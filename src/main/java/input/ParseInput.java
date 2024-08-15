package input;

import logic.Plateau;
import logic.Position;
import logic.Sojourner;

import java.util.Arrays;
import java.util.Scanner;

public class ParseInput {

    // TODO: implement plateau validation to make sure neither of its dimensions are 0

    public static Plateau getPlateau(Scanner scanner){
        String plateauSizeInput = "";
        System.out.println("Enter plateau size");
        while (plateauSizeInput.length() < 3 || !plateauSizeInput.contains(" ")){
            try {
                plateauSizeInput = scanner.nextLine();
            } catch (Exception e){
                System.err.println("Please use format 'width height'");
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
        System.out.println("Enter (0-indexed) Sojourner position");
        while (
            startPointInput.length() < 5 || !startPointInput.contains(" ") ||
            !Arrays.toString(Direction.values()).contains(
                String.valueOf(startPointInput.charAt(startPointInput.length()-1)).toUpperCase())
        ){
            try {
                startPointInput = scanner.nextLine().toUpperCase();
            } catch (Exception e){
                System.err.println("Please use format 'x y compass-point");
                scanner.next();
            }
        }
        String[] startPoint = startPointInput.split(" ");
        return new Sojourner(new Position(
                Integer.valueOf(startPoint[0]),
                Integer.valueOf(startPoint[1]),
                Direction.valueOf(String.valueOf(startPoint[2]))
                ),
                plateau);
    }
}
