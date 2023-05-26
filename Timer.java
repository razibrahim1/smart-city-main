package Lab8;
class StopWatch extends Thread {
	int mil=0;
	int sec=0; //0 sec
	int min=0; //0 mil

	@Override
	public void run() {
	int secSum=0;
	int sec=0; 
	int tensSec=0;
	int min=0; 
	int tensMin=0;

		System.out.println("The Game is Started");

		while (Vehicle.getActiveCars()>0) {

			try {
				
				System.out.println("Time : "+tensMin+min+":"+tensSec +sec);
				sleep(1000);

				secSum++;
				int tempSec=secSum;
				tensMin= tempSec/600;
				tempSec-=tensMin*600;
				
				min=tempSec/60%10;
				tempSec-=min*60;
				tensSec=tempSec/10;
				tempSec-=tensSec*10;
				sec=tempSec;
				
						
				
				
				if(Vehicle.getActiveCars()==0) { sleep(3000);}

			} catch (InterruptedException e) {break;}
		}
		System.out.println("the game is finished");
	}
}

