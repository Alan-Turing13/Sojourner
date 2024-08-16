package input;

import logic.Plateau;
import logic.Position;
import logic.Sojourner;
import logic.SojournerController;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Scanner;
import static org.junit.jupiter.api.Assertions.*;

class UserInputTest {

    @org.junit.jupiter.api.Test
    void getBasicPlateauTest() {
        Plateau expectedPlateau = new Plateau(10, 10);
        Plateau userPlateau = PlateauBuilder.getPlateau(new Scanner("10 10"));
        assertTrue(expectedPlateau.equals(userPlateau));
    }

    @org.junit.jupiter.api.Test
    void getBasicSojournerTest() {
        Sojourner expectedSojourner = new Sojourner(
                new Position(10,10,Direction.N), new Plateau(11, 11)
        );
        Sojourner userSojourner = SojournerBuilder.getSojourner(
                new Scanner("10 10 N"), new Plateau(11, 11)
        );
        assertTrue(expectedSojourner.getPosition().equals(userSojourner.getPosition()));
    }

    @Test
    void basicDriveSojournerTest() {
        Sojourner sojourner = new Sojourner(
                new Position(10,10,Direction.N),
                new Plateau(11, 11)
        );
        SojournerController.checkWithinBounds(
                sojourner, List.of(Instruction.L, Instruction.M, Instruction.R)
        );
        Position expectedPosition = new Position(9, 10, Direction.N);
        assertTrue(expectedPosition.equals(sojourner.getPosition()));
    }

    @org.junit.jupiter.api.Test
    void driveFromUserInputTest() {
        Sojourner sojourner = new Sojourner(
                new Position(10,10,Direction.N), new Plateau(11, 11)
        );
        Position expectedPosition = new Position(9, 10, Direction.N);
        SojournerDriver.driveSojourner(new Scanner("LMR"), sojourner);
        assertTrue(expectedPosition.equals(sojourner.getPosition()));
    }

//    ‼️ To run this test, pass in a new Scanner("Y") at the end of driveSojourner()
//    @org.junit.jupiter.api.Test
//    void driveFurtherThanAnyManHasBeenBeforeTest() {
//        Sojourner sojourner = new Sojourner(
//                new Position(10,10,Direction.N), new Plateau(11, 11)
//        );
//        Position expectedPosition = new Position(10, 14, Direction.N);
//        SojournerDriver.driveSojourner(new Scanner("MMMM"), sojourner);
//        assertTrue(expectedPosition.equals(sojourner.getPosition()));
//    }

//    ‼️ To run this test, pass in a new Scanner("N") at the end of driveSojourner()
//    @org.junit.jupiter.api.Test
//    void stayWithinBoundsTest() {
//        Sojourner sojourner = new Sojourner(
//                new Position(10,10,Direction.N), new Plateau(11, 11)
//        );
//        Position expectedPosition = new Position(10, 10, Direction.N);
//        SojournerDriver.driveSojourner(new Scanner("MMMM"), sojourner);
//        assertTrue(expectedPosition.equals(sojourner.getPosition()));
//    }




}