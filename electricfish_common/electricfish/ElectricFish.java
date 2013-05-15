package electricfish;

import net.minecraft.creativetab.CreativeTabs;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import electricfish.configuration.ConfigurationHandler;
import electricfish.core.proxy.CommonProxy;
import electricfish.creativetab.CreativeTabElectricFish;
import electricfish.item.ModItems;
import electricfish.lib.Reference;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION, dependencies = "required-after:Forge@[7.7.1.675,)")
public class ElectricFish {

    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
    public static CommonProxy proxy;

    public static CreativeTabs tabsElectricFish = new CreativeTabElectricFish(CreativeTabs.getNextID(), Reference.MOD_NAME);

    @PreInit
    public void preInit(FMLPreInitializationEvent event) {
        ConfigurationHandler.config(event);
        ModItems.preInit();
    }

    @Init
    public void init(FMLInitializationEvent event) {
        ModItems.init(event);
    }

    @PostInit
    public void postInit(FMLPostInitializationEvent event) {

    }
}
