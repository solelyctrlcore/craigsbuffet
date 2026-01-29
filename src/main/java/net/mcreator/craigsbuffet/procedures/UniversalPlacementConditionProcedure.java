package net.mcreator.craigsbuffet.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.tags.BlockTags;

import net.mcreator.craigsbuffet.CraigsBuffetMod;

import java.util.Map;

public class UniversalPlacementConditionProcedure {

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				CraigsBuffetMod.LOGGER.warn("Failed to load dependency world for procedure UniversalPlacementCondition!");
			return false;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				CraigsBuffetMod.LOGGER.warn("Failed to load dependency x for procedure UniversalPlacementCondition!");
			return false;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				CraigsBuffetMod.LOGGER.warn("Failed to load dependency y for procedure UniversalPlacementCondition!");
			return false;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				CraigsBuffetMod.LOGGER.warn("Failed to load dependency z for procedure UniversalPlacementCondition!");
			return false;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		if (world.getLight(new BlockPos((int) x, (int) (y + 0.5), (int) z)) >= 8
				&& BlockTags.getCollection().getTagByID(new ResourceLocation("craigs_buffet:farmland"))
						.contains((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock())) {
			return true;
		}
		return false;
	}
}
