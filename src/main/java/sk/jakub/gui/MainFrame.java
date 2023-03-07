package sk.jakub.gui;

import sk.jakub.listeners.DisplayListener;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private DisplayListener displayListener;
    private DisplayPanel displayPanel;
    private SelectionPanel selectionPanel;

    public MainFrame(String title) {
        super(title);
        setSize(1280, 720);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setFocusable(false);
        setLayout(new BorderLayout());

        loadComponents();

        setVisible(true);

        Dimension d = this.displayPanel.getSize();
        this.displayPanel.mouseMovedCallback((float) d.width / 2, 0);
    }

    private void loadComponents() {

        displayPanel = new DisplayPanel();
        displayListener = new DisplayListener(displayPanel);
        displayPanel.addDisplayListener(displayListener);
        selectionPanel = new SelectionPanel();

        this.add(BorderLayout.CENTER, this.displayPanel);
        this.add(BorderLayout.LINE_END, this.selectionPanel);
    }

}
