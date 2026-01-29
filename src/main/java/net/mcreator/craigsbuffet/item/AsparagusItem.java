
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
public class AsparagusItem extends CraigsBuffetModElements.ModElement {
	@ObjectHolder("craigs_buffet:asparagus")
	public static final Item block = null;

	public AsparagusItem(CraigsBuffetModElements instance) {
		super(instance, 56);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new FoodItemCustom());
	}

	public static class FoodItemCustom extends Item {
		public FoodItemCustom() {
			super(new Item.Properties().group(ItemGroup.FOOD).maxStackSize(64).rarity(Rarity.COMMON)
					.food((new Food.Builder()).hunger(3).saturation(0.3f)

							.build()));
			setRegistryName("asparagus");
		}

		@Override
		public UseAction getUseAction(ItemStack itemstack) {
			return UseAction.EAT;
		}
	}
}
