import java.util.Scanner;

public class Lyu {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt(), targetNum = 2;
        while (num != 1) {
            if (num % targetNum != 0)
                targetNum++;
            else {
                System.out.print(targetNum);
                int count = 0;
                do {
                    num /= targetNum;
                    count++;
                } while (num % targetNum == 0);
                if (count > 1)
                    System.out.printf("^%d", count);
                if (num != 1)
                    System.out.print(" * ");
                targetNum = 2;
            }
        }
        scan.close();
    }
}