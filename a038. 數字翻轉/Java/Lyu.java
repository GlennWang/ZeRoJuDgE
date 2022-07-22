import java.util.Scanner;

public class Lyu {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String numString = scan.nextLine();
        int stringLength = numString.length(), result = 0;
        for (int i = 0; i < stringLength; i++)
            result += (numString.charAt(i) - '0') * Math.pow(10, i);
        System.out.println(result);
        scan.close();
    }
}