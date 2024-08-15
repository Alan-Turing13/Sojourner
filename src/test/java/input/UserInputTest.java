package input;

import logic.Plateau;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class UserInputTest {

    /*

     */

    @org.junit.jupiter.api.Test
    void getBasicPlateauTest() {
        Plateau expectedPlateau = new Plateau(10, 10);
        Plateau userPlateau = ParseInput.getPlateau(new Scanner("10 10"));
        assertTrue(expectedPlateau.equals(userPlateau));
    }

    @org.junit.jupiter.api.Test
    void getNullPlateauTest() {
        Plateau userPlateau = ParseInput.getPlateau(new Scanner("0 0"));
        System.out.println(userPlateau.toString());
        assertNull(userPlateau);
    }

    @org.junit.jupiter.api.Test
    void getSojourner() {
    }
}