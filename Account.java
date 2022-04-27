import java.text.DecimalFormat;
import java.util.Scanner;

public class Account {
    private int customerNumber;
    private int pinNumber;
    private double checkingBalance = 0;
    private double savingsBalance = 0;
    
    Scanner input = new Scanner(System.in);
    DecimalFormat moneyFormat = new DecimalFormat(" '$'#### , ##0.00");

    public int setCustomerNumber(int customerNumber){
        this.customerNumber = customerNumber;
        return customerNumber;
    }

    public int getCustomerNumber(){
        return customerNumber;
    }

    public int setPinNumber(int pinNumber){
        this.pinNumber = pinNumber;
        return pinNumber;
    }

    public int getPinNumber(){
        return pinNumber;
    }
    
    public double getCheckingBalance(){
        return checkingBalance;
    }

    public double getSavingBalance(){
        return savingsBalance;
    }

    public double calcCheckingWithdraw(double amount){
        checkingBalance = (checkingBalance - amount);
        return checkingBalance;
    }

    public double calcSavingWithdraw(double amount){
        savingsBalance = (savingsBalance- amount);
        return savingsBalance;
    }

    public double calcCheckingDeposit(double amount){
        checkingBalance = (checkingBalance+amount);
        return checkingBalance;
    }

    public double calcSavingDeposit(double amount){
        savingsBalance = (savingsBalance+amount);
        return savingsBalance;
    }

    public void getCheckingWithdrawInput(){
        System.out.println("Checking Account Balance: "+ moneyFormat.format(checkingBalance));
        System.out.print("Amount you want to withdraw from checking Account: ");
        double amount= input.nextDouble();

        if((checkingBalance-amount)>=0){
            calcCheckingWithdraw(amount);
            System.out.println("New Checking Account Balance: "+ moneyFormat.format(checkingBalance));
        }
        else{
            System.out.println("Balance Cannot be Negative."+"\n");
        }
    }
    public void getSavingWithdrawInput(){
        System.out.println("Savings Account Balance: "+ moneyFormat.format(savingsBalance));
        System.out.print("Amount you want to withdraw from Savings Account: ");
        double amount= input.nextDouble();

        if((savingsBalance-amount)>=0){
            calcSavingWithdraw(amount);
            System.out.println("New Savings Account Balance: "+ moneyFormat.format(savingsBalance));
        }
        else{
            System.out.println("Balance cannot be Negative."+"\n");
        }
    }

    public void getCheckingDepositInput(){
        System.out.println("Checking Account Balance: "+ moneyFormat.format(checkingBalance));
        System.out.print("Amount you want to Deposit from checking Account: ");
        double amount = input.nextDouble();
    
        if((checkingBalance+amount)>=0){
            calcCheckingDeposit(amount);
            System.out.println("New Checking Account Balance: "+ moneyFormat.format(checkingBalance));
        }
        else{
            System.out.println("Balance Cannot be Negative."+ "\n");
        }
    }

    public void getSavingDepositInput(){
        System.out.println("Saving Account Balance: "+ moneyFormat.format(savingsBalance));
        System.out.print("Amount you want to Deposit from Savings Account: ");
        double amount = input.nextDouble();

        if((savingsBalance+amount)>=0){
            calcSavingDeposit(amount);
            System.out.println("New Savings Account Balance: "+ moneyFormat.format(savingsBalance));
        }
        else{
            System.out.println("Balance Cannot be negative."+ "\n");
        }
    }
}
