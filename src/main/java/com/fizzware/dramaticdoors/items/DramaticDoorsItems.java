package com.fizzware.dramaticdoors.items;

import com.fizzware.dramaticdoors.DramaticDoors;
import com.fizzware.dramaticdoors.blocks.TallDoorBlock;
import com.fizzware.dramaticdoors.blocks.DramaticDoorsBlocks;

import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ObjectHolder;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
@ObjectHolder(DramaticDoors.MOD_ID)
public class DramaticDoorsItems {

    private static final Item.Properties PROPERTIES = new Item.Properties().tab(DramaticDoors.TAB);

    @ObjectHolder(TallDoorBlock.NAME_OAK) public static final Item TALL_OAK_DOOR = null;
    @ObjectHolder(TallDoorBlock.NAME_SPRUCE) public static final Item TALL_SPRUCE_DOOR = null;
    @ObjectHolder(TallDoorBlock.NAME_BIRCH) public static final Item TALL_BIRCH_DOOR = null;
    @ObjectHolder(TallDoorBlock.NAME_JUNGLE) public static final Item TALL_JUNGLE_DOOR = null;
    @ObjectHolder(TallDoorBlock.NAME_ACACIA) public static final Item TALL_ACACIA_DOOR = null;
    @ObjectHolder(TallDoorBlock.NAME_DARK_OAK) public static final Item TALL_DARK_OAK_DOOR = null;
    @ObjectHolder(TallDoorBlock.NAME_IRON) public static final Item TALL_IRON_DOOR = null;
    @ObjectHolder(TallDoorBlock.NAME_CRIMSON) public static final Item TALL_CRIMSON_DOOR = null;
    @ObjectHolder(TallDoorBlock.NAME_WARPED) public static final Item TALL_WARPED_DOOR = null;
    
    //Atmospheric
    @ObjectHolder(TallDoorBlock.NAME_ASPEN) public static final Item TALL_ASPEN_DOOR = null;
    @ObjectHolder(TallDoorBlock.NAME_GRIMWOOD) public static final Item TALL_GRIMWOOD_DOOR = null;
    @ObjectHolder(TallDoorBlock.NAME_KOUSA) public static final Item TALL_KOUSA_DOOR = null;
    @ObjectHolder(TallDoorBlock.NAME_MORADO) public static final Item TALL_MORADO_DOOR = null;
    @ObjectHolder(TallDoorBlock.NAME_ROSEWOOD) public static final Item TALL_ROSEWOOD_DOOR = null;
    @ObjectHolder(TallDoorBlock.NAME_YUCCA) public static final Item TALL_YUCCA_DOOR = null;
    
    //Autumnity
    @ObjectHolder(TallDoorBlock.NAME_MAPLE) public static final Item TALL_MAPLE_DOOR = null;
    
    //Bamboo Blocks
    @ObjectHolder(TallDoorBlock.NAME_BAMBOO) public static final Item TALL_BAMBOO_DOOR = null;

    //Buzzier Bees
    @ObjectHolder(TallDoorBlock.NAME_HONEYCOMB) public static final Item TALL_HONEYCOMB_DOOR = null;
    
    //Endergetic Expansion
    @ObjectHolder(TallDoorBlock.NAME_POISE) public static final Item TALL_POISE_DOOR = null;
    
    //Environmental
    @ObjectHolder(TallDoorBlock.NAME_CHERRY) public static final Item TALL_CHERRY_DOOR = null;
    @ObjectHolder(TallDoorBlock.NAME_WILLOW) public static final Item TALL_WILLOW_DOOR = null;
    @ObjectHolder(TallDoorBlock.NAME_WISTERIA) public static final Item TALL_WISTERIA_DOOR = null;
    
