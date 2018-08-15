import java.util.Scanner;

class APlusB {
    static int sumOfTwoDigits(int firstDigit, int secondDigit) {
        return firstDigit + secondDigit;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int a = s.nextInt();
        int b = s.nextInt();
        System.out.println(sumOfTwoDigits(a, b));
    }
}