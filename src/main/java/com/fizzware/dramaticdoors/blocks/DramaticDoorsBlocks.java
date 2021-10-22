package com.fizzware.dramaticdoors.blocks;

import com.fizzware.dramaticdoors.DramaticDoors;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.ObjectHolder;
import org.apache.commons.lang3.NotImplementedException;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
@ObjectHolder(DramaticDoors.MOD_ID)
public class DramaticDoorsBlocks {

    @ObjectHolder(TallDoorBlock.NAME_OAK) public static final Block TALL_OAK_DOOR = null;
    @ObjectHolder(TallDoorBlock.NAME_SPRUCE) public static final Block TALL_SPRUCE_DOOR = null;
    @ObjectHolder(TallDoorBlock.NAME_BIRCH) public static final Block TALL_BIRCH_DOOR = null;
    @ObjectHolder(TallDoorBlock.NAME_JUNGLE) public static final Block TALL_JUNGLE_DOOR = null;
    @ObjectHolder(TallDoorBlock.NAME_ACACIA) public static final Block TALL_ACACIA_DOOR = null;
    @ObjectHolder(TallDoorBlock.NAME_DARK_OAK) public static final Block TALL_DARK_OAK_DOOR = null;
    @ObjectHolder(TallDoorBlock.NAME_IRON) public static final Block TALL_IRON_DOOR = null;
    @ObjectHolder(TallDoorBlock.NAME_CRIMSON) public static final Block TALL_CRIMSON_DOOR = null;
    @ObjectHolder(TallDoorBlock.NAME_WARPED) public static final Block TALL_WARPED_DOOR = null;

    @SubscribeEvent
    public static void registerBlocks(final RegistryEvent.Register<Block> blockRegistry) {
        Block[] vanillaDoors = getBlockList(DoorSeries.VANILLA);
        String[] tallDoorNames = TallDoorBlock.getNames();
        IForgeRegistry<Block> registry = blockRegistry.getRegistry();
        for (int i = 0; i < vanillaDoors.length; i++) {
            registry.register(new TallDoorBlock(vanillaDoors[i]).setRegistryName(new ResourceLocation(DramaticDoors.MOD_ID, tallDoorNames[i])));
//            blockRegistry.getRegistry().registerAll(
//                    new TallDoorBlock(Blocks.OAK_DOOR).setRegistryName(new ResourceLocation(DramaticDoors.MOD_ID, TallDoorBlock.NAME_OAK)),
//                    new TallDoorBlock(Blocks.SPRUCE_DOOR).setRegistryName(new ResourceLocation(DramaticDoors.MOD_ID, TallDoorBlock.NAME_SPRUCE)),
//                    new TallDoorBlock(Blocks.BIRCH_DOOR).setRegistryName(new ResourceLocation(DramaticDoors.MOD_ID, TallDoorBlock.NAME_BIRCH)),
//                    new TallDoorBlock(Blocks.JUNGLE_DOOR).setRegistryName(new ResourceLocation(DramaticDoors.MOD_ID, TallDoorBlock.NAME_JUNGLE)),
//                    new TallDoorBlock(Blocks.ACACIA_DOOR).setRegistryName(new ResourceLocation(DramaticDoors.MOD_ID, TallDoorBlock.NAME_ACACIA)),
//                    new TallDoorBlock(Blocks.DARK_OAK_DOOR).setRegistryName(new ResourceLocation(DramaticDoors.MOD_ID, TallDoorBlock.NAME_DARK_OAK)),
//                    new TallDoorBlock(Blocks.IRON_DOOR).setRegistryName(new ResourceLocation(DramaticDoors.MOD_ID, TallDoorBlock.NAME_IRON))
//            );
        }
    }

    public static Block[] getBlockList(DoorSeries series) {
        switch (series) {
            case VANILLA:
                return new Block[] {
                        Blocks.OAK_DOOR, Blocks.SPRUCE_DOOR, Blocks.BIRCH_DOOR,
                        Blocks.JUNGLE_DOOR, Blocks.ACACIA_DOOR, Blocks.DARK_OAK_DOOR,
                        Blocks.IRON_DOOR, Blocks.CRIMSON_DOOR, Blocks.WARPED_DOOR };
                // TODO: Update mappings. Crimson is mS and Warped is mT
            case VANILLA_TALL:
                return new Block[] {
                        TALL_OAK_DOOR, TALL_SPRUCE_DOOR, TALL_BIRCH_DOOR,
                        TALL_JUNGLE_DOOR, TALL_ACACIA_DOOR, TALL_DARK_OAK_DOOR,
                        TALL_IRON_DOOR, TALL_CRIMSON_DOOR, TALL_WARPED_DOOR };
            case BOP:
                throw new NotImplementedException("Biomes O' Plenty not yet supported."); // TODO BOP (Many)
            case BOP_TALL:
                throw new NotImplementedException("Biomes O' Plenty not yet supported."); // TODO BOP (Many Tall)
            case UPGRADE_AQUATIC:
                throw new NotImplementedException("Upgrade Aquatic not yet supported."); // TODO Upgrade Aquatic (Driftwood Door)
            case UPGRADE_AQUATIC_TALL:
                throw new NotImplementedException("Upgrade Aquatic not yet supported."); // TODO Upgrade Aquatic (Tall Driftwood Door)
            default:
                return new Block[] {};
        }
    }

    public enum DoorSeries {
        VANILLA,
        VANILLA_TALL,
        BOP,
        BOP_TALL,
        UPGRADE_AQUATIC,
        UPGRADE_AQUATIC_TALL // TODO Series: All, All Short, All Tall
    }
}
