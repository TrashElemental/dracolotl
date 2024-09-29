package net.trashelemental.dracolotl.datagen;

import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.FrameType;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.core.HolderLookup;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.ForgeAdvancementProvider;
import net.trashelemental.dracolotl.dracolotl;
import net.trashelemental.dracolotl.item.ModItems;

import java.util.function.Consumer;

public class ModAdvancementGenerator implements ForgeAdvancementProvider.AdvancementGenerator {

    @Override
    public void generate(HolderLookup.Provider registries, Consumer<Advancement> writer, ExistingFileHelper existingFileHelper) {

        Advancement DracolotlBucketGet = Advancement.Builder.advancement()
                .display(
                        ModItems.BUCKET_OF_DRACOLOTL.get(),
                        Component.translatable("advancements.dracolotl_bucket_get.title"),
                        Component.translatable("advancements.dracolotl_bucket_get.description"),
                        new ResourceLocation("textures/gui/advancements/backgrounds/stone.png"),
                        FrameType.CHALLENGE,
                        true,
                        true,
                        true
                )
                .parent(new ResourceLocation("minecraft:husbandry/axolotl_in_a_bucket"))
                .addCriterion("has_dracolotl_bucket", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.BUCKET_OF_DRACOLOTL.get()))
                .save(writer, new ResourceLocation(dracolotl.MOD_ID, "dracolotl_bucket_get"), existingFileHelper);

    }
}
