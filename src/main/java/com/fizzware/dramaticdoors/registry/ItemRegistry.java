package com.fizzware.dramaticdoors.registry;

import com.fizzware.dramaticdoors.compat.ModCompatModule;
import com.fizzware.dramaticdoors.init.DoorMaterial.DoorGroup;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.registries.IForgeRegistry;


@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class ItemRegistry {

    @SubscribeEvent
    public static void registerItems(final Register<Item> event)
    {
        IForgeRegistry<Item> itemRegistry = event.getRegistry();
        registerVanilla(itemRegistry);
        for (String mod_id : ModCompatModule.getRegistryMods()) {
            registerModDoors(itemRegistry, mod_id);
        }
    }

    public static void registerVanilla(IForgeRegistry<Item> itemRegistry) {
        itemRegistry.registerAll(DoorGroup.VANILLA.getGroupItems());
    }

    public static void registerModDoors(IForgeRegistry<Item> itemRegistry, String mod_id) {
        if (!ModCompatModule.getByModId(mod_id).isDisabled()) {
            itemRegistry.registerAll(DoorGroup.getByModId(mod_id).getGroupItems());
        }
    }

}
