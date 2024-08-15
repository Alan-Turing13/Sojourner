import input.ParseInput;
import logic.Plateau;
import logic.Sojourner;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Plateau plateau = ParseInput.getPlateau(new Scanner(System.in));
        Sojourner sojourner = null;
        while (sojourner == null){
            sojourner = ParseInput.getSojourner(new Scanner(System.in), plateau);
        }
    }
}
