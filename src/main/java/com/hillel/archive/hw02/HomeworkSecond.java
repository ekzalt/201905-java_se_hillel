package com.hillel.archive.hw02;

/*
1. Объявить массив с n-м количеством случайных чисел (явно инициализировать массив) и выбрать из него четные и нечетные числа.
2. Объявить массив с n-м количеством случайных чисел (явно инициализировать массив) и выбрать из него простые числа.
3. Создайте массив из 20-ти первых чисел Фибоначчи и выведите его на экран
(первый и второй члены последовательности равны единицам, а каждый следующий — сумме двух предыдущих)
4. Объявить массив с n-м количеством случайных чисел (явно инициализировать массив) и выбрать из него наибольшее и наименьшее число
5. Умножить две матрицы ( https://goo.gl/BMNaD3 )
6. Задать массив с n чисел. Найти самое короткое и самое длинное число. Вывести найденные числа и их длину.
7. Задать массив с n чисел. Найти числа, состоящее только из различных цифр.
8. Вывести числа от 1 до k в виде матрицы N x N слева направо и сверху вниз
 */

public class HomeworkSecond {
    private int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    private int[][] matrixA = {
            {10, 20},
            {0, 0},
            {30, 40},
            {0, 0},
    };
    private int[][] matrixB = {
            {0, 50, 60},
            {0, 70, 80},
    };
    private int[] bigIntegers = {1, 12, 123, 1234, 12345, 123456, 1234567, 12345678, 123456789, 1234567890};
    private int[] diffIntegers = {123, 321, 456, 654, 789, 987};

    public void printOddEven(int[] list) {
        for (int i: list) {
            if (i % 2 == 0) System.out.println("even: " + i);
            else System.out.println("odd: " + i);
        }
    }

    public void printSimple(int[] list) {
        for (int i: list) {
            if (i <= 1) continue;

            boolean isSimple = true;

            for (int j: list) {
                if (j <= 1) continue;

                if (i != j && i % j == 0) {
                    isSimple = false;
                    break;
                }
            }

            if (isSimple) System.out.println("simple: " + i);
        }
    }

    public void printFibo(int max) {
        int prev = 1, last = 0, sum;

        for (int i = 0; i < max; i++) {
            sum = prev + last;
            prev = last;
            last = sum;

            System.out.println("fibo" + (i + 1) + ": " + sum);
        }
    }

    public int[] getMinAndMax(int[] list) {
        int min, max;
        min = max = list[0];

        for (int i: list) {
            if (i < min) min = i;
            if (i > max) max = i;
        }

        return new int[] {min, max};
    }

    public int[][] multiplyMatrix(int[][] m1, int[][] m2) throws UnsupportedOperationException {
        int m1ColLength = m1[0].length;
        int m2RowLength = m2.length;

        if(m1ColLength != m2RowLength) throw new UnsupportedOperationException("Unsupported Matrix");

        int mRRowLength = m1.length;
        int mRColLength = m2[0].length;
        int [][] mResult = new int[mRRowLength][mRColLength];

        for (int i = 0; i < mRRowLength; i++) {
            for (int j = 0; j < mRColLength; j++) {
                for (int k = 0; k < m1ColLength; k++) mResult[i][j] += m1[i][k] * m2[k][j];
            }
        }

        return mResult;
    }

    public String toString(int[][] m) {
        String result = "";

        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) result += (m[i][j] + " ");

            result += "\n";
        }

        return result;
    }

    public int getLength(int number) {
        int length = 0;
        int divided = number;

        do {
            divided = divided / 10;
            length++;
        } while (divided != 0);

        return length;
    }

    public void printDiffIntegers(int[] list) {
        int[] acc = new int[10];

        for (int i: list) {
            char[] chars = ("" + i).toCharArray();
            boolean found = false;

            // check every char
            for (char ch: chars) {
                int j = Character.getNumericValue(ch);

                if(acc[j] != 0) {
                    found = true;
                    break;
                }
            }

            if (!found) System.out.println("Unique for now: " + i);

            // add every char
            for (char ch: chars) {
                int j = Character.getNumericValue(ch);
                acc[j] = j;
            }
        }
    }

    public int[][] buildMatrix(int start, int size, boolean vertical) {
        int value = start;
        int[][] matrix = new int[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (vertical) matrix[j][i] = value++;
                else matrix[i][j] = value++;
            }
        }

        return matrix;
    }

    public void run() {
        System.out.println("\ntask 1\n");
        printOddEven(numbers);

        System.out.println("\ntask 2\n");
        printSimple(numbers);

        System.out.println("\ntask 3\n");
        printFibo(20);

        System.out.println("\ntask 4\n");
        int[] minAndMax = getMinAndMax(bigIntegers);
        int min = minAndMax[0];
        int max = minAndMax[1];
        System.out.println("min: " + min + ", max: " + max);

        System.out.println("\ntask 5\n");
        System.out.println(toString(multiplyMatrix(matrixA, matrixB)));

        System.out.println("\ntask 6\n");
        System.out.println("min length: " + getLength(min) + ", max length: " + getLength(max));

        System.out.println("\ntask 7\n");
        printDiffIntegers(diffIntegers);

        System.out.println("\ntask 8\n");
        System.out.println(toString(buildMatrix(1, 3, false)));
        System.out.println(toString(buildMatrix(1, 3, true)));
    }
}
