package marsobjects;

import logic.Plateau;
import logic.Position;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Martian {
    private Position position;
    private Plateau plateau;
    private MartianTrait disposition;
    private List<String> hobbiesAndInterests;

    public Martian(Plateau plateau) {
        this.plateau = plateau;
        this.position = Position.generateRandomPosition(plateau);
        Random random = new Random();
        this.disposition = MartianTrait.values()[random.nextInt(3)];
    }

    public Position getPosition() {
        return position;
    }

    public MartianTrait getDisposition() {
        return disposition;
    }

    @Override
    public String toString() {
        return "position=" + position +
                ", disposition=" + disposition +
                '}';
    }
}
