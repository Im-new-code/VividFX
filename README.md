# VividFX for Minecraft 1.17.1

Lightweight client-side visual effects inspired by Shine/Shimmer-style presentation, tailored for lower-end hardware.

## Included
- Screen-space highlight extraction + subtle bloom
- Two-pass radius-1 blur to keep GPU cost low
- Contrast, saturation and brightness grade tuned toward the supplied reference screenshot
- No colored-light engine
- No sky replacement
- No gameplay/server changes

## Intended stack
1. Cyan Sky resource pack
2. Reference Visuals resource pack
3. Your existing 200% saturation resource pack
4. VividFX mod

## Requirements
- Minecraft 1.17.1
- Fabric Loader 0.16.14+
- Fabric API 0.46.1+1.17
- Java 17+

The build is provided as source because this environment cannot download the Minecraft/Fabric dependencies needed to produce a verified 1.17.1 binary. Use the included Gradle project / GitHub Actions workflow to build `build/libs/vividfx-1.0.0.jar`.
