package com.darktech.bedrockbiomes.client.render;

import net.fabricmc.fabric.api.client.rendering.v1.WorldRenderContext;
import net.minecraft.client.render.BufferBuilder;
import net.minecraft.client.render.Tessellator;
import net.minecraft.client.render.VertexFormat;
import net.minecraft.client.render.VertexFormats;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;
import org.lwjgl.opengl.GL11;

from darktech.bedrockbiomes.world.gen.StripedTerrainGenerator;

public class StripelandsRenderer {

	private static final float STRIPE_OPACITY = 0.15f; // Subtle overlay opacity
	private static final int STRIPE_WIDTH = 4;

	public static void renderStripedTerrain(WorldRenderContext context) {
		if (context.world() == null || context.camera() == null) {
			return;
		}

		// Get player position
		double playerX = context.camera().getPos().x;
		double playerY = context.camera().getPos().y;
		double playerZ = context.camera().getPos().z;

		// Only render if in biome (simplified check)
		if (shouldRenderStripes(playerX, playerZ)) {
			renderStripeOverlay(context, playerX, playerY, playerZ);
		}
	}

	private static boolean shouldRenderStripes(double x, double z) {
		// Check if in Stripelands or Flatlands biome
		// This is a simplified check - in production, check actual biome
		return true; // For now, always render for testing
	}

	private static void renderStripeOverlay(WorldRenderContext context, double playerX, double playerY, double playerZ) {
		MatrixStack matrices = context.matrixStack();
		
		matrices.push();
		matrices.translate(-playerX, -playerY, -playerZ);

		Tessellator tessellator = Tessellator.getInstance();
		BufferBuilder buffer = tessellator.getBuffer();

		// Render stripe patterns
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		GL11.glDisable(GL11.GL_DEPTH_TEST);

		buffer.begin(VertexFormat.DrawMode.QUADS, VertexFormats.POSITION_COLOR);

		int renderDistance = 128;
		int blockX = (int) playerX;
		int blockZ = (int) playerZ;

		// Draw stripe grid
		for (int x = blockX - renderDistance; x < blockX + renderDistance; x += STRIPE_WIDTH) {
			for (int z = blockZ - renderDistance; z < blockZ + renderDistance; z += STRIPE_WIDTH) {
				boolean isStriped = StripedTerrainGenerator.isStriped(x, z);
				
				if (isStriped) {
					int r = 100;
					int g = 150;
					int b = 100;
					int a = (int) (255 * STRIPE_OPACITY);

					drawQuad(buffer, x, 60, z, STRIPE_WIDTH, r, g, b, a);
				}
			}
		}

		tessellator.draw();

		GL11.glEnable(GL11.GL_DEPTH_TEST);
		GL11.glDisable(GL11.GL_BLEND);

		matrices.pop();
	}

	private static void drawQuad(BufferBuilder buffer, int x, int y, int z, int size, int r, int g, int b, int a) {
		buffer.vertex(x, y, z).color(r, g, b, a).next();
		buffer.vertex(x + size, y, z).color(r, g, b, a).next();
		buffer.vertex(x + size, y, z + size).color(r, g, b, a).next();
		buffer.vertex(x, y, z + size).color(r, g, b, a).next();
	}
}