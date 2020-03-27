package hamoverlord.headstart;

import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(Headstart.MODID)
public class Headstart {
	public static final String MODID = "headstart";
	
	public static final Logger LOGGER = LogManager.getLogger(MODID);
	
	public Headstart() {
		LOGGER.debug("There's probably a pun for loading something called Headstart but I can't think of anything :(");
	}
}
