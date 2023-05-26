package Lab8;
public class ConsistentLights extends Lights{

	public ConsistentLights(Junction jun) {setUp(jun);}

	public void timeOut() {
		int newIndexRoadGreen=getIndexRoadGreen()+1;
		setIndexRoadGreen(newIndexRoadGreen);
		System.out.println(toString());

	}
	public String toString() {
		String str="Sequential TrafficLights Junction "+this.getJun()+ "delay= "+this.getDelay()+" green light "+getCurrentGreen();
		return str;
	}
}