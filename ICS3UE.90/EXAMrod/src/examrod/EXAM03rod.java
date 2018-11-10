package examrod;

/**
 * This program calculates the commission earned by an employee in a week. 
 *
 * @author Cameron Rodriguez
 * @version 0.3
 */
import java.io.*;
import java.text.*;
public class EXAM03rod {
  static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
  static DecimalFormat cents = new DecimalFormat("#,##0.00");
  /**
   * @param args the command line arguments
   * @throws java.io.IOException
   */
  public static void main(String[] args) throws IOException {
    int employeeCount;
    int element = 0;
    
    employeeCount = inputEmployeeCount();
    
    String name[] = new String[employeeCount];
    double sales[] = new double[employeeCount];
    double commission[] = new double[employeeCount];
    
    while (element < employeeCount) {
     name[element] = inputName();
     sales[element] = inputSales(name[element]);
    
     commission[element] = calculateCommission(sales[element]);
     
     element++;
    }
    
    displayCommission(name, sales, commission);
  }
  
  public static int inputEmployeeCount() throws IOException{
    int employeeCount;
    
    System.out.println("Please enter the number of employees you wish to calculate commission for:");
    
    employeeCount = Integer.parseInt(input.readLine());
    System.out.println("");
    
    return employeeCount;
  }
  
  public static String inputName() throws IOException {
    String name;
    
    System.out.println("Please enter the employee's name:");
    
    name = input.readLine();
    System.out.println("");
    
    return name;
  }
  
  public static double inputSales(String name) throws IOException {
    double sales;
    
    System.out.println("Please enter " + name + "'s total sales this week:");
    
    sales = Double.parseDouble(input.readLine());
    System.out.println("");
    
    return sales;
  }
  
  public static double calculateCommission(double sales) {
    double commission;
    
    if (sales > 5000) {
      commission = sales * 0.1;
    }
    else if (sales > 3000) {
      commission = sales * 0.08;
    }
    else if (sales > 1000) {
      commission = sales * 0.05;
    }
    else {
      commission = sales * 0.02;
    }
    
    return commission;
  }
  
  public static void displayCommission(String[] name, double[] sales, double[] commission) {
    int element = 0;
    
    System.out.printf("%-45s %-20s %-12s \n", "Name", "Sales", "Commission");
    
    System.out.printf("%-45s %-20s %-12s \n", "----", "-----", "----------");
    
    while (element < name.length) {
      System.out.printf("%-45s %-20s %-12s \n", name[element], "$" + cents.format(sales[element]),
                         "$" + cents.format(commission[element]));
      element++;
    }
  }
}
