package hamoverlord.headstart;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import hamoverlord.headstart.init.ModBlocks;
import hamoverlord.headstart.init.ModItems;

@Mod(Headstart.MODID)
public class Headstart {
	public static final String MODID = "headstart";
	
	public static final Logger LOGGER = LogManager.getLogger(MODID);
	
	public Headstart() {
		LOGGER.debug("There's probably a pun for loading something called Headstart but I can't think of anything :(");
		
		final ModLoadingContext modLoadingContext = ModLoadingContext.get();
		final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

		// Register Deferred Registers (Does not need to be before Configs)
		ModBlocks.BLOCKS.register(modEventBus);
		ModItems.ITEMS.register(modEventBus);
		/*ModContainerTypes.CONTAINER_TYPES.register(modEventBus);
		ModTileEntityTypes.TILE_ENTITY_TYPES.register(modEventBus);
		// Register Configs (Does not need to be after Deferred Registers)
		modLoadingContext.registerConfig(ModConfig.Type.CLIENT, ConfigHolder.CLIENT_SPEC);
		modLoadingContext.registerConfig(ModConfig.Type.SERVER, ConfigHolder.SERVER_SPEC);
		*/
	}
}
