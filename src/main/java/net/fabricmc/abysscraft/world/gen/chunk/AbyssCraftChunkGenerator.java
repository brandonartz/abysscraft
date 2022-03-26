// package net.fabricmc.abysscraft.world.gen.chunk;

// import java.util.List;
// import java.util.concurrent.CompletableFuture;
// import java.util.concurrent.Executor;

// import com.mojang.datafixers.Products;
// import com.mojang.datafixers.kinds.Applicative;
// import com.mojang.serialization.Codec;
// import com.mojang.serialization.MapCodec;
// import com.mojang.serialization.codecs.RecordCodecBuilder;

// import net.minecraft.block.BlockState;
// import net.minecraft.block.Blocks;
// import net.minecraft.structure.StructureSet;
// import net.minecraft.util.dynamic.Codecs;
// import net.minecraft.util.dynamic.RegistryOps;
// import net.minecraft.util.math.BlockPos;
// import net.minecraft.util.registry.Registry;
// import net.minecraft.world.ChunkRegion;
// import net.minecraft.world.HeightLimitView;
// import net.minecraft.world.Heightmap;
// import net.minecraft.world.Heightmap.Type;
// import net.minecraft.world.biome.source.BiomeAccess;
// import net.minecraft.world.biome.source.FixedBiomeSource;
// import net.minecraft.world.biome.source.util.MultiNoiseUtil;
// import net.minecraft.world.biome.source.util.MultiNoiseUtil.MultiNoiseSampler;
// import net.minecraft.world.chunk.Chunk;
// import net.minecraft.world.gen.GenerationStep.Carver;
// import net.minecraft.world.gen.StructureAccessor;
// import net.minecraft.world.gen.chunk.Blender;
// import net.minecraft.world.gen.chunk.ChunkGenerator;
// import net.minecraft.world.gen.chunk.FlatChunkGenerator;
// import net.minecraft.world.gen.chunk.FlatChunkGeneratorConfig;
// import net.minecraft.world.gen.chunk.VerticalBlockSample;

// public class AbyssCraftChunkGenerator extends ChunkGenerator {
//     //public static final Codec<AbyssCraftChunkGenerator> CODEC = RecordCodecBuilder.create(instance -> FlatChunkGenerator.method_41042(instance));//.and(((MapCodec)FlatChunkGeneratorConfig.CODEC.fieldOf("settings"))));//.forGetter(FlatChunkGenerator::getConfig)).apply((Applicative<FlatChunkGenerator, ?>)instance, instance.stable(FlatChunkGenerator::new)));
//     //public static final Codec<FlatChunkGenerator> CODEC = RecordCodecBuilder.create(instance -> FlatChunkGenerator.method_41042(instance).and(((MapCodec)FlatChunkGeneratorConfig.CODEC.fieldOf("settings")).forGetter(FlatChunkGenerator::getConfig)).apply((Applicative<FlatChunkGenerator, ?>)instance, instance.stable(FlatChunkGenerator::new)));
//     public static final Codec<AbyssCraftChunkGenerator> CODEC = RecordCodecBuilder.create(instance -> AbyssCraftChunkGenerator.method_41042(instance).and(((MapCodec)AbyssCraftChunkGeneratorConfig.CODEC.fieldOf("settings"))));
//     private final FlatChunkGeneratorConfig config;

//     public AbyssCraftChunkGenerator(Registry<StructureSet> structureFeatureRegistry, FlatChunkGeneratorConfig config) {
//         super(structureFeatureRegistry, config.method_41139(), new FixedBiomeSource(config.createBiome()), new FixedBiomeSource(config.getBiome()), 0L);
//         this.config = config;
//     }

//     @Override
//     protected Codec<? extends ChunkGenerator> getCodec() {
//         return CODEC;
//     }

//     public FlatChunkGeneratorConfig getConfig() {
//         return this.config;
//     }

//     @Override
//     public ChunkGenerator withSeed(long var1) {
//         return this;
//     }

//     @Override
//     public MultiNoiseSampler getMultiNoiseSampler() {
//         return MultiNoiseUtil.method_40443();
//     }

//     @Override
//     public void carve(ChunkRegion var1, long var2, BiomeAccess var4, StructureAccessor var5, Chunk var6, Carver var7) {
//     }

//     @Override
//     public void buildSurface(ChunkRegion var1, StructureAccessor var2, Chunk var3) {
//     }

//     @Override
//     public void populateEntities(ChunkRegion var1) { 
//     }

//     @Override
//     public int getWorldHeight() {
//         return 384;
//     }

//     @Override
//     public CompletableFuture<Chunk> populateNoise(Executor executor, Blender blender, StructureAccessor structureAccessor, Chunk chunk) {
//         List<BlockState> list = this.config.getLayerBlocks();
//         BlockPos.Mutable mutable = new BlockPos.Mutable();
//         Heightmap heightmap = chunk.getHeightmap(Heightmap.Type.OCEAN_FLOOR_WG);
//         Heightmap heightmap2 = chunk.getHeightmap(Heightmap.Type.WORLD_SURFACE_WG);
//         for (int i = 0; i < Math.min(chunk.getHeight(), list.size()); ++i) {
//             BlockState blockState = list.get(i);
//             if (blockState == null) continue;
//             int j = chunk.getBottomY() + i;
//             for (int k = 0; k < 16; ++k) {
//                 for (int l = 0; l < 16; ++l) {
//                     chunk.setBlockState(mutable.set(k, j, l), blockState, false);
//                     heightmap.trackUpdate(k, j, l, blockState);
//                     heightmap2.trackUpdate(k, j, l, blockState);
//                 }
//             }
//         }
//         return CompletableFuture.completedFuture(chunk);
//     }

//     @Override
//     public int getSeaLevel() {
//         return -63;
//     }

//     @Override
//     public int getMinimumY() {
//         return 0;
//     }

//     @Override
//     public int getHeight(int x, int z, Heightmap.Type heightmap, HeightLimitView world) {
//         List<BlockState> list = this.config.getLayerBlocks();
//         for (int i = Math.min(list.size(), world.getTopY()) - 1; i >= 0; --i) {
//             BlockState blockState = list.get(i);
//             if (blockState == null || !heightmap.getBlockPredicate().test(blockState)) continue;
//             return world.getBottomY() + i + 1;
//         }
//         return world.getBottomY();
//     }

//     @Override
//     public VerticalBlockSample getColumnSample(int x, int z, HeightLimitView world) {
//         return new VerticalBlockSample(world.getBottomY(), (BlockState[])this.config.getLayerBlocks().stream().limit(world.getHeight()).map(state -> state == null ? Blocks.AIR.getDefaultState() : state).toArray(BlockState[]::new));
//     }

//     @Override
//     public void getDebugHudText(List<String> text, BlockPos pos) {
//     }
    
// }
