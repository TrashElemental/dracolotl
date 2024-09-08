package net.trashelemental.infested.armor.client.models;

import net.minecraft.resources.ResourceLocation;
import net.trashelemental.infested.armor.custom.ChitinArmorItem;
import net.trashelemental.infested.armor.custom.SpiderArmorItem;
import software.bernie.geckolib.model.GeoModel;

public class SpiderArmorModel extends GeoModel<SpiderArmorItem> {

    @Override
    public ResourceLocation getModelResource(SpiderArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath("infested_swarms_spiders","geo/models/armor/spider_armor.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(SpiderArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath("infested_swarms_spiders","textures/models/armor/spider_armor.png");
    }

    @Override
    public ResourceLocation getAnimationResource(SpiderArmorItem animatable) {
        return null;
    }


}