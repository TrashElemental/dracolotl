package net.trashelemental.infested.entity.client.renderers.jewel_beetles;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.resources.ResourceLocation;
import net.trashelemental.infested.InfestedSwarmsAndSpiders;
import net.trashelemental.infested.entity.ModEntityClientEvents;
import net.trashelemental.infested.entity.client.models.JewelBeetleModel;
import net.trashelemental.infested.entity.custom.jewel_beetles.HarvestBeetleEntity;

public class HarvestBeetleRenderer extends MobRenderer<HarvestBeetleEntity, JewelBeetleModel<HarvestBeetleEntity>> {

    private static final ResourceLocation MAIN_TEXTURE = InfestedSwarmsAndSpiders.prefix("textures/entity/harvest_beetle.png");
    private static final ResourceLocation EMISSIVE_TEXTURE = InfestedSwarmsAndSpiders.prefix("textures/entity/harvest_beetle_glow.png");

    public HarvestBeetleRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new JewelBeetleModel<>(pContext.bakeLayer(ModEntityClientEvents.HARVEST_BEETLE_LAYER)), 0.3f);
        this.addLayer(new EmissiveLayer<>(this));
    }

    @Override
    public ResourceLocation getTextureLocation(HarvestBeetleEntity entity) {
        return MAIN_TEXTURE;
    }

    private static class EmissiveLayer<T extends HarvestBeetleEntity, M extends EntityModel<T>> extends RenderLayer<T, M> {

        public EmissiveLayer(RenderLayerParent<T, M> parent) {
            super(parent);
        }

        @Override
        public void render(PoseStack poseStack, MultiBufferSource buffer, int packedLight, T entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
            VertexConsumer vertexConsumer = buffer.getBuffer(RenderType.eyes(EMISSIVE_TEXTURE));
            this.getParentModel().renderToBuffer(poseStack, vertexConsumer, packedLight, LivingEntityRenderer.getOverlayCoords(entity, 0.0F));
        }
    }

    @Override
    public void render(HarvestBeetleEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight) {
        float scale = 0.5f;
        pPoseStack.pushPose();
        pPoseStack.scale(scale, scale, scale);
        super.render(pEntity, pEntityYaw, pPartialTicks, pPoseStack, pBuffer, pPackedLight);
        pPoseStack.popPose();
    }
}
