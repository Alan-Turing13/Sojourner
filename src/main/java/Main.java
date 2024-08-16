import input.ParseInput;
import logic.Plateau;
import logic.Sojourner;
import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Plateau plateau = ParseInput.getPlateau(scanner);
        Sojourner sojourner = null;
        while (sojourner == null){
            sojourner = ParseInput.getSojourner(scanner, plateau);
        }
        ParseInput.driveSojourner(scanner, sojourner);
    }
}
