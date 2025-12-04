package net.tysontheember.spelunkeryplus;

import java.util.List;
import java.util.Locale;

import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.MissingMappingsEvent;

/**
 * Remaps old Mining Master compat ids that used the raw_ prefix to their new rough_ counterparts.
 * Runs on the MOD event bus for both block and item registries.
 */
@Mod.EventBusSubscriber(modid = SpelunkeryPlus.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public final class MissingMappingsHandler {
    private static final String COMPAT_PREFIX = "mm_raw";

    private MissingMappingsHandler() {}

    @SubscribeEvent
    public static void onMissingMappings(MissingMappingsEvent event) {
        remap(event.getMappings(ForgeRegistries.Keys.BLOCKS, SpelunkeryPlus.MODID), ForgeRegistries.BLOCKS);
        remap(event.getMappings(ForgeRegistries.Keys.ITEMS, SpelunkeryPlus.MODID), ForgeRegistries.ITEMS);
    }

    private static <T> void remap(List<MissingMappingsEvent.Mapping<T>> mappings, IForgeRegistry<T> registry) {
        for (MissingMappingsEvent.Mapping<T> mapping : mappings) {
            ResourceLocation oldId = mapping.getKey();
            String path = oldId.getPath();
            String lower = path.toLowerCase(Locale.ROOT);

            // Only touch Mining Master compat entries that used the legacy raw_ prefix.
            if (!lower.startsWith(COMPAT_PREFIX)) {
                continue;
            }

            String newPath = path.replaceFirst("raw_", "rough_");
            if (newPath.equals(path)) {
                continue;
            }

            ResourceLocation newId = new ResourceLocation(oldId.getNamespace(), newPath);
            T replacement = registry.getValue(newId);
            if (replacement != null) {
                mapping.remap(replacement);
            }
        }
    }
}
