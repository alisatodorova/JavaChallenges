/**
Part 3: Enhance Part 1 and 2
Add an instance variable to the BankAccount class that represents the account number.
Modify the constructor of the BankAccount class so that it assigns the account number sequentially.
This means that the first BankAccount object will get account number 1,
the second BankAccount object will get account number 2, and so on.

Modify the class constructors and methods withdraw and deposit so that whenever that are executed
they add a String object describing the transaction to a global String object
that contains the descriptions of all the transaction so far.

* @author Alisa Todorova
*/
import java.util.*;
public class BankAccount2_1
{
    private double balance;
    private double fee;
    //fixed number of free monthly transactions (deposits and withdrawals)
    final int FREE_TRANSACTIONS = 3;
    //counter to keep track of the monthly transactions
    private int count = 0;
    //the account number
    private int accountNumber;
    //the next account number
    private static int nextAccountNumber = 0;
    //global String object that contains the descriptions of all the transaction so far
    public static String log = "";

    /**
     * Creates a bank account with an initial balance.
     *
     * @param initialBalance the initial balance
     */
    public BankAccount2_1(double initialBalance)
    {
        balance = initialBalance;
        nextAccountNumber++;
        accountNumber = nextAccountNumber;
        log = "BankAccount " + accountNumber + ":\n";
    }

    /**
     * Deposits money into the bank account.
     *
     * @param amount the amount to deposit
     */
    public void deposit(double amount)
    {
        double newBalance = balance + amount;
        balance = newBalance;
        count++;
        log = log + "deposit " + amount + " euros \n";
    }

    /**
     * Withdraws money from the bank account.
     *
     * @param amount the amount to withdraw
     */
    public void withdraw(double amount)
    {
        double newBalance = balance - amount;
        balance = newBalance;
        count++;
        log = log + "withdraw " + amount + " euros \n";
    }

     /**
     * Gets the current balance.
     *
     * @return the balance
     */
    public double getBalance()
    {
        return balance;
    }

    /**
     * Gets the fee.
     *
     * @return the fee
     */
    public double getFee()
    {
        return fee;
    }

    /**
     * Sets the fee.
     *
     * @param fee the fee to be charged
     */
    public void setFee(double fee)
    {
        this.fee = fee;
    }

     /**
     * Deducts monthly charge for transactions exceeding free allotment 
     * and resets the transactions count.
     *
     */
    public void deductMonthlyCharge()
    {
        if(count > FREE_TRANSACTIONS)
        {
            int exceeds = count - FREE_TRANSACTIONS;

            balance = balance - (exceeds * fee);

            log = log + "monthly charge amounts to " + (exceeds * fee) + " euros \n";

            count = 0;
        }
    }

     /**
     * Prints the global String object log 
     * that contains the descriptions of all the transactions.
     * Then resets the log for the new object.
     *
     */
    public void displayLog()
    {
        System.out.print(log);
        log = "";
    }


    public static void main (String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter your bank's fee: ");
        double fee = in.nextDouble();
        in.close();

        //Create 4 BankAccount2_1 objects to test
        //if the displayLog method is computed correctly

        BankAccount2_1 bank1 = new BankAccount2_1(500);
        System.out.println("Your current balance is " + bank1.getBalance());
        bank1.setFee(fee); //fee is set based on user's input
        bank1.withdraw(100);
        bank1.deposit(30);
        bank1.withdraw(200);
        bank1.deposit(40);
        bank1.deductMonthlyCharge();
        bank1.displayLog();
        System.out.println("After the transactions your current balance is " + bank1.getBalance());
        System.out.println();

        BankAccount2_1 bank2 = new BankAccount2_1(1000);
        System.out.println("Your current balance is " + bank2.getBalance());
        bank2.setFee(fee); //fee is set based on user's input
        bank2.withdraw(500);
        bank2.deposit(55);
        bank2.withdraw(100);
        bank2.deposit(202);
        bank2.withdraw(50);
        bank2.deposit(321);
        bank2.deposit(5);
        bank2.deductMonthlyCharge();
        bank2.displayLog();
        System.out.println("After the transactions your current balance is " + bank2.getBalance());
        System.out.println();

        BankAccount2_1 bank3 = new BankAccount2_1(123.25);
        System.out.println("Your current balance is " + bank3.getBalance());
        bank3.setFee(fee); //fee is set based on user's input
        bank3.withdraw(110);
        bank3.deposit(10.11);
        bank3.deductMonthlyCharge();
        bank3.displayLog();
        System.out.println("After the transactions your current balance is " + bank3.getBalance());
        System.out.println();

        BankAccount2_1 bank4 = new BankAccount2_1(402);
        System.out.println("Your current balance is " + bank4.getBalance());
        bank4.setFee(fee); //fee is set based on user's input
        bank4.withdraw(110);
        bank4.deposit(10);
        bank4.deposit(450);
        bank4.deductMonthlyCharge();
        bank4.displayLog();
        System.out.println("After the transactions your current balance is " + bank4.getBalance());
        System.out.println();
    }
}