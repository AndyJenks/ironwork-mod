package net.fabricmc.example;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExampleMod implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger("ironwork");
	public static final Item TRUSS_ELEMENT = new Item(new FabricItemSettings().group(ItemGroup.MISC));
	public static final Block CROSS_TRUSS = new Block(FabricBlockSettings
			.of(Material.METAL)
			.strength(1.5f)
			.nonOpaque());
	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("Starting Ironwork mod");
		LOGGER.info("Registering items");
		Registry.register(Registry.ITEM, new Identifier("ironwork", "truss_element"), TRUSS_ELEMENT);
		Registry.register(Registry.BLOCK, new Identifier("ironwork", "cross_truss"), CROSS_TRUSS);
		Registry.register(Registry.ITEM, new Identifier("ironwork", "cross_truss"),
				new BlockItem(CROSS_TRUSS, new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS)));
	}
}
