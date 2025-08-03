package com.rhettcarver.diabetes;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.NotNull;

import java.util.function.Function;

public class ModItems {
    public static final Item DEXCOM_G7 = register("dexcom_g7", Item::new, new Item.Settings());

    /**
     * @param name The name of the item to create
     * @param itemFactory The interface to create the parameters for the function
     * @param settings The settings to apply to the item
     * @return The created item
     */
    public static Item register(String name, @NotNull Function<Item.Settings, Item> itemFactory, @NotNull Item.Settings settings) {
        RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Diabetes.MOD_ID, name));

        Item item = itemFactory.apply(settings.registryKey(itemKey));

        Registry.register(Registries.ITEM, itemKey, item);

        return item;
    }

    public static void initialize() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS)
                .register((itemGroup) -> itemGroup.add(ModItems.DEXCOM_G7));
    }
}
