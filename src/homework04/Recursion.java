package homework04;

public class Recursion {
    public void printIntegers(int max) {
        if (max < 1) {
            return;
        }

        printIntegers(max - 1);
        System.out.println(max);
    }

    public int sumIntegers(int num) {
        return num < 10 ? num : ((num % 10) + sumIntegers( num / 10 ));
    }
}
