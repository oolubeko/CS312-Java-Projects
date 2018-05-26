/*
  File: EasterSunday.java

  Description: Given a year, calculate the month and day of Easter using Gauss's algorithm 

  Student Name: Tomi Olubeko

  Student UT EID: oeo227

  Course Name: CS 312

  Unique Number: 87525

  Date Created: 6/12/16

  Date Last Modified: June 12 2016

*/


import java.util.Scanner;

public class EasterSunday 
{
	public static void main(String[] args) 
	{
		//Declare the variables
		Scanner input = new Scanner(System.in);
		int y;
		int a;
		int b;
		int c;
		int d;
		int e;
		int g;
		int h;
		int j;
		int k;
		int m;
		int r;
		int n;
		int p;
		
		
		// Prompt the user for a year
		System.out.print("Enter year: ");
		
		// Store the user input in y
		y = input.nextInt();
		
		// Use Gauss's Algorithm
		a = y % 19;					
		b = y / 100;				
		c = y % 100;
		d = b / 4;
		e = b % 4;
		g = (8 * b + 13) / 25;
		h = (19 * a + b - d - g + 15) % 30;
		j = c / 4;
		k = c % 4;
		m = (a + 11 * h) / 319;
		r = (2 * e + 2 * j - k - h + m + 32) % 7;
		n = (h - m + r + 90) / 25;
		p = (h - m + r + n + 19) % 32;
		
		//Output the result
		if (n == 3) 
		{
			System.out.println("In " + y + ", Easter Sunday is on " + p + " March.");
		}
		else 
		{
			System.out.println("In " + y + ", Easter Sunday is on " + p + " April.");
		}
	}
}	