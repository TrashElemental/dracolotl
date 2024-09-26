package net.trashelemental.dracolotl.entity.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.FlyingMoveControl;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.OwnerHurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.OwnerHurtTargetGoal;
import net.minecraft.world.entity.ai.navigation.FlyingPathNavigation;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.Bee;
import net.minecraft.world.entity.animal.axolotl.Axolotl;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.fluids.FluidType;
import net.trashelemental.dracolotl.dracolotl;
import net.trashelemental.dracolotl.item.ModItems;
import net.trashelemental.dracolotl.util.ModBucketableInterface;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animatable.instance.SingletonAnimatableInstanceCache;
import software.bernie.geckolib.animation.*;
import software.bernie.geckolib.animation.AnimationState;

import java.util.List;
import java.util.Objects;

@SuppressWarnings("Deprecated")
public class DracolotlEntity extends TamableAnimal implements GeoEntity, ModBucketableInterface {
    public DracolotlEntity(EntityType<? extends TamableAnimal> entityType, Level level) {
        super(entityType, level);
        this.moveControl = new FlyingMoveControl(this, 20, true);
    }

    private static final EntityDataAccessor<Boolean> DATA_PLAYING_DEAD;
    private static final EntityDataAccessor<Boolean> FROM_BUCKET;

    protected void defineSynchedData(SynchedEntityData.@NotNull Builder builder) {
        super.defineSynchedData(builder);
        builder.define(DATA_PLAYING_DEAD, false);
        builder.define(FROM_BUCKET, false);
    }

    static {
        DATA_PLAYING_DEAD = SynchedEntityData.defineId(DracolotlEntity.class, EntityDataSerializers.BOOLEAN);
        FROM_BUCKET = SynchedEntityData.defineId(DracolotlEntity.class, EntityDataSerializers.BOOLEAN);
    }



    @Override
    protected void registerGoals() {
        super.registerGoals();
        {


            this.goalSelector.addGoal(1, new OwnerHurtByTargetGoal(this) {
                        @Override
                        public boolean canUse() {
                            return super.canUse() && follow(DracolotlEntity.this) && !playingDead(DracolotlEntity.this);
                        }
                    });
            this.targetSelector.addGoal(2, new OwnerHurtTargetGoal(this) {
                        @Override
                        public boolean canUse() {
                            return super.canUse() && follow(DracolotlEntity.this) && !playingDead(DracolotlEntity.this);
                        }
                    });
            this.goalSelector.addGoal(3, new MeleeAttackGoal(this, 1.2, false) {
            @Override
            public boolean canUse() {
                return super.canUse() && !playingDead(DracolotlEntity.this);
            }
        });
            this.targetSelector.addGoal(4, new HurtByTargetGoal(this) {
                        @Override
                        public boolean canUse() {
                            return super.canUse() && !playingDead(DracolotlEntity.this);
                        }
                    });
            this.goalSelector.addGoal(5, new FollowOwnerGoal(this, 1, 10, 2) {
                @Override
                public boolean canUse() {
                    return super.canUse() && follow(DracolotlEntity.this) && !playingDead(DracolotlEntity.this);
                }
            });

            this.goalSelector.addGoal(7, new TemptGoal(this, 1, Ingredient.of(Items.ENDER_EYE), false) {
                @Override
                public boolean canUse() {
                    return super.canUse() && wander(DracolotlEntity.this) && !playingDead(DracolotlEntity.this);
                }
            });
            this.goalSelector.addGoal(8, new RandomStrollGoal(this, 1) {
                @Override
                public boolean canUse() {
                    return super.canUse() && wander(DracolotlEntity.this) && !playingDead(DracolotlEntity.this);
                }
            });
            this.goalSelector.addGoal(9, new LookAtPlayerGoal(this, Player.class, (float) 6) {
                @Override
                public boolean canUse() {
                    return super.canUse() && !playingDead(DracolotlEntity.this);
                }
            });
            this.goalSelector.addGoal(10, new RandomLookAroundGoal(this) {
            @Override
            public boolean canUse() {
                return super.canUse() && !playingDead(DracolotlEntity.this);
            }
        });



        }
    }



    public static boolean follow(DracolotlEntity entity) {
        if (entity == null)
            return false;
        return entity.isFollowing();
    }

    public static boolean wander(DracolotlEntity entity) {
        if (entity == null)
            return false;
        return entity.isWandering();
    }

    public static boolean playingDead(DracolotlEntity entity) {
        if (entity == null)
            return false;
        return entity.isPlayingDead();
    }


