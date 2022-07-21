import java.util.Scanner;

public class Lyu {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        for (char chr : input.toCharArray()) {
            System.out.print((char) (chr - 7));
        }
        scan.close();
    }
}