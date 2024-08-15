package input;

import logic.Plateau;
import logic.Position;
import logic.Sojourner;
import java.util.Scanner;
import static org.junit.jupiter.api.Assertions.*;

class UserInputTest {

    @org.junit.jupiter.api.Test
    void getBasicPlateauTest() {
        Plateau expectedPlateau = new Plateau(10, 10);
        Plateau userPlateau = ParseInput.getPlateau(new Scanner("10 10"));
        assertTrue(expectedPlateau.equals(userPlateau));
    }

    @org.junit.jupiter.api.Test
    void getBasicSojournerTest() {
        Sojourner expectedSojourner = new Sojourner(new Position(10,10,Direction.N));
        Sojourner userSojourner = ParseInput.getSojourner(
                new Scanner("10 10 N"), new Plateau(11, 11)
        );
        assertTrue(expectedSojourner.getPosition().equals(userSojourner.getPosition()));
    }
}