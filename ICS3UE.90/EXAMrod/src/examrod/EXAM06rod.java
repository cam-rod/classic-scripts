package examrod;

/**
 * This program calculates the commission earned by an employee in a week. 
 *
 * @author Cameron Rodriguez
 * @version 1.0
 */
import java.io.*;
import java.text.*;
public class EXAM06rod {
  //Initializing Input Stream Reader and Decimal Format
  static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
  static DecimalFormat cents = new DecimalFormat("#,##0.00");
  /**
   * @param args the command line arguments
   * @throws java.io.IOException
   */
  public static void main(String[] args) throws IOException {
    int employeeCount; //The number of employees to input info for
    int element = 0; //The element in the name, commission, sales array to populate
    double salesTotal; //The total sales made
    double commissionTotal; //The total commission to pay
    double commissionAvg; //The average commission to pay
    
    //Introduce program to user
    introProgram();
    
    //Get number of employees data will be inputted for
    employeeCount = inputEmployeeCount();
    
    //Build array based on number of employees
    String name[] = new String[employeeCount];
    double sales[] = new double[employeeCount];
    double commission[] = new double[employeeCount];
    
    //Initializing array population loop
    while (element < employeeCount) {
      //Input name and sales
      name[element] = inputName();
      sales[element] = inputSales(name[element]);
      
      //Calculate commision
      commission[element] = calculateCommission(sales[element]);
      
      //Increase element by 1
      element++;
    }
    
    //Calculate sales and commission totals
    salesTotal = calculateTotals(sales);
    commissionTotal = calculateTotals(commission);
    
    //Calculate average commission
    commissionAvg = calculateCommissionAvg(commission, commissionTotal);
    
    //Display commission and sales to user
    displayCommission(name, sales, commission, salesTotal, commissionTotal, commissionAvg);
  }
  
  /**
   * Introduces the program to the user.
   */
  public static void introProgram() {
    System.out.println("COMMISSION CALCULATOR");
    System.out.println("=====================");
    System.out.println("Welcome to the Commission Calculator. This program will calculate");
    System.out.println("the commission to be paid to employees based on their weekly sales.");
    System.out.println("");
    System.out.println("First, enter the number of employees to calculate commission for. Then,");
    System.out.println("enter the name and sales of each employee. The program will return each");
    System.out.println("employee's commission, as well as total sales, and total and average");
    System.out.println("commissions.");
  }
  
  /**
   * Returns the number of employees data will by inputted for
   * @return the number of employees
   * @throws IOException 
   */
  public static int inputEmployeeCount() throws IOException{
    int employeeCount; //Theinteger for the number of employees
    
    //Prompt user it input data
    System.out.println("Please enter the number of employees you wish to calculate commission for:");
    
    //Get numberof employees
    employeeCount = Integer.parseInt(input.readLine());
    System.out.println("");
    
    //Return number of employees
    return employeeCount;
  }
  
  /**
   * Returns the employee's name
   * @return the name 
   * @throws IOException 
   */
  public static String inputName() throws IOException {
    String name; //The name
    
    //Prompt user to enter name
    System.out.println("Please enter the employee's name:");
    
    //Get name
    name = input.readLine();
    System.out.println("");
    
    //Return name
    return name;
  }
  
  /**
   * Return the employee's sales
   * @param name the employee's name
   * @return the employee's sales
   * @throws IOException 
   */
  public static double inputSales(String name) throws IOException {
    double sales; //The sales
    
    //Prompt user
    System.out.println("Please enter " + name + "'s total sales this week:");
    
    //Get sales
    sales = Double.parseDouble(input.readLine());
    System.out.println("");
    
    //Return sales
    return sales;
  }
  
  /**
   * Return the commission based on sales
   * @param sales the employee's sales
   * @return the commission
   */
  public static double calculateCommission(double sales) {
    double commission; //The commision
    
    if (sales > 5000) { //Sales over $5000, 10% commission
      commission = sales * 0.1;
    }
    else if (sales > 3000) { //Sales over $3000 to $5000, 8% commission
      commission = sales * 0.08;
    }
    else if (sales > 1000) { //Sales over $1000 to $3000, 5% commission
      commission = sales * 0.05;
    }
    else { //Sales to $1000, 2% commission
      commission = sales * 0.02;
    }
    
    //Return commission
    return commission;
  }
  
  /**
   * Calculate totals of sales/commissions
   * @param money the array of sales/commissions
   * @return the total sales/commissions
   */
  public static double calculateTotals(double[] money) {
    int element = 0; //The element to add
    double total = 0; //The total sales/commissions
    
    while (element < money.length) { //Add each element
      total += money[element];
      element++;
    }
    
    //Return total
    return total;
  }
  /**
   * Return the average commission
   * @param commission the array of commissions
   * @param commissionTotal the total commissions
   * @return the average commission
   */
  public static double calculateCommissionAvg(double[] commission, double commissionTotal) {
    double commissionAvg; //The average commission
    
    //Divide the total commission by the number of employees to get the average
    commissionAvg = commissionTotal / commission.length;
    
    //Return the average commission
    return commissionAvg;
  }
  
  /**
   * Displays the sales and commissions of the employees
   * @param name the array of employee names
   * @param sales the array of employee sales
   * @param commission the array of employee commissions
   * @param salesTotal the total sales
   * @param commissionTotal the total commission
   * @param commissionAvg the average commmission
   */
  public static void displayCommission(String[] name, double[] sales, double[] commission,
                                       double salesTotal, double commissionTotal, double commissionAvg) {
    int element = 0; //The element to display
    //Display title and headers
    System.out.println("Weekly Commissions");
    System.out.println("~~~~~~~~~~~~~~~~~~");
    System.out.printf("%-45s %-20s %-12s \n", "Name", "Sales", "Commission");
    System.out.printf("%-45s %-20s %-12s \n", "----", "-----", "----------");
    
    while (element < name.length) { //Display data for each employee
      System.out.printf("%-45s %-20s %-12s \n", name[element], "$" + cents.format(sales[element]),
                         "$" + cents.format(commission[element]));
      element++;
    }
    //Display totals and average commission
    System.out.println("-----------------------------------------------------------------------------");
    System.out.printf("%-45s %-20s %-12s \n", "Totals", "$" + cents.format(salesTotal),
                      "$" + cents.format(commissionTotal));
    System.out.printf("%-45s %-20s %-12s \n", "Average", "", "$" + cents.format(commissionAvg));
  }
}
