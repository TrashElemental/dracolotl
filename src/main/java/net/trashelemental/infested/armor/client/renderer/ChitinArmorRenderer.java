package net.trashelemental.infested.armor.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ArmorItem;
import net.trashelemental.infested.armor.client.models.ChitinArmorModel;
import net.trashelemental.infested.armor.custom.ChitinArmorItem;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class ChitinArmorRenderer extends GeoArmorRenderer<ChitinArmorItem> {

    public ChitinArmorRenderer() {
        super(new ChitinArmorModel());
    }

    @Override
    public ResourceLocation getTextureLocation(ChitinArmorItem armorItem) {
        return ResourceLocation.fromNamespaceAndPath("infested_swarms_spiders","textures/models/armor/chitin_armor.png");
    }
}