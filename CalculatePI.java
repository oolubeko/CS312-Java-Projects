/*
  File: CalculatePI.java

  Description: Approximate PI using random numbers

  Student Name: Tomi Olubeko

  Student UT EID: oeo227

  Course Name: CS 312

  Unique Number: 87525

  Date Created: 7/6/16

  Date Last Modified: 7/7/16

*/

import java.util.*;

public class CalculatePI
{
	// Return true or false depending on whether the coordinate is inside the unit circle
	public static boolean isInside(double xPos, double yPos)
	{
		double distance = Math.sqrt(Math.pow(xPos , 2) + Math.pow(yPos , 2)); //Distance formula
		return(distance < 1);
	}
	
	// Approximate PI by taking the ratio of points inside the circle to total number of throws
	public static double computePI(int numThrows)
	{
		Random randomGen = new Random ( System.currentTimeMillis() );
		double count = 0;		//Initialize to double so ratio is also a double
		int counter = numThrows;
		
		while(counter > 0)
		{
			//Get values for the x and y coordinates
			double xPos = (randomGen.nextDouble()) * 2 - 1.0;
			double yPos = (randomGen.nextDouble()) * 2 - 1.0;
			
			//Increment if they are inside the circle
			if(isInside(xPos , yPos))
			{
				count++;
			}
			counter--;
		}
		
		// Get the ratio and multiply by 4 to approximate PI
		double ratio = count / numThrows;
		ratio *= 4;
		return ratio;
	}
	
	public static void main(String[] args)
	{
		System.out.println("Computation of PI using Random Numbers");
		System.out.println();
		
		// For loop to avoid repeating same code for different number of throws
		for(int i = 100; i <= 100000; i *= 10)
		{
			double computedPI = computePI(i);
			double Difference = computedPI - Math.PI;
			System.out.println("Number of throws = " + i + ", Computed PI = " + computedPI + ", Difference = " + Difference);
		}
	
	}
}