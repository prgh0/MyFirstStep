import java.util.Scanner;

public class Lesson3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите ваше имя: ");
        String name = scanner.nextLine();

        System.out.print("Введите ваш возраст: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // съедаем enter

        System.out.print("Сколько у вас денег? ");
        double money = scanner.nextDouble();
        scanner.nextLine(); // съедаем enter

        System.out.println("--- Проверка на вход ---");

        if (age < 18) {
            System.out.println(name + ", извини, тебе еще рано. Иди учи уроки!");
        } else if (age >= 18 && age <= 30) {
            if (age == 30 && money > 5000) {
                System.out.println(name + ", о, тебе уже 30 и ты при деньгах! Проходи в золотой зал!");
            }
            if (money >= 1000) {
                System.out.println(name + ", проходи, друг! У тебя есть " + money + "руб.");
            }else {
                System.out.println(name + ", денег нет, но ты держись! У тебя всего " + money + "руб.");
            }
        } else {
            System.out.println(name + ", Вам сюда, в VIP-ложу! Возраст " + age + " лет - солидный.");
        }

        scanner.close();
    }
}
