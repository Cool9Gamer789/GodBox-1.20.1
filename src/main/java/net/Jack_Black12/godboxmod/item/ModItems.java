package net.Jack_Black12.godboxmod.item;

import net.Jack_Black12.godboxmod.GodBoxMod;
import net.Jack_Black12.godboxmod.item.GodBoxItem.GodBoxItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, GodBoxMod.MOD_ID);

    public static final RegistryObject<Item> GodBox = ITEMS.register("godbox",
            () -> new GodBoxItem(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
