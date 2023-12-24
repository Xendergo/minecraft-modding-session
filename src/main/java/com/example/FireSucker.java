package com.example;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class FireSucker extends Block {
    public static final BooleanProperty POWERED = BooleanProperty.of("powered");

    FireSucker() {
        super(FabricBlockSettings.create().strength(4));
        setDefaultState(getDefaultState().with(POWERED, false));
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return (BlockState) this.getDefaultState().with(POWERED, ctx.getWorld().isReceivingRedstonePower(ctx.getBlockPos()));
    }

    @Override
    public void neighborUpdate(BlockState state, World world, BlockPos pos, Block sourceBlock, BlockPos sourcePos, boolean notify) {
        if (world.isClient) {
            return;
        }

        if (state.get(POWERED) != world.isReceivingRedstonePower(pos)) {
            world.setBlockState(pos, (BlockState) state.cycle(POWERED), Block.NOTIFY_LISTENERS);
        }
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(POWERED);
    }
}
