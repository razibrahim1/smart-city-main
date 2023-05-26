package Lab8;
//import java.util.ArrayList;
//public class Program {
//
//	public static void main(String[] args) {
//
//	/*	System.out.println("=========Testing class Point=========");
//		Point a=new Point(0,0);
//		Point b=new Point(8,6);
//		Point c=new Point(805.0,0);
//		System.out.println(a.toString());
//		System.out.println(b.toString());
//		
//
//		System.out.println("The distance between a and b is " +a.calcDistance(b));
//		
//		a= new Point();
//		a=new Point(5, 805);
//		a=new Point (805, 5);
//		a=new Point(-5, 609.22);
//		
//		System.out.println("\n=========Testing class Junction=========");
//
//		Junction j=new Junction();
//		Junction k=new Junction();
//		System.out.println("The distance between "+ j +" and " + k+" is " +j.calcDistance(k));
//		System.out.println("The distance between "+ k +" and " + j+" is "+k.calcDistance(j));
//		
//		System.out.println("\n=========Testing class Road=========");
// 
//		Road road=new Road (j,k);
//		System.out.println("The length of "+road+" is "+road.getLength());
//		System.out.println(road.toString());
//		System.out.println(road.getEnter().getRoadsExit());
//		System.out.println(road.getExit().getRoadsEnter());
//		
//		road=new Road(j,j);
//		System.out.println("The length of "+road+" is "+road.getLength());
//		System.out.println(j.getRoadsExit());
//	
//	
//		System.out.println("\n=========Testing class Map=========");
//		System.out.println("\n Map #1");
//		
//		Map map=new Map(10);
//		//System.out.println(map.calcShortestPath(map.getJunctions().get(4), map.getJunctions().get(0)));
//		
//		System.out.println("\n Map #2");
//		ArrayList<Junction> junctions=new ArrayList<Junction>();
//		junctions.add(new Junction(0, 0));
//		junctions.add(new Junction(0, 3));
//		junctions.add(new Junction(4, 3));
//		junctions.add(new Junction(4, 0));
//		ArrayList<Road>roads=new ArrayList<Road>();
//		roads.add(new Road(junctions.get(0), junctions.get(1)));
//		roads.add(new Road(junctions.get(1), junctions.get(2)));
//		roads.add(new Road(junctions.get(2), junctions.get(3)));
//		roads.add(new Road(junctions.get(3), junctions.get(0)));
//		roads.add(new Road(junctions.get(0), junctions.get(2)));
//		map=new Map(junctions,roads);
//		//System.out.println(map.calcShortestPath(map.getJunctions().get(0), map.getJunctions().get(3)));
//			*/
//		
//		System.out.println("\n===========Testing the game============\n");
//		Thread A = new Thread(new StopWatch());
////		Thread game = new Thread(new DrivingGame(10, 5));
//		
////		game.run();
////		A.start();
//		A.run();
////		A.start();
//		
//		A.stop();
//		
//	
//	}
//}
import java.util.ArrayList;

public class Program {

	public static void main(String[] args) {
			
		System.out.println("\n=========Testing class Map=========");
		
		ArrayList<Junction> junctions=new ArrayList<Junction>();
		junctions.add(new Junction(0, 0));
		junctions.add(new Junction(0, 3));
		junctions.add(new Junction(4, 3));
		junctions.add(new Junction(4, 0));
		ArrayList<Road>roads=new ArrayList<Road>();
		roads.add(new Road(junctions.get(0), junctions.get(1)));
		roads.add(new Road(junctions.get(1), junctions.get(2)));
		roads.add(new Road(junctions.get(2), junctions.get(3)));
		roads.add(new Road(junctions.get(3), junctions.get(0)));
		roads.add(new Road(junctions.get(0), junctions.get(2)));
		Map map=new Map(junctions, roads);
		System.out.println(map.calcShortestPath(map.getJunctions().get(0), map.getJunctions().get(3)));
			
		
		System.out.println("\n===========Testing the game============\n");
		
		DrivingGame game=new DrivingGame(10, 5);
		game.play();
		
	}

}
