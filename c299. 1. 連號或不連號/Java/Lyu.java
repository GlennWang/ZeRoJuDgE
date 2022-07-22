import java.util.Scanner;

public class Lyu {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int length = scan.nextInt();
        int nowNum = scan.nextInt();
        int min = nowNum, max = nowNum;
        for (int i = 1; i < length; i++) {
            nowNum = scan.nextInt();
            if (nowNum < min)
                min = nowNum;
            if (nowNum > max)
                max = nowNum;
        }
        System.out.println((max - min + 1 == length) ? min + " " + max + " yes" : min + " " + max + " no");
        scan.close();
    }
}