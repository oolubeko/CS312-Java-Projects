/*
  File: Geometry.java

  Description: Develop a Point Class, Circle Class, and Rectangle class, as well as a test class to test methods

  Student Name: Tomi Olubeko

  Student UT EID: oeo227

  Course Name: CS 312

  Unique Numbers: 87525

  Date Created: 8/5/16

  Date Last Modified: 8/6/16

*/

import java.util.*;
import java.io.*;

class Point
{
  // list of attributes - x and y coordinates
  private double x;
  private double y;

  // default constructor
  public Point ()
  {
	this.x = 0.0;
	this.y = 0.0;
  }

  // non-default constructor
  public Point (double x, double y)
  {
	this.x = x;
	this.y = y;
  }

  // accessors get the x and y coordinates
  public double getX ()
  {
	return this.x;
  }
  public double getY ()
  {
	return this.y;
  }

  // mutators set the x and y coordinates
  public void setX (double x)
  {
	this.x = x;
  }
  public void setY (double y)
  {
	this.y = y;
  }

  // distance to another point
  public double distance (Point p)
  {
	return(Math.sqrt(Math.pow((this.x - p.x) , 2) + Math.pow((this.y - p.y) , 2)));
  }

  // string representation of a point, i.e. x and y coordinates
  public String toString ()
  {
	String s = "(" + this.x + ", " + this.y + ")";
	return s;
  }

  // test for equality of two points
  public boolean equals (Point p)
  {
	double delta = 1.0 * Math.pow(10 , -18);
	return ((Math.abs(this.x - p.x) < delta) && (Math.abs(this.y - p.y) < delta));
  }
}

class Circle
{
  // list of attributes
  private double radius;
  private Point center;

  // default constructor (radius = 1.0 and center at the origin)
  public Circle ()
  {
	this.radius = 0.0;
	this.center = new Point();
  }

  // non-default constructors
  public Circle (double radius, double x, double y)
  {
	this.radius = radius;
	this.center = new Point(x , y);
  }


  public Circle (double radius, Point p)
  {
	this.radius = radius;
	this.center = new Point(p.getX() , p.getY());
  }

  // accessors
  public double getRadius ()
  {
	return this.radius;
  }

  public Point getCenter ()
  {
	return this.center;
  }

  // mutators
  public void setRadius (double radius)
  {
	this.radius = radius;
  }

  public void setCenter (double x, double y)
  {
	this.center.setX(x);
	this.center.setY(y);
  }

  public void setCenter (Point p)
  {
	this.center.setX(p.getX());
	this.center.setY(p.getY());
  }

  // calculate circumference
  public double circumference ()
  {
	double circ = 2 * this.radius * Math.PI;
	return circ;
  }

  // calculate area
  public double area ()
  {
	double area = Math.PI * Math.pow(this.radius , 2);
	return area;
  }

  // determine if Point p is strictly inside this Circle
  public boolean isInside (Point p)
  {
	return this.center.distance(p) < this.radius;
  }

  // determine if Circle c is strictly inside this Circle
  public boolean isInside (Circle c)
  {
	return ((this.center.distance(c.center) + c.radius) < this.radius);
  }

  // determine if Rectangle r is strictly inside this Circle
  public boolean isInside (Rectangle r)
  {
	Point UL = r.getUL();
	Point LR = r.getLR();
	Point UR = new Point(LR.getX() , UL.getY());
	Point LL = new Point(UL.getX() , LR.getY());
	double dist1 = this.center.distance(UL);
	double dist2 = this.center.distance(LR);
	double dist3 = this.center.distance(LL);
	double dist4 = this.center.distance(UR);
	return ((dist1 < this.radius) && (dist2 < this.radius) && (dist3 < this.radius) && (dist4 < this.radius));
  }

  // determine if Circle c intersects this Circle
  public boolean doesIntersect (Circle c)
  {
	return ((this.center.distance(c.getCenter())) < (this.radius + c.radius)); 
  }

  // determine if Rectangle r intersects this Circle
  public boolean doesIntersect (Rectangle r)
  {
	Point UL = r.getUL();
	Point LR = r.getLR();
	Point UR = new Point(LR.getX() , UL.getY());
	Point LL = new Point(UL.getX() , LR.getY());
	double dist1 = this.center.distance(UL);
	double dist2 = this.center.distance(LR);
	double dist3 = this.center.distance(LL);
	double dist4 = this.center.distance(UR);
	return ((dist1 < this.radius) || (dist2 < this.radius) || (dist3 < this.radius) || (dist4 < this.radius));
  }

  // determine the Rectangle that inscribes this Circle
  public Rectangle inscribes ()
  {
	double ulXCord = this.center.getX() - this.radius;
	double ulYCord = this.center.getY() + this.radius;
	double lrXCord = this.center.getX() + this.radius;
	double lrYCord = this.center.getY() - this.radius;
	Rectangle r = new Rectangle(ulXCord , ulYCord , lrXCord , lrYCord);
	return r;
  }

