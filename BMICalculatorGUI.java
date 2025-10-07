import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BMICalculatorGUI {
    public static void main(String[] args) {
        // Create the frame (main window)
        JFrame frame = new JFrame("BMI Calculator");
        frame.setSize(350, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null); // center window

        // Create labels and input fields
        JLabel title = new JLabel("BMI Calculator", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 18));
        title.setBounds(80, 10, 180, 30);
        frame.add(title);

        JLabel weightLabel = new JLabel("Weight (kg):");
        weightLabel.setBounds(30, 60, 100, 25);
        frame.add(weightLabel);

        JTextField weightField = new JTextField();
        weightField.setBounds(140, 60, 150, 25);
        frame.add(weightField);

        JLabel heightLabel = new JLabel("Height (m):");
        heightLabel.setBounds(30, 90, 100, 25);
        frame.add(heightLabel);

        JTextField heightField = new JTextField();
        heightField.setBounds(140, 90, 150, 25);
        frame.add(heightField);

        JButton calcButton = new JButton("Calculate BMI");
        calcButton.setBounds(90, 130, 150, 30);
        frame.add(calcButton);

        JLabel resultLabel = new JLabel("", SwingConstants.CENTER);
        resultLabel.setBounds(30, 170, 280, 25);
        frame.add(resultLabel);

        // Add button functionality
        calcButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double weight = Double.parseDouble(weightField.getText());
                    double height = Double.parseDouble(heightField.getText());

                    double bmi = weight / (height * height);
                    String category;

                    if (bmi < 18.5)
                        category = "Underweight";
                    else if (bmi < 25)
                        category = "Normal weight";
                    else if (bmi < 30)
                        category = "Overweight";
                    else
                        category = "Obesity";

                    resultLabel.setText(String.format("BMI: %.2f  →  %s", bmi, category));

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(frame, "Please enter valid numbers for weight and height!");
                }
            }
        });

        // Make the frame visible
        frame.setVisible(true);
    }
}
