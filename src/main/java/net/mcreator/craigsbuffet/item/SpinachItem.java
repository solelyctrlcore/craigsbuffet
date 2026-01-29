
package net.mcreator.craigsbuffet.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.UseAction;
import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.Food;

import net.mcreator.craigsbuffet.CraigsBuffetModElements;

@CraigsBuffetModElements.ModElement.Tag
public class SpinachItem extends CraigsBuffetModElements.ModElement {
	@ObjectHolder("craigs_buffet:spinach")
	public static final Item block = null;

	public SpinachItem(CraigsBuffetModElements instance) {
		super(instance, 57);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new FoodItemCustom());
	}

	public static class FoodItemCustom extends Item {
		public FoodItemCustom() {
			super(new Item.Properties().group(ItemGroup.FOOD).maxStackSize(64).rarity(Rarity.COMMON)
					.food((new Food.Builder()).hunger(1).saturation(0.3f)

							.build()));
			setRegistryName("spinach");
		}

		@Override
		public int getUseDuration(ItemStack stack) {
			return 10;
		}

		@Override
		public UseAction getUseAction(ItemStack itemstack) {
			return UseAction.EAT;
		}
	}
}
