package lab.blackbox;

import java.util.Random;

public enum Direction {
    EAST() {
        @Override
        public Direction reverse() { return WEST; }
    },
    WEST() {
        @Override
        public Direction reverse() { return EAST; }
    };

    public abstract Direction reverse();

    private static final Random RNG = new Random();
    public static Direction randomDirection() {
        return (RNG.nextBoolean() ? EAST : WEST);
    }
}
