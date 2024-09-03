package net.trashelemental.infested.entity.ai;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;

import javax.annotation.Nullable;
import java.util.function.Predicate;

public class MantisAttackGoal<T extends LivingEntity> extends NearestAttackableTargetGoal<T> {
    private final TamableAnimal tamableMob;

    public MantisAttackGoal(TamableAnimal pTamableMob, Class<T> pTargetType, boolean pMustSee, @Nullable Predicate<LivingEntity> pTargetPredicate) {
        super(pTamableMob, pTargetType, 10, pMustSee, false, pTargetPredicate);
        this.tamableMob = pTamableMob;
    }

    @Override
    public boolean canUse() {
        if (super.canUse()) {

            if (this.tamableMob.isTame() && this.target instanceof TamableAnimal targetTamable && targetTamable.isTame()) {
                return false;
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean canContinueToUse() {
        assert this.target != null;
        return this.targetConditions.test(this.mob, this.target);
    }
}
