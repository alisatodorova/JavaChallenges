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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConverterViewer
{

    public ConverterViewer()
    {
        JFrame frame = new JFrame();
        frame.setSize(350, 300);
        frame.setTitle("Currency Converter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();

        JLabel label1 = new JLabel("Enter amount to be converted:");
        TextField input = new TextField(30);

        JLabel label2 = new JLabel("Convert from:");
        JComboBox comboBox1 = new JComboBox();
        comboBox1.addItem("EUR");
        comboBox1.addItem("GBP");
        comboBox1.addItem("USD");

        JLabel label3 = new JLabel("Convert to:");
        JComboBox comboBox2 = new JComboBox();
        comboBox2.addItem("EUR");
        comboBox2.addItem("GBP");
        comboBox2.addItem("USD");

        JButton button = new JButton("Convert");

        JLabel label4 = new JLabel("Result: ");
        TextField output = new TextField(30);


        /**
         * An action listener that prints a message.
         */
        class ClickListener implements ActionListener
        {

            /**
             * Invoked when an action occurs.
             *
             * @param event the event that is occuring.
             */
            public void actionPerformed(ActionEvent event)
            {
                try
                {
                    double amount = Double.parseDouble(input.getText());

                    CurrencyType convertFrom = CurrencyType.valueOf((String) comboBox1.getSelectedItem());
                    CurrencyType convertTo = CurrencyType.valueOf((String) comboBox2.getSelectedItem());

                    //Display a warning if the user does not choose different currencies.
                    if(convertFrom == convertTo)
                    {
                        JOptionPane.showMessageDialog(null, "Error! Can't convert same currency!\nBoth currencies need to be different!");
                    }

                    else
                    {
                        //Performing the conversion
                        double result = Converter.convertCurrency(amount, convertFrom, convertTo);

                        //Rounding the result
                        String resultAsText = String.valueOf(result);

                        //Set the result as a text in label
                        output.setText(resultAsText);
                    }

                }
                catch (Exception e)
                {
                    JOptionPane.showMessageDialog(null, "Error! Invalid input amount!");
                }
            }
        }

        ActionListener listener = new ClickListener();
        button.addActionListener(listener);

        panel.add(label1, BorderLayout.NORTH);
        panel.add(input, BorderLayout.NORTH);
        panel.add(label2, BorderLayout.WEST);
        panel.add(comboBox1, BorderLayout.WEST);
        panel.add(label3, BorderLayout.EAST);
        panel.add(comboBox2, BorderLayout.EAST);
        panel.add(button, BorderLayout.SOUTH);
        panel.add(label4, BorderLayout.SOUTH);
        panel.add(output, BorderLayout.SOUTH);

        frame.add(panel);
        frame.setVisible(true);

    }

    public static void main(String[] args)
    {

        new ConverterViewer();

    }
}
