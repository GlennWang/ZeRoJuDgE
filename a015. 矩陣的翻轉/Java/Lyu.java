import java.util.Scanner;

public class Lyu {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            int arrayX = scan.nextInt(), arrayY = scan.nextInt();
            int[] array = new int[arrayX * arrayY];
            for (int i = 0; i < array.length; i++) {
                array[i] = scan.nextInt();
            }
            for (int i = 0; i < arrayY; i++) {
                for (int j = 0; j < arrayX; j++) {
                    System.out.print(array[i + j * arrayY] + " ");
                }
                System.out.println();
            }
        }
        scan.close();
    }
}