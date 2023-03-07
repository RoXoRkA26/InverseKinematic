package sk.jakub.classes;

import lombok.Getter;

import java.util.ArrayList;

public class Structure {

    @Getter
    private ArrayList<Segment> structure;

    public Structure() {
        this.structure = new ArrayList<>();
    }

    public void addSegment(Segment s) {
        this.structure.add(s);
    }

    public void calculateMove(float reqX, float reqY, float fixedX, float fixedY) {
        int sz = structure.size();

        for (int i = sz - 1; i >= 0; i--) {
            if (i == (sz - 1)) {
                Segment s = structure.get(i);
                s.follow(reqX, reqY);
            } else {
                Segment sOld = structure.get(i + 1);
                Segment s = structure.get(i);
                s.follow(sOld.getA().getX(), sOld.getA().getY());
            }
        }

        for (int i = 0; i < sz; i++) {
            if (i == 0) {
                Segment s = structure.get(i);
                s.holdFixed(fixedX, fixedY);
            } else {
                Segment s = structure.get(i);
                Segment sOld = structure.get(i - 1);
                s.holdFixed(sOld.getB().getX(), sOld.getB().getY());
            }
        }

    }

}
