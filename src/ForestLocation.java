import java.util.Random;
import java.util.Scanner;

public class ForestLocation extends Location {
    @Override
    public void execute (GameContext context) {
        Player player = context.getPlayer();
        Scanner scanner = context.getScanner();
        Random random = context.getRandom();

        int number = random.nextInt(10);
        if (number < 5) {
            System.out.println("Ты спокойно прошел по лесу.");
        } else {
            System.out.println("Из кустов выбегает волк!");
            System.out.print("Будешь драться (1) или убегать (2)? ");
            int action = scanner.nextInt();
            scanner.nextLine();

            if (action == 1) {
                if (player.hasSword()) {
                    System.out.println("Ты убил волка! +10 золота.");
                    player.addGold(10);
                } else {
                    System.out.println("Волк покусал тебя! -жизнь.");
                    player.takeDamage(1);
                }
            } else if (action == 2) {
                System.out.println("Ты убежал, но потерял 3 золота.");
                player.spendGold(3);
            } else {
                System.out.println("Ты замешкался! -1 жизнь.");
                player.takeDamage(1);
            }
        }
    }
}
