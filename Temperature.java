package rezwanul.temparature;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Temperature {

    public static void main(String[] args) {
        Temp_Converter gui = new Temp_Converter(); 
        gui.createApp();
    }
}

class Temp_Converter implements ActionListener {

    JFrame frame;
    Container c;
    JLabel label1, label2, label3, label4;
    JTextField tf1, tf2;
    JComboBox comboBox1, comboBox2;
    JButton convert, clear, n1, n2;

    public void createApp() {

        frame = new JFrame();
        frame.setBounds(250,150, 290, 450);
        frame.setResizable(false);

        c = frame.getContentPane();
        c.setLayout(null);

        label1 = new JLabel();
        label1.setText("Enter a value");
        label1.setBounds(10, 10, 120, 30);

        tf1 = new JTextField();
        tf1.setBounds(10, 40, 120, 30);

        label2 = new JLabel();
        label2.setText("From");
        label2.setBounds(140, 10, 120, 30);

        String[] from = {"Celsius","Kelvin", "Fahrenheit"};
        comboBox1 = new JComboBox(from);
        comboBox1.setBounds(140, 40, 120, 30);

        label3 = new JLabel();
        label3.setText("Converted value");
        label3.setBounds(10, 80, 120, 30);

        tf2 = new JTextField();
        tf2.setBounds(10, 110, 120, 30);
        tf2.setEditable(false);

        label4 = new JLabel();
        label4.setText("To");
        label4.setBounds(140, 80, 120, 30);

        String[] to = {"Celsius","Kelvin", "Fahrenheit"};
        comboBox2 = new JComboBox(to);
        comboBox2.setBounds(140, 110, 120, 30);

        convert = new JButton();
        convert.setText("Convert");
        convert.setBounds(10, 150, 120, 30);
        convert.addActionListener(this);

        clear = new JButton();
        clear.setText("Clear");
        clear.setBounds(140, 150, 120, 30);
        clear.addActionListener(this);

        n1 = new JButton("1");
        n1.setBounds(10, 190, 50, 50);
        n1.addActionListener(this);

        n2 = new JButton("2");
        n2.setBounds(70, 190, 50, 50);
        n2.addActionListener(this);

        c.add(label1);
        c.add(tf1);
        c.add(label2);
        c.add(comboBox1);
        c.add(label3);
        c.add(tf2);
        c.add(label4);
        c.add(comboBox2);
        c.add(convert);
        c.add(clear);
        c.add(n1);
        c.add(n2);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == convert) {
            try {
                double value = Double.parseDouble(tf1.getText());
                double result = 0.0;

                if (comboBox1.getSelectedIndex() == 0 && comboBox2.getSelectedIndex() == 2) {
                    result = (value * 9 / 5.0) + 32;
                } else if (comboBox1.getSelectedIndex() == 0 && comboBox2.getSelectedIndex() == 1) {
                    result = value + 273.15;
                }
                tf2.setText(Double.toString(result));
            } catch (NumberFormatException ex) {
                tf2.setText("Invalid input");
            }
        } else if (e.getSource() == clear) {
            tf1.setText("");
            tf2.setText("");
        } else if (e.getSource() == n1) {
            tf1.setText(tf1.getText() + "1");
        } else if (e.getSource() == n2) {
            tf1.setText(tf1.getText() + "2");
        }
    }
}
