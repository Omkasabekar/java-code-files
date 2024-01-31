import java.util.*;

public class fun {
    public static int calc(int a, int b) {
        int add = a + b;
        return add;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter first number");
        int a = sc.nextInt();
        System.out.println("enter second number");
        int b = sc.nextInt();
        System.out.println(calc(a, b));

    }

}
