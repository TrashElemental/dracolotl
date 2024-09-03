package net.trashelemental.infested.entity.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.monster.ZombifiedPiglin;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.trashelemental.infested.entity.ModEntities;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;

public class GrubEntity extends Animal {


    public GrubEntity(EntityType<? extends Animal> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;

    @Override
    public void tick() {
        super.tick();

        if(this.level().isClientSide) {
            setupAnimationStates();
        }
    }

    private void setupAnimationStates() {
        if (!idleAnimationState.isStarted()) {
            this.idleAnimationState.start(this.tickCount);
        }
    }

    @Override
    protected void updateWalkAnimation(float pPartialTick) {
        float f;
        if(this.getPose() == Pose.STANDING) {
            f = Math.min(pPartialTick * 6f, 1f);
        } else {
            f = 0f;
        }
        this.walkAnimation.update(f, 0.2f);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals(); {

            this.goalSelector.addGoal(0, new PanicGoal(this, 1));
            this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1, false));
            this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, ZombifiedPiglin.class, false, false));
            this.goalSelector.addGoal(3, new LeapAtTargetGoal(this, (float) 0.5f));

            this.goalSelector.addGoal(4, new FloatGoal(this));
            this.goalSelector.addGoal(5, new TemptGoal(this, 1, Ingredient.of(Items.ROTTEN_FLESH), false));
            this.goalSelector.addGoal(6, new RandomStrollGoal(this, 1));
            this.goalSelector.addGoal(7, new LookAtPlayerGoal(this, Player.class, (float) 6));
            this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));

        }
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Animal.createLivingAttributes()

                .add(Attributes.MAX_HEALTH, 4)
                .add(Attributes.MOVEMENT_SPEED, 0.2)
                .add(Attributes.ATTACK_DAMAGE, 1)
                .add(Attributes.ARMOR, 0)
                .add(Attributes.FOLLOW_RANGE, 26)
                .add(Attributes.ATTACK_KNOCKBACK, 0);

    }

    @Override
    public boolean isFood(ItemStack pStack) {
        return pStack.is(Items.ROTTEN_FLESH);
    }

    //Sound Events
    @Override
    public SoundEvent getAmbientSound() {
        return SoundEvents.COD_AMBIENT;
    }
    @Override
    public void playStepSound(BlockPos pos, BlockState blockIn) {
        this.playSound(SoundEvents.SILVERFISH_STEP, 0.15f, 1);
    }
    @Override
    public SoundEvent getHurtSound(DamageSource ds) {
        return SoundEvents.COD_HURT;
    }
    @Override
    public SoundEvent getDeathSound() {
        return SoundEvents.COD_DEATH;
    }

    @Nullable
    @Override
    public AgeableMob getBreedOffspring(ServerLevel serverLevel, AgeableMob ageableMob) {
        return null;
    }

    //Spawning

