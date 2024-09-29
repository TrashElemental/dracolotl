package net.trashelemental.dracolotl.entity;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.trashelemental.dracolotl.dracolotl;
import net.trashelemental.dracolotl.entity.custom.DracolotlEntity;

@EventBusSubscriber(modid = dracolotl.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class ModEntityClientEvents {


    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {

        event.put(ModEntities.DRACOLOTL.get(), DracolotlEntity.createAttributes().build());

    }


    //public static final ModelLayerLocation DRACOLOTL_LAYER = new ModelLayerLocation(
    //        dracolotl.prefix("dracolotl_layer"), "main");



    @SubscribeEvent
    public static void registerLayer(EntityRenderersEvent.RegisterLayerDefinitions event) {

       // event.registerLayerDefinition(DRACOLOTL_LAYER, DracolotlModel::createBodyLayer);

    }


}
