package minicraft.api.event;

/**
 * Base class for cancellable events fired by the public modding API.
 */
public non-sealed abstract class CancellableGameEvent implements GameEvent {
	private boolean cancelled;

	public final boolean isCancelled() {
		return cancelled;
	}

	public final void cancel() {
		cancelled = true;
	}
}
