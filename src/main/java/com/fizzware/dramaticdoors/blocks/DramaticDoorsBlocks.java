package com.fizzware.dramaticdoors.blocks;

import com.fizzware.dramaticdoors.DramaticDoors;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.ObjectHolder;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
@ObjectHolder(DramaticDoors.MOD_ID)
public class DramaticDoorsBlocks {

	//Vanilla
    @ObjectHolder(TallDoorBlock.NAME_OAK) public static final Block TALL_OAK_DOOR = null;
    @ObjectHolder(TallDoorBlock.NAME_SPRUCE) public static final Block TALL_SPRUCE_DOOR = null;
    @ObjectHolder(TallDoorBlock.NAME_BIRCH) public static final Block TALL_BIRCH_DOOR = null;
    @ObjectHolder(TallDoorBlock.NAME_JUNGLE) public static final Block TALL_JUNGLE_DOOR = null;
    @ObjectHolder(TallDoorBlock.NAME_ACACIA) public static final Block TALL_ACACIA_DOOR = null;
    @ObjectHolder(TallDoorBlock.NAME_DARK_OAK) public static final Block TALL_DARK_OAK_DOOR = null;
    @ObjectHolder(TallDoorBlock.NAME_IRON) public static final Block TALL_IRON_DOOR = null;
    @ObjectHolder(TallDoorBlock.NAME_CRIMSON) public static final Block TALL_CRIMSON_DOOR = null;
    @ObjectHolder(TallDoorBlock.NAME_WARPED) public static final Block TALL_WARPED_DOOR = null;

    //Biomes O' Plenty
    @ObjectHolder(TallDoorBlock.NAME_BOP_CHERRY) public static final Block TALL_BOP_CHERRY_DOOR = null;
    @ObjectHolder(TallDoorBlock.NAME_BOP_DEAD) public static final Block TALL_BOP_DEAD_DOOR = null;
    @ObjectHolder(TallDoorBlock.NAME_BOP_FIR) public static final Block TALL_BOP_FIR_DOOR = null;
    @ObjectHolder(TallDoorBlock.NAME_BOP_HELLBARK) public static final Block TALL_BOP_HELLBARK_DOOR = null;
    @ObjectHolder(TallDoorBlock.NAME_BOP_JACARANDA) public static final Block TALL_BOP_JACARANDA_DOOR = null;
    @ObjectHolder(TallDoorBlock.NAME_BOP_MAGIC) public static final Block TALL_BOP_MAGIC_DOOR = null;
    @ObjectHolder(TallDoorBlock.NAME_BOP_MAHOGANY) public static final Block TALL_BOP_MAHOGANY_DOOR = null;
    @ObjectHolder(TallDoorBlock.NAME_BOP_PALM) public static final Block TALL_BOP_PALM_DOOR = null;
    @ObjectHolder(TallDoorBlock.NAME_BOP_REDWOOD) public static final Block TALL_BOP_REDWOOD_DOOR = null;
    @ObjectHolder(TallDoorBlock.NAME_BOP_UMBRAN) public static final Block TALL_BOP_UMBRAN_DOOR = null;
    @ObjectHolder(TallDoorBlock.NAME_BOP_WILLOW) public static final Block TALL_BOP_WILLOW_DOOR = null;
    
    //Twilight Forest
    @ObjectHolder(TallDoorBlock.NAME_CANOPY) public static final Block TALL_CANOPY_DOOR = null;
    @ObjectHolder(TallDoorBlock.NAME_DARKWOOD) public static final Block TALL_DARKWOOD_DOOR = null;
    @ObjectHolder(TallDoorBlock.NAME_MANGROVE) public static final Block TALL_MANGROVE_DOOR = null;
    @ObjectHolder(TallDoorBlock.NAME_MINEWOOD) public static final Block TALL_MINEWOOD_DOOR = null;
    @ObjectHolder(TallDoorBlock.NAME_SORTINGWOOD) public static final Block TALL_SORTINGWOOD_DOOR = null;
    @ObjectHolder(TallDoorBlock.NAME_TIMEWOOD) public static final Block TALL_TIMEWOOD_DOOR = null;
    @ObjectHolder(TallDoorBlock.NAME_TRANSWOOD) public static final Block TALL_TRANSWOOD_DOOR = null;
    @ObjectHolder(TallDoorBlock.NAME_TWILIGHT_OAK) public static final Block TALL_TWILIGHT_OAK_DOOR = null;
    
