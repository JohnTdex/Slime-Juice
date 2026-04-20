package net.johntdex.slimejuice.item;

import net.johntdex.slimejuice.SlimeJuice;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import javax.swing.*;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(SlimeJuice.MODID);

    public static final DeferredItem<Item> SLIMECUBE = ITEMS.register("slime_cube",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> SLIMEJUICE = ITEMS.register("slime_juice",
            () -> new Item((new Item.Properties())));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
