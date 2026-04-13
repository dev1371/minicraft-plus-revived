package minicraft.api.render;

import minicraft.entity.Entity;
import minicraft.gfx.Screen;

@FunctionalInterface
public interface EntityRenderer {
	void render(Entity entity, Screen screen);
}
