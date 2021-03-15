package com.company;

/**
 * This class represents a specific location in a 2D map.  Coordinates are
 * integer values.
 **/
public class Location {
    /**
     * X coordinate of this location.
     **/
    public int xCoord;

    /**
     * Y coordinate of this location.
     **/
    public int yCoord;


    /**
     * Creates a new location with the specified integer coordinates.
     **/
    public Location(int x, int y) {
        this.xCoord = x;
        this.yCoord = y;
    }

    /**
     * Creates a new location with coordinates (0, 0).
     **/
    public Location() {
        this(0, 0);
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof Location) {
            Location other = (Location) object;

            if (this.xCoord == other.xCoord && this.yCoord == other.yCoord) {
                return true;
            }
        }

        return false;
    }

    @Override
    public int hashCode() {
        int result = 17;

        result = 37 * result + xCoord;
        result = 37 * result + yCoord;

        return result;
    }
}
