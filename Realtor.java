/*
  File: Realtor.java

  Description: Create and maintain a list of houses that are for sale in Austin area

  Student Name: Tomi Olubeko

  Student UT EID: oeo227

  Partner's Name:

  Partner's UT EID:

  Course Name: CS 312

  Unique Number: 87525

  Date Created: 8/9/16

  Date Last Modified: 8/10/16

*/

import java.util.*;
import java.io.*;

class Address
{
	// List of attributes
	public String street;	// House number and street name
	public String town;		// Name of town or city
	public String state;	// Two letter abbreviation of state
	public String zip;		// Five digit zip code
	
	// Default constructor
	public Address()
	{
		this.street = "123 Speedway";
		this.town = "Austin";
		this.state = "TX";
		this.zip = "78705";
	}
	
	// Non-default constructor
	public Address(String street, String town, String state, String zip)
	{
		this.street = street;
		this.town = town;
		this.state = state;
		this.zip = zip;
	}
	
	// To-string method
	public String toString()
	{
		String s = this.street + ", " + this.town + ", " + this.state + ", " + this.zip;
		return s;
	}
	
	
}


class House
{
	// List of attributes
	public Address address;
	public int area;		// Area in square feet
	public int bedRooms;	// Number of bedrooms
	public int bathRooms;	// Number of bathrooms
	public int garage;		// Number of cars in garage
	public double price;	// List(asking) price in dollars
	
	// Default constructor
	public House()
	{
		this.address = new Address();
		this.area = 0;
		this.bedRooms = 0;
		this.bathRooms = 0;
		this.garage = 0;
		this.price = 0.0;
	}
	
	// Non-default constructor
	public House(Address address, int area, int bedRooms, int bathRooms, int garage, double price)
	{
		this.address = address;
		this.area = area;
		this.bedRooms = bedRooms;
		this.bathRooms = bathRooms;
		this.garage = garage;
		this.price = price;
	}
	
	// To-string method
	public String toString()
	{
		String s = "Address: " + address.toString() + ". Area: " + this.area + ". Bedrooms: " + this.bedRooms + ". Bathrooms: " + this.bathRooms + ". Garage: " + this.garage + ". Price: " + this.price;
		return s;
	}
}

class HouseList
{
	// List attributes
	private House[] houseList;		// Array of Houses
	private int numHouses;			// Number of houses on the list
	
	// Default Constructor
	public HouseList()
	{
		this.houseList = new House[100];
		this.numHouses = 0;
	}
	
	// Non-default constructor
	public HouseList(int n)
	{
		this.houseList = new House[n];
		this.numHouses = 0;
	}
	
	// Method to get the number of houses in list
	public int getNumHouses()
	{
		return this.numHouses;
	}
	
	// Method to add a House to the list
	public void addHouse(House house)
	{
		if(this.numHouses != houseList.length)
		{
			for(int i = 0; i < houseList.length; i++)
			{
				if(!(houseList[i] instanceof House))
				{
					houseList[i] = house;
					this.numHouses += 1;
					break;
				}
			}
		}
	}
	
	// Method to search the HouseList by zipcode
	public void searchByZip(String zip)
	{
		int count = 0;
		for(int i = 0; i < numHouses; i++)
		{
			String z = this.houseList[i].address.zip;
			if(z.equals(zip))
			{
				System.out.println(this.houseList[i].address.toString());
			}
			else
			{
				count++;
			}
		}
		if(count == 10)
		{
			System.out.println("Sorry, we do not have any houses with that zipcode in our database");
		}
	}
	
	// Method to search the HouseList by price
	public void searchByPrice(double lowPrice, double highPrice)
	{
		int count = 0;
		for(int i = 0; i < numHouses; i++)
		{
			double p = this.houseList[i].price;
			if((p >= lowPrice) && (p <= highPrice))
			{
				System.out.println(this.houseList[i].address.toString());
			}
			else
			{
				count++;
			}
		}
		if(count == 10)
		{
			System.out.println("Sorry, there are no houses in that price range on our database");
		}
	}
	
	// Method to search the HouseList by Area
	public void searchByArea(int lowArea, int highArea)
	{
		int count = 0;
		for(int i = 0; i < numHouses; i++)
		{
			int a = this.houseList[i].area;
			if((a >= lowArea) && (a <= highArea))
			{
				System.out.println(this.houseList[i].address.toString());
			}
			else
			{
				count++;
			}
		}
		if(count == 10)
		{
			System.out.println("Sorry there are no houses of that size range in our database");
		}
	}
	
