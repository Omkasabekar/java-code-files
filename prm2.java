import java.util.*;

public class prm2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size, target;
        System.out.print("enter the size of an array:");
        size = sc.nextInt();
        System.out.print("enter the target you want to get:");
        target = sc.nextInt();
        int a[] = new int[size];

        for (int i = 0; i < a.length; i++) {
            System.out.print("enter the " + (i + 1) + " element:");
            a[i] = sc.nextInt();
        }
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] + a[j] == target) {
                    System.out.println("the target is achieved by adding (" + a[i] + "," + a[j] + ")");

                }
            }


            
        }
    }
}
