package com.fizzware.dramaticdoors;

import com.fizzware.dramaticdoors.client.ClientRenderer;
import com.fizzware.dramaticdoors.crafting.conditions.AbundanceModInstalledCondition;
import com.fizzware.dramaticdoors.crafting.conditions.AtmosphericModInstalledCondition;
import com.fizzware.dramaticdoors.crafting.conditions.AutumnityModInstalledCondition;
import com.fizzware.dramaticdoors.crafting.conditions.BambooBlocksModInstalledCondition;
import com.fizzware.dramaticdoors.crafting.conditions.BayouBluesModInstalledCondition;
import com.fizzware.dramaticdoors.crafting.conditions.BiomesOPlentyModInstalledCondition;
import com.fizzware.dramaticdoors.crafting.conditions.BuzzierBeesModInstalledCondition;
import com.fizzware.dramaticdoors.crafting.conditions.EndergeticModInstalledCondition;
import com.fizzware.dramaticdoors.crafting.conditions.EnhancedMushroomsModInstalledCondition;
import com.fizzware.dramaticdoors.crafting.conditions.EnvironmentalModInstalledCondition;
import com.fizzware.dramaticdoors.crafting.conditions.OuterEndModInstalledCondition;
import com.fizzware.dramaticdoors.crafting.conditions.TwilightForestModInstalledCondition;
import com.fizzware.dramaticdoors.crafting.conditions.UpgradeAquaticModInstalledCondition;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fmlserverevents.FMLServerStartingEvent;


@Mod("dramaticdoors")
public class DramaticDoors
{
    public static final String MOD_ID = "dramaticdoors";

    public DramaticDoors() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () -> { FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setupClient); });

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event)
    {
    	CraftingHelper.register(new BiomesOPlentyModInstalledCondition.Serializer());
    	CraftingHelper.register(new TwilightForestModInstalledCondition.Serializer());
    	
    	CraftingHelper.register(new AtmosphericModInstalledCondition.Serializer());
    	CraftingHelper.register(new AutumnityModInstalledCondition.Serializer());
    	CraftingHelper.register(new BambooBlocksModInstalledCondition.Serializer());
    	CraftingHelper.register(new BuzzierBeesModInstalledCondition.Serializer());
    	CraftingHelper.register(new EndergeticModInstalledCondition.Serializer());
    	CraftingHelper.register(new EnvironmentalModInstalledCondition.Serializer());
    	CraftingHelper.register(new UpgradeAquaticModInstalledCondition.Serializer());
    	
    	CraftingHelper.register(new AbundanceModInstalledCondition.Serializer());
    	CraftingHelper.register(new BayouBluesModInstalledCondition.Serializer());
    	CraftingHelper.register(new EnhancedMushroomsModInstalledCondition.Serializer());
    	
    	CraftingHelper.register(new OuterEndModInstalledCondition.Serializer());
    }

    public static final CreativeModeTab TAB = CreativeModeTab.TAB_REDSTONE;

    private void setupClient(final FMLClientSetupEvent event) {
    	ClientRenderer.setRenderers();
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