//    public static boolean canSpawn(EntityType<GrubEntity> entityType, LevelAccessor level, MobSpawnType spawnType, BlockPos position, RandomSource random) {
//        BlockState blockBelow = level.getBlockState(position.below());
//        return !blockBelow.is(Blocks.NETHER_WART_BLOCK)
//                && !blockBelow.is(Blocks.SHROOMLIGHT)
//                && !blockBelow.is(Blocks.LAVA)
//                && !blockBelow.is(Blocks.MAGMA_BLOCK)
//                && !blockBelow.is(Blocks.GLOWSTONE)
//                && !blockBelow.is(Blocks.AIR)
//                && !level.getBlockState(position.below()).getFluidState().is(FluidTags.LAVA)
//                && !level.getBlockState(position.below()).is(Blocks.FIRE);
//    }

    //Custom Behaviors

    //If the Grub is fed Rotten Flesh, it has a 10% chance to grow into a Crimson Beetle.
    //If it's fed Cocoa Beans, a Brilliant Beetle.
    @Override
    public InteractionResult mobInteract(Player pPlayer, InteractionHand pHand) {
        ItemStack itemStack = pPlayer.getItemInHand(pHand);

        if (itemStack.is(Items.ROTTEN_FLESH)) {
            if (!pPlayer.isCreative()) { itemStack.shrink(1); }
            this.playSound(SoundEvents.GENERIC_EAT);
            for (int i = 0; i < 5; ++i) {
                double d0 = this.random.nextGaussian() * 0.02D;
                double d1 = this.random.nextGaussian() * 0.02D;
                double d2 = this.random.nextGaussian() * 0.02D;
                this.level().addParticle(ParticleTypes.HAPPY_VILLAGER,
                        this.getX() + (double)(this.random.nextFloat() * this.getBbWidth() * 2.0F) - (double)this.getBbWidth(),
                        this.getY() + 0.5D + (double)(this.random.nextFloat() * this.getBbHeight()),
                        this.getZ() + (double)(this.random.nextFloat() * this.getBbWidth() * 2.0F) - (double)this.getBbWidth(),
                        d0, d1, d2);
            }

            if (Math.random() >= 0.9) {
                if (!this.level().isClientSide()) {
                    this.discard();
                }
                if (this.level() instanceof ServerLevel _level) {
                    Entity entityToSpawn = ModEntities.CRIMSON_BEETLE.get().spawn(_level, BlockPos.containing(this.getX(), this.getY(), this.getZ()), MobSpawnType.MOB_SUMMONED);
                    if (entityToSpawn != null) {
                        entityToSpawn.setYRot(this.level().getRandom().nextFloat() * 360F);
                    }
                }
            }
            return InteractionResult.SUCCESS;
        } else if (itemStack.is(Items.COCOA_BEANS)) {
            if (!pPlayer.isCreative()) { itemStack.shrink(1); }
            this.playSound(SoundEvents.GENERIC_EAT);
            for (int i = 0; i < 5; ++i) {
                double d0 = this.random.nextGaussian() * 0.02D;
                double d1 = this.random.nextGaussian() * 0.02D;
                double d2 = this.random.nextGaussian() * 0.02D;
                this.level().addParticle(ParticleTypes.HAPPY_VILLAGER,
                        this.getX() + (double)(this.random.nextFloat() * this.getBbWidth() * 2.0F) - (double)this.getBbWidth(),
                        this.getY() + 0.5D + (double)(this.random.nextFloat() * this.getBbHeight()),
                        this.getZ() + (double)(this.random.nextFloat() * this.getBbWidth() * 2.0F) - (double)this.getBbWidth(),
                        d0, d1, d2);
            }

            if (Math.random() >= 0.9) {
                if (!this.level().isClientSide()) {
                    this.discard();
                }
                if (this.level() instanceof ServerLevel _level) {
                    Entity entityToSpawn = ModEntities.BRILLIANT_BEETLE.get().spawn(_level, BlockPos.containing(this.getX(), this.getY(), this.getZ()), MobSpawnType.MOB_SUMMONED);
                    if (entityToSpawn != null) {
                        entityToSpawn.setYRot(this.level().getRandom().nextFloat() * 360F);
                    }
                }
            }
            return InteractionResult.SUCCESS;
        }
        return super.mobInteract(pPlayer, pHand);
    }

    //Spawns 2-3 Grubs when breeding Crimson Beetles, rather than 1. Also sets the offspring to be an adult because
    //it messes with the animations if it's a baby.
    @Override
    public void onAddedToLevel() {
        super.onAddedToLevel();

        if (this.isBaby()) {
            this.setAge(0);

            int numberOfEntities = this.random.nextInt(2) + 1;
            for (int i = 0; i < numberOfEntities; i++) {
                GrubEntity newGrub = ModEntities.GRUB.get().create(this.level());
                if (newGrub != null) {
                    newGrub.setPos(this.getX() + this.random.nextDouble() - 0.5,
                            this.getY(),
                            this.getZ() + this.random.nextDouble() - 0.5);
                    this.level().addFreshEntity(newGrub);
                }
            }
        }
    }


}
