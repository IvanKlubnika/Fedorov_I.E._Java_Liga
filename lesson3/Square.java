package com.bad.code;

public class Square implements Shape2D {
    //Длина
    private Double length;
    //Ширина
    private Double width;

    //Конструктор определяющий длину ребер квадрата
    public Square(Double length, Double width) {
        this.length = length;
        this.width = width;
    }

    //Возвращает длину
    @Override
    public Double getLength() {
        return length;
    }

    //Возвращает ширину
    @Override
    public Double getWidth() {
        return width;
    }

    //Возвращает периметр
    public Double getPerimeter() {
        return 4 * length;
    }
}

