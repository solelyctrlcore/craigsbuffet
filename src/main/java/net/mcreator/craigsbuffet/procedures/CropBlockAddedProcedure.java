package net.mcreator.craigsbuffet.procedures;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.block.BlockState;

import net.mcreator.craigsbuffet.CraigsBuffetMod;

import java.util.Map;

public class CropBlockAddedProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				CraigsBuffetMod.LOGGER.warn("Failed to load dependency world for procedure CropBlockAdded!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				CraigsBuffetMod.LOGGER.warn("Failed to load dependency x for procedure CropBlockAdded!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				CraigsBuffetMod.LOGGER.warn("Failed to load dependency y for procedure CropBlockAdded!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				CraigsBuffetMod.LOGGER.warn("Failed to load dependency z for procedure CropBlockAdded!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		if (!world.isRemote()) {
			BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
			TileEntity _tileEntity = world.getTileEntity(_bp);
			BlockState _bs = world.getBlockState(_bp);
			if (_tileEntity != null)
				_tileEntity.getTileData().putDouble("GrowthTime", 0);
			if (world instanceof World)
				((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
		}
	}
}
