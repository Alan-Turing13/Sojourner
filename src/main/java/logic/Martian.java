package logic;

import java.util.ArrayList;
import java.util.List;

public class Martian {
    private Position position;
    private List<String> hobbiesAndInterests;

    public Martian(Position position) {
        this.position = position;
        hobbiesAndInterests = new ArrayList<>();
    }

    public Position getPosition() {
        return position;
    }

    public void move(Position position) {
        this.position = position;
        System.out.println("The martian moved to " + position.getX() + "," + position.getY());
    }

    public void addPastime(String pastime) {
        this.hobbiesAndInterests.add(pastime);
    }

    public void printHobbiesAndInterests() {
        System.out.println("This martian enjoys:");
        for (String hobbie : hobbiesAndInterests){
            System.out.println(hobbie);
        }
    }

    public void lookSheepish(){
        System.out.println("A martian cautiously emerged");
    }
}
