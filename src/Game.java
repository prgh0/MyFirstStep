import java.util.Scanner;
import java.util.Random;

public class Game {
    private Scanner scanner;
    private Random random;
    private Player player;

    public Game() {
        scanner = new Scanner(System.in);
        random = new Random();
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
            handleChoice(choice);
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

    private void handleChoice(int choise) {
        if (choise == 1) {
            goToForest();
        } else if (choise == 2) {
            goToCastle();
        } else if (choise == 3) {
            goToTavern();
        } else if (choise == 4) {
            goToWell();
        } else if (choise == 5) {
            player.showInventory();
        } else {
            System.out.println("Неверный выборй!");
        }
    }
    private void goToForest() {
        int number = random.nextInt(10);
        if (number < 5) {
            System.out.println("Ты спокойно прошел по лесу.");
        } else {
            System.out.println("Из кустов выбегает волк!");
            System.out.println("Будешь драться (1) или убегать (2)?");
            int action = scanner.nextInt();
            scanner.nextLine();
            if (action == 1) {
                if(player.hasSword()) {
                    System.out.println("Ты убил волка! +10 золота.");
                    player.addGold(10);
                }else {
                    System.out.println("Волк покусал тебя! -1 жизнь.");
                    player.takeDamage(1);
                }
            } else if (action == 2) {
                System.out.println("Ты убежал, но потерял 3 золота");
                player.spendGold(3);
            } else {
                System.out.println("Ты замешкался! -1 жизнь");
                player.takeDamage(1);
            }
        }
    }
    private void goToCastle() {
        System.out.println("Ты подошел к воротам замка. Они заперты.");
        if (player.hasKey()) {
            System.out.println("У тебя есть ключ! Ты открываешь ворота и заходишь.");
            System.out.println("Внутрим ты находишь сундук с 50 золотом!");
            player.addGold(50);
            System.out.println("Поздравляю! Ты прошел игру.");
            player.winGame();
        } else {
            System.out.print("Ключа нет. Попробуй найти его в лесу или таверне.");
        }
    }
    private void goToTavern() {
        System.out.println("Ты зашел в таверну. За стойкой сидит старый рыцарь.");
        System.out.println("Он предлагает тебе выпить за 5 золотоа (1) или сыграть в кости (2).");
        int tavernAction = scanner.nextInt();
        scanner.nextLine();

        if (tavernAction == 1) {
            if (player.getGold() >= 5) {
                player.spendGold(5);
                System.out.println("Ты выпил. Рыцарь дает тебе ключ от замка!");
                player.setKey(true);
            } else {
                System.out.println("У тебя нет денег. Рыцарь смеется над тобой.");
            }
        } else if (tavernAction == 2) {
            int dice = random.nextInt(6) + 1;
            System.out.println("Ты играешь в кости. Тебе выпало " + dice + "!");
            if (dice == 6) {
                System.out.println("Рыцарь в востороге и дает тебе старый меч.");
                player.setSword(true);
            } else {
                System.out.println("Рыцарь смеется: 'Не повезло, дружок!'");
            }
        } else {
            System.out.println("Ты нимчего не выбрал и просто ушел.");
        }
    }

    private void goToWell() {
        System.out.println("Ты подошел к старому колодцу.");
        if (player.hasSword()) {
            System.out.println("Ты достал меч и нащупал им на дне сундук! +20 золота.");
            player.addGold(20);
        } else {
            System.out.println("Ты поскользнулся и упал в колодец! -2 жизни.");
            player.takeDamage(2);
        }
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