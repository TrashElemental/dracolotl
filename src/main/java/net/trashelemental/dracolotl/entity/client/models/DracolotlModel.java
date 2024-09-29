package net.trashelemental.dracolotl.entity.client.models;

import net.minecraft.resources.ResourceLocation;
import net.trashelemental.dracolotl.entity.custom.DracolotlEntity;
import software.bernie.geckolib.model.GeoModel;

public class DracolotlModel extends GeoModel<DracolotlEntity> {
    @Override
    public ResourceLocation getModelResource(DracolotlEntity dracolotl) {
        return new ResourceLocation("dracolotl", "geo/models/dracolotl.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(DracolotlEntity dracolotl) {

        if (dracolotl.ShouldUseRedDragonSkin()) {
            return new ResourceLocation("dracolotl", "textures/entity/dracolotl_nether.png");
        }

        return new ResourceLocation("dracolotl","textures/entity/dracolotl.png");

    }

    @Override
    public ResourceLocation getAnimationResource(DracolotlEntity dracolotl) {
        return new ResourceLocation("dracolotl", "animations/dracolotl.animation.json");
    }
}