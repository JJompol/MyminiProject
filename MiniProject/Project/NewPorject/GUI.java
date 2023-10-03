package Project.NewPorject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame{
    private JTextField salaryField;
    private JTextField totalIncomeField;
    private JTextField expensesField;
    private JTextField deductionsField;
    
    public GUI() {
        // สร้าง UI
        setTitle("ระบบคำนวณภาษี");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 2));

        JLabel salaryLabel = new JLabel("ใส่เงินเดือน:");
        salaryField = new JTextField();
        JLabel totalIncomeLabel = new JLabel("ใส่เงินได้ทั้งหมด:");
        totalIncomeField = new JTextField();
        JLabel expensesLabel = new JLabel("ใส่รายจ่าย:");
        expensesField = new JTextField();
        JLabel deductionsLabel = new JLabel("ใส่ค่าลดหย่อนภาษี:");
        deductionsField = new JTextField();
        // สร้างปุ่มคำนวณ
        JButton calculateButton = new JButton("คำนวณ");
        calculateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double salary = Double.parseDouble(salaryField.getText());
                double totalIncome = Double.parseDouble(totalIncomeField.getText());
                double expenses = Double.parseDouble(expensesField.getText());
                double deductions = Double.parseDouble(deductionsField.getText());

                double netIncome = totalIncome - expenses - deductions;

                Calculator taxCalculator = new Calculator();
                double progressiveTax = taxCalculator.calculateProgressiveTax(netIncome);
                double flatTax = taxCalculator.FlatTax(totalIncome,salary);
                
                String taxComparisonResult = Comparison.compareTaxes(progressiveTax,flatTax);

                String result = "\n \tภาษีแบบขั้นบันได: " + (progressiveTax) + " บาท \n \n \tภาษีแบบเหมา: " + 
                (flatTax) + " บาท\n \n" + "\t" + taxComparisonResult;
                
                //JFrame2
                JFrame resultFrame = new JFrame("ผลลัพธ์");
                resultFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                resultFrame.setSize(375, 160);
                //สร้าง JTextArea ให้ข้อความขึ้นบรรทัดใหม่
                JTextArea resultTextArea = new JTextArea(result);
                resultTextArea.setWrapStyleWord(true);
                resultTextArea.setLineWrap(true);
                resultTextArea.setOpaque(false);
                resultTextArea.setEditable(false);

                resultFrame.add(resultTextArea);
                resultFrame.setVisible(true);
                
            }
        });
        panel.add(salaryLabel);
        panel.add(salaryField);
        panel.add(totalIncomeLabel);
        panel.add(totalIncomeField);
        panel.add(expensesLabel);
        panel.add(expensesField);
        panel.add(deductionsLabel);
        panel.add(deductionsField);
        panel.add(new JLabel()); // Blank label for layout
        panel.add(calculateButton);

        add(panel);
        setVisible(true);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new GUI();
            }
        });
    }
}