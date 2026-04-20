package net.johntdex.slimejuice.item;

import net.johntdex.slimejuice.SlimeJuice;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs{
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, SlimeJuice.MODID);

    public static final Supplier<CreativeModeTab> SLIMEJUICE_ITEM_TAB = CREATIVE_MODE_TAB.register("slimejuice_item_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.SLIMEJUICE.get()))
                    .title(Component.translatable("creativetab.slimejuice.slimejuice_items"))
                    .displayItems(((parameters, output) -> {
                        output.accept(ModItems.SLIMECUBE);
                        output.accept(ModItems.SLIMEJUICE);
                    }))


                    .build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }

}
