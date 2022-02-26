package com.fuzs.aquaacrobatics.block;

import git.jbredwards.fluidlogged_api.common.block.IFluidloggable;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nonnull;

import static net.minecraft.block.BlockLiquid.LEVEL;

public class UnderwaterPlantBlock extends Block implements IFluidloggable {
    protected UnderwaterPlantBlock() {
        super(Material.PLANTS);
        this.setHardness(0.0F);
        this.setSoundType(SoundType.PLANT);
    }

    @Override
    public boolean isFluidValid(@Nonnull IBlockState state, @Nonnull Fluid fluid) {
        return fluid == FluidRegistry.WATER;
    }

    // not opaque
    @Override
    public boolean isOpaqueCube(IBlockState state)
    {
        return false;
    }

    // not full cube
    @Override
    public boolean isFullCube(IBlockState state)
    {
        return false;
    }

    @Override
    public AxisAlignedBB getCollisionBoundingBox(IBlockState state, IBlockAccess world, BlockPos pos)
    {
        return NULL_AABB;
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public BlockRenderLayer getBlockLayer()
    {
        return BlockRenderLayer.CUTOUT;
    }

    @Override
    public boolean isReplaceable(IBlockAccess worldIn, BlockPos pos) {
        return false;
    }

    public static boolean destroyBlockToWater(World world, BlockPos pos, boolean dropBlock) {
        return world.destroyBlock(pos, dropBlock);
    }
}