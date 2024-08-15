package logic;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class Plateau {
    private int width;
    private int height;

    public Plateau(int width, int height){
            this.width = width;
            this.height = height;
            System.out.println("Plateau mapped");
    }

    public static BiPredicate<Integer, Integer> plateauValidator = (w, h) -> w>0 && h>0;

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public boolean equals(Plateau pl) {
        return this.width == pl.getWidth() && this.height == pl.getHeight();
    }

    @Override
    public String toString() {
        return "Plateau{" +
                "width=" + width +
                ", height=" + height +
                '}';
    }
}
