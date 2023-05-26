package Lab8;

import java.util.ArrayList;

public class Road {
	private Junction enter;
	private Junction exit;
	public Road(Junction enter,Junction exit) {
		this.enter=enter;
		if(enter.equals(exit))
		{
			Junction ran=new Junction();
			this.exit=ran;
			System.out.println("Road can not connect a junction to itself, the end junction has been replaced with Junction "+exit.getId());
		}
		else
		{
			this.exit=exit;
		}
		this.enter.addRoadsExit(this);
		this.exit.addRoadsEnter(this);
		System.out.println("Creating Road from Junction "+enter.getId()+" to Junction "+exit.getId() +" length= "+getLength());

	}
	


	public Junction getEnter() {
		return enter;
	}
	public void setEnter(Junction enter) {
		this.enter = enter;
	}
	public Junction getExit() {
		return exit;
	}
	public void setExit(Junction exit) {
		this.exit = exit;
	}
	public double getLength() {
		return this.enter.calcDistance(this.exit);
	}
	public String toString() {
		String str="Road from junction "+this.enter.getId()+" to junction "+this.exit.getId();
		return str;
	}
	
	public boolean Equals(Road r2)
	{
		if(this.enter.equals(r2.getEnter())&&
				this.exit.equals(r2.getExit()))
			return true;
		return false;
	}

}



