package com.fizzware.dramaticdoors;

import com.fizzware.dramaticdoors.blocks.DramaticDoorsBlocks;
import com.fizzware.dramaticdoors.blocks.TallDoorBlock;
import com.fizzware.dramaticdoors.crafting.conditions.AtmosphericModInstalledCondition;
import com.fizzware.dramaticdoors.crafting.conditions.AutumnityModInstalledCondition;
import com.fizzware.dramaticdoors.crafting.conditions.BambooBlocksModInstalledCondition;
import com.fizzware.dramaticdoors.crafting.conditions.BuzzierBeesModInstalledCondition;
import com.fizzware.dramaticdoors.crafting.conditions.EndergeticModInstalledCondition;
import com.fizzware.dramaticdoors.crafting.conditions.EnvironmentalModInstalledCondition;
import com.fizzware.dramaticdoors.crafting.conditions.UpgradeAquaticModInstalledCondition;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
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
    	CraftingHelper.register(new AtmosphericModInstalledCondition.Serializer());
    	CraftingHelper.register(new AutumnityModInstalledCondition.Serializer());
    	CraftingHelper.register(new BambooBlocksModInstalledCondition.Serializer());
    	CraftingHelper.register(new BuzzierBeesModInstalledCondition.Serializer());
    	CraftingHelper.register(new EndergeticModInstalledCondition.Serializer());
    	CraftingHelper.register(new EnvironmentalModInstalledCondition.Serializer());
    	CraftingHelper.register(new UpgradeAquaticModInstalledCondition.Serializer());
    }

    public static final ItemGroup TAB = ItemGroup.TAB_REDSTONE;

    private void doClientStuff(final FMLClientSetupEvent event) {
        // Setup Render Types (mainly for transparent doors like Acacia and Jungle)
        for (Block doorBlock : DramaticDoorsBlocks.getBlockList(DramaticDoorsBlocks.DoorSeries.VANILLA_TALL)) {
            RenderTypeLookup.setRenderLayer(doorBlock, RenderType.cutout());
            LOGGER.debug(doorBlock.getRegistryName());
        }
        //Conditionally add items based on whether mods are loaded.
        if (ModList.get().isLoaded("atmospheric")) {
            for (Block doorBlock : DramaticDoorsBlocks.getBlockList(DramaticDoorsBlocks.DoorSeries.ATMOSPHERIC_TALL)) {
                RenderTypeLookup.setRenderLayer(doorBlock, RenderType.cutout());
            }
        }
        if (ModList.get().isLoaded("autumnity")) {
            for (Block doorBlock : DramaticDoorsBlocks.getBlockList(DramaticDoorsBlocks.DoorSeries.AUTUMNITY_TALL)) {
                RenderTypeLookup.setRenderLayer(doorBlock, RenderType.cutout());
            }
        }
        if (ModList.get().isLoaded("bamboo_blocks")) {
            for (Block doorBlock : DramaticDoorsBlocks.getBlockList(DramaticDoorsBlocks.DoorSeries.BAMBOO_TALL)) {
                RenderTypeLookup.setRenderLayer(doorBlock, RenderType.cutout());
            }
        }
        if (ModList.get().isLoaded("buzzier_bees")) {
            for (Block doorBlock : DramaticDoorsBlocks.getBlockList(DramaticDoorsBlocks.DoorSeries.BUZZIER_TALL)) {
                RenderTypeLookup.setRenderLayer(doorBlock, RenderType.cutout());
            }
        }
        if (ModList.get().isLoaded("endergetic")) {
            for (Block doorBlock : DramaticDoorsBlocks.getBlockList(DramaticDoorsBlocks.DoorSeries.ENDERGETIC_TALL)) {
                RenderTypeLookup.setRenderLayer(doorBlock, RenderType.cutout());
            }
        }
        if (ModList.get().isLoaded("environmental")) {
            for (Block doorBlock : DramaticDoorsBlocks.getBlockList(DramaticDoorsBlocks.DoorSeries.ENVIRONMENTAL_TALL)) {
                RenderTypeLookup.setRenderLayer(doorBlock, RenderType.cutout());
            }
        }
        if (ModList.get().isLoaded("upgrade_aquatic")) {
            for (Block doorBlock : DramaticDoorsBlocks.getBlockList(DramaticDoorsBlocks.DoorSeries.UPGRADE_AQUATIC_TALL)) {
                RenderTypeLookup.setRenderLayer(doorBlock, RenderType.cutout());
            }
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
