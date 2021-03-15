package com.company;

/**
 * Двумерный класс точки
 **/
public class Point3d extends Point2d {
    /**
     * Координата Z
     **/
    private double zCoord;

    /**
     * Конструктор инициализации
     **/
    public Point3d(double x, double y, double z) {
        super(x, y);

        this.zCoord = z;
    }

    /**
     * Конструктор по умолчанию
     **/
    public Point3d() {
        this(0, 0, 0);
    }

    /**
     * Возвращение координаты Z
     **/
    public double getZ() {
        return this.zCoord;
    }

    /**
     * Установка значения координаты Z
     **/
    public void setZ(double value) {
        this.zCoord = value;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }

        if (object == null || this.getClass() != object.getClass()) {
            return false;
        }

        Point3d point3d = (Point3d) object;

        return Double.compare(point3d.xCoord, this.xCoord) == 0 &&
                Double.compare(point3d.yCoord, this.yCoord) == 0 &&
                Double.compare(point3d.zCoord, this.zCoord) == 0;
    }

    public double distanceTo(Point3d point) {
        double distance = Math.sqrt(
                Math.pow(point.getX() - this.getX(), 2) +
                        Math.pow(point.getY() - this.getY(), 2) +
                        Math.pow(point.getZ() - this.getZ(), 2)
        );

        return Math.round(distance * 100) / 100D;
    }
}
