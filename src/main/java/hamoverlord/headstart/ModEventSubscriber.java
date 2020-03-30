package hamoverlord.headstart;

import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.registries.IForgeRegistry;
//import net.minecraftforge.registries.IForgeRegistryEntry;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import hamoverlord.headstart.init.ModBlocks;
import hamoverlord.headstart.init.ModItemGroups;
//import net.minecraft.block.Block;
//import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
//import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

/**
 * Subscribe to events from the MOD EventBus that should be handled on both PHYSICAL sides in this class
 *
 * @author Cadiboo
 */

@EventBusSubscriber(modid = Headstart.MODID, bus = EventBusSubscriber.Bus.MOD)

public final class ModEventSubscriber {
	private static final Logger LOGGER = LogManager.getLogger(Headstart.MODID + " Mod Event Subscriber");

	@SubscribeEvent
	public static void onRegisterItems(final RegistryEvent.Register<Item> event) {
		final IForgeRegistry<Item> registry = event.getRegistry();
		// Automatically register BlockItems for all our Blocks
		ModBlocks.BLOCKS.getEntries().stream()
				.map(RegistryObject::get)
				// You can do extra filtering here if you don't want some blocks to have an BlockItem automatically registered for them
				// .filter(block -> needsItemBlock(block))
				// Register the BlockItem for the block
				.forEach(block -> {
					// Make the properties, and make it so that the item will be on our ItemGroup (CreativeTab)
					final Item.Properties properties = new Item.Properties().group(ModItemGroups.MOD_ITEM_GROUP);
					// Create the new BlockItem with the block and it's properties
					final BlockItem blockItem = new BlockItem(block, properties);
					// Set the new BlockItem's registry name to the block's registry name
					blockItem.setRegistryName(block.getRegistryName());
					// Register the BlockItem
					registry.register(blockItem);
				});
		LOGGER.debug("Registered BlockItems");
	}
}
