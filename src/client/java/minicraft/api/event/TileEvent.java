package minicraft.api.event;

import minicraft.level.Level;
import minicraft.level.tile.Tile;

/**
 * Event fired before a tile is changed in the world.
 */
public final class TileEvent extends CancellableGameEvent {
	private final Level level;
	private final int x;
	private final int y;
	private final Tile previousTile;
	private final Tile nextTile;
	private final int nextData;

	public TileEvent(Level level, int x, int y, Tile previousTile, Tile nextTile, int nextData) {
		this.level = level;
		this.x = x;
		this.y = y;
		this.previousTile = previousTile;
		this.nextTile = nextTile;
		this.nextData = nextData;
	}

	public Level level() { return level; }
	public int x() { return x; }
	public int y() { return y; }
	public Tile previousTile() { return previousTile; }
	public Tile nextTile() { return nextTile; }
	public int nextData() { return nextData; }
}
