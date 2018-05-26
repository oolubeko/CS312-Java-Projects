/*
  File: Grid.java

  Description: Read an input from grid.txt and output the largest product of 4 numbers

  Student Name: Griffin Hanson

  Student UT EID: grh589

  Partner Name: Tomi Olubeko

  Partner UT EID: oeo227

  Course Name: CS 312

  Unique Number: 87525

  Date Created: 8/3/16

  Date Last Modified:8/3/16

*/

import java.util.*;
import java.io.*;

public class Grid
{
    public static void main(String[] args) throws IOException
    {
		
		//Initialize the variables to go through the input file
        File inFile = new File("grid.txt");
        Scanner sc = new Scanner(inFile);
		
		//Get the dimensions from the first line of the file
        int dimension = sc.nextInt();
		
		//Create a  2d-array to store the grid and put all the values inside it
        int grid[][] = new int[dimension][dimension];
        for (int i = 0; i < dimension; i++)
        {
            for (int j = 0; j < dimension; j++)
            {
                grid[i][j] = sc.nextInt();
            }
        }
		
		//Create and initialize variables to hold products
        long maxProd = 0;
        long vertical;
        long horizontal;
        long diag1;
        long diag2;
		
		//Parse through the 2-d array and calculate products vertically, horizontally, and diagonally
        for (int i = 0; i < dimension; i++)
        {
            for (int j = 0; j < dimension; j++)
            {
                vertical = 0;
                horizontal = 0;
                diag1 = 0;
                diag2 = 0;
                if (i < (dimension - 3))
                {
                    vertical = (grid[i][j] * grid[i+1][j] * grid[i+2][j] * grid[i+3][j]);
                    if (j > 2)
                        diag1 = (grid[i][j] * grid[i+1][j-1] * grid[i+2][j-2] * grid[i+3][j-3]);
                    if (j < (dimension - 3))
                        diag2 = (grid[i][j] * grid[i+1][j+1] * grid[i+2][j+2] * grid[i+3][j+3]);
                }
                if (j < (dimension - 3))
                    horizontal = (grid[i][j] * grid[i][j+1] * grid[i][j+2] * grid[i][j+3]);
                if (vertical > maxProd)
                    maxProd = vertical;
                if (diag1 > maxProd)
                    maxProd = diag1;
                if (diag2 > maxProd)
                    maxProd = diag2;
                if (horizontal > maxProd)
                    maxProd = horizontal;
            }
        }
        System.out.println("The greatest product is " + maxProd + ".");
    }
}