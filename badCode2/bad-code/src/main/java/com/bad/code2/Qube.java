package com.bad.code2;

public class Qube implements RectangularShapes {
    // У куба стороны равны, поэтому достаточно только длины
    private Double length;

    public Qube(Double length) {
        this.length = length;
    }

    @Override
    public Double getLength() {
        return length;
    }

    @Override
    public Double getWidth() {
        return length;
    }

    @Override
    public Double getHeight() {
        return length;
    }



    /**
     * Сумма всех сторон куба 12a
     */
    @Override
    public Double getPerimeter() {
        return 12 * length;
    }

    /**
     * Площадь поверхности куба  6 * (a^2)
     */
    @Override
    public Double getArea() {
        return 6 * Math.pow(length, 2);
    }

    /**
     * Объем куба a^3
     */
    @Override
    public Double getVolume() {
        return Math.pow(length, 3);
    }

    public void printParameters(){
        System.out.println("Qube: length - " + length + ", width - " + length + ", height - " + length + ".");
        System.out.println("Perimeter: " + getPerimeter() + ".");
        System.out.println("Area: " + getArea() + ".");
        System.out.println("Volume: " + getVolume() + ".");
        System.out.println();
    }
}
