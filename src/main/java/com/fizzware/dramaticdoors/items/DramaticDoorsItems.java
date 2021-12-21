package com.fizzware.dramaticdoors.items;

import com.fizzware.dramaticdoors.DramaticDoors;
import com.fizzware.dramaticdoors.blocks.TallDoorBlock;
import com.fizzware.dramaticdoors.blocks.DramaticDoorsBlocks;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ObjectHolder;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
@ObjectHolder(DramaticDoors.MOD_ID)
public class DramaticDoorsItems {

    private static final Item.Properties PROPERTIES = new Item.Properties();
    
    @SubscribeEvent
    public static void registerItems(final RegistryEvent.Register<Item> itemRegistry) {
        itemRegistry.getRegistry().registerAll(
            new BlockItem(DramaticDoorsBlocks.TALL_OAK_DOOR, PROPERTIES.tab(DramaticDoors.TAB)).setRegistryName(new ResourceLocation(DramaticDoors.MOD_ID, TallDoorBlock.NAME_OAK)),
            new BlockItem(DramaticDoorsBlocks.TALL_SPRUCE_DOOR, PROPERTIES.tab(DramaticDoors.TAB)).setRegistryName(new ResourceLocation(DramaticDoors.MOD_ID, TallDoorBlock.NAME_SPRUCE)),
            new BlockItem(DramaticDoorsBlocks.TALL_BIRCH_DOOR, PROPERTIES.tab(DramaticDoors.TAB)).setRegistryName(new ResourceLocation(DramaticDoors.MOD_ID, TallDoorBlock.NAME_BIRCH)),
            new BlockItem(DramaticDoorsBlocks.TALL_JUNGLE_DOOR, PROPERTIES.tab(DramaticDoors.TAB)).setRegistryName(new ResourceLocation(DramaticDoors.MOD_ID, TallDoorBlock.NAME_JUNGLE)),
            new BlockItem(DramaticDoorsBlocks.TALL_ACACIA_DOOR, PROPERTIES.tab(DramaticDoors.TAB)).setRegistryName(new ResourceLocation(DramaticDoors.MOD_ID, TallDoorBlock.NAME_ACACIA)),
            new BlockItem(DramaticDoorsBlocks.TALL_DARK_OAK_DOOR, PROPERTIES.tab(DramaticDoors.TAB)).setRegistryName(new ResourceLocation(DramaticDoors.MOD_ID, TallDoorBlock.NAME_DARK_OAK)),
            new BlockItem(DramaticDoorsBlocks.TALL_IRON_DOOR, PROPERTIES.tab(DramaticDoors.TAB)).setRegistryName(new ResourceLocation(DramaticDoors.MOD_ID, TallDoorBlock.NAME_IRON)),
            new BlockItem(DramaticDoorsBlocks.TALL_CRIMSON_DOOR, PROPERTIES.tab(DramaticDoors.TAB)).setRegistryName(new ResourceLocation(DramaticDoors.MOD_ID, TallDoorBlock.NAME_CRIMSON)),
            new BlockItem(DramaticDoorsBlocks.TALL_WARPED_DOOR, PROPERTIES.tab(DramaticDoors.TAB)).setRegistryName(new ResourceLocation(DramaticDoors.MOD_ID, TallDoorBlock.NAME_WARPED))
        );
        //Conditionally add items based on whether mods are loaded.
        itemRegistry.getRegistry().registerAll(
            new BlockItem(DramaticDoorsBlocks.TALL_BOP_CHERRY_DOOR, conditionalTabProperties("biomesoplenty")).setRegistryName(new ResourceLocation(DramaticDoors.MOD_ID, TallDoorBlock.NAME_BOP_CHERRY)),
            new BlockItem(DramaticDoorsBlocks.TALL_BOP_DEAD_DOOR, conditionalTabProperties("biomesoplenty")).setRegistryName(new ResourceLocation(DramaticDoors.MOD_ID, TallDoorBlock.NAME_BOP_DEAD)),
            new BlockItem(DramaticDoorsBlocks.TALL_BOP_FIR_DOOR, conditionalTabProperties("biomesoplenty")).setRegistryName(new ResourceLocation(DramaticDoors.MOD_ID, TallDoorBlock.NAME_BOP_FIR)),
            new BlockItem(DramaticDoorsBlocks.TALL_BOP_HELLBARK_DOOR, conditionalTabProperties("biomesoplenty")).setRegistryName(new ResourceLocation(DramaticDoors.MOD_ID, TallDoorBlock.NAME_BOP_HELLBARK)),
            new BlockItem(DramaticDoorsBlocks.TALL_BOP_JACARANDA_DOOR, conditionalTabProperties("biomesoplenty")).setRegistryName(new ResourceLocation(DramaticDoors.MOD_ID, TallDoorBlock.NAME_BOP_JACARANDA)),
            new BlockItem(DramaticDoorsBlocks.TALL_BOP_MAGIC_DOOR, conditionalTabProperties("biomesoplenty")).setRegistryName(new ResourceLocation(DramaticDoors.MOD_ID, TallDoorBlock.NAME_BOP_MAGIC)),
            new BlockItem(DramaticDoorsBlocks.TALL_BOP_MAHOGANY_DOOR, conditionalTabProperties("biomesoplenty")).setRegistryName(new ResourceLocation(DramaticDoors.MOD_ID, TallDoorBlock.NAME_BOP_MAHOGANY)),
            new BlockItem(DramaticDoorsBlocks.TALL_BOP_PALM_DOOR, conditionalTabProperties("biomesoplenty")).setRegistryName(new ResourceLocation(DramaticDoors.MOD_ID, TallDoorBlock.NAME_BOP_PALM)),
            new BlockItem(DramaticDoorsBlocks.TALL_BOP_REDWOOD_DOOR, conditionalTabProperties("biomesoplenty")).setRegistryName(new ResourceLocation(DramaticDoors.MOD_ID, TallDoorBlock.NAME_BOP_REDWOOD)),
            new BlockItem(DramaticDoorsBlocks.TALL_BOP_UMBRAN_DOOR, conditionalTabProperties("biomesoplenty")).setRegistryName(new ResourceLocation(DramaticDoors.MOD_ID, TallDoorBlock.NAME_BOP_UMBRAN)),
            new BlockItem(DramaticDoorsBlocks.TALL_BOP_WILLOW_DOOR, conditionalTabProperties("biomesoplenty")).setRegistryName(new ResourceLocation(DramaticDoors.MOD_ID, TallDoorBlock.NAME_BOP_WILLOW)),

        	new BlockItem(DramaticDoorsBlocks.TALL_CANOPY_DOOR, conditionalTabProperties("twilightforest")).setRegistryName(new ResourceLocation(DramaticDoors.MOD_ID, TallDoorBlock.NAME_CANOPY)),
        	new BlockItem(DramaticDoorsBlocks.TALL_DARKWOOD_DOOR, conditionalTabProperties("twilightforest")).setRegistryName(new ResourceLocation(DramaticDoors.MOD_ID, TallDoorBlock.NAME_DARKWOOD)),
        	new BlockItem(DramaticDoorsBlocks.TALL_MANGROVE_DOOR, conditionalTabProperties("twilightforest")).setRegistryName(new ResourceLocation(DramaticDoors.MOD_ID, TallDoorBlock.NAME_MANGROVE)),
        	new BlockItem(DramaticDoorsBlocks.TALL_MINEWOOD_DOOR, conditionalTabProperties("twilightforest")).setRegistryName(new ResourceLocation(DramaticDoors.MOD_ID, TallDoorBlock.NAME_MINEWOOD)),
        	new BlockItem(DramaticDoorsBlocks.TALL_SORTINGWOOD_DOOR, conditionalTabProperties("twilightforest")).setRegistryName(new ResourceLocation(DramaticDoors.MOD_ID, TallDoorBlock.NAME_SORTINGWOOD)),
        	new BlockItem(DramaticDoorsBlocks.TALL_TIMEWOOD_DOOR, conditionalTabProperties("twilightforest")).setRegistryName(new ResourceLocation(DramaticDoors.MOD_ID, TallDoorBlock.NAME_TIMEWOOD)),
        	new BlockItem(DramaticDoorsBlocks.TALL_TRANSWOOD_DOOR, conditionalTabProperties("twilightforest")).setRegistryName(new ResourceLocation(DramaticDoors.MOD_ID, TallDoorBlock.NAME_TRANSWOOD)),
        	new BlockItem(DramaticDoorsBlocks.TALL_TWILIGHT_OAK_DOOR, conditionalTabProperties("twilightforest")).setRegistryName(new ResourceLocation(DramaticDoors.MOD_ID, TallDoorBlock.NAME_TWILIGHT_OAK)),
            
            new BlockItem(DramaticDoorsBlocks.TALL_ASPEN_DOOR, conditionalTabProperties("atmospheric")).setRegistryName(new ResourceLocation(DramaticDoors.MOD_ID, TallDoorBlock.NAME_ASPEN)),
            new BlockItem(DramaticDoorsBlocks.TALL_GRIMWOOD_DOOR, conditionalTabProperties("atmospheric")).setRegistryName(new ResourceLocation(DramaticDoors.MOD_ID, TallDoorBlock.NAME_GRIMWOOD)),
            new BlockItem(DramaticDoorsBlocks.TALL_KOUSA_DOOR, conditionalTabProperties("atmospheric")).setRegistryName(new ResourceLocation(DramaticDoors.MOD_ID, TallDoorBlock.NAME_KOUSA)),
            new BlockItem(DramaticDoorsBlocks.TALL_MORADO_DOOR, conditionalTabProperties("atmospheric")).setRegistryName(new ResourceLocation(DramaticDoors.MOD_ID, TallDoorBlock.NAME_MORADO)),
            new BlockItem(DramaticDoorsBlocks.TALL_ROSEWOOD_DOOR, conditionalTabProperties("atmospheric")).setRegistryName(new ResourceLocation(DramaticDoors.MOD_ID, TallDoorBlock.NAME_ROSEWOOD)),
            new BlockItem(DramaticDoorsBlocks.TALL_YUCCA_DOOR, conditionalTabProperties("atmospheric")).setRegistryName(new ResourceLocation(DramaticDoors.MOD_ID, TallDoorBlock.NAME_YUCCA)),
            
            new BlockItem(DramaticDoorsBlocks.TALL_MAPLE_DOOR, conditionalTabProperties("autumnity")).setRegistryName(new ResourceLocation(DramaticDoors.MOD_ID, TallDoorBlock.NAME_MAPLE)),
            
            new BlockItem(DramaticDoorsBlocks.TALL_BAMBOO_DOOR, conditionalTabProperties("bamboo_blocks")).setRegistryName(new ResourceLocation(DramaticDoors.MOD_ID, TallDoorBlock.NAME_BAMBOO)),
            
            new BlockItem(DramaticDoorsBlocks.TALL_HONEYCOMB_DOOR, conditionalTabProperties("buzzier_bees")).setRegistryName(new ResourceLocation(DramaticDoors.MOD_ID, TallDoorBlock.NAME_HONEYCOMB)),
            
            new BlockItem(DramaticDoorsBlocks.TALL_POISE_DOOR, conditionalTabProperties("endergetic")).setRegistryName(new ResourceLocation(DramaticDoors.MOD_ID, TallDoorBlock.NAME_POISE)),
            
            new BlockItem(DramaticDoorsBlocks.TALL_CHERRY_DOOR, conditionalTabProperties("environmental")).setRegistryName(new ResourceLocation(DramaticDoors.MOD_ID, TallDoorBlock.NAME_CHERRY)),
            new BlockItem(DramaticDoorsBlocks.TALL_WILLOW_DOOR, conditionalTabProperties("environmental")).setRegistryName(new ResourceLocation(DramaticDoors.MOD_ID, TallDoorBlock.NAME_WILLOW)),
            new BlockItem(DramaticDoorsBlocks.TALL_WISTERIA_DOOR, conditionalTabProperties("environmental")).setRegistryName(new ResourceLocation(DramaticDoors.MOD_ID, TallDoorBlock.NAME_WISTERIA)),
            
            new BlockItem(DramaticDoorsBlocks.TALL_DRIFTWOOD_DOOR, conditionalTabProperties("upgrade_aquatic")).setRegistryName(new ResourceLocation(DramaticDoors.MOD_ID, TallDoorBlock.NAME_DRIFTWOOD)),
            new BlockItem(DramaticDoorsBlocks.TALL_RIVER_DOOR, conditionalTabProperties("upgrade_aquatic")).setRegistryName(new ResourceLocation(DramaticDoors.MOD_ID, TallDoorBlock.NAME_RIVER)),
            new BlockItem(DramaticDoorsBlocks.TALL_GLASS_DOOR, conditionalTabProperties("upgrade_aquatic")).setRegistryName(new ResourceLocation(DramaticDoors.MOD_ID, TallDoorBlock.NAME_GLASS)),
            new BlockItem(DramaticDoorsBlocks.TALL_TOOTH_DOOR, conditionalTabProperties("upgrade_aquatic")).setRegistryName(new ResourceLocation(DramaticDoors.MOD_ID, TallDoorBlock.NAME_TOOTH)),

            new BlockItem(DramaticDoorsBlocks.TALL_JACARANDA_DOOR, conditionalTabProperties("abundance")).setRegistryName(new ResourceLocation(DramaticDoors.MOD_ID, TallDoorBlock.NAME_JACARANDA)),
            new BlockItem(DramaticDoorsBlocks.TALL_REDBUD_DOOR, conditionalTabProperties("abundance")).setRegistryName(new ResourceLocation(DramaticDoors.MOD_ID, TallDoorBlock.NAME_REDBUD)),

            new BlockItem(DramaticDoorsBlocks.TALL_CYPRESS_DOOR, conditionalTabProperties("bayou_blues")).setRegistryName(new ResourceLocation(DramaticDoors.MOD_ID, TallDoorBlock.NAME_CYPRESS)),

            new BlockItem(DramaticDoorsBlocks.TALL_BROWN_MUSHROOM_DOOR, conditionalTabProperties("enhanced_mushrooms")).setRegistryName(new ResourceLocation(DramaticDoors.MOD_ID, TallDoorBlock.NAME_BROWN_MUSHROOM)),
            new BlockItem(DramaticDoorsBlocks.TALL_RED_MUSHROOM_DOOR, conditionalTabProperties("enhanced_mushrooms")).setRegistryName(new ResourceLocation(DramaticDoors.MOD_ID, TallDoorBlock.NAME_RED_MUSHROOM)),
            new BlockItem(DramaticDoorsBlocks.TALL_GLOWSHROOM_DOOR, conditionalTabProperties("enhanced_mushrooms")).setRegistryName(new ResourceLocation(DramaticDoors.MOD_ID, TallDoorBlock.NAME_GLOWSHROOM)),
            
            new BlockItem(DramaticDoorsBlocks.TALL_PETRIFIED_DOOR, conditionalTabProperties("darkerdepths")).setRegistryName(new ResourceLocation(DramaticDoors.MOD_ID, TallDoorBlock.NAME_PETRIFIED)),
            
            new BlockItem(DramaticDoorsBlocks.TALL_CARDBOARD_DOOR, conditionalTabProperties("dustrial_decor")).setRegistryName(new ResourceLocation(DramaticDoors.MOD_ID, TallDoorBlock.NAME_CARDBOARD)),
            new BlockItem(DramaticDoorsBlocks.TALL_CHAIN_DOOR, conditionalTabProperties("dustrial_decor")).setRegistryName(new ResourceLocation(DramaticDoors.MOD_ID, TallDoorBlock.NAME_CHAIN)),
            new BlockItem(DramaticDoorsBlocks.TALL_INDUSTRIAL_IRON_DOOR, conditionalTabProperties("dustrial_decor")).setRegistryName(new ResourceLocation(DramaticDoors.MOD_ID, TallDoorBlock.NAME_INDUSTRIAL_IRON)),
            new BlockItem(DramaticDoorsBlocks.TALL_IRON_BAR_DOOR, conditionalTabProperties("dustrial_decor")).setRegistryName(new ResourceLocation(DramaticDoors.MOD_ID, TallDoorBlock.NAME_IRON_BAR)),
            new BlockItem(DramaticDoorsBlocks.TALL_PADDED_DOOR, conditionalTabProperties("dustrial_decor")).setRegistryName(new ResourceLocation(DramaticDoors.MOD_ID, TallDoorBlock.NAME_PADDED)),
            new BlockItem(DramaticDoorsBlocks.TALL_RUSTY_IRON_DOOR, conditionalTabProperties("dustrial_decor")).setRegistryName(new ResourceLocation(DramaticDoors.MOD_ID, TallDoorBlock.NAME_RUSTY_IRON)),
            new BlockItem(DramaticDoorsBlocks.TALL_RUSTY_SHEET_METAL_DOOR, conditionalTabProperties("dustrial_decor")).setRegistryName(new ResourceLocation(DramaticDoors.MOD_ID, TallDoorBlock.NAME_RUSTY_SHEET_METAL)),
            new BlockItem(DramaticDoorsBlocks.TALL_SHEET_METAL_DOOR, conditionalTabProperties("dustrial_decor")).setRegistryName(new ResourceLocation(DramaticDoors.MOD_ID, TallDoorBlock.NAME_SHEET_METAL)),
            
            new BlockItem(DramaticDoorsBlocks.TALL_FAIRY_RING_MUSHROOM_DOOR, conditionalTabProperties("habitat")).setRegistryName(new ResourceLocation(DramaticDoors.MOD_ID, TallDoorBlock.NAME_FAIRY_RING_MUSHROOM)),

            new BlockItem(DramaticDoorsBlocks.TALL_AZURE_DOOR, conditionalTabProperties("outer_end")).setRegistryName(new ResourceLocation(DramaticDoors.MOD_ID, TallDoorBlock.NAME_AZURE)),
            
            new BlockItem(DramaticDoorsBlocks.TALL_GOLD_DOOR, conditionalTabProperties("supplementaries")).setRegistryName(new ResourceLocation(DramaticDoors.MOD_ID, TallDoorBlock.NAME_GOLD)),
            new BlockItem(DramaticDoorsBlocks.TALL_NETHERITE_DOOR, conditionalTabProperties("supplementaries")).setRegistryName(new ResourceLocation(DramaticDoors.MOD_ID, TallDoorBlock.NAME_NETHERITE))
        );
    }

    private static Item.Properties conditionalTabProperties(String modid) {
    	return ModList.get().isLoaded(modid) ? PROPERTIES.tab(DramaticDoors.TAB) : PROPERTIES.tab(null);
    }

}