  // string representation of the Circle in the form:
  // Radius: 1.2, Center: (3, 4)
  public String toString ()
  {
	String s = "Radius: " + this.radius + ", Center: (" + this.center.getX() + ", " + this.center.getY() + ")";
	return s;
  }

  // determine if two Circles have the same radius
  public boolean equals (Circle c)
  {
	double delta = 1.0 * Math.pow(10 , -18);
	return (Math.abs(this.radius - c.getRadius()) < delta);
  }

  // determine if two Circles have the same center
  public boolean isConcentric (Circle c)
  {
	double delta = 1.0 * Math.pow(10 , -18);
	return (this.center.distance(c.getCenter()) < delta);
  }
}

class Rectangle
{
  // list attributes
  private Point UL; 	// upper left corner
  private Point LR;	// lower right corner

  // default constructor creates a rectangle having
  // corners UL (0, 1) and LR (1, 0)
  public Rectangle ()
  {
	this.UL = new Point(0 , 1);
	this.LR = new Point(1 , 0);
  }

  // non-default constructors accept user defined points
  // and creates a rectangle object if the points form a
  // rectangle or the default rectangle if they do not.
  public Rectangle (Point ul, Point lr)
  {
	if((ul.getX() < lr.getX()) && (ul.getY() > lr.getY()))
	{
		this.UL = new Point(ul.getX() , ul.getY());
		this.LR = new Point(lr.getX() , lr.getY());
	}
	else
	{
		this.UL = new Point(0 , 1);
		this.LR = new Point(1 , 0);
	}	
  }

  public Rectangle (double x1, double y1, double x2, double y2)
  {
	if((x1 < x2) && (y1 > y2))
	{
		this.UL = new Point(x1 , y1);
		this.LR = new Point(x2 , y2);
	}
	else
	{
		this.UL = new Point(0 , 1);
		this.LR = new Point(1 , 0);
	}
  }

  // accessors
  public Point getUL ()
  {
	return this.UL;
  }
  public Point getLR ()
  {
	return this.LR;
  }

  // get length - absolute value of the x coord difference
  public double getLength ()
  {
	double len = Math.abs(this.UL.getX() - this.LR.getX());
	return len;
  }

  // get width - absolute value of the y coord difference
  public double getWidth ()
  {
	double wid = Math.abs(this.UL.getY() - this.LR.getY());
	return wid;
  }

  // mutators reset the edge points only if the rectangle 
  // shape is preserved
  public void setUL (Point ul)
  {
	if((ul.getX() < this.LR.getX()) && (ul.getY() > this.LR.getY()))
	{
		this.UL = new Point(ul.getX() , ul.getY());
	}
	else
	{
		return;
	}
  }
  public void setLR (Point lr)
  {
	if((lr.getX() > this.UL.getX()) && (lr.getY() < this.UL.getY()))
	{
		this.LR = new Point(lr.getX() , lr.getY());
	}
	else
	{
		return;
	}
  }

  public void setUL (double x1, double y1)
  {
	if((x1 < this.LR.getX()) && (y1 > this.LR.getY()))
	{
		this.UL = new Point(x1 , y1);
	}
	else
	{
		return;
	}
  }
  public void setLR (double x2, double y2)
  {
	if((x2 > this.UL.getX()) && (y2 < this.UL.getY()))
	{
		this.LR = new Point(x2 , y2);
	}
	else
	{
		return;
	}
  }
  public void setRectangle (double x1, double y1, double x2, double y2)
  {
	if((x1 < x2) && (y1 > y2))
	{
		this.UL = new Point(x1 , y1);
		this.LR = new Point(x2 , y2);
	}
	else
	{
		return;
	}
  }

  // calculate area of a rectangle
  public double area ()
  {
	double area = this.getLength() * this.getWidth();
	return area;
  }

  // calculate the perimeter of a rectangle
  public double perimeter ()
  {
	double perm = 2 * this.getLength() + 2 * this.getWidth();
	return perm;
  }

  // determine if a point is inside the rectangle
  public boolean isInside (Point p)
  {
	Point UL = this.getUL();
	Point LR = this.getLR();
	return ((p.getX() > UL.getX()) && (p.getY() < UL.getY()) && (p.getX() < LR.getX()) && (p.getY() > LR.getY()));
	/*Point center = new Point((UL.getX() + LR.getX()) / 2 , (UL.getY() + LR.getY()) / 2);
	double dist1 = center.distance(p);
	double dist2 = center.distance(this.getUL());
	return (dist1 < dist2);*/
  }

