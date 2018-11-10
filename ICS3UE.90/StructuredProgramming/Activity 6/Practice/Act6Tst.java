//Importing toolkits
import java.io.*;
import java.text.*;
import javax.swing.*;

public class Act6Tst {
   public static void main(String[] args) throws IOException  {
   //Initialize the Input stream reader
       BufferedReader myInput = new BufferedReader (new InputStreamReader (System.in));

       //Declare our variables
       double PI = 3.14159;
       double radius;
       double area;
       double circumference;

       //Initalize the formatting to 2 decimal places
       DecimalFormat twoDigit = new DecimalFormat ("#,##0.00");

       //Ask the user to input a value for radius 
       String radinput = JOptionPane.showInputDialog ("Please enter the radius of the circle: ");
       //OR System.out.println " "                                     "
        
       //Obtain Radius from the user as a String & convert to a double
       radius = Double.parseDouble (radinput);
       //OR " "         "          (myInput.readLine());

       //Calculate the area of a circle
       area = PI * radius * radius;

       //Calculate the circumference of a circle
       circumference = 2 * PI * radius;

       //Output values to the user
       System.out.println ("The area of a circle is: " + twoDigit.format (area));
       System.out.println ("The circumference of a circle is: " 
          + twoDigit.format (circumference));
    }
}