package sk.jakub.classes;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Segment {
    private PVector a;
    private PVector b;
    private float angle;
    private float length;

    public Segment(PVector a, PVector b) {
        this.a = a;
        this.b = b;
    }

    public Segment(PVector a, float length, float angle) {
        this.a = a;
        this.length = length;
        this.angle = angle;
        this.b = calculateNewPVector(a, length, angle);
    }

    private PVector calculateNewPVector(PVector a, float length, float angle) {
        float tmpY = (float) (length * Math.sin(angle * (Math.PI / 180)));
        float tmpX = (float) (length * Math.cos(angle * (Math.PI / 180)));
        return new PVector(a.getX() + tmpX, a.getY() + tmpY);
    }

    private void calculateA(double angle) {
        float aX = (float) (this.b.getX() - (this.length * Math.cos(angle)));
        float aY = (float) (this.b.getY() - (this.length * Math.sin(angle)));

        this.a.setX(aX);
        this.a.setY(aY);
    }

    private void calculateB(double angle) {
        float bX = (float) (this.a.getX() - (this.length * Math.cos(angle)));
        float bY = (float) (this.a.getY() - (this.length * Math.sin(angle)));

        this.b.setX(bX);
        this.b.setY(bY);
    }

    public void follow(float reqX, float reqY) {
        float angle = (float) Math.atan2(reqY - this.a.getY(), reqX - this.a.getX());

        this.b.setX(reqX);
        this.b.setY(reqY);

        calculateA(angle);
    }

    public void holdFixed(float fixedX, float fixedY) {
        float angle = (float) Math.atan2(fixedY - this.b.getY(), fixedX - this.b.getX());

        this.a.setX(fixedX);
        this.a.setY(fixedY);

        calculateB(angle);
    }
}