package net.trashelemental.infested.datagen.tags;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.EntityTypeTagsProvider;
import net.minecraft.tags.EntityTypeTags;
import net.minecraft.world.entity.EntityType;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.trashelemental.infested.InfestedSwarmsAndSpiders;
import net.trashelemental.infested.entity.ModEntities;
import net.trashelemental.infested.util.ModTags;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModEntityTagGenerator extends EntityTypeTagsProvider {
    public ModEntityTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> provider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, provider, InfestedSwarmsAndSpiders.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {


        this.tag(EntityTypeTags.ARTHROPOD)
                .add(ModEntities.GRUB.get())
                .add(ModEntities.CRIMSON_BEETLE.get())
                .add(ModEntities.MANTIS.get())
                .add(ModEntities.ORCHID_MANTIS.get())
                .add(ModEntities.BRILLIANT_BEETLE.get())

                .add(ModEntities.HARVEST_BEETLE.get())
                .add(ModEntities.JEWEL_BEETLE.get())
                .add(ModEntities.CHORUS_BEETLE.get())
                .add(ModEntities.ANCIENT_DEBREETLE.get())

                .add(ModEntities.ATTACK_SILVERFISH.get())
                .add(ModEntities.SILVERFISH_MINION.get())
                .add(ModEntities.ATTACK_SPIDER.get())
                .add(ModEntities.SPIDER_MINION.get())
                .add(ModEntities.TAMED_SPIDER.get());

        this.tag(ModTags.EntityTags.MANTIS_PREY).add(
                EntityType.SPIDER,
                EntityType.CAVE_SPIDER,
                EntityType.SILVERFISH,
                EntityType.ENDERMITE,
                ModEntities.GRUB.get(),
                ModEntities.CRIMSON_BEETLE.get(),
                ModEntities.ANCIENT_DEBREETLE.get(),
                ModEntities.CHORUS_BEETLE.get(),
                ModEntities.HARVEST_BEETLE.get(),
                ModEntities.JEWEL_BEETLE.get(),
                ModEntities.BRILLIANT_BEETLE.get()
        );


    }



}
