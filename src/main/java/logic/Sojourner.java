package logic;

import input.Direction;
import input.Instruction;

import java.util.Arrays;

public class Sojourner {
    private Position position;
    private Plateau plateau;

    public Sojourner(Position position) {
         this.position = position;
         System.out.println("Sojourner landed");
    }

    public static boolean sojournerValidator(String s, Plateau plateau){
        if (s.length() >= 5 && s.trim().contains(" ")){
            try {
                int x = Integer.valueOf(s.split(" ")[0]);
                int y = Integer.valueOf(s.split(" ")[1]);
                return s.split(" ")[2] != "" &&
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

    public void navigate(Instruction instruction){

    }

}
