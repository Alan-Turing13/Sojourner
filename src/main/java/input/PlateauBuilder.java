package input;

import logic.Plateau;
import java.util.Scanner;

public class PlateauBuilder {
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
}
