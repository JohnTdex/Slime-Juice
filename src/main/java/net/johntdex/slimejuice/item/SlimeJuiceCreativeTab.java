package net.johntdex.slimejuice.item;

import net.johntdex.slimejuice.SlimeJuice;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class SlimeJuiceCreativeTab {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, SlimeJuice.MODID);

    public static final Supplier<CreativeModeTab> SLIMEJUICE_ITEM_TAB = CREATIVE_MODE_TAB.register("slimejuice_item_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(SlimeJuiceItems.SLIMEJUICE.get()))
                    .title(Component.translatable("creativetab.slimejuice.slimejuice_items"))
                    .displayItems(((parameters, output) -> {
                        output.accept(SlimeJuiceItems.SLIMECUBE);
                        output.accept(SlimeJuiceItems.SLIMEJUICE);
                        output.accept(SlimeJuiceItems.GLASS_CUP);
                        output.accept(SlimeJuiceItems.MILK_BOTTLE);
                        output.accept(SlimeJuiceItems.WHITE_FOOD_COLORING);
                        output.accept(SlimeJuiceItems.LIGHT_GREY_FOOD_COLORING);
                        output.accept(SlimeJuiceItems.GREY_FOOD_COLORING);
                        output.accept(SlimeJuiceItems.DARK_FOOD_COLORING);
                        output.accept(SlimeJuiceItems.BROWN_FOOD_COLORING);
                        output.accept(SlimeJuiceItems.RED_FOOD_COLORING);
                        output.accept(SlimeJuiceItems.ORANGE_FOOD_COLORING);
                        output.accept(SlimeJuiceItems.YELLOW_FOOD_COLORING);
                        output.accept(SlimeJuiceItems.WHITE_SLIMECUBE);
                        output.accept(SlimeJuiceItems.LIGHT_GREY_SLIMECUBE);
                        output.accept(SlimeJuiceItems.GREY_SLIMECUBE);
                        output.accept(SlimeJuiceItems.DARK_SLIMECUBE);
                        output.accept(SlimeJuiceItems.BROWN_SLIMECUBE);
                        output.accept(SlimeJuiceItems.RED_SLIMECUBE);
                        output.accept(SlimeJuiceItems.ORANGE_SLIMECUBE);
                        output.accept(SlimeJuiceItems.YELLOW_SLIMECUBE);
                        output.accept(SlimeJuiceItems.WHITE_SLIMEJUICE);
                        output.accept(SlimeJuiceItems.LIGHT_GREY_SLIMEJUICE);
                    }))


                    .build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }

}
