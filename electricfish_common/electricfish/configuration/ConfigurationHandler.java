package electricfish.configuration;

import electricfish.lib.Strings;
import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class ConfigurationHandler {
    
    public static Configuration config;
    public static int electricRod;
    
    public static void config(FMLPreInitializationEvent event) {
        config = new Configuration(
                event.getSuggestedConfigurationFile());
        config.load();
        
        electricRod = config.get(Strings.ITEM_ID_CONFIG_CATEGORY, "CATEGORY_ITEM", 16500).getInt();
        
        config.save();
    }
}
