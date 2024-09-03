package net.trashelemental.infested.entity.client.renderers;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.trashelemental.infested.InfestedSwarmsAndSpiders;
import net.trashelemental.infested.entity.ModEntityClientEvents;
import net.trashelemental.infested.entity.client.models.MantisModel;
import net.trashelemental.infested.entity.custom.OrchidMantisEntity;

public class OrchidMantisRenderer extends MobRenderer<OrchidMantisEntity, MantisModel<OrchidMantisEntity>> {
    public OrchidMantisRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new MantisModel<>(pContext.bakeLayer(ModEntityClientEvents.ORCHID_MANTIS_LAYER)), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(OrchidMantisEntity OrchidMantisEntity) {
        return InfestedSwarmsAndSpiders.prefix("textures/entity/orchid_mantis.png");
    }

    @Override
    public void render(OrchidMantisEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight) {
        float scale = 1.0f;
        if (pEntity.isBaby()) { scale = 0.5f; }
        pPoseStack.pushPose();
        pPoseStack.scale(scale, scale, scale);
        super.render(pEntity, pEntityYaw, pPartialTicks, pPoseStack, pBuffer, pPackedLight);
        pPoseStack.popPose();
    }
}