package electricfish.item.crafting;

import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;
import electricfish.item.ModItems;

public class ElectricFishCrafting {
    private static ItemStack teslaCoilStack = ic2.core.Ic2Items.teslaCoil;
    private static ItemStack energyCrystalStack = ic2.core.Ic2Items.energyCrystal;
    private static ItemStack magnetizerStack = ic2.core.Ic2Items.magnetizer;

    public static void init(){
        GameRegistry.addRecipe(new ItemStack(ModItems.electricFishingRod), "  c", " m ", "c  ", 't', teslaCoilStack, 'c', energyCrystalStack, 'm', magnetizerStack);
    }
}