    //Atmospheric
    @ObjectHolder(TallDoorBlock.NAME_ASPEN) public static final Block TALL_ASPEN_DOOR = null;
    @ObjectHolder(TallDoorBlock.NAME_GRIMWOOD) public static final Block TALL_GRIMWOOD_DOOR = null;
    @ObjectHolder(TallDoorBlock.NAME_KOUSA) public static final Block TALL_KOUSA_DOOR = null;
    @ObjectHolder(TallDoorBlock.NAME_MORADO) public static final Block TALL_MORADO_DOOR = null;
    @ObjectHolder(TallDoorBlock.NAME_ROSEWOOD) public static final Block TALL_ROSEWOOD_DOOR = null;
    @ObjectHolder(TallDoorBlock.NAME_YUCCA) public static final Block TALL_YUCCA_DOOR = null;
    
    //Autumnity
    @ObjectHolder(TallDoorBlock.NAME_MAPLE) public static final Block TALL_MAPLE_DOOR = null;
    
    //Bamboo Blocks
    @ObjectHolder(TallDoorBlock.NAME_BAMBOO) public static final Block TALL_BAMBOO_DOOR = null;

    //Buzzier Bees
    @ObjectHolder(TallDoorBlock.NAME_HONEYCOMB) public static final Block TALL_HONEYCOMB_DOOR = null;
    
    //Endergetic Expansion
    @ObjectHolder(TallDoorBlock.NAME_POISE) public static final Block TALL_POISE_DOOR = null;
    
    //Environmental
    @ObjectHolder(TallDoorBlock.NAME_CHERRY) public static final Block TALL_CHERRY_DOOR = null;
    @ObjectHolder(TallDoorBlock.NAME_WILLOW) public static final Block TALL_WILLOW_DOOR = null;
    @ObjectHolder(TallDoorBlock.NAME_WISTERIA) public static final Block TALL_WISTERIA_DOOR = null;
    
    //Upgrade Aquatic
    @ObjectHolder(TallDoorBlock.NAME_DRIFTWOOD) public static final Block TALL_DRIFTWOOD_DOOR = null;
    @ObjectHolder(TallDoorBlock.NAME_RIVER) public static final Block TALL_RIVER_DOOR = null;
    @ObjectHolder(TallDoorBlock.NAME_GLASS) public static final Block TALL_GLASS_DOOR = null;
    @ObjectHolder(TallDoorBlock.NAME_TOOTH) public static final Block TALL_TOOTH_DOOR = null;
    
    //Abundance
    @ObjectHolder(TallDoorBlock.NAME_JACARANDA) public static final Block TALL_JACARANDA_DOOR = null;
    @ObjectHolder(TallDoorBlock.NAME_REDBUD) public static final Block TALL_REDBUD_DOOR = null;
    
    //Bayou Blues
    @ObjectHolder(TallDoorBlock.NAME_CYPRESS) public static final Block TALL_CYPRESS_DOOR = null;
    
    //Enhanced Mushrooms
    @ObjectHolder(TallDoorBlock.NAME_BROWN_MUSHROOM) public static final Block TALL_BROWN_MUSHROOM_DOOR = null;
    @ObjectHolder(TallDoorBlock.NAME_RED_MUSHROOM) public static final Block TALL_RED_MUSHROOM_DOOR = null;
    @ObjectHolder(TallDoorBlock.NAME_GLOWSHROOM) public static final Block TALL_GLOWSHROOM_DOOR = null;
    
    //Darker Depths
    @ObjectHolder(TallDoorBlock.NAME_PETRIFIED) public static final Block TALL_PETRIFIED_DOOR = null;
    
