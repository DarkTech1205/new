package com.darktech.bedrockbiomes.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

import net.minecraft.world.gen.chunk.ChunkGenerator;

import com.darktech.bedrockbiomes.world.gen.GatewayToHellFeature;

@Mixin(ChunkGenerator.class)
public abstract class ChunkGeneratorMixin {

	/**
	 * Modifies terrain height in Gateway to Hell zones
	 * Mountains become holes with lava at the bottom
	 */
	@ModifyVariable(
		method = "getHeight",
		at = @At("RETURN"),
		ordinal = 0
	)
	private int modifyGatewayHeight(int height, int x, int z) {
		// If in gateway zone and this is a mountain, create void
		if (GatewayToHellFeature.shouldBeGateway(x, z, height)) {
			return 8; // Drop mountain to near lava level
		}
		return height;
	}
}