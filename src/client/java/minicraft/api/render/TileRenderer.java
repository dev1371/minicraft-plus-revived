package minicraft.api.render;

import minicraft.gfx.Screen;
import minicraft.level.Level;
import minicraft.level.tile.Tile;

@FunctionalInterface
public interface TileRenderer {
	void render(Tile tile, Screen screen, Level level, int x, int y);
}
