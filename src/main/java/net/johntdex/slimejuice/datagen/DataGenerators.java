package net.johntdex.slimejuice.datagen;

import net.johntdex.slimejuice.SlimeJuice;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.TagsProvider;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.concurrent.CompletableFuture;

@EventBusSubscriber(modid = SlimeJuice.MODID)
public class DataGenerators {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput output = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        generator.addProvider(event.includeServer(), new SlimeJuiceRecipe(output, lookupProvider, existingFileHelper));
        generator.addProvider(event.includeServer(), new SlimeJuiceItemTags(
                output, lookupProvider, CompletableFuture.completedFuture(TagsProvider.TagLookup.empty()), existingFileHelper));

    }
}
