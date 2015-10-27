package lab;

/*
 *  Aquarium Lab Series
 *
 *  Class: AquaFish
 *
 *  Author: Alyce Brady
 *
 *  Modified:
 *      Your Name      Date    Reason
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
import java.util.Random;

import lab.blackbox.AquaPoint;
import lab.blackbox.Aquarium;
import lab.blackbox.Direction;

/** Aquarium Lab Series:
 *      The AquaFish class defines a fish in an aquarium.
 *
 *  @author  Alyce Brady
 *  @version 10 July 2002
 *  @see Aquarium
 *  @see AquaPoint
 **/
public class AquaFish {
    // Named constants that specify how far a fish may move in one timestep
    private static final int MIN_OFFSET = 10;
    private static final int MAX_OFFSET = 70;
    private static final int PADDING = 20;

    // Class Variables: Shared among ALL fish
    private static int nextAvailableID = 1;   // next avail unique identifier
    private static Random generator = new Random(); // random number generator

    // Instance Variables: Encapsulated data for EACH fish
    private final Aquarium homeAquarium;    // aquarium in which this fish is swimming
    private final int id;                // unique identifier for this fish
    private final Color color;           // fish's color
    private AquaPoint pos;         // fish's position in the Aquarium
    private Direction dir;         // fish's direction
    private final int length, height;  // define size of fish
    private final int halfLength, halfHeight;  // useful for knowing perimeter of
                                         //   fish (myPos is center position)


    /**
     *  The AquaFish constructor sets properties of the AquaFish.
     *  Precondition: the aquarium must be big enough to accommodate
     *  the biggest fish (currently 75 pixels long and 30 pixels high)
     *  plus 10 pixels of padding in all four directions.
     *  @param    aqua   the Aquarium in which to place the fish
     **/
    public AquaFish(Aquarium aqua) {
        // Place fish in aquarium and initialize ID and color.
        this (aqua, Color.white);
    }

    /**
     *  The AquaFish constructor sets properties of the AquaFish.
     *  This version of the constructor allows the user to select the
     *  Color to be associated with the fish.
     *  Precondition: the aquarium must be big enough to accomodate
     *  the biggest fish (currently 75 pixels long and 30 pixels high)
     *  plus 10 pixels of padding in all four directions.
     *  @param    aqua   the Aquarium in which to place the fish
     *  @param    color  the Color to associate with the fish
     **/
    public AquaFish(Aquarium aqua, Color c) {
        // Place fish in aquarium and initialize ID and color.
        homeAquarium = aqua;
        id = nextAvailableID++;
        color = c;

        //  Fish are evenly distributed among 4 different sizes based on their
        //  ID numbers.
        length = 30 + (id % 4) * 15;
        height = (int)Math.round(0.4*length);
        halfLength = (int)Math.round(length/2.0);
        halfHeight = (int)Math.round(height/2.0);

        // Find random position within the bounds of the aquarium.
        int x = generator.nextInt(homeAquarium.width() - length
                   - PADDING) + PADDING/2;
        int y = generator.nextInt(homeAquarium.height() - height
                   - PADDING) + PADDING/2;

        // Since myX and myY represent the center of the fish, shift over half
        // the length and half the width.
        int fishX = x + halfLength;
        int fishY = y + halfHeight;

        // Initialize my position and direction.
        pos = new AquaPoint(fishX, fishY);
        dir = Direction.EAST;
    }

    /**
     * A static factory method that returns a randomly colored fish.
     *
     * Static factories are a way of acquiring objects, much like a
     * constructor. While somewhat more verbose to write, static factories can
     * be more flexible than normal constructors; for example, if you want to
     * create a "default" AquaFish and randomly-colored AquaFish, you can't
     * use two constructors, as both would have a single Aquarium argument,
     * making things ambiguous when one of the two constructors is used.
     * Static factory methods are not required to have the same name as the
     * class, so arguments are not as big of an issue.
     *
     * @param aqua
     * @return
     */
    public static AquaFish getRandomColorFish(Aquarium aqua) {
        return new AquaFish(aqua, new Color (generator.nextInt(256),
                generator.nextInt(256), generator.nextInt(256)));
    }

