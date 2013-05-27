package electricfish.configuration;

import electricfish.lib.Strings;
import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class ConfigurationHandler {
    
    public static Configuration config;
    public static int electricRod;
    public static int advancedElectricRod;
    
    public static void config(FMLPreInitializationEvent event) {
        config = new Configuration(
                event.getSuggestedConfigurationFile());
        config.load();
        
        electricRod = config.get(Strings.ITEM_ID_CONFIG_CATEGORY, "Electric Fishing Rod ID", 16500).getInt();
        advancedElectricRod = config.get(Strings.ITEM_ID_CONFIG_CATEGORY, "Advanced Electric Fishing Rod ID", 16501).getInt();
        
        config.save();
    }
}
