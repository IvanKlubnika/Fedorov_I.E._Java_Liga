package com.bad.code2;

/**
 * Изменил название интерфейса с Share3D, так как от него наследовали 2D фигуру.
 * Выбрал название RectangularShapes, так как существует очень большое многообразие фигур,
 * и для нахождения объема нужны разные параметры(не всегда длина ширина и высота).
 * Поэтому для упрощения интерфейс может использоваться, только для прямоугольным фигур 2D и 3D размерности.
 */
public interface RectangularShapes {
    /*
     * Не использовал в данном коде методы возвращающие длины сторон.
     * Но реализовал их, вдруг кто воспользуется.
     */
    Double getWidth();
    Double getLength();
    Double getHeight();

    Double getPerimeter();
    Double getArea();
    Double getVolume();

    void printParameters();
}
