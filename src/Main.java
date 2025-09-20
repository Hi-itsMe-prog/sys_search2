import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Читаем всю строку и разбиваем по запятым или пробелам
        String input = scanner.nextLine();
        String[] numbers = input.split("[,\\s]+");

        List<Integer> numbs = new ArrayList<>();
        for (String numStr : numbers) {
            if (!numStr.trim().isEmpty()) {
                numbs.add(Integer.parseInt(numStr.trim()));
            }
        }

        if (numbs.size() < 2) {
            System.out.println("0 0");
            return;
        }

        // Находим минимальный элемент последовательности
        int min = Integer.MAX_VALUE;
        for (int num : numbs) {
            if (num < min) {
                min = num;
            }
        }

        System.out.println("Минимальный элемент: " + min); // для отладки

        // Если минимальный элемент >= 16, то условие никогда не выполнится
        if (min >= 16) {
            System.out.println("0 0");
            return;
        }

        int k = 0;
        int maxSum = 0;

        // Проходим по всем парам подряд идущих элементов
        for (int i = 0; i < numbs.size() - 1; i++) {
            int first = numbs.get(i);
            int second = numbs.get(i + 1);

            boolean condition1 = (first % 16 == min);
            boolean condition2 = (second % 16 == min);

            System.out.println("Пара (" + first + ", " + second + "): " +
                    first + "%16=" + (first % 16) + ", " +
                    second + "%16=" + (second % 16) + ", условие: " +
                    (condition1 || condition2));

            if (condition1 || condition2) {
                k++;
                int currentSum = first + second;
                if (currentSum > maxSum) {
                    maxSum = currentSum;
                }
            }
        }

        System.out.println(k + " " + maxSum);
    }
}