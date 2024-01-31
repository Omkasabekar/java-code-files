import java.util.*;

public class find_index {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the size of an array");
        int size = sc.nextInt();
        int arr[] = new int[size];
        for (int i = 0; i < size; i++) {
            System.out.println("enter the " + (i + 1) + " element");
            arr[i] = sc.nextInt();
        }
        for (int i = 0; i < size; i++) {
            System.out.println("the value are " + arr[i]);
        }
        System.out.println("enter the value you want index");
        int num = sc.nextInt();
        for (int i = 0; i < arr.length; i++) { // i<size can also be used.
            if (arr[i] == num) {
                System.out.println("found at index " + i);
            }
        }
    }
}