	// Method to search the HouseList by num rooms
	public void searchByRooms(int rooms)
	{
		int count = 0;
		for(int i = 0; i < numHouses; i++)
		{
			int r = this.houseList[i].bedRooms;
			if(r == rooms)
			{
				System.out.println(this.houseList[i].address.toString());
			}
			else
			{
				count++;
			}
		}
		if(count == 10)
		{
			System.out.println("Sorry, there are no houses with that many rooms in our database");
		}
	}
}


public class Realtor
{
  public static void main ( String[] args ) throws IOException
  {
    // Create a HouseList object that can hold a hundred houses
    HouseList houseList = new HouseList();

    // Populate the array with 10 houses with data from realtor.txt
	File inFile = new File("realtor.txt");
	Scanner sc = new Scanner(inFile);
	Scanner input = new Scanner(System.in);
    // Create an Address object for each house

    // Create a House object for each house and add the Address object

    // Add the House object to the HouseList
    for(int i = 0; i < 9; i++)
	{
		String street = sc.nextLine();
		String town = sc.nextLine();
		String state = sc.nextLine();
		String zip = sc.nextLine();
		Address address = new Address(street, town, state, zip);
		//sc.nextLine();
		int area = sc.nextInt();
		//sc.nextLine();
		int bedRooms = sc.nextInt();
		//sc.nextLine();
		int bathRooms = sc.nextInt();
		//sc.nextLine();
		int garage = sc.nextInt();
		//sc.nextLine();
		double price = sc.nextDouble();
		sc.nextLine();
		sc.nextLine();
		House house = new House(address, area, bedRooms, bathRooms, garage, price);
		houseList.addHouse(house);
	}
	String street = sc.nextLine();
	String town = sc.nextLine();
	String state = sc.nextLine();
	String zip = sc.nextLine();
	Address address = new Address(street, town, state, zip);
	//sc.nextLine();
	int area = sc.nextInt();
	//sc.nextLine();
	int bedRooms = sc.nextInt();
	//sc.nextLine();
	int bathRooms = sc.nextInt();
	//sc.nextLine();
	int garage = sc.nextInt();
	//sc.nextLine();
	double price = sc.nextDouble();
	House house = new House(address, area, bedRooms, bathRooms, garage, price);
	houseList.addHouse(house);
	sc.close();

    // Write out the number of houses in your list
    int numHouses = houseList.getNumHouses();
	System.out.println("There are " + numHouses + " houses in our database");
	System.out.println();

    // Write out the houses in a certain zip code
	System.out.print("Enter a valid 5 digit zipcode: ");
	int userZip = input.nextInt();
	String uZip = Integer.toString(userZip);
	while((uZip.length() != 5) || (userZip < 10000))
	{
		System.out.print("Invalid zipcode. Enter a valid 5-digit zipcode: ");
		userZip = input.nextInt();
		uZip = Integer.toString(userZip);
	}
	System.out.println("Here are the houses in our database with zipcode " + uZip + ":");
    houseList.searchByZip(uZip);
	System.out.println();

    // Write out the houses in a certain price range
	System.out.print("Enter the low price: ");
	double low = input.nextDouble();
	System.out.print("Enter the high price: ");
	double high = input.nextDouble();
	while(low > high)
	{
		System.out.println("Invalid format. Reenter numbers:");
		System.out.print("Enter the low price: ");
		low = input.nextDouble();
		System.out.print("Enter the high price: ");
		high = input.nextDouble();
	}
	System.out.println("Here are the houses in our database that cost between $" + low + " and $" + high + ":");
    houseList.searchByPrice(low, high);
	System.out.println();
	
    // Write out the houses in a certain square foot range
	System.out.print("Enter the minimum square feet: ");
	int lowSF = input.nextInt();
	System.out.print("Enter the maximum square feet: ");
	int highSF = input.nextInt();
	while(lowSF > highSF)
	{
		System.out.println("Invalid format. Reenter numbers:");
		System.out.print("Enter the minimum square feet: ");
		lowSF = input.nextInt();
		System.out.print("Enter the maximum square feet: ");
		highSF = input.nextInt();
	}
	System.out.println("Here are the houses in our database that have between " + lowSF + " and " + highSF + " square feet:");
    houseList.searchByArea(lowSF, highSF);
	System.out.println();
	
    // Write out the houses that have a certain number of bedrooms
	System.out.print("Enter the number of bedrooms: ");
	int userBR = input.nextInt();
	while(userBR < 0)
	{
		System.out.println("Invalid format. Reenter number: ");
		System.out.print("Enter the number of bedrooms: ");
		userBR = input.nextInt();
	}
	System.out.println("Here are the houses in our database with " + userBR + " bedrooms:");
    houseList.searchByRooms(userBR);

  }
}