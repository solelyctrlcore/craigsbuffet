package net.mcreator.craigsbuffet.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.world.GameType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Hand;
import net.minecraft.tags.BlockTags;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.client.network.play.NetworkPlayerInfo;
import net.minecraft.client.entity.player.AbstractClientPlayerEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.block.Blocks;
import net.minecraft.block.BlockState;

import net.mcreator.craigsbuffet.item.RaspberrySeedsItem;
import net.mcreator.craigsbuffet.block.RaspberryCropStage0Block;
import net.mcreator.craigsbuffet.CraigsBuffetMod;

import java.util.Map;

public class RaspberrySeedsRightClickedOnBlockProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				CraigsBuffetMod.LOGGER.warn("Failed to load dependency world for procedure RaspberrySeedsRightClickedOnBlock!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				CraigsBuffetMod.LOGGER.warn("Failed to load dependency x for procedure RaspberrySeedsRightClickedOnBlock!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				CraigsBuffetMod.LOGGER.warn("Failed to load dependency y for procedure RaspberrySeedsRightClickedOnBlock!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				CraigsBuffetMod.LOGGER.warn("Failed to load dependency z for procedure RaspberrySeedsRightClickedOnBlock!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				CraigsBuffetMod.LOGGER.warn("Failed to load dependency entity for procedure RaspberrySeedsRightClickedOnBlock!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack seeds = ItemStack.EMPTY;
		BlockState stage0 = Blocks.AIR.getDefaultState();
		seeds = new ItemStack(RaspberrySeedsItem.block);
		stage0 = RaspberryCropStage0Block.block.getDefaultState();
		if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getItem() == (seeds).getItem()
				&& BlockTags.getCollection().getTagByID(new ResourceLocation("craigs_buffet:farmland"))
						.contains((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock())
				&& (world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getMaterial() == net.minecraft.block.material.Material.AIR
				&& (stage0).isValidPosition(world, new BlockPos((int) x, (int) (y + 1), (int) z))) {
			{
				BlockPos _bp = new BlockPos((int) x, (int) (y + 1), (int) z);
				BlockState _bs = (stage0);
				world.setBlockState(_bp, _bs, 3);
			}
			if (!(new Object() {
				public boolean checkGamemode(Entity _ent) {
					if (_ent instanceof ServerPlayerEntity) {
						return ((ServerPlayerEntity) _ent).interactionManager.getGameType() == GameType.CREATIVE;
					} else if (_ent instanceof PlayerEntity && _ent.world.isRemote()) {
						NetworkPlayerInfo _npi = Minecraft.getInstance().getConnection()
								.getPlayerInfo(((AbstractClientPlayerEntity) _ent).getGameProfile().getId());
						return _npi != null && _npi.getGameType() == GameType.CREATIVE;
					}
					return false;
				}
			}.checkGamemode(entity))) {
				if (entity instanceof LivingEntity) {
					ItemStack _setstack = ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY);
					_setstack.setCount(
							(int) ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)).getCount()
									- 1));
					((LivingEntity) entity).setHeldItem(Hand.MAIN_HAND, _setstack);
					if (entity instanceof ServerPlayerEntity)
						((ServerPlayerEntity) entity).inventory.markDirty();
				}
			}
		}
	}
}
