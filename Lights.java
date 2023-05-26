package Lab8;

abstract  class Lights extends Thread{
	private int delay;
	private Junction jun;
	private int indexRoadGreen;
	private boolean isGreen;


	@Override
	public void  run() {
		while (Vehicle.getActiveCars()>0) {
			try {

				sleep(getDelay()*1000);

			}
			catch(Exception e) {	

			}
			timeOut();
			System.out.println(this);
		}
	}

	public abstract void timeOut();

	public void setUp(Junction jun) {
		this.jun=jun;
		this.delay=(int)(Math.random() * 2+2);
		jun.setLight(this);
		System.out.println("Creating " + this);
	}

	public Road getCurrentGreen(){
		return this.jun.getRoadsEnter().get(indexRoadGreen);// mahzira et ha kvish im or yarok

	}
	public Junction getJun() {
		return jun;
	}
	public void setJun(Junction jun) {
		this.jun = jun;
	}

	public int getIndexRoadGreen() {
		return indexRoadGreen;
	}
	public void setIndexRoadGreen(int indexRoadGreen) {

		this.indexRoadGreen = indexRoadGreen%(this.getJun().getRoadsEnter().size());
	}

	public int getDelay() {
		return delay;
	}
	public void setDelay(int delay) {
		this.delay = delay;
	}

	public boolean isGreen() {
		return isGreen;
	}

	public void setGreen(boolean isGreen) {
		this.isGreen = isGreen;
	}

}
