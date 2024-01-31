import java.util.*;
import java.io.*;

public class Finalpro {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("1.Quadratic solver\n2.Arithmatic solver");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                System.out.print("Enter the value of a: ");
                double a = sc.nextDouble();
                System.out.print("Enter the value of b: ");
                double b = sc.nextDouble();
                System.out.print("Enter the value of c: ");
                double c = sc.nextDouble();
                double x1 = 0, x2 = 0;
                double discr = b * b - 4 * a * c;
                Stack<Double> stack = new Stack<>();
                if (discr > 0) {
                    x1 = (-b + Math.sqrt(discr)) / (2 * a);
                    x2 = (-b - Math.sqrt(discr)) / (2 * a);
                    stack.push(x1);
                    stack.push(x2);
                } else if (discr == 0) {
                    x1 = -b / (2 * a);
                    stack.push(x1);
                } else {
                    System.out.println("The equation has no real roots.");
                    return;
                }

                System.out.print("The roots of the equation are: ");
                while (!stack.empty()) {
                    System.out.print(stack.pop() + " ");
                }
                break;

            case 2:

                Stack<Integer> opnds = new Stack<>();
                Stack<Character> optors = new Stack<>();
                String exp = br.readLine();
                // Scanner sc = new Scanner(System.in);
                // String exp = sc.nextLine();
                for (int i = 0; i < exp.length(); i++) {
                    char ch = exp.charAt(i);
                    if (ch == '(') {
                        optors.push(ch);
                    } else if (Character.isDigit(ch)) {
                        opnds.push(ch - '0');
                    } else if (ch == ')') {
                        while (optors.peek() != '(') {
                            char optor = optors.pop();
                            int v2 = opnds.pop();
                            int v1 = opnds.pop();
                            int opv = operation(v1, v2, optor);
                            opnds.push(opv);
                        }
                        optors.pop(); // by doing operation and atlast pushing final value
                    } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                        while (optors.size() > 0 && optors.peek() != '('
                                && precedence(ch) <= precedence(optors.peek())) {
                            char optor = optors.pop();
                            int v2 = opnds.pop();
                            int v1 = opnds.pop();
                            int opv = operation(v1, v2, optor);
                            opnds.push(opv);
                        }
                        optors.push(ch); // by removing less pirority and to push present optors.
                    }
                }

                while (optors.size() != 0) {
                    char optor = optors.pop();
                    int v2 = opnds.pop();
                    int v1 = opnds.pop();
                    int opv = operation(v1, v2, optor);
                    opnds.push(opv);
                }
                Stack<String> post = new Stack<>();
                Stack<String> pre = new Stack<>();
                Stack<Character> ops = new Stack<>();

                for (int i = 0; i < exp.length(); i++) {
                    char ch = exp.charAt(i);
                    if (ch == '(') {
                        ops.push(ch);
                    } else if ((ch >= '0' && ch <= '9') || (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) {
                        post.push(ch + "");
                        pre.push(ch + "");
                    } else if (ch == ')') {
                        while (ops.peek() != '(') {
                            char op = ops.pop();
                            String postv2 = post.pop();
                            String postv1 = post.pop();
                            String postv = postv1 + postv2 + op;
                            post.push(postv);

                            String prev2 = pre.pop();
                            String prev1 = pre.pop();
                            String prev = op + prev1 + prev2;
                            pre.push(prev);

                        }
                        ops.pop();
                    } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                        while (ops.size() > 0 && ops.peek() != '(' && precedence(ch) <= precedence(ops.peek())) {
                            char op = ops.pop();
                            String postv2 = post.pop();
                            String postv1 = post.pop();
                            String postv = postv1 + postv2 + op;
                            post.push(postv);

                            String prev2 = pre.pop();
                            String prev1 = pre.pop();
                            String prev = op + prev1 + prev2;
                            pre.push(prev);
                        }
                        ops.push(ch);
                    }
                }
                while (ops.size() > 0) {
                    char op = ops.pop();
                    String postv2 = post.pop();
                    String postv1 = post.pop();
                    String postv = postv1 + postv2 + op;
                    post.push(postv);

                    String prev2 = pre.pop();
                    String prev1 = pre.pop();
                    String prev = op + prev1 + prev2;
                    pre.push(prev);

                }
                System.out.println("postfix:" + post.pop());
                System.out.println("prefix:" + pre.pop());
                System.out.println(opnds.peek());

        }
    }

    public static int precedence(char optor) {
        if (optor == '+') {
            return 1;
        } else if (optor == '-') {
            return 1;
        } else if (optor == '*') {
            return 2;
        } else if (optor == '/') {
            return 2;
        } else {
            return 0;
        }
    }

    public static int operation(int v1, int v2, char optor) {
        if (optor == '+') {
            return v1 + v2;
        } else if (optor == '-') {
            return v1 - v2;
        } else if (optor == '*') {
            return v1 * v2;
        } else {
            return v1 / v2;
        }
    }
}
