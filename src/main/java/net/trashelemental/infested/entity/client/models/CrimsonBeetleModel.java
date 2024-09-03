package net.trashelemental.infested.entity.client.models;

import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.trashelemental.infested.entity.animation.CrimsonBeetleAnimationDefinitions;
import net.trashelemental.infested.entity.custom.CrimsonBeetleEntity;

public class CrimsonBeetleModel<T extends Entity> extends HierarchicalModel<T> {

    private final ModelPart Crimson_Beetle;
    private final ModelPart Head;

    public CrimsonBeetleModel(ModelPart root) {
        this.Crimson_Beetle = root.getChild("Everything");
        this.Head = Crimson_Beetle.getChild("Head");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition Everything = partdefinition.addOrReplaceChild("Everything", CubeListBuilder.create(), PartPose.offset(0.0341F, 27.5F, 0.5845F));

        PartDefinition Head = Everything.addOrReplaceChild("Head", CubeListBuilder.create(), PartPose.offset(0.0F, -7.0F, -3.0F));

        PartDefinition Head2 = Head.addOrReplaceChild("Head2", CubeListBuilder.create().texOffs(0, 31).addBox(-4.0F, -10.0F, -8.0F, 8.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 7.0F, 3.0F));

        PartDefinition Antenna = Head.addOrReplaceChild("Antenna", CubeListBuilder.create(), PartPose.offset(0.0F, 7.0F, 3.0F));

        PartDefinition Lantenna = Antenna.addOrReplaceChild("Lantenna", CubeListBuilder.create(), PartPose.offset(-3.0F, -10.0F, -7.0F));

        PartDefinition Rantenna_r1 = Lantenna.addOrReplaceChild("Rantenna_r1", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-3.0F, 0.0F, -5.0F, 3.0F, 0.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.3927F, 0.0F, 0.0F));

        PartDefinition Rantenna = Antenna.addOrReplaceChild("Rantenna", CubeListBuilder.create(), PartPose.offset(2.0F, -10.0F, -7.0F));

        PartDefinition Lantenna_r1 = Rantenna.addOrReplaceChild("Lantenna_r1", CubeListBuilder.create().texOffs(0, 16).addBox(0.0F, 0.0F, -5.0F, 3.0F, 0.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.3458F, -0.4872F, 0.1629F, -0.3927F, 0.0F, 0.0F));

        PartDefinition Mandibles = Head.addOrReplaceChild("Mandibles", CubeListBuilder.create(), PartPose.offset(0.0F, 7.0F, 3.0F));

        PartDefinition Rmandible = Mandibles.addOrReplaceChild("Rmandible", CubeListBuilder.create(), PartPose.offset(3.0F, -5.0F, -6.0F));

        PartDefinition Rmandible_r1 = Rmandible.addOrReplaceChild("Rmandible_r1", CubeListBuilder.create().texOffs(-2, 0).addBox(-3.0F, 0.0F, -5.0F, 5.0F, 0.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, -0.5F, -1.25F, 0.0873F, 0.0F, 0.0F));

        PartDefinition Lmandible = Mandibles.addOrReplaceChild("Lmandible", CubeListBuilder.create(), PartPose.offset(-3.0F, -5.0F, -7.0F));

        PartDefinition Lmandible_r1 = Lmandible.addOrReplaceChild("Lmandible_r1", CubeListBuilder.create().texOffs(-2, 0).mirror().addBox(-2.0F, 0.0F, -5.0F, 5.0F, 0.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.0F, -0.5F, -0.25F, 0.0873F, 0.0F, 0.0F));

