package hamoverlord.headstart.init;

import java.util.function.Supplier;

import hamoverlord.headstart.Headstart;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

public class ModItemGroups {
	public static final ItemGroup MOD_ITEM_GROUP = new ModItemGroup(Headstart.MODID, () -> new ItemStack(Items.PLAYER_HEAD));
	
	public static class ModItemGroup extends ItemGroup {
		private final Supplier<ItemStack> iconSupplier;
		
		public ModItemGroup(final String name, final Supplier<ItemStack> iconSupplier ) {
			super(name);
			this.iconSupplier = iconSupplier;
		}
		
		@Override
		public ItemStack createIcon() {
			return iconSupplier.get();
		}
	}

}
