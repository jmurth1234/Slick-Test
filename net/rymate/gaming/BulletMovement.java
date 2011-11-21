package net.rymate.gaming;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.StateBasedGame;

import net.rymate.gaming.Component;

public class BulletMovement extends Component {

	float direction;
	float speed;

	public BulletMovement(String id) {
		this.id = id;
	}

	public float getSpeed() {
		return speed;
	}

	public float getDirection() {
		return direction;
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sb, int delta) {

		float rotation = owner.getRotation();
		float scale = owner.getScale();
		Vector2f position = owner.getPosition();

		float hip = 0.4f * delta;

		position.x += hip
				* java.lang.Math.sin(java.lang.Math.toRadians(rotation));
		position.y -= hip
				* java.lang.Math.cos(java.lang.Math.toRadians(rotation));

		owner.setPosition(position);
		owner.setRotation(rotation);
		owner.setScale(scale);
	}

}