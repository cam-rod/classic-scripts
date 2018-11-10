/**
 * "Fibonacci Sequence Generator
 *
 * This program will generate the Fibonacci sequence up to the user's request.
 * 
 * @author Cameron Rodriguez
 * @version 1.0 07/11/17
 */

//Importing toolkits
import java.io.*;

public class FibonacciRodC {
  
  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) throws IOException { 
    //Initializing Input Stream Reader
    BufferedReader seqLimit = new BufferedReader(new InputStreamReader(System.in));

    //Declaring variables
    int seriesNum;
    int a, b, c;
    int counter;
    
    //Introducing program to user
    System.out.println("FIBONACCI SEQUENCE GENERATOR");
    System.out.println("");
    System.out.println("This program will generate the values of the Fibonacci sequence as many times as");
    System.out.println("instructed. Simply enter a number and it will generate the sequence for you.");
    System.out.println("");
    
    /**
     * Returns number of values from user
     * 
     * @return number of values
     */
    System.out.println("Please enter a number of values to be generated:");
    seriesNum = Integer.parseInt(seqLimit.readLine());
    System.out.println("");
    
    /**
     * Return values of sequence and display to user
     * 
     * @param seriesNum the number of values
     * @return the continuous Fibonacci sequence
     */
    a = 0;
    b = 1;
    c = 0;
    counter = 0;
    while (counter != seriesNum) {
      counter++;
      a = a + (b - a); //Replace with a = b
      b = b + (c - b); //Replace with b = c #idiot
      c = a + b;
      System.out.println(c);
    }
  }
}