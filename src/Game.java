import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Random;

public class Game {
    private Scanner scanner;
    private Random random;
    private Player player;
    private Map<Integer, Location> locations;

    public Game() {
        scanner = new Scanner(System.in);
        random = new Random();
        // Инициализируем карту локаций
        locations = new HashMap<>();
        locations.put(1, new ForestLocation());
        locations.put(2, new CastleLocation());
        locations.put(3, new TavernLocation());
        locations.put(4, new WellLocation());
        // Сюда добавим Колодец позже

    }

    public void start() {
        System.out.print("Введите имя героя: ");
        String name = scanner.nextLine();
        player = new Player(name);
        System.out.println("Добро пожаловать, " + player.getName() + "!");

        while (!player.isGameOver() && player.isAlive()) {
            showMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();

            // Если есть такая локация — выполняем её
            if (locations.containsKey(choice)) {
                Location location = locations.get(choice);
                // Создаём контекст на ходу и передаём его в локацию
                GameContext context = new GameContext(player, scanner, random);
                location.execute(context);
            } else if (choice == 5) {
                player.showInventory();
            } else {
                System.out.println("Неверный выбор!");
            }
        }

        endGame();
        scanner.close();
    }

    private void showMenu() {
        System.out.println("\n--- Что делаем? ---");
        System.out.println("1. Пойти в лес");
        System.out.println("2. Пойти к замку");
        System.out.println("3. Пойти в таверну");
        System.out.println("4. Пойти к колодцу");
        System.out.println("5. Посмотреть свой инвентарь");
        System.out.print("Твой выбор (1-5): ");
    }

    private void endGame() {
        if (!player.isAlive()) {
            System.out.println("\nТы погиб! Игра окончена.");
        } else {
            System.out.println("\nПоздравляю, " + player.getName() + "! Ты победил!");
        }
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.start();
    }
}