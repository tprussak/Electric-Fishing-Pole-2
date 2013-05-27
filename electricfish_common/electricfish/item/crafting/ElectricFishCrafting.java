package electricfish.item.crafting;

import ic2.api.item.Items;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;
import electricfish.item.ModItems;

public class ElectricFishCrafting {
    private static ItemStack teslaCoilStack = Items.getItem("teslaCoil").copy();
    private static ItemStack energyCrystalStack = Items.getItem("energyCrystal").copy();
    private static ItemStack magnetizerStack = Items.getItem("magnetizer").copy();
    private static ItemStack lapotronCrystalStack = Items.getItem("lapotronCrystal").copy();
    private static ItemStack advancedCircuitStack = Items.getItem("advancedCircuit").copy();
    private static ItemStack electricFishingRodStack = new ItemStack(ModItems.electricFishingRod);
    private static ItemStack advancedElectricFishingRodStack = new ItemStack(ModItems.advancedElectricFishingRod);

    public static void init(){
        GameRegistry.addRecipe(electricFishingRodStack, "  c", " m ", "c  ", 't', teslaCoilStack, 'c', energyCrystalStack, 'm', magnetizerStack);
        GameRegistry.addShapelessRecipe(advancedElectricFishingRodStack, advancedCircuitStack, lapotronCrystalStack, electricFishingRodStack);
    }
}
