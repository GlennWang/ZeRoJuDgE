import java.util.Scanner;

public class Lyu {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int lines = scan.nextInt();
        for (int i = 0; i < lines; i++) {
            int[] nums = new int[4];
            for (int j = 0; j < nums.length; j++) {
                nums[j] = scan.nextInt();
                System.out.print(Integer.toString(nums[j]) + " ");
            }
            arithmeticOrGeometic(nums);
        }
        scan.close();
    }

    static private void arithmeticOrGeometic(int[] nums) {
        int diff = nums[1] - nums[0];
        System.out.println((nums[2] - nums[1] == diff && nums[3] - nums[2] == diff) ? nums[3] + diff
                : nums[3] * (nums[3] / nums[2]));
    }
}