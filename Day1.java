/*
  File: Day.java

  Description: computes the day of the week when given date

  Student Name: Griffin Hanson

  Student UT EID: grh589

  Course Name: CS 312

  Unique Number: 

  Date Created: 20 Jun 2016

  Date Last Modified: 22 Jun 2016

*/

import java.util.*;

public class Day1
{

	public static void main (String[] args)
	{
		Scanner sc = new Scanner (System.in);
		Calendar today = new GregorianCalendar();
		
		int year = 0;
		int month = 0;
		int day = 0;
		int a = 0;
		int currentDay = today.get(Calendar.DAY_OF_MONTH);
		int currentMonth = today.get(Calendar.MONTH);
		int currentYear = today.get(Calendar.YEAR);
		
		do
		{
			System.out.print ("Enter year: ");
			year = sc.nextInt();
		} while (year < 1900 || year > 2100);
			
		do
		{
			System.out.print ("Enter month: ");
			month = sc.nextInt();
		} while (month < 1 || month > 12);
		
		if (month == 2)
		{
			if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0))
			{
				do
				{
					System.out.print ("Enter day: ");
					day = sc.nextInt();
				} while (day < 1 || day > 29);
			}
			else
			{
				do
				{
					System.out.print ("Enter day: ");
					day = sc.nextInt();
				} while (day < 1 || day > 28);
			}
		}
		else if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12)
		{
			do
			{
				System.out.print ("Enter day: ");
				day = sc.nextInt();
			} while (day < 1 || day > 31);
		}
		else
		{	
			do
			{
				System.out.print ("Enter day: ");
				day = sc.nextInt();
			} while (day < 1 || day > 30);
		}
		
		if (month < 3)
		{
			a = month + 10;
		}
		else
		{
			a = month - 2;
		}
		
		if (month == 1 || month == 2)
		{
			year = year - 1;
		}
		
		int b = day;
		int c = year % 100;
		int d = year / 100;
		
		int w = (13 * a - 1 ) / 5;
		int x = c / 4;
		int y = d / 4;
		int z = w + x + y + b + c - 2 * d;
		int r = z % 7;
		r = (r + 7) % 7;
		
		if (currentYear > year ^ (currentYear == year && currentMonth > month) ^ (currentYear == year && currentMonth == month && currentDay > day))
		{
		switch (r)
			{
				case 0: System.out.println ("\nThe day was Sunday."); break;
				case 1: System.out.println ("\nThe day was Monday."); break;
				case 2: System.out.println ("\nThe day was Tuesday."); break;
				case 3: System.out.println ("\nThe day was Wednesday."); break;
				case 4: System.out.println ("\nThe day was Thursday."); break;
				case 5: System.out.println ("\nThe day was Friday."); break;
				case 6: System.out.println ("\nThe day was Saturday."); break;
				default: System.out.println ("\nThe date is out of range."); break;			
			}		
		}
		
		if (currentYear == year && currentMonth == month && currentDay == day)
		{
			switch (r)
			{
				case 0: System.out.println ("\nThe day is Sunday."); break;
				case 1: System.out.println ("\nThe day is Monday."); break;
				case 2: System.out.println ("\nThe day is Tuesday."); break;
				case 3: System.out.println ("\nThe day is Wednesday."); break;
				case 4: System.out.println ("\nThe day is Thursday."); break;
				case 5: System.out.println ("\nThe day is Friday."); break;
				case 6: System.out.println ("\nThe day is Saturday."); break;
				default: System.out.println ("\nThe date is out of range."); break;			
			}
		}
		
		if (currentYear < year ^ (currentYear == year && currentMonth < month) ^ (currentYear == year && currentMonth == month && currentDay < day))
		{
			switch (r)
			{
				case 0: System.out.println ("\nThe day will be Sunday."); break;
				case 1: System.out.println ("\nThe day will be Monday."); break;
				case 2: System.out.println ("\nThe day will be Tuesday."); break;
				case 3: System.out.println ("\nThe day will be Wednesday."); break;
				case 4: System.out.println ("\nThe day will be Thursday."); break;
				case 5: System.out.println ("\nThe day will be Friday."); break;
				case 6: System.out.println ("\nThe day will be Saturday."); break;
				default: System.out.println ("\nThe date is out of range."); break;			
			}	
		}
	}
}


