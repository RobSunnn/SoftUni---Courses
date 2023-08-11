package Abstraction.lab.PointInRectangle;

public class Rectangle {
    private Point bottomLeft;
    private Point topRight;

    public Rectangle(Point bottomLeft, Point topRight) {
        this.bottomLeft = bottomLeft;
        this.topRight = topRight;
    }

    public boolean contains(Point point) {
        boolean firstPointToCheck = point.getX() >= bottomLeft.getX() && point.getY() >= bottomLeft.getY();
        boolean secondPointToCheck =  point.getX() <= topRight.getX() && point.getY() <= topRight.getY();

        return firstPointToCheck && secondPointToCheck;
    }
}
