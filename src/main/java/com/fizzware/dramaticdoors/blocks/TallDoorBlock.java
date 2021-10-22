package com.fizzware.dramaticdoors.blocks;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

import com.fizzware.dramaticdoors.state.properties.DoorBlockStateProperties;
import com.fizzware.dramaticdoors.state.properties.TripleBlockPart;
import com.mojang.blaze3d.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.*;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.DoorHingeSide;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import net.minecraft.world.level.block.HorizontalDirectionalBlock;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
@SuppressWarnings("deprecation")
public class TallDoorBlock extends Block {

    public static final String NAME_OAK = "tall_oak_door";
    public static final String NAME_SPRUCE = "tall_spruce_door";
    public static final String NAME_BIRCH = "tall_birch_door";
    public static final String NAME_JUNGLE = "tall_jungle_door";
    public static final String NAME_ACACIA = "tall_acacia_door";
    public static final String NAME_DARK_OAK = "tall_dark_oak_door";
    public static final String NAME_IRON = "tall_iron_door";
    public static final String NAME_CRIMSON = "tall_crimson_door";
    public static final String NAME_WARPED = "tall_warped_door";

    // TODO: Reorganize / Enumerate for BOP, Upgrade Aquatic, etc.
    public static String[] getNames() {
        return new String[] {
                NAME_OAK, NAME_SPRUCE, NAME_BIRCH,
                NAME_JUNGLE, NAME_ACACIA, NAME_DARK_OAK,
                NAME_IRON, NAME_CRIMSON, NAME_WARPED };
    }

