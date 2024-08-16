import input.PlateauBuilder;
import input.SojournerBuilder;
import input.SojournerDriver;
import logic.Plateau;
import logic.Sojourner;
import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Plateau plateau = PlateauBuilder.getPlateau(scanner);
        Sojourner sojourner = null;
        while (sojourner == null){
            sojourner = SojournerBuilder.getSojourner(scanner, plateau);
        }
        while (!sojourner.checkIsCaptured() && !sojourner.checkHasVisitedTreeOfKnowledge()) {
            SojournerDriver.driveSojourner(scanner, sojourner);
        }
    }
}
