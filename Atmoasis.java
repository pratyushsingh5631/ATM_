import java.util.Scanner;
import java.time.LocalDateTime; // import the LocalDateTime class

public class Atmoasis {
    public static void main(String[] args){

    try (Scanner sc = new Scanner(System.in)) {
    int pin=1234, option, enteredPin, count=0, amount=1;
   float balance = 50000;
   int continueTransc = 1;
   
   // time_t now;
   // time(&now);
   System.out.println("\n");
   LocalDateTime myObj = LocalDateTime.now();
   System.out.println(myObj);
   System.out.println("\n\t\t\t=====================*WELCOME TO YOURS' ATM*=====================");
   System.out.println("\n\t\t\t\t\t\tPlease enter your pin : ");
   enteredPin=sc.nextInt();

   while(pin!= enteredPin)
   {
            System.out.println("\n\t\t\t\t\t\tPlease enter your pin : ");
            enteredPin=sc.nextInt();
            if(enteredPin != pin)
            {
               // Beep(610,500); //freq. , duration
                System.out.println("invalid pin!!!");
            }
            count++;
            if(count==2 && pin != enteredPin)
            {
                System.exit(0);
            }
   }
            while(continueTransc != 0)
   {
            System.out.println("\n\t\t\t=====================*Available Transcaction*=====================");
            System.out.println("\n\n\t\t1.Withdrawal");
            System.out.println("\n\t\t2.Deposit");
            System.out.println("\n\t\t3.Check balance");
            System.out.println("\n\t\t4.Transfer");
            System.out.println("\n\t Please select the option: ");
            option=sc.nextInt();
            switch(option)
            {
              case 1: 
                while(amount % 500 !=0)
                {
                    System.out.println("\n\tEnter the amount : ");
                    amount=sc.nextInt();
                    if(amount % 500 !=0)
                    System.out.println("\n\t The amount should be a multiple of 500.");
                }
                if(balance < amount)
                {
                    System.out.println("\n\t Sorry insufficient balance.");
                    amount = 1;
                    break;
                }
                else{
                    balance-=amount;
                    System.out.println("\n\t You have withdrawn Rs. " + amount+" Your new balance is "+balance);
                    amount=1;
                    break;
                }
                
              case 2:
              System.out.println("\n\tEnter the amount :");
              amount=sc.nextInt();
              balance += amount;
              System.out.println("\n\t You have deposited Rs."+ amount+"Your new balance is ."+balance);
              System.out.println("\n\t\t\t=====================*THANK YOU FOR BANKING WITH US*=====================");
              amount=1;
              break;  
             
              case 3:
               System.out.println("\n\t Your  balance is Rs. "+balance);
               break;

               case 4:
                        System.out.println("\n\tEnter the amount to transfer: ");
                        int transferAmount = sc.nextInt();
                        if (transferAmount > balance) {
                            System.out.println("\n\tSorry, insufficient balance for transfer.");
                            break;
                        }
                        System.out.println("\n\tEnter the account number to transfer to: ");
                        String accountNumber = sc.next();
                        // Perform transfer logic here
                        System.out.println("\n\tTransfer of Rs. " + transferAmount + " to account " + accountNumber + " successful!");
                        balance -= transferAmount;
                        break;
               
              default:
               // Beep(610,500); //freq. , duration
              System.out.println("INVALID OPTION");
            
            }
            
            System.out.println("\n\t\t\tDo you wish to continue Transcaction? \n\t\t\t1[YES] 0[NO]");
            continueTransc=sc.nextInt();
            }
        } 
    }
    
}