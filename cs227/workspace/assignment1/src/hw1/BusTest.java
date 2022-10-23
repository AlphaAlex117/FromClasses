package hw1;

public class BusTest 
{

	public static void main(String[] args) 
	{
		System.out.println("______ START ______");
		System.out.println();
		System.out.println();
		
		System.out.println();
		System.out.println("______ Stops TEST ______");
		System.out.println();
		
		CyrideBus b = new CyrideBus(10, 3);
		System.out.println(b.getCurrentStop());
		System.out.println("   Expected Stop: -1"); // starts out at BUS_GARAGE
		b.nextStop(0, 0);
		System.out.println(b.getCurrentStop());
		System.out.println("   Expected Stop: 0");
		b.nextStop(0, 0);
		System.out.println(b.getCurrentStop());
		System.out.println("   Expected Stop: 1");
		b.nextStop(0, 0);
		System.out.println(b.getCurrentStop());
		System.out.println("   Expected Stop: 2");
		b.nextStop(0, 0);
		System.out.println(b.getCurrentStop());
		System.out.println("   Expected Stop: 0");
		b.nextStop(0, 0);
		System.out.println(b.getCurrentStop());
		System.out.println("   Expected Stop: 1");
		b.nextStop(0, 0);
		System.out.println(b.getCurrentStop());
		System.out.println("   Expected Stop: 2");
		b.nextStop(0, 0);
		System.out.println(b.getCurrentStop());
		System.out.println("   Expected Stop: 0");
		b.nextStop(0, 0);
		System.out.println(b.getCurrentStop());
		System.out.println("   Expected Stop: 1");
		b.nextStop(0, 0);
		System.out.println(b.getCurrentStop());
		System.out.println("   Expected Stop: 2");
		
		System.out.println();
		System.out.println("______ Second Stop TEST ______");
		System.out.println();
		
		CyrideBus b2 = new CyrideBus(10, 6);
		System.out.println(b2.getCurrentStop());
		System.out.println("   Expected Stop: -1"); // starts out at BUS_GARAGE
		b2.nextStop(0, 0);
		System.out.println(b2.getCurrentStop());
		System.out.println("   Expected Stop: 0");
		b2.nextStop(0, 0);
		System.out.println(b2.getCurrentStop());
		System.out.println("   Expected Stop: 1");
		b2.nextStop(0, 0);
		System.out.println(b2.getCurrentStop());
		System.out.println("   Expected Stop: 2");
		b2.nextStop(0, 0);
		System.out.println(b2.getCurrentStop());
		System.out.println("   Expected Stop: 3");
		b2.nextStop(0, 0);
		System.out.println(b2.getCurrentStop());
		System.out.println("   Expected Stop: 4");
		b2.nextStop(0, 0);
		System.out.println(b2.getCurrentStop());
		System.out.println("   Expected Stop: 5");
		b2.nextStop(0, 0);
		System.out.println(b2.getCurrentStop());
		System.out.println("   Expected Stop: 0");
		b2.nextStop(0, 0);
		System.out.println(b2.getCurrentStop());
		System.out.println("   Expected Stop: 1");
		
		System.out.println();
		System.out.println("______ isInService TEST ______");
		System.out.println();

		CyrideBus b3 = new CyrideBus(5, 3);
		System.out.println(b3.isInService());
		System.out.println("   Expected Value: true");
		b3.removeFromService();
		System.out.println(b3.isInService());
		System.out.println("   Expected Value: false");
		b3.placeInService();
		System.out.println(b3.isInService());
		System.out.println("   Expected Value: true");
		
		System.out.println();
		System.out.println("______ Passengers TEST ______");
		System.out.println();
		
		CyrideBus b4 = new CyrideBus(10, 3);
		System.out.println(b4.getNumPassengers());
		System.out.println("   Expected Num: 0");
		b4.nextStop(0, 5);
		System.out.println(b4.getNumPassengers());
		System.out.println("   Expected Num: 5");
		b4.nextStop(2, 20);
		System.out.println(b4.getNumPassengers());
		System.out.println("   Expected Num: 10");
		b4.nextStop(20, 4);
		System.out.println(b4.getNumPassengers());
		System.out.println("   Expected Num: 4");
		
		System.out.println();
		System.out.println("______ Total Riders TEST ______");
		System.out.println();
		
		CyrideBus b5 = new CyrideBus(10, 3);
		System.out.println(b5.getTotalRiders());
		System.out.println("   Expected Num: 0");
		b5.nextStop(0, 5);
		System.out.println(b5.getTotalRiders());
		System.out.println("   Expected Num: 5");
		b5.nextStop(2, 20);
		System.out.println(b5.getTotalRiders());
		System.out.println("   Expected Num: 12");
		b5.nextStop(20, 4);
		System.out.println(b5.getTotalRiders());
		System.out.println("   Expected Num: 16");
		
		System.out.println();
		System.out.println("______ OutofService and BackinService TEST ______");
		System.out.println();
		
		CyrideBus b6 = new CyrideBus(60, 12); 
		b6.nextStop(0, 5);
		b6.nextStop(0, 5);
		b6.removeFromService();
		System.out.println(b6.getCurrentCapacity());
		System.out.println("   Expected Value: 0");
		b6.placeInService();
		System.out.println(b6.getCurrentCapacity());
		System.out.println("   Expected Value: 60");
		System.out.println(b6.getCurrentStop());
		System.out.println("   Expected Stop: -1");
		
		System.out.println();
		System.out.println("______ OutofService Ride TEST ______");
		System.out.println();
		
		CyrideBus b7 = new CyrideBus(35, 5);
		b7.removeFromService();
		b7.nextStop(0, 6);
		System.out.println(b7.getCurrentStop());
		System.out.println("   Expected Stop: 0");
		System.out.println(b7.getNumPassengers());
		System.out.println("   Expected Num: 0");
		b7.nextStop(4, 20);
		System.out.println(b7.getCurrentStop());
		System.out.println("   Expected Stop: 1");
		System.out.println(b7.getNumPassengers());
		System.out.println("   Expected Num: 0");
		
		
		System.out.println();
		System.out.println();
		System.out.println("______ END ______");
	}

}
