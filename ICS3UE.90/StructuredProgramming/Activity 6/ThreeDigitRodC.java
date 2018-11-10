/**
 * "The Number Sum Calculator"
 * 
 * This program calaculates and displays the sum of a positive three digit interger.
 * 
 * @author Cameron Rodriguez
 * @version 1.0 07/09/17
 */

//Importing toolkits
import java.io.*;
import javax.swing.*; //ONE OUTPUT ONLY

public class ThreeDigitRodC {
  
  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) { 
    //Declaring the variables
    int threeDigInt, twoDigInt;
    int ones, tens, hundreds;
    int intSum;
    
    /**
     * Get the three digit integer from user
     * 
     * @param threeDigInt the three digit interger
     * @return the three digit interger
     */
    String numinput = JOptionPane.showInputDialog ("Welcome to the Number Sum Calculator!" + "\n\nPlease enter a three digit number:");
    threeDigInt = Integer.parseInt (numinput);
    
    /**
     * Determine value of each digit
     * 
     * @param ones the ones place digit of threeDigInt
     * @param twoDigInt the first two digits of threeDigInt
     * @param tens the tens place digit of threeDigInt
     * @param hundreds the hundreds place digit of threeDigInt
     * @return the value of each digit
     */
    ones = threeDigInt % 10;
    twoDigInt = threeDigInt / 10;
    tens = twoDigInt % 10;
    hundreds = twoDigInt / 10;
    
    /**
     * Calculate the sum of the the digits
     * 
     * @param intSum the sum of all digits
     * @return the sum of the digits
     */
    intSum = ones + tens + hundreds;
    
    /**
     * Displays sum of digits to user
     */
    
    System.out.println ("When the digits of the number " + threeDigInt + " are added,");
    System.out.println ("the sum is " + intSum + ".");
  }  
}
