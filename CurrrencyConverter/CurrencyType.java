/**
Write a program with a graphical interface
that allows the user to convert an amount of money between
U.S. dollars (USD), euros (EUR), and British  pounds (GBP).
The user interface should have the following elements:
a text box to enter the amount to be converted,
two combo boxes to allow the user to select the currencies,
a button to make the conversion, and a label to show the result.
Display a warning if the user does not choose different currencies.
Use the following conversion rates:
•1 EUR is equal to 1.18 USD
•1 GBP is equal to 1.32 USD
•1 GBP is equal to 1.12 EUR

* @author Alisa Todorova
*/

/**
 * The type of currencies
 * the user can convert from and to.
 */
public enum CurrencyType
{
    EUR, GBP, USD
}
