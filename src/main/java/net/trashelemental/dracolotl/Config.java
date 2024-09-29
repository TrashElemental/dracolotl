package net.trashelemental.dracolotl;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.config.ModConfigEvent;
import net.neoforged.neoforge.common.ModConfigSpec;

@EventBusSubscriber(modid = dracolotl.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class Config {
    private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();

//    private static final ModConfigSpec.BooleanValue DRACOLOTL_BUCKET_RECIPE = BUILDER
//            .comment("Should Buckets of Dracolotl be craftable?")
//            .define("showSpecialRecipe", false);

    static final ModConfigSpec SPEC = BUILDER.build();

    public static boolean DracolotlBucketRecipe;

    @SubscribeEvent
    static void onLoad(final ModConfigEvent event) {
        if (event.getConfig().getSpec() == SPEC) {
           // DracolotlBucketRecipe = DRACOLOTL_BUCKET_RECIPE.get();
        }
    }
}
