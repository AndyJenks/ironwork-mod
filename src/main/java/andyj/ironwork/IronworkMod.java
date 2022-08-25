package andyj.ironwork;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.core.Registry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class IronworkMod implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger("ironwork");
	public static final Item TRUSS_ELEMENT = new Item(new FabricItemSettings().group(CreativeModeTab.TAB_MISC));
	public static final Block CROSS_TRUSS = new Block(FabricBlockSettings
			.of(Material.METAL)
			.strength(1.2f,7.0f)
			.nonOpaque());

	public static final Block WARREN_TRUSS = new Block(FabricBlockSettings
			.of(Material.METAL)
			.strength(1.2f,7.0f)
			.nonOpaque());

	public static final Block CROSS_TRUSS_BLACK = new Block(FabricBlockSettings
			.of(Material.METAL)
			.strength(1.2f,7.0f)
			.nonOpaque());

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("Starting Ironwork mod");
		LOGGER.info("Registering items");
		Registry.register(Registry.ITEM, new ResourceLocation("ironwork", "truss_element"), TRUSS_ELEMENT);
		Registry.register(Registry.BLOCK, new ResourceLocation("ironwork", "cross_truss_painted"), CROSS_TRUSS);
		Registry.register(Registry.ITEM, new ResourceLocation("ironwork", "cross_truss_painted"),
				new BlockItem(CROSS_TRUSS, new FabricItemSettings().group(CreativeModeTab.TAB_BUILDING_BLOCKS)));
		Registry.register(Registry.BLOCK, new ResourceLocation("ironwork", "cross_truss_black"), CROSS_TRUSS_BLACK);
		Registry.register(Registry.ITEM, new ResourceLocation("ironwork", "cross_truss_black"),
				new BlockItem(CROSS_TRUSS_BLACK, new FabricItemSettings().group(CreativeModeTab.TAB_BUILDING_BLOCKS)));
		Registry.register(Registry.BLOCK, new ResourceLocation("ironwork", "warren_truss"), WARREN_TRUSS);
		Registry.register(Registry.ITEM, new ResourceLocation("ironwork", "warren_truss"),
				new BlockItem(WARREN_TRUSS, new FabricItemSettings().group(CreativeModeTab.TAB_BUILDING_BLOCKS)));
	}
}
