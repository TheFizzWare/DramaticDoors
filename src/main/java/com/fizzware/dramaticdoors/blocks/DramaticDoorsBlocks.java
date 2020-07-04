package com.fizzware.dramaticdoors.blocks;

import com.fizzware.dramaticdoors.DramaticDoors;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ObjectHolder;

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

    @SubscribeEvent
    public static void registerBlocks(final RegistryEvent.Register<Block> blockRegistry) {
        blockRegistry.getRegistry().registerAll(
                new TallDoorBlock(Blocks.OAK_DOOR).setRegistryName(new ResourceLocation(DramaticDoors.MOD_ID, TallDoorBlock.NAME_OAK)),
                new TallDoorBlock(Blocks.SPRUCE_DOOR).setRegistryName(new ResourceLocation(DramaticDoors.MOD_ID, TallDoorBlock.NAME_SPRUCE)),
                new TallDoorBlock(Blocks.BIRCH_DOOR).setRegistryName(new ResourceLocation(DramaticDoors.MOD_ID, TallDoorBlock.NAME_BIRCH)),
                new TallDoorBlock(Blocks.JUNGLE_DOOR).setRegistryName(new ResourceLocation(DramaticDoors.MOD_ID, TallDoorBlock.NAME_JUNGLE)),
                new TallDoorBlock(Blocks.ACACIA_DOOR).setRegistryName(new ResourceLocation(DramaticDoors.MOD_ID, TallDoorBlock.NAME_ACACIA)),
                new TallDoorBlock(Blocks.DARK_OAK_DOOR).setRegistryName(new ResourceLocation(DramaticDoors.MOD_ID, TallDoorBlock.NAME_DARK_OAK)),
                new TallDoorBlock(Blocks.IRON_DOOR).setRegistryName(new ResourceLocation(DramaticDoors.MOD_ID, TallDoorBlock.NAME_IRON))
        );
    }

    public static Block[] getBlockList() {
        return new Block[] { TALL_OAK_DOOR, TALL_SPRUCE_DOOR, TALL_BIRCH_DOOR, TALL_JUNGLE_DOOR, TALL_ACACIA_DOOR, TALL_DARK_OAK_DOOR, TALL_IRON_DOOR };
    }

}
