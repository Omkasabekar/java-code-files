//1 type to write.

/* 
class Student {
    String name;
    int age;

    public void Printinfo() {
        System.out.println(this.name);
        System.out.println(this.age);
    }

    Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

public class para {
    public static void main(String[] args) {
        Student s1 = new Student("om", 19);
        s1.Printinfo();
    }
}
*/

//2 type
/*
class Student {
    String name;
    int age;

    public void Print(String name, int age) {
        System.out.println(name);
        System.out.println(age);
    }
}

class para {
    public static void main(String[] args) {
        Student s1 = new Student();
    
        s1.Print("om", 19);
    }
}
 */

//3 type
class Student {
    String name;
    int age;

    public void print() {
        System.out.println(this.name);
        System.out.println(this.age);
    }
}

class para {
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.name = "om";
        s1.age = 19;
        s1.print();
    }
}
