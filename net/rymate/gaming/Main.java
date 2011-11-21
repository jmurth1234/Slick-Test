package net.rymate.gaming;

import java.io.File;
import org.lwjgl.LWJGLUtil;
import org.newdawn.slick.*;
import org.newdawn.slick.geom.Vector2f;

public class Main extends BasicGame {

	public static String title = "Rymate Test Shooter";
	Entity land;
	Entity plane;
	Entity bullet;
	float maxX = 800;
	float maxY = 600;

	public Main(String title) {
		super(title);
	}

	@Override
	public void init(GameContainer gc) throws SlickException {
		land = new Entity("land");
		land.AddComponent(new ImageRender("LandRender", new Image("/data/land.jpg")));
		
		plane = new Entity("plane");
		plane.AddComponent(new ImageRender("PlaneRender", new Image("/data/plane.png")));
		plane.AddComponent(new Movement("PlaneMovement"));
		plane.AddComponent(new ShootComponent("PlaneShoot", this));
		plane.AddComponent(new BorderLoopComponent("PlaneMovementLoop"));
		plane.setPosition(new Vector2f(400, 300));
		
		bullet = new Entity("bullet");
	}
	
    public void createBullet(float rotation, Vector2f pos) throws SlickException {
		bullet = new Entity("bullet");
		bullet.AddComponent(new BulletMovement("BulletMovement"));
		bullet.AddComponent(new ImageRender("BulletRender", new Image("/data/bullet.png")));
		bullet.rotation = rotation;
		bullet.setPosition(pos);
    }
    
	@Override
	public void update(GameContainer gc, int delta) throws SlickException {
		land.update(gc, null, delta);
		plane.update(gc, null, delta);
		bullet.update(gc, null, delta);
	}
	

	public void render(GameContainer gc, Graphics g) throws SlickException {
		land.render(gc, null, g);
		plane.render(gc, null, g);
		bullet.render(gc, null, g);
	}

	public static void main(String[] args) throws SlickException {
		System.setProperty("org.lwjgl.librarypath",
				new File(new File(System.getProperty("user.dir"), "native"),
						LWJGLUtil.getPlatformName()).getAbsolutePath());
		System.setProperty("net.java.games.input.librarypath",
				System.getProperty("org.lwjgl.librarypath"));
		AppGameContainer app = new AppGameContainer(new Main(title));
		app.setDisplayMode(800, 600, false);
		app.setSmoothDeltas(true);
		app.setShowFPS(true);
		app.start();
	}
}