package net.trashelemental.infested.datagen;

import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.advancements.AdvancementRequirements;
import net.minecraft.advancements.AdvancementType;
import net.minecraft.advancements.critereon.ConsumeItemTrigger;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.advancements.AdvancementSubProvider;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.neoforged.neoforge.common.data.AdvancementProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.trashelemental.infested.InfestedSwarmsAndSpiders;
import net.trashelemental.infested.item.ModItems;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class ModAdvancementProvider extends AdvancementProvider {
    public ModAdvancementProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, existingFileHelper, List.of(new ModAdvancementGenerator()));
    }

    private static final class ModAdvancementGenerator implements AdvancementProvider.AdvancementGenerator {
        @Override
        public void generate(HolderLookup.Provider registries, Consumer<AdvancementHolder> saver, ExistingFileHelper existingFileHelper) {


            Advancement.Builder SpiderEggGet = Advancement.Builder.advancement();
            SpiderEggGet.parent(AdvancementSubProvider.createPlaceholder("minecraft:husbandry/tame_an_animal"));
            SpiderEggGet.display(
                    new ItemStack(ModItems.SPIDER_EGG.get()), //Icon
                    Component.translatable("advancements.spider_egg_get.title"),        //Title
                    Component.translatable("advancements.spider_egg_get.description"),  //Description
                    null, //Should be null unless this is a root advancement
                    AdvancementType.GOAL,
                    true,
                    true,
                    false
            );
            SpiderEggGet.addCriterion("has_spider_egg", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.SPIDER_EGG.get()));
            SpiderEggGet.requirements(AdvancementRequirements.allOf(List.of("has_spider_egg")));
            SpiderEggGet.save(saver, ResourceLocation.fromNamespaceAndPath("infested_swarms_spiders", "spider_egg_get"), existingFileHelper);


            Advancement.Builder SilverfishEggsGet = Advancement.Builder.advancement();
            SilverfishEggsGet.parent(AdvancementSubProvider.createPlaceholder("minecraft:husbandry/tame_an_animal"));
            SilverfishEggsGet.display(
                    new ItemStack(ModItems.SILVERFISH_EGGS.get()), //Icon
                    Component.translatable("advancements.silverfish_eggs_get.title"),        //Title
                    Component.translatable("advancements.silverfish_eggs_get.description"),  //Description
                    null, //Should be null unless this is a root advancement
                    AdvancementType.GOAL,
                    true,
                    true,
                    false
            );
            SilverfishEggsGet.addCriterion("has_silverfish_eggs", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.SILVERFISH_EGGS.get()));
            SilverfishEggsGet.requirements(AdvancementRequirements.allOf(List.of("has_silverfish_eggs")));
            SilverfishEggsGet.save(saver, ResourceLocation.fromNamespaceAndPath("infested_swarms_spiders", "silverfish_eggs_get"), existingFileHelper);


            Advancement.Builder InsectTemplateGet = Advancement.Builder.advancement();
            InsectTemplateGet.parent(AdvancementSubProvider.createPlaceholder("minecraft:adventure/trim_with_any_armor_pattern"));
            InsectTemplateGet.display(
                    new ItemStack(ModItems.INSECT_TEMPLATE.get()), //Icon
                    Component.translatable("advancements.insect_template_get.title"),        //Title
                    Component.translatable("advancements.insect_template_get.description"),  //Description
                    null, //Should be null unless this is a root advancement
                    AdvancementType.GOAL,
                    true,
                    true,
                    false
            );
            InsectTemplateGet.addCriterion("has_insect_template", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.INSECT_TEMPLATE.get()));
            InsectTemplateGet.requirements(AdvancementRequirements.allOf(List.of("has_insect_template")));
            InsectTemplateGet.save(saver, ResourceLocation.fromNamespaceAndPath("infested_swarms_spiders", "insect_template_get"), existingFileHelper);


            Advancement.Builder SpiderTemplateGet = Advancement.Builder.advancement();
            SpiderTemplateGet.parent(AdvancementSubProvider.createPlaceholder("minecraft:adventure/trim_with_any_armor_pattern"));
            SpiderTemplateGet.display(
                    new ItemStack(ModItems.SPIDER_TEMPLATE.get()), //Icon
                    Component.translatable("advancements.spider_template_get.title"),        //Title
                    Component.translatable("advancements.spider_template_get.description"),  //Description
                    null, //Should be null unless this is a root advancement
                    AdvancementType.GOAL,
                    true,
                    true,
                    false
            );
            SpiderTemplateGet.addCriterion("has_spider_template", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.SPIDER_TEMPLATE.get()));
            SpiderTemplateGet.requirements(AdvancementRequirements.allOf(List.of("has_spider_template")));
            SpiderTemplateGet.save(saver, ResourceLocation.fromNamespaceAndPath("infested_swarms_spiders", "spider_template_get"), existingFileHelper);


            Advancement.Builder FriedGrubEat = Advancement.Builder.advancement();
            FriedGrubEat.parent(AdvancementSubProvider.createPlaceholder("minecraft:husbandry/balanced_diet"));
            FriedGrubEat.display(
                    new ItemStack(ModItems.FRIED_GRUB.get()), //Icon
                    Component.translatable("advancements.fried_grub_eat.title"),        //Title
                    Component.translatable("advancements.fried_grub_eat.description"),  //Description
                    null, //Should be null unless this is a root advancement
                    AdvancementType.GOAL,
                    true,
                    true,
                    false
            );
            FriedGrubEat.addCriterion("has_eaten_fried_grub", ConsumeItemTrigger.TriggerInstance.usedItem(ModItems.FRIED_GRUB.get()));
            FriedGrubEat.requirements(AdvancementRequirements.allOf(List.of("has_eaten_fried_grub")));
            FriedGrubEat.save(saver, ResourceLocation.fromNamespaceAndPath("infested_swarms_spiders", "fried_grub_eat"), existingFileHelper);

        }
    }
}
