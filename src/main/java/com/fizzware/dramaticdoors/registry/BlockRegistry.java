package com.fizzware.dramaticdoors.registry;

import com.fizzware.dramaticdoors.compat.ModCompatModule;
import com.fizzware.dramaticdoors.init.DoorMaterial.DoorGroup;
import net.minecraft.block.Block;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.registries.IForgeRegistry;



@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class BlockRegistry {

    @SubscribeEvent
    public static void registerBlocks(final Register<Block> event)
    {
        IForgeRegistry<Block> blockRegistry = event.getRegistry();
        registerVanilla(blockRegistry);
        for (String mod_id : ModCompatModule.getRegistryMods()) {
            registerModDoors(blockRegistry, mod_id);
        }
    }

    public static void registerVanilla(IForgeRegistry<Block> blockRegistry) {
        blockRegistry.registerAll(DoorGroup.VANILLA.getGroupBlocks());
    }

    public static void registerModDoors(IForgeRegistry<Block> blockRegistry, String mod_id) {
        if (!ModCompatModule.getByModId(mod_id).isDisabled()) {
            blockRegistry.registerAll(DoorGroup.getByModId(mod_id).getGroupBlocks());
        }
    }

}
