public class number {
  public static void main(String[] args) {
    int n = 10;
    int m = n - 1;
    for (int i = 0; i <= n; i++) {
      for (int j = 0; j < m; j++) {
        System.out.print(" ");
      }
      m--;
      for (int k = 1; k <= i; k++) {
        System.out.print(k + " ");
      }
      System.out.print("\n");
    }
  }
}
