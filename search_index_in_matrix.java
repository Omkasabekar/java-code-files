import java.util.*;

public class search_index_in_matrix {
    public static void main(String[] args) {
        int A[][] = new int[3][3];
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the value of Matrix 1");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print("enter the " + (i + 1) + " row and " + (j + 1) + " coloum:");
                A[i][j] = sc.nextInt();
            }
        }
        System.out.println("The first matrix is:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(A[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("enter the index you want");
        int x = sc.nextInt();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (A[i][j] == x) {
                    System.out.println("it is found at " + (i + 1) + " row and " + (j + 1) + " coloum");
                }
            }
        }
    }
}
