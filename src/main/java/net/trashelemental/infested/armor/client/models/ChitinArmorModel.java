package net.trashelemental.infested.armor.client.models;

import net.minecraft.resources.ResourceLocation;
import net.trashelemental.infested.armor.custom.ChitinArmorItem;
import software.bernie.geckolib.model.GeoModel;

public class ChitinArmorModel extends GeoModel<ChitinArmorItem> {

    @Override
    public ResourceLocation getModelResource(ChitinArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath("infested_swarms_spiders","geo/models/armor/chitin_armor.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(ChitinArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath("infested_swarms_spiders","textures/models/armor/chitin_armor.png");
    }

    @Override
    public ResourceLocation getAnimationResource(ChitinArmorItem animatable) {
        return null;
    }


}