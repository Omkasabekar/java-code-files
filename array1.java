import java.util.*;

public class array1 {
    public static void main(String[] args) {
        int arr[] = new int[3];
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            System.out.print("enter the " + (i + 1) + " value:");
            arr[i] = sc.nextInt();
        }
        for (int i = 0; i < 3; i++) {
            System.out.println("the value of arr is" + arr[i]);
        }
    }
}
