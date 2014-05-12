/*********************************************************
* Main.java (Project 1: Empirical Analysis - Array Search)
* Author: Robert Payne
* Date: 9/3/2012
* Class: ITCS 2215

* Purpose: To analyze the number of comparisons made to 
 to locate random integers in an array. The array is
 set up to be 2^15 elements. The program then fills the
 array up with random integers in steps starting at 2^8
 moving upwards to 2^15. The program loops through each
 set and performs linear searches 10% of the set size.
 The comparisons are added up then divided by the size
 of the set. The result is outputed to the console for
 each set. 

/*********************************************************/
import java.util.Random;

public class Main {

/*	main()	 
===========================================================

---------------------------------------------------------*/ 
	public static void main(String[] args) {	
	 
	 	int[] searchTable = new int[32786]; //the array to be filled
														//with random numbers

		Random randomNumber = new Random();	//random number object

		int powOfTwo = 8;							//placeholder for which
														//power of two currently on

		int currentSize;							//current size of array
														//being analyzed

		int searchCounter;						//number of comparisons made

		int m;										//stores 10% of currentSize

		int searchVal;								//stores the random value being
														//searched for

		boolean found;								//true when the value has been
														//found in the array
		
		//This loop iterates for each power of 2 from 8 to 15
		while(powOfTwo <= 15) {
			
			currentSize =(int) Math.pow(2, powOfTwo); //set the currentSize
			
			//initialize the array with random numbers
			for(int i = 0; i < currentSize; i++) {
			
				searchTable[i] = randomNumber.nextInt(currentSize);
			}
			
			m = currentSize / 10;
			searchCounter = 0;	//reset the searchCounter to 0
			
			//search for a random value m times
			for(int n = 0; n < m; n++) {
				
				found = false; 	//reset found to false before next search
				searchVal = randomNumber.nextInt(currentSize);
					
				//linear search of the array
				for(int k = 0; k < currentSize && !found; k++) {
						
					if(searchTable[k] == searchVal) {
						found = true;
					}
				
					searchCounter++;	//increment searchCounter since a comparison was performed
				}
							
			}			
			
			System.out.println("Size: " + currentSize + "    \tComparisons/Size: " + searchCounter / currentSize); //output
			powOfTwo++;	//increment the search array size for the next iteration
			
		}
	}
}