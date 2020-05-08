package com.fizzware.dramaticdoors.blocks;

import javax.annotation.Nullable;

import com.fizzware.dramaticdoors.state.properties.DoorBlockStateProperties;
import com.fizzware.dramaticdoors.state.properties.TripleBlockPart;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.PushReaction;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.pathfinding.PathType;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.state.properties.DoorHingeSide;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class TallDoorBlock extends Block {

    public static final String NAME_OAK = "tall_oak_door";
    public static final String NAME_SPRUCE = "tall_spruce_door";
    public static final String NAME_BIRCH = "tall_birch_door";
    public static final String NAME_JUNGLE = "tall_jungle_door";
    public static final String NAME_ACACIA = "tall_acacia_door";
    public static final String NAME_DARK_OAK = "tall_dark_oak_door";
    public static final String NAME_IRON = "tall_iron_door";

    public static final EnumProperty<TripleBlockPart> THIRD = DoorBlockStateProperties.TRIPLE_BLOCK_THIRD;
    public static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;
    public static final BooleanProperty OPEN = BlockStateProperties.OPEN;
    public static final EnumProperty<DoorHingeSide> HINGE = BlockStateProperties.DOOR_HINGE;
    public static final BooleanProperty POWERED = BlockStateProperties.POWERED;
    protected static final VoxelShape SOUTH_AABB = Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 3.0D);
    protected static final VoxelShape NORTH_AABB = Block.makeCuboidShape(0.0D, 0.0D, 13.0D, 16.0D, 16.0D, 16.0D);
    protected static final VoxelShape WEST_AABB = Block.makeCuboidShape(13.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D);
    protected static final VoxelShape EAST_AABB = Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 3.0D, 16.0D, 16.0D);


    public TallDoorBlock(Block from) {
        super(Properties.from(from));
        this.setDefaultState(this.stateContainer.getBaseState().with(FACING, Direction.NORTH).with(OPEN, Boolean.FALSE).with(HINGE, DoorHingeSide.LEFT).with(POWERED, Boolean.FALSE).with(THIRD, TripleBlockPart.LOWER));
    }

    @Override
    public BlockState updatePostPlacement(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos) {
        TripleBlockPart tripleblockpart = stateIn.get(THIRD);
        if (facing.getAxis() == Direction.Axis.Y && ((tripleblockpart == TripleBlockPart.LOWER == (facing == Direction.UP)) || tripleblockpart == TripleBlockPart.MIDDLE)) {
            if (facingState.getBlock() == this && facingState.get(THIRD) != tripleblockpart) {
                return stateIn.with(FACING, facingState.get(FACING)).with(OPEN, facingState.get(OPEN)).with(HINGE, facingState.get(HINGE)).with(POWERED, facingState.get(POWERED));
            } else {
                return Blocks.AIR.getDefaultState();
            }
        } else {
            if (tripleblockpart == TripleBlockPart.LOWER && facing == Direction.DOWN && !stateIn.isValidPosition(worldIn, currentPos)) {
                return  Blocks.AIR.getDefaultState();
            } else {
                return super.updatePostPlacement(stateIn, facing, facingState, worldIn, currentPos, facingPos);
            }
        }
    }

    @Override
    public void onBlockHarvested(World worldIn, BlockPos pos, BlockState state, PlayerEntity player) {
        TripleBlockPart tripleblockpart = state.get(THIRD);
        BlockPos otherPos1 = pos;
        BlockPos otherPos2 = pos;
        ItemStack itemstack = player.getHeldItemMainhand();
        switch (tripleblockpart) {
            case LOWER:
                otherPos1 = pos.up();
                otherPos2 = pos.up(2);
                break;
            case MIDDLE:
                otherPos1 = pos.down();
                otherPos2 = pos.up();
                break;
            case UPPER:
                otherPos1 = pos.down(2);
                otherPos2 = pos.down();
                break;
        }
        BlockState blockstate1 = worldIn.getBlockState(otherPos1);
        BlockState blockstate2 = worldIn.getBlockState(otherPos2);
        boolean flag = false;
        if (blockstate1.getBlock() == this && blockstate1.get(THIRD) != tripleblockpart) {
            worldIn.setBlockState(otherPos1, Blocks.AIR.getDefaultState(), 35);
            worldIn.playEvent(player, 2001, otherPos1, Block.getStateId(blockstate1));
            if (!worldIn.isRemote && !player.isCreative()) {
                flag = true;
                Block.spawnDrops(blockstate1, worldIn, otherPos1, (TileEntity)null, player, itemstack);
            }
        }
        if (blockstate2.getBlock() == this && blockstate2.get(THIRD) != tripleblockpart) {
            worldIn.setBlockState(otherPos1, Blocks.AIR.getDefaultState(), 35);
            worldIn.playEvent(player, 2001, otherPos1, Block.getStateId(blockstate2));
            if (!worldIn.isRemote && !player.isCreative()) {
                flag = true;
                Block.spawnDrops(blockstate2, worldIn, otherPos1, (TileEntity)null, player, itemstack);
            }
        }
        if (flag) {
            Block.spawnDrops(state, worldIn, pos, (TileEntity) null, player, itemstack);
        }

        super.onBlockHarvested(worldIn, pos, state, player);
    }

    private int getCloseSound() {
        return this.material == Material.IRON ? 1011 : 1012;
    }

    private int getOpenSound() {
        return this.material == Material.IRON ? 1005 : 1006;
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        BlockPos blockpos = context.getPos();
        if (blockpos.getY() < 255 && context.getWorld().getBlockState(blockpos.up()).isReplaceable(context) && context.getWorld().getBlockState(blockpos.up(2)).isReplaceable(context)) {
            World world = context.getWorld();
            boolean flag = world.isBlockPowered(blockpos) || world.isBlockPowered(blockpos.up());
            return this.getDefaultState().with(FACING, context.getPlacementHorizontalFacing()).with(HINGE, this.getHingeSide(context)).with(POWERED, flag).with(OPEN, flag).with(THIRD, TripleBlockPart.LOWER);
        } else {
            return null;
        }
    }

    @Override
    public void onBlockPlacedBy(World worldIn, BlockPos pos, BlockState state, LivingEntity placer, ItemStack stack) {
        worldIn.setBlockState(pos.up(), state.with(THIRD, TripleBlockPart.MIDDLE), 3);
        worldIn.setBlockState(pos.up().up(), state.with(THIRD, TripleBlockPart.UPPER), 3);
    }

    private DoorHingeSide getHingeSide(BlockItemUseContext p_208073_1_) {
        IBlockReader iblockreader = p_208073_1_.getWorld();
        BlockPos placePos = p_208073_1_.getPos();
        Direction behindDir = p_208073_1_.getPlacementHorizontalFacing(); // Behind
        BlockPos placePosAbove = placePos.up();
        Direction leftDir = behindDir.rotateYCCW(); // Left
        BlockPos leftPos = placePos.offset(leftDir); // Left Pos
        BlockState leftBlockstate = iblockreader.getBlockState(leftPos); // Left BlockState
        BlockPos leftPosAbove = placePosAbove.offset(leftDir); // Left Up Pos
        BlockState leftAboveBlockstate = iblockreader.getBlockState(leftPosAbove); // Left Up BlockState
        Direction rightDir = behindDir.rotateY(); // Right
        BlockPos rightPos = placePos.offset(rightDir); // Right Pos
        BlockState rightBlockstate = iblockreader.getBlockState(rightPos); // Right Blockstate
        BlockPos rightPosAbove = placePosAbove.offset(rightDir); // Right Up Pos
        BlockState rightAboveBlockstate = iblockreader.getBlockState(rightPosAbove); // Right Up Blockstate
        int i = (leftBlockstate.func_224756_o(iblockreader, leftPos) ? -1 : 0) + (leftAboveBlockstate.func_224756_o(iblockreader, leftPosAbove) ? -1 : 0) + (rightBlockstate.func_224756_o(iblockreader, rightPos) ? 1 : 0) + (rightAboveBlockstate.func_224756_o(iblockreader, rightPosAbove) ? 1 : 0);
        boolean leftIsLowerOfSameType = leftBlockstate.getBlock() == this && leftBlockstate.get(THIRD) == TripleBlockPart.LOWER;
        boolean rightIsLowerOfSameType = rightBlockstate.getBlock() == this && rightBlockstate.get(THIRD) == TripleBlockPart.LOWER;
        if ((!leftIsLowerOfSameType || rightIsLowerOfSameType) && i <= 0) {
            if ((!rightIsLowerOfSameType || leftIsLowerOfSameType) && i >= 0) {
                int j = behindDir.getXOffset();
                int k = behindDir.getZOffset();
                Vec3d vec3d = p_208073_1_.getHitVec();
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
    public boolean onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        if (this.material == Material.IRON) {
            return false;
        } else {
            state = state.cycle(OPEN);
            worldIn.setBlockState(pos, state, 10);
            worldIn.playEvent(player, state.get(OPEN) ? this.getOpenSound() : this.getCloseSound(), pos, 0);
            return true;
        }
    }

    public void toggleDoor(World worldIn, BlockPos pos, boolean open) {
        BlockState blockstate = worldIn.getBlockState(pos);
        if (blockstate.getBlock() == this && blockstate.get(OPEN) != open) {
            worldIn.setBlockState(pos, blockstate.with(OPEN, Boolean.valueOf(open)), 10);
            if (blockstate.get(THIRD) == TripleBlockPart.UPPER) {
                BlockState middle = worldIn.getBlockState(pos.down());
                BlockState bottom = worldIn.getBlockState(pos.down(2));
                if (middle.getBlock() == this) {
                    middle = middle.cycle(OPEN);
                    worldIn.setBlockState(pos.down(), middle, 10);
                }
                if (bottom.getBlock() == this) {
                    bottom = bottom.cycle(OPEN);
                    worldIn.setBlockState(pos.down(2), bottom, 10);
                }
            }
            this.playSound(worldIn, pos, open);
        }
    }

    @Override
    public void neighborChanged(BlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos, boolean isMoving) {
        boolean flag = worldIn.isBlockPowered(pos);
        if (!flag) {
            switch(state.get(THIRD)) {
                case LOWER:
                    flag = worldIn.isBlockPowered(pos.offset(Direction.UP)) || worldIn.isBlockPowered(pos.offset(Direction.UP, 2));
                    break;
                case MIDDLE:
                    flag = worldIn.isBlockPowered(pos.offset(Direction.DOWN)) || worldIn.isBlockPowered(pos.offset(Direction.UP));
                    break;
                case UPPER:
                    flag = worldIn.isBlockPowered(pos.offset(Direction.DOWN)) || worldIn.isBlockPowered(pos.offset(Direction.DOWN, 2));
                    break;
            }
        }
        if (blockIn != this && flag != state.get(POWERED)) {
            if (flag != state.get(OPEN)) {
                this.playSound(worldIn, pos, flag);
            }
            worldIn.setBlockState(pos, state.with(POWERED, flag).with(OPEN, flag), 2);
        }
    }

    @Override
    public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos) {
        boolean result;
        BlockPos below = pos.down();
        BlockPos below2 = below.down();
        BlockState belowState = worldIn.getBlockState(below);
        BlockState below2State = worldIn.getBlockState(below2);
        if (state.get(THIRD) == TripleBlockPart.LOWER) {
            result = belowState.func_224755_d(worldIn, below, Direction.UP);
            return result;
        } else if (state.get(THIRD) == TripleBlockPart.MIDDLE) {
            result = belowState.getBlock() == this;
            return result;
        } else {
            result = belowState.getBlock() == this && below2State.getBlock() == this;
            return result;
        }
    }

    private void playSound(World p_196426_1_, BlockPos p_196426_2_, boolean p_196426_3_) {
        p_196426_1_.playEvent((PlayerEntity)null, p_196426_3_ ? this.getOpenSound() : this.getCloseSound(), p_196426_2_, 0);
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public long getPositionRandom(BlockState state, BlockPos pos) {
        return MathHelper.getCoordinateRandom(pos.getX(), pos.down(state.get(THIRD) == TripleBlockPart.LOWER ? 0 : state.get(THIRD) == TripleBlockPart.MIDDLE ? 1 : 2).getY(), pos.getZ());
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(THIRD, FACING, OPEN, HINGE, POWERED);
    }

    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        Direction direction = state.get(FACING);
        boolean flag = !state.get(OPEN);
        boolean flag1 = state.get(HINGE) == DoorHingeSide.RIGHT;
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

    public void harvestBlock(World worldIn, PlayerEntity player, BlockPos pos, BlockState state, @Nullable TileEntity te, ItemStack stack) {
        super.harvestBlock(worldIn, player, pos, Blocks.AIR.getDefaultState(), te, stack);
    }

    public boolean allowsMovement(BlockState state, IBlockReader worldIn, BlockPos pos, PathType type) {
        switch(type) {
            case LAND:
                return state.get(OPEN);
            case WATER:
                return false;
            case AIR:
                return state.get(OPEN);
            default:
                return false;
        }
    }

    public PushReaction getPushReaction(BlockState state) {
        return PushReaction.DESTROY;
    }

    public BlockRenderLayer getRenderLayer() {
        return BlockRenderLayer.CUTOUT;
    }

    public BlockState rotate(BlockState state, Rotation rot) {
        return state.with(FACING, rot.rotate(state.get(FACING)));
    }

    public BlockState mirror(BlockState state, Mirror mirrorIn) {
        return mirrorIn == Mirror.NONE ? state : state.rotate(mirrorIn.toRotation(state.get(FACING))).cycle(HINGE);
    }
}