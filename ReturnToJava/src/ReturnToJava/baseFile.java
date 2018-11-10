package ReturnToJava;

/**
 * Test program to see what I remember.
 * 
 * @author Racer 77
 */
import java.io.*;
import java.util.Scanner;

public class baseFile {
  static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
  //New input type - Scanner
  static Scanner scanInput = new Scanner(System.in);
  /**
   * @param args the command line arguments
   * @throws java.io.IOException
   */
  public static void main(String[] args) throws IOException {
    Hello hello = new Hello();
    
    hello.sayHello();
    
    int number = getNumber();
    
    System.out.println("");
    System.out.println("The number you entered was " + number);
  }
  /**
   * Returns the number the user inputted
   * @return the number
   * @throws java.io.IOException
   */
  public static int getNumber() throws IOException {
    int number; //The number the user inputted
    
    System.out.print("Enter your number:");
    number = scanInput.nextInt();
    
    return number;
  }
}
