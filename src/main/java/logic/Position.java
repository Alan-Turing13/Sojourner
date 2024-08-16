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

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean equals(Position p){
        return this.getX() == p.getX() && this.getY() == p.getY() &&
                this.getFacing().equals(p.getFacing());
    }

    @Override
    public String toString() {
        return x + "," + y + " facing " + facing;
    }
}
