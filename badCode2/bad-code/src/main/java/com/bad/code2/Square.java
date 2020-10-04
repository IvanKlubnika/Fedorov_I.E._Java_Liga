package com.bad.code2;

public class Square implements RectangularShapes {
    // У квадрата стороны равны, поэтому достаточно только длины
    private Double length;

    public Square(Double length) {
        this.length = length;
    }

    @Override
    public Double getLength() {
        return length;
    }

    @Override
    public Double getWidth() { return length; }

    @Override
    public Double getHeight() { return null; }



    @Override
    public Double getPerimeter() {
        return 4 * length;
    }

    @Override
    public Double getArea() {
        return Math.pow(length, 2);
    }

    //Квадрат 2D фигура, поэтому объем null
    @Override
    public Double getVolume() { return null; }

    public void printParameters(){
        System.out.println("Square: length - " + length + ", width - " + length + ".");
        System.out.println("Perimeter: " + getPerimeter() + ".");
        System.out.println("Area: " + getArea() + ".");
        System.out.println();
    }

}
