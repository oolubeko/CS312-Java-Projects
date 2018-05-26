/*
  File: CreditCard.java

  Description: Prompt the user for a 15 or 16 digit number and check to see if it is a valid Credit Card number

  Student Name: Tomi Olubeko

  Student UT EID: oeo227

  Course Name: CS 312

  Unique Number: 87525

  Date Created: 7/26/16

  Date Last Modified: 7/27/16

*/

import java.util.Scanner;

public class CreditCard
{
	//This method returns the number of digits a value has
	public static int numDigits(long num)
	{
		int count = 0;
		while(num > 0)
		{
			count++;
			num /= 10;
		}
		return count;
	}
	
	//This method sums the digits in a number
	public static int sumDigits(int n)
	{
		int sum = 0;
		while(n > 0)
		{
			sum += (n % 10);
			n /= 10;
		}
		return sum;
	}
	
	//This method puts all the digits in the number in an array
	public static int[] toArray(long num)
	{
		int[] cNum = new int[numDigits(num)];
		int len = cNum.length;
		for(int i = len - 1; i >= 0; i--)
		{
			cNum[i] = (int) (num % 10);
			num /= 10;
		}
		return cNum;
	}
	
	//This method checks if a credit card number is valid
	public static boolean is_valid(long cc_num) 
	{
		int[] cNum = toArray(cc_num);
		int len = cNum.length;
		int sum = 0;
		if(len == 15)
		{
			for(int i = len - 2; i > 0; i -= 2)
			{
				cNum[i] *= 2;
				cNum[i] = sumDigits(cNum[i]);
			}
		}
		else
		{
			for(int i = 0; i < len; i += 2)
			{
				cNum[i] *= 2;
				cNum[i] = sumDigits(cNum[i]);
			}
		}	
		for(int i = 0; i < len; i++)
		{
			sum += cNum[i];
		}
		//System.out.println(sum);
		return((sum % 10) == 0);
	}
	
	//This method returns the type of credit card 
	public static String cc_type(long cc_num)
	{
		String type = "";
		int[] cNum = toArray(cc_num);
		if(cNum[0] == 4)
		{
			type += "Visa";
		}
		else if(cNum[0] == 5)
		{
			int num2 = cNum[1];
			if((num2 >= 0) && (num2 <= 5))
			{
				type += "MasterCard";
			}
		}
		else if(cNum[0] == 6)
		{
			int num2 = cNum[1];
			int num3 = cNum[2];
			int num4 = cNum[4];
			if((num2 == 0) && (num3 == 1) && (num4 == 1))
			{
				type += "Discover";
			}
			else if((num2 == 4) && (num3 == 4))
			{
				type += "Discover";
			}
			else if(num2 == 5)
			{
				type += "Discover";
			}
		}
		else if(cNum[0] == 3)
		{
			int num2 = cNum[1];
			if((num2 == 4) || (num2 == 7))
			{
				type += "American Express";
			}
		}
		return type;
	}
	
	public static void main(String[] args)
	{
		System.out.print("Enter 15 or 16-digit credit card number: ");
		Scanner sc = new Scanner(System.in);
		long cc_num = sc.nextLong();
		//String type = new String("");
		if((numDigits(cc_num) < 15) || (numDigits(cc_num) > 16))
		{
			System.out.println("Not a 15 or 16-digit number");
			return;
		}
		if(is_valid(cc_num))
		{
			String type = cc_type(cc_num);
			System.out.println("Valid " + type + " credit card number");
		}
		else
		{
			System.out.println("Invalid credit card number");
			return;
		}
	}
}