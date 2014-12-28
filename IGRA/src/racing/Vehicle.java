package racing;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;

public class Vehicle implements GameArtifact {
	public static int WIDTH = 40;
	public static int HEIGHT = 60;
	
	public static int WIDTH_HALF = WIDTH/2;
	public static int HEIGHT_HALF = HEIGHT/2;
	
	protected int x;
	protected int y;
	
	private int crashFrame; 
	
	private int crashFrameOBJ;

	public Vehicle(int x, int y) {
		setPosition(x, y);
	}
	
	public void setPosition(int x, int y) {
		this.x = x - WIDTH_HALF;
		this.y = y - HEIGHT_HALF;
	}
	
	public void setX(int x) {
		this.x = x - WIDTH_HALF; 
	}

	@Override
	public void draw(Graphics graphics) { 
		if (crashFrame > 0) {
			drawCar(graphics, Color.RED);
			crashFrame--;
		} else if (crashFrameOBJ > 0){
			x+=10;
			crashFrameOBJ--;
	
		} else {
			drawCar(graphics, Color.BLUE);
		}
		
	}
	
	protected void drawCar(Graphics graphics, Color c) { //crtanje auta
		
		graphics.setColor(c );
		graphics.fillRect(x, y, WIDTH, HEIGHT);
		graphics.setColor(Color.gray);
		graphics.fillRect(x + 5, y +5, WIDTH -10, HEIGHT-10);
		graphics.setColor(Color.black);
		graphics.fillRect(x-10, y+10, 10, 10);
		graphics.fillRect( x +WIDTH, y+10, 10, 10);
		graphics.fillRect(x-10, y+40, 10, 10);
		graphics.fillRect( x +WIDTH, y+40, 10, 10);
		
		
	}

	public boolean colade(Vehicle v) {
		return Math.abs(x - v.x) < WIDTH && Math.abs(y - v.y) < HEIGHT;
	}

	public void crash() {
		
		crashFrame = 20;
	}
	
	public boolean isCrashed() {
		return crashFrame > 0;
	}
	
	
	
	//moje
	public void crashOBJ() {
		crashFrameOBJ = 5;
	}
	
	public boolean isCrashedOBJ() {
		return crashFrameOBJ > 0;
	}
	
}
