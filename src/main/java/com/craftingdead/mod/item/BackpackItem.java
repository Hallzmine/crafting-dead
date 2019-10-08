package com.craftingdead.mod.item;


import com.craftingdead.mod.container.BackpackContainer;
import com.craftingdead.mod.inventory.BackpackInventory;
import com.craftingdead.mod.type.Backpack;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.DyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

import net.minecraft.util.*;

import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.network.NetworkHooks;

import javax.annotation.Nullable;
import java.util.List;

public class BackpackItem extends Item  {

    private Backpack backpack;

    public BackpackItem(Backpack backpack) {
        super(new Item.Properties()
                .maxStackSize(1)
                .group(ModItemGroups.CRAFTING_DEAD_WEAPON));
        this.backpack = backpack;
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity player,
                                                    Hand handIn) {

        ItemStack itemstack = player.getHeldItem(handIn);
        if (worldIn.isRemote) return new ActionResult(ActionResultType.SUCCESS,itemstack);
        if (!(player instanceof ServerPlayerEntity)){
            return new ActionResult(ActionResultType.SUCCESS, itemstack);
        }
            NetworkHooks.openGui((ServerPlayerEntity) player, new INamedContainerProvider() {
                @Override
                public Container createMenu(int id, PlayerInventory playerInventory, PlayerEntity player) {
                    return new BackpackContainer(id,playerInventory,new BackpackInventory(itemstack,backpack.getInventorySize()), backpack);
                }
                @Override
                public ITextComponent getDisplayName() {
                    return itemstack.getDisplayName();
                }
            },buffer -> buffer.writeEnumValue(this.backpack));

        return new ActionResult<>(ActionResultType.SUCCESS, itemstack);
    }

    @Override
    public ItemStack onItemUseFinish(ItemStack stack, World worldIn, LivingEntity entityLiving) {
        return stack;
    }

    @Override
    public boolean shouldCauseReequipAnimation(ItemStack oldStack, ItemStack newStack, boolean slotChanged) {
        if (ItemStack.areItemsEqual(oldStack, newStack)) return false;
        return true;
    }

    @OnlyIn(Dist.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        super.addInformation(stack, worldIn, tooltip, flagIn);
    }
}
