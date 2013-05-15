package electricfish.item;

import net.minecraft.item.Item;
import electricfish.ElectricFish;
import electricfish.lib.Reference;

public class ItemElectricFish extends Item {

    public ItemElectricFish(int id, String itemName) {
        super(id - Reference.SHIFTED_RANGE_ID_CORRECTION);
        this.setUnlocalizedName(itemName);
        this.setCreativeTab(ElectricFish.tabsElectricFish);
    }
}
