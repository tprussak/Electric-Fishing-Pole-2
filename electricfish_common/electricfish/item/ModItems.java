package electricfish.item;

import java.util.logging.Logger;

import net.minecraft.item.Item;
import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.registry.LanguageRegistry;
import electricfish.lib.ItemIds;
import electricfish.lib.Strings;

public class ModItems {

    public static Logger log;
    public static Item electricFishingRod;
    public static Configuration config;

    public static void preInit() {

        registerItems();

    }

    public static void init(FMLInitializationEvent event) {
        addNames();
    }

    private static void registerItems() {
        electricFishingRod = new ItemElectricRod(ItemIds.ELECTRIC_ROD_ID, Strings.ELECTRIC_ROD_NAME);
    }

    private static void addNames() {
        LanguageRegistry.addName(electricFishingRod,
                Strings.ELECTRIC_ROD_DISPLAY_NAME);
    }
}
