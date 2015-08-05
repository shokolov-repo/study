package dz2.circle;

/**
 * Created by dmitriy on 8/2/15.
 */
public class Circle {
    private int x;
    private int y;
    private int radius;

    public Circle(int x, int y, int radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public void move(int dx, int dy) {
        this.x += dx;
        this.y += dy;
    }

    public boolean containsPoint(int x, int y) {
        return this.radius >= calculateDistanseFromCentre(x, y);

    }

    public boolean containsCircle(int x, int y, int radius) {
        return this.radius >= calculateDistanseFromCentre(x, y) + radius;
    }

    public void print() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Coordinates of centre are " + x + "," + y + "; radius is " + radius;
    }


    private double calculateDistanseFromCentre(int x, int y) {
        return Math.sqrt((this.x - x) * (this.x - x) + (this.y - y) * (this.y - y));
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }
}
