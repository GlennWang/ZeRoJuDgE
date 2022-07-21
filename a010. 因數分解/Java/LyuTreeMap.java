import java.util.Scanner;
import java.util.TreeMap;

public class LyuTreeMap {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt(), targetNum = 2;
        TreeMap<Integer, Integer> factors = new TreeMap<>();
        while (num != 1) {
            if (num % targetNum != 0)
                targetNum++;
            else {
                if (factors.containsKey(targetNum)) {
                    factors.put(targetNum, factors.get(targetNum) + 1);
                } else {
                    factors.put(targetNum, 1);
                }
                num /= targetNum;
                targetNum = 2;
            }
        }
        factors.forEach((key, value) -> {
            System.out.print((value == 1) ? key : key + "^" + value);
            if (factors.lastKey() != key)
                System.out.print(" * ");
        });
        scan.close();
    }
}