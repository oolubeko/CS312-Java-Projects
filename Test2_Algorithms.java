import java.util.Scanner;
import java.io.*;

// find the max element in an array
public static int max(int[] a)
{
	int max = a[0];
	for(int i = 0; i < a.length; i++)
	{
		if(a[i] > max)
		{
			max = a[i];
		}
	}
	return max;
}

//find the min element in an array
public static int min(int[] a)
{
	int min = a[0];
	for(int i = 0; i < a.length; i++)
	{
		if(a[i] < min)
		{
			min = a[i];
		}
	}
	return min;
}

//find the second highest element in an array
public static int secondMax(int[] a)
{
	int max = a[0];
	int secMax = a[0];
	for(int i = 0; i < a.length; i++)
	{
		if(a[i] > max)
		{
			secMax = max;
			max = a[i];
		}
	}
	return secMax;
}

//search for an element in an unsorted array
public static int seqSearch(int[] a,int x)
{
	int idx = -1;
	for(int i = 0; i < a.length; i++)
	{
		if(a[i] == x)
		{
			idx = i;
		}
	}
	return idx;
}

//search for an element in a sorted array
public static int binarySearch(int[] a, int x)
{
	int lo = 0;
	int hi = a.length - 1;
	while(lo <= hi)
	{
		int mid = (lo + hi) / 2;
		if(x < a[mid])
		{
			hi = mid - 1;
		}
		else if(x > a[mid])
		{
			lo = mid + 1;
		}
		else
		{
			return mid;
		}
	}
	return -1;
}

//Sort an unsorted array
public static int[] selectionSort(int[] a)
{
	int len = a.length;
	for(int i = 0; i < len; i++)
	{
		int min = a[i];
		int minIdx = i;
		for(int j = i + 1; j < len; j++)
		{
			if(a[j] < min)
			{
				min = a[j];
				minIdx = j;
			}
		}
		a[minIdx] = a[i];
		a[i] = min;
	}
	return a;
}

//merge two sorted arrays
public static int[] merge(int[] a, int[] b)
{
	int aLen = a.length;
	int bLen = b.length;
	int[] c = new int[aLen + bLen];
	int idxA = 0;
	int idxB = 0;
	int idxC = 0;
	while((idxA < aLen) && (idxB < bLen))
	{
		if(a[idxA] <= b[idxB])
		{
			c[idxC++] = a[idxA++];
		}
		else
		{
			c[idxC++] = b[idxB++];
		}
	}
	while(idxA < aLen)
	{
		c[idxC++] = a[idxA++];
	}
	while(idxB < bLen)
	{
		c[idxC++] = b[idxB++];
	}
	return c;
}

//Add two arrays together
public static int[] addArray(int[] a, int[] b)
{
	int[] c = new int[a.length];
	for(int i = 0; i < a.length; i++)
	{
		c[i] = a[i] + b[i];
	}
	return c;
}

//Multiply corresponding digits in an array together and return the sum
public static int multArray(int[] a, int[] b)
{
	int[] c = new int[a.length];
	int sum = 0;
	for(int i = 0; i < a.length; i++)
	{
		c[i] = a[i] * b[i];
	}
	for(int i = 0; i < c.length; i++)
	{
		sum += c[i];
	}
	return sum;
}

//Determine if two arrays are equal
public static boolean isEqual(int[] a, int[] b)
{
	if(a.length != b.length)
	{
		return false;
	}
	for(int i = 0; i < a.length; i++)
	{
		int aVal = a[i];
		int bVal = b[i];
		if(aVal != bVal)
		{
			return false;
		}
	}
	return true;
}

//Determine if an array is sorted
public static boolean isSorted(int[] a)
{
	boolean isDescending = true;
	boolean isAscending = true;
	for(int i = 0; i < a.length; i++)
	{
		int first = a[i];
		for(int j = i + 1; j < a.length; j++)
		{
			if(a[i] < a[j])
			{
				isDescending = false;
			}
		}
	}
	for(int i = 0; i < a.length; i++)
	{
		int first = a[i];
		for(int j = i + 1; j < a.length; j++)
		{
			if(a[i] > a[j])
			{
				isAscending = false;
			}
		}
	}
	return (isAscending || isDescending);
}

//return an array that has the cumulative sum of another array
public static int[] cumSum(int[] a)
{
	int len = a.length;
	int cumSum = 0;
	int[] sum = new int[len];
	for(int i = 0; i < len; i++)
	{
		cumSum += a[i];
		sum[i] = cumSum;
	}
	return sum;
}

//reverse the elements of an array in place
public static void rev(int[] a)
{
	int len = a.length;
	int[] c = new int[len];
	for(int i = 0; i < len; i++)
	{
		c[i] = a[len - i - 1];
	}
	for(int i = 0; i < len; i++)
	{
		a[i] = c[i];
	}
}

//remove duplicate elements in an array
public static int[] remDup(int[] a)
{
	int len = a.length;
	
}