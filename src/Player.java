public class Player {
    private String name;
    private int lives;
    private int gold;
    private boolean hasSword;
    private boolean hasKey;
    private boolean gameOver;

    // Конструктор
    public Player(String name) {
        this.name = name;
        this.lives = 3;
        this.gold = 0;
        this.hasKey = false;
        this.gameOver = false;
    }

    // --- Методы для изменения состояния ---
    public void takeDamage(int damage) {
        lives -= damage;
        if (lives <=0) {
            lives = 0;
            System.out.println("Ты погиб!");
        }
    }

    public void addGold(int amount) {
        gold += amount;
    }

    public void spendGold(int amount) {
        if (gold >= amount) {
            gold -= amount;
        } else {
            System.out.println("У тебя нет денег!");
        }
    }

    public void setSword(boolean has) {
        hasSword = has;
    }

    public void setKey(boolean has) {
        hasKey = has;
    }

    public void winGame() {
        gameOver = true;
    }

    // --- Геттеры (для получения данных) ---
    public String getName() {return name;}
    public int getLives() {return lives;}
    public int getGold() {return gold;}
    public boolean hasSword() {return hasSword;}
    public boolean hasKey() {return hasKey;}
    public boolean isGameOver() {return gameOver;}
    public boolean isAlive() {return lives > 0;}

    // --- Вывод инвентаря ---
    public void showInventory() {
        System.out.println("--- ИНВЕНТАРЬ ---");
        System.out.println("Жизни: " + lives);
        System.out.println("Золото: " + gold);
        System.out.println("Меч: " + (hasKey ? "Есть" : "Нет"));
        System.out.println("Ключ: " + (hasKey ? "Есть" : "Нет"));
    }

}