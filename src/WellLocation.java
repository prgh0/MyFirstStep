import java.util.Random;
import java.util.Scanner;

public class WellLocation extends Location {
    @Override
    public void execute(GameContext context) {
        // 1. Забираем все нужные инструменты из контекста
        Player player = context.getPlayer();
        Scanner scanner = context.getScanner();
        Random random = context.getRandom();
        // 2. Логика колодца
        System.out.println("Ты подошел к колодцу.");
        if (player.hasSword()) {
            System.out.println("Ты достал меч и нащупал им на дне сундук! +20 золота.");
            player.addGold(20);
        } else {
            System.out.println("Ты поскользнулся и упал в колодец! -2 жизни.");
            player.takeDamage(2);
        }
    }
}
