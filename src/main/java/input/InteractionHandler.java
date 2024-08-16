package input;

import com.sun.source.tree.Tree;
import logic.Sojourner;
import marsobjects.Martian;
import marsobjects.TreeOfKnowledge;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class InteractionHandler {

    public static Scanner scanner = new Scanner(System.in);

    public static void interact(Sojourner sojourner, Martian martian){

        Random random = new Random();
        List<String> martianDescriptions = List.of(
                "You notice a Martian up ahead with absurdly large shoes.",
                "You hear some really loud drum & bass. Looking round, you notice an alien pulling some outrageous shapes",
                "Up ahead, is a Martian making some soup in a large cauldron."
        );
        System.out.println(martianDescriptions.get(random.nextInt(3)));
        System.out.println("1) Take picture\n2) Stand still\n3) Move closer");

        String userResponse = "";
        while (!userResponse.equals("1") && !userResponse.equals("2") && !userResponse.equals("3")){
            try {
                userResponse = scanner.nextLine();
            } catch (Exception e){
                userResponse = "";
                System.err.println("Choose 1, 2 or 3");
                scanner.next();
            }
        }

        switch (martian.getDisposition()){
            case HOSTILE:
                List<String> martianHostilities = List.of(
                        "\nThe Martian shot your robot with a CO2 Laser, and now you have to build a new one, which will cost you millions of pounds 🕳",
                        "\nThe Martian threw your rover into a crater and it broke 🕳️",
                        "\nThe Martian threw a net over your rover and then carried it off 🕳"
                );
                System.out.println(martianHostilities.get(random.nextInt(3)));
                sojourner.setCaptured();
                break;

            case FRIENDLY:
                List<String> martianApproaches = List.of(
                        "\nThe Martian offered to trade some Martian tea for some whisky, but being a robot you did not bring any beverages on the trip.",
                        "\nThe friendly creature let you take a picture of him and you won a Nobel prize"
                );
                System.out.println(martianApproaches.get(random.nextInt(2)));
                System.out.println("Then walks onward. Follow the Martian? Y/N");
                String followMartianResponse = "";
                while (!followMartianResponse.equalsIgnoreCase("Y") && !followMartianResponse.equalsIgnoreCase("N")){
                    try {
                        followMartianResponse = scanner.nextLine();
                    } catch (Exception e){
                        followMartianResponse = "";
                        System.err.println("Select Y or N");
                        scanner.next();
                    }
                }
                if (followMartianResponse.equalsIgnoreCase("Y")){
                    TreeOfKnowledge.glimmer();
                    sojourner.setHasVisitedTreeOfKnowledge();
                }
                break;

            case AMBIVALENT:
                System.out.println("\nNot taken with your artificial robot appearance, the Martian shook his head in contempt,");
                System.out.println("then continued some alien activities he had been doing before.");
                break;
        }
    }
}
