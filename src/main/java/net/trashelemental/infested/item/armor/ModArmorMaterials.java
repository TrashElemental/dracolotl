package net.trashelemental.infested.item.armor;


import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.trashelemental.infested.InfestedSwarmsAndSpiders;
import net.trashelemental.infested.item.ModItems;

import java.util.EnumMap;
import java.util.List;
import java.util.function.Supplier;

public class ModArmorMaterials {

    public static final DeferredRegister<ArmorMaterial> MATERIALS = DeferredRegister.create(BuiltInRegistries.ARMOR_MATERIAL, InfestedSwarmsAndSpiders.MOD_ID);

    public static final Holder<ArmorMaterial> CHITIN = MATERIALS.register("chitin", () -> createArmorMaterial(
            new EnumMap<>(ArmorItem.Type.class) {{
                put(ArmorItem.Type.BOOTS, 2);
                put(ArmorItem.Type.LEGGINGS, 5);
                put(ArmorItem.Type.CHESTPLATE, 6);
                put(ArmorItem.Type.HELMET, 2);
            }},
            15,                             //Enchantment value
            SoundEvents.ARMOR_EQUIP_TURTLE,                //Equip sound
            1.0f,                                          //Toughness
            0.1f,                                          //Knockback resistance
            () -> Ingredient.of(ModItems.CHITIN),          //Repair ingredient
            List.of(new ArmorMaterial.Layer(InfestedSwarmsAndSpiders.prefix("chitin"), "", false)) //Armor texture layers
    ));

    public static final Holder<ArmorMaterial> SPIDER = MATERIALS.register("spider", () -> createArmorMaterial(
            new EnumMap<>(ArmorItem.Type.class) {{
                put(ArmorItem.Type.BOOTS, 2);
                put(ArmorItem.Type.LEGGINGS, 5);
                put(ArmorItem.Type.CHESTPLATE, 6);
                put(ArmorItem.Type.HELMET, 2);
            }},
            15,                             //Enchantment value
            SoundEvents.ARMOR_EQUIP_WOLF,                  //Equip sound
            0.0f,                                          //Toughness
            0.0f,                                          //Knockback resistance
            () -> Ingredient.of(Items.COBWEB),             //Repair ingredient
            List.of(new ArmorMaterial.Layer(InfestedSwarmsAndSpiders.prefix("spider"), "", false)) //Armor texture layers
    ));




    private static ArmorMaterial createArmorMaterial(
            EnumMap<ArmorItem.Type, Integer> defense,
            int enchantmentValue,
            Holder<SoundEvent> equipSound,
            float toughness,
            float knockbackResistance,
            Supplier<Ingredient> repairIngredient,
            List<ArmorMaterial.Layer> layers
    ){
        return new ArmorMaterial(defense, enchantmentValue, equipSound, repairIngredient, layers, toughness, knockbackResistance);
    }

    public static void register(IEventBus eventBus) {
        MATERIALS.register(eventBus);
    }

}


