package com.fizzware.dramaticdoors.state.properties;

import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.EnumProperty;

public class DoorBlockStateProperties extends BlockStateProperties {
   public static final EnumProperty<TripleBlockPart> TRIPLE_BLOCK_THIRD = EnumProperty.create("third", TripleBlockPart.class);
}