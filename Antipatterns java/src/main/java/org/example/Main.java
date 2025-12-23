package org.example;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

// Антипаттерн 1: Бог-класс (God Class) — этот класс делает всё: ввод, обработку, вывод, работу с файлами и т.д.
public class Main {

    // Антипаттерн 2: Злоупотребление глобальными переменными — статические переменные используются везде
    public static int magicNumber1 = 5; // Антипаттерн 3: Магические числа
    public static String hardcodedString = "result.txt"; // Антипаттерн 4: Жёстко закодированные строки
    public static List<Integer> numbers = new ArrayList<>(); // Антипаттерн 5: Публичное изменяемое состояние

    // Антипаттерн 6: Неиспользуемые переменные — эта переменная никогда не используется
    private static double unusedVar = 3.14;

    public static void main(String[] args) {
        // Антипаттерн 7: Спагетти-код — всё свалено в main без структуры
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите числа, напишите 'done' для завершения"); // Антипаттерн 8: Плохая обработка ошибок — нет валидации ввода

        // Антипаттерн 9: Дублирование кода — повторяющаяся логика ввода
        while (true) {
            String input = scanner.nextLine();
            if (input.equals("done")) {
                break;
            }
            try {
                numbers.add(Integer.parseInt(input));
            } catch (Exception e) {
                // Антипаттерн 10: Проглатывание исключений — исключение просто игнорируется
            }
        }

        // Антипаттерн 11: Слишком длинный метод — всё запихнуто в один метод
        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }

        // Антипаттерн 12: Копи-паст программирование — дублирование вычисления суммы
        int sum2 = 0;
        for (int num : numbers) {
            sum2 += num;
        }
        if (sum != sum2) { // Это никогда не выполнится
            System.out.println("Ошибка в вычислениях"); // Антипаттерн 13: Мёртвый код
        }

        double average = sum / numbers.size(); // Антипаттерн 14: Целочисленное деление (рискованно, возможна потеря точности)
        System.out.println("Сумма: " + sum);
        System.out.println("Среднее: " + average);

        // Антипаттерн 15: Ненужная сложность — поиск максимума усложнён без причины
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) > max) {
                max = numbers.get(i);
            }
        }
        System.out.println("Максимум: " + max);

        // Антипаттерн 16: Изобретение велосипеда — ручная сортировка вместо Collections.sort
        for (int i = 0; i < numbers.size(); i++) {
            for (int j = i + 1; j < numbers.size(); j++) {
                if (numbers.get(i) > numbers.get(j)) {
                    int temp = numbers.get(i);
                    numbers.set(i, numbers.get(j));
                    numbers.set(j, temp);
                }
            }
        }
        System.out.println("Отсортировано: " + numbers);

        // Антипаттерн 17: Плохие имена переменных — бессмысленные имена
        int a = 0;
        for (int b : numbers) {
            a += b * magicNumber1; // Использование магического числа
        }
        System.out.println("Таинственное вычисление: " + a);

        // Антипаттерн 18: Якорь (Boat anchor) — вызов неиспользуемого метода
        unusedMethod();

        // Антипаттерн 19: Жёсткая связь (Tight coupling) — прямое создание FileWriter
        try {
            FileWriter writer = new FileWriter(new File(hardcodedString));
            writer.write("Результаты: сумма=" + sum + ", среднее=" + average);
            writer.close();
        } catch (IOException e) {
            // Антипаттерн 20: Пустой catch-блок — ничего не делаем при ошибке
        }

        // Антипаттерн 21: Преждевременная оптимизация — бесполезное кэширование
        int cachedSum = sum; // Совершенно бессмысленно

        // Антипаттерн 22: Программирование перебором (Programming by permutation) — стиль проб и ошибок
        if (numbers.size() > 0) {
            System.out.println("Первое число: " + numbers.get(0));
        } else {
            System.out.println("Нет чисел");
        }

        // Антипаттерн 23: Раздувание интерфейса (Interface bloat) — ненужный интерфейс
        Calculator calc = new BadCalculator();
        calc.calculate(sum); // Ничего полезного не делает

        // Антипаттерн 24: Полтергейст (Poltergeist) — временный объект, созданный и сразу выброшенный
        new TemporaryObject().doNothing();

        // Антипаттерн 25: Лавовый поток (Lava flow) — устаревший код оставлен в проекте
        // Старый способ: int oldSum = 0; // Закомментировано, но всё ещё здесь

        // Антипаттерн 26: Позолота (Gold plating) — избыточная функциональность для простого вывода
        printFancy("Готово", 3);

        // Антипаттерн 27: Проблема йо-йо (Yo-yo problem) — глубокая цепочка наследования без смысла
        new DeepChild().method();

        // Антипаттерн 28: Дружественная зависимость — злоупотребление package-private (симулировано)

        // Антипаттерн 29: Накопление и выстрел (Accumulate and fire) — неэффективное построение строки
        String result = "";
        for (int num : numbers) {
            result += num + " ";
        }
        System.out.println("Числа: " + result);

        // Антипаттерн 30: Паралич анализа (Analysis paralysis) — избыточное усложнение простого условия
        if (numbers.size() == 0) {
            System.out.println("Список пуст");
        } else if (numbers.size() == 1) {
            System.out.println("Один элемент");
        } else {
            // и т.д., но не завершено
        }

        // Антипаттерн 31: Слишком общий обработчик исключений — уже был выше

        scanner.close();
    }

    // Антипаттерн 32: Неиспользуемый метод
    private static void unusedMethod() {
        // Ничего не делает
    }

    // Антипаттерн 33: Избыточный вывод с украшениями
    private static void printFancy(String msg, int times) {
        for (int i = 0; i < times; i++) {
            System.out.println("*** " + msg + " ***");
        }
    }
}

// Антипаттерн 34: Пустой интерфейс — раздувание API
interface Calculator {
    void calculate(int x);
}

// Антипаттерн 35: Бесполезная реализация
class BadCalculator implements Calculator {
    @Override
    public void calculate(int x) {
        // Ничего не делает
    }
}

// Антипаттерн 36: Класс-полтергейст — существует только для одноразового создания
class TemporaryObject {
    public void doNothing() {
        // Существует только чтобы быть созданным один раз
    }
}

// Антипаттерн 37: Глубокое бессмысленное наследование
class DeepParent {
    public void method() {
        System.out.println("Родитель");
    }
}

class DeepChild extends DeepParent {
    // Ничего полезного не переопределяет
}


