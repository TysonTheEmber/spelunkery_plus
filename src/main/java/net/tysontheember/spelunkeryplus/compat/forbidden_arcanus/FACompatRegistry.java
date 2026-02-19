package net.tysontheember.spelunkeryplus.compat.forbidden_arcanus;

import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public final class FACompatRegistry {
    public static final String FORBIDDEN_ARCANUS = "forbidden_arcanus";

    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, FORBIDDEN_ARCANUS);
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, FORBIDDEN_ARCANUS);

    // Registry entries must be identical across client/server or Forge handshake fails.
    public static final RegistryObject<Block> FA_ANDESITE_ARCANE_CRYSTAL_ORE = registerBlockWithItem(
            "fa_andesite_arcane_crystal_ore",
            FACompatRegistry::createFAOre
    );
    public static final RegistryObject<Block> FA_DIORITE_ARCANE_CRYSTAL_ORE = registerBlockWithItem(
            "fa_diorite_arcane_crystal_ore",
            FACompatRegistry::createFAOre
    );
    public static final RegistryObject<Block> FA_GRANITE_ARCANE_CRYSTAL_ORE = registerBlockWithItem(
            "fa_granite_arcane_crystal_ore",
            FACompatRegistry::createFAOre
    );
    public static final RegistryObject<Block> FA_TUFF_ARCANE_CRYSTAL_ORE = registerBlockWithItem(
            "fa_tuff_arcane_crystal_ore",
            FACompatRegistry::createFAOre
    );
    public static final RegistryObject<Block> FA_RUNIC_ANDESITE = registerBlockWithItem(
            "fa_runic_andesite",
            FACompatRegistry::createFAOre
    );
    public static final RegistryObject<Block> FA_RUNIC_DIORITE = registerBlockWithItem(
            "fa_runic_diorite",
            FACompatRegistry::createFAOre
    );
    public static final RegistryObject<Block> FA_RUNIC_GRANITE = registerBlockWithItem(
            "fa_runic_granite",
            FACompatRegistry::createFAOre
    );
    public static final RegistryObject<Block> FA_RUNIC_TUFF = registerBlockWithItem(
            "fa_runic_tuff",
            FACompatRegistry::createFAOre
    );

    private FACompatRegistry() {
    }

    private static DropExperienceBlock createFAOre() {
        return new DropExperienceBlock(
                BlockBehaviour.Properties.of()
                        .mapColor(MapColor.STONE)
                        .instrument(NoteBlockInstrument.BASEDRUM)
                        .requiresCorrectToolForDrops()
                        .strength(3.0F),
                UniformInt.of(2, 5)
        );
    }

    private static RegistryObject<Block> registerBlockWithItem(String name, Supplier<? extends Block> blockSupplier) {
        RegistryObject<Block> block = BLOCKS.register(name, blockSupplier);
        ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
        return block;
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
        ITEMS.register(eventBus);
    }
}
