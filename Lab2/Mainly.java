package com.company;

import java.util.Scanner;

public class Mainly {
    public static void main(String[] args) {
        System.out.println("Введите координаты (x, y, z) для 1 точки:");

        Scanner scanner = new Scanner(System.in);
        String oneString = scanner.nextLine();
        String[] oneStringArr = oneString.split(" ");

        Point3d onePoint = new Point3d();

        onePoint.setX(Double.parseDouble(oneStringArr[0]));
        onePoint.setY(Double.parseDouble(oneStringArr[1]));
        onePoint.setZ(Double.parseDouble(oneStringArr[2]));

        System.out.println("Введите координаты (x, y, z) для 2 точки:");

        String twoString = scanner.nextLine();
        String[] twoStringArr = twoString.split(" ");

        Point3d twoPoint = new Point3d();

        twoPoint.setX(Double.parseDouble(twoStringArr[0]));
        twoPoint.setY(Double.parseDouble(twoStringArr[1]));
        twoPoint.setZ(Double.parseDouble(twoStringArr[2]));

        System.out.println("Введите координаты (x, y, z) для 3 точки:");

        String threeString = scanner.nextLine();
        String[] threeStringArr = threeString.split(" ");

        Point3d threePoint = new Point3d();

        threePoint.setX(Double.parseDouble(threeStringArr[0]));
        threePoint.setY(Double.parseDouble(threeStringArr[1]));
        threePoint.setZ(Double.parseDouble(threeStringArr[2]));

        if (
            onePoint.equals(twoPoint) ||
            onePoint.equals(threePoint) ||
            twoPoint.equals(threePoint)
        ) {
            System.out.println("Минимум две точки равны");
        } else {
            System.out.println("Площадь равна: " + computeArea(onePoint, twoPoint, threePoint));
        }
    }

    public static double computeArea(Point3d onePoint3d, Point3d twoPoint3d, Point3d threePoint3d) {
        double a = onePoint3d.distanceTo(twoPoint3d);
        double b = twoPoint3d.distanceTo(threePoint3d);
        double c = threePoint3d.distanceTo(onePoint3d);
        double p = (a + b + c) / 2;

        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }
}
