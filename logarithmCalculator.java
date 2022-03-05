import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class logarithmCalculator implements ActionListener{
    private JFrame frame;
    private JLabel outputResult, logarithmText, equalsText;
    private JTextField baseInputField, numberInputField;
    private JButton submitDataButton;

    logarithmCalculator(){
        Font textFont = new Font("Times New Roman", Font.PLAIN, 30);

        baseInputField = new JTextField();
        baseInputField.setHorizontalAlignment(JTextField.CENTER);
        baseInputField.setFont(textFont);
        baseInputField.setBounds(130, 200, 70, 40);

        numberInputField = new JTextField();
        numberInputField.setFont(textFont);
        numberInputField.setHorizontalAlignment(JTextField.CENTER);
        numberInputField.setBounds(200, 160, 100, 40);

        submitDataButton = new JButton("Submit");
        submitDataButton.addActionListener(this);
        submitDataButton.setBackground(Color.white);
        submitDataButton.setFocusable(false);
        submitDataButton.setBounds(300, 300, 100, 50);

        outputResult = new JLabel();
        outputResult.setFont(textFont);
        outputResult.setBounds(370, 150, 200, 50);

        equalsText = new JLabel("=");
        equalsText.setFont(textFont);
        equalsText.setBounds(330, 150, 100, 50);

        logarithmText = new JLabel("log");
        logarithmText.setFont(textFont);
        logarithmText.setBounds(100, 150, 50, 50);

        frame = new JFrame("Logarithm Calculator");
        frame.setSize(new Dimension(700, 500));
        frame.setResizable(false);
        frame.setLayout(null);

        frame.add(logarithmText);
        frame.add(equalsText);
        frame.add(baseInputField);
        frame.add(numberInputField);
        frame.add(submitDataButton);
        frame.add(outputResult);
        frame.setVisible(true);
    }
    public boolean isInputNumber(String stringNumber){
        try{
            Integer number = Integer.parseInt(stringNumber);
        }catch(NumberFormatException ae){
            return false;
        }
        return true;
    }
    public Double calculateLogarithm(int base, int number){
        double logarithmResult = Math.log(number)/Math.log(base);
        return logarithmResult;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String baseString = baseInputField.getText();
        String numberString = numberInputField.getText();
        if(e.getSource() == submitDataButton){
            if(isInputNumber(baseString) && isInputNumber(numberString)){
                int base = Integer.parseInt(baseString);
                int logarithmNumber = Integer.parseInt(numberString);
                if(base <= 0 || logarithmNumber <=0 || base == 1){
                    JOptionPane.showMessageDialog(frame, "Invalid Input.");
                    baseInputField.setText("");
                    numberInputField.setText("");
                }
                outputResult.setText(""+calculateLogarithm(base, logarithmNumber));
            }else{
                JOptionPane.showMessageDialog(frame, "Input Numbers Only.");
                baseInputField.setText("");
                numberInputField.setText("");
            }
        }
    }
}
