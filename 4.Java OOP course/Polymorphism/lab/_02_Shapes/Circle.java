package Polymorphism.lab._02_Shapes;

public class Circle extends Shape {

    private Double radius;

    public Circle(Double radius) {
        this.radius = radius;
    }


    final Double getRadius() {
        return radius;
    }

    @Override
    public Double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }


    @Override
    public Double calculateArea() {
        return Math.PI * radius * radius;
    }


}