    //Dustrial Decor
    @ObjectHolder(TallDoorBlock.NAME_CARDBOARD) public static final Block TALL_CARDBOARD_DOOR = null;
    @ObjectHolder(TallDoorBlock.NAME_CHAIN) public static final Block TALL_CHAIN_DOOR = null;
    @ObjectHolder(TallDoorBlock.NAME_INDUSTRIAL_IRON) public static final Block TALL_INDUSTRIAL_IRON_DOOR = null;
    @ObjectHolder(TallDoorBlock.NAME_IRON_BAR) public static final Block TALL_IRON_BAR_DOOR = null;
    @ObjectHolder(TallDoorBlock.NAME_PADDED) public static final Block TALL_PADDED_DOOR = null;
    @ObjectHolder(TallDoorBlock.NAME_RUSTY_IRON) public static final Block TALL_RUSTY_IRON_DOOR = null;
    @ObjectHolder(TallDoorBlock.NAME_RUSTY_SHEET_METAL) public static final Block TALL_RUSTY_SHEET_METAL_DOOR = null;
    @ObjectHolder(TallDoorBlock.NAME_SHEET_METAL) public static final Block TALL_SHEET_METAL_DOOR = null;

    //Habitat
    @ObjectHolder(TallDoorBlock.NAME_FAIRY_RING_MUSHROOM) public static final Block TALL_FAIRY_RING_MUSHROOM_DOOR = null;
    
    //Outer End
    @ObjectHolder(TallDoorBlock.NAME_AZURE) public static final Block TALL_AZURE_DOOR = null;
    
    //Supplementaries
    @ObjectHolder(TallDoorBlock.NAME_GOLD) public static final Block TALL_GOLD_DOOR = null;
    @ObjectHolder(TallDoorBlock.NAME_NETHERITE) public static final Block TALL_NETHERITE_DOOR = null;
    
    @SubscribeEvent
    public static void registerBlocks(final RegistryEvent.Register<Block> blockRegistry) {
        IForgeRegistry<Block> registry = blockRegistry.getRegistry();
        addBlockSeries(registry, DoorSeries.VANILLA, "minecraft");
        //Conditionally add doors based on whether mods are loaded.
        //Big mods
        addBlockSeries(registry, DoorSeries.BOP, "biomesoplenty");
        addBlockSeries(registry, DoorSeries.TWILIGHT_FOREST, "twilightforest");
        //Abnormals
        addBlockSeries(registry, DoorSeries.ATMOSPHERIC, "atmospheric");
        addBlockSeries(registry, DoorSeries.AUTUMNITY, "autumnity");
        addBlockSeries(registry, DoorSeries.BAMBOO, "bamboo_blocks");
        addBlockSeries(registry, DoorSeries.BUZZIER, "buzzier_bees");
        addBlockSeries(registry, DoorSeries.ENDERGETIC, "endergetic");
        addBlockSeries(registry, DoorSeries.ENVIRONMENTAL, "environmental");
        addBlockSeries(registry, DoorSeries.UPGRADE_AQUATIC, "upgrade_aquatic");
        //Team Aurora
        addBlockSeries(registry, DoorSeries.ABUNDANCE, "abundance");
        addBlockSeries(registry, DoorSeries.BAYOU_BLUES, "bayou_blues");
        addBlockSeries(registry, DoorSeries.ENH_MUSHROOMS, "enhanced_mushrooms");
        //Miscellaneous
        addBlockSeries(registry, DoorSeries.DARKER_DEPTHS, "darkerdepths");
        addBlockSeries(registry, DoorSeries.DUSTRIAL_DECOR, "dustrial_decor");
        addBlockSeries(registry, DoorSeries.HABITAT, "habitat");
        addBlockSeries(registry, DoorSeries.OUTER_END, "outer_end");
        addBlockSeries(registry, DoorSeries.SUPPLEMENTARIES, "supplementaries");
    }

    private static void addBlockSeries(IForgeRegistry<Block> registry, DoorSeries series, String modid) {
        String[] tallDoorNames = TallDoorBlock.getNames(series);
        if (ModList.get().isLoaded(modid)) {
	        Block[] baseDoors = getBlockList(series);
	        for (int i = 0; i < baseDoors.length; i++) {
	            registry.register(new TallDoorBlock(baseDoors[i]).setRegistryName(new ResourceLocation(DramaticDoors.MOD_ID, tallDoorNames[i])));
	        }
        }
        else { //Add fallback blocks that shall retain data.
	        Block[] baseDoors = getBlockList(series);
	        for (int i = 0; i < baseDoors.length; i++) {
	            registry.register(new TallDoorBlock(Blocks.OAK_DOOR).setRegistryName(new ResourceLocation(DramaticDoors.MOD_ID, tallDoorNames[i])));
	        }
        }
    }
    
