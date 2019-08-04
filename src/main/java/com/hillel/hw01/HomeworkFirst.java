package com.hillel.hw01;

/*
1. Поприветствовать любого пользователя при вводе его имени через аргумент командной строки.
2. Отобразить в окне консоли аргументы командной строки в обратном порядке.
3. Объявить массив с n-м количеством случайных чисел (явно инициализировать массив)
и вывести числа массива один раз с переходом(столбец) и один раз без перехода на новую строку(строка).
 */

public class HomeworkFirst {
    public void main(String[] args) {
        try {
            // task 1
            String username = args[0];
            System.out.println("Hello " + username);

            // task 2
            for (int i = args.length - 1; i >= 0; i--) System.out.println(args[i]);
        } catch (Exception e) {
            e.printStackTrace();
        }


        // task 3
        int[] numbers = new int[] {1, 2, 3, 4, 5};

        for (int i = 0; i < numbers.length; i++) System.out.println(numbers[i]);

        for (int i = 0; i < numbers.length; i++) System.out.print(numbers[i]);
    }
}
