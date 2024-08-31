package net.trashelemental.infested.entity.client.renderers.minions;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.SpiderModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.resources.ResourceLocation;
import net.trashelemental.infested.InfestedSwarmsAndSpiders;
import net.trashelemental.infested.entity.custom.minions.AttackSpiderEntity;

public class AttackSpiderRenderer extends MobRenderer<AttackSpiderEntity, SpiderModel<AttackSpiderEntity>> {

    private static final ResourceLocation MAIN_TEXTURE = ResourceLocation.fromNamespaceAndPath(InfestedSwarmsAndSpiders.MOD_ID, "textures/entity/cave_spider.png");
    private static final ResourceLocation EMISSIVE_TEXTURE = ResourceLocation.fromNamespaceAndPath(InfestedSwarmsAndSpiders.MOD_ID, "textures/entity/spider_eye_red.png");

    public AttackSpiderRenderer(EntityRendererProvider.Context context) {
        super(context, new SpiderModel<>(context.bakeLayer(ModelLayers.SPIDER)), 0.3f);
        this.addLayer(new AttackSpiderRenderer.EmissiveLayer<>(this));
    }

    @Override
    public ResourceLocation getTextureLocation(AttackSpiderEntity entity) {
        return MAIN_TEXTURE;
    }

    private static class EmissiveLayer<T extends AttackSpiderEntity, M extends EntityModel<T>> extends RenderLayer<T, M> {

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
    public void render(AttackSpiderEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight) {
        float scale = 0.3f;
        pPoseStack.pushPose();
        pPoseStack.scale(scale, scale, scale);
        super.render(pEntity, pEntityYaw, pPartialTicks, pPoseStack, pBuffer, pPackedLight);
        pPoseStack.popPose();
    }
}
