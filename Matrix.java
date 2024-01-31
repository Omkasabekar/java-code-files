import java.util.*;

public class Matrix {
    public static void main(String[] args) {
        int A[][] = new int[3][3];
        int B[][] = new int[3][3];
        int add[][] = new int[3][3];
        int sub[][] = new int[3][3];
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the value of Matrix 1");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print("enter the " + (i + 1) + " row and " + (j + 1) + " coloum:");
                A[i][j] = sc.nextInt();
            }
        }
        System.out.println("enter the value of matrix 2");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print("enter the " + (i + 1) + " row and " + (j + 1) + " coloum:");
                B[i][j] = sc.nextInt();
            }
        }
        System.out.println("The first matrix is:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(A[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("The second matrix is:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(B[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("the addition of two matrix is:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                add[i][j] = A[i][j] + B[i][j];
                System.out.print(add[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("the substraction of two matrix is:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                sub[i][j] = A[i][j] - B[i][j];
                System.out.print(sub[i][j] + " ");
            }
            System.out.println();
        }
    }
}
