package electricfish.item;

import ic2.api.item.ElectricItem;
import ic2.api.item.IElectricItem;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumMovingObjectType;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import electricfish.lib.ItemIds;
import electricfish.util.ElectricFishDamageSource;

public class ItemAdvancedElectricRod extends ItemElectricFish implements IElectricItem{
    public ItemAdvancedElectricRod(int id, String name) {
        super(id, name);
        this.setMaxDamage(27);
    }

    @Override
    public boolean canProvideEnergy(ItemStack arg0) {
        return true;
    }

    @Override
    public int getChargedItemId(ItemStack arg0) {
        return ItemIds.ADVANCED_ELECTRIC_ROD_ID;
    }

    @Override
    public int getEmptyItemId(ItemStack arg0) {
        return ItemIds.ADVANCED_ELECTRIC_ROD_ID;
    }

    @Override
    public int getMaxCharge(ItemStack arg0) {
        return 1000000;
    }

    @Override
    public int getTier(ItemStack arg0) {
        return 3;
    }

    @Override
    public int getTransferLimit(ItemStack arg0) {
        return 15000;
    }
    
    @Override
    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player)
    {
        MovingObjectPosition movingobjectposition = this.getMovingObjectPositionFromPlayer(world, player, true);

        if (movingobjectposition == null)
        {
            return itemStack;
        }
        else
        {
            if (movingobjectposition.typeOfHit == EnumMovingObjectType.TILE)
            {
//                if(tickTimer == 0){
                    if(ElectricItem.manager.canUse(itemStack, 20000)){
                        if(world.getBlockId(movingobjectposition.blockX, movingobjectposition.blockY, movingobjectposition.blockZ) == Block.waterStill.blockID || world.getBlockId(movingobjectposition.blockX, movingobjectposition.blockY, movingobjectposition.blockZ) == Block.waterMoving.blockID){
                            EntityItem entityItem = new EntityItem(world, movingobjectposition.blockX, movingobjectposition.blockY, movingobjectposition.blockZ, new ItemStack(Item.fishCooked, new Random().nextInt(8)));
                            entityItem.motionX = movingobjectposition.blockX - player.posX*2;
                            entityItem.motionY = movingobjectposition.blockY - player.posY*2;
                            entityItem.motionZ = movingobjectposition.blockZ - player.posZ*2;
                            ElectricItem.manager.use(itemStack, 20000, player);
                            world.spawnEntityInWorld(entityItem);
//                            tickTimer = 5;
                            return itemStack;
                        }
                    }
//                }
            }
            return itemStack;
        }
    }
    @Override
    public boolean onLeftClickEntity(ItemStack itemStack, EntityPlayer player, Entity entity) {
        
        if(entity instanceof EntityLiving) {
            if(ElectricItem.manager.canUse(itemStack, 50000)){
                ElectricItem.manager.use(itemStack, 50000, player);
                EntityLiving entityLiving = (EntityLiving) entity;
                entityLiving.attackEntityFrom(ElectricFishDamageSource.electricity, 50);;
                player.attackEntityFrom(ElectricFishDamageSource.electricity, 3);;
            }
        }
        return false;
    }
//    private int tickTimer = 5;
//    @Override
//    public void onUpdate(ItemStack itemStack, World world, Entity entity, int slot, boolean held){
//        if(tickTimer > 0){
//            tickTimer--;
//        }
//    }
}
