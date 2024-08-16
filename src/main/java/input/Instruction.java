package input;

import java.util.List;

public enum Instruction {
    L, R, M;

    public static boolean validateInstructions(String input){
        if (input.length()==0) return false;
        List<String> validLetters = List.of("L", "M", "R");
        List<String> inputLetters = List.of(input.split(""));
        // filter out whichever letters are not in validLetters. count should then be 0.
        return inputLetters.stream().filter(letter -> !validLetters.contains(letter)).count() == 0;
    }
}
