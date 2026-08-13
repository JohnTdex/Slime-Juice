package net.johntdex.slimejuice.item;

import net.johntdex.slimejuice.SlimeJuice;
import net.johntdex.slimejuice.item.custom.DrinkableItem;
import net.johntdex.slimejuice.item.custom.MilkBottleItem;
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
    public static final DeferredItem<Item> MILK_BOTTLE = ITEMS.register("milk_bottle",
            () -> new MilkBottleItem(new Item.Properties().stacksTo(16)));

    //Food Coloring
    public static final DeferredItem<Item> WHITE_FOOD_COLORING = ITEMS.register("white_food_coloring",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> LIGHT_GREY_FOOD_COLORING = ITEMS.register("light_grey_food_coloring",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> GREY_FOOD_COLORING = ITEMS.register("grey_food_coloring",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> DARK_FOOD_COLORING = ITEMS.register("dark_food_coloring",
            () -> new Item(new Item.Properties()));


    //Colored Slime cubes
    public static final DeferredItem<Item> WHITE_SLIMECUBE = ITEMS.register("white_slime_cube",
            () -> new Item(new Item.Properties().food(SlimeJuiceFoodProperties.SLIMECUBE)));
    public static final DeferredItem<Item> LIGHT_GREY_SLIMECUBE = ITEMS.register("light_grey_slime_cube",
            () -> new Item(new Item.Properties().food(SlimeJuiceFoodProperties.SLIMECUBE)));
    public static final DeferredItem<Item> GREY_SLIMECUBE = ITEMS.register("grey_slime_cube",
            () -> new Item(new Item.Properties().food(SlimeJuiceFoodProperties.SLIMECUBE)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