  // determine if the Circle c is inside the rectangle
  public boolean isInside (Circle c)
  {
	Point UL = this.getUL();
	Point LR = this.getLR();
	Point center = new Point((UL.getX() + LR.getX()) / 2 , (UL.getY() + LR.getY()) / 2);
	double dist1 = center.distance(c.getCenter()) + c.getRadius();
	double dist2 = center.distance(this.getUL());
	return (dist1 < dist2);
  }

  // determine if the Rectangle r is strictly inside this Rectangle
  public boolean isInside (Rectangle r)
  {
	Point UL = this.getUL();
	Point LR = this.getLR();
	Point UR = new Point(LR.getX() , UL.getY());
	Point LL = new Point(UL.getX() , LR.getY());
	Point rUL = r.getUL();
	Point rLR = r.getLR();
	Point rUR = new Point(rLR.getX() , rUL.getY());
	Point rLL = new Point(rUL.getX() , rLR.getY());
	return((rUL.getX() > UL.getX()) && (rUL.getY() < UL.getY()) && (rLR.getX() < LR.getX()) && (rLR.getY() < LR.getY())); 
	/*Point center = new Point((UL.getX() + LR.getX()) / 2 , (UL.getY() + LR.getY()) / 2);
	double dist1 = center.distance(this.getUL());
	Point rUL = r.getUL();
	Point rLR = r.getLR();
	Point rUR = new Point(rLR.getX() , rUL.getY());
	Point rLL = new Point(rUL.getX() , rLR.getY());
	double dist2 = center.distance(rUL);
	double dist3 = center.distance(rLR);
	double dist4 = center.distance(rUR);
	double dist5 = center.distance(rLL);
	return ((dist2 < dist1) && (dist3 < dist1) && (dist4 < dist1) && (dist5 < dist1));*/
  }

  // determine if Rectangle r intersects with this Rectangle
  public boolean doesIntersect (Rectangle r)
  {
	Point UL = this.getUL();
	Point LR = this.getLR();
	Point UR = new Point(LR.getX() , UL.getY());
	Point LL = new Point(UL.getX() , LR.getY());
	Point rUL = r.getUL();
	Point rLR = r.getLR();
	Point rUR = new Point(rLR.getX() , rUL.getY());
	Point rLL = new Point(rUL.getX() , rLR.getY());
	if((rLL.getX() > LL.getX()) && (rLL.getX() < LR.getX()) && (LL.getY() > rLL.getY()) && (LL.getY() < UL.getY()))
	{
		return true;
	}	
	return false;
	/*Point center = new Point((UL.getX() + LR.getX()) / 2 , (UL.getY() + LR.getY()) / 2);
	double dist1 = center.distance(this.getUL());
	Point rUL = r.getUL();
	Point rLR = r.getLR();
	Point rUR = new Point(rLR.getX() , rUL.getY());
	Point rLL = new Point(rUL.getX() , rLR.getY());
	double dist2 = center.distance(rUL);
	double dist3 = center.distance(rLR);
	double dist4 = center.distance(rUR);
	double dist5 = center.distance(rLL);
	return ((dist2 < dist1) || (dist3 < dist1) || (dist4 < dist1) || (dist5 < dist1));*/
  }

  // determine the Circle that circumscribes this Rectangle
  public Circle circumscribes ()
  {
	Point UL = this.getUL();
	Point LR = this.getLR();
	Point center = new Point((UL.getX() + LR.getX()) / 2 , (UL.getY() + LR.getY()) / 2);
	double radius = center.distance(this.getUL());
	Circle c = new Circle(radius , center);
	return c;
  }

  // return a string representation of a rectangle of the form
  // UL: (3, 4), LR: (7, 2)
  public String toString ()
  {
	Point UL = this.getUL();
	Point LR = this.getLR();
	String s = "UL: " + UL.toString() + ", LR: " + LR.toString();
	return s;
  }

  // determine if two rectangles are congruent, i.e. the
  // length of one is equal to the length of the other
  // width of one is equal to the width of the other
  public boolean equals (Rectangle r)
  {
	double delta = 1.0 * Math.pow(10 , -18);
	return((Math.abs(this.getLength() - r.getLength()) < delta) && (Math.abs(this.getWidth() - r.getWidth()) < delta));
  }

  // determine if a rectangle is a square
  public boolean isSquare () 
  {
	double delta = 1.0 * Math.pow(10 , -18); 
	return (Math.abs(this.getLength() - this.getWidth()) < delta);
  }

}

public class Geometry
{