    public static final EnumProperty<TripleBlockPart> THIRD = DoorBlockStateProperties.TRIPLE_BLOCK_THIRD;
    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
    public static final BooleanProperty OPEN = BlockStateProperties.OPEN;
    public static final EnumProperty<DoorHingeSide> HINGE = BlockStateProperties.DOOR_HINGE;
    public static final BooleanProperty POWERED = BlockStateProperties.POWERED;
    protected static final VoxelShape SOUTH_AABB = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 3.0D);
    protected static final VoxelShape NORTH_AABB = Block.box(0.0D, 0.0D, 13.0D, 16.0D, 16.0D, 16.0D);
    protected static final VoxelShape WEST_AABB = Block.box(13.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D);
    protected static final VoxelShape EAST_AABB = Block.box(0.0D, 0.0D, 0.0D, 3.0D, 16.0D, 16.0D);


    public TallDoorBlock(Block from) {
        super(Properties.copy(from));
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(OPEN, Boolean.FALSE).setValue(HINGE, DoorHingeSide.LEFT).setValue(POWERED, Boolean.FALSE).setValue(THIRD, TripleBlockPart.LOWER));
    }

    @Override
    public BlockState updateShape(BlockState stateIn, Direction facing, BlockState facingState, LevelAccessor worldIn, BlockPos currentPos, BlockPos facingPos) {
        TripleBlockPart tripleblockpart = stateIn.getValue(THIRD);
        if (facing.getAxis() == Direction.Axis.Y && ((tripleblockpart == TripleBlockPart.LOWER == (facing == Direction.UP)) || tripleblockpart == TripleBlockPart.MIDDLE)) {
            if (facingState.getBlock() == this && facingState.getValue(THIRD) != tripleblockpart) {
                return stateIn.setValue(FACING, facingState.getValue(FACING)).setValue(OPEN, facingState.getValue(OPEN)).setValue(HINGE, facingState.getValue(HINGE)).setValue(POWERED, facingState.getValue(POWERED));
            } else {
                return Blocks.AIR.defaultBlockState();
            }
        } else {
            if (tripleblockpart == TripleBlockPart.LOWER && facing == Direction.DOWN && !stateIn.canSurvive(worldIn, currentPos)) {
                return Blocks.AIR.defaultBlockState();
            } else {
                return super.updateShape(stateIn, facing, facingState, worldIn, currentPos, facingPos);
            }
        }
    }

    @Override
    public void playerWillDestroy(Level worldIn, BlockPos pos, BlockState state, Player player) {
        if (!worldIn.isClientSide && player.isCreative()) {
            BlockPos otherPos1 = pos;
            BlockPos otherPos2 = pos;
            TripleBlockPart tripleblockpart = state.getValue(THIRD);
            switch (tripleblockpart) {
                case LOWER:
                    otherPos1 = pos.above();
                    otherPos2 = pos.above(2);
                    break;
                case MIDDLE:
                    otherPos1 = pos.below();
                    otherPos2 = pos.above();
                    break;
                case UPPER:
                    otherPos1 = pos.below(2);
                    otherPos2 = pos.below();
                    break;
            }
            BlockState blockstate1 = worldIn.getBlockState(otherPos1);
            BlockState blockstate2 = worldIn.getBlockState(otherPos2);
            if (blockstate1.getBlock() == state.getBlock() && blockstate1.getValue(THIRD) == TripleBlockPart.LOWER) {
                worldIn.setBlock(otherPos1, Blocks.AIR.defaultBlockState(), 35);
                worldIn.levelEvent(player, 2001, otherPos1, Block.getId(blockstate1));
            }
            if (blockstate2.getBlock() == state.getBlock() && blockstate2.getValue(THIRD) == TripleBlockPart.LOWER) {
                worldIn.setBlock(otherPos2, Blocks.AIR.defaultBlockState(), 35);
                worldIn.levelEvent(player, 2001, otherPos1, Block.getId(blockstate1));
            }
        }
        super.playerWillDestroy(worldIn, pos, state, player);
    }

    private int getCloseSound() {
        return this.material == Material.METAL ? 1011 : 1012;
    }

    private int getOpenSound() {
        return this.material == Material.METAL ? 1005 : 1006;
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockPos blockpos = context.getClickedPos();
        if (blockpos.getY() < 255 && context.getLevel().getBlockState(blockpos.above()).canBeReplaced(context) && context.getLevel().getBlockState(blockpos.above(2)).canBeReplaced(context)) {
            Level level = context.getLevel();
            boolean flag = level.hasNeighborSignal(blockpos) || level.hasNeighborSignal(blockpos.above());
            return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection()).setValue(HINGE, this.getHinge(context)).setValue(POWERED, flag).setValue(OPEN, flag).setValue(THIRD, TripleBlockPart.LOWER);
        } else {
            return null;
        }
    }

    @Override
    public void setPlacedBy(Level worldIn, BlockPos pos, BlockState state, LivingEntity placer, ItemStack stack) {
        worldIn.setBlock(pos.above(), state.setValue(THIRD, TripleBlockPart.MIDDLE), 3);
        worldIn.setBlock(pos.above().above(), state.setValue(THIRD, TripleBlockPart.UPPER), 3);
    }

    private DoorHingeSide getHinge(BlockPlaceContext context) {
        BlockGetter BlockGetter = context.getLevel();
        BlockPos placePos = context.getClickedPos();
        Direction behindDir = context.getHorizontalDirection(); // Behind
        BlockPos placePosAbove = placePos.above();
        Direction leftDir = behindDir.getCounterClockWise(); // Left
        BlockPos leftPos = placePos.relative(leftDir); // Left Pos
        BlockState leftBlockstate = BlockGetter.getBlockState(leftPos); // Left BlockState
        BlockPos leftPosAbove = placePosAbove.relative(leftDir); // Left Up Pos
        BlockState leftAboveBlockstate = BlockGetter.getBlockState(leftPosAbove); // Left Up BlockState
        Direction rightDir = behindDir.getClockWise(); // Right
        BlockPos rightPos = placePos.relative(rightDir); // Right Pos
        BlockState rightBlockstate = BlockGetter.getBlockState(rightPos); // Right Blockstate
        BlockPos rightPosAbove = placePosAbove.relative(rightDir); // Right Up Pos
        BlockState rightAboveBlockstate = BlockGetter.getBlockState(rightPosAbove); // Right Up Blockstate
        int i = (leftBlockstate.isCollisionShapeFullBlock(BlockGetter, leftPos) ? -1 : 0) + (leftAboveBlockstate.isCollisionShapeFullBlock(BlockGetter, leftPosAbove) ? -1 : 0) + (rightBlockstate.isCollisionShapeFullBlock(BlockGetter, rightPos) ? 1 : 0) + (rightAboveBlockstate.isCollisionShapeFullBlock(BlockGetter, rightPosAbove) ? 1 : 0);
        boolean leftIsLowerOfSameType = leftBlockstate.getBlock() == this && leftBlockstate.getValue(THIRD) == TripleBlockPart.LOWER;
        boolean rightIsLowerOfSameType = rightBlockstate.getBlock() == this && rightBlockstate.getValue(THIRD) == TripleBlockPart.LOWER;
        if ((!leftIsLowerOfSameType || rightIsLowerOfSameType) && i <= 0) {
            if ((!rightIsLowerOfSameType || leftIsLowerOfSameType) && i >= 0) {
                int j = behindDir.getStepX();
                int k = behindDir.getStepZ();
                Vec3 vec3d = context.getClickLocation();
                double d0 = vec3d.x - (double)placePos.getX();
                double d1 = vec3d.z - (double)placePos.getZ();
                return (j >= 0 || !(d1 < 0.5D)) && (j <= 0 || !(d1 > 0.5D)) && (k >= 0 || !(d0 > 0.5D)) && (k <= 0 || !(d0 < 0.5D)) ? DoorHingeSide.LEFT : DoorHingeSide.RIGHT;
            } else {
                return DoorHingeSide.LEFT;
            }
        } else {
            return DoorHingeSide.RIGHT;
        }
    }

    @Override
    public InteractionResult use(BlockState state, Level worldIn, BlockPos pos, Player player, InteractionHand handIn, BlockHitResult hit) {
        if (this.material == Material.METAL) {
            return InteractionResult.PASS;
        } else {
            state = state.cycle(OPEN);
            worldIn.setBlock(pos, state, 10);
            worldIn.levelEvent(player, state.getValue(OPEN) ? this.getOpenSound() : this.getCloseSound(), pos, 0);
            worldIn.gameEvent(player, state.getValue(OPEN) ? GameEvent.BLOCK_OPEN : GameEvent.BLOCK_CLOSE, pos);
            return InteractionResult.sidedSuccess(worldIn.isClientSide);
        }
    }

    public void toggleDoor(Level worldIn, BlockPos pos, boolean open) {
        BlockState blockstate = worldIn.getBlockState(pos);
        if (blockstate.getBlock() == this && blockstate.getValue(OPEN) != open) {
            worldIn.setBlock(pos, blockstate.setValue(OPEN, open), 10);
            if (blockstate.getValue(THIRD) == TripleBlockPart.UPPER) {
                BlockState middle = worldIn.getBlockState(pos.below());
                BlockState bottom = worldIn.getBlockState(pos.below(2));
                if (middle.getBlock() == this) {
                    worldIn.setBlock(pos.below(), middle.setValue(OPEN, open), 10);
                }
                if (bottom.getBlock() == this) {
                    worldIn.setBlock(pos.below(2), middle.setValue(OPEN, open), 10);
                }
            }
            this.playSound(worldIn, pos, open);
        }
    }

    @Override
    public void neighborChanged(BlockState state, Level worldIn, BlockPos pos, Block blockIn, BlockPos fromPos, boolean isMoving) {
        boolean flag = worldIn.hasNeighborSignal(pos);
        if (!flag) {
            switch(state.getValue(THIRD)) {
                case LOWER:
                    flag = worldIn.hasNeighborSignal(pos.relative(Direction.UP)) || worldIn.hasNeighborSignal(pos.relative(Direction.UP, 2));
                    break;
                case MIDDLE:
                    flag = worldIn.hasNeighborSignal(pos.relative(Direction.DOWN)) || worldIn.hasNeighborSignal(pos.relative(Direction.UP));
                    break;
                case UPPER:
                    flag = worldIn.hasNeighborSignal(pos.relative(Direction.DOWN)) || worldIn.hasNeighborSignal(pos.relative(Direction.DOWN, 2));
                    break;
            }
        }
        if (blockIn != this && flag != state.getValue(POWERED)) {
            if (flag != state.getValue(OPEN)) {
                this.playSound(worldIn, pos, flag);
            }
            worldIn.setBlock(pos, state.setValue(POWERED, flag).setValue(OPEN, flag), 2);
        }
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader worldIn, BlockPos pos) {
        boolean result;
        BlockPos below = pos.below();
        BlockPos below2 = below.below();
        BlockState belowState = worldIn.getBlockState(below);
        BlockState below2State = worldIn.getBlockState(below2);
        if (state.getValue(THIRD) == TripleBlockPart.LOWER) {
            result = belowState.isFaceSturdy(worldIn, below, Direction.UP);
            return result;
        } else if (state.getValue(THIRD) == TripleBlockPart.MIDDLE) {
            result = belowState.getBlock() == this;
            return result;
        } else {
            result = belowState.getBlock() == this && below2State.getBlock() == this;
            return result;
        }
    }

    private void playSound(Level level, BlockPos pos, boolean isOpen) {
        level.levelEvent(null, isOpen ? this.getOpenSound() : this.getCloseSound(), pos, 0);
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public long getSeed(BlockState state, BlockPos pos) {
        return Mth.getSeed(pos.getX(), pos.below(state.getValue(THIRD) == TripleBlockPart.LOWER ? 0 : state.getValue(THIRD) == TripleBlockPart.MIDDLE ? 1 : 2).getY(), pos.getZ());
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(THIRD, FACING, OPEN, HINGE, POWERED);
    }

    public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
        Direction direction = state.getValue(FACING);
        boolean flag = !state.getValue(OPEN);
        boolean flag1 = state.getValue(HINGE) == DoorHingeSide.RIGHT;
        switch(direction) {
            case EAST:
            default:
                return flag ? EAST_AABB : (flag1 ? NORTH_AABB : SOUTH_AABB);
            case SOUTH:
                return flag ? SOUTH_AABB : (flag1 ? EAST_AABB : WEST_AABB);
            case WEST:
                return flag ? WEST_AABB : (flag1 ? SOUTH_AABB : NORTH_AABB);
            case NORTH:
                return flag ? NORTH_AABB : (flag1 ? WEST_AABB : EAST_AABB);
        }
    }

    public boolean allowsMovement(BlockState state, BlockGetter worldIn, BlockPos pos, BlockPathTypes type) {
        switch(type) {
            case WALKABLE:
                return state.getValue(OPEN);
            case WATER:
                return false;
            case OPEN:
                return state.getValue(OPEN);
            default:
                return false;
        }
    }

    public PushReaction getPushReaction(BlockState state) {
        return PushReaction.DESTROY;
    }

    public BlockState rotate(BlockState state, Rotation rot) {
        return state.setValue(FACING, rot.rotate(state.getValue(FACING)));
    }

    public BlockState mirror(BlockState state, Mirror mirrorIn) {
        return mirrorIn == Mirror.NONE ? state : state.rotate(mirrorIn.getRotation(state.getValue(FACING))).cycle(HINGE);
    }

    // TODO: Figure out if Zombie breaking Tall Doors is feasible... Following obfuscated methods are only used for that.
//    public static boolean func_235491_a_(World p_235491_0_, BlockPos p_235491_1_) {
//        return func_235492_h_(p_235491_0_.getBlockState(p_235491_1_));
//    }
//
//    public static boolean func_235492_h_(BlockState p_235492_0_) {
//        return p_235492_0_.getBlock() instanceof TallDoorBlock && (p_235492_0_.getMaterial() == Material.WOOD || p_235492_0_.getMaterial() == Material.field_237214_y_);
//    }
}