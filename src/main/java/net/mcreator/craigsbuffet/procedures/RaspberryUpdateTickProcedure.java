package net.mcreator.craigsbuffet.procedures;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.block.Blocks;
import net.minecraft.block.BlockState;

import net.mcreator.craigsbuffet.block.RaspberryCropStage2FinalBlock;
import net.mcreator.craigsbuffet.block.RaspberryCropStage1Block;
import net.mcreator.craigsbuffet.block.RaspberryCropStage0Block;
import net.mcreator.craigsbuffet.CraigsBuffetMod;

import java.util.Map;

public class RaspberryUpdateTickProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				CraigsBuffetMod.LOGGER.warn("Failed to load dependency world for procedure RaspberryUpdateTick!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				CraigsBuffetMod.LOGGER.warn("Failed to load dependency x for procedure RaspberryUpdateTick!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				CraigsBuffetMod.LOGGER.warn("Failed to load dependency y for procedure RaspberryUpdateTick!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				CraigsBuffetMod.LOGGER.warn("Failed to load dependency z for procedure RaspberryUpdateTick!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		BlockState stage0 = Blocks.AIR.getDefaultState();
		BlockState stage1 = Blocks.AIR.getDefaultState();
		BlockState stage2 = Blocks.AIR.getDefaultState();
		stage0 = RaspberryCropStage0Block.block.getDefaultState();
		stage1 = RaspberryCropStage1Block.block.getDefaultState();
		stage2 = RaspberryCropStage2FinalBlock.block.getDefaultState();
		if (new Object() {
			public double getValue(IWorld world, BlockPos pos, String tag) {
				TileEntity tileEntity = world.getTileEntity(pos);
				if (tileEntity != null)
					return tileEntity.getTileData().getDouble(tag);
				return -1;
			}
		}.getValue(world, new BlockPos((int) x, (int) y, (int) z), "GrowthTime") <= 0) {
			if ((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == (stage0).getBlock()
					&& (stage1).isValidPosition(world, new BlockPos((int) x, (int) y, (int) z))) {
				{
					BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
					BlockState _bs = (stage1);
					world.setBlockState(_bp, _bs, 3);
				}
			} else if ((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == (stage1).getBlock()
					&& (stage2).isValidPosition(world, new BlockPos((int) x, (int) y, (int) z))) {
				{
					BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
					BlockState _bs = (stage2);
					world.setBlockState(_bp, _bs, 3);
				}
			}
			if (!world.isRemote()) {
				BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
				TileEntity _tileEntity = world.getTileEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_tileEntity != null)
					_tileEntity.getTileData().putDouble("GrowthTime", 0);
				if (world instanceof World)
					((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
			}
		} else {
			if (!world.isRemote()) {
				BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
				TileEntity _tileEntity = world.getTileEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_tileEntity != null)
					_tileEntity.getTileData().putDouble("GrowthTime", ((new Object() {
						public double getValue(IWorld world, BlockPos pos, String tag) {
							TileEntity tileEntity = world.getTileEntity(pos);
							if (tileEntity != null)
								return tileEntity.getTileData().getDouble(tag);
							return -1;
						}
					}.getValue(world, new BlockPos((int) x, (int) y, (int) z), "GrowthTime")) - 1));
				if (world instanceof World)
					((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
			}
		}
	}
}
