// package net.fabricmc.abysscraft.world.gen.chunk;

// import com.mojang.datafixers.kinds.Applicative;
// import com.mojang.serialization.Codec;
// import com.mojang.serialization.MapCodec;
// import com.mojang.serialization.codecs.RecordCodecBuilder;
// import net.minecraft.block.Block;
// import net.minecraft.block.BlockState;
// import net.minecraft.block.Blocks;
// import net.minecraft.util.registry.Registry;
// import net.minecraft.world.dimension.DimensionType;

// public class AbyssCraftChunkGeneratorLayer {
//     public static final Codec<AbyssCraftChunkGeneratorLayer> CODEC = RecordCodecBuilder.create(instance -> instance.group(((MapCodec)Codec.intRange(0, DimensionType.MAX_HEIGHT).fieldOf("height")).forGetter(AbyssCraftChunkGeneratorLayer::getThickness), ((MapCodec)Registry.BLOCK.getCodec().fieldOf("block")).orElse(Blocks.AIR).forGetter(abyssCraftChunkGeneratorLayer -> abyssCraftChunkGeneratorLayer.getBlockState().getBlock())).apply((Applicative<AbyssCraftChunkGeneratorLayer, ?>)instance, AbyssCraftChunkGeneratorLayer::new));
//     private final Block block;
//     private final int thickness;

//     public AbyssCraftChunkGeneratorLayer(int thickness, Block block) {
//         this.thickness = thickness;
//         this.block = block;
//     }

//     public int getThickness() {
//         return this.thickness;
//     }

//     public BlockState getBlockState() {
//         return this.block.getDefaultState();
//     }

//     public String toString() {
//         return (String)(this.thickness != 1 ? this.thickness + "*" : "") + Registry.BLOCK.getId(this.block);
//     }
// }
