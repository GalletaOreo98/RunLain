package gameobject;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Cactus extends Enemy {
	
	public int Y_LAND = 150;
	
	private int posX;
	private int width;
	private int height;
	
	private BufferedImage image;
	private MainCharacter mainCharacter;
	
	private Rectangle rectBound;
	
	public Cactus(MainCharacter mainCharacter, int posX, int width, int height, BufferedImage image) {
		this.posX = posX;
		this.width = width;
		this.height = height;
		this.image = image;
		this.mainCharacter = mainCharacter;
		rectBound = new Rectangle();
	}
	
	public void update() {
		posX -= mainCharacter.getSpeedX();
	}
	
	public void draw(Graphics g) {
		g.drawImage(image, posX, Y_LAND - image.getHeight(), null);
		g.setColor(Color.red);
//		Rectangle bound = getBound();
//		g.drawRect(bound.x, bound.y, bound.width, bound.height);
	}
	
	public Rectangle getBound() {
		rectBound = new Rectangle();
		rectBound.x = (int) posX + (image.getWidth() - width)/2;
		rectBound.y = Y_LAND - image.getHeight() + (image.getHeight() - height)/2;
		rectBound.width = width;
		rectBound.height = height;
		return rectBound;
	}

	@Override
	public boolean isOutOfScreen() {
		if(posX < -image.getWidth()) {
			return true;
		}
		return false;
	}

	public int getY_LAND() {
		return Y_LAND;
	}

	public void setY_LAND(int y_LAND) {
		Y_LAND = y_LAND;
	}
	
}