package logic;

import input.Direction;
import input.Instruction;
import java.util.Arrays;
import java.util.List;

public class Sojourner {
    private Position position;
    private Plateau plateau;

    public Sojourner(Position position) {
         this.position = position;
         System.out.println("Sojourner landed\n");
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

    public int getCorrectDirectionIndex(int n){
        if (n < 0) n+=4;
        if (n>3) n-=4;
        return n;
    }

    public void navigate(List<Instruction> instructionList){
        int x = position.getX();
        int y = position.getY();
        Direction facing = position.getFacing();
        List<Direction> directionsList = List.of(Direction.values());

        for (Instruction instruction: instructionList){
            if (instruction.equals(Instruction.L)){
                facing = directionsList.get(getCorrectDirectionIndex(directionsList.indexOf(facing) - 1));
            } else if (instruction.equals(Instruction.M)){
                if (facing.equals(Direction.N)) y+=1;
                else if (facing.equals(Direction.E)) x+=1;
                else if (facing.equals(Direction.S)) y-=1;
                else if (facing.equals(Direction.W)) x-=1;
            } else if (instruction.equals(Instruction.R)) {
                facing = directionsList.get(getCorrectDirectionIndex(directionsList.indexOf(facing) + 1));
            }
        }
        System.out.println("Moved to " + x + "," + y + " facing " + facing);
        position = new Position(x, y, facing);
    }

}