    public static AttributeSupplier.Builder createAttributes() {
        return Animal.createLivingAttributes()

                .add(Attributes.MAX_HEALTH, 40)
                .add(Attributes.MOVEMENT_SPEED, 0.3)
                .add(Attributes.ATTACK_DAMAGE, 5)
                .add(Attributes.ARMOR, 4)
                .add(Attributes.FOLLOW_RANGE, 16)
                .add(Attributes.KNOCKBACK_RESISTANCE, 0.3)
                .add(Attributes.ATTACK_KNOCKBACK, 0)
                .add(Attributes.FLYING_SPEED, 0.6);

    }


    //Flying
    protected PathNavigation createNavigation(Level p_level) {
        FlyingPathNavigation flyingpathnavigation = new FlyingPathNavigation(this, p_level) {
            public boolean isStableDestination(BlockPos p_27947_) {
                return !this.level.getBlockState(p_27947_.below()).isAir();
            }
        };
        flyingpathnavigation.setCanOpenDoors(false);
        flyingpathnavigation.setCanFloat(false);
        flyingpathnavigation.setCanPassDoors(true);
        return flyingpathnavigation;
    }



    //Slower movement on ground
    private static final double GROUND_SPEED = 0.15;
    private static final double AIR_SPEED = 0.6;

    @Override
    public void travel(Vec3 travelVector) {
        if (this.isFlying() || this.isInLiquid() || this.isInLava()) {
            Objects.requireNonNull(this.getAttribute(Attributes.MOVEMENT_SPEED)).setBaseValue(AIR_SPEED);
        } else {
            Objects.requireNonNull(this.getAttribute(Attributes.MOVEMENT_SPEED)).setBaseValue(GROUND_SPEED);
        }

        super.travel(travelVector);
    }



    //Bucket Behavior
    @Override
    public ItemStack getBucketItemStack() {
        return new ItemStack(ModItems.BUCKET_OF_DRACOLOTL.get());
    }

    @Override
    public SoundEvent getPickupSound() {
        return SoundEvents.BUCKET_FILL_AXOLOTL;
    }

    public boolean requiresCustomPersistence() {
        return super.requiresCustomPersistence() || this.fromBucket();
    }

    public boolean removeWhenFarAway(double distanceToClosestPlayer) {
        return !this.fromBucket() && !this.hasCustomName() && !this.isTame();
    }

    public boolean fromBucket() {
        return (Boolean)this.entityData.get(FROM_BUCKET);
    }

    public void setFromBucket(boolean fromBucket) {
        this.entityData.set(FROM_BUCKET, fromBucket);
    }

    public void saveToBucketTag(ItemStack stack) {
        ModBucketableInterface.saveDefaultDataToBucketTag(this, stack);
        CustomData.update(DataComponents.BUCKET_ENTITY_DATA, stack, (data) -> {
            // Save tame status
            if (this.isTame()) {
                data.putBoolean("IsTame", true);  // Save tamed status

                // Save owner UUID if tamed
                if (this.getOwnerUUID() != null) {
                    data.putUUID("OwnerUUID", this.getOwnerUUID());
                }
            }
        });
    }

    public void loadFromBucketTag(CompoundTag tag) {
        ModBucketableInterface.loadDefaultDataFromBucketTag(this, tag);

        if (tag.contains("IsTame")) {
            this.setTame(tag.getBoolean("IsTame"), false);
        }

        if (tag.contains("OwnerUUID")) {
            this.setOwnerUUID(tag.getUUID("OwnerUUID"));
        }

        if (this.isTame()) {
            this.BEHAVIOR = "FOLLOW";
        }

    }



    //Play Dead Behavior
    public void setPlayingDead(boolean playingDead) {
        this.entityData.set(DATA_PLAYING_DEAD, playingDead);
    }

    public boolean isPlayingDead() {
        return (Boolean)this.entityData.get(DATA_PLAYING_DEAD);
    }

    public boolean canBeSeenAsEnemy() {
        return !this.isPlayingDead() && super.canBeSeenAsEnemy();
    }

    public boolean canAttack(LivingEntity livingentity, TargetingConditions condition) {
        return !this.isPlayingDead();
    }

