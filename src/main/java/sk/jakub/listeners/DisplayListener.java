package sk.jakub.listeners;

import lombok.Getter;
import sk.jakub.classes.PVector;
import sk.jakub.classes.Segment;
import sk.jakub.gui.DisplayPanel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@Getter
public class DisplayListener extends MouseAdapter {

    private DisplayPanel displayPanel;

    public DisplayListener(DisplayPanel displayPanel) {
        super();
        this.displayPanel = displayPanel;
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        super.mouseMoved(e);
        this.displayPanel.mouseMovedCallback(e.getX(), e.getY());
    }
}
