package Polymorphism.lab._02_Shapes;

public class Rectangle extends Shape {

    private Double height;
    private Double width;

    public Rectangle(Double height, Double width) {
        this.height = height;
        this.width = width;
    }


    @Override
    public Double calculatePerimeter() {
        return height * width;
    }

    public Double getHeight() {
        return height;
    }

    public Double getWidth() {
        return width;
    }

    @Override
    public Double calculateArea() {
        return 2 * height + 2 * width;
    }
}
