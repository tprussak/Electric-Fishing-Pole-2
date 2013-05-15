package electricfish.core.proxy;

import java.io.File;

import net.minecraft.client.Minecraft;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy {
    @Override
    public void registerRenders() {

    }
    
    public int addArmor(String armor) {
        return RenderingRegistry.addNewArmourRendererPrefix(armor);
    }
    public File getMinecraftDir() {
        return Minecraft.getMinecraftDir();
    }
}
