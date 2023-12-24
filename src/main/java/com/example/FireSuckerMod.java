package com.example;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FireSuckerMod implements ModInitializer {
    // This logger is used to write text to the console and the log file.
    // It is considered best practice to use your mod id as the logger's name.
    // That way, it's clear which mod wrote info, warnings, and errors.
    public static final Logger LOGGER = LoggerFactory.getLogger("firesucker");

    public static final Block FIRE_SUCKER = new FireSucker();

    @Override
    public void onInitialize() {
        // This code runs as soon as Minecraft is in a mod-load-ready state.
        // However, some things (like resources) may still be uninitialized.
        // Proceed with mild caution.

        Registry.register(Registries.BLOCK, new Identifier("firesucker", "firesucker"), FIRE_SUCKER);
        var item = new BlockItem(FIRE_SUCKER, new FabricItemSettings());
        Registry.register(Registries.ITEM, new Identifier("firesucker", "firesucker"), item);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.REDSTONE).register(content -> {
            content.add(item);
        });
    }
}