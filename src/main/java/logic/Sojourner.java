package logic;

import input.Direction;
import input.InteractionHandler;
import marsobjects.Martian;
import sfx.PlaySound;

import java.util.Arrays;

public class Sojourner {
    private Position position;
    private Plateau plateau;
    private boolean capturedByMartianForces;
    private boolean visitedMartianTreeOfKnowledge;

    public Sojourner(Position position, Plateau plateau) {
         this.position = position;
         this.plateau = plateau;
         System.out.println("Sojourner landed 🚀\n");
    }

    public static boolean sojournerValidator(String s, Plateau plateau){
        if (s.length() >= 5 && s.trim().contains(" ")){
            try {
                int x = Integer.valueOf(s.split(" ")[0]);
                int y = Integer.valueOf(s.split(" ")[1]);
                return !s.split(" ")[2].isEmpty() &&
                        Arrays.toString(Direction.values()).contains(s.split(" ")[2].toUpperCase())
                        && x < plateau.getWidth() && y < plateau.getHeight();
            } catch (NumberFormatException n){}
        }
        if (s.length() != 0) System.err.println("Sojourner cannot land at these coordinates");
        return false;
    }

    public Position getPosition() {
        return position;
    }
    public void setPosition(Position position) {
        this.position = position;
    }

    public int getXCoordinate(){
        return getPosition().getX();
    }
    public void setXCoordinate(int x){
        setPosition(new Position(x, getPosition().getY(), getPosition().getFacing()));
    }

    public int getYCoordinate(){
        return getPosition().getY();
    }
    public void setYCoordinate(int y){
        setPosition(new Position(getPosition().getX(), y, getPosition().getFacing()));
    }

    public Plateau getPlateau() {
        return plateau;
    }
    public void expandPlateau(int northernMostPoint, int easternMostPoint,
                              int southernMostPoint, int westernMostPoint) {
        this.plateau.setWidthAndHeight(
                northernMostPoint, easternMostPoint, southernMostPoint, westernMostPoint
        );
    }

    public void checkNewPosition(){
        for (Martian martian: this.plateau.getAllMartians()){
            if (martian.getPosition().equals(this.getPosition())){
                InteractionHandler.interact(this, martian);
            }
        }
    }

    public boolean checkIsCaptured() {
        return capturedByMartianForces;
    }
    public void setCaptured() {
        PlaySound gameOverSound = new PlaySound("gameOver.wav");
        Thread treeSoundThread = new Thread(gameOverSound);
        treeSoundThread.start();
        this.capturedByMartianForces = true;
    }

    public boolean checkHasVisitedTreeOfKnowledge() {
        return visitedMartianTreeOfKnowledge;
    }

    public void setHasVisitedTreeOfKnowledge() {
        PlaySound treeSound = new PlaySound("gameComplete.wav");
        Thread treeSoundThread = new Thread(treeSound);
        treeSoundThread.start();
        this.visitedMartianTreeOfKnowledge = true;
    }
}
