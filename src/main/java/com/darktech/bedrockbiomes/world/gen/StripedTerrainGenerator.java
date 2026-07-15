package com.darktech.bedrockbiomes.world.gen;

import net.minecraft.util.math.MathHelper;

public class StripedTerrainGenerator {

	private static final int STRIPE_WIDTH = 4; // Width of each stripe in blocks
	private static final float STRIPE_AMPLITUDE = 8.0f; // Height variation of stripes

	/**
	 * Generates striped terrain effect for Stripelands
	 * Creates alternating grass and stone stripes
	 */
	public static float generateStripedTerrain(int x, int z, float baseHeight) {
		// Determine stripe position
		int stripeX = Math.abs((x / STRIPE_WIDTH) % 2);
		int stripeZ = Math.abs((z / STRIPE_WIDTH) % 2);
		
		// Create alternating pattern
		float stripeInfluence = (stripeX == stripeZ) ? STRIPE_AMPLITUDE : -STRIPE_AMPLITUDE;
		
		// Add smooth noise for natural variation
		float noise = simplexNoise(x * 0.05f, z * 0.05f) * 4.0f;
		
		return baseHeight + stripeInfluence + noise;
	}

	/**
	 * Simple noise function for terrain variation
	 */
	private static float simplexNoise(float x, float z) {
		// Pseudo-simplex noise implementation
		float n = (float) Math.sin(x * 12.9898f + z * 78.233f) * 43758.5453f;
		return n - (float) Math.floor(n);
	}

	/**
	 * Determines if position should render striped pattern (Stripelands)
	 */
	public static boolean isStriped(int x, int z) {
		int stripeX = (x / STRIPE_WIDTH) % 2;
		int stripeZ = (z / STRIPE_WIDTH) % 2;
		return (stripeX + stripeZ) % 2 == 0; // Creates checkerboard pattern
	}

	/**
	 * Gets the stripe block type (grass vs stone)
	 */
	public static StripeType getStripeType(int x, int z) {
		int stripeX = (x / STRIPE_WIDTH) % 2;
		int stripeZ = (z / STRIPE_WIDTH) % 2;
		
		if ((stripeX + stripeZ) % 2 == 0) {
			return StripeType.GRASS;
		} else {
			return StripeType.STONE;
		}
	}

	public enum StripeType {
		GRASS("minecraft:grass_block"),
		STONE("minecraft:stone");

		public final String blockId;

		StripeType(String blockId) {
			this.blockId = blockId;
		}
	}
}