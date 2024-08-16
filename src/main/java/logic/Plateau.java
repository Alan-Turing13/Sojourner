package logic;

import marsobjects.Martian;
import java.util.HashSet;

public class Plateau {
    private int northernMostPoint;
    private int easternMostPoint;
    private int southernMostPoint;
    private int westernMostPoint;
    private int width;
    private int height;
    private HashSet<Martian> martians;

    public Plateau(int northernMostPoint, int easternMostPoint){
        this.northernMostPoint = northernMostPoint; this.easternMostPoint = easternMostPoint;
        this.southernMostPoint = 0; this.westernMostPoint = 0;
        this.width = easternMostPoint-westernMostPoint;
        this.height = northernMostPoint-southernMostPoint;
        martians = new HashSet<>();
        seedMartians();
        System.out.println("Plateau mapped ⭐️");
    }

    public static boolean plateauValidator(String s){
        if (s.split(" ").length > 1) {
            return Integer.valueOf(s.split(" ")[0]) > 0 &&
                    Integer.valueOf(s.split(" ")[1]) > 0;
        } else {
            return false;
        }
    }

    public int getNorthernMostPoint() {
        return northernMostPoint;
    }
    public int getEasternMostPoint() {
        return easternMostPoint;
    }
    public int getSouthernMostPoint() {
        return southernMostPoint;
    }
    public int getWesternMostPoint() {
        return westernMostPoint;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void setWidthAndHeight(int northernMostPoint, int easternMostPoint,
                                  int southernMostPoint, int westernMostPoint) {
        this.northernMostPoint = northernMostPoint; this.easternMostPoint = easternMostPoint;
        this.southernMostPoint = southernMostPoint; this.westernMostPoint = westernMostPoint;
        this.width = easternMostPoint-westernMostPoint;
        this.height = northernMostPoint-southernMostPoint;
        seedMartians();
    }

    public HashSet<Martian> getAllMartians() {
        return martians;
    }

    public void seedMartians(){
        for (int i=0; i<width+height/4; i++){
            Martian martian = new Martian(this);
            martians.add(new Martian(this));
        }
    }

    public boolean equals(Plateau pl) {
        return this.width == pl.getWidth() && this.height == pl.getHeight();
    }

    @Override
    public String toString() {
        return "Plateau{" + "width=" + width + ", height=" + height + '}';
    }

}
