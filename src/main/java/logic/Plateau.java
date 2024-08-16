package logic;

import java.util.HashSet;

public class Plateau {
    private int width;
    private int height;
    private HashSet<Martian> martians;

    public Plateau(int width, int height){
        this.width = width;
        this.height = height;
        martians = new HashSet<>();
        System.out.println("Plateau mapped\n");
    }

    public Plateau(int width, int height, HashSet<Martian> martians) {
        this.width = width;
        this.height = height;
        this.martians = martians;
        System.out.println("Plateau mapped\n");
    }

    public static boolean plateauValidator(String s){
        if (s.split(" ").length > 1) {
            return Integer.valueOf(s.split(" ")[0]) > 0 &&
                    Integer.valueOf(s.split(" ")[1]) > 0;
        } else {
            return false;
        }
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void setWidthAndHeight(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public boolean equals(Plateau pl) {
        return this.width == pl.getWidth() && this.height == pl.getHeight();
    }

    @Override
    public String toString() {
        return "Plateau{" + "width=" + width + ", height=" + height + '}';
    }
}
