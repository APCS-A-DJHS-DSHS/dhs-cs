package lab.blackbox;

// Aquarium Lab Series:  AquaPoint Class
//
// Copyright (C) 2002  Alyce Brady
//
// This class is free software; you can redistribute it and/or modify
// it under the terms of the GNU General Public License as published by
// the Free Software Foundation.
//
// This class is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
// GNU General Public License for more details.

/**
 *  Aquarium Lab Series:
 *  An {@code AquaPoint} object represents the x and y coordinates
 *  of a location in an aquarium.
 *
 *  @author Alyce Brady
 *  @version 10 July 2002
 **/

public class AquaPoint {
    private final int x;
    private final int y;
  // constructor

    /** Constructs an {@code AquaPoint} object.
     *  @param xCoord    point's x coordinate
     *  @param yCoord    point's y coordinate
     **/
    public AquaPoint(int xCoord, int yCoord) {
        x = xCoord;
        y = yCoord;
    }

  // accessor methods

    /** Returns the x coordinate of this point.
     *  @return        x coordinate of this point
     **/
    public int xCoord() {
        return x;
    }

    /** Returns the y coordinate of this point.
     *  @return        y coordinate of this point
     **/
    public int yCoord() {
        return y;
    }

    /** Moves this point {@code distance} units to the right.
     *  @param  distance   distance to move right
     **/
    public AquaPoint moveRight(int distance) {
        return translate(distance, 0);
    }

    /** Moves this point {@code distance} units to the left.
     *  @param  distance   distance to move left
     **/
    public AquaPoint moveLeft(int distance) {
        return translate(-distance, 0);
    }

    /** Moves this point {@code distance} units up.
     *  @param  distance   distance to move up
     **/
    public AquaPoint rise(int distance) {
        return translate(0, -distance);   // y coordinates get smaller going up
    }

    /** Moves this point {@code distance} units down.
     *  @param  distance   distance to move down
     **/
    public AquaPoint sink(int distance) {
        return translate(0, distance);   // y coordinates get bigger going down
    }

    private AquaPoint translate(int dX, int dY) {
        return new AquaPoint(x + dX, y + dY);
    }

    /** Represents this point as a string.
     *  @return        a string indicating the x and y coordinates of the
     *                 point in (x, y) format
     **/
    @Override
    public String toString() {
        return "(" + xCoord() + ", " + yCoord() + ")";
    }

}
