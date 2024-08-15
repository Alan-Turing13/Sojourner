package logic;

import input.Direction;

public class Position {
    private int x;
    private int y;
    private Direction facing;

    public Position(int x, int y, Direction facing) {
        this.x = x;
        this.y = y;
        this.facing = facing;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Direction getFacing() {
        return facing;
    }
}
