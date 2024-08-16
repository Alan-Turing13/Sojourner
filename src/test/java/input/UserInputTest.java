package input;

import logic.Plateau;
import logic.Position;
import logic.Sojourner;
import java.util.List;
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

    @org.junit.jupiter.api.Test
    void basicDriveSojournerTest() {
        Sojourner sojourner = new Sojourner(new Position(10,10,Direction.N));
        sojourner.navigate(List.of(Instruction.L, Instruction.M, Instruction.R));
        Position expectedPosition = new Position(9, 10, Direction.N);
        assertTrue(expectedPosition.equals(sojourner.getPosition()));
    }

    @org.junit.jupiter.api.Test
    void driveFromUserInputTest() {
        Sojourner sojourner = new Sojourner(new Position(10,10,Direction.N));
        Position expectedPosition = new Position(9, 10, Direction.N);
        ParseInput.driveSojourner(new Scanner("LMR"), sojourner);
        assertTrue(expectedPosition.equals(sojourner.getPosition()));
    }
}