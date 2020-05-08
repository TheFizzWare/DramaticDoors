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

    public static Block TALL_OAK_DOOR;
    public static Block TALL_SPRUCE_DOOR;
    public static Block TALL_BIRCH_DOOR;
    public static Block TALL_JUNGLE_DOOR;
    public static Block TALL_ACACIA_DOOR;
    public static Block TALL_DARK_OAK_DOOR;
    public static Block TALL_IRON_DOOR;

    @SubscribeEvent
    public static void registerBlocks(final RegistryEvent.Register<Block> blockRegistry)
    {
        TALL_OAK_DOOR = new TallDoorBlock(Blocks.OAK_DOOR);
        TALL_SPRUCE_DOOR = new TallDoorBlock(Blocks.SPRUCE_DOOR);
        TALL_BIRCH_DOOR = new TallDoorBlock(Blocks.BIRCH_DOOR);
        TALL_JUNGLE_DOOR = new TallDoorBlock(Blocks.JUNGLE_DOOR);
        TALL_ACACIA_DOOR = new TallDoorBlock(Blocks.ACACIA_DOOR);
        TALL_DARK_OAK_DOOR = new TallDoorBlock(Blocks.DARK_OAK_DOOR);
        TALL_IRON_DOOR = new TallDoorBlock(Blocks.IRON_DOOR);

        blockRegistry.getRegistry().registerAll(
                TALL_OAK_DOOR.setRegistryName(new ResourceLocation(DramaticDoors.MOD_ID, TallDoorBlock.NAME_OAK)),
                TALL_SPRUCE_DOOR.setRegistryName(new ResourceLocation(DramaticDoors.MOD_ID, TallDoorBlock.NAME_SPRUCE)),
                TALL_BIRCH_DOOR.setRegistryName(new ResourceLocation(DramaticDoors.MOD_ID, TallDoorBlock.NAME_BIRCH)),
                TALL_JUNGLE_DOOR.setRegistryName(new ResourceLocation(DramaticDoors.MOD_ID, TallDoorBlock.NAME_JUNGLE)),
                TALL_ACACIA_DOOR.setRegistryName(new ResourceLocation(DramaticDoors.MOD_ID, TallDoorBlock.NAME_ACACIA)),
                TALL_DARK_OAK_DOOR.setRegistryName(new ResourceLocation(DramaticDoors.MOD_ID, TallDoorBlock.NAME_DARK_OAK)),
                TALL_IRON_DOOR.setRegistryName(new ResourceLocation(DramaticDoors.MOD_ID, TallDoorBlock.NAME_IRON))
        );

    }

}
