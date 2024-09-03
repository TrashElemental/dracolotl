package net.trashelemental.infested.entity.ai;

import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;
import net.trashelemental.infested.entity.custom.BrilliantBeetleEntity;

@EventBusSubscriber
public class BrilliantBeetleEvents {

    @SubscribeEvent
    public static void onLivingDamage(LivingDamageEvent.Pre event) {

        if (event.getEntity() instanceof Player player) {
            if (event.getSource().is(DamageTypes.FALL)) {
                Entity vehicle = player.getVehicle();
                if (vehicle instanceof BrilliantBeetleEntity) {
                    event.setNewDamage(0);
                }
            }
        }
    }

}
