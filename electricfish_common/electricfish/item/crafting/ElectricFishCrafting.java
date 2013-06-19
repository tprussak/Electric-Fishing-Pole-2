package electricfish.item.crafting;

import ic2.api.item.Items;
import ic2.api.recipe.Recipes;
import net.minecraft.item.ItemStack;
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
        Recipes.advRecipes.addRecipe(electricFishingRodStack, new Object[] {"  m", " t ", "c  ", 't', teslaCoilStack, 'c', energyCrystalStack, 'm', magnetizerStack});
        Recipes.advRecipes.addShapelessRecipe(advancedElectricFishingRodStack, new Object[] {advancedCircuitStack, lapotronCrystalStack, electricFishingRodStack});
    }
}
