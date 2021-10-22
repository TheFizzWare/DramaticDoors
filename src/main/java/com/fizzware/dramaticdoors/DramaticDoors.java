package com.fizzware.dramaticdoors;

import com.fizzware.dramaticdoors.blocks.DramaticDoorsBlocks;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fmlserverevents.FMLServerStartingEvent;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod("dramaticdoors")
public class DramaticDoors
{
    public static final String MOD_ID = "dramaticdoors";
    private static final Logger LOGGER = LogManager.getLogger();

    public DramaticDoors() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event)
    {
    }

    public static final CreativeModeTab TAB = CreativeModeTab.TAB_REDSTONE;

    private void doClientStuff(final FMLClientSetupEvent event) {
        // Setup Render Types (mainly for transparent doors like Acacia and Jungle)
        for (Block doorBlock : DramaticDoorsBlocks.getBlockList(DramaticDoorsBlocks.DoorSeries.VANILLA_TALL)) {
            ItemBlockRenderTypes.setRenderLayer(doorBlock, RenderType.cutout());
            LOGGER.debug(doorBlock.getRegistryName());
        }
    }

    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) {
    }

    @Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {
        @SubscribeEvent
        public static void onBlocksRegistry(final RegistryEvent.Register<Block> blockRegistryEvent) {
        }
    }
}
