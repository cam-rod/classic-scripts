/**
 * "Triangle Identifier"
 * 
 * This program identifies whether a set of sides can form a triangle, and if so, the type of triangle.
 * 
 * @author Cameron Rodriguez
 * @version 1.0 07/12/17
 */
//Importing toolkit
import javax.swing.*;

public class TriangleIdentifierRodC {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) { 
    //Identifying variables
    int totalTriangle; //This variable determines whether the program restarts or not and counts total number of attempted triangles
    int restartCheck = 0; //This unit recieves the restart command and equalizes with totalTriangle
    double side1, side2, side3; //Holds three side lengths inputted by user
    int goodTriangle = 0; //Counts the number of successfuly formed triangles
    
    //Introduce program to user
    JOptionPane.showMessageDialog(null, "Welcome to the Triangle Identifier! This program will take the values of three"
                                  + "\nsides and determine whether those values can form a triangle. It will also figure"
                                  + "\nout whether a scalene, isosceles, or equilateral triangle is formed. It also can"
                                  + "\ndetermine if a right triangle is formed." + "\n\nClick the button below to begin.",
                                  "Triangle Identifier", JOptionPane.INFORMATION_MESSAGE); 
    
    //Initializing restart loop
    main: //Allows for loop to be broken if cancel button is selected
    for (totalTriangle = 0; totalTriangle == restartCheck; totalTriangle++) {
      //Get first side length from user
      String sideInput1 = JOptionPane.showInputDialog(null, "Please enter the length of the first side below:",
                                                      "Enter Side Length", JOptionPane.QUESTION_MESSAGE);
      side1 = Double.parseDouble(sideInput1);
      //Get second side length from user
      String sideInput2 = JOptionPane.showInputDialog(null, "Please enter the length of the second side below:",
                                                      "Enter Side Length", JOptionPane.QUESTION_MESSAGE);
      side2 = Double.parseDouble(sideInput2);
      //Get thirf side length from user
      String sideInput3 = JOptionPane.showInputDialog(null, "Please enter the length of the third side below:",
                                                      "Enter Side Length", JOptionPane.QUESTION_MESSAGE);
      side3 = Double.parseDouble(sideInput3);
      
      //Square all sides for right triangle check
      double side1Squared = side1 * side1;
      double side2Squared = side2 * side2;
      double side3Squared = side3 * side3;
   
      //Determine if sides inputted form triangle
      if (side1 + side2 > side3 || side2 + side3 > side1 || side1 + side3 > side2) {
        //Adding successful triangle
        goodTriangle++;
        //Determine if sides inputted form equilateral triangle
        if (side1 + side2 == 2 * side3 || side2 + side3 == 2 * side1 || side1 + side3 == 2 * side2) {
          JOptionPane.showMessageDialog(null, "The side lengths of " + side1 + ", " + side2 + ", and " + side3
                                        + "WILL form" + "\n a triangle. Specifically, it will form an equilateral triangle.",
                                        "Results", JOptionPane.PLAIN_MESSAGE);
        }
        else {
          //Determine if sides inputted form a right triangle (isosceles triangles can also be right triangles)
          if (side1Squared + side2Squared == side3Squared || side2Squared + side3Squared == side1Squared
                || side1Squared + side3Squared == side2Squared) {
            //Determine if isosceles or scalene triangle formed
            if (side1 == side2 || side2 == side3 || side1 == side3) {
              JOptionPane.showMessageDialog(null, "The side lengths of " + side1 + ", " + side2 + ", and " + side3
                                            + "WILL form" + "\n a triangle. Specifically, it will form a right, isosceles triangle.",
                                            "Results", JOptionPane.PLAIN_MESSAGE);  
            }
            //Is a scalene triangle
            else {
              JOptionPane.showMessageDialog(null, "The side lengths of " + side1 + ", " + side2 + ", and " + side3
                                            + "WILL form" + "\n a triangle. Specifically, it will form a right, scalene triangle.",
                                            "Results", JOptionPane.PLAIN_MESSAGE);
            }
          }
          //Is NOT a right triangle
          else {
            //Determine if isosceles or scalene triangle formed
            if (side1 == side2 || side2 == side3 || side1 == side3) {
              JOptionPane.showMessageDialog(null, "The side lengths of " + side1 + ", " + side2 + ", and " + side3
                                            + "WILL form" + "\n a triangle. Specifically, it will form an isosceles triangle.",
                                            "Results", JOptionPane.PLAIN_MESSAGE);  
            }
            //Is a scalene triangle
            else {
              JOptionPane.showMessageDialog(null, "The side lengths of " + side1 + ", " + side2 + ", and " + side3
                                            + " WILL form" + "\n a triangle. Specifically, it will form a scalene triangle.",
                                            "Results", JOptionPane.PLAIN_MESSAGE);
             }
          }
        }
      }
      else {
        JOptionPane.showMessageDialog(null, "The side lengths of " + side1 + ", " + side2 + ", and " + side3
                                      + " will NOT form" + "\na triangle.", "Results", JOptionPane.WARNING_MESSAGE);
      }
    //Opening restart menu
    Object[] restartOptions = {"Yes", "No"};
    restartCheck = JOptionPane.showOptionDialog(null, "Would you like to run the program again?", "Restart program?",
                                             JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null,
                                             restartOptions, restartOptions[0]);
    /* Pressing yes gives outputs a zero, adding totalTriangle will match them in this case.
     * Selecting another option will output a different value, so the addition will be incorrect and the program will
     * not restart. */
    restartCheck += totalTriangle;
    }
    JOptionPane.showMessageDialog(null, "Of the " + totalTriangle + " attempted triangles, " + goodTriangle
                                  + " triangles were succesfully created." + "\n\nThaks for using this program!",
                                  "Final Results", JOptionPane.PLAIN_MESSAGE);
  } 
}
