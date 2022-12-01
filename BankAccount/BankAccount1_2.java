/**
Part 2: 
The bank will allow a fixed number of free transactions (deposits and withdrawals) every month,
and charge for transactions exceeding the free allotment.
The charge is not levied immediately but at the end of the month.

* @author Alisa Todorova
*/
import java.util.*;
public class BankAccount1_2
{
    private double balance;
    private double fee;
    //fixed number of free monthly transactions (deposits and withdrawals)
    final int FREE_TRANSACTIONS = 3;
    //counter to keep track of the monthly transactions
    private int count = 0;

    /**
     * Creates a bank account with an initial balance.
     *
     * @param initialBalance the initial balance
     */
    public BankAccount1_2(double initialBalance)
    {
        balance = initialBalance;
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

            count = 0;
        }
    }


    public static void main (String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter your bank's fee: ");
        double fee = in.nextDouble();
        in.close();

        //Create 3 BankAccount1_2 objects to test
        //if the deductMonthlyCharge method is computed correctly

        BankAccount1_2 bank1 = new BankAccount1_2(500);
        System.out.println("Your current balance is " + bank1.getBalance());
        bank1.setFee(fee); //fee is set based on user's input
        bank1.withdraw(100);
        bank1.deposit(30); 
        bank1.withdraw(200);
        bank1.deposit(40);
        bank1.deductMonthlyCharge();
        System.out.println("After the transactions your current balance is " + bank1.getBalance());

        BankAccount1_2 bank2 = new BankAccount1_2(1000);
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
        System.out.println("After the transactions your current balance is " + bank2.getBalance());

        BankAccount1_2 bank3 = new BankAccount1_2(123.25);
        System.out.println("Your current balance is " + bank3.getBalance());
        bank3.setFee(fee); //fee is set based on user's input
        bank3.withdraw(110);
        bank3.deposit(10.11);
        bank3.deductMonthlyCharge();
        System.out.println("After the transactions your current balance is " + bank3.getBalance());

    }
}