package Lab8;

import java.util.Random;

public class Point {
	@Override
	public String toString() {
		return "Creating Point ("+this.x+" , "+this.y+" ) ";
	}
	private double x;
	private double y;
	public Point() {
		Random rand = new Random();
		x = rand.nextInt(800);
		y =rand.nextInt(600);
	}
	public Point(double x,double y) {
		this.x=x;
		this.y=y;
	}

	public void isProper(Point p) {
		Random rand = new Random();
		if (p.x<0||p.x>800)
			p.x=rand.nextInt(800);
		if(p.y<0||p.y>600)
			p.y=(rand.nextInt(800));
	}
	public double calcDistance(Point p) {
		return (double) Math.sqrt((p.getY() - this.y) * (p.getY() - this.y) + (p.getX() - this.x) * (p.getX() - this.x));
	}
	
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}
	
}

