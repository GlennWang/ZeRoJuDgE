import java.util.Scanner;

public class Lyu {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in).useDelimiter("");
        int[] ENcode = { 10, 11, 12, 13, 14, 15, 16, 17, 34, 18, 19, 20, 21, 22, 35, 23, 24, 25, 26, 27, 28, 29, 32, 30,
                31, 33 };
        int decodeNum = ENcode[scan.next().charAt(0) - 'A'];
        int verify = decodeNum / 10 + decodeNum % 10 * 9;
        for (int i = 8; i >= 1; i--) {
            verify += (scan.next().charAt(0) - '0') * i;
        }
        verify += scan.next().charAt(0) - '0';
        System.out.println((verify % 10 == 0) ? "real" : "fake");
        scan.close();
    }
}