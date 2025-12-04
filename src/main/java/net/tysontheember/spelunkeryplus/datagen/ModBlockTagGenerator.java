package net.tysontheember.spelunkeryplus.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.ModList;
import net.tysontheember.spelunkeryplus.SpelunkeryPlus;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, SpelunkeryPlus.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        TagKey<Block> ORES_TAG = TagKey.create(Registries.BLOCK, new ResourceLocation("forge", "ores"));
        TagKey<Block> RUNIC_TAG = TagKey.create(Registries.BLOCK, new ResourceLocation("forbidden_arcanus", "runic_ores"));// check github
        TagKey<Block> ARCANE_CRYSTAL_ORES = TagKey.create(Registries.BLOCK, new ResourceLocation("forbidden_arcanus", "arcane_crystal_ores"));// check github

            String[] faOres = new String[]{
                    "fa_tuff_arcane_crystal_ore",
                    "fa_andesite_arcane_crystal_ore",
                    "fa_diorite_arcane_crystal_ore",
                    "fa_granite_arcane_crystal_ore",
                    "fa_runic_andesite",
                    "fa_runic_diorite",
                    "fa_runic_granite",
                    "fa_runic_tuff"
            };
            for (String blockId : faOres) {
                this.tag(BlockTags.MINEABLE_WITH_PICKAXE).addOptional(new ResourceLocation("forbidden_arcanus", blockId));
                this.tag(BlockTags.NEEDS_IRON_TOOL).addOptional(new ResourceLocation("forbidden_arcanus", blockId));
                this.tag(ORES_TAG).addOptional(new ResourceLocation("forbidden_arcanus", blockId));
            }



            String[] mmBlocks = new String[]{
                    "mm_rough_air_malachite_block", "mm_rough_dive_aquamarine_block", "mm_rough_divine_beryl_block",
                    "mm_rough_fire_ruby_block", "mm_rough_haste_peridot_block", "mm_rough_heart_rhodonite_block",
                    "mm_rough_ice_sapphire_block", "mm_rough_kinetic_opal_block", "mm_rough_lucky_citrine_block",
                    "mm_rough_power_pyrite_block", "mm_rough_spider_kunzite_block", "mm_rough_spirit_garnet_block",
                    "mm_rough_unbreaking_iolite_block"
            };
            for (String blockId : mmBlocks) {
                this.tag(BlockTags.MINEABLE_WITH_PICKAXE).addOptional(new ResourceLocation("spelunkeryplus", blockId));
                this.tag(BlockTags.NEEDS_IRON_TOOL).addOptional(new ResourceLocation("spelunkeryplus", blockId));
            }



            String[] mmOres = new String[]{
                    "mm_andesite_dive_aquamarine_ore", "mm_andesite_divine_beryl_ore", "mm_andesite_fire_ruby_ore",
                    "mm_andesite_haste_peridot_ore", "mm_andesite_ice_sapphire_ore", "mm_andesite_lucky_citrine_ore",
                    "mm_andesite_spider_kunzite_ore", "mm_andesite_spirit_garnet_ore", "mm_andesite_unbreaking_iolite_ore",

                    "mm_diorite_dive_aquamarine_ore", "mm_diorite_divine_beryl_ore", "mm_diorite_fire_ruby_ore",
                    "mm_diorite_haste_peridot_ore", "mm_diorite_ice_sapphire_ore", "mm_diorite_lucky_citrine_ore",
                    "mm_diorite_spider_kunzite_ore", "mm_diorite_spirit_garnet_ore", "mm_diorite_unbreaking_iolite_ore",

                    "mm_granite_dive_aquamarine_ore", "mm_granite_divine_beryl_ore", "mm_granite_fire_ruby_ore",
                    "mm_granite_haste_peridot_ore", "mm_granite_ice_sapphire_ore", "mm_granite_lucky_citrine_ore",
                    "mm_granite_spider_kunzite_ore", "mm_granite_spirit_garnet_ore", "mm_granite_unbreaking_iolite_ore",

                    "mm_tuff_dive_aquamarine_ore", "mm_tuff_divine_beryl_ore", "mm_tuff_fire_ruby_ore",
                    "mm_tuff_haste_peridot_ore", "mm_tuff_ice_sapphire_ore", "mm_tuff_lucky_citrine_ore",
                    "mm_tuff_spider_kunzite_ore", "mm_tuff_spirit_garnet_ore", "mm_tuff_unbreaking_iolite_ore"
            };
            for (String blockId : mmOres) {
                this.tag(BlockTags.MINEABLE_WITH_PICKAXE).addOptional(new ResourceLocation("spelunkeryplus", blockId));
                this.tag(BlockTags.NEEDS_IRON_TOOL).addOptional(new ResourceLocation("spelunkeryplus", blockId));
                this.tag(ORES_TAG).addOptional(new ResourceLocation("spelunkeryplus", blockId));
                this.tag(ORES_TAG).addOptional(new ResourceLocation("spelunkeryplus", blockId));
            }



            String[] ccOres = new String[]{
                    "cc_andesite_silver_ore", "cc_diorite_silver_ore", "cc_granite_silver_ore", "cc_tuff_silver_ore"
            };
            for (String blockId : ccOres) {
                this.tag(BlockTags.MINEABLE_WITH_PICKAXE).addOptional(new ResourceLocation("spelunkeryplus", blockId));
                this.tag(BlockTags.NEEDS_IRON_TOOL).addOptional(new ResourceLocation("spelunkeryplus", blockId));
                this.tag(ORES_TAG).addOptional(new ResourceLocation("spelunkeryplus", blockId));
                this.tag(ORES_TAG).addOptional(new ResourceLocation("spelunkeryplus", blockId));
            }
            String[] ccOresStone = new String[]{
                    "cc_andesite_spinel_ore", "cc_diorite_spinel_ore", "cc_granite_spinel_ore", "cc_tuff_spinel_ore"
            };
            for (String blockId : ccOresStone) {
                this.tag(BlockTags.MINEABLE_WITH_PICKAXE).addOptional(new ResourceLocation("spelunkeryplus", blockId));
                this.tag(BlockTags.NEEDS_STONE_TOOL).addOptional(new ResourceLocation("spelunkeryplus", blockId));
                this.tag(ORES_TAG).addOptional(new ResourceLocation("spelunkeryplus", blockId));
                this.tag(ORES_TAG).addOptional(new ResourceLocation("spelunkeryplus", blockId));
            }



            String[] iafOres = new String[]{
                    "iaf_granite_sapphire_ore", "iaf_andesite_sapphire_ore", "iaf_deepslate_sapphire_ore",
                    "iaf_diorite_sapphire_ore", "iaf_tuff_sapphire_ore"
            };
            for (String blockId : iafOres) {
                this.tag(BlockTags.MINEABLE_WITH_PICKAXE).addOptional(new ResourceLocation("spelunkeryplus", blockId));
                this.tag(BlockTags.NEEDS_IRON_TOOL).addOptional(new ResourceLocation("spelunkeryplus", blockId));
                this.tag(ORES_TAG).addOptional(new ResourceLocation("spelunkeryplus", blockId));
                this.tag(ORES_TAG).addOptional(new ResourceLocation("spelunkeryplus", blockId));
            }
        String[] iafOresStone = new String[]{
            "iaf_andesite_silver_ore", "iaf_diorite_silver_ore", "iaf_granite_silver_ore", "iaf_tuff_silver_ore"
            };
            for (String blockId : iafOresStone) {
                this.tag(BlockTags.MINEABLE_WITH_PICKAXE).addOptional(new ResourceLocation("spelunkeryplus", blockId));
                this.tag(BlockTags.NEEDS_STONE_TOOL).addOptional(new ResourceLocation("spelunkeryplus", blockId));
                this.tag(ORES_TAG).addOptional(new ResourceLocation("spelunkeryplus", blockId));
                this.tag(ORES_TAG).addOptional(new ResourceLocation("spelunkeryplus", blockId));
            }
            this.tag(ORES_TAG).addOptional(new ResourceLocation("spelunkeryplus", "iaf_rough_sapphire_block"));
            }
}
