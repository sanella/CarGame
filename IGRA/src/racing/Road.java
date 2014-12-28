package racing;

import java.awt.Color;
import java.awt.Graphics;

public class Road implements AnimatedGameArtifact {
	private int left;
	private int right;
	private int speed;
	private int height;
	
	public static int RODE_SIDE = 50;
	public static int LINE_WIDTH = 10;
	
	private int lineHeight = 50;
	private int lineSpace = 20;
	private int totalLineHeight = lineHeight + lineSpace;
	
	private int start;
	
	public static int WIDTH = 40;
	public static int HEIGHT = 60;

	public Road(int width, int height, int speed) { // konstruktor
		this.height = height;
		this.speed = speed;
		this.left = RODE_SIDE - LINE_WIDTH; // udaljenost branika od granica prozoroa (lijeva strana)
		this.right = width - RODE_SIDE; //  udaljenost branika od granica prozoroa (desna strana)
	}

	@Override
	public void animateFrame(long frameNumber) {
		start = (int) (frameNumber % totalLineHeight) * speed;
	}
	
	@Override
	public void setSpeed(int speed) { //seter za brzinu
		this.speed = speed;
	}

	@Override
	public void draw(Graphics graphics) { //  f-ja koju implementiram iz interfacea
		graphics.setColor(Color.BLACK);
		drawLine(graphics, left); // lijeva stana branika
		drawLine(graphics, right); // desna strana branika
		drawTree(graphics, right);
		drawTree(graphics, left-40);
		drawCarCrash(graphics, left);
		
	}

	private void drawTree(Graphics graphics, int position){ //DRVO
		int y = start - speed * totalLineHeight;
		while (y < height + totalLineHeight) {
			
			graphics.setColor(new Color(87, 44, 10));
			graphics.fillRect(position + 22, y+25, 10, 30);
			
			graphics.setColor(new Color(31, 161, 56));
			graphics.fillOval(position + 10, y , 25, 25);
			
			graphics.setColor(new Color(31, 161, 56));
			graphics.fillOval(position + 20, y +1, 25, 25);
			
			graphics.setColor(new Color(19, 128, 34));
			graphics.fillOval(position + 15, y-3, 25, 25);
			
		
			
			y += 700;
	}
	}
	
	private void drawLine(Graphics graphics, int position) {
		int y = start - speed * totalLineHeight;
		while (y < height + totalLineHeight) {
			graphics.setColor(Color.GRAY);
			graphics.fillRect(position, y, LINE_WIDTH, lineHeight);
			
			y += 70;
		}
		
	}
	
	private void drawCarCrash(Graphics graphics, int position){
		int y = start - speed * totalLineHeight;
		while (y < height + totalLineHeight) {

			graphics.fillRect(position, y, WIDTH, HEIGHT);
			graphics.setColor(Color.gray);
			graphics.fillRect(position + 5, y +5, WIDTH -10, HEIGHT-10);
			graphics.setColor(Color.black);
			graphics.fillRect(position-10, y+10, 10, 10);
			graphics.fillRect( position +WIDTH, y+10, 10, 10);
			graphics.fillRect(position-10, y+40, 10, 10);
			graphics.fillRect( position +WIDTH, y+40, 10, 10);
			
			graphics.fillRect(position-20, y, WIDTH, HEIGHT);
			graphics.setColor(Color.gray);
			graphics.fillRect(position + 5 -20, y +5, WIDTH -10, HEIGHT-10);
			graphics.setColor(Color.black);
			graphics.fillRect(position-10 -20, y+10, 10, 10);
			graphics.fillRect( position-20 +WIDTH, y+10, 10, 10);
			graphics.fillRect(position-10-20, y+40, 10, 10);
			graphics.fillRect( position-20 +WIDTH, y+40, 10, 10);
			
						
			
			y += 1400;
	}
	}
	
}
