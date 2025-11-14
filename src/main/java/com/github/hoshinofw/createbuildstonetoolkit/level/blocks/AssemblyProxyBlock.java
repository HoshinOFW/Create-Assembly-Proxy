package com.github.hoshinofw.createbuildstonetoolkit.level.blocks;

import com.github.hoshinofw.createbuildstonetoolkit.level.blocks.entities.AssemblyProxyBlockEntity;
import com.github.hoshinofw.createbuildstonetoolkit.registries.CBTBlockEntities;
import com.github.hoshinofw.buildstonetoolkit.common.level.blocks.IProxyBlock;
import com.github.hoshinofw.buildstonetoolkit.common.level.blocks.IProxyEntityBlock;
import com.github.hoshinofw.buildstonetoolkit.util.Util;
import com.simibubi.create.content.equipment.wrench.IWrenchable;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.piston.PistonMovingBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.Optional;

@ParametersAreNonnullByDefault
public class AssemblyProxyBlock extends Block implements EntityBlock, IProxyBlock, IProxyEntityBlock, IWrenchable {
    public AssemblyProxyBlock(Properties arg) {
        super(arg);
        this.registerDefaultState(this.defaultBlockState()
                .setValue(POWER_LEVEL, 0));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(POWER_LEVEL);
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(@NotNull BlockPos pos, @NotNull BlockState state) {
        return new AssemblyProxyBlockEntity(pos, state);
    }

    @Override
    public void neighborChanged(@NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos, @NotNull Block block, @NotNull BlockPos pos2, boolean bl) {
        IProxyBlock.super.neighborChanged(state, level, pos, block, pos2, bl);
    }

    @Override
    public void onPlace(@NotNull BlockState oldState, Level level, BlockPos pos, BlockState newState, boolean bl) {
        IProxyBlock.super.onPlace(oldState, level, pos, newState, bl);
    }

    @Override
    public boolean shouldPreserveTargetAbsPos(@NotNull Level level, @NotNull PistonMovingBlockEntity pistonMovingBlockEntity, BlockPos blockPos, BlockPos blockPos1, Direction direction) {
        return false;
    }

    @Override
    public boolean shouldTransferMovement(BlockPos blockPos, BlockState blockState, Direction direction) {
        return false;
    }

    @Override
    public @Nullable BlockPos getLinkedBlockPos(@NotNull Level level, BlockPos blockPos) {
        Optional<AssemblyProxyBlockEntity> optionalBE = level.getBlockEntity(blockPos, CBTBlockEntities.ASSEMBLY_PROXY.get());
        return optionalBE.map(AssemblyProxyBlockEntity::getTargetBlockPos).orElse(null);
    }

    @Override
    public Util.FailableResult<BlockPos> parsePos(@NotNull Level level, BlockPos proxyPos, BlockPos inputPos) {
        BlockPos outputPos = inputPos.subtract(proxyPos);
        return new Util.FailableResult<>(outputPos, true);
    }

    @Override
    public boolean setLinkedRelPos(@NotNull Level level, BlockPos pos, BlockPos newRelativeTargetPos) {
        BlockEntity be = level.getBlockEntity(pos);
        if (be instanceof AssemblyProxyBlockEntity apBE) {
            apBE.setTargetOffset(newRelativeTargetPos);
            apBE.setChanged();
            level.sendBlockUpdated(pos, apBE.getBlockState(), apBE.getBlockState(), Block.UPDATE_ALL);
            return true;
        }

        return false;
    }

    @Override
    public void offsetLinkedPos(Level level, BlockPos blockPos, BlockState blockState, Direction direction) {
        Optional<AssemblyProxyBlockEntity> optionalBE = level.getBlockEntity(blockPos, CBTBlockEntities.ASSEMBLY_PROXY.get());
        if (optionalBE.isPresent()) {
            AssemblyProxyBlockEntity blockEntity = optionalBE.get();
            blockEntity.setTargetOffset(blockEntity.getTargetOffset().relative(direction.getOpposite()));
        }
    }

    @Override
    public void offsetLinkedPos(Level level, BlockPos blockPos, BlockState blockState, Direction direction, int i) {
        Optional<AssemblyProxyBlockEntity> optionalBE = level.getBlockEntity(blockPos, CBTBlockEntities.ASSEMBLY_PROXY.get());
        if (optionalBE.isPresent()) {
            AssemblyProxyBlockEntity blockEntity = optionalBE.get();
            blockEntity.setTargetOffset(blockEntity.getTargetOffset().relative(direction.getOpposite(), i));
        }
    }

    @Override
    public BlockState computeNewStateWithPreservedTargetAbsPos(Level level, BlockPos blockPos, BlockState oldState, Direction direction) {
        return oldState;
    }

    @Override
    public CompoundTag computeNewNBTWithPreservedTargetAbsPos(Level level, BlockPos blockPos, BlockState blockState, @Nullable CompoundTag compoundTag, Direction direction) {
        return compoundTag;
    }

    @Override
    public BlockState computeNewStateWithPreservedTargetAbsPos(Level level, BlockPos blockPos, CompoundTag compoundTag, BlockState oldState, Direction direction) {
        return oldState;
    }
}
