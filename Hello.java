import java.util.Scanner;

class Hello {
    static int[] abc(int[] a) {
        int n = a.length;
        int[] fac = new int[n];

        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 1; j * j <= a[i]; j++) {

                if (a[i] % j == 0) {
                    count = count + 2;
                }
            }
            fac[i] = count;
        }

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (fac[j] > fac[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                    int temp1 = fac[j];
                    fac[j] = fac[j + 1];
                    fac[j + 1] = temp1;
                } else if (fac[j] == fac[j + 1]) {
                    if (a[j] < a[j + 1]) {
                        int temp = a[j];
                        a[j] = a[j + 1];
                        a[j + 1] = temp;
                    }
                }
            }
        }
        return a;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int b[] = new int[n];
        b = abc(a);
        for (int i = 0; i < n; i++) {
            System.out.println(b[i]);
        }
    }
}