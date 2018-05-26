/*
	Final Exam Review CS 312
	
	Name: Tomi Olubeko
	
	UTEID: oeo227
	
*/

import java.util.*;
import java.io.*;

abstract class Shape
{
	//List attributes
	public String color;
	public double xPos;
	public double yPos;
	public boolean filled;
	
	//Methods
	public abstract double getArea();
}

class Rectangle extends shape
{
	//List attributes
	double length;
	double width;
	
	//Constructors
	public Rectangle()
	{
		this.length = 1;
		this.width = 1;
		this.color = "green";
		this.filled = true;
	}
	public Rectangle(double length, double width, String color, boolean filled)
	{
		this.length = length;
		this.width = width;
		this.color = color;
		this.filled = filled;
	}
	
	//Methods
	public double getLength()
	{
		return this.length;
	}
	public double getWidth()
	{
		return this.width;
	}
	public double getArea()
	{
		return this.length * this.width;
	}
	public double getPerimeter()
	{
		return 2 * this.length + 2 * this.width;
	}
	public void setFill(boolean isFilled)
	{
		this.filled = isFilled;
	}
	public void setColor(String color)
	{
		this.color = color;
	}
	public void setLength(double len)
	{
		this.length = len;
	}
	public void setWidth(double wid)
	{
		this.width = wid;
	}
	public String getColor()
	{
		return this.color;
	}
	public boolean getFilled()
	{
		return this.filled;
	}

}

public class TestReview
{
	//return the maximum element in an array
	public int max(int[] a)
	{
		int len = a.length;
		if(len == 0)
		{
			return 0;
		}
		int max = a[0];
		for(int i = 0; i < len; i++)
		{
			if(a[i] > max)
			{
				max = a[i];
			}
			
		}
		return max;
	}
	
	//return the minimum element in an array
	public int min(int[] a)
	{
		int len = a.length;
		if(len == 0)
		{
			return 0;
		}
		int min = a[0];
		for(int i = 0; i < len; i++)
		{
			if(a[i] < min)
			{
				min = a[i];
			}
		}
		return min;
	}
	
	//return the second highest element in an array
	public int secondMax(int[] a)
	{
		int len = a.length;
		if(len == 0)
		{
			return 0;
		}
		int max = a[0];
		int sMax = a[0];
		for(int i = 0; i < len; i++)
		{
			if(a[i] > max)
			{
				sMax = max;
				max = a[i];
			}
		}
		return sMax;
	}
	
	int[] a = [9,6,,4,2,1];
	//Selection Sorting algorithm
	public void SeclectionSort(int[] a)
	{
		for(int i = 0; i < a.length - 1; i++)
		{
			int isMin = a[i];
			for(int j = i + 1; j < a.length; j++)
			{
				if(a[j] < isMin)
				{
					a[i] = a[j];
					a[j] = isMin;
					isMin = a[i];
				}
			}
		}
	}
	
	//search for an element in an unsorted array
	public int seqSearch(int[] a, int x)
	{
		int len = a.length;
		if(len == 0)
		{
			return -1;
		}
		for(int i = 0; i < len; i++)
		{
			int isX = a[i];
			if(isX == x)
			{
				return i;
			}
		}
		return -1;
	}
	
	//search for an element in a sorted array
	public int binarySearch(int[] a, int x)
	{
		int low = 0;
		int hi = a.length - 1;
		while(low <= hi)
		{
			int mid = (low + hi) / 2;
			if(a[mid] < x)
			{
				low = mid + 1;
			}
			else if(a[mid] > x)
			{
				hi = mid - 1;
			}
			else
			{
				return mid;
			}
		}
		return -1;
	}
	
	//Merge two sorted arrays
	public int[] merge(int[] a, int[] b)
	{
		int[] c = new int[a.length + b.length];
		int idxA = 0;
		int idxB = 0;
		int idxC = 0;
		while((idxA < a.length) && (idxB < b.length))
		{
			if(a[idxA] < b[idxB])
			{
				c[idxC++] = a[idxA++];
			}
			else
			{
				c[idxC++] = b[idxB++];
			}
		}
		while(idxA < a.length)
		{
			c[idxC++] = a[idxA++];
		}
		while(idxB < b.length)
		{
			c[idxC++] = b[idxB++];
		}
		return c;		
	}
	
	//Add two arrays together
	public int[] addArrays(int[] a, int[] b)
	{
		int[] c = new int[a.length];
		for(int i = 0; i < c.length; i++)
		{
			int sum = a[i] + b[i];
			c[i] = sum;
		}
		return c;
	}
	
	//Multiply corresponding elements in two arrays and return the sum
	
}