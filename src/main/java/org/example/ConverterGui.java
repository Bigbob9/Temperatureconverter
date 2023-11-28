package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConverterGui {

    Converter converter = new Converter();


    JFrame frame;
    JPanel westPanel;


    JPanel centerGrid;

    JLabel title;

    JButton convert;

    JTextField celsius;
    JTextField fahrenheit;

    JTextField celsiusResult;
    JTextField fahrenheitResult;
    public void go(){

        frame = new JFrame("TemperatureConverter");
        title = new JLabel("TemperatureConverter");
        westPanel = new JPanel();
        westPanel.setLayout(new BoxLayout(westPanel, BoxLayout.Y_AXIS));


        centerGrid = new JPanel();
        centerGrid.setLayout(new GridLayout(2,2));




        frame.getContentPane().add(BorderLayout.NORTH, title);
        frame.getContentPane().add(BorderLayout.WEST, westPanel);
        frame.getContentPane().add(BorderLayout.CENTER, centerGrid);  // retrospectively Instead of centerPanel with Boxlayout Y, the centerGrid with Gridlayout inserted


        celsius = new JTextField(3);
        fahrenheit = new JTextField(3);
        celsiusResult = new JTextField(5);
        fahrenheitResult = new JTextField(5);

        convert = new JButton("Convert");
        convert.addActionListener(new convertListener());

        centerGrid.add(fahrenheit);                                       // retrospectively
        centerGrid.add(fahrenheitResult);                                 // retrospectively
        centerGrid.add(celsius);                                          // retrospectively
        centerGrid.add(celsiusResult);                                    // retrospectively

        westPanel.add(new JLabel("Fahrenheit"));
        westPanel.add(new JLabel("Celsius"));




        frame.getContentPane().add(BorderLayout.SOUTH, convert);



        frame.setVisible(true);
        frame.setSize(500,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public float getCelsius(){
        return Float.parseFloat(celsius.getText());
    }
    public float getFahrenheit(){
        return Float.parseFloat(fahrenheit.getText());
    }
    public void setCelsiusResult(String c){
        celsiusResult.setText(c);
    }

    public void setFahrenheitResult(String f){
        fahrenheitResult.setText(f);
    }
    private class convertListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String  c = String.valueOf(converter.convertFtoC(getFahrenheit()));
            String f = String.valueOf(converter.convertCtoF(getCelsius()));

            setCelsiusResult(c);
            setFahrenheitResult(f);


        }
    }
}
