package view;

import net.miginfocom.layout.CC;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;

/**
 * Created View
 */
public class ViewForm {

    private JFrame jFrame;
    private JPanel jPanel;
    private JLabel buyDateLabel;
    private JLabel amountLabel;
    private JLabel resultLabel;
    private JLabel formatDate;
    private JTextField buyDateField;
    private JTextField amountField;
    private JTextField profitLossField;
    private JButton calculateButton;
    private JOptionPane jOptionPane;

    public JOptionPane getjOptionPane() {
        return jOptionPane;
    }

    public void setjOptionPane(JOptionPane jOptionPane) {
        this.jOptionPane = jOptionPane;
    }

    /**
     * View Constructor
     *
     * @param title title used for the frame
     */

    public ViewForm(String title) {
        jOptionPane = new JOptionPane();
        /*Create Frame*/
        jFrame = new JFrame(title);
        jPanel = new JPanel(new MigLayout());
        jFrame.setPreferredSize(new Dimension(300, 150));
        jFrame.setResizable(false);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /*Create UI elements*/
        buyDateLabel = new JLabel("Enter the date of purchase: ");
        amountLabel = new JLabel("Enter amount in USD: ");
        buyDateField = new JTextField(10);
        formatDate = new JLabel("YYYY-MM-DD");
        formatDate.setForeground(SystemColor.LIGHT_GRAY);
        buyDateField.setToolTipText("YYYY-MM-DD");
        amountField = new JTextField(10);
        resultLabel = new JLabel("Calculation of profit/loss");
        profitLossField = new JTextField(10);
        profitLossField.setEditable(false);
        calculateButton = new JButton("Recalculate");

        CC componentConstraints = new CC();
        componentConstraints.alignX("center").spanX();

        /*Add elements to panel*/
        jPanel.add(buyDateLabel);
        jPanel.add(buyDateField, "wrap");
        jPanel.add(formatDate, "wrap, skip");
        jPanel.add(amountLabel);
        jPanel.add(amountField, "wrap");
        jPanel.add(resultLabel);
        jPanel.add(profitLossField, "wrap");
        jPanel.add(calculateButton, componentConstraints);

        jFrame.add(jPanel);
        jFrame.pack();
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
    }

    public JFrame getjFrame() {
        return jFrame;
    }

    public JPanel getjPanel() {
        return jPanel;
    }

    public JLabel getBuyDateLabel() {
        return buyDateLabel;
    }

    public JLabel getAmountLabel() {
        return amountLabel;
    }

    public JLabel getResultLabel() {
        return resultLabel;
    }

    public JLabel getFormatDate() {
        return formatDate;
    }

    public JTextField getBuyDateField() {
        return buyDateField;
    }

    public JTextField getAmountField() {
        return amountField;
    }

    public JTextField getProfitLossField() {
        return profitLossField;
    }

    public JButton getCalculateButton() {
        return calculateButton;
    }

}
