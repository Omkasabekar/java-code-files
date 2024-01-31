import java.util.Scanner;

class Shape {
    double setarea(double pi, int r) {
        double cir = pi * r * r;
        System.out.print(" The area of circle is:");
        return cir;
    }

    int setarea(int side) {
        int sq = side * side;
        System.out.print(" The area of Square is:");
        return sq;

    }

    double setarea(int height, int base) {
        int tri = (base * height) / 2;
        System.out.print(" The area of Traingle is:");
        return tri;
    }

}

class Circle extends Shape {
    Scanner sc = new Scanner(System.in);

    void getInput() {
        System.out.println("Enter the radius:");
        int r = sc.nextInt();
        System.out.println(setarea(3.14, r));
    }
}

class Square extends Shape {
    Scanner sc = new Scanner(System.in);

    void getInput() {
        System.out.println("Enter the side:");
        int side = sc.nextInt();
        System.out.println(setarea(side));
    }
}

class Triangle extends Shape {
    Scanner sc = new Scanner(System.in);

    void getInput() {
        System.out.println("Enter the height:");
        int height = sc.nextInt();
        System.out.println("Enter the base:");
        int base = sc.nextInt();
        System.out.println(setarea(height, base));

    }
}

public class prm3 {
    public static void main(String[] args) {
        Circle c = new Circle();
        c.getInput();

        Square sq = new Square();
        sq.getInput();

        Triangle tq = new Triangle();
        tq.getInput();

    }

}