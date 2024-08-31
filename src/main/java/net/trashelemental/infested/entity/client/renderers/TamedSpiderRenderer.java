package net.trashelemental.infested.entity.client.renderers;

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
import net.minecraft.world.item.DyeColor;
import net.trashelemental.infested.InfestedSwarmsAndSpiders;
import net.trashelemental.infested.entity.custom.TamedSpiderEntity;

import java.util.HashMap;
import java.util.Map;

public class TamedSpiderRenderer extends MobRenderer<TamedSpiderEntity, SpiderModel<TamedSpiderEntity>> {
    private static final ResourceLocation MAIN_TEXTURE = ResourceLocation.fromNamespaceAndPath(InfestedSwarmsAndSpiders.MOD_ID, "textures/entity/cave_spider.png");
    private static final Map<DyeColor, ResourceLocation> EYE_TEXTURES = new HashMap<>();

    static {
        for (DyeColor color : DyeColor.values()) {
            EYE_TEXTURES.put(color, ResourceLocation.fromNamespaceAndPath(InfestedSwarmsAndSpiders.MOD_ID, "textures/entity/spider_eye_" + color.getName() + ".png"));
        }
    }

    public TamedSpiderRenderer(EntityRendererProvider.Context context) {
        super(context, new SpiderModel<>(context.bakeLayer(ModelLayers.SPIDER)), 0.3f);
        this.addLayer(new EmissiveLayer<>(this));
    }

    @Override
    public ResourceLocation getTextureLocation(TamedSpiderEntity entity) {
        return MAIN_TEXTURE;
    }

    private static class EmissiveLayer<T extends TamedSpiderEntity, M extends EntityModel<T>> extends RenderLayer<T, M> {

        public EmissiveLayer(RenderLayerParent<T, M> parent) {
            super(parent);
        }

        @Override
        public void render(PoseStack poseStack, MultiBufferSource buffer, int packedLight, T entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
            DyeColor eyeColor = entity.getEyeColor();
            ResourceLocation eyeTexture = EYE_TEXTURES.getOrDefault(eyeColor, EYE_TEXTURES.get(DyeColor.GREEN));

            VertexConsumer vertexConsumer = buffer.getBuffer(RenderType.eyes(eyeTexture));
            this.getParentModel().renderToBuffer(poseStack, vertexConsumer, packedLight, LivingEntityRenderer.getOverlayCoords(entity, 0.0F));
        }
    }

    @Override
    public void render(TamedSpiderEntity entity, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int packedLight) {
        float scale = 0.6f;
        poseStack.pushPose();
        poseStack.scale(scale, scale, scale);
        super.render(entity, entityYaw, partialTicks, poseStack, buffer, packedLight);
        poseStack.popPose();
    }
}