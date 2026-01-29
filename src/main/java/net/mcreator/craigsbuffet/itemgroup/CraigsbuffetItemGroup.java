
package net.mcreator.craigsbuffet.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.mcreator.craigsbuffet.item.StrawberryItem;
import net.mcreator.craigsbuffet.CraigsBuffetModElements;

@CraigsBuffetModElements.ModElement.Tag
public class CraigsbuffetItemGroup extends CraigsBuffetModElements.ModElement {
	public CraigsbuffetItemGroup(CraigsBuffetModElements instance) {
		super(instance, 11);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabcraigsbuffet") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(StrawberryItem.block);
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}

	public static ItemGroup tab;
}
