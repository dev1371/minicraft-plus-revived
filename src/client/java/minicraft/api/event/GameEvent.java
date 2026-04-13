package minicraft.api.event;

/**
 * Marker interface for all public Minicraft modding events.
 * <p>
 * The interface is intentionally sealed so plugin developers can rely on
 * exhaustive pattern matching in modern JDKs (17+).
 */
public sealed interface GameEvent permits CancellableGameEvent {
}
