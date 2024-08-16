package input;

import logic.Plateau;
import java.util.Scanner;

public class PlateauBuilder {
    public static Plateau getPlateau(Scanner scanner){
        System.out.println("☄️");
        String plateauSizeInput = "";
        System.out.println("Enter plateau size, eg <width> <height>");
        while (!plateauSizeInput.contains(" ")){
            try {
                plateauSizeInput = scanner.nextLine().trim();
                if (!Plateau.plateauValidator(plateauSizeInput)){
                    System.err.println("Invalid plateau dimensions");
                    plateauSizeInput = "";
                }
            } catch (Exception e){
                plateauSizeInput = "";
                System.err.println("Invalid plateau dimensions");
                scanner.next();
            }
        }
        String[] plateauSize = plateauSizeInput.split(" ");
        return new Plateau(
                Integer.valueOf(plateauSize[0]),
                Integer.valueOf(plateauSize[1]));
    }
}
