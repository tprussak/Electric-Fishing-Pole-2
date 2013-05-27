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
        return 2;
    }

    @Override
    public int getTransferLimit(ItemStack arg0) {
        return 1500;
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
                if(ElectricItem.manager.canUse(itemStack, 5000)){
                    if(world.getBlockId(movingobjectposition.blockX, movingobjectposition.blockY, movingobjectposition.blockZ) == Block.waterStill.blockID){
                        EntityItem entityItem = new EntityItem(world, movingobjectposition.blockX, movingobjectposition.blockY, movingobjectposition.blockZ, new ItemStack(Item.fishRaw, new Random().nextInt(5) +3));
                        entityItem.motionX = movingobjectposition.blockX - player.posX*2;
                        entityItem.motionY = movingobjectposition.blockY - player.posY*2;
                        entityItem.motionZ = movingobjectposition.blockZ - player.posZ*2;
                        ElectricItem.manager.use(itemStack, 5000, player);
                        world.spawnEntityInWorld(entityItem);
                        return itemStack;
                    }
                }
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
                entityLiving.attackEntityFrom(ElectricFishDamageSource.electricity, 30);
                player.attackEntityFrom(ElectricFishDamageSource.electricity, 15);;
            }
        }
        return false;
    }
}