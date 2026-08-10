package net.johntdex.slimejuice.item;

import net.johntdex.slimejuice.SlimeJuice;
import net.johntdex.slimejuice.item.custom.DrinkableItem;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class SlimeJuiceItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(SlimeJuice.MODID);

    public static final DeferredItem<Item> SLIMECUBE = ITEMS.register("slime_cube",
            () -> new Item(new Item.Properties().food(SlimeJuiceFoodProperties.SLIMECUBE)));
    public static final DeferredItem<Item> SLIMEJUICE = ITEMS.register("slime_juice",
            () -> new DrinkableItem(new Item.Properties().food(SlimeJuiceFoodProperties.SLIMEJUICE)));
    public static final DeferredItem<Item> GLASS_CUP = ITEMS.register("glass_cup",
            () -> new Item(new Item.Properties().stacksTo(16)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
