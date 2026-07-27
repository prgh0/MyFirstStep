import java.util.Scanner;

public class GameQuest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /// --- ПЕРЕМЕННЫЙ ИГРОВКА ---
        String name;
        int lives = 3;
        int gold = 0;
        boolean hasSword = false;
        boolean hasKey = false;
        boolean gameOver = false;

        // --- ВВОД ИМЕНИ ---
        System.out.print("Введите имя своего героя: ");
        name = scanner.nextLine();
        System.out.println("Доброй пожаловать, " + name + "!");

        // -- ГЛАВЫНЙ ЦИКЛ ИГРЫ ---
        while (!gameOver && lives >0) {
            System.out.println("\n--- Что делаем? ---");
            System.out.println("1. Пойти в лес");
            System.out.println("2. Пойти к замку");
            System.out.println("3. Пойти в таверну");
            System.out.println("4. Пойти к колодцу");
            System.out.println("5. Посмотреть свой инвентарь");
            System.out.print("Твой выбор (1-5): ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Съедаем Enter

            // --- ОБРАБОТКА ВЫБОРА ---
            if (choice ==1) {
                // ЛЕС
                System.out.println("Ты пошел в лес. Вдруг из кустов выбегает волк!");
                System.out.println("Будешь драться (1) или убегать (2)? ");
                int action = scanner.nextInt();
                scanner.nextLine();

                if (action == 1) {
                    if (hasSword) {
                        System.out.println("Ты достал меч и убил волка! +10 золота.");
                        gold +=10;
                    } else {
                        System.out.println("У тебя нет оружия! Волк тебя покусал. -1 жизнь.");
                        lives--;
                    }
                } else if (action == 2) {
                    System.out.println("Ты убежал, но потерял 3 золота.");
                    gold -= 3;
                    if (gold < 0) gold = 0; // Чтобы золото не уходило в минус
                } else {
                    System.out.println("Ты замешкался и волк укусил тебя! -1 жизнь.");
                    lives --;
                }
            } else if (choice == 2) {
                // ЗАМОК
                System.out.println("Ты подошел к воротам замка. Они заперты.");
                if (hasKey) {
                    System.out.println("У тебя есть ключ! Ты открываешь ворота и заходишь.");
                    System.out.println("Внутри ты находишь сундук с 50 золотом!");
                    gold += 50;
                    System.out.println("Поздравляю! Ты прошел игру!");
                    gameOver = true;
                } else {
                    System.out.println("Ключа нет. Попробуй найти его в лесу или таверне.");
                }
            } else if (choice == 3) {
                // ТАВЕРНА
                System.out.println("Ты зашел в таверну. За стойкой сидит старый рыцарь.");
                System.out.println("Он предлагает тебе выпить за 5 золота (1) или сыграть в кости (2).");
                int tavernAction = scanner.nextInt();
                scanner.nextLine();

                if (tavernAction == 1) {
                    if (gold >= 5) {
                        gold -= 5;
                        System.out.println("Ты выпил. Рыцарь дает тебе ключ от замка!");
                        hasKey = true;
                    } else {
                        System.out.println("У тебя нет денег. Рыцарь смеется над тобой.");
                    }
                } else if (tavernAction == 2) {
                    System.out.println("Ты играешь в кости. Тебе выпало 6!");
                    System.out.println("Рыцарь в восторге и дает тебе старый меч.");
                    hasSword = true;
                } else {
                    System.out.println("Ты ничего не выбрал и просто ушел.");
                }
            } else if (choice == 4) {
                // КОЛОДЕЦ
                System.out.println("Ты подошел к старому колодцу.");
                if (hasSword) {
                    System.out.println("Ты достал меч и нащупал им на дне сундук! +20 золота.");
                    gold += 20;
                } else {
                    System.out.println("Ты поскользнулся и упал в колодец! -2 жизни.");
                    lives -= 2;
                }
            } else if (choice == 5) {
                // ИНВЕНТАРЬ
                System.out.println("--- ИНВЕНТАРЬ ---");
                System.out.println("Жизни: " + lives);
                System.out.println("Золото: " + gold);
                System.out.println("Меч: " + (hasSword ? "Есть" : "Нет"));
                System.out.println("Ключи: " + (hasKey ? "Есть" : "Нет"));
            } else {
                System.out.println("Неверный выбор. Попробуй снова.");
            }
        }
        /// --- КОНЕЦ ИГРЫ ---
        if (lives < 0) {
            System.out.println("\nТы погиб! Игра окончена.");
        } else {
            System.out.println("\nТы победил! Поздравляю, " + name + "!");
        }

        scanner.close();
    }
}
