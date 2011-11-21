package net.rymate.gaming;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.StateBasedGame;

public class BorderLoopComponent extends Component {
	float direction;
	float speed;

	public BorderLoopComponent(String id) {
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
		Vector2f position = owner.getPosition();
		if (position.x > 800) {
			position.x = -120;
		} else if (position.x < -120) {
			position.x = 800;
		}

		if (position.y > 600) {
			position.y = -120;
		} else if (position.y < -120) {
			position.y = 600;
		}

	}

}
