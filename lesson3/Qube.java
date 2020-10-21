package com.bad.code;

public class Qube implements Shape3D {
    //Длина
    private Double length;
    //Ширина
    private Double width;
    //Высота
    private Double height;

    //Конструктор определяющий длину ребер куба
    public Qube(Double length, Double width, Double height) {
        this.length = length;
        this.width = width;
        this.height = height;
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

    //Возвращает высоту
    @Override
    public Double getHeight() {
        return height;
    }

    //Возвращает объем
    @Override
    public Double getVolume() {
        return Math.pow(length, 3);
    }
}