    @Override
    public boolean hurt(DamageSource source, float amount) {

        //Damage Immunities
        if (source.is(DamageTypes.FALL) ||
                source.is(DamageTypes.CAMPFIRE) ||
                source.is(DamageTypes.IN_FIRE) ||
                source.is(DamageTypes.ON_FIRE) ||
                source.is(DamageTypes.FIREBALL) ||
                source.is(DamageTypes.UNATTRIBUTED_FIREBALL) ||
                source.is(DamageTypes.LAVA) ||
                source.is(DamageTypes.DRAGON_BREATH)
        ) return false;

        if (!this.level().isClientSide && this.getHealth() - amount <= 8 && !this.isPlayingDead()) {
            this.setPlayingDead(true);
            this.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 200, 3));

            dracolotl.queueServerWork(200, () -> {
                if (this.isAlive()) {
                    this.setPlayingDead(false);
                    this.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 100, 1));

                    if (this.isTame() && this.getOwner() instanceof Player owner) {
                        owner.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 100, 1));
                    }
                }
            });

            return true;
        }
        return super.hurt(source, amount);
    }

    @Override
    public void setTarget(@Nullable LivingEntity target) {
        if (this.isPlayingDead()) {
            target = null;
        }
        super.setTarget(target);
    }

    @Override
    public void tick() {
        super.tick();

        if (this.isPlayingDead()) {
            List<Mob> nearbyEntities = this.level().getEntitiesOfClass(Mob.class, this.getBoundingBox().inflate(10));
            for (Mob entity : nearbyEntities) {
                if (entity.getTarget() == this) {
                    entity.setTarget(null);
                }
            }
        }

        if (this.isPlayingDead() || !this.isWandering() && !this.isFollowing()) {
            this.setDeltaMovement(this.getDeltaMovement().add(0, -0.5, 0));
        }

    }



    //Swimming




    //Sound Events
    @Override
    public SoundEvent getAmbientSound() {
        return SoundEvents.AXOLOTL_IDLE_AIR;
    }

    @Override
    public SoundEvent getHurtSound(DamageSource ds) {
        return SoundEvents.AXOLOTL_HURT;
    }

    @Override
    public SoundEvent getDeathSound() {
        return SoundEvents.AXOLOTL_DEATH;
    }



    //Mob stuff
    @Override
    public boolean isFood(ItemStack itemStack) {
        return false;
    }

    @Nullable
    @Override
    public AgeableMob getBreedOffspring(ServerLevel serverLevel, AgeableMob ageableMob) {
        return null;
    }



    //On right click behavior
    @Override
    public InteractionResult mobInteract(Player pPlayer, InteractionHand pHand) {
        ItemStack itemstack = pPlayer.getItemInHand(pHand);

        //Tries to tame if the item is an Eye of Ender and it isn't tame
        if (itemstack.getItem() == Items.ENDER_EYE) {
            this.usePlayerItem(pPlayer, pHand, itemstack);
            if (!this.isTame()) {
                if (this.random.nextInt(5) == 0) {
                    this.tame(pPlayer);
                    this.BEHAVIOR = "FOLLOW";
                    this.level().broadcastEntityEvent(this, (byte) 7);
                } else {
                    this.level().broadcastEntityEvent(this, (byte) 6);
                }
                this.setPersistenceRequired();
                return InteractionResult.SUCCESS;
            }
        }

        //Gives Dragon's Breath if it's owned by the player who interacted with it and the item is a bottle
       else if (itemstack.getItem() == Items.GLASS_BOTTLE && this.isOwnedBy(pPlayer)) {

            if (!pPlayer.isCreative()) {
                itemstack.shrink(1);
            }

            ItemStack dragonsBreath = new ItemStack(Items.DRAGON_BREATH);

            if (!pPlayer.getInventory().add(dragonsBreath)) {
                pPlayer.drop(dragonsBreath, false);
            }

            this.level().playSound(null, this.getX(), this.getY(), this.getZ(),
                    SoundEvents.BOTTLE_FILL_DRAGONBREATH, SoundSource.NEUTRAL, 0.5F, 3.0F);

            return InteractionResult.SUCCESS;

        }

        //Has a 3% chance to drop a Dragon Egg when fed a Chorus Flower
        else if (itemstack.getItem() == Items.CHORUS_FLOWER) {

                if (this.level().random.nextInt(100) < 3) {

                    ItemStack dragonEgg = new ItemStack(Items.DRAGON_EGG);
                    this.spawnAtLocation(dragonEgg);

                }

                this.level().playSound(null, this.getX(), this.getY(), this.getZ(),
                        SoundEvents.GENERIC_EAT, SoundSource.NEUTRAL, 0.5F, 1.0F);

                for (int i = 0; i < 5; i++) {
                        this.level().addParticle(ParticleTypes.SMOKE,
                            this.getX() + (this.level().random.nextDouble() - 0.5D),
                            this.getY() + 0.5D,
                            this.getZ() + (this.level().random.nextDouble() - 0.5D),
                          0, 0, 0);
                }

                if (!pPlayer.isCreative()) {
                    itemstack.shrink(1);
                }

                return InteractionResult.SUCCESS;

        }

        //Bucketing if it isn't tame or if the player who interacted with it owns it
        else if (itemstack.getItem() == Items.BUCKET) {
            if (!this.isTame() || this.isOwnedBy(pPlayer)) {
                ModBucketableInterface.bucketMobPickup(pPlayer, pHand, this);
            }
        }

        //Cycles behavior if it's owned by the player who interacted with it
        else {
            InteractionResult retval = super.mobInteract(pPlayer, pHand);
            if (retval == InteractionResult.SUCCESS || retval == InteractionResult.CONSUME) {
                this.setPersistenceRequired();
            }

            if (this.isOwnedBy(pPlayer)) {
                cycleBehavior(pPlayer);
                return InteractionResult.SUCCESS;
            }

            return retval;
        }

        return InteractionResult.PASS;
    }



    //Behavior
    private String BEHAVIOR = "WANDER";

    private void setBehaviorInPersistentData(String behavior) {
        CompoundTag tag = this.getPersistentData();
        tag.putString("Behavior", behavior);
    }

    public boolean isFollowing() {
        return this.BEHAVIOR.equals("FOLLOW");
    }

    public boolean isWandering() {
        return this.BEHAVIOR.equals("WANDER");
    }

    private void cycleBehavior(Player pPlayer) {
        switch (this.BEHAVIOR) {
            case "FOLLOW":
                this.BEHAVIOR = "WANDER";
                pPlayer.displayClientMessage(Component.literal("Dracolotl will wander"), true);
                break;
            case "STAY":
                this.BEHAVIOR = "FOLLOW";
                pPlayer.displayClientMessage(Component.literal("Dracolotl will follow"), true);
                break;
            case "WANDER":
                this.BEHAVIOR = "STAY";
                pPlayer.displayClientMessage(Component.literal("Dracolotl will stay"), true);
                break;
        }
        this.setBehaviorInPersistentData(this.BEHAVIOR);
    }



    //Sets skin to Red Dragon if it has the name 'Hellkite'
    //Dark Souls 1 reference plus a reference to the scrapped Red Dragon mob
    public boolean ShouldUseRedDragonSkin() {
        return this.hasCustomName() && "Hellkite".equals(this.getCustomName().getString());
    }



    //NBT Tags
    @Override
    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.putString("Behavior", this.BEHAVIOR);
        compound.putBoolean("FromBucket", this.fromBucket());
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        if (compound.contains("Behavior")) {
            this.BEHAVIOR = compound.getString("Behavior");
            this.setFromBucket(compound.getBoolean("FromBucket"));
        }
    }



    //GeckoLib
    public boolean isFlying() {
        return !this.onGround() && !this.isPlayingDead();
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController<>(this, "controller", 4, this::predicate));
    }

    private PlayState predicate(AnimationState<DracolotlEntity> dracolotlEntityAnimationState) {

        //Playing Dead
        if (this.isPlayingDead()) {
            dracolotlEntityAnimationState.getController().setAnimation(RawAnimation.begin().then("PLAY_DEAD", Animation.LoopType.LOOP));
            return PlayState.CONTINUE;
        }

        //Air
        if (this.isFlying() && !this.isNoAi()) {
            if (dracolotlEntityAnimationState.isMoving()) {
                dracolotlEntityAnimationState.getController().setAnimation(RawAnimation.begin().then("MOVE_AIR", Animation.LoopType.LOOP));
            } else {
                dracolotlEntityAnimationState.getController().setAnimation(RawAnimation.begin().then("IDLE_AIR", Animation.LoopType.LOOP));
            }
            return PlayState.CONTINUE;
        }

        //Ground
        if(dracolotlEntityAnimationState.isMoving()) {
            dracolotlEntityAnimationState.getController().setAnimation(RawAnimation.begin().then("MOVE_GROUND", Animation.LoopType.LOOP));
            return PlayState.CONTINUE;
        }

        dracolotlEntityAnimationState.getController().setAnimation(RawAnimation.begin().then("IDLE_GROUND", Animation.LoopType.LOOP));
        return PlayState.CONTINUE;
    }

    private AnimatableInstanceCache cache = new SingletonAnimatableInstanceCache(this);

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }



}
