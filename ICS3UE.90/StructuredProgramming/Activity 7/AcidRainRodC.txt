/**
 * "Water Body Acidity Checker"
 * 
 * This program determines the chances of fish survival based on water acidity.
 * 
 * @author Cameron Rodruguez
 * @version 1.0 07/10/17
 */

//Importing toolkits
import java.io.*;

public class AcidRainRodC {
  
  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) throws IOException { 
    //Initializing Input Stream Reader
    BufferedReader acidInput = new BufferedReader(new InputStreamReader(System.in));
    //Declaring variables
    double pH;
    
    //Introductory text
    System.out.println("'WATER BODY ACIDITY CHECKER'");
    System.out.println("");
    System.out.println("Acid rain is a real threat to the natural environment, especially");
    System.out.println("bodies of water inhabited by sea life. While carbon dioxide from");
    System.out.println("volcanoes are a factor, human activities such as burning fossil fuels");
    System.out.println("have a major impact.");
    System.out.println("");
    System.out.println("This program will predict the ability for fish to survive based on the");
    System.out.println("acidity of the water.");
    System.out.println("");
    
    /**
     * Get pH level from user
     * 
     * @param pH the pH level of the water body
     * @return the pH level
     */
    System.out.println("Please enter a pH level:");
    pH = Double.parseDouble(acidInput.readLine());
    
    /*
     * Calculate acidity of water body and display result to user
     * 
     * @return survivability of fish
     */
    if (pH < 6.5) {
      System.out.println("");
      System.out.println("TOO ACID - FISH IN STREAMS, RIVERS AND LAKES WILL NOT SURVIVE");
    }  
    else if (pH > 7.5) {
      System.out.println("");
      System.out.println("TOO ALKALINE - FISH IN STREAMS, RIVERS AND LAKES WILL NOT SURVIVE");
    }
    else {
      System.out.println("");
      System.out.println("NEUTRAL - FISH IN STREAMS, RIVERS AND LAKES WILL SURVIVE");
    }
  } 
}