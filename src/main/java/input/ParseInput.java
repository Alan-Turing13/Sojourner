package input;

import logic.Plateau;
import logic.Position;
import logic.Sojourner;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ParseInput {

    public static Plateau getPlateau(Scanner scanner){
        String plateauSizeInput = "";
        System.out.println("Enter plateau size, eg <width> <height>");
        while (plateauSizeInput.length() < 3 || !plateauSizeInput.contains(" ")){
            try {
                plateauSizeInput = scanner.nextLine();
                if (!Plateau.plateauValidator(plateauSizeInput)){
                    System.err.println("Invalid plateau dimensions");
                    plateauSizeInput = "";
                }
            } catch (Exception e){
                System.err.println("Invalid plateau dimensions");
                plateauSizeInput = "";
                scanner.next();
            }
        }
        String[] plateauSize = plateauSizeInput.split(" ");
        return new Plateau(
                Integer.valueOf(plateauSize[0]),
                Integer.valueOf(plateauSize[1]));
    }

    public static Sojourner getSojourner(Scanner scanner, Plateau plateau){
        String startPointInput = "";
        System.out.println("Enter (0-indexed) Sojourner position, eg <x> <y> <N/S/W/E>");
        while (!Sojourner.sojournerValidator(startPointInput, plateau)){
            try {
                startPointInput = scanner.nextLine().toUpperCase();
            } catch (Exception e){
                startPointInput = "";
                scanner.next();
            }
        }
        String[] startPoint = startPointInput.trim().split(" ");
        return new Sojourner(new Position(
                Integer.parseInt(startPoint[0]),
                Integer.parseInt(startPoint[1]),
                Direction.valueOf(String.valueOf(startPoint[2]))
                ));
    }

    public static void driveSojourner(Scanner scanner, Sojourner sojourner){
        String instructionsInput = "";
        System.out.println("Enter some driving commands for the Sojourner");
        System.out.println("L: turn left; R: turn right; M: move forward");

        while (!Instruction.validateInstructions(instructionsInput)){
            try {
                instructionsInput = scanner.nextLine().toUpperCase();
            } catch (Exception e){
                instructionsInput = "";
                System.err.println("Invalid instructions. Use format 'LMRLMRLL'");
                scanner.next();
            }
        }
        List<Instruction> instructionList = new ArrayList<>();
        for (String letter : instructionsInput.split("")){
            instructionList.add(Instruction.valueOf(letter));
        }
        sojourner.navigate(instructionList);
    }
}
