package sk.jakub.gui;

import lombok.Getter;
import sk.jakub.classes.PVector;
import sk.jakub.classes.Segment;
import sk.jakub.classes.Structure;
import sk.jakub.listeners.DisplayListener;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;

public class DisplayPanel extends JPanel {

    @Getter
    private Structure structure;

    public DisplayPanel() {
        super();
        setBackground(new Color(25, 25, 25));
        structure = new Structure();

        for (int i = 0; i < 5; i++) {
            structure.addSegment(new Segment(new PVector(10 * i, 10 * i), 150, 0));
        }
    }

    public void addDisplayListener(DisplayListener dl) {
        if (dl != null) {
            this.addMouseListener(dl);
            this.addMouseMotionListener(dl);
            System.out.println("DisplayListener added [" + dl.hashCode() + "]");
        } else {
            System.out.println("Adding DisplayListener failed");
        }
    }

    public void mouseMovedCallback(float reqX, float reqY) {
        Dimension d = getSize();
        structure.calculateMove(reqX, reqY, (float) d.width / 2, (float) d.height / 2);
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        g2.setColor(Color.WHITE);
        g2.setStroke(new BasicStroke(10));
//        g2.draw(new Line2D.Float(ax, ay, bx, by));

        for (int i = 0; i < structure.getStructure().size(); i++) {
//            g2.setStroke(new BasicStroke(structure.getStructure().size() - i));
//            g2.setStroke(new BasicStroke(20 - (float) (i / 10)));
            Segment s = structure.getStructure().get(i);
            g2.draw(new Line2D.Float(s.getA().getX(), s.getA().getY(), s.getB().getX(), s.getB().getY()));
        }

//        for (Segment s : this.structure.getStructure()) {
//            g2.draw(new Line2D.Float(s.getA().getX(), s.getA().getY(), s.getB().getX(), s.getB().getY()));
//        }
    }
}
