 import java.util.Scanner;

interface Power {
    int apply(int a, int b);

    default int square(int a) {
        return a * a;
    }
}

public class DefaultPower {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Power power = (x, y) -> (int) Math.pow(x, y);

        System.out.print("Enter base: ");
        int base = sc.nextInt();
        System.out.print("Enter exponent: ");
        int exp = sc.nextInt();

        System.out.println(base + "^" + exp + " = " + power.apply(base, exp));
        System.out.print("Enter number to square: ");
        int num = sc.nextInt();
        System.out.println("Square = " + power.square(num));
    }
}
 
