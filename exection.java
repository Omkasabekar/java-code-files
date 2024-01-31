import java.util.*;
class exection{
    public static void main (String[] args) {
        int a,b;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter two values:");
        a=sc.nextInt();
        b=sc.nextInt();
        try{
            int c=a/b;
            System.out.println(c);
        }
        catch(Exception e){
            System.out.println(e);
        }
    
        int arr[]=new int[10];
        arr[0]=1;
        arr[1]=2;
        try{
            arr[12]=12;
        }
        catch(Exception e){
            System.out.println(e);
        }
        String s="pune";
        System.out.println(s.length());
        try{
            String s1=null;
            System.out.println(s1.length());
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}