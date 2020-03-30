package hamoverlord.headstart.init;

import hamoverlord.headstart.Headstart;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

/**
 * Holds a list of all our {@link Block}s.
 * Suppliers that create Blocks are added to the DeferredRegister.
 * The DeferredRegister is then added to our mod event bus in our constructor.
 * When the Block Registry Event is fired by Forge and it is time for the mod to
 * register its Blocks, our Blocks are created and registered by the DeferredRegister.
 * The Block Registry Event will always be called before the Item registry is filled.
 * Note: This supports registry overrides.
 *
 * @author Cadiboo
 */

public final class ModBlocks {

	public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, Headstart.MODID);

	public static final RegistryObject<Block> GLOWING_GRASS = BLOCKS.register("glowing_grass", () -> new Block(Block.Properties.create(Material.EARTH, MaterialColor.GRASS).hardnessAndResistance(0.5F, 1.0F).lightValue(11).notSolid()));
	public static final RegistryObject<Block> TOKEN_BLOCK = BLOCKS.register("token_block", () -> new Block(Block.Properties.create(Material.IRON, MaterialColor.IRON).hardnessAndResistance(5.0F, 6.0F).sound(SoundType.METAL)));
}