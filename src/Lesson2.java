import java.util.Scanner;

public class Lesson2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите ваше имя: ");
        String name = scanner.nextLine();

        System.out.print("Введите ваш возраст: ");
        int age = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Введите вашу зарплату: ");
        double salary = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Введите ваш город: ");
        String city = scanner.nextLine();

        System.out.print("Введите любимый цвет: ");
        String color = scanner.nextLine();

        System.out.print("Введите ваш рост (см): ");
        int growth = scanner.nextInt();

        System.out.print("Введите ваш вес (кг): ");
        double weight = scanner.nextDouble();

        System.out.println("--------- ВАША АНКЕТА ---------");
        System.out.println("Имя: " + name);
        System.out.println("Возраст: " + age);
        System.out.println("Город: " + city);
        System.out.println("Любимый цвет: " + color);
        System.out.println("Рост: "+ growth);
        System.out.println("Вес: " + weight);
        System.out.println("Зарплата: " + salary + "руб.");
        System.out.println("Через 10 лет вам будет " + (age + 10));
        double heightInMeters = weight / 100.0;
        double bmi = weight / (heightInMeters * heightInMeters);
        System.out.printf("Ваш индекс массы тела: %.1f%n", bmi);

        scanner.close();
        }
    }