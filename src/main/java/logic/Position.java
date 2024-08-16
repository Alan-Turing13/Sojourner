package logic;

import input.Direction;

import java.util.Random;

public class Position {
    private int x;
    private int y;
    private Direction facing;

    public Position(int x, int y, Direction facing) {
        this.x = x;
        this.y = y;
        this.facing = facing;
    }

    public static Position generateRandomPosition(Plateau plateau){
        Random random = new Random();
        Position newPosition = new Position(
                random.nextInt(plateau.getWesternMostPoint(), plateau.getEasternMostPoint()),
                random.nextInt(plateau.getSouthernMostPoint(), plateau.getNorthernMostPoint()),
                Direction.values()[random.nextInt(0, 4)]
        );
        while (plateau.getAllMartians().stream().filter(m -> m.getPosition().equals(newPosition)).count() > 0){
            newPosition.setX(random.nextInt(plateau.getWesternMostPoint(), plateau.getEasternMostPoint()));
            newPosition.setY(random.nextInt(plateau.getSouthernMostPoint(), plateau.getNorthernMostPoint()));
        }
        return newPosition;
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
        return this.getX() == p.getX() && this.getY() == p.getY();
    }

    @Override
    public String toString() {
        return x + "," + y + " facing " + facing;
    }
}
