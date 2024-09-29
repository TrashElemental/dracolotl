package net.trashelemental.dracolotl.datagen;

import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.GlobalLootModifierProvider;
import net.trashelemental.dracolotl.dracolotl;

public class ModGlobalLootModifiersProvider extends GlobalLootModifierProvider {
    public ModGlobalLootModifiersProvider(PackOutput output) {
        super(output, dracolotl.MOD_ID);
    }


    @Override
    protected void start() {


    }
}
