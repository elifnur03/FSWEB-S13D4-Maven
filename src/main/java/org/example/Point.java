package org.example;

public class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // Getter ve Setter
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

    // Distance overloading metodları
    public double distance() {
        return distance(0, 0);
    }

    public double distance(int a, int b) {
        int dx = a - x;
        int dy = b - y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    public double distance(Point p) {
        return distance(p.getX(), p.getY());
    }

    @Override
    public String toString() {
        return "Point[x=" + x + ", y=" + y + "]";
    }
}