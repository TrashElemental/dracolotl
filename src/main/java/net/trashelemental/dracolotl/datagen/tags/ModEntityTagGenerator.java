package net.trashelemental.dracolotl.datagen.tags;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.EntityTypeTagsProvider;
import net.minecraft.tags.EntityTypeTags;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.trashelemental.dracolotl.dracolotl;
import net.trashelemental.dracolotl.entity.ModEntities;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModEntityTagGenerator extends EntityTypeTagsProvider {
    public ModEntityTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> provider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, provider, dracolotl.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {

        this.tag(EntityTypeTags.CAN_BREATHE_UNDER_WATER)
                .add(ModEntities.DRACOLOTL.get());

        this.tag(EntityTypeTags.FALL_DAMAGE_IMMUNE)
                .add(ModEntities.DRACOLOTL.get());


    }



}
