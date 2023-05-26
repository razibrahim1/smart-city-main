package Lab8;
import java.util.ArrayList;

public class RandomLights extends Lights{
	public RandomLights(Junction jun) {
		setUp(jun);
		
		
	}

	public void timeOut() {
		ArrayList<Road>roadsEnter=getJun().getRoadsEnter();
		int randomIndex=(int)(Math.random() * ((roadsEnter.size())));//random between 0-numRoads
		setIndexRoadGreen(randomIndex);
		System.out.println(this);
	}
	public String toString() {
		String str="Random TrafficLights Junction "+this.getJun()+ "delay= "+this.getDelay()+"green light "+getCurrentGreen();
		return str;
	}

}
