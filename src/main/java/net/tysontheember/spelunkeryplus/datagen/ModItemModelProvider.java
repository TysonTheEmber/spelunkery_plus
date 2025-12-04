package net.tysontheember.spelunkeryplus.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.registries.RegistryObject;
import net.tysontheember.spelunkeryplus.SpelunkeryPlus;
import net.tysontheember.spelunkeryplus.item.ModItems;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, SpelunkeryPlus.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.IAF_ROUGH_SAPPHIRE);
        simpleItem(ModItems.IAF_SAPPHIRE_SHARD);
        simpleItem(ModItems.IAF_ROUGH_SAPPHIRE_SHARD);

        simpleItem(ModItems.MM_ROUGH_AIR_MALACHITE);
        simpleItem(ModItems.MM_ROUGH_DIVE_AQUAMARINE);
        simpleItem(ModItems.MM_ROUGH_DIVINE_BERYL);
        simpleItem(ModItems.MM_ROUGH_FIRE_RUBY);
        simpleItem(ModItems.MM_ROUGH_HASTE_PERIDOT);
        simpleItem(ModItems.MM_ROUGH_HEART_RHODONITE);
        simpleItem(ModItems.MM_ROUGH_ICE_SAPPHIRE);
        simpleItem(ModItems.MM_ROUGH_KINETIC_OPAL);
        simpleItem(ModItems.MM_ROUGH_LUCKY_CITRINE);
        simpleItem(ModItems.MM_ROUGH_POWER_PYRITE);
        simpleItem(ModItems.MM_ROUGH_SPIDER_KUNZITE);
        simpleItem(ModItems.MM_ROUGH_SPIRIT_GARNET);
        simpleItem(ModItems.MM_ROUGH_UNBREAKING_IOLITE);

        simpleItem(ModItems.CC_ROUGH_SPINEL_SHARD);
        simpleItem(ModItems.CC_ROUGH_SPINEL);
        simpleItem(ModItems.CC_SPINEL_SHARD);

        simpleItem(ModItems.FA_ROUGH_ARCANE_CRYSTAL);
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(SpelunkeryPlus.MODID, "item/" + item.getId().getPath()));
    }
}
