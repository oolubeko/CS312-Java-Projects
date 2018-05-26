/*
  File: Hailstone.java

  Description: Give the largest Hailstone Cycle length and number of a user defined range

  Student Name: Tomi Olubeko

  Student UT EID: oeo227

  Course Name: CS 312

  Unique Number: 87525

  Date Created: 6/20/16

  Date Last Modified: June 20 2016

*/

import java.util.*;

public class Hailstone
{
	public static void main(String[] args)
	{
		// Declare variables
		Scanner input = new Scanner(System.in);
		int startNum;
		int endNum;
		int max = 0;
		int maxCycle = 0;
		
		// Prompt the user for the starting and ending numbers
		do
		{
			System.out.print("Enter starting and ending number of the range: ");
			startNum = input.nextInt();
			endNum = input.nextInt();
			System.out.println("");
		}
		while((startNum <= 0) || (endNum <= 0) || (startNum > endNum));
		
		
		//Compute the cycle lengths for each number
		for(int i = startNum; i <= endNum; i++)
		{
			int cycleLength = 0;
			int j = i;
			while(j != 1)
			{
				if(j % 2 == 0)
				{
					j /= 2;
					cycleLength += 1;
					
				}
				else
				{
					j = (j * 3 + 1);
					cycleLength += 1;
				}
			}
			
			//Update the max cycle length
			if(cycleLength > maxCycle)
			{
				max = i;
				maxCycle = cycleLength;
			}
			else if((cycleLength == maxCycle) && (i > max))
			{
				max = i;
			}
		}
		
		//Output the results
		System.out.println("The number " + max + " has the longest cycle of length " + maxCycle);
	
	}
}