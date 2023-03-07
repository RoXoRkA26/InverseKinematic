package sk.jakub.gui;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class SelectionPanel extends JPanel {

    JPanel inputPanel = new JPanel(new GridLayout(2, 2));
    JTextField inputField = new JTextField();
    JButton addButton = new JButton("Add");

    public SelectionPanel() {
        super();
        setBackground(Color.BLUE);
        setLayout(new BorderLayout());
        loadComponents();
    }

    private void loadComponents() {
        inputPanel.add(new JLabel("Length [px]:"));
        inputPanel.add(inputField);
        inputPanel.add(new JPanel());
        addButton.setFocusable(false);
        inputPanel.add(addButton);
        this.add(BorderLayout.PAGE_START, inputPanel);
    }

}
