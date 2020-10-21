package com.bad.code2;

public class BadCode2 {
    public static void main(String... args) {
        Square square = new Square(5d);
        square.printParameters();

        Qube qube = new Qube(10d);
        qube.printParameters();

        Parallelepiped parallelepiped = new Parallelepiped(2d, 3d, 5d);
        parallelepiped.printParameters();
    }

}
