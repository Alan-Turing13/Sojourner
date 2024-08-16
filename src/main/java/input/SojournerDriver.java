package input;

import logic.Sojourner;
import logic.SojournerController;

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
        if (!SojournerController.checkWithinBounds(sojourner, instructionList)) {
            decideWhetherToExpand(new Scanner("N"), sojourner);
        };
    }

    public static void decideWhetherToExpand(Scanner scanner, Sojourner sojourner){
        String decisionInput = "";
        System.out.println("\nThis will take you outside of presently-mapped territories");
        System.out.println("Do you wish to proceed? Y/N\n");

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
            SojournerController.doNotExpand(sojourner);
        } else if (decisionInput.equalsIgnoreCase("Y")){
            sojourner.expandPlateau(
                    Math.max(sojourner.getYCoordinate()+1, sojourner.getPlateau().getNorthernMostPoint()),
                    Math.max(sojourner.getXCoordinate()+1, sojourner.getPlateau().getEasternMostPoint()),
                    Math.min(sojourner.getYCoordinate(), sojourner.getPlateau().getSouthernMostPoint()),
                    Math.min(sojourner.getXCoordinate(), sojourner.getPlateau().getWesternMostPoint())
            );
            System.out.println("Boldly ventured to " + sojourner.getPosition().toString() + "\n");
            sojourner.checkNewPosition();
        }
    }
}
