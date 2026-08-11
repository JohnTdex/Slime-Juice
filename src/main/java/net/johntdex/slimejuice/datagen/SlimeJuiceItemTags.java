package net.johntdex.slimejuice.datagen;

import net.johntdex.slimejuice.SlimeJuice;
import net.johntdex.slimejuice.item.SlimeJuiceItems;
import net.johntdex.slimejuice.util.SlimeJuiceTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class SlimeJuiceItemTags extends ItemTagsProvider {
    public SlimeJuiceItemTags(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider,
                              CompletableFuture<TagsProvider.TagLookup<Block>> blockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, blockTags, SlimeJuice.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(SlimeJuiceTags.Items.MILK_BOTTLE)
                .add(SlimeJuiceItems.MILK_BOTTLE.get())
                .addOptional(ResourceLocation.fromNamespaceAndPath("farmersdelight", "milk_bottle"));
    }
}
