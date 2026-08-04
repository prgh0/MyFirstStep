import java.util.Scanner;

public class CastleLocation extends Location {
    @Override
    public void execute(GameContext context) {
        // 1. Забираем все нужные инструменты из контекста
        Player player = context.getPlayer();
        Scanner scanner = context.getScanner();

        // 2. Логика замка (такая же, как была в Game)
        System.out.println("Ты подошел к воротам замка. Они заперты.");

        if (player.hasKey()) {
            System.out.println("У тебя есть ключ! Ты открываешь ворота и заходишь.");
            System.out.println("Внутри ты находишь сундук с 50 золотом!");
            player.addGold(50);
            System.out.println("Поздравляю! Ты прошел игру!");
            player.winGame(); // Устанавливаем флаг победы
        } else {
            System.out.println("Ключа нет. Попробуй найти его в лесу или таверну.");
        }
    }
}
