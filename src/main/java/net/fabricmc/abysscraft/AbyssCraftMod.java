package net.fabricmc.abysscraft;

import net.fabricmc.abysscraft.mixin.GeneratorTypeAccessorMixin;
import net.fabricmc.api.ModInitializer;
import net.minecraft.client.world.GeneratorType;
import net.minecraft.structure.StructureSet;
import net.minecraft.structure.StructureSetKeys;
import net.minecraft.util.registry.DynamicRegistryManager;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryEntryList;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.chunk.FlatChunkGenerator;
import net.minecraft.world.gen.chunk.FlatChunkGeneratorConfig;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class AbyssCraftMod implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger("modid");

	private static final GeneratorType VOID = new GeneratorType("void") {
		protected ChunkGenerator getChunkGenerator(DynamicRegistryManager registryManager, long seed) {
			// Registry<Biome> registry = registryManager.get(Registry.BIOME_KEY);
            // Registry<StructureSet> registry2 = registryManager.get(Registry.STRUCTURE_SET_KEY);
            // return new FlatChunkGenerator(registry2, FlatChunkGeneratorConfig.getDefaultConfig(registry, registry2));
			Registry<Biome> registry = registryManager.get(Registry.BIOME_KEY);
            Registry<StructureSet> registry2 = registryManager.get(Registry.STRUCTURE_SET_KEY);
            
			RegistryEntryList.Direct registryEntryList = RegistryEntryList.of(registry2.entryOf(StructureSetKeys.STRONGHOLDS), registry2.entryOf(StructureSetKeys.VILLAGES));
        	FlatChunkGeneratorConfig flatChunkGeneratorConfig = new FlatChunkGeneratorConfig(Optional.of(registryEntryList), registry);
        	// flatChunkGeneratorConfig.biome = biomeRegistry.getOrCreateEntry(BiomeKeys.PLAINS);
        	// flatChunkGeneratorConfig.getLayers().add(new FlatChunkGeneratorLayer(1, Blocks.BEDROCK));
        	// flatChunkGeneratorConfig.getLayers().add(new FlatChunkGeneratorLayer(2, Blocks.DIRT));
        	// flatChunkGeneratorConfig.getLayers().add(new FlatChunkGeneratorLayer(1, Blocks.GRASS_BLOCK));
        	flatChunkGeneratorConfig.updateLayerBlocks();
			return new FlatChunkGenerator(registry2, flatChunkGeneratorConfig);
		}
	  };


	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("Hello Fabric world!");
		
		GeneratorTypeAccessorMixin.getValues().add(VOID);
	}

	
}
