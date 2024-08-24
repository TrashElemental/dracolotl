package net.trashelemental.infested.magic.enchantments;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.enchantment.Enchantment;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.trashelemental.infested.InfestedSwarmsAndSpiders;

public class ModEnchantments {
    public static final DeferredRegister<Enchantment> REGISTRY = DeferredRegister.create(Registries.ENCHANTMENT, InfestedSwarmsAndSpiders.MOD_ID);



//    public static final DeferredHolder<Enchantment, Enchantment> INFESTED = REGISTRY.register("infested", InfestedEnchantment::new);
//    public static final DeferredHolder<Enchantment, Enchantment> PARASITOID = REGISTRY.register("parasitoid", ParasitoidEnchantment::new);
 //   public static final DeferredHolder<Enchantment, Enchantment> ENSNARING_STRIKE = REGISTRY.register("ensnaring_strike", EnsnaringStrikeEnchantment::new);



    public static void register(IEventBus eventBus) {
        REGISTRY.register(eventBus);
    }
}
