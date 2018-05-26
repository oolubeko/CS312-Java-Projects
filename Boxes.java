/*
  File: Boxes.java

  Description: Given a set of boxes, return the largest subset of boxes that nest inside each other

  Student Name: Tomi Olubeko

  Student UT EID: oeo227

  Course Name: CS 312

  Unique Number: 87525

  Date Created: 7/30/16

  Date Last Modified: 8/1/16
*/

import java.util.*;
import java.io.*;

public class Boxes
{	
	static int maxSub = 0;
	/*public static int findMax(List<int[]> arr)
	{
		int maxSub = 1;
		int[] a = arr.get(0);
		int l = a[0];
		int w = a[1];
		int h = a[2];
		for(int i = 1; i < arr.size(); i++)
		{
			int [] b = arr.get(i);
			int l1 = b[0];
			int w1 = b[1];
			int h1 = b[2];
			if((l < l1) && (w < w1) && (h < h1))
			{
				maxSub += 1;
				l = l1;
				w = w1;
				h = h1;
				System.out.println(l + " " + w + " " + h);
			}
		}
		return maxSub;
	}*/
	
	public static void printArray (int[] a)
	{
		for (int i = 0; i < a.length; i++)
		{
			if (a[i] != -1)
			{
				System.out.print (a[i] + " ");
			}
		}
		System.out.println ();
	}

	public static int[] copy (int[] b)
	{
		int[] c = new int [b.length];
		for (int i = 0; i < b.length; i++)
		{
			c[i] = b[i];
		}
		return c;
	}
	
	public static void subsets (int[] a, int[] b, int index)
	{
		if (index == a.length)
		{
			maxSub++;;
		}
		else
		{
			int[] c = copy (b);
			b[index] = a[index];
			subsets (a, b, index + 1);
			subsets (a, c, index + 1);
		}
	}
	
	public static void main(String[] args) throws IOException
	{
		File inFile = new File("boxes.txt");
		Scanner sc = new Scanner(inFile);
		int numBoxes = sc.nextInt();
		List<int[]> dim = new ArrayList<int[]>();
		for(int i = 0; i < numBoxes; i++)
		{
			int[] numbers = new int[3];
			numbers[0] = sc.nextInt();
			numbers[1] = sc.nextInt();
			numbers[2] = sc.nextInt();
			Arrays.sort(numbers);
			dim.add(numbers);
		}
		sc.close();
		Collections.sort(dim, new Comparator<int[]>()
		{
			public int compare(int[] a, int[] b)
			{
				if(a[0] < b[0])
				{
					return -1;
				}
				else if(a[0] == b[0])
				{
					return 0;
				}
				return 1;
			}
		});
		/*for(int i = 0; i < dim.size(); i++)
		{
			int tmp = maxSub;
			int[] a = dim.get(i);
			int[] b = dim.get(i + 1);
			//subsets(a , b , 0);
			//if(maxSub > tmp)
		}*/
	}
}