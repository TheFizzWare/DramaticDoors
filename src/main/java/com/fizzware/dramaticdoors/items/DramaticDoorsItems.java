package com.fizzware.dramaticdoors.items;

import com.fizzware.dramaticdoors.DramaticDoors;
import com.fizzware.dramaticdoors.blocks.TallDoorBlock;
import com.fizzware.dramaticdoors.blocks.DramaticDoorsBlocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ObjectHolder;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
@ObjectHolder(DramaticDoors.MOD_ID)
public class DramaticDoorsItems {

    private static final Item.Properties PROPERTIES = new Item.Properties().group(DramaticDoors.TAB);

    @ObjectHolder(TallDoorBlock.NAME_OAK) public static final Item TALL_OAK_DOOR = null;
    @ObjectHolder(TallDoorBlock.NAME_SPRUCE) public static final Item TALL_SPRUCE_DOOR = null;
    @ObjectHolder(TallDoorBlock.NAME_BIRCH) public static final Item TALL_BIRCH_DOOR = null;
    @ObjectHolder(TallDoorBlock.NAME_JUNGLE) public static final Item TALL_JUNGLE_DOOR = null;
    @ObjectHolder(TallDoorBlock.NAME_ACACIA) public static final Item TALL_ACACIA_DOOR = null;
    @ObjectHolder(TallDoorBlock.NAME_DARK_OAK) public static final Item TALL_DARK_OAK_DOOR = null;
    @ObjectHolder(TallDoorBlock.NAME_IRON) public static final Item TALL_IRON_DOOR = null;

    @SubscribeEvent
    public static void registerItems(final RegistryEvent.Register<Item> itemRegistry) {
        itemRegistry.getRegistry().registerAll(
                new BlockItem(DramaticDoorsBlocks.TALL_OAK_DOOR, PROPERTIES).setRegistryName(new ResourceLocation(DramaticDoors.MOD_ID, TallDoorBlock.NAME_OAK)),
                new BlockItem(DramaticDoorsBlocks.TALL_SPRUCE_DOOR, PROPERTIES).setRegistryName(new ResourceLocation(DramaticDoors.MOD_ID, TallDoorBlock.NAME_SPRUCE)),
                new BlockItem(DramaticDoorsBlocks.TALL_BIRCH_DOOR, PROPERTIES).setRegistryName(new ResourceLocation(DramaticDoors.MOD_ID, TallDoorBlock.NAME_BIRCH)),
                new BlockItem(DramaticDoorsBlocks.TALL_JUNGLE_DOOR, PROPERTIES).setRegistryName(new ResourceLocation(DramaticDoors.MOD_ID, TallDoorBlock.NAME_JUNGLE)),
                new BlockItem(DramaticDoorsBlocks.TALL_ACACIA_DOOR, PROPERTIES).setRegistryName(new ResourceLocation(DramaticDoors.MOD_ID, TallDoorBlock.NAME_ACACIA)),
                new BlockItem(DramaticDoorsBlocks.TALL_DARK_OAK_DOOR, PROPERTIES).setRegistryName(new ResourceLocation(DramaticDoors.MOD_ID, TallDoorBlock.NAME_DARK_OAK)),
                new BlockItem(DramaticDoorsBlocks.TALL_IRON_DOOR, PROPERTIES).setRegistryName(new ResourceLocation(DramaticDoors.MOD_ID, TallDoorBlock.NAME_IRON))
        );
    }

}
