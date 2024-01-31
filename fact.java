import java.util.*;

public class fact {
    public static void fact(int n) {
        int factorial = 1;
        for (int i = 1; i <= n; i++) {
            factorial *= i;
        }
        System.out.println(factorial);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number you want the factorial");
        int num = sc.nextInt();
        fact(num);
    }
}
