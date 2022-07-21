import java.util.Scanner;

public class Lyu {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt(), b = scan.nextInt(), c = scan.nextInt();
        int judgmental = b * b - 4 * a * c;
        if (judgmental < 0) {
            System.out.println("No real root");
        } else {
            double x1 = (-b + Math.sqrt(judgmental)) / (2 * a);
            double x2 = (-b - Math.sqrt(judgmental)) / (2 * a);
            System.out.println((judgmental == 0) ? "Two same roots x=" + Integer.toString((int) x1)
                    : "Two different roots x1=" + Integer.toString((int) x1) + " , x2=" + Integer.toString((int) x2));
        }
        scan.close();
    }
}