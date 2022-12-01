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
public class Converter
{

    //1 EUR is equal to 1.18 USD
    private static final double EUR_TO_USD = 1.18;
    //1 GBP is equal to 1.32 USD
    private static final double GBP_TO_USD = 1.32;
    //1 GBP is equal to 1.12 EUR
    private static final double GBP_TO_EUR = 1.12;

    /**
     * Converts from one currency to another.
     *
     * @param amount the amount the user wants to convert
     * @param convertFrom the initial type of currency
     * @param converrtTo the currency the user wants
     * @return the amount of the converted currency
     */
    public static double convertCurrency(double amount, CurrencyType convertFrom, CurrencyType convertTo)
    {
        if((convertFrom == CurrencyType.EUR) && (convertTo == CurrencyType.GBP))
        {
            return amount / GBP_TO_EUR;
        }

        if((convertFrom == CurrencyType.EUR) && (convertTo == CurrencyType.USD))
        {
            return amount * EUR_TO_USD;
        }

        if((convertFrom == CurrencyType.GBP) && (convertTo == CurrencyType.USD))
        {
            return amount * GBP_TO_USD;
        }

        if((convertFrom == CurrencyType.GBP) && (convertTo == CurrencyType.EUR))
        {
            return amount * GBP_TO_EUR;
        }

        if((convertFrom == CurrencyType.USD) && (convertTo == CurrencyType.EUR))
        {
            return amount / EUR_TO_USD;
        }

        if((convertFrom == CurrencyType.USD) && (convertTo == CurrencyType.GBP))
        {
            return amount / GBP_TO_USD;
        }

        else
        {
            return amount;
        }
    }
}
