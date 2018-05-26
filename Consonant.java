/*
  File: Consonant.java

  Description: Given a string, find the longest run of consonant that are either ascending or descending.

  Student Name: Tomi Olubeko

  Student UT EID: oeo227

  Course Name: CS 312

  Unique Number: 87525

  Date Created: 7/19/16

  Date Last Modified: 7/20/16

*/

import java.util.Scanner;
import java.io.*;

public class Consonant
{
	//Method that returns all the consonants in a string
	public static String toConsonant(String line)
	{
		String cnsnt = "";
		for(int jk = 0; jk < line.length(); jk++)
		{
			char isCnsnt = line.charAt(jk);
			if((!Character.isLetter(isCnsnt)) || (isCnsnt == 'a') || (isCnsnt == 'e') || (isCnsnt == 'i') || (isCnsnt == 'o') || (isCnsnt == 'u'))
			{
				continue;
			}
			cnsnt += isCnsnt;
		}
		return cnsnt;
	}

	//Method that returns the maximum number of descending consonants
	public static int maxLowest(String line)
	{
		int maxLoCount = 0;
		for(int j = 0; j < line.length(); j++)
		{
			char start = line.charAt(j);
			int countDec = 1;
			for(int k = j + 1; k < line.length(); k++)
			{
				char next = line.charAt(k);
				if(start >= next)
				{
					start = next;
					countDec++;
					continue;
				}
				else
				{
					break;
				}
			}
			if(countDec > maxLoCount)
			{
				maxLoCount = countDec;
			}
		}
		return maxLoCount;
	}

	//Method that returns the maximum number of ascending consonants
	public static int maxHighest(String line)
	{
		int maxHiCount = 0;
		for(int m = 0; m < line.length(); m++)
		{
			char start = line.charAt(m);
			int countInc = 1;
			for(int n = m + 1; n < line.length(); n++)
			{
				char next = line.charAt(n);
				if(start <= next)
				{
					start = next;
					countInc++;
					continue;
				}
				else
				{
					break;
				}
			}
			if(countInc > maxHiCount)
			{
				maxHiCount = countInc;
			}
		}
		return maxHiCount;
	}

	//Main Method
	public static void main(String[] args) throws FileNotFoundException
	{
		//Read the file and initialize the variables
		File inFile = new File("consonant.txt");
		Scanner sc = new Scanner (inFile);
		String line = sc.nextLine();
		int numLines = Integer.parseInt(line);		//Get the number of lines from the first line of file
		int maxLowestCount = 0;
		int maxHighestCount = 0;
		int maxCount = 0;

		//Parse through the file
		for(int i = 0; i < numLines; i++)
		{
			String currLine = sc.nextLine();		//Get next line
			currLine = currLine.toLowerCase();		//Convert to lowercase
			String cnsnt = toConsonant(currLine);		//Get all the consonants from line
			maxLowestCount = maxLowest(cnsnt);		//Get length of max descending string
			maxHighestCount = maxHighest(cnsnt);		//Get length of max ascending string
		
			//Check to see which is the greatest length and assign it to maxCount	
			if(maxLowestCount >= maxHighestCount)
			{
				maxCount = maxLowestCount;
			}
			else
			{
				maxCount = maxHighestCount;
			}

			//Print out the max for the line and reset the max counters;
			System.out.println(maxCount);
			maxLowestCount = 0;
			maxHighestCount = 0;
		}
	}
}	