    @SuppressWarnings("deprecation")
	public static Block[] getBlockList(DoorSeries series) {
        switch (series) {
            case VANILLA:
                return new Block[] {
                        Blocks.OAK_DOOR, Blocks.SPRUCE_DOOR, Blocks.BIRCH_DOOR,
                        Blocks.JUNGLE_DOOR, Blocks.ACACIA_DOOR, Blocks.DARK_OAK_DOOR,
                        Blocks.IRON_DOOR, Blocks.CRIMSON_DOOR, Blocks.WARPED_DOOR };
            case VANILLA_TALL:
                return new Block[] {
                        TALL_OAK_DOOR, TALL_SPRUCE_DOOR, TALL_BIRCH_DOOR,
                        TALL_JUNGLE_DOOR, TALL_ACACIA_DOOR, TALL_DARK_OAK_DOOR,
                        TALL_IRON_DOOR, TALL_CRIMSON_DOOR, TALL_WARPED_DOOR };
            //Big mods
            case BOP:
            	return new Block[] {
            			Registry.BLOCK.get(new ResourceLocation("biomesoplenty", "cherry_door")),
            			Registry.BLOCK.get(new ResourceLocation("biomesoplenty", "dead_door")),
            			Registry.BLOCK.get(new ResourceLocation("biomesoplenty", "fir_door")),
            			Registry.BLOCK.get(new ResourceLocation("biomesoplenty", "hellbark_door")),
            			Registry.BLOCK.get(new ResourceLocation("biomesoplenty", "jacaranda_door")),
            			Registry.BLOCK.get(new ResourceLocation("biomesoplenty", "magic_door")),
            			Registry.BLOCK.get(new ResourceLocation("biomesoplenty", "mahogany_door")),
            			Registry.BLOCK.get(new ResourceLocation("biomesoplenty", "palm_door")),
            			Registry.BLOCK.get(new ResourceLocation("biomesoplenty", "redwood_door")),
            			Registry.BLOCK.get(new ResourceLocation("biomesoplenty", "umbran_door")),
            			Registry.BLOCK.get(new ResourceLocation("biomesoplenty", "willow_door")) };
            case BOP_TALL:
            	return new Block[] { 
            			TALL_BOP_CHERRY_DOOR, TALL_BOP_DEAD_DOOR, TALL_BOP_FIR_DOOR, TALL_BOP_HELLBARK_DOOR, TALL_BOP_JACARANDA_DOOR, TALL_BOP_MAGIC_DOOR,
            			TALL_BOP_MAHOGANY_DOOR, TALL_BOP_PALM_DOOR, TALL_BOP_REDWOOD_DOOR, TALL_BOP_UMBRAN_DOOR, TALL_BOP_WILLOW_DOOR };
            case TWILIGHT_FOREST:
            	return new Block[] {
            			Registry.BLOCK.get(new ResourceLocation("twilightforest", "canopy_door")),
            			Registry.BLOCK.get(new ResourceLocation("twilightforest", "dark_door")),
            			Registry.BLOCK.get(new ResourceLocation("twilightforest", "mangrove_door")),
            			Registry.BLOCK.get(new ResourceLocation("twilightforest", "mine_door")),
            			Registry.BLOCK.get(new ResourceLocation("twilightforest", "sort_door")),
            			Registry.BLOCK.get(new ResourceLocation("twilightforest", "time_door")),
            			Registry.BLOCK.get(new ResourceLocation("twilightforest", "trans_door")),
            			Registry.BLOCK.get(new ResourceLocation("twilightforest", "twilight_oak_door")) };
            case TWILIGHT_FOREST_TALL:
            	return new Block[] { 
            			TALL_CANOPY_DOOR, TALL_DARKWOOD_DOOR, TALL_MANGROVE_DOOR, TALL_MINEWOOD_DOOR,
            			TALL_SORTINGWOOD_DOOR, TALL_TIMEWOOD_DOOR, TALL_TRANSWOOD_DOOR, TALL_TWILIGHT_OAK_DOOR };
            //Abnormals Mods
            case ATMOSPHERIC:
            	return new Block[] { 
            			Registry.BLOCK.get(new ResourceLocation("atmospheric", "aspen_door")),
            			Registry.BLOCK.get(new ResourceLocation("atmospheric", "grimwood_door")),
            			Registry.BLOCK.get(new ResourceLocation("atmospheric", "kousa_door")),
            			Registry.BLOCK.get(new ResourceLocation("atmospheric", "morado_door")),
            			Registry.BLOCK.get(new ResourceLocation("atmospheric", "rosewood_door")),
            			Registry.BLOCK.get(new ResourceLocation("atmospheric", "yucca_door")) };
            case ATMOSPHERIC_TALL:
            	return new Block[] { TALL_ASPEN_DOOR, TALL_GRIMWOOD_DOOR, TALL_KOUSA_DOOR, TALL_MORADO_DOOR, TALL_ROSEWOOD_DOOR, TALL_YUCCA_DOOR };
            case AUTUMNITY:
            	return new Block[] { Registry.BLOCK.get(new ResourceLocation("autumnity", "maple_door")) };
            case AUTUMNITY_TALL:
            	return new Block[] { TALL_MAPLE_DOOR };
            case BAMBOO:
            	return new Block[] { Registry.BLOCK.get(new ResourceLocation("bamboo_blocks", "bamboo_door")) };
            case BAMBOO_TALL:
            	return new Block[] { TALL_BAMBOO_DOOR };
            case BUZZIER:
            	return new Block[] { Registry.BLOCK.get(new ResourceLocation("buzzier_bees", "honeycomb_door")) };
            case BUZZIER_TALL:
            	return new Block[] { TALL_HONEYCOMB_DOOR };
            case ENDERGETIC:
            	return new Block[] { Registry.BLOCK.get(new ResourceLocation("endergetic", "poise_door")) };
            case ENDERGETIC_TALL:
            	return new Block[] { TALL_POISE_DOOR };
            case ENVIRONMENTAL:
            	return new Block[] { 
            			Registry.BLOCK.get(new ResourceLocation("environmental", "cherry_door")),
            			Registry.BLOCK.get(new ResourceLocation("environmental", "willow_door")),
            			Registry.BLOCK.get(new ResourceLocation("environmental", "wisteria_door")) };
            case ENVIRONMENTAL_TALL:
            	return new Block[] { TALL_CHERRY_DOOR, TALL_WILLOW_DOOR, TALL_WISTERIA_DOOR };
            case UPGRADE_AQUATIC:
            	return new Block[] { 
            			Registry.BLOCK.get(new ResourceLocation("upgrade_aquatic", "driftwood_door")),
            			Registry.BLOCK.get(new ResourceLocation("upgrade_aquatic", "river_door")),
           			    Registry.BLOCK.get(new ResourceLocation("upgrade_aquatic", "glass_door")),
            			Registry.BLOCK.get(new ResourceLocation("upgrade_aquatic", "tooth_door")) };
            case UPGRADE_AQUATIC_TALL:
            	return new Block[] { TALL_DRIFTWOOD_DOOR, TALL_RIVER_DOOR, TALL_GLASS_DOOR, TALL_TOOTH_DOOR };
            //Team Aurora Mods
            case ABUNDANCE:
            	return new Block[] { 
            			Registry.BLOCK.get(new ResourceLocation("abundance", "jacaranda_door")),
            			Registry.BLOCK.get(new ResourceLocation("abundance", "redbud_door")) };
            case ABUNDANCE_TALL:
            	return new Block[] { TALL_JACARANDA_DOOR, TALL_REDBUD_DOOR };
            case BAYOU_BLUES:
            	return new Block[] { Registry.BLOCK.get(new ResourceLocation("bayou_blues", "cypress_door")) };
            case BAYOU_BLUES_TALL:
            	return new Block[] { TALL_CYPRESS_DOOR };
            case ENH_MUSHROOMS:
            	return new Block[] { 
            			Registry.BLOCK.get(new ResourceLocation("enhanced_mushrooms", "brown_mushroom_door")),
            			Registry.BLOCK.get(new ResourceLocation("enhanced_mushrooms", "red_mushroom_door")),
            			Registry.BLOCK.get(new ResourceLocation("enhanced_mushrooms", "glowshroom_door")) };
            case ENH_MUSHROOMS_TALL:
            	return new Block[] { TALL_BROWN_MUSHROOM_DOOR, TALL_RED_MUSHROOM_DOOR, TALL_GLOWSHROOM_DOOR };
            //Miscellaneous
            case DARKER_DEPTHS:
            	return new Block[] { Registry.BLOCK.get(new ResourceLocation("darkerdepths", "petrified_door")) };
            case DARKER_DEPTHS_TALL:
            	return new Block[] { TALL_PETRIFIED_DOOR };
            case DUSTRIAL_DECOR:
            	return new Block[] { 
            			Registry.BLOCK.get(new ResourceLocation("dustrial_decor", "cardboard_door")),
            			Registry.BLOCK.get(new ResourceLocation("dustrial_decor", "chain_door")),
            			Registry.BLOCK.get(new ResourceLocation("dustrial_decor", "industrial_iron_door")),
            			Registry.BLOCK.get(new ResourceLocation("dustrial_decor", "iron_bar_door")),
            			Registry.BLOCK.get(new ResourceLocation("dustrial_decor", "padded_door")),
            			Registry.BLOCK.get(new ResourceLocation("dustrial_decor", "rusty_iron_door")),
            			Registry.BLOCK.get(new ResourceLocation("dustrial_decor", "rusty_sheet_metal_door")),
            			Registry.BLOCK.get(new ResourceLocation("dustrial_decor", "sheet_metal_door")) };
            case DUSTRIAL_DECOR_TALL:
            	return new Block[] { 
            			TALL_CARDBOARD_DOOR, TALL_CHAIN_DOOR, TALL_INDUSTRIAL_IRON_DOOR, TALL_IRON_BAR_DOOR,
            			TALL_PADDED_DOOR, TALL_RUSTY_IRON_DOOR, TALL_RUSTY_SHEET_METAL_DOOR, TALL_SHEET_METAL_DOOR };
            case HABITAT:
            	return new Block[] { Registry.BLOCK.get(new ResourceLocation("habitat", "fairy_ring_mushroom_door")) };
            case HABITAT_TALL:
            	return new Block[] { TALL_FAIRY_RING_MUSHROOM_DOOR };
            case OUTER_END:
            	return new Block[] { Registry.BLOCK.get(new ResourceLocation("outer_end", "azure_door")) };
            case OUTER_END_TALL:
            	return new Block[] { TALL_AZURE_DOOR };
            case SUPPLEMENTARIES:
            	return new Block[] { 
            			Registry.BLOCK.get(new ResourceLocation("supplementaries", "gold_door")),
            			Registry.BLOCK.get(new ResourceLocation("supplementaries", "netherite_door"))};
            case SUPPLEMENTARIES_TALL:
            	return new Block[] { TALL_GOLD_DOOR, TALL_NETHERITE_DOOR };
            //Failsafe
            default:
                return new Block[] {};
        }
    }

