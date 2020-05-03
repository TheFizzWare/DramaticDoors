package com.fizzware.dramaticdoors.state.properties;

import net.minecraft.state.EnumProperty;
import net.minecraft.state.properties.*;

public class DoorBlockStateProperties extends BlockStateProperties {
   public static final EnumProperty<TripleBlockPart> TRIPLE_BLOCK_THIRD = EnumProperty.create("third", TripleBlockPart.class);
}