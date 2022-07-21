import java.util.Scanner;

public class Lyu {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        final int month = scan.nextInt();
        final int day = scan.nextInt();
        switch ((month * 2 + day) % 3) {
            case 0:
                System.out.println("普通");
                break;
            case 1:
                System.out.println("吉");
                break;
            case 2:
                System.out.println("大吉");
                break;
            default:
                break;
        }
        scan.close();
    }
}
