
package net.mcreator.craigsbuffet.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.UseAction;
import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.Food;

import net.mcreator.craigsbuffet.itemgroup.CraigsbuffetItemGroup;
import net.mcreator.craigsbuffet.CraigsBuffetModElements;

@CraigsBuffetModElements.ModElement.Tag
public class ElderberriesItem extends CraigsBuffetModElements.ModElement {
	@ObjectHolder("craigs_buffet:elderberries")
	public static final Item block = null;

	public ElderberriesItem(CraigsBuffetModElements instance) {
		super(instance, 6);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new FoodItemCustom());
	}

	public static class FoodItemCustom extends Item {
		public FoodItemCustom() {
			super(new Item.Properties().group(CraigsbuffetItemGroup.tab).maxStackSize(64).rarity(Rarity.COMMON)
					.food((new Food.Builder()).hunger(3).saturation(0.3f)

							.build()));
			setRegistryName("elderberries");
		}

		@Override
		public int getUseDuration(ItemStack stack) {
			return 15;
		}

		@Override
		public UseAction getUseAction(ItemStack itemstack) {
			return UseAction.EAT;
		}
	}
}
