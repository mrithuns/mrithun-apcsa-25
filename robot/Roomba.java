package robot;

import kareltherobot.*;

public class Roomba implements Directions {

	// Main method to make this self-contained
	public static void main(String[] args) {
		// LEAVE THIS ALONE!!!!!!
		String worldName = "robot/finalTestWorld2024.wld"; //which world the roomba is cleanin in

		Roomba cleaner = new Roomba();
		int totalBeepers = cleaner.cleanRoom(worldName, 26, 101); //where the roomba starts
		System.out.println("Roomba cleaned up a total of " + totalBeepers + " beepers.");
		

	}

	// declared here so it is visible in all the methods!
	public Robot roomba;

	// You will need to add many variables!!


	public int cleanRoom(String worldName, int startX, int startY) {

		// A new Robot should be constructed and assigned to the global (instance) variable named roomba that is declared above.
        // Make sure it starts at startX and startY location.

		World.readWorld(worldName);
		World.setVisible(true);
		World.setDelay(0);  //the speed of the world

		int totalBeepers = 0;  //List of variables used to find values 
		int totalSpaces = 1;
		int largestPile = 0;
		int pileCount = 0;
		int numOfPiles = 1;
		int pileLocationX = 0;
		int pileLocationY = 0;

		/** This section will have all the logic that takes the Robot to every location
		 * and cleans up all piles of beepers. Think about ways you can break this
		 * large, complex task into smaller, easier to solve problems.
		 */

		 roomba = new Robot (startX, startY, East, 0);

		// the line below causes a null pointer exception
		// what is that and why are we getting it?
		
		
		boolean moreToClean = true;
		while (moreToClean) {
			while (roomba.frontIsClear()) {
				while (roomba.nextToABeeper()) {
					roomba.pickBeeper();
					pileCount++;
					totalBeepers++;
					if (pileCount>largestPile) {  //looking to find the largest pile size
						largestPile=pileCount;
						pileLocationX =  roomba.street();  //gets the location of the pile
						pileLocationY = roomba.avenue();
					}
				}
				if (pileCount > 0) { //this is to find the number of piles by counting any pile where there is more than 0 beepers
					numOfPiles++;
				}
				roomba.move();
				pileCount=0;
				totalSpaces++;
			}
			
				if (!roomba.frontIsClear()) {
					if (roomba.facingEast()) {
						roomba.turnLeft();
						while (roomba.nextToABeeper()) {
							roomba.pickBeeper();
							pileCount++;
							totalBeepers++;
							if (pileCount>largestPile) {  //Checks for largest pile again
								largestPile=pileCount;
								pileLocationX =  roomba.street();  //gets the location if the pile is bigger
								pileLocationY = roomba.avenue();
							}
						}
						if (roomba.frontIsClear()) {
							roomba.move();
							totalSpaces++;
							roomba.turnLeft();
						}
						else {
							moreToClean=false;
						}
					} 
					else {
						roomba.turnLeft();
						roomba.turnLeft();
						roomba.turnLeft();
						while (roomba.nextToABeeper()) {
							roomba.pickBeeper();
							pileCount++;
							totalBeepers++;
							if (pileCount>largestPile) { //This is to find the largest pile in the room 
								largestPile=pileCount;
								pileLocationX =  roomba.street(); //lines 106 and 107 locate where the largest pile is
								pileLocationY = roomba.avenue();
							}
						}
				
				
						if (roomba.frontIsClear()) {
							roomba.move();
							totalSpaces++;
							roomba.turnLeft();
							roomba.turnLeft();
							roomba.turnLeft();
						}
						else {
							moreToClean=false;
						}
						
					}
				}
		}

		System.out.println("Area is: "+ totalSpaces); //prints Area
		System.out.println("The number of piles is: " + numOfPiles); //Printing piles
		System.out.println("The largest pile is: "+ largestPile); //prints largest
		System.out.println("The location of the largest pile is: " + pileLocationX + "," + pileLocationY); //prints the location
		System.out.println("The average pile size is: " + ((double)totalBeepers / numOfPiles)); //prints avg pile
		System.out.println("The percent dirty is: " + (((double)numOfPiles/totalSpaces) * 100) + "%"); //prints percent diryt
		return totalBeepers; // This method should return the total number of beepers cleaned up.
	}
}
