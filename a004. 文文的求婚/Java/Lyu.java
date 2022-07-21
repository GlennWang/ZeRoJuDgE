import java.util.Scanner;

public class Lyu {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int year;
        while (scan.hasNext()) {
            year = scan.nextInt();
            System.out.println((year % 4 == 0 && year % 100 != 0 || year % 400 == 0) ? "閏年" : "平年");
        }
        scan.close();
    }
}