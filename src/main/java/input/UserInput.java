package input;

import logic.Plateau;
import logic.Position;
import logic.Sojourner;

import java.util.Scanner;

public class UserInput {

    static Scanner scanner = new Scanner(System.in);

    public static Plateau getPlateau(){
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

    public static Sojourner getSojourner(){
        String startPointInput = "";
        System.out.println("Enter rover position");
        while (startPointInput.length() < 5 || !startPointInput.contains(" ")){
            try {
                startPointInput = scanner.nextLine();
            } catch (Exception e){
                System.err.println("Please use format 'x y compass-point");
                scanner.next();
            }
        }
        String[] startPoint = startPointInput.split(" ");
        return new Sojourner(new Position(
                Integer.valueOf(startPoint[0]),
                Integer.valueOf(startPoint[2]),
                Direction.valueOf(String.valueOf(startPoint[4]))
                ));
    }
}
