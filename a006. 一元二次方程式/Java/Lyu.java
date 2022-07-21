import java.util.Scanner;

public class Lyu {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt(), b = scan.nextInt(), c = scan.nextInt();
        int judgmental = b * b - 4 * a * c;
        if (judgmental < 0) {
            System.out.println("No real root");
        } else {
            int x1 = (int) (-b + Math.sqrt(judgmental)) / (2 * a);
            int x2 = (int) (-b - Math.sqrt(judgmental)) / (2 * a);
            System.out.println((judgmental == 0) ? "Two same roots x=" + x1
                    : "Two different roots x1=" + x1 + " , x2=" + x2);
        }
        scan.close();
    }
}