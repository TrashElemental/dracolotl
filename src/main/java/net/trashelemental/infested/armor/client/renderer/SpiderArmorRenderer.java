package net.trashelemental.infested.armor.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.trashelemental.infested.armor.client.models.ChitinArmorModel;
import net.trashelemental.infested.armor.client.models.SpiderArmorModel;
import net.trashelemental.infested.armor.custom.ChitinArmorItem;
import net.trashelemental.infested.armor.custom.SpiderArmorItem;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class SpiderArmorRenderer extends GeoArmorRenderer<SpiderArmorItem> {

    public SpiderArmorRenderer() {
        super(new SpiderArmorModel());
    }

    @Override
    public ResourceLocation getTextureLocation(SpiderArmorItem armorItem) {
        return ResourceLocation.fromNamespaceAndPath("infested_swarms_spiders","textures/models/armor/spider_armor.png");
    }
}