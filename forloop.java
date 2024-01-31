import java.util.*;

public class forloop {
    public static void main(String[] args) {
        int sum = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the number you want sum:");
        int num = sc.nextInt();
        for (int i = 0; i <= num; i++) {
            sum = sum + i;
        }
        System.out.println(sum);
    }

}
