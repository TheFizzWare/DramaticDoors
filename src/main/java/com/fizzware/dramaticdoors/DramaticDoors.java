package com.fizzware.dramaticdoors;

import com.fizzware.dramaticdoors.blocks.DramaticDoorsBlocks;
import com.fizzware.dramaticdoors.items.DramaticDoorsItems;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod("dramaticdoors")
public class DramaticDoors {

    public static final String MOD_ID = "dramaticdoors";
    private static final Logger LOGGER = LogManager.getLogger();

    public DramaticDoors() {
        MinecraftForge.EVENT_BUS.register(this);
    }

    public static final ItemGroup TAB = ItemGroup.REDSTONE;

}
