package net.trashelemental.dracolotl.util.event;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.boss.enderdragon.EndCrystal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.trashelemental.dracolotl.dracolotl;
import net.trashelemental.dracolotl.entity.ModEntities;
import net.trashelemental.dracolotl.entity.custom.DracolotlEntity;

import java.util.List;

@EventBusSubscriber
public class SummonDracolotlEvent {


    @SubscribeEvent
    public static void onRightClickBlock(PlayerInteractEvent.RightClickBlock event) {
        Level level = event.getLevel();
        Player player = event.getEntity();
        BlockPos pos = event.getPos();
        BlockState blockState = level.getBlockState(pos);

        if (blockState.is(Blocks.DRAGON_EGG)) {

            if (isEndCrystalNearby(level, pos.offset(-2, -2, 0)) &&
                    isEndCrystalNearby(level, pos.offset(2, -2, 0)) &&
                    isEndCrystalNearby(level, pos.offset(0, -2, -2)) &&
                    isEndCrystalNearby(level, pos.offset(0, -2, 2))) {

                event.setCanceled(true);

                setCrystalBeams(level, pos);

                level.playSound(null, pos, SoundEvents.END_PORTAL_SPAWN, SoundSource.BLOCKS, 1.0F, 1.0F);
                level.removeBlock(pos, false);

                dracolotl.queueServerWork(40, () -> {
                    removeEndCrystals(level, pos.offset(-2, -2, 0));
                    level.playSound(null, pos.offset(-2, -2, 0),
                            SoundEvents.DRAGON_FIREBALL_EXPLODE, SoundSource.BLOCKS, 1.0F, 1.0F);

                    dracolotl.queueServerWork(20, () -> {
                        removeEndCrystals(level, pos.offset(2, -2, 0));
                        level.playSound(null, pos.offset(2, -2, 0),
                                SoundEvents.DRAGON_FIREBALL_EXPLODE, SoundSource.BLOCKS, 1.0F, 1.0F);

                        dracolotl.queueServerWork(20, () -> {
                            removeEndCrystals(level, pos.offset(0, -2, -2));
                            level.playSound(null, pos.offset(0, -2, -2),
                                    SoundEvents.DRAGON_FIREBALL_EXPLODE, SoundSource.BLOCKS, 1.0F, 1.0F);

                            dracolotl.queueServerWork(20, () -> {
                                removeEndCrystals(level, pos.offset(0, -2, 2));
                                level.playSound(null, pos, SoundEvents.ENDER_DRAGON_AMBIENT, SoundSource.BLOCKS, 1.0F, 2.0F);

                                for (int i = 0; i < 20; i++) {
                                    double xOffset = level.random.nextGaussian();
                                    double yOffset = level.random.nextGaussian();
                                    double zOffset = level.random.nextGaussian();
                                    level.addParticle(ParticleTypes.DRAGON_BREATH,
                                            pos.getX() + xOffset,
                                            pos.getY() + yOffset + 2,
                                            pos.getZ() + zOffset,
                                            0, 0, 0);
                                }

                                spawnTamedDracolotl(level, pos, player);
                            });
                        });
                    });
                });

            }
        }
    }

    private static boolean isEndCrystalNearby(Level level, BlockPos pos) {
        return !level.getEntitiesOfClass(EndCrystal.class, new AABB(pos)).isEmpty();
    }

    private static void removeEndCrystals(Level level, BlockPos pos) {
        List<EndCrystal> crystals = level.getEntitiesOfClass(EndCrystal.class, new AABB(pos));
        for (EndCrystal crystal : crystals) {

            for (int i = 0; i < 10; i++) {
                double xOffset = level.random.nextGaussian() * 0.2;
                double yOffset = level.random.nextGaussian() * 0.2;
                double zOffset = level.random.nextGaussian() * 0.2;
                level.addParticle(ParticleTypes.EXPLOSION,
                        crystal.getX() + xOffset,
                        crystal.getY() + yOffset,
                        crystal.getZ() + zOffset,
                        0, 0, 0);
            }

            crystal.discard();
        }
    }

    private static void spawnTamedDracolotl(Level level, BlockPos pos, Player player) {
        if (!level.isClientSide()) {
            DracolotlEntity dracolotl = ModEntities.DRACOLOTL.get().create(level);
            if (dracolotl != null) {
                dracolotl.moveTo(pos.getX(), pos.getY() + 1, pos.getZ(), 0, 0);
                dracolotl.setTame(true, false);
                dracolotl.setOwnerUUID(player.getUUID());
                dracolotl.BEHAVIOR = "FOLLOW";
                level.addFreshEntity(dracolotl);
            }
        }
    }

    private static void setCrystalBeams(Level level, BlockPos eggPos) {
        setCrystalBeamTarget(level, eggPos.offset(-2, -2, 0), eggPos);
        setCrystalBeamTarget(level, eggPos.offset(2, -2, 0), eggPos);
        setCrystalBeamTarget(level, eggPos.offset(0, -2, -2), eggPos);
        setCrystalBeamTarget(level, eggPos.offset(0, -2, 2), eggPos);
    }

    private static void setCrystalBeamTarget(Level level, BlockPos crystalPos, BlockPos eggPos) {
        List<EndCrystal> crystals = level.getEntitiesOfClass(EndCrystal.class, new AABB(crystalPos).inflate(1));
        for (EndCrystal crystal : crystals) {
            crystal.setBeamTarget(eggPos);
        }
    }



}