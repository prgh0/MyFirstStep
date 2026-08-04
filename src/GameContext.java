import java.util.Random;
import java.util.Scanner;

public class GameContext {
    private Player player;
    private Scanner scanner;
    private Random random;

    public GameContext(Player player, Scanner scanner, Random random) {
        this.player = player;
        this.scanner = scanner;
        this.random = random;
    }

    // Геттеры (чтобы локации могли получить доступ к данным)
    public Player getPlayer() {return player; }
    public Scanner getScanner() {return scanner; }
    public Random getRandom() {return random; }
}