    //Upgrade Aquatic
    @ObjectHolder(TallDoorBlock.NAME_DRIFTWOOD) public static final Item TALL_DRIFTWOOD_DOOR = null;
    @ObjectHolder(TallDoorBlock.NAME_RIVER) public static final Item TALL_RIVER_DOOR = null;
    @ObjectHolder(TallDoorBlock.NAME_GLASS) public static final Item TALL_GLASS_DOOR = null;
    @ObjectHolder(TallDoorBlock.NAME_TOOTH) public static final Item TALL_TOOTH_DOOR = null;
    @SubscribeEvent
    public static void registerItems(final RegistryEvent.Register<Item> itemRegistry) {
        itemRegistry.getRegistry().registerAll(
                new BlockItem(DramaticDoorsBlocks.TALL_OAK_DOOR, PROPERTIES).setRegistryName(new ResourceLocation(DramaticDoors.MOD_ID, TallDoorBlock.NAME_OAK)),
                new BlockItem(DramaticDoorsBlocks.TALL_SPRUCE_DOOR, PROPERTIES).setRegistryName(new ResourceLocation(DramaticDoors.MOD_ID, TallDoorBlock.NAME_SPRUCE)),
                new BlockItem(DramaticDoorsBlocks.TALL_BIRCH_DOOR, PROPERTIES).setRegistryName(new ResourceLocation(DramaticDoors.MOD_ID, TallDoorBlock.NAME_BIRCH)),
                new BlockItem(DramaticDoorsBlocks.TALL_JUNGLE_DOOR, PROPERTIES).setRegistryName(new ResourceLocation(DramaticDoors.MOD_ID, TallDoorBlock.NAME_JUNGLE)),
                new BlockItem(DramaticDoorsBlocks.TALL_ACACIA_DOOR, PROPERTIES).setRegistryName(new ResourceLocation(DramaticDoors.MOD_ID, TallDoorBlock.NAME_ACACIA)),
                new BlockItem(DramaticDoorsBlocks.TALL_DARK_OAK_DOOR, PROPERTIES).setRegistryName(new ResourceLocation(DramaticDoors.MOD_ID, TallDoorBlock.NAME_DARK_OAK)),
                new BlockItem(DramaticDoorsBlocks.TALL_IRON_DOOR, PROPERTIES).setRegistryName(new ResourceLocation(DramaticDoors.MOD_ID, TallDoorBlock.NAME_IRON)),
                new BlockItem(DramaticDoorsBlocks.TALL_CRIMSON_DOOR, PROPERTIES).setRegistryName(new ResourceLocation(DramaticDoors.MOD_ID, TallDoorBlock.NAME_CRIMSON)),
                new BlockItem(DramaticDoorsBlocks.TALL_WARPED_DOOR, PROPERTIES).setRegistryName(new ResourceLocation(DramaticDoors.MOD_ID, TallDoorBlock.NAME_WARPED))
        );
        //Conditionally add items based on whether mods are loaded.
        if (ModList.get().isLoaded("atmospheric")) {
        	itemRegistry.getRegistry().registerAll(
                new BlockItem(DramaticDoorsBlocks.TALL_ASPEN_DOOR, PROPERTIES).setRegistryName(new ResourceLocation(DramaticDoors.MOD_ID, TallDoorBlock.NAME_ASPEN)),
                new BlockItem(DramaticDoorsBlocks.TALL_GRIMWOOD_DOOR, PROPERTIES).setRegistryName(new ResourceLocation(DramaticDoors.MOD_ID, TallDoorBlock.NAME_GRIMWOOD)),
                new BlockItem(DramaticDoorsBlocks.TALL_KOUSA_DOOR, PROPERTIES).setRegistryName(new ResourceLocation(DramaticDoors.MOD_ID, TallDoorBlock.NAME_KOUSA)),
                new BlockItem(DramaticDoorsBlocks.TALL_MORADO_DOOR, PROPERTIES).setRegistryName(new ResourceLocation(DramaticDoors.MOD_ID, TallDoorBlock.NAME_MORADO)),
                new BlockItem(DramaticDoorsBlocks.TALL_ROSEWOOD_DOOR, PROPERTIES).setRegistryName(new ResourceLocation(DramaticDoors.MOD_ID, TallDoorBlock.NAME_ROSEWOOD)),
                new BlockItem(DramaticDoorsBlocks.TALL_YUCCA_DOOR, PROPERTIES).setRegistryName(new ResourceLocation(DramaticDoors.MOD_ID, TallDoorBlock.NAME_YUCCA))
        	);
        }
        if (ModList.get().isLoaded("autumnity")) {
        	itemRegistry.getRegistry().registerAll(
                new BlockItem(DramaticDoorsBlocks.TALL_MAPLE_DOOR, PROPERTIES).setRegistryName(new ResourceLocation(DramaticDoors.MOD_ID, TallDoorBlock.NAME_MAPLE))
            );
        }
        if (ModList.get().isLoaded("bamboo_blocks")) {
        	itemRegistry.getRegistry().registerAll(
                new BlockItem(DramaticDoorsBlocks.TALL_BAMBOO_DOOR, PROPERTIES).setRegistryName(new ResourceLocation(DramaticDoors.MOD_ID, TallDoorBlock.NAME_BAMBOO))
            );
        }
        if (ModList.get().isLoaded("buzzier_bees")) {
        	itemRegistry.getRegistry().registerAll(
                new BlockItem(DramaticDoorsBlocks.TALL_HONEYCOMB_DOOR, PROPERTIES).setRegistryName(new ResourceLocation(DramaticDoors.MOD_ID, TallDoorBlock.NAME_HONEYCOMB))
            );
        }
        if (ModList.get().isLoaded("endergetic")) {
        	itemRegistry.getRegistry().registerAll(
                new BlockItem(DramaticDoorsBlocks.TALL_POISE_DOOR, PROPERTIES).setRegistryName(new ResourceLocation(DramaticDoors.MOD_ID, TallDoorBlock.NAME_POISE))
            );
        }
        if (ModList.get().isLoaded("environmental")) {
        	itemRegistry.getRegistry().registerAll(
                new BlockItem(DramaticDoorsBlocks.TALL_CHERRY_DOOR, PROPERTIES).setRegistryName(new ResourceLocation(DramaticDoors.MOD_ID, TallDoorBlock.NAME_CHERRY)),
                new BlockItem(DramaticDoorsBlocks.TALL_WILLOW_DOOR, PROPERTIES).setRegistryName(new ResourceLocation(DramaticDoors.MOD_ID, TallDoorBlock.NAME_WILLOW)),
                new BlockItem(DramaticDoorsBlocks.TALL_WISTERIA_DOOR, PROPERTIES).setRegistryName(new ResourceLocation(DramaticDoors.MOD_ID, TallDoorBlock.NAME_WISTERIA))
            );
        }
        if (ModList.get().isLoaded("upgrade_aquatic")) {
        	itemRegistry.getRegistry().registerAll(
                new BlockItem(DramaticDoorsBlocks.TALL_DRIFTWOOD_DOOR, PROPERTIES).setRegistryName(new ResourceLocation(DramaticDoors.MOD_ID, TallDoorBlock.NAME_DRIFTWOOD)),
                new BlockItem(DramaticDoorsBlocks.TALL_RIVER_DOOR, PROPERTIES).setRegistryName(new ResourceLocation(DramaticDoors.MOD_ID, TallDoorBlock.NAME_RIVER)),
                new BlockItem(DramaticDoorsBlocks.TALL_GLASS_DOOR, PROPERTIES).setRegistryName(new ResourceLocation(DramaticDoors.MOD_ID, TallDoorBlock.NAME_GLASS)),
                new BlockItem(DramaticDoorsBlocks.TALL_TOOTH_DOOR, PROPERTIES).setRegistryName(new ResourceLocation(DramaticDoors.MOD_ID, TallDoorBlock.NAME_TOOTH))
            );
        }
    }

}
