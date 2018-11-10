/**
 * "SIN CHECKER"
 * 
 * This program calculates if a SIN's check number is correct.
 * 
 * @author Cameron Rodriguez
 * @version 1.0 07/13/17
 */

//Importing Swing
import javax.swing.*;

public class SINcheckerRodC {
  
  /** @param args the command line arguments */
  public static void main(String[] args) { 
    //Declaring variables
    String inputSIN; //The SIN number inputted by the user
    int num1, num2, num3, num4, num5, num6, num7, num8; //The first 8 digits (individually) of inputSIN
    int checkDigit; //The check (9th) digit
    int evenSum; //The sum of num2, num4, num6, and num8
    int oddSum; //The sum of num1, num3, num5, and num7
    int totalSum; //The sum of evenSum and oddSum (processed later for clarity)
    int totalSumTens; //totalSum rounded up to the nearest ten
    int retry; //Restarts input if user fails to input SIN and selects "Yes" on following dialog
    
    //Introducing program to user
    JOptionPane.showMessageDialog(null, "Welcome to the SIN Checker. A Social Insurance Number (SIN) is a unique identifier"
                                  + "\nissued by the Government of Canada. The first 8 digits are aiigned and the ninth is"
                                  + "\na check digit. This program will determine whether the check digit of a given SIN"
                                  + "\nis correct.", "SIN Checker", JOptionPane.INFORMATION_MESSAGE);
    
    //Initializing loop if user cancels
    do {
      retry = 99; //Clears retry option to prevent infinite loops if input fails once
      //Get SIN number from user
      inputSIN = JOptionPane.showInputDialog(null, "Please enter a SIN number. It must contain 9 numbers, without spaces,"
                                             + "\ndashes, or other symbols or characters.", "Input SIN Number",
                                             JOptionPane.QUESTION_MESSAGE);
      //Initialize input failure check
      if (inputSIN != null && inputSIN.length() == 9 && inputSIN.matches("[0-9]+")) {
        //Get all digits
        num1 = Character.getNumericValue(inputSIN.charAt(0));
        num2 = Character.getNumericValue(inputSIN.charAt(1));
        num3 = Character.getNumericValue(inputSIN.charAt(2));
        num4 = Character.getNumericValue(inputSIN.charAt(3));
        num5 = Character.getNumericValue(inputSIN.charAt(4));
        num6= Character.getNumericValue(inputSIN.charAt(5));
        num7 = Character.getNumericValue(inputSIN.charAt(6));
        num8 = Character.getNumericValue(inputSIN.charAt(7));
        checkDigit = Character.getNumericValue(inputSIN.charAt(8));
        //Multiplying even digits
        num2 *= 2;
        num4 *= 2;
        num6 *= 2;
        num8 *= 2;
        //Adding digits of individual even numbers
        if (num2 >= 10){
          num2 = (num2 % 10) + (num2 / 10);
        }
        if (num4 >= 10){
          num4 = (num4 % 10) + (num4 / 10);
        }
        if (num6 >= 10){
          num6 = (num6 % 10) + (num6 / 10);
        }
        if (num8 >= 10){
          num8 = (num8 % 10) + (num8 / 10);
        }
        //Adding digits of all even numbers
        evenSum = num2 + num4 + num6 + num8;
        //Adding digits of all odd numbers
        oddSum = num1 + num3 + num5 + num7;
        //Adding evenSum and oddSum
        totalSum = evenSum + oddSum;
        //Rounding up to nearest 10 (if needed)
        if ((totalSum % 10) != 0) {
          totalSumTens = totalSum + (10 - (totalSum % 10)); //TEACHER NOTE: totalSumTens = totalSum/10 --> " = Math.ceil(") * 10
        }
        else {
          totalSumTens = totalSum;
        }
        if ((totalSumTens - totalSum) == checkDigit) {
          JOptionPane.showMessageDialog(null, "The SIN " + inputSIN + " has the check digit " + checkDigit
                                        + ". It IS the correct check digit.", "Good Check Digit", JOptionPane.INFORMATION_MESSAGE);
        }
        else {
          JOptionPane.showMessageDialog(null, "The SIN " + inputSIN + " has the check digit " + checkDigit
                                        + ". It IS NOT the correct check digit.", "Bad Check Digit!", JOptionPane.WARNING_MESSAGE); 
        }
      }
      else { //Displays if no SIN inputted
        Object[] retryOptions = {"Yes", "No"};
        retry = JOptionPane.showOptionDialog(null, "A SIN number was not entered. Would you like to try again?",
                                             "SIN Not Entered", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE,
                                             null, retryOptions, retryOptions[0]);
      }
    }
    while (retry == JOptionPane.YES_OPTION);
  }  
}
