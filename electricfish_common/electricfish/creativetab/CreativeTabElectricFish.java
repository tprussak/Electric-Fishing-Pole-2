package electricfish.creativetab;

import electricfish.lib.ItemIds;
import net.minecraft.creativetab.CreativeTabs;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class CreativeTabElectricFish extends CreativeTabs{

    public CreativeTabElectricFish(int par1, String par2Str) {
        
        super(par1, par2Str);
    }
    @Override
    @SideOnly(Side.CLIENT)
    public int getTabIconItemIndex() {

        return ItemIds.ELECTRIC_ROD_ID;
    }
}
