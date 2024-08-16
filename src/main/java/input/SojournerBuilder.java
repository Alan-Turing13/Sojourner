package input;

import logic.Plateau;
import logic.Position;
import logic.Sojourner;
import java.util.Scanner;

public class SojournerBuilder {
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
        ), plateau);
    }
}
