import java.util.*;

class ADS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("1. for aryh and 2. for quadratic");
        int num = sc.nextInt();
        switch (num) {
            case 1:
                String expression = "2 * (3 + 4) / 5 - 6";
                Stack<Double> operands = new Stack<>();
                Stack<Character> operators = new Stack<>();
                int i = 0;
                while (i < expression.length()) {
                    if (expression.charAt(i) == '(') {
                        operators.push('(');
                        i++;
                    } else if (expression.charAt(i) == ')') {
                        while (operators.peek() != '(') {
                            double operand2 = operands.pop();
                            double operand1 = operands.pop();
                            char operator = operators.pop();
                            operands.push(applyOperator(operand1, operand2, operator));
                        }
                        operators.pop();
                        i++;
                    } else if (Character.isDigit(expression.charAt(i))) {
                        int j = i;
                        while (j < expression.length()
                                && (Character.isDigit(expression.charAt(j)) || expression.charAt(j) == '.')) {
                            j++;
                        }
                        operands.push(Double.parseDouble(expression.substring(i, j)));
                        i = j;
                    } else if (expression.charAt(i) == '+' || expression.charAt(i) == '-' || expression.charAt(i) == '*'
                            || expression.charAt(i) == '/') {
                        while (!operators.isEmpty()
                                && precedence(operators.peek()) >= precedence(expression.charAt(i))) {
                            double operand2 = operands.pop();
                            double operand1 = operands.pop();
                            char operator = operators.pop();
                            operands.push(applyOperator(operand1, operand2, operator));
                        }
                        operators.push(expression.charAt(i));
                        i++;
                    } else if (Character.isWhitespace(expression.charAt(i))) {
                        i++;
                    } else {
                        throw new IllegalArgumentException("Invalid character: " + expression.charAt(i));
                    }
                }
                while (!operators.isEmpty()) {
                    double operand2 = operands.pop();
                    double operand1 = operands.pop();
                    char operator = operators.pop();
                    operands.push(applyOperator(operand1, operand2, operator));
                }
                System.out.println(operands.pop());

                break;

            case 2:
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
            default:
                System.out.println("enter the valid number");
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

    public static double applyOperator(double operand1, double operand2, char operator) {
        switch (operator) {
            case '+':
                return operand1 + operand2;
            case '-':
                return operand1 - operand2;
            case '*':
                return operand1 * operand2;
            case '/':
                return operand1 / operand2;
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }
}