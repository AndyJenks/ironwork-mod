package andyj.ironwork;

import andyj.ironwork.block.TrussBlock;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.core.Registry;
import net.minecraft.world.level.block.IronBarsBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class IronworkMod implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static String MODID = "ironwork";
	public static final Logger LOGGER = LoggerFactory.getLogger(MODID);
	public static final Item TRUSS_ELEMENT = new Item(new FabricItemSettings().group(CreativeModeTab.TAB_MISC));
	public static final Block WARREN_TRUSS = new TrussBlock();
	public static final Block CROSS_TRUSS = new TrussBlock();
	public static final Block CROSS_TRUSS_PAINTED = new TrussBlock();
	public static final Block CORRUGATED_PANEL = new IronBarsBlock(BlockBehaviour.Properties.of(Material.METAL));
	public static final Block CORRUGATED_BLOCK = new Block(BlockBehaviour.Properties
			.of(Material.METAL).strength(1.0f));
	public static final StairBlock CORRUGATED_STAIRS = new StairBlock(CORRUGATED_BLOCK.defaultBlockState(),
			BlockBehaviour.Properties.copy(CORRUGATED_BLOCK));
	public static final SlabBlock CORRUGATED_SLAB = new SlabBlock(BlockBehaviour.Properties.copy(CORRUGATED_BLOCK));

	private void registerBlockAndItem(String name, Block block, CreativeModeTab tab) {
		Registry.register(Registry.BLOCK, new ResourceLocation(MODID, name), block);
		Registry.register(Registry.ITEM, new ResourceLocation(MODID, name),
				new BlockItem(block, new FabricItemSettings().group(tab)));
	}

	private void registerItem(String name, Item item) {
		Registry.register(Registry.ITEM, new ResourceLocation(MODID, name), item);
	}
	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.Override

		LOGGER.info("Starting Ironwork mod");
		LOGGER.info("Registering items");

		registerItem("truss_element", TRUSS_ELEMENT);
		registerBlockAndItem("cross_truss", CROSS_TRUSS, CreativeModeTab.TAB_BUILDING_BLOCKS);
		registerBlockAndItem("cross_truss_painted", CROSS_TRUSS_PAINTED, CreativeModeTab.TAB_BUILDING_BLOCKS);
		registerBlockAndItem("warren_truss", WARREN_TRUSS, CreativeModeTab.TAB_BUILDING_BLOCKS);

		// Corrugated bits
		registerBlockAndItem("corrugated_panel", CORRUGATED_PANEL, CreativeModeTab.TAB_DECORATIONS);
		registerBlockAndItem("corrugated_panel_block", CORRUGATED_BLOCK, CreativeModeTab.TAB_BUILDING_BLOCKS);
		registerBlockAndItem("corrugated_stairs", CORRUGATED_STAIRS, CreativeModeTab.TAB_BUILDING_BLOCKS);
		registerBlockAndItem("corrugated_slab", CORRUGATED_SLAB, CreativeModeTab.TAB_BUILDING_BLOCKS);
	}
}
