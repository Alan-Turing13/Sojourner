package input;

import logic.Sojourner;
import logic.SojournerNavigator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SojournerDriver {

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
        if (!SojournerNavigator.navigateWithinBounds(sojourner, instructionList)) {
            decideWhetherToExpand(scanner, sojourner);
        };
    }

    public static void decideWhetherToExpand(Scanner scanner, Sojourner sojourner){
        String decisionInput = "";
        System.out.println("\nThis will take you outside of Earth-charted territories");
        System.out.println("Do you wish to proceed? Y/N");

        while (!decisionInput.equalsIgnoreCase("Y") && !decisionInput.equalsIgnoreCase("N")){
            try {
                decisionInput = scanner.nextLine();
            } catch (Exception e){
                decisionInput = "";
                System.err.println("Select Y or N");
                scanner.next();
            }
        }

        if (decisionInput.equalsIgnoreCase("N")){
            SojournerNavigator.doNotExpand(sojourner);
        } else if (decisionInput.equalsIgnoreCase("Y")){
            sojourner.expandPlateau(
                    Math.max(sojourner.getXCoordinate()+1, sojourner.getPlateau().getWidth()),
                    Math.max(sojourner.getYCoordinate()+1, sojourner.getPlateau().getHeight())
            );
            System.out.println("Boldly ventured to " + sojourner.getPosition().toString());
        }
    }
}
