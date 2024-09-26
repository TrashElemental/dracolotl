package net.trashelemental.dracolotl.datagen;

import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.advancements.AdvancementRequirements;
import net.minecraft.advancements.AdvancementType;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.advancements.AdvancementSubProvider;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.common.data.AdvancementProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.trashelemental.dracolotl.item.ModItems;

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


            Advancement.Builder DracolotlBucketGet = Advancement.Builder.advancement();
            DracolotlBucketGet.parent(AdvancementSubProvider.createPlaceholder("minecraft:husbandry/axolotl_in_a_bucket"));
            DracolotlBucketGet.display(
                    new ItemStack(ModItems.BUCKET_OF_DRACOLOTL.get()), //Icon
                    Component.translatable("advancements.dracolotl_bucket_get.title"),        //Title
                    Component.translatable("advancements.dracolotl_bucket_get.description"),  //Description
                    null, //Should be null unless this is a root advancement
                    AdvancementType.GOAL,
                    true,
                    true,
                    true
            );
            DracolotlBucketGet.addCriterion("has_dracolotl_bucket", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.BUCKET_OF_DRACOLOTL.get()));
            DracolotlBucketGet.requirements(AdvancementRequirements.allOf(List.of("has_dracolotl_bucket")));
            DracolotlBucketGet.save(saver, ResourceLocation.fromNamespaceAndPath("dracolotl", "dracolotl_bucket_get"), existingFileHelper);




        }
    }
}
