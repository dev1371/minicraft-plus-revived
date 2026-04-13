package minicraft.api.event;

import minicraft.entity.Entity;
import minicraft.level.Level;

/**
 * Event fired before entities are added to or removed from levels.
 */
public final class EntityEvent extends CancellableGameEvent {
	public enum Type { ADD, REMOVE }

	private final Type type;
	private final Level level;
	private final Entity entity;

	public EntityEvent(Type type, Level level, Entity entity) {
		this.type = type;
		this.level = level;
		this.entity = entity;
	}

	public Type type() { return type; }
	public Level level() { return level; }
	public Entity entity() { return entity; }
}
