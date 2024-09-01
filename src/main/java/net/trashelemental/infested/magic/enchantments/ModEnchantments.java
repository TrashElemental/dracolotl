package net.trashelemental.infested.magic.enchantments;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.enchantment.Enchantment;
import net.trashelemental.infested.InfestedSwarmsAndSpiders;

public class ModEnchantments {

    public static ResourceKey<Enchantment> INFESTED = key("infested");
    public static ResourceKey<Enchantment> PARASITOID = key("parasitoid");
    public static ResourceKey<Enchantment> ENSNARING_STRIKE = key("ensnaring_strike");


    private static ResourceKey<Enchantment> key(String p_345314_) {
        return ResourceKey.create(Registries.ENCHANTMENT, InfestedSwarmsAndSpiders.prefix(p_345314_));
    }

}

