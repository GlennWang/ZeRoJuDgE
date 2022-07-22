import java.util.Scanner;

public class Lyu {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            String line = scan.nextLine();
            if (line.charAt(0) == '#')
                break;
            String[] strings = (line.split(" "));
            int[] nums = new int[2];
            nums[0] = decodeString(strings[0]);
            nums[1] = decodeString(strings[1]);
            printResult(nums);
        }
        scan.close();
    }

    private static int decodeRoma(char chr) {
        char[] romaNums = { 'I', 'V', 'X', 'L', 'C', 'D', 'M' };
        int num = 1;
        for (int i = 0; i < romaNums.length; i++) {
            if (chr == romaNums[i])
                return num;
            else {
                num *= (i % 2 == 0) ? 5 : 2;
            }
        }
        return 0;
    }

    private static int decodeString(String str) {
        int result = 0, decodeNum = 0;
        int previousNum = 1001;
        for (char c : str.toCharArray()) {
            decodeNum = decodeRoma(c);
            result += decodeNum;
            if (previousNum < decodeNum) {
                result -= 2 * previousNum;
            }
            previousNum = decodeNum;
        }
        return result;
    }

    private static void printResult(int[] nums) {
        char[] romaNums = { 'I', 'V', 'X', 'L', 'C', 'D', 'M' };
        int index = 6, digit = 1000, digitNum = 0;
        int result = (nums[0] > nums[1]) ? nums[0] - nums[1] : nums[1] - nums[0];
        if (result == 0) {
            System.out.println("ZERO");
            return;
        }
        while (digit > 0) {
            digitNum = result / digit;
            if (digitNum < 4) {
                for (int i = 0; i < digitNum; i++) {
                    System.out.print(romaNums[index]);
                }
            } else if (digitNum == 4) {
                System.out.printf("%c%c", romaNums[index], romaNums[index + 1]);
            } else if (digitNum < 9) {
                System.out.print(romaNums[index + 1]);
                for (int i = 5; i < digitNum; i++) {
                    System.out.print(romaNums[index]);
                }
            } else {
                System.out.printf("%c%c", romaNums[index], romaNums[index + 2]);
            }
            result -= digitNum * digit;
            digit /= 10;
            index -= 2;
        }
        System.out.println();
    }
}