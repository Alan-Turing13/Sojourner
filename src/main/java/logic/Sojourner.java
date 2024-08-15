package logic;

import input.Direction;
import java.util.Arrays;

public class Sojourner {
    private Position position;
    private Plateau plateau;

    public Sojourner(Position position) {
         this.position = position;
         System.out.println("Sojourner landed");
    }

    public static boolean sojournerValidator(String s, Plateau plateau){
        if (s.split(" ").length > 2){
            int x = Integer.valueOf(s.split(" ")[0]);
            int y = Integer.valueOf(s.split(" ")[1]);
            return x > 0 && y > 0 && x < plateau.getWidth() && y < plateau.getHeight();
        }
        return s.length() >= 5 && s.contains(" ") &&
               Arrays.toString(Direction.values()).contains(
                    String.valueOf(s.charAt(s.length()-1)).toUpperCase()
                );
    }

    public Position getPosition() {
        return position;
    }


}
