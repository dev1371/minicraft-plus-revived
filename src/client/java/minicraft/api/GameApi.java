package minicraft.api;

import minicraft.api.event.EntityEvent;
import minicraft.api.event.GameEvent;
import minicraft.api.event.TileEvent;
import minicraft.api.render.EntityRenderer;
import minicraft.api.render.TileRenderer;
import minicraft.entity.Entity;
import minicraft.gfx.Screen;
import minicraft.item.Item;
import minicraft.item.Items;
import minicraft.level.Level;
import minicraft.level.tile.Tile;
import minicraft.level.tile.Tiles;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Public modding entrypoint. Exposes eventing, registries and rendering hooks.
 */
public final class GameApi {
	private GameApi() {}

	public static final GameEventBus EVENTS = new GameEventBus();

	private static final Map<Class<? extends Tile>, TileRenderer> TILE_RENDERERS = new ConcurrentHashMap<>();
	private static final Map<Class<? extends Entity>, EntityRenderer> ENTITY_RENDERERS = new ConcurrentHashMap<>();

	public static void registerTile(short id, Tile tile) {
		Tiles.register(id, tile);
	}

	public static Optional<Tile> unregisterTile(short id) {
		return Tiles.unregister(id);
	}

	public static void registerItem(Item item) {
		Items.register(item);
	}

	public static boolean unregisterItem(String name) {
		return Items.unregister(name);
	}

	public static void registerTileRenderer(Class<? extends Tile> tileType, TileRenderer renderer) {
		TILE_RENDERERS.put(tileType, renderer);
	}

	public static void registerEntityRenderer(Class<? extends Entity> entityType, EntityRenderer renderer) {
		ENTITY_RENDERERS.put(entityType, renderer);
	}

	public static void renderTile(Tile tile, Screen screen, Level level, int x, int y) {
		TileRenderer renderer = TILE_RENDERERS.get(tile.getClass());
		if (renderer != null) renderer.render(tile, screen, level, x, y);
		else tile.render(screen, level, x, y);
	}

	public static void renderEntity(Entity entity, Screen screen) {
		EntityRenderer renderer = ENTITY_RENDERERS.get(entity.getClass());
		if (renderer != null) renderer.render(entity, screen);
		else entity.render(screen);
	}

	public static TileEvent publish(TileEvent event) {
		return EVENTS.publish(event);
	}

	public static EntityEvent publish(EntityEvent event) {
		return EVENTS.publish(event);
	}

	public static <E extends GameEvent> void on(Class<E> eventType, java.util.function.Consumer<E> listener) {
		EVENTS.subscribe(eventType, listener);
	}
}
