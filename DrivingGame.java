package Lab8;

import java.util.Random;

public class DrivingGame {
	private Map map;
	private StopWatch timer;

	private Vehicle[] vAR;

	public DrivingGame(int numJunction, int numVehicle) {
		Random ran=new Random();
		this.timer = new StopWatch();
		this.map = new Map(numJunction);// Creating new map
		this.vAR = new Vehicle[numVehicle];// Set the size of Array
			
		for (int i = 0; i < this.vAR.length; i++) {
				this.vAR[i] = new Vehicle(this.map);
				if(vAR[i].getCurrentRoad().getEnter().equals(vAR[i].getCurrentRoad().getExit()))
				{
					
	                Road start = map.randomRoute().get(0);
	                Road end = map.randomRoute().get(map.randomRoute().size()-1);

	                Vertex shortest = map.calcShortestPath(start.getEnter(), end.getExit());
	                map.randomVertex(shortest);
				}
					
		}
	}

	public void play() {
		timer.setPriority(10);
		timer.start();
		for (int i = 0; i < vAR.length; i++) {vAR[i].start();}
		
		for(int i=0;i<map.getJunctions().size();i++)
		{
			if(map.getJunctions().get(i).getLight()!=null) {
				map.getJunctions().get(i).getLight().setPriority(7);
				map.getJunctions().get(i).getLight().start();
			}
		}
	}
		

	public boolean IsDone() {
		for (int i = 0; i < this.vAR.length; i++) {
			if (this.vAR[i].IsFinish() == false)
				return false;
		}
		return true;
	}

}
