import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Scanner;

public class optionMenu extends Account {
    Scanner menuInput = new Scanner(System.in);
    DecimalFormat moneyFormat = new DecimalFormat(" '$' ####,##0.00"); // format of money we have

    HashMap<Integer,Integer> data = new HashMap<Integer,Integer>(); //mapping account no. nd pin

    public void getLogin() throws IOException{
        int x=1;
        do{
            try{
                data.put(952141,191904); // key pts to customer no. nd 2nd is pin
                data.put(989947,71976);

                System.out.println("Welcome to ATM project!");
                System.out.println("Enter your customer Number");
                setCustomerNumber(menuInput.nextInt());

                System.out.println("Enter your PIN number:");
                setPinNumber(menuInput.nextInt());
            } catch(Exception e){
                System.out.println("\n"+"Invalid Character(s). Only Numbers."+"\n");
                x=2;
            }
            int cn = getCustomerNumber();
            int pn = getPinNumber();
            if(data.containsKey(cn) && data.get(cn)==pn){
                getAccountType();
            }
            else{
                System.out.println("\n"+"Wrong Customer Number or Pin Number"+"\n");
            }
        }while(x==1);
    }
    public void getAccountType(){
        System.out.println("Select the account you want to Access: ");
        System.out.println("Type 1 - Checking Account");
        System.out.println("Type 2 - Savings Account");
        System.out.println("Type 3 - Exit");
        
        int selection = menuInput.nextInt();
        switch(selection){
          case 1:
             getChecking();
             break;
          case 2:
             getSaving();
             break;
          case 3: 
             System.out.println("Thank you for using this ATM, have a Good Day. \n");   
             break;
            
        }
    }
    public void getChecking(){
        System.out.println("Checking Account : ");
        System.out.println("Type 1 - View Balance");
        System.out.println("Type 2 - Withdraw Balance");
        System.out.println("Type 3 - Deposit Funds");
        System.out.println("Type 4 - Exit");
        System.out.println("Choice : ");

        int selection = menuInput.nextInt();

        switch(selection){
            case 1:
                System.out.println("Checking Account Balance: "+ moneyFormat.format(getCheckingBalance()));
                getAccountType();
                break;
            case 2:
                getCheckingWithdrawInput();
                getAccountType();
                break;
            case 3:
                getCheckingDepositInput();
                getAccountType();
                break;
            case 4:
                System.out.println("Thank you for using this ATM,have a Good day."+"\n");
                getChecking(); 
            default :
                System.out.println("\n"+"Invalid Choice"+"\n");
                getChecking();
        }
    }
    public void getSaving(){
        System.out.println("Savings Account :");
        System.out.println("Type 1 - View Balance ");
        System.out.println("Type 2 - Withdraw Funds ");
        System.out.println("Type 3 - Deposit Funds ");
        System.out.println("Type 4 - Exit ");
        System.out.println("Choice");

        int selection = menuInput.nextInt();

        switch(selection){
            case 1:
                System.out.println("Savings Account Balance: "+ moneyFormat.format(getSavingBalance()));
            case 2:
                getSavingWithdrawInput();
                getAccountType();
                break;
            case 3:
                getSavingDepositInput();
                getAccountType();
                break;
            case 4:
                System.out.println("Thank you for usinig this ATM,have a good day");
                break;
            default :
            System.out.println("\n"+"Invalid Choice"+"\n");
            getChecking();
        }
    }
}