  public static void main (String[] args) throws IOException
  {
    // open file "geometry.txt" for reading
	File inFile = new File("geometry.txt");
	Scanner sc = new Scanner(inFile);
	
    // read the coordinates of the first Point pointP
	double x1 = sc.nextDouble();
	double y1 = sc.nextDouble();
	Point pointP = new Point(x1, y1);
	sc.nextLine();
    
    // read the coordinates of the second Point pointQ
	double x2 = sc.nextDouble();
	double y2 = sc.nextDouble();
	Point pointQ = new Point(x2, y2);
	sc.nextLine();

    // print distance between pointP and pointQ
	double dist = pointP.distance(pointQ);
	System.out.println("Distance between pointP and pointQ: " + dist);
	System.out.println("");

    // read the radius and coordinates of the first Circle circleA
	double radius1 = sc.nextDouble();
	double c1 = sc.nextDouble();
	double c2 = sc.nextDouble();
	Circle circleA = new Circle(radius1 , c1, c2);
	sc.nextLine();

    // read the radius and coordinates of the second Circle circleB
	double radius2 = sc.nextDouble();
	double c3 = sc.nextDouble();
	double c4 = sc.nextDouble();
	Circle circleB = new Circle(radius2 , c3 , c4);
	sc.nextLine();

    // print the circumference of circleA
	double circA = circleA.circumference();
	System.out.println("Circumference of circleA: " + circA);
	System.out.println("");
 
    // print the area of circleB
	double areaB = circleB.area();
	System.out.println("Area of circleB: " + areaB);
	System.out.println("");
	
    // print if pointP is inside circleA
	if(circleA.isInside(pointP))
	{
		System.out.println("pointP is inside circleA");
	}
	else
	{
		System.out.println("pointP is not inside circleA");
	}
	System.out.println("");

    // print if circleB is inside circleA
	if(circleA.isInside(circleB))
	{
		System.out.println("circleB is inside circleA");
	}
	else
	{
		System.out.println("circleB is not inside circleA");
	}
	System.out.println("");

    // print if circleA and circleB intersect
	if(circleA.doesIntersect(circleB))
	{
		System.out.println("circleA and circleB does intersect");
	}
	else
	{
		System.out.println("circleA and circleB does not intersect");
	}
	System.out.println("");

    // print the Rectangle that circleB is inscribed in
	Rectangle r = circleB.inscribes();
	String s = r.toString();
	System.out.println("Coordinates of rectangle that inscribes circleB: " + s);
	System.out.println("");

    // read the coordinates of the UL and LR corners of Rectangle rectG
	double r1 = sc.nextDouble();
	double r2 = sc.nextDouble();
	double r3 = sc.nextDouble();
	double r4 = sc.nextDouble();
	Rectangle rectG = new Rectangle(r1, r2, r3, r4);
	sc.nextLine();

    // read the coordinates of the UL and LR corners of Rectangle rectH
	double r5 = sc.nextDouble();
	double r6 = sc.nextDouble();
	double r7 = sc.nextDouble();
	double r8 = sc.nextDouble();
	Rectangle rectH = new Rectangle(r5, r6, r7, r8);
	sc.nextLine();

    // print the length and width of rectG
	double len = rectG.getLength();
	double wid = rectG.getWidth();
	System.out.println("Length and width of rectG: " + len + "  " + wid);
	System.out.println("");

    // print if the rectG and rectH have the same area but different perimeter
	if((rectG.area() == rectH.area()) && (rectG.perimeter() != rectH.perimeter()))
	{
		System.out.println("rectG and rectH do have the same area but different perimeter");
	}
	else
	{
		System.out.println("rectG and rectH do not have the same area but different perimeter");
	}
	System.out.println("");

    // print if rectH is a square
	if(rectH.isSquare())
	{
		System.out.println("rectH is a square");
	}
	else
	{
		System.out.println("rectH is not a square");
	}
	System.out.println("");

    // print the Circle that circumscribes rectH
	Circle c = rectH.circumscribes();
	String t = c.toString();
	System.out.println("Coordinates of circle that circumscribes rectH: " + t);
	System.out.println("");

    // determine if pointP is inside rectG
	if(rectG.isInside(pointP))
	{
		System.out.println("pointP is inside rectG");
	}
	else
	{
		System.out.println("pointP is not inside rectG");
	}
	System.out.println("");

    // determine if circleB is inside rectH
	if(rectH.isInside(circleB))
	{
		System.out.println("circleB is inside rectH");
	}
	else
	{
		System.out.println("circleB is not inside rectH");
	}
	System.out.println("");

    // determine if rectH is inside rectG
	if(rectG.isInside(rectH))
	{
		System.out.println("rectH is inside rectG");
	}
	else
	{
		System.out.println("rectH is not inside rectG");
	}
	System.out.println("");

    // determine if rectG and rectH intersect
	if(rectG.doesIntersect(rectH))
	{
		System.out.println("rectG and rectH do intersect");
	}
	else
	{
		System.out.println("rectG and rectH do not intersect");
	}

    // close file "geometry.txt"
	sc.close();
	
  }
   
}
