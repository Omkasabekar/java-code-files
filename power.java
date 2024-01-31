import java.util.*;

public class power {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter number");
        int num = sc.nextInt();
        System.out.println("enter the  power");
        int pow = sc.nextInt();
        int mul = 1;
        for (int i = 0; i < pow; i++) {
            if (pow == 0) {
                System.out.println("1");

            } else if (num == 0) {
                System.out.println("0");
                break;
            } else {
                mul = mul * num;
                System.out.println(mul);
            }
        }

    }
}
