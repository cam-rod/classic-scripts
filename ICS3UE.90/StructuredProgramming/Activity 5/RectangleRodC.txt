/*
 * Programmer: Cameron Rodriguez
 * Date: July 8, 2017
 */
/**
 * Program Description: This program will display information about the side lengths, perimeter, and area or a rectangle
 */
public class RectangleRodC {
  
  /**
   * Calculates details on a rectangle and displays to command line
   * 
   * @param args the command line arguments
   */
  public static void main(String[] args) { 
    //Declaring variables
    int recLength, recWidth, recBorder, recArea;
    
    //Assigning values to variables
    recLength = 16;
    recWidth = 12;
    
    /** Calculating perimeter and area of rectangle */
    recBorder = 2 * (recLength + recWidth);
    recArea = recLength * recWidth;
    
    /** Displaying information to command line */
    System.out.println ("Welcome to the " + "Rectangle Calculator" + "! This program will");
    System.out.println ("calculate and display basic information about a rectangle.");
    System.out.println ("");
    System.out.println ("This rectangle has a length of " + recLength + " units, and a width");
    System.out.println ("of " + recWidth + " units.");
    System.out.println ("");
    System.out.println ("It has a perimeter of " + recBorder + " units, and an area of " + recArea + " square units.");
  }
}
