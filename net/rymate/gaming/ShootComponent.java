package net.rymate.gaming;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.StateBasedGame;

public class ShootComponent extends Component {

	private Main main;

	public ShootComponent(String id, Main m) {
		this.id = id;
		this.main = m;
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sb, int delta) {
		Input input = gc.getInput();

		if (input.isKeyDown(Input.KEY_SPACE)) {
			try {
				float rotation = owner.getRotation();
				Vector2f pos = owner.getPosition();
				main.createBullet(rotation, pos);
			} catch (SlickException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
