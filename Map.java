package Lab8;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Map {
	private ArrayList<Junction>junList=new ArrayList<Junction>();
	private ArrayList<Road>roadList=new ArrayList<Road>();

	public Map(int num) {
		//Creating new junctions
		creatJunctions(num);
		//Creating new random roads
		creatRoads(num);
		//Creating lights given a probability of a quarter to each junction
		setLights(num);


	}
	public Map(ArrayList<Junction>junList,ArrayList<Road>roadList) {
		this.junList=junList;
		this.roadList=roadList;
		setLights(this.junList.size());


	}

	public void creatJunctions(int num) {
		this.junList=new ArrayList<Junction>();
		for (int i=0;i<num;i++)
		{
			this.junList.add(new Junction());
		}
	}

	public void creatRoads(int num) {
		Random ran=new Random();
		for(int j=0;j<num;j++) {
			for(int k=0;k<num;k++)
			{
				if(j!=k && ran.nextBoolean())
				{
					roadList.add(new Road(this.junList.get(j),junList.get(k)));
				}
			}
		}
	}

	public void setLights(int num) {
		Random ran=new Random();
		int probi=0;
		for(int k=0;k<num;k++) {
			probi=(int)(Math.random() * ((3)+1));
			if(probi==2)

			{
				if(ran.nextBoolean())
				{
					RandomLights ranLights= new RandomLights(this.junList.get(k));

				}
				else 
				{
					ConsistentLights ConsisLights= new ConsistentLights(this.junList.get(k));

				}
			}

		}
	}

	public ArrayList<Road> randomRoute() 
	{// creating random road (no more then 4 roads& dereh lelo motza)
		ArrayList<Road>randomRoads=new ArrayList <Road>(); 
		Random ran=new Random();
		Junction cur;
		do {
			int ranIndex=(int)(Math.random() * ((this.junList.size())));


			cur=junList.get(ranIndex);
		}while(cur.getRoadsExit().size()==0);

		while(cur.getRoadsExit().size()!=0&&randomRoads.size()<=4)
		{
			randomRoads.add(cur.getRoadsExit().get(ran.nextInt(cur.getRoadsExit().size())));
			cur=randomRoads.get(randomRoads.size()-1).getExit();
		}
		return randomRoads;
	}

	public String toString() {
		return "Map [junList=" + junList + ", roadList=" + roadList + "]";
	}
	public ArrayList<Junction> getJunctions() {
		return junList;
	}
	public void setJunList(ArrayList<Junction> getJunctions) {
		this.junList = junList;
	}
	public ArrayList<Road> getRoadList() {
		return roadList;
	}
	public void setRoadList(ArrayList<Road> roadList) {
		this.roadList = roadList;
	}
	private int min_index(Boolean[] visited, Double[] lengths){
		double min = Double.MAX_VALUE;
		int min_index = -1;
		for(int i=0;i<lengths.length;i++) {
			if (!visited[i] && lengths[i] <= min) {
				min = lengths[i];
				min_index = i;
			}
		}
		return min_index;
	}
    private Vertex createRoad(int start, int end, ArrayList<Junction> points_on_route){
    	Vertex route = new Vertex(null);
        if(points_on_route.get(end) == null && end!=start)
            return null; //no route.
        int i = end;
        while(i!=start){
            Junction start_j = points_on_route.get(i);
            Junction end_j = this.junList.get(i);
            Road r =findRoad(start_j, end_j);//TODO exception if null
            route.addRoad(0, r);
            i=this.junList.indexOf(start_j);
        }
        return route;
    }
	private Road findRoad(Junction start_j, Junction end_j) {
		for(int i=0;i<roadList.size();i++){
        if(roadList.get(i).getEnter().equals(start_j) &&
        		roadList.get(i).getExit().equals(end_j))
            return roadList.get(i);
    }
    return null;
	}
	private void relax(int src_index, Boolean[] visited, Double[] lengths, ArrayList<Junction> points_on_route){
		for(int i=0;i<this.roadList.size();i++){
			if(roadList.get(i).getEnter() == junList.get(src_index)){
				int end_index = junList.indexOf(roadList.get(i).getExit());
				if(lengths[end_index] > lengths[src_index] +
						junList.get(end_index).calcDistance(junList.get(src_index))){
					lengths[end_index] = lengths[src_index] +
							junList.get(end_index).calcDistance(junList.get(src_index));
					points_on_route.set(end_index , junList.get(src_index));
				}

			}
		}
	}
	public Vertex calcShortestPath(Junction start, Junction end)
	{
		Boolean[] visited = new Boolean[junList.size()];
		Arrays.fill(visited, Boolean.FALSE);

		Double[] lengths = new Double[junList.size()];
		Arrays.fill(lengths, Double.MAX_VALUE);

		ArrayList<Junction> points_on_route =
				new ArrayList<>(Collections.nCopies(junList.size(), null));


		int start_index = junList.indexOf(start);
		int end_index = junList.indexOf(end);
		lengths[start_index] = (double)0;

		while(!visited[end_index]){
			int min = min_index(visited, lengths); 
			visited[min] = true;
			relax(min, visited, lengths, points_on_route);
		}
		return createRoad(start_index, end_index, points_on_route);
	}
	public Vertex randomVertex(Vertex shortest) {
		int route_length =1;
        ArrayList<Road> random_route = new ArrayList<Road>();
        Integer[] array = new Integer[junList.size()];
        for(int i=0;i<junList.size();i++)
            array[i] = i;
        List<Integer> l = Arrays.asList(array);
        Collections.shuffle(l);

        random_route.add(new Road(junList.get(l.get(0)), junList.get(l.get(1))));
        for(int i=1;i<junList.size()-1;i++){
            if(route_length>=4 || junList.get(l.get(i)).getRoadsExit().size() ==0)
                break;
            route_length++;
            random_route.add(new Road(junList.get(l.get(i)), junList.get(l.get(i+1))));
        }
        return new Vertex(random_route);
		
	}      
}










