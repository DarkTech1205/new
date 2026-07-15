package com.darktech.bedrockbiomes;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.darktech.bedrockbiomes.world.biome.BedrockBiomes;
import com.darktech.bedrockbiomes.world.gen.GatewayToHellFeature;

public class BedrockBiomesMod implements ModInitializer {
	public static final String MOD_ID = "bedrock-biomes";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	// Gateway to Hell spawning threshold (2.8 million blocks)
	public static final long GATEWAY_THRESHOLD = 2_800_000L;

	@Override
	public void onInitialize() {
		LOGGER.info("Initializing Bedrock Biomes Mod");
		
		// Register biomes
		BedrockBiomes.register();
		
		// Register Gateway to Hell features
		GatewayToHellFeature.register();
		
		LOGGER.info("Bedrock Biomes Mod initialized successfully!");
		LOGGER.info("Gateways to Hell will spawn after ±" + GATEWAY_THRESHOLD + " blocks");
	}
}