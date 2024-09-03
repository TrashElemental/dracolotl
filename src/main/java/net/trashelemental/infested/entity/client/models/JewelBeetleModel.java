package net.trashelemental.infested.entity.client.models;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.world.entity.Entity;
import net.trashelemental.infested.entity.animation.JewelBeetleAnimationDefinitions;
import net.trashelemental.infested.entity.custom.jewel_beetles.AncientDebreetleEntity;
import net.trashelemental.infested.entity.custom.jewel_beetles.ChorusBeetleEntity;
import net.trashelemental.infested.entity.custom.jewel_beetles.HarvestBeetleEntity;
import net.trashelemental.infested.entity.custom.jewel_beetles.JewelBeetleEntity;

public class JewelBeetleModel<T extends Entity> extends HierarchicalModel<T> {

    private final ModelPart jewel_beetle;


    public JewelBeetleModel(ModelPart root) {
        this.jewel_beetle = root.getChild("jewel_beetle");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition jewel_beetle = partdefinition.addOrReplaceChild("jewel_beetle", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition Antenna = jewel_beetle.addOrReplaceChild("Antenna", CubeListBuilder.create().texOffs(42, 8).addBox(2.0F, -4.5F, -4.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(42, 8).addBox(-3.0F, -4.5F, -4.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -8.0F, -7.5F));

        PartDefinition Rantenna2_r1 = Antenna.addOrReplaceChild("Rantenna2_r1", CubeListBuilder.create().texOffs(37, 5).addBox(4.0F, 2.0F, -2.5F, 1.0F, 0.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(37, 5).addBox(-1.0F, 2.0F, -2.5F, 1.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, -5.0F, -1.0F, -0.3927F, 0.0F, 0.0F));

        PartDefinition Rantenna1_r1 = Antenna.addOrReplaceChild("Rantenna1_r1", CubeListBuilder.create().texOffs(39, 9).addBox(4.0F, -3.0F, -1.0F, 1.0F, 5.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(39, 9).addBox(-1.0F, -3.0F, -1.0F, 1.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, -1.0F, 0.0F, 0.4363F, 0.0F, 0.0F));

        PartDefinition Shell = jewel_beetle.addOrReplaceChild("Shell", CubeListBuilder.create().texOffs(0, 0).addBox(-5.5F, -11.0F, -8.0F, 11.0F, 7.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition Underside = jewel_beetle.addOrReplaceChild("Underside", CubeListBuilder.create().texOffs(0, 23).addBox(-4.5F, -5.0F, -7.0F, 9.0F, 2.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition Legs = jewel_beetle.addOrReplaceChild("Legs", CubeListBuilder.create(), PartPose.offset(0.0F, 1.0F, 0.0F));

        PartDefinition Leg1 = Legs.addOrReplaceChild("Leg1", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition L1 = Leg1.addOrReplaceChild("L1", CubeListBuilder.create(), PartPose.offset(0.0F, -1.0F, 0.0F));

        PartDefinition Lleg1_r1 = L1.addOrReplaceChild("Lleg1_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-7.0F, -3.0F, -4.0F, 6.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.5F, -3.0F, -1.0F, 0.219F, -0.3286F, -0.6037F));

        PartDefinition R1 = Leg1.addOrReplaceChild("R1", CubeListBuilder.create(), PartPose.offset(0.0F, -1.0F, 0.0F));

        PartDefinition Rleg1_r1 = R1.addOrReplaceChild("Rleg1_r1", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(0.5F, -3.0F, -4.0F, 6.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(3.5F, -3.0F, -1.0F, 0.219F, 0.3286F, 0.6037F));

        PartDefinition Leg2 = Legs.addOrReplaceChild("Leg2", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition L2 = Leg2.addOrReplaceChild("L2", CubeListBuilder.create(), PartPose.offset(0.0F, -1.0F, 0.0F));

        PartDefinition Lleg2_r1 = L2.addOrReplaceChild("Lleg2_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-6.25F, -1.0F, 0.0F, 6.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.5F, -4.0F, -1.0F, 0.0F, 0.0F, -0.5672F));

        PartDefinition R2 = Leg2.addOrReplaceChild("R2", CubeListBuilder.create(), PartPose.offset(0.0F, -1.0F, 0.0F));

        PartDefinition Rleg2_r1 = R2.addOrReplaceChild("Rleg2_r1", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(0.25F, -1.0F, 0.0F, 6.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(4.5F, -4.0F, -1.0F, 0.0F, 0.0F, 0.5672F));

        PartDefinition Leg3 = Legs.addOrReplaceChild("Leg3", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition L3 = Leg3.addOrReplaceChild("L3", CubeListBuilder.create(), PartPose.offset(0.0F, -1.0F, 0.0F));

        PartDefinition Lleg3_r1 = L3.addOrReplaceChild("Lleg3_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-7.0F, -1.0F, -1.0F, 6.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.5F, -4.0F, 4.0F, -0.1526F, 0.3152F, -0.4606F));

        PartDefinition R3 = Leg3.addOrReplaceChild("R3", CubeListBuilder.create(), PartPose.offset(0.0F, -1.0F, 0.0F));

        PartDefinition Rleg3_r1 = R3.addOrReplaceChild("Rleg3_r1", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(1.0F, -1.0F, -1.0F, 6.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(3.5F, -4.0F, 4.0F, -0.1526F, -0.3152F, 0.4606F));

        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    @Override
    public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.root().getAllParts().forEach(ModelPart::resetPose);

        this.animateWalk(JewelBeetleAnimationDefinitions.JEWEL_BEETLE_WALK, limbSwing, limbSwingAmount, 1f, 2.5f);

        if (entity instanceof HarvestBeetleEntity) {
            this.animate(((HarvestBeetleEntity) entity).idleAnimationState, JewelBeetleAnimationDefinitions.JEWEL_BEETLE_IDLE, ageInTicks, 1f);
        } else if (entity instanceof JewelBeetleEntity) {
            this.animate(((JewelBeetleEntity) entity).idleAnimationState, JewelBeetleAnimationDefinitions.JEWEL_BEETLE_IDLE, ageInTicks, 1f);
        } else if (entity instanceof ChorusBeetleEntity) {
            this.animate(((ChorusBeetleEntity) entity).idleAnimationState, JewelBeetleAnimationDefinitions.JEWEL_BEETLE_IDLE, ageInTicks, 1f);
        } else if (entity instanceof AncientDebreetleEntity) {
            this.animate(((AncientDebreetleEntity) entity).idleAnimationState, JewelBeetleAnimationDefinitions.JEWEL_BEETLE_IDLE, ageInTicks, 1f);
        }
    }


    @Override
    public ModelPart root() {
        return jewel_beetle;
    }
}
