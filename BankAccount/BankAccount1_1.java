/**
Part 1: Charging a fee for every deposit and withdrawal.
Supply a mechanism for setting the fee and modify the deposit and withdraw methods,
so that the fee is levied. 

* @author Alisa Todorova
*/
import java.util.*;
public class BankAccount1_1
{
    private double balance;
    private double fee;

    /**
     * Creates a bank account with an initial balance.
     *
     * @param initialBalance the initial balance
     */
    public BankAccount1_1(double initialBalance)
    {
        balance = initialBalance;
    }

    /**
     * Deposits money into the bank account.
     * Charges a fee for every deposit.
     *
     * @param amount the amount to deposit
     */
    public void deposit(double amount)
    {
        double newBalance = (balance + amount) - fee;
        balance = newBalance;
    }

    /**
     * Withdraws money from the bank account.
     * Charges a fee for every withdraw.
     *
     * @param amount the amount to withdraw
     */
    public void withdraw(double amount)
    {
        double newBalance = balance - amount - fee;
        balance = newBalance;
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

    public static void main (String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter your bank's fee: ");
        double fee = in.nextDouble();
        in.close();

        //Create 3 BankAccount1_1 objects to test
        //if the fee is computed correctly

        BankAccount1_1 bank1 = new BankAccount1_1(500);
        System.out.println("Your current balance is " + bank1.getBalance());
        bank1.setFee(fee); //fee is set based on user's input
        bank1.withdraw(100);
        bank1.deposit(30);
        System.out.println("After the transactions your current balance is " + bank1.getBalance());

        BankAccount1_1 bank2 = new BankAccount1_1(1000);
        System.out.println("Your current balance is " + bank2.getBalance());
        bank2.setFee(fee); //fee is set based on user's input
        bank2.withdraw(500);
        bank2.deposit(55.55);
        System.out.println("After the transactions your current balance is " + bank2.getBalance());

        BankAccount1_1 bank3 = new BankAccount1_1(123.25);
        System.out.println("Your current balance is " + bank3.getBalance());
        bank3.setFee(fee); //fee is set based on user's input
        bank3.withdraw(110);
        bank3.deposit(10.11);
        System.out.println("After the transactions your current balance is " + bank3.getBalance());

    }
}