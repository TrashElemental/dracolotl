package net.trashelemental.infested.entity.client.renderers;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.trashelemental.infested.InfestedSwarmsAndSpiders;
import net.trashelemental.infested.entity.ModEntityClientEvents;
import net.trashelemental.infested.entity.client.models.CrimsonBeetleModel;
import net.trashelemental.infested.entity.custom.CrimsonBeetleEntity;

public class CrimsonBeetleRenderer extends MobRenderer<CrimsonBeetleEntity, CrimsonBeetleModel<CrimsonBeetleEntity>> {
    public CrimsonBeetleRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new CrimsonBeetleModel<>(pContext.bakeLayer(ModEntityClientEvents.CRIMSON_BEETLE_LAYER)), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(CrimsonBeetleEntity crimsonBeetleEntity) {
        return InfestedSwarmsAndSpiders.prefix("textures/entity/crimson_beetle.png");
    }

    @Override
    public void render(CrimsonBeetleEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pPoseStack,
                       MultiBufferSource pBuffer, int pPackedLight) {

        if(pEntity.isBaby()) {
            pPoseStack.scale(0.5f, 0.5f, 0.5f);
        }

        super.render(pEntity, pEntityYaw, pPartialTicks, pPoseStack, pBuffer, pPackedLight);
    }
}