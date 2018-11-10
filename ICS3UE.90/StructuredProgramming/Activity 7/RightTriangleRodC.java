/**
 * "Right Triangle"
 * 
 * This program will calculate whether three values could form a right triangle.
 * 
 * @author Cameron Rodriguez
 * @version 1.0 07/10/17
 */

//Importing toolkits
import javax.swing.*;

public class RightTriangleRodC {
  
  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) { 
    //Declaring variables
    double side1, side2, side3;
    double sideSquared1, sideSquared2, sideSquared3; // names like side3Squared #idiot
    
    /**
     * Introduce program and get first side length from user
     * 
     * @param side1 the first side length
     * @return the first side
     */
    String sideInput1 = JOptionPane.showInputDialog("Welcome to the 'Right Triangle' program."
                                                      + "\n\nThis program will take three side length and determine "
                                                      + "whether they can form" + "\na right triangle." + "\n\nPlease "
                                                      + "enter the first side length.");
    side1 = Double.parseDouble(sideInput1);
    /**
     * Get second side length form user
     * 
     * @param side2 the second side length
     * @return the second side length
     */
    String sideInput2 = JOptionPane.showInputDialog("Please enter the second side length.");
    side2 = Double.parseDouble(sideInput2);
    /**
     * Get third side length from iser
     * 
     * @param side3 the third side length
     * @return thre third side length
     */
    String sideInput3 = JOptionPane.showInputDialog("Please enter the third side length.");
    side3 = Double.parseDouble(sideInput3);
    
    /**
     * Calculate square of side lengths
     * 
     * @param sideSquared1 the square of side1
     * @param sideSquared2 the square of side2
     * @param sideSquared3 the square of side3
     * @return the square of each side
     */
    sideSquared1 = side1 * side1;
    sideSquared2 = side2 * side2;
    sideSquared3 = side3 * side3;
    
    /**
     * Determine whether right triangle is possible
     * 
     * @return possibility of right triangle
     */
    if (sideSquared1 + sideSquared2 == sideSquared3 || sideSquared2 + sideSquared3 == sideSquared1 ||
        sideSquared1 + sideSquared3 == sideSquared2) {
      System.out.println("The side lengths of " + side1 + ", " + side2 + ", and " + side3 + " WILL form a right triangle.");
    }
    else {
      System.out.println("The side lengths of " + side1 + ", " + side2 + ", and " + side3 + " will NOT form a right triangle.");
    }
  } 
}
