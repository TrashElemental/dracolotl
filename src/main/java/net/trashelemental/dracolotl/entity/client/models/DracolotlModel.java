package net.trashelemental.dracolotl.entity.client.models;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.trashelemental.dracolotl.dracolotl;
import net.trashelemental.dracolotl.entity.custom.DracolotlEntity;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class DracolotlModel extends GeoModel<DracolotlEntity> {
    @Override
    public ResourceLocation getModelResource(DracolotlEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath("dracolotl","geo/models/dracolotl.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(DracolotlEntity animatable) {

        if (animatable.ShouldUseRedDragonSkin()) {
            return ResourceLocation.fromNamespaceAndPath("dracolotl", "textures/entity/dracolotl_nether.png");
        }

        return ResourceLocation.fromNamespaceAndPath("dracolotl","textures/entity/dracolotl.png");
    }

    @Override
    public ResourceLocation getAnimationResource(DracolotlEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath("dracolotl","animations/dracolotl.animation.json");
    }

    @Override
    public void setCustomAnimations(DracolotlEntity animatable, long instanceId, AnimationState<DracolotlEntity> animationState) {
        GeoBone head = getAnimationProcessor().getBone("Head");

        if (head != null) {
            EntityModelData entityData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);

            head.setRotX(entityData.headPitch() * Mth.DEG_TO_RAD);
            head.setRotY(entityData.netHeadYaw() * Mth.DEG_TO_RAD);
        }
    }
}
