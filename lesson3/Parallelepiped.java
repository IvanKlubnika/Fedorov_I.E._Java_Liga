package com.bad.code2;

/**
 * В коде изначально не было данной фигуры.
 * Просто случайно расписал все для параллелепипеда, жалко было удалять=)
 */
public class Parallelepiped implements RectangularShapes {
    private Double length;
    private Double width;
    private Double height;

    public Parallelepiped(Double length, Double width, Double height) {
        this.length = length;
        this.width = width;
        this.height = height;
    }

    @Override
    public Double getLength() {
        return length;
    }

    @Override
    public Double getWidth() {
        return width;
    }

    @Override
    public Double getHeight() {
        return height;
    }


    /**
     * Сумма всех сторон параллелепипеда 2(ab+bc+ca)
     */
    @Override
    public Double getPerimeter() {
        return 4 * length + 4 * width + 4 * height;
    }

    /**
     * Площадь поверхности параллелепипеда 2(ab+bc+ca)
     */
    @Override
    public Double getArea() {
        return 2 * (length * width + width * height + height * length);
    }

    /**
     * Объем параллелепипеда abc
     */
    @Override
    public Double getVolume() {
        return length * width * height;
    }

    public void printParameters(){
        System.out.println("Parallelepiped: length - " + length + ", width - " + width + ", height - " + height + ".");
        System.out.println("Perimeter: " + getPerimeter() + ".");
        System.out.println("Area: " + getArea() + ".");
        System.out.println("Volume: " + getVolume() + ".");
        System.out.println();
    }
}
