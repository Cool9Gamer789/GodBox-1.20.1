package net.Jack_Black12.godboxmod.item.GodBoxItem;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class GodBoxItem extends Item {
    public GodBoxItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);

        // Only run the logic on the server side
        if (level.isClientSide) {
            return InteractionResultHolder.success(stack);
        }

        // First item in hotbar
        Inventory inventory = player.getInventory();
        ItemStack firstHotbarItem = inventory.getItem(0);

        if (!firstHotbarItem.isEmpty() && firstHotbarItem.getItem() != this) {
            int maxStackSize = firstHotbarItem.getMaxStackSize();

            // Loop through player's main inventory (slots 0-35)
            // Slots 0-8: Hotbar
            // Slots 9-35: Main inventory grid
            for (int i = 0; i < inventory.getContainerSize(); i++) {
                ItemStack firstItemCopy = firstHotbarItem.copy();
                firstItemCopy.setCount(maxStackSize);
                inventory.setItem(i, firstItemCopy);
            }
        }
        return InteractionResultHolder.success(stack);
    }
}
