package electricfish.item;

import ic2.api.item.IElectricItem;
import net.minecraft.item.ItemStack;
import electricfish.lib.ItemIds;

public class ItemElectricRod extends ItemElectricFish implements IElectricItem{

    public ItemElectricRod(int id, String name) {
        super(id, name);
    }

    @Override
    public boolean canProvideEnergy(ItemStack arg0) {
        return true;
    }

    @Override
    public int getChargedItemId(ItemStack arg0) {
        return ItemIds.ELECTRIC_ROD_ID;
    }

    @Override
    public int getEmptyItemId(ItemStack arg0) {
        return ItemIds.ELECTRIC_ROD_ID;
    }

    @Override
    public int getMaxCharge(ItemStack arg0) {
        return 100000;
    }

    @Override
    public int getTier(ItemStack arg0) {
        return 1;
    }

    @Override
    public int getTransferLimit(ItemStack arg0) {
        return 100;
    }
}
