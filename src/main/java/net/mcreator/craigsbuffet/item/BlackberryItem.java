
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
public class BlackberryItem extends CraigsBuffetModElements.ModElement {
	@ObjectHolder("craigs_buffet:blackberry")
	public static final Item block = null;

	public BlackberryItem(CraigsBuffetModElements instance) {
		super(instance, 4);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new FoodItemCustom());
	}

	public static class FoodItemCustom extends Item {
		public FoodItemCustom() {
			super(new Item.Properties().group(CraigsbuffetItemGroup.tab).maxStackSize(64).rarity(Rarity.COMMON)
					.food((new Food.Builder()).hunger(4).saturation(0.3f).setAlwaysEdible()

							.build()));
			setRegistryName("blackberry");
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
