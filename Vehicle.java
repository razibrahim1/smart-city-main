package Lab8;

import java.util.ArrayList;

public class Vehicle extends Thread {
	private int speed;
	private ArrayList<Road> roadList = new ArrayList<Road>();
	private int vid;
	private static int countCars;
	private int timeCounter = 0;
	private boolean arrived=false;
	int indexCurrentRoad = 0;
	private static int activeCars=0;

	public Vehicle(Map map) {
		this.speed = (int) (Math.random() * ((90)) + 30);
		this.roadList = map.randomRoute();
		countCars++;
		this.vid = countCars;
		activeCars=countCars;
		System.out.println("Creating "+this);
	}

	
	@Override
	public String toString() {
		return "Vehicle [vid=" + vid + ", speed=" + speed + ", roadList=" + roadList + "]";
	}


	@Override
	public void run() {
		while(!arrived) {
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
			
			move();
		}
	}

	public void move() {
		
		timeCounter++;
		if (this.roadList.get(indexCurrentRoad).getLength() <= timeCounter * this.speed) {

			if (indexCurrentRoad + 1 == this.roadList.size()) {
				System.out.println("Vehicle " + this.vid + " arrived to it's destination: Junction "
						+ this.roadList.get(indexCurrentRoad).getExit());
				arrived=true;
				activeCars--;
				return;

			}
			else {
				Lights lights=this.roadList.get(indexCurrentRoad).getExit().getLight();
				if (lights!=null&&lights.getCurrentGreen()!=this.getCurrentRoad()) {
					System.out.println("Vehicle " + this.vid + " is  waiting for green light on Junction "+this.getCurrentRoad().getExit().getId());
					return;
				}
				else {
					timeCounter=0;
					indexCurrentRoad++;
				}
				
			}
		}
			
		System.out.println("Vehicle " + this.vid + " is moving on the " + roadList.get(indexCurrentRoad));
			
			
		}

	public static int getActiveCars() {
		return activeCars;
	}



	
	public Road getCurrentRoad() {
		return this.roadList.get(indexCurrentRoad);
	}

	public void setId(int id) {
		this.vid = id;
	}

	public int getTimeCounter() {
		return timeCounter;
	}

	public void setTimeCounter(int timeCounter) {
		this.timeCounter = timeCounter;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public ArrayList<Road> getRoadList() {
		return roadList;
	}

	public void setRoadList(ArrayList<Road> roadList) {
		this.roadList = roadList;
	}

	public boolean IsFinish() {
		if (indexCurrentRoad >= this.roadList.size()) {
			return true;
		}
		return false;
	}

}