    /**
     *  Get the unique identifier for this fish.
     *  @return    the ID of the fish
     **/
    public int id() {
        return id;
    }

    /** Get fish's color.
     *  @return        the color of this fish
     **/
    public Color color() {
        return color;
    }

    /**
     *  Get the fish's position in the aquarium.
     *  @return    the position (point in the aquarium) of the fish
     **/
    public AquaPoint position() {
        return pos;
    }

    /** Get the length of the fish.
     *  @return    fish length
     **/
    public int length() {
        return length;
    }

    /** Get the height of the fish.
     *  @return    fish height
     **/
    public int height() {
        return height;
    }

    /**
     *  Determine whether the fish is facing right.
     *  @return    {@code true} if fish is facing right;
     *              {@code false} otherwise
     **/
    public boolean facingRight() {
        return dir.equals(Direction.EAST);
    }

    /**
     *  Determine whether the fish is facing left.
     *  @return    {@code true} if fish is facing left;
     *              {@code false} otherwise
     **/
    public boolean facingLeft() {
        return !facingRight();
    }

    /**
     *  Compute how far the fish is from the wall in front of it.
     *  @return    distance from front of fish to facing wall
     **/
    public int distanceToWall() {
        int leftEdgeOfFish = pos.xCoord() - (halfLength + 1);
        int rightEdgeOfFish = pos.xCoord() + (halfLength + 1);
        if (facingRight()) {
            return homeAquarium.width() - rightEdgeOfFish;
        }
        return leftEdgeOfFish;    // since left edge of aquarium is 0
    }

    /**
     *  Determine whether the fish is at a wall.
     *  A fish is considered at a wall if it cannot move forward; in other
     *  words, if the distance from the fish to the wall it faces is less
     *  than the minimum distance that a fish can move forward.
     *  @return    {@code true} if fish is at a wall;
     *              {@code false} otherwise
     **/
    public boolean atWall() {
        return distanceToWall() <= MIN_OFFSET;
    }

    /**
     *  Determine whether the fish is at the surface.
     *  A fish is considered at the surface if it cannot ascend; in other
     *  words, if the distance from the fish to the surface is less
     *  than the fish's height.
     *  @return    {@code true} if fish is at the surface;
     *              {@code false} otherwise
     **/
    public boolean atSurface() {
        int topOfFish = pos.yCoord() - (halfHeight + 1);
        return topOfFish <= height;
    }

    /**
     *  Determine whether the fish is at the bottom.
     *  A fish is considered at the bottom if it cannot descend; in other
     *  words, if the distance from the fish to the bottom is less
     *  than the fish's height.
     *  @return    {@code true} if fish is at the bottom;
     *              {@code false} otherwise
     **/
    public boolean atBottom() {
        int bottomOfFish = pos.yCoord() + (halfHeight + 1);
        return bottomOfFish >= (homeAquarium.height() - height);
    }

    /**
     *  This function is provided primarily for debugging purposes.
     *  @return    a string representation of a fish
     **/
    @Override
    public String toString() {
        return "" + id + pos + (facingLeft() ? "L" : "R");
    }

    /**
     *  Move forward horizontally by random increments, staying
     *  within the aquarium.
     **/
    public void moveForward() {
        // First get random number in range [0, MAX_DISTANCE-MIN_DISTANCE],
        // then shift to [MIN_DISTANCE, MAX_DISTANCE].  If moving that
        // far would mean swimming out of the aquarium, only move to edge
        // of aquarium.  Ajust fish's x coordinate by a positive or
        // negative amount, depending on whether fish is facing right or left.
        int moveDistance = generator.nextInt(MAX_OFFSET - MIN_OFFSET + 1);
        int moveAmt = MIN_OFFSET + moveDistance;
        if (moveAmt >= distanceToWall()) {
            moveAmt = distanceToWall();
        }

        if (facingRight()) {
            pos = pos.moveRight(moveAmt);
        } else {
            pos = pos.moveLeft(moveAmt);
        }
    }

    /**
     *  Reverse direction.
     **/
    public void changeDir() {
        dir = dir.reverse();
    }
}

