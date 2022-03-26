// package net.fabricmc.abysscraft.world.gen.chunk;

// import com.mojang.serialization.Codec;
// import com.mojang.serialization.MapCodec;
// import com.mojang.serialization.codecs.RecordCodecBuilder;

// import net.minecraft.util.dynamic.RegistryOps;
// import net.minecraft.util.registry.Registry;
// import net.minecraft.util.registry.RegistryCodecs;

// public class AbyssCraftChunkGeneratorConfig {
//     public static final Codec<AbyssCraftChunkGeneratorConfig> CODEC = RecordCodecBuilder.create(instance -> instance.group(RegistryOps.createRegistryCodec(Registry.BIOME_KEY).forGetter(flatChunkGeneratorConfig -> flatChunkGeneratorConfig.biomeRegistry), RegistryCodecs.entryList(Registry.STRUCTURE_SET_KEY).optionalFieldOf("structure_overrides").forGetter(flatChunkGeneratorConfig -> flatChunkGeneratorConfig.field_37145), ((MapCodec)FlatChunkGeneratorLayer.CODEC.listOf().fieldOf("layers")).forGetter(FlatChunkGeneratorConfig::getLayers), ((MapCodec)Codec.BOOL.fieldOf("lakes")).orElse(false).forGetter(flatChunkGeneratorConfig -> flatChunkGeneratorConfig.hasLakes), ((MapCodec)Codec.BOOL.fieldOf("features")).orElse(false).forGetter(flatChunkGeneratorConfig -> flatChunkGeneratorConfig.hasFeatures), Biome.REGISTRY_CODEC.optionalFieldOf("biome").orElseGet(Optional::empty).forGetter(flatChunkGeneratorConfig -> Optional.of(flatChunkGeneratorConfig.biome))).apply((Applicative<FlatChunkGeneratorConfig, ?>)instance, FlatChunkGeneratorConfig::new)).comapFlatMap(FlatChunkGeneratorConfig::checkHeight, Function.identity()).stable();
    
// }
