# Bedrock Biomes Mod

A Fabric mod for Minecraft 1.20.1 that brings the **Stripelands** and **Flatlands** biomes from Bedrock Edition to Java Edition, complete with distinctive striped terrain rendering and the infamous **Gateways to Hell**.

## Features

### 🌍 Biomes
- **Stripelands Biome**: Features distinctive striped terrain patterns with alternating grass and stone blocks
- **Flatlands Biome**: A perfectly flat grassy landscape ideal for building

### 🔥 Gateways to Hell
After traveling **±2.8 million blocks** from spawn:
- Mountains become massive holes (voids)
- Lava spawns at the bottom (Y=10)
- Creates an eerie, otherworldly boundary effect
- Named after the Bedrock Edition glitch/feature

### 👾 Features
- Custom terrain rendering for visual striped effects
- Full mob spawning support in both biomes
- Dynamic terrain deformation in gateway zones
- Fabric-compatible for easy installation

## Installation

1. Download the latest release from the [Releases](https://github.com/DarkTech1205/new/releases) page
2. Place the `.jar` file in your `mods` folder
3. Launch Minecraft with Fabric installed

## Building from Source

```bash
# Clone the repository
git clone https://github.com/DarkTech1205/new.git
cd new

# Build the mod
./gradlew build

# The built jar will be in build/libs/
```

## Requirements

- Fabric Loader 0.14.21+
- Fabric API 0.92.0+
- Minecraft 1.20.1
- Java 17+

## Configuration

The Gateway to Hell threshold can be modified in `BedrockBiomesMod.java`:

```java
public static final long GATEWAY_THRESHOLD = 2_800_000L; // Blocks from origin
```

## How It Works

### Stripelands Rendering
The striped terrain is created through a combination of:
- Custom terrain height modification in chunk generation
- Client-side rendering overlays showing stripe patterns
- Alternating block types (grass and stone) in a checkerboard pattern

### Gateways to Hell
When you venture far enough from spawn:
- The `GatewayToHellFeature` class detects your distance from origin
- Mountain biomes in gateway zones are modified to create void holes
- Lava is placed at Y=10 to create the "hell" bottom
- Creates the Bedrock Edition's world boundary aesthetic

## License

MIT License - see LICENSE file for details

## Credits

Created by DarkTech1205

## Contributing

Contributions are welcome! Feel free to open issues or pull requests.
