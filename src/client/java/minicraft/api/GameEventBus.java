package minicraft.api;

import minicraft.api.event.GameEvent;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Consumer;

/**
 * Lightweight type-safe event bus for gameplay and modding events.
 */
public final class GameEventBus {
	private final Map<Class<?>, List<Consumer<?>>> handlers = new ConcurrentHashMap<>();

	public <E extends GameEvent> void subscribe(Class<E> eventType, Consumer<E> listener) {
		handlers.computeIfAbsent(eventType, ignored -> new CopyOnWriteArrayList<>()).add(listener);
	}

	@SuppressWarnings("unchecked")
	public <E extends GameEvent> E publish(E event) {
		handlers.getOrDefault(event.getClass(), List.of()).forEach(handler -> ((Consumer<E>) handler).accept(event));
		return event;
	}
}
