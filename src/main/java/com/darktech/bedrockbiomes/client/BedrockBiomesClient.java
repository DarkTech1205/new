package com.darktech.bedrockbiomes.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.WorldRenderEvents;

import com.darktech.bedrockbiomes.client.render.StripelandsRenderer;

public class BedrockBiomesClient implements ClientModInitializer {

	@Override
	public void onInitializeClient() {
		// Register world render events for striped terrain rendering
		WorldRenderEvents.AFTER_SETUP.register(context -> {
			StripelandsRenderer.renderStripedTerrain(context);
		});
	}
}