/**
 * "The Change Calculator"
 * 
 * This program calculates the type and number of coins required to make change for a value inputted.
 * 
 * @author Cameron Rodriguez
 * @version 1.1 07/10/17
 */

//Importing toolkits
import java.io.*;
import java.text.*;
import javax.swing.*;

public class MakeChangeRodC {
  
  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) { 
    //Declaring the variables
    double inputMoney;
    double toonieLeftover, loonieLeftover, quarterLeftover, dimeLeftover, nickelLeftover;
    int nickels, dimes, quarters, loonies, toonies;
    double pennies;
    String inputText1 = "Welcome to the Change Calculator!";
    String inputText2 = "\nThis program will calculate the change required to equal an amount of money.";
    String inputText3 = "\n\nPlease enter an amount in dollars:";
    
    //Initializing rounding to zero decimals
    DecimalFormat pennyRound = new DecimalFormat ("#,##0");
    
    /**
     * Get money input from reader
     * 
     * @param inputMoney the monetary value inputted by user
     * @return the monetary value
     */
    String cashinput = JOptionPane.showInputDialog (inputText1 + inputText2 + inputText3);
    inputMoney = Double.parseDouble (cashinput);
    
    /**
     * Caluclate the leftover money after the largest coins are taken
     * 
     * @param toonieLeftover remaining money after all tonnies are taken
     * @param loonieLeftover remaining money after all loonies are taken
     * @param quarterLeftover remaining money after all quarters are taken
     * @param dimeLeftover remaining money after all dimes are taken
     * @param nickelLeftover remaining money after all nickels are taken
     * @return remaining values for each coin amount
     */
    toonieLeftover = inputMoney % 2;
    loonieLeftover = toonieLeftover % 1;
    quarterLeftover = loonieLeftover % 0.25;
    dimeLeftover = quarterLeftover % 0.1;
    nickelLeftover = dimeLeftover % 0.05;
    
    /**
     * Calculate required coin amounts based on leftover money
     * 
     * @param toonies the number of toonies needed
     * @param loonies the number of loonies needed
     * @param quarters the number of quarters needed
     * @param dimes the number of dimes needed
     * @param nickels the number of nickels needed
     * @param pennies the number of pennies needed
     * @return the number of each coin which is needed
     */
    toonies = (int) (inputMoney / 2);
    loonies = (int) (toonieLeftover / 1);
    quarters = (int) (loonieLeftover / 0.25);
    dimes = (int) (quarterLeftover / 0.1);
    nickels = (int) (dimeLeftover / 0.05);
    pennies = (nickelLeftover / 0.01);
    
    /**
     * Display results to user
     */
    System.out.println ("The number of coins required to equal $" + inputMoney + " is:");
    System.out.println (toonies + " toonie(s)");
    System.out.println (loonies + " loonie(s)");
    System.out.println (quarters + " quarter(s)");
    System.out.println (dimes + " dime(s)");
    System.out.println (nickels + " nickel(s)");
    System.out.println ("and " + pennyRound.format (pennies) + " penny/pennies.");
  }
}
