import java.util.*;
import java.lang.Math;
import java.text.*;

public class mortage_calc{

  public static void main(String[] args) {
      //instancing the scanner method
      Scanner input = new Scanner(System.in);
      
      //declaring variables
      int principle;
      float interestRate;
      int paymentPeriod;

      // for a mortage calculator we are going to need three variables: principle (the loan), Interest rate, and payment period to calculate the mortage amount monthly
      while (true) {
    	  System.out.print("Principle ($1k - $1m): ");
    	  principle = input.nextInt();
    	  if (principle >= 1000 && principle <= 1000000) {
    		  break;
    	  }else {
    		  System.out.println("Please enter a value between $1k and $1m...");
    	  }
      }
      
      while(true) {
    	  System.out.print("Interest rate: ");
      	  interestRate = input.nextFloat();
      	  if (interestRate > 0 && interestRate <= 30) {
      		  break;
      	  }else {
      		  System.out.println("Please enter a value greater than 0 and less than 30...");
      	  }
      }
      
      while(true) {
    	  System.out.print("payment period (in years): ");
    	  paymentPeriod = input.nextInt();
    	  if (paymentPeriod >= 1 && paymentPeriod <= 30) {
    		  break;
    	  }else {
    		  System.out.println("Please enter a value between 1 and 30...");
    	  }
      
      }
      //now we have all the user input saved in variables named accordingly time to do the mortage formula and output the monthly mortage cost in dollar currency
      //first thing we have to do is in the mortage formula we need to convert the payment period to months and the interest rate to monthly interest not yearly as it is right now
      float monthlyInterestRate = interestRate / 100 / 12;
      //we can convert the yearly rate to monthly by dividing it by 100
      int paymentPeriodMonthly = paymentPeriod * 12;
      //this code converts the payment period from years to months by multiplying the years by 12(months) to figure out the total # of months in the payment period
      
      double stepOne = 1 + monthlyInterestRate;
      
      
      double stepTwo = Math.pow(stepOne, paymentPeriodMonthly);
     
      //we need two of the step twos so here we are creating a temp variable to hold another value of the same as steptwo
      double temp = stepTwo;
      
      double stepThree = monthlyInterestRate * stepTwo;
     
      
      double bottomDenominator = temp - 1;
     
      
      double stepFour = stepThree / bottomDenominator;
    
      //last and final step of the formula is multiplying the principle by the final stepFour
      
      double monthlyPayment = principle * stepFour;
      
      //now in the monthlyPayment variable we have the final monthly cost of the mortage with interest
      NumberFormat result = NumberFormat.getCurrencyInstance();
      String currency = result.format(monthlyPayment);
      System.out.println(currency);


    




  }//end of main method


}//end of class