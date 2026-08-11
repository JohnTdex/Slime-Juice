package net.johntdex.slimejuice.util;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class SlimeJuiceTags {
    public static class Items {
        public static final TagKey<Item> MILK_BOTTLE = create("c", "drinks/milk");

        public static TagKey<Item> create(String namespace, String path) {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(namespace, path));
        }
    }
}
