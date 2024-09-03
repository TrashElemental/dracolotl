package net.trashelemental.infested.entity.client.renderers;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.trashelemental.infested.InfestedSwarmsAndSpiders;
import net.trashelemental.infested.entity.ModEntityClientEvents;
import net.trashelemental.infested.entity.client.models.GrubModel;
import net.trashelemental.infested.entity.custom.GrubEntity;

public class GrubRenderer extends MobRenderer<GrubEntity, GrubModel<GrubEntity>> {
    public GrubRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new GrubModel<>(pContext.bakeLayer(ModEntityClientEvents.GRUB_LAYER)), 0.3f);
    }

    @Override
    public ResourceLocation getTextureLocation(GrubEntity GrubEntity) {
        return InfestedSwarmsAndSpiders.prefix("textures/entity/grub.png");
    }

    @Override
    public void render(GrubEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pPoseStack,
                       MultiBufferSource pBuffer, int pPackedLight) {



        super.render(pEntity, pEntityYaw, pPartialTicks, pPoseStack, pBuffer, pPackedLight);
    }
}
