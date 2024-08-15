package input;

import logic.Plateau;
import logic.Position;
import logic.Sojourner;
import java.util.Scanner;

public class ParseInput {

    public static Plateau getPlateau(Scanner scanner){
        String plateauSizeInput = "";
        System.out.println("Enter plateau size");
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
        System.out.println("Enter (0-indexed) Sojourner position");
        while (!Sojourner.sojournerValidator(startPointInput, plateau)){
            try {
                startPointInput = scanner.nextLine().toUpperCase();
            } catch (Exception e){
                System.err.println("Sojourner cannot land at these coordinates");
                startPointInput = "";
                scanner.next();
            }
        }
        String[] startPoint = startPointInput.split(" ");
        return new Sojourner(new Position(
                Integer.parseInt(startPoint[0]),
                Integer.parseInt(startPoint[1]),
                Direction.valueOf(String.valueOf(startPoint[2]))
                ));
    }
}
