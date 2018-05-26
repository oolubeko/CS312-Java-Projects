/*
  File: Day.java

  Description: Prompts the user to enter the year, month, and day, then prints out the day of the week

  Student Name: Tomi Olubeko

  Student UT EID: oeo227

  Course Name: CS 312

  Unique Number: 87525

  Date Created: 6/19/16

  Date Last Modified: June 19 2016

*/
import java.util.*;

public class Day
{
	public static void main(String[] args)
	{
		// Declare the variables
		Calendar today = new GregorianCalendar();
		Scanner input = new Scanner(System.in);
		int year;
		int month;
		int day = 0;
		
		//Prompt the user for a year between 1900 and 2100
		do
		{
			System.out.print("Enter year: ");
			year = input.nextInt();
			System.out.println("");
		}	
		while((year < 1900) || (year > 2100));
		
		
		// Prompt the user for a month(number between 1 and 12)
		do
		{
			System.out.print("Enter month: ");
			month = input.nextInt();
			System.out.println("");
		}
		while((month < 1) ||(month > 12));

		//Prompt the user for a day and check if its valid for the month and year
		
		//Edge case for February on a leap year
		if((year % 4 == 0) && (year % 100 != 0) && (month == 2))
		{
			do
			{
				System.out.print("Enter day: ");
				day = input.nextInt();
				System.out.println("");
			}
			while((day < 1) || (day > 29));
		}
		
		//Edge case for February of year 2000
		else if((year == 2000) && (month == 2))
		{
			do
			{
				System.out.print("Enter day: ");
				day = input.nextInt();
				System.out.println("");
			}
			while((day < 1) || (day > 29));
		}
		
		//Case for February on a regular year
		else if(month == 2)
		{
			do
			{
				System.out.print("Enter day: ");
				day = input.nextInt();
				System.out.println("");
			}
			while((day < 1) || (day > 28));
		}
		
		//Case for months with 31 days
		else if((month == 1) || (month == 3) || (month == 5) || (month == 7) || (month == 8) || (month == 10) || (month == 12))
		{
			do
			{
				System.out.print("Enter day: ");
				day = input.nextInt();
				System.out.println("");
			}
			while((day < 1) || (day > 31));
		}
		
		//Case for months with 30 days
		else if((month == 4) || (month == 6) || (month == 9) || (month == 11))
		{
			do
			{
				System.out.print("Enter day: ");
				day = input.nextInt();
				System.out.println("");
			}
			while((day < 1) || (day > 30));
		}
		
		//Convert the user input to algorithm form
		int a;
		int b;
		int c = 0;
		int d = 0;
		
		a = month + 10; 
		if(a > 12)
		{
			a -= 12;
		}
		
		b = day;
		
		int adjustedYear = year - 1;
		if(a > 10)
		{
			c = adjustedYear % 1000;
			c = c % 100;
		}
		else if(a < 11)
		{
			c = year % 1000;
			c = c % 100;
		}
		
		if(a < 11)
		{
			d = year / 100;
		}
		else if(a > 10)
		{
			d = adjustedYear / 100;
		}
		
		//Apply Zeller's Algorithm
		int w;
		int x;
		int y;
		int z;
		int r;
		
		w = (13 * a - 1) / 5;
		x = c / 4;
		y = d / 4;
		z = w + x + y + b + c - 2 * d;
		r = z % 7;
		r = (r + 7) % 7;
		
		//Get the current time
		int week = today.get(Calendar.DAY_OF_MONTH);
		int currentMonth = today.get(Calendar.MONTH);
		int currentYear = today.get(Calendar.YEAR);
		
		//Calibration for calendar months vs user inputted months
		currentMonth++;
		
		//Cases for each day
		if(r == 0)
		{
			if(year < currentYear)
			{
				System.out.println("The day was Sunday");
			}
			else if(year == currentYear)
			{
				if(month < currentMonth)
				{
					System.out.println("The day was Sunday");
				}
				else if(month == currentMonth)
				{
					if(day < week)
					{
						System.out.println("The day was Sunday");
					}
					else if(day == week)
					{
						System.out.println("The day is Sunday");
					}
					else if(day > week)
					{
						System.out.println("The day will be Sunday");
					}
				}
				else if(month > currentMonth)
				{
					System.out.println("The day will be Sunday");
				}
			}
			else
			{
				System.out.println("The day will be Sunday");
			}
		}
		
		if(r == 1)
		{
			if(year < currentYear)
			{
				System.out.println("The day was Monday");
			}
			else if(year == currentYear)
			{
				if(month < currentMonth)
				{
					System.out.println("The day was Monday");
				}
				else if(month == currentMonth)
				{
					if(day < week)
					{
						System.out.println("The day was Monday");
					}
					else if(day == week)
					{
						System.out.println("The day is Monday");
					}
					else if(day > week)
					{
						System.out.println("The day will be Monday");
					}
				}
				else if(month > currentMonth)
				{
					System.out.println("The day will be Monday");
				}
			}
			else
			{
				System.out.println("The day will be Monday");
			}
		}
		
		if(r == 2)
		{
			if(year < currentYear)
			{
				System.out.println("The day was Tuesday");
			}
			else if(year == currentYear)
			{
				if(month < currentMonth)
				{
					System.out.println("The day was Tuesday");
				}
				else if(month == currentMonth)
				{
					if(day < week)
					{
						System.out.println("The day was Tueday");
					}
					else if(day == week)
					{
						System.out.println("The day is Tuesday");
					}
					else if(day > week)
					{
						System.out.println("The day will be Tuesday");
					}
				}
				else if(month > currentMonth)
				{
					System.out.println("The day will be Tuesday");
				}
			}
			else
			{
				System.out.println("The day will be Tuesday");
			}
		}
		
		if(r == 3)
		{
			if(year < currentYear)
			{
				System.out.println("The day was Wednesday");
			}
			else if(year == currentYear)
			{
				if(month < currentMonth)
				{
					System.out.println("The day was Wednesday");
				}
				else if(month == currentMonth)
				{
					if(day < week)
					{
						System.out.println("The day was Wednesday");
					}
					else if(day == week)
					{
						System.out.println("The day is Wednesday");
					}
					else if(day > week)
					{
						System.out.println("The day will be Wednesday");
					}
				}
				else if(month > currentMonth)
				{
					System.out.println("The day will be Wednesday");
				}
			}
			else
			{
				System.out.println("The day will be Wednesday");
			}
		}
		
		if(r == 4)
		{
			if(year < currentYear)
			{
				System.out.println("The day was Thursday");
			}
			else if(year == currentYear)
			{
				if(month < currentMonth)
				{
					System.out.println("The day was Thursday");
				}
				else if(month == currentMonth)
				{
					if(day < week)
					{
						System.out.println("The day was Thursday");
					}
					else if(day == week)
					{
						System.out.println("The day is Thursday");
					}
					else if(day > week)
					{
						System.out.println("The day will be Thursday");
					}
				}
				else if(month > currentMonth)
				{
					System.out.println("The day will be Thursday");
				}
			}
			else
			{
				System.out.println("The day will be Thursday");
			}
		}
		
		if(r == 5)
		{
			if(year < currentYear)
			{
				System.out.println("The day was Friday");
			}
			else if(year == currentYear)
			{
				if(month < currentMonth)
				{
					System.out.println("The day was Friday");
				}
				else if(month == currentMonth)
				{
					if(day < week)
					{
						System.out.println("The day was Friday");
					}
					else if(day == week)
					{
						System.out.println("The day is Friday");
					}
					else if(day > week)
					{
						System.out.println("The day will be Friday");
					}
				}
				else if(month > currentMonth)
				{
					System.out.println("The day will be Friday");
				}
			}
			else
			{
				System.out.println("The day will be Friday");
			}
		}
		
		if(r == 6)
		{
			if(year < currentYear)
			{
				System.out.println("The day was Saturday");
			}
			else if(year == currentYear)
			{
				if(month < currentMonth)
				{
					System.out.println("The day was Saturday");
				}
				else if(month == currentMonth)
				{
					if(day < week)
					{
						System.out.println("The day was Saturday");
					}
					else if(day == week)
					{
						System.out.println("The day is Saturday");
					}
					else if(day > week)
					{
						System.out.println("The day will be Saturday");
					}
				}
				else if(month > currentMonth)
				{
					System.out.println("The day will be Saturday");
				}
			}
			else
			{
				System.out.println("The day will be Saturday");
			}
		}
	}
}