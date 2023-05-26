package Lab8;

import java.util.ArrayList;
import java.util.Random;

public class Junction extends Point {
	private ArrayList<Road> roadsEnter;
	private ArrayList<Road> roadsExit;
	private int id;// klali la mahlaka
	private Lights light=null;
	private static int countJunction;// klali la mahlaka kedei lishmor


	public Junction() {// random placement for Junction
		super();
		setUp();
	}

	public Junction(double x, double y) {// placement by x and y for Junction
		super(x, y);
		setUp();
	}

	private void setUp() {
		roadsEnter = new ArrayList<Road>();
		roadsExit = new ArrayList<Road>();
			
		countJunction++;
		id = countJunction;
		System.out.println("Creating junction " + id + " at point (" + this.getX() + " ," + this.getY() + ")");
		}


	public boolean equals(Junction other) {
		if (other.getX() != this.getX())
			return false;
		if (other.getY() != this.getY())
			return false;
		return true;
	}

	@Override
	public String toString() {
		return id + " ";
	}

	public void addRoadsEnter(Road other) {
		roadsEnter.add(other);
	}

	public void addRoadsExit(Road other) {
		roadsExit.add(other);
	}

	public ArrayList<Road> getRoadsEnter() {
		return roadsEnter;
	}

	public void setRoadsEnter(ArrayList<Road> roadsEnter) {
		this.roadsEnter = roadsEnter;
	}

	public ArrayList<Road> getRoadsExit() {
		return roadsExit;
	}

	public void setRoadsExit(ArrayList<Road> roadsExit) {
		this.roadsExit = roadsExit;
	}

	public int getId() {
		return id;
	}

	public Lights getLight() {
		return light;
	}

	public void setLight(Lights light) {
		this.light = light;
	}

}
