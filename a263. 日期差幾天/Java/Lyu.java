import java.util.Scanner;

public class Lyu {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            int y1 = scan.nextInt(), m1 = scan.nextInt(), d1 = scan.nextInt();
            int y2 = scan.nextInt(), m2 = scan.nextInt(), d2 = scan.nextInt();
            System.out.println(Math.abs(dayOfDate(y1, m1, d1) - dayOfDate(y2, m2, d2)));
        }
        scan.close();
    }

    private static int dayOfDate(int y, int m, int d) {
        int days = (m > 2 && (y % 4 == 0 && y % 100 != 0 || y % 400 == 0)) ? 1 : 0;
        int[] dayOfMonth = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        y -= 1; // 目標年不滿一年 先扣除
        days += y * 365 + y / 4 - y / 100 + y / 400;
        m -= 1;
        for (int i = 0; i < m; i++)
            days += dayOfMonth[i];
        days += d;
        return days;
    }
}