package tektonikal.missingno;

import eu.midnightdust.lib.config.MidnightConfig;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.client.rendering.v1.InvalidateRenderStateCallback;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import tektonikal.missingno.enterprise.impl.InitializationHandlerImpl;

import java.io.File;
import java.nio.file.Path;

public class Missingno implements ModInitializer {
//		public static final Block CONDENSED_DIRT = register(
//				new Block(AbstractBlock.Settings.create().sounds(BlockSoundGroup.GRASS)),
//				"condensed_dirt",
//				true
//		);


	@Override
	public void onInitialize() {
		MidnightConfig.init("missingno", Config.class);
		new InitializationHandlerImpl().handleInit();
	}
//	public static Block register(Block block, String name, boolean shouldRegisterItem) {
//		Identifier id = Identifier.of("missingno", name);
//		if (shouldRegisterItem) {
//			BlockItem blockItem = new BlockItem(block, new Item.Settings());
//			Registry.register(Registries.ITEM, id, blockItem);
//		}
//
//		return Registry.register(Registries.BLOCK, id, block);
//	}
}