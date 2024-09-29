package net.trashelemental.dracolotl.entity.client.renderers;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.trashelemental.dracolotl.entity.client.models.DracolotlModel;
import net.trashelemental.dracolotl.entity.custom.DracolotlEntity;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class DracolotlRenderer extends GeoEntityRenderer<DracolotlEntity> {

    public DracolotlRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new DracolotlModel());
    }

    @Override
    public ResourceLocation getTextureLocation(DracolotlEntity animatable) {
        if (animatable.ShouldUseRedDragonSkin()) {
            return new ResourceLocation("dracolotl", "textures/entity/dracolotl_nether.png");
        }

        return new ResourceLocation("dracolotl","textures/entity/dracolotl.png");
    }

    @Override
    public void render(DracolotlEntity entity, float entityYaw, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight) {

        if (entity.isBaby()) {
            poseStack.scale(0.4f, 0.4f, 0.4f);
        }

        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }
}
