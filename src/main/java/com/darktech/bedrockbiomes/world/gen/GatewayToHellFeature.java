package com.darktech.bedrockbiomes.world.gen;

import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;

import com.darktech.bedrockbiomes.BedrockBiomesMod;

public class GatewayToHellFeature {

	public static void register() {
		BedrockBiomesMod.LOGGER.info("Gateway to Hell feature registered");
		BedrockBiomesMod.LOGGER.info("Mountains will become gateways beyond ±" + BedrockBiomesMod.GATEWAY_THRESHOLD + " blocks");
	}

	/**
	 * Checks if a coordinate is beyond the gateway threshold
	 * where mountains become holes with lava at the bottom
	 */
	public static boolean isGatewayZone(long x, long z) {
		long distFromOrigin = Math.max(Math.abs(x), Math.abs(z));
		return distFromOrigin > BedrockBiomesMod.GATEWAY_THRESHOLD;
	}

	/**
	 * Calculates if this position should be a void/hole
	 * (for mountain biomes in gateway zones)
	 */
	public static boolean shouldBeGateway(long x, long z, double terrainHeight) {
		if (!isGatewayZone(x, z)) {
			return false;
		}
		
		// If it's a high terrain area (mountain), make it a gateway hole
		return terrainHeight > 100;
	}

	/**
	 * Gets the height at which lava should spawn in gateway zones
	 */
	public static int getLavaLevel() {
		return 10; // Lava at Y=10
	}
}