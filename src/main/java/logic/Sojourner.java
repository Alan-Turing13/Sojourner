package logic;

public class Sojourner {
    private Position position;
    private Plateau plateau;

    public Sojourner(Position position, Plateau plateau) {
        if (position.getX() < plateau.getWidth() && position.getY() < plateau.getHeight()) {
            this.position = position;
            System.out.println("Sojourner landed");
        } else {
            System.err.println("Sojourner cannot land at these coordinates");
        }
    }
}
