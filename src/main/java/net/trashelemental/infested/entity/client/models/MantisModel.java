package net.trashelemental.infested.entity.client.models;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.trashelemental.infested.entity.animation.MantisAnimationDefinitions;
import net.trashelemental.infested.entity.custom.MantisEntity;
import net.trashelemental.infested.entity.custom.OrchidMantisEntity;

public class MantisModel<T extends Entity> extends HierarchicalModel<T> {

    private final ModelPart mantis;
    private final ModelPart Head;


    public MantisModel(ModelPart root) {
        this.mantis = root.getChild("mantis");
        this.Head = mantis.getChild("Head");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition mantis = partdefinition.addOrReplaceChild("mantis", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition Head = mantis.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(22, 28).addBox(-3.0F, -4.0F, -2.2759F, 6.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -18.75F, -2.5F));

        PartDefinition Eyes = Head.addOrReplaceChild("Eyes", CubeListBuilder.create().texOffs(0, 42).addBox(-5.0F, -25.25F, -3.7759F, 3.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(40, 26).addBox(2.0F, -25.25F, -3.7759F, 3.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 20.75F, 2.5F));

        PartDefinition Antenna = Head.addOrReplaceChild("Antenna", CubeListBuilder.create(), PartPose.offset(0.0F, -3.25F, 6.5F));

        PartDefinition AntennaR = Antenna.addOrReplaceChild("AntennaR", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition Rantenna_r1 = AntennaR.addOrReplaceChild("Rantenna_r1", CubeListBuilder.create().texOffs(0, 22).addBox(-1.3289F, -3.5163F, -1.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.2177F, -0.8613F, -2.2954F, 0.0F, 0.0F, -0.4363F));

        PartDefinition AntennaL = Antenna.addOrReplaceChild("AntennaL", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition Lantenna_r1 = AntennaL.addOrReplaceChild("Lantenna_r1", CubeListBuilder.create().texOffs(0, 22).addBox(-1.0F, -4.0F, -1.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 0.25F, -2.2759F, 0.0F, 0.0F, 0.4363F));

        PartDefinition Mandibles = Head.addOrReplaceChild("Mandibles", CubeListBuilder.create(), PartPose.offset(0.0F, -1.25F, 11.5F));

        PartDefinition MandibleL = Mandibles.addOrReplaceChild("MandibleL", CubeListBuilder.create().texOffs(0, 0).addBox(1.0F, -1.75F, -5.2759F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 2.0F, -9.0F));

        PartDefinition MandibleR = Mandibles.addOrReplaceChild("MandibleR", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, 0.25F, -14.2759F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition Pincers = mantis.addOrReplaceChild("Pincers", CubeListBuilder.create(), PartPose.offset(0.0F, -14.0F, -2.0F));

        PartDefinition ArmR = Pincers.addOrReplaceChild("ArmR", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0015F, -0.2615F, -0.0136F));

        PartDefinition Rarm1 = ArmR.addOrReplaceChild("Rarm1", CubeListBuilder.create(), PartPose.offset(-0.3926F, -0.6078F, -0.0171F));

        PartDefinition Rarm1_r1 = Rarm1.addOrReplaceChild("Rarm1_r1", CubeListBuilder.create().texOffs(10, 42).mirror().addBox(-1.0F, -2.0F, -1.0F, 6.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.25F, 1.0F, -0.7759F, -1.208F, 0.6237F, 1.1927F));

        PartDefinition Rarm2 = ArmR.addOrReplaceChild("Rarm2", CubeListBuilder.create(), PartPose.offset(3.6074F, 4.3922F, -3.0171F));

        PartDefinition Rarm2_r1 = Rarm2.addOrReplaceChild("Rarm2_r1", CubeListBuilder.create().texOffs(0, 34).mirror().addBox(-1.0F, -2.0F, -1.0F, 8.0F, 2.0F, 2.0F, new CubeDeformation(0.2F)).mirror(false), PartPose.offsetAndRotation(-0.75F, -0.5F, 0.2241F, 1.4216F, 0.3561F, -1.805F));

        PartDefinition Rarm3 = ArmR.addOrReplaceChild("Rarm3", CubeListBuilder.create(), PartPose.offset(0.6074F, -1.6078F, -6.0171F));

        PartDefinition Rarm3_r1 = Rarm3.addOrReplaceChild("Rarm3_r1", CubeListBuilder.create().texOffs(20, 22).mirror().addBox(-1.0F, -2.0F, -1.0F, 12.0F, 2.0F, 2.0F, new CubeDeformation(0.2F)).mirror(false), PartPose.offsetAndRotation(0.5F, 0.25F, -0.2759F, 1.4629F, 0.3809F, 1.3364F));

        PartDefinition Larm = Pincers.addOrReplaceChild("Larm", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0437F, 0.0436F, 0.0019F));

        PartDefinition Arm1 = Larm.addOrReplaceChild("Arm1", CubeListBuilder.create(), PartPose.offset(0.0872F, -1.0F, -0.0019F));

        PartDefinition Larm1_r1 = Arm1.addOrReplaceChild("Larm1_r1", CubeListBuilder.create().texOffs(10, 42).addBox(-5.0F, -2.0F, -1.0F, 6.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.25F, 1.0F, -0.7911F, -1.208F, -0.6237F, -1.1927F));

        PartDefinition Arm2 = Larm.addOrReplaceChild("Arm2", CubeListBuilder.create(), PartPose.offset(-2.9128F, 4.0F, -3.0019F));

        PartDefinition Larm2_r1 = Arm2.addOrReplaceChild("Larm2_r1", CubeListBuilder.create().texOffs(0, 34).addBox(-7.0F, -2.0F, -1.0F, 8.0F, 2.0F, 2.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(-0.25F, -0.5F, 0.2089F, 1.4216F, -0.3561F, 1.805F));

        PartDefinition Arm3 = Larm.addOrReplaceChild("Arm3", CubeListBuilder.create(), PartPose.offset(-1.9128F, 0.0F, -6.0019F));

        PartDefinition Larm3_r1 = Arm3.addOrReplaceChild("Larm3_r1", CubeListBuilder.create().texOffs(20, 22).addBox(-11.0F, -2.0F, -1.0F, 12.0F, 2.0F, 2.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(0.5F, -1.6899F, -0.7776F, 1.0702F, -0.3809F, -1.3364F));

        PartDefinition Body = mantis.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -19.0F, -3.7759F, 4.0F, 12.0F, 4.0F, new CubeDeformation(-0.3F))
                .texOffs(0, 22).addBox(-3.0F, -10.0F, -1.7759F, 6.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition abdomen = Body.addOrReplaceChild("abdomen", CubeListBuilder.create(), PartPose.offset(0.0F, -8.0F, 2.0F));

        PartDefinition abdomen_r1 = abdomen.addOrReplaceChild("abdomen_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -3.0F, -1.0F, 8.0F, 4.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, 1.2241F, 0.1745F, 0.0F, 0.0F));

        PartDefinition Legs = mantis.addOrReplaceChild("Legs", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition Rlegs = Legs.addOrReplaceChild("Rlegs", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -9.0F, 5.0F, 0.0F, 0.0F, 0.5236F));

        PartDefinition RLeg1 = Rlegs.addOrReplaceChild("RLeg1", CubeListBuilder.create(), PartPose.offset(0.0F, 1.0F, -3.0F));

        PartDefinition Rleg1_r1 = RLeg1.addOrReplaceChild("Rleg1_r1", CubeListBuilder.create().texOffs(34, 0).addBox(-1.0F, -2.0F, -1.0F, 12.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, 0.0F, 1.2241F, -0.0791F, -0.5621F, 0.1548F));

        PartDefinition RLeg2 = Rlegs.addOrReplaceChild("RLeg2", CubeListBuilder.create(), PartPose.offset(1.0F, 1.0F, -5.0F));

        PartDefinition Rleg2_r1 = RLeg2.addOrReplaceChild("Rleg2_r1", CubeListBuilder.create().texOffs(34, 0).addBox(-1.0F, -2.0F, -1.0F, 12.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.2079F, 0.024F, -0.4858F, 0.0751F, 0.5627F, 0.1541F));

        PartDefinition Llegs = Legs.addOrReplaceChild("Llegs", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -9.0F, 5.0F, 0.0F, 0.0F, -0.5236F));

        PartDefinition Lleg1 = Llegs.addOrReplaceChild("Lleg1", CubeListBuilder.create(), PartPose.offset(-1.0F, 1.0F, -3.0F));

        PartDefinition Lleg1_r1 = Lleg1.addOrReplaceChild("Lleg1_r1", CubeListBuilder.create().texOffs(34, 0).mirror().addBox(-11.0F, -2.0F, -1.0F, 12.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-3.0F, 0.0F, 1.2241F, -0.0791F, 0.5621F, -0.1548F));

        PartDefinition Lleg2 = Llegs.addOrReplaceChild("Lleg2", CubeListBuilder.create(), PartPose.offset(0.0F, 1.0F, -6.0F));

        PartDefinition Lleg2_r1 = Lleg2.addOrReplaceChild("Lleg2_r1", CubeListBuilder.create().texOffs(34, 0).mirror().addBox(-11.0F, -2.0F, -1.0F, 12.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-4.0F, 0.0F, 0.2241F, 0.0751F, -0.5627F, -0.1541F));

        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    @Override
    public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.root().getAllParts().forEach(ModelPart::resetPose);
        this.applyHeadRotation(netHeadYaw, headPitch, ageInTicks);

        this.animateWalk(MantisAnimationDefinitions.MANTIS_WALK, limbSwing, limbSwingAmount, 1f, 2.5f);

        if (entity instanceof MantisEntity) {
            this.animate(((MantisEntity) entity).idleAnimationState, MantisAnimationDefinitions.MANTIS_IDLE, ageInTicks, 1f);
        } else if (entity instanceof OrchidMantisEntity) {
            this.animate(((OrchidMantisEntity) entity).idleAnimationState, MantisAnimationDefinitions.MANTIS_IDLE, ageInTicks, 1f);
        }

        if (entity instanceof MantisEntity) {
            this.animate(((MantisEntity) entity).attackAnimationState, MantisAnimationDefinitions.MANTIS_ATTACK, ageInTicks, 1f);
        } else if (entity instanceof OrchidMantisEntity) {
            this.animate(((OrchidMantisEntity) entity).attackAnimationState, MantisAnimationDefinitions.MANTIS_ATTACK, ageInTicks, 1f);
        }
    }

    private void applyHeadRotation(float pNetHeadYaw, float pHeadPitch, float pAgeInTicks) {
        pNetHeadYaw = Mth.clamp(pNetHeadYaw, -30.0F, 30.0F);
        pHeadPitch = Mth.clamp(pHeadPitch, -25.0F, 45.0F);

        this.Head.yRot = pNetHeadYaw * ((float)Math.PI / 180F);
        this.Head.xRot = pHeadPitch * ((float)Math.PI / 180F);
    }

    @Override
    public ModelPart root() {
        return mantis;
    }
}
