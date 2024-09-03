package net.trashelemental.infested.entity.client.models;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.trashelemental.infested.entity.animation.BrilliantBeetleAnimationDefinitions;
import net.trashelemental.infested.entity.custom.BrilliantBeetleEntity;

import static net.trashelemental.infested.entity.custom.BrilliantBeetleEntity.ANIMATION;

public class BrilliantBeetleModel<T extends Entity> extends HierarchicalModel<T> {

    private final ModelPart brilliant_beetle;
    private final ModelPart Head;


    public BrilliantBeetleModel(ModelPart root) {
        this.brilliant_beetle = root.getChild("brilliant_beetle");
        this.Head = brilliant_beetle.getChild("Head");

    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition brilliant_beetle = partdefinition.addOrReplaceChild("brilliant_beetle", CubeListBuilder.create(), PartPose.offset(4.5F, 22.0F, 12.75F));

        PartDefinition Head = brilliant_beetle.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(0, 0).addBox(-6.0F, -3.0F, -12.0F, 12.0F, 6.0F, 10.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-1.0F, -8.0F, -12.75F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(0, 16).addBox(-1.0F, -9.75F, -12.75F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-5.0F, -4.0F, -11.0F));

        PartDefinition Antenna = Head.addOrReplaceChild("Antenna", CubeListBuilder.create(), PartPose.offset(0.0F, -1.0F, -8.0F));

        PartDefinition Rantenna = Antenna.addOrReplaceChild("Rantenna", CubeListBuilder.create().texOffs(28, 0).addBox(6.0F, -1.0F, -9.0F, 3.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition Lantenna = Antenna.addOrReplaceChild("Lantenna", CubeListBuilder.create().texOffs(37, 0).addBox(-9.0F, -1.0F, -9.0F, 3.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition Body = brilliant_beetle.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 16).addBox(-12.0F, -3.0F, -8.0F, 14.0F, 5.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, -5.0F));

        PartDefinition Rwing = Body.addOrReplaceChild("Rwing", CubeListBuilder.create().texOffs(0, 40).mirror().addBox(-3.5324F, -2.465F, -0.5589F, 7.0F, 6.0F, 18.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-0.75F, -3.5F, -8.5F));

        PartDefinition Relytra = Body.addOrReplaceChild("Relytra", CubeListBuilder.create().texOffs(18, 41).addBox(-0.75F, -0.25F, -2.0F, 7.0F, 0.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.0F, -3.0F, -6.0F));

        PartDefinition Lwing = Body.addOrReplaceChild("Lwing", CubeListBuilder.create().texOffs(0, 40).addBox(-5.5F, -2.0F, -3.0F, 7.0F, 6.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offset(-7.0F, -4.0F, -6.0F));

        PartDefinition Lelytra = Body.addOrReplaceChild("Lelytra", CubeListBuilder.create().texOffs(18, 41).mirror().addBox(-5.25F, -0.25F, -2.0F, 7.0F, 0.0F, 15.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-7.0F, -3.0F, -6.0F));

        PartDefinition Legs = brilliant_beetle.addOrReplaceChild("Legs", CubeListBuilder.create(), PartPose.offset(-14.0F, -1.0F, -6.0F));

        PartDefinition Rleg1 = Legs.addOrReplaceChild("Rleg1", CubeListBuilder.create(), PartPose.offset(14.0F, 0.0F, -5.0F));

        PartDefinition Rleg1_r1 = Rleg1.addOrReplaceChild("Rleg1_r1", CubeListBuilder.create().texOffs(34, 6).addBox(1.0F, -1.0F, -1.0F, 11.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, -0.25F, 0.0F, 0.0222F, 0.4708F, 0.3108F));

        PartDefinition Lleg1 = Legs.addOrReplaceChild("Lleg1", CubeListBuilder.create(), PartPose.offset(4.0F, 0.0F, -5.0F));

        PartDefinition Lleg1_r1 = Lleg1.addOrReplaceChild("Lleg1_r1", CubeListBuilder.create().texOffs(34, 6).addBox(-11.0F, -1.0F, -1.0F, 11.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5F, 0.0F, 0.0F, 0.0222F, -0.4708F, -0.3108F));

        PartDefinition Rleg2 = Legs.addOrReplaceChild("Rleg2", CubeListBuilder.create(), PartPose.offset(14.5F, -1.25F, 0.25F));

        PartDefinition Rleg2_r1 = Rleg2.addOrReplaceChild("Rleg2_r1", CubeListBuilder.create().texOffs(34, 6).addBox(2.0F, -1.0F, -1.0F, 11.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.3403F, 0.5767F, -0.7899F, 0.0F, 0.0F, 0.3054F));

        PartDefinition Lleg2 = Legs.addOrReplaceChild("Lleg2", CubeListBuilder.create(), PartPose.offset(2.5F, -1.0F, 0.25F));

        PartDefinition Lleg2_r1 = Lleg2.addOrReplaceChild("Lleg2_r1", CubeListBuilder.create().texOffs(34, 6).addBox(-11.0F, -1.0F, -1.0F, 11.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 1.0F, -0.25F, 0.0F, 0.0F, -0.3054F));

        PartDefinition Rleg3 = Legs.addOrReplaceChild("Rleg3", CubeListBuilder.create(), PartPose.offset(14.5F, 0.0F, 5.25F));

        PartDefinition Rleg3_r1 = Rleg3.addOrReplaceChild("Rleg3_r1", CubeListBuilder.create().texOffs(34, 6).addBox(0.0F, -1.0F, -1.0F, 11.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5F, 0.0F, -0.25F, -0.147F, -0.5177F, 0.3116F));

        PartDefinition Lleg3 = Legs.addOrReplaceChild("Lleg3", CubeListBuilder.create(), PartPose.offset(2.5F, -1.0F, 5.25F));

        PartDefinition Lleg3_r1 = Lleg3.addOrReplaceChild("Lleg3_r1", CubeListBuilder.create().texOffs(34, 6).addBox(-10.0F, -1.0F, -1.0F, 11.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 1.0F, -0.25F, -0.0503F, 0.5214F, -0.3625F));

        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    @Override
    public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.root().getAllParts().forEach(ModelPart::resetPose);
        this.applyHeadRotation(netHeadYaw, headPitch, ageInTicks);

        BrilliantBeetleEntity beetle = (BrilliantBeetleEntity) entity;
        String animationState = beetle.getEntityData().get(ANIMATION);

        boolean isBaby = beetle.isBaby();
        float animationSpeedMultiplier = isBaby ? 0.5f : 1.0f;

        if (animationState.equals("walk")) {
            this.animateWalk(BrilliantBeetleAnimationDefinitions.BRILLIANT_BEETLE_WALK, limbSwing, limbSwingAmount, 2f * animationSpeedMultiplier, 2.5f * animationSpeedMultiplier);
        } else if (animationState.equals("fall")) {
            this.animate(((BrilliantBeetleEntity) entity).fallAnimationState, BrilliantBeetleAnimationDefinitions.BRILLIANT_BEETLE_FALL, ageInTicks * animationSpeedMultiplier, 1f * animationSpeedMultiplier);
        } else {
            this.animate(((BrilliantBeetleEntity) entity).idleAnimationState, BrilliantBeetleAnimationDefinitions.BRILLIANT_BEETLE_IDLE, ageInTicks * animationSpeedMultiplier, 1f * animationSpeedMultiplier);
        }
    }

    private void applyHeadRotation(float pNetHeadYaw, float pHeadPitch, float pAgeInTicks) {
        pNetHeadYaw = Mth.clamp(pNetHeadYaw, -30.0F, 30.0F);
        pHeadPitch = Mth.clamp(pHeadPitch, -25.0F, 45.0F);

        this.Head.yRot = pNetHeadYaw * ((float)Math.PI / 180F);
        this.Head.xRot = pHeadPitch * ((float)Math.PI / 180F);
    }

//    @Override
//    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
//        brilliant_beetle.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
//    }

    @Override
    public ModelPart root() {
        return brilliant_beetle;
    }
}