    public enum DoorSeries {
        VANILLA,
        VANILLA_TALL,
        BOP,
        BOP_TALL,
        TWILIGHT_FOREST,
        TWILIGHT_FOREST_TALL,
        ATMOSPHERIC,
        ATMOSPHERIC_TALL,
        AUTUMNITY,
        AUTUMNITY_TALL,
        BAMBOO,
        BAMBOO_TALL,
        BUZZIER,
        BUZZIER_TALL,
        ENDERGETIC,
        ENDERGETIC_TALL,
        ENVIRONMENTAL,
        ENVIRONMENTAL_TALL,
        UPGRADE_AQUATIC,
        UPGRADE_AQUATIC_TALL,
        ABUNDANCE,
        ABUNDANCE_TALL,
        BAYOU_BLUES,
        BAYOU_BLUES_TALL,
        ENH_MUSHROOMS,
        ENH_MUSHROOMS_TALL,
        DARKER_DEPTHS,
        DARKER_DEPTHS_TALL,
        DUSTRIAL_DECOR,
        DUSTRIAL_DECOR_TALL,
        HABITAT,
        HABITAT_TALL,
        OUTER_END,
        OUTER_END_TALL,
        SUPPLEMENTARIES,
        SUPPLEMENTARIES_TALL
    }
}
