package net.trashelemental.infested.item.armor;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.trashelemental.infested.InfestedSwarmsAndSpiders;
import net.trashelemental.infested.item.armor.models.ChitinArmorModel;
import net.trashelemental.infested.item.armor.models.SpiderArmorModel;

@EventBusSubscriber(modid = InfestedSwarmsAndSpiders.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class ModArmorModels {

    @SubscribeEvent
    public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {

        event.registerLayerDefinition(ChitinArmorModel.LAYER_LOCATION, ChitinArmorModel::createBodyLayer);
        event.registerLayerDefinition(SpiderArmorModel.LAYER_LOCATION, SpiderArmorModel::createBodyLayer);

    }
}
