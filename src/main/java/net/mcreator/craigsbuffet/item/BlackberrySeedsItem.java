
package net.mcreator.craigsbuffet.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Direction;
import net.minecraft.util.ActionResultType;
import net.minecraft.item.Rarity;
import net.minecraft.item.ItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.block.BlockState;

import net.mcreator.craigsbuffet.procedures.BlackberrySeedsRightClickedOnBlockProcedure;
import net.mcreator.craigsbuffet.itemgroup.CraigsbuffetItemGroup;
import net.mcreator.craigsbuffet.CraigsBuffetModElements;

import java.util.stream.Stream;
import java.util.Map;
import java.util.HashMap;
import java.util.AbstractMap;

@CraigsBuffetModElements.ModElement.Tag
public class BlackberrySeedsItem extends CraigsBuffetModElements.ModElement {
	@ObjectHolder("craigs_buffet:blackberry_seeds")
	public static final Item block = null;

	public BlackberrySeedsItem(CraigsBuffetModElements instance) {
		super(instance, 28);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(CraigsbuffetItemGroup.tab).maxStackSize(64).rarity(Rarity.COMMON));
			setRegistryName("blackberry_seeds");
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public int getUseDuration(ItemStack itemstack) {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}

		@Override
		public ActionResultType onItemUseFirst(ItemStack stack, ItemUseContext context) {
			ActionResultType retval = super.onItemUseFirst(stack, context);
			World world = context.getWorld();
			BlockPos pos = context.getPos();
			PlayerEntity entity = context.getPlayer();
			Direction direction = context.getFace();
			BlockState blockstate = world.getBlockState(pos);
			int x = pos.getX();
			int y = pos.getY();
			int z = pos.getZ();
			ItemStack itemstack = context.getItem();

			BlackberrySeedsRightClickedOnBlockProcedure.executeProcedure(Stream
					.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x), new AbstractMap.SimpleEntry<>("y", y),
							new AbstractMap.SimpleEntry<>("z", z), new AbstractMap.SimpleEntry<>("entity", entity))
					.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			return retval;
		}
	}
}
