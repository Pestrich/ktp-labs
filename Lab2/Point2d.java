package com.company;

/**
 * Двумерный класс точки
 **/
public class Point2d {
    /**
     * Координата X
     **/
    protected double xCoord;

    /**
     * Координата Y
     **/
    protected double yCoord;

    /**
     * Конструктор инициализации
     **/
    public Point2d(double x, double y) {
        this.xCoord = x;
        this.yCoord = y;
    }

    /**
     * Конструктор по умолчанию
     **/
    public Point2d() {
        this(0, 0);
    }

    /**
     * Возвращение координаты X
     **/
    public double getX() {
        return this.xCoord;
    }

    /**
     * Возвращение координаты Y
     **/
    public double getY() {
        return this.yCoord;
    }

    /**
     * Установка значения координаты X.
     **/
    public void setX(double value) {
        this.xCoord = value;
    }

    /**
     * Установка значения координаты Y.
     **/
    public void setY(double value) {
        this.yCoord = value;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }

        if (object == null || this.getClass() != object.getClass()) {
            return false;
        }

        Point2d point2d = (Point2d) object;

        return Double.compare(point2d.getX(), this.getX()) == 0 &&
                Double.compare(point2d.getY(), this.getY()) == 0;
    }
}