        PartDefinition Body = Everything.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 16).addBox(-5.0F, -1.0F, -6.0F, 10.0F, 2.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-6.0F, -3.75F, -6.5F, 12.0F, 3.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -7.0F, 2.0F));

        PartDefinition Legs = Everything.addOrReplaceChild("Legs", CubeListBuilder.create(), PartPose.offset(-14.0F, -6.5F, 6.0F));

        PartDefinition Lleg1 = Legs.addOrReplaceChild("Lleg1", CubeListBuilder.create(), PartPose.offset(10.0F, -1.0F, -8.0F));

        PartDefinition Lleg1_r1 = Lleg1.addOrReplaceChild("Lleg1_r1", CubeListBuilder.create().texOffs(37, 0).addBox(-8.0F, -1.0F, -1.0F, 9.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 0.0F, 0.0F, 0.054F, -0.3892F, -0.4033F));

        PartDefinition Rleg1 = Legs.addOrReplaceChild("Rleg1", CubeListBuilder.create(), PartPose.offset(18.0F, 0.0F, -9.0F));

        PartDefinition Rleg1_r1 = Rleg1.addOrReplaceChild("Rleg1_r1", CubeListBuilder.create().texOffs(37, 0).addBox(0.0F, -1.0F, -1.0F, 9.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, 1.0F, 0.054F, 0.3892F, 0.447F));

        PartDefinition Lleg2 = Legs.addOrReplaceChild("Lleg2", CubeListBuilder.create(), PartPose.offset(10.0F, -1.0F, -4.0F));

        PartDefinition Lleg2_r1 = Lleg2.addOrReplaceChild("Lleg2_r1", CubeListBuilder.create().texOffs(37, 0).addBox(-8.0F, -1.0F, -1.0F, 9.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.3927F));

        PartDefinition Rleg2 = Legs.addOrReplaceChild("Rleg2", CubeListBuilder.create(), PartPose.offset(18.0F, -1.0F, -4.0F));

        PartDefinition Rleg2_r1 = Rleg2.addOrReplaceChild("Rleg2_r1", CubeListBuilder.create().texOffs(37, 0).addBox(1.0F, -1.0F, -1.0F, 9.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.3491F));

        PartDefinition Lleg3 = Legs.addOrReplaceChild("Lleg3", CubeListBuilder.create(), PartPose.offsetAndRotation(10.0F, -1.0F, 0.0F, 0.0F, 0.0F, -0.0873F));

        PartDefinition Lleg3_r1 = Lleg3.addOrReplaceChild("Lleg3_r1", CubeListBuilder.create().texOffs(37, 0).addBox(-8.0F, -1.0F, -1.0F, 9.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 0.0F, 0.0F, -0.061F, 0.6082F, -0.3682F));

        PartDefinition Rleg3 = Legs.addOrReplaceChild("Rleg3", CubeListBuilder.create(), PartPose.offset(18.0F, -1.0F, 0.0F));

        PartDefinition Rleg3_r1 = Rleg3.addOrReplaceChild("Rleg3_r1", CubeListBuilder.create().texOffs(37, 0).addBox(0.0F, -1.0F, -1.0F, 9.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.0911F, -0.6049F, 0.4648F));

        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    @Override
    public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.root().getAllParts().forEach(ModelPart::resetPose);
        this.applyHeadRotation(netHeadYaw, headPitch, ageInTicks);

        this.animateWalk(CrimsonBeetleAnimationDefinitions.CRIMSON_BEETLE_WALK, limbSwing, limbSwingAmount, 1f, 2.5f);
        this.animate(((CrimsonBeetleEntity) entity).idleAnimationState, CrimsonBeetleAnimationDefinitions.CRIMSON_BEETLE_IDLE, ageInTicks, 1f);
    }

    private void applyHeadRotation(float pNetHeadYaw, float pHeadPitch, float pAgeInTicks) {
        pNetHeadYaw = Mth.clamp(pNetHeadYaw, -30.0F, 30.0F);
        pHeadPitch = Mth.clamp(pHeadPitch, -25.0F, 45.0F);

        this.Head.yRot = pNetHeadYaw * ((float)Math.PI / 180F);
        this.Head.xRot = pHeadPitch * ((float)Math.PI / 180F);
    }

//    @Override
//    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
//        Crimson_Beetle.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
//    }

    @Override
    public ModelPart root() {
        return Crimson_Beetle;
    }
}
