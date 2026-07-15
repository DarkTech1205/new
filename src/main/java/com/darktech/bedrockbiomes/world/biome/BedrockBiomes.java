package com.darktech.bedrockbiomes.world.biome;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;

import com.darktech.bedrockbiomes.BedrockBiomesMod;

public class BedrockBiomes {
	public static final RegistryKey<Biome> STRIPELANDS = registerBiomeKey("stripelands");
	public static final RegistryKey<Biome> FLATLANDS = registerBiomeKey("flatlands");

	private static RegistryKey<Biome> registerBiomeKey(String name) {
		return RegistryKey.of(Registries.BIOME.getKey(), new Identifier(BedrockBiomesMod.MOD_ID, name));
	}

	public static void register() {
		BedrockBiomesMod.LOGGER.info("Registered custom biome keys: Stripelands and Flatlands");
	}
}