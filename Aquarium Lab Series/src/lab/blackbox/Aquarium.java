package lab.blackbox;

/*
 *  Aquarium Lab Series
 *
 *  Class: Aquarium
 *
 *  Author: Alyce Brady
 *
 *  License:
 *      This program is free software; you can redistribute it
 *      and/or modify it under the terms of the GNU General Public
 *      License as published by the Free Software Foundation.
 *
 *      This program is distributed in the hope that it will be useful,
 *      but WITHOUT ANY WARRANTY; without even the implied warranty of
 *      MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *      GNU General Public License for more details.
 */

import java.awt.Color;

/** Aquarium Lab Series:
 *  The Aquarium class defines an Aquarium and its properties.
 *
 *  @author  Alyce Brady
 *  @version 10 July 2002
 **/
public class Aquarium {
    private final int width;
    private final int height;
    private final Color color;

    /**
        Construct an Aquarium with user-specified size.
        @param    w    width of the aquarium when displayed (in pixels)
        @param    h   height of the aquarium when displayed (in pixels)
    */
    public Aquarium(int w, int h) {
        width = (w > 0 ? w : 640);
        height = (h > 0 ? h : 480);

        color = new Color(0.0f, .6f, 1.0f);
    }

    /**
        Determine the width of the aquarium.
        @return    the width of the aquarium
    */
    public int width() {
        return width;
    }

    /**
        Determine the height of the aquarium.
        @return    the height of the aquarium
    */
    public int height() {
        return height;
    }

    /**
        Determine the color of the aquarium (water color).
        @return    the Color of the aquarium
    */
    public Color color() {
        return color;
    }

    /**
        This function determines whether the given coordinates specify
            a valid location (one that exists within the bounds of the
            aquarium).
        @param xCoord a x coordinate to be checked
        @param yCoord a y coordinate to be checked
        @return    true if the specified location is within the bounds
                    of the aquarium
    */
    public boolean validLoc(int xCoord, int yCoord) {
        return  ((0 <= xCoord && xCoord < width) &&
                 (0 <= yCoord && yCoord < height));
    }
}    //end Aquarium class
