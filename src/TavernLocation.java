import java.util.Random;
import java.util.Scanner;

public class TavernLocation  extends Location {
    @Override
    public void execute(GameContext context) {
        // 1. Забираем все нужные инструементы из контекста
        Scanner scanner = context.getScanner();
        Random random = context.getRandom();
        Player player = context.getPlayer();

        // 2. Логика таверны (такая же, как была в Game)
        System.out.println("Ты зашел в таверну. За стойкой сидит старый рыцарь.");
        System.out.println("Он предлагает тебе выпить за 5 золота (1) или сыграть в кости (2).");
        int tavernAction = scanner.nextInt();
        scanner.nextLine();
        if (tavernAction == 1) {
            // Проверяем, хватит ли денег
            if (player.getGold() >= 5) {
                player.spendGold(5); // Тратим 5 золота
                System.out.println("Ты выпил. Рыцарь дает тебе ключ от замка!");
                player.setKey(true); // Выдали ключ
            } else {
                System.out.println("У тебя нет денег. Рыцарь смеется над тобой.");
            }
        } else if (tavernAction == 2) {
            int dice = random.nextInt(6) + 1;
            System.out.println("Ты играешь в кости. Тебе выпло " + dice + "!");
            if (dice ==6) {
                System.out.println("Рыцарь в восторге и дает тебе старый меч.");
                player.setSword(true);
            } else {
                System.out.println("Рыцарь смеется: 'Не повезло, дружок!'");
            }
        } else {
            System.out.println("Ты ничего не выбрал и просто ушел.");
        }
    }
}
