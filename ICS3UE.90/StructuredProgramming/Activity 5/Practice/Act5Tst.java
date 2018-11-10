import java.io.*;
import java.text.*;

/* Programmer: Cameron Rodriguez
 * Date: July 8, 2017
 */

/**
 * This program will demonstrate variables, math, and decimal limiting.
 */
public class Act5Tst {
  
  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) throws IOException{ 
    //Declare variable names
    int myNum1, myNum2, myNum3, myNum4;
    String firstname;
    double myDecimal;
    
    //Assign values to variables
    myNum1 = 12;
    myNum2 = 23;
    myNum3 = -14;
    myNum4 = 7;
    myDecimal = 2.3;
    firstname = "Cameron";
    
    //Displaying information to screen
    System.out.println (myNum1);
    System.out.println (firstname);
    
    //Displaying text and variables combined
    System.out.println ("Hello, my name is " + firstname + ".");
    System.out.println ("");
    
    System.out.println ("I am going to guess your favourite");
    System.out.print ("number. Is it ");
    System.out.print (myNum2);
    System.out.println ("?");
    System.out.println ("");
    
    System.out.println ("Hello! My name is " + firstname + ".");
    System.out.println ("My favourite number is " + myNum4 + ", and ");
    System.out.println ("an random interger I chose is " + myNum3 + ".");
    System.out.println ("");
    
    //Declaring division variables
    int divNum = 5;
    double halfDivNum = divNum/2.0;
    
    System.out.println ("Five divided by two is " + halfDivNum + ".");
    System.out.println ("");
    
    //Declaring arithmetic variables
    int answer1, answer2, answer3, answer4;
    double answer5;
    
    //Adding variables
    answer1 = myNum2 + myNum3;
    
    //Subtracting variables
    answer2 = myNum1 - myNum4;
    
    //Multiplying variables
    answer3 = myNum2 * myNum4;
    
    //Dividing with answer variables
    answer4 = answer3 / answer1;
    answer5 = answer4 / myNum1 + myNum4 + 0.5;
    
    //Displaying answers
    System.out.println ("Adding " + myNum2 + " and " + myNum3 + " gives " + answer1 + ".");
    System.out.println ("");
    System.out.println ("I also got " + answer2 + " from subtracting, " + answer3 + " from multiplying");
    System.out.println ("and " + answer4 + " and " + answer5 + " from dividing.");
    
    //Assinging the final variable
    double superNum = 3.14159265;
    
    //Rounding to two decimal places
    DecimalFormat twoDigit = new DecimalFormat ("#,##0.00");
    
    //Rounding to four decimal places
    DecimalFormat fourDigit = new DecimalFormat ("#,##0.0000");
    
    //Displaying rounded decimals
    System.out.println ("When " + superNum + " is displayed to 2 and 4 decimal points, it");
    System.out.println ("gives " + twoDigit.format (superNum) + " and " + fourDigit.format (superNum) + ", respectively.");
    
  }
  
}
