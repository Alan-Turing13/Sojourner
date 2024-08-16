package logic;

import input.Direction;
import input.Instruction;
import java.util.List;

public class SojournerController {
    public static boolean checkWithinBounds(Sojourner sojourner, List<Instruction> instructionList){
        int x = sojourner.getXCoordinate();
        int y = sojourner.getYCoordinate();
        Direction facing = sojourner.getPosition().getFacing();
        List<Direction> directionsList = List.of(Direction.values());

        for (Instruction instruction: instructionList){
            if (instruction.equals(Instruction.L)){
                facing = directionsList.get(
                        Direction.getCorrectDirectionIndex(directionsList.indexOf(facing) - 1)
                );
            } else if (instruction.equals(Instruction.M)){
                if (facing.equals(Direction.N)) y+=1;
                else if (facing.equals(Direction.E)) x+=1;
                else if (facing.equals(Direction.S)) y-=1;
                else if (facing.equals(Direction.W)) x-=1;
            } else if (instruction.equals(Instruction.R)) {
                facing = directionsList.get(
                        Direction.getCorrectDirectionIndex(directionsList.indexOf(facing) + 1)
                );
            }
        }
        sojourner.setPosition(new Position(x, y, facing));

        if (x >= sojourner.getPlateau().getWidth() || y >= sojourner.getPlateau().getHeight()
                || x < 0 || y < 0){
            return false;
        } else {
            System.out.println("Moved to " + x + "," + y + " facing " + facing + "\n");
            sojourner.checkNewPosition();
            return true;
        }
    }

    public static void doNotExpand(Sojourner sojourner){
        if (sojourner.getXCoordinate() >= sojourner.getPlateau().getWidth()){
            sojourner.setXCoordinate(sojourner.getPlateau().getWidth()-1);
        }
        if (sojourner.getYCoordinate() >= sojourner.getPlateau().getHeight()){
            sojourner.setYCoordinate(sojourner.getPlateau().getHeight()-1);
        }
        if (sojourner.getXCoordinate() < 0){
            sojourner.setXCoordinate(0);
        }
        if (sojourner.getYCoordinate() < 0){
            sojourner.setYCoordinate(0);
        }
        System.out.println("Safely moved to " + sojourner.getPosition().toString() + "\n");
        sojourner.checkNewPosition();
    }

}
