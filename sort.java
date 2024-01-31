
//Bubble sort
/* 
import java.util.*;
class sort{
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        int arr[]={8,3,5,9,4,1};
        bubblesort(arr);
        System.out.println(Arrays.toString(arr));
    }
    static int[] bubblesort(int arr[]){
        boolean swap;
        for(int i=0;i<arr.length;i++){
            swap=false;
            for(int j=1;j<arr.length-i;j++){
                if(arr[j-1]>arr[j]){
                    int temp=arr[j];
                    arr[j]=arr[j-1];
                    arr[j-1]=temp;
                    swap=true;
                }
            }
            if(swap==false){
                break;
            }
        }
        return arr;
    }
}
*/

// selection sort
/* 
import java.util.*;
class sort{
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        int arr[]={8,3,5,9,4,1};
        selectionsort(arr);
        System.out.println(Arrays.toString(arr));
    }
    static int[] selectionsort(int arr[]){
        for(int i=0;i<arr.length;i++){
            int small=i;
            for(int j=i+1;j<arr.length;j++){
                if(arr[small]>arr[j]){
                   small=j;
                }
            }
            int temp=arr[i];
            arr[i]=arr[small];
            arr[small]=temp;
        }
        return arr;
    }
}
*/

//insertion sort
/*
    import java.util.*;
class Main{
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        int arr[]={8,3,5,9,4,1};
        insertionsort(arr);
        System.out.println(Arrays.toString(arr));
    }
    static int[] insertionsort(int arr[]){
        for(int i=0;i<arr.length-1;i++){
            for(int j=i+1;j>0;j--){
                if(arr[j-1]>arr[j]){
                   int temp=arr[j];
                   arr[j]=arr[j-1];
                   arr[j-1]=temp;
                }
                else{
                    break;
                }
            }
        }
        return arr;
    }
}
*/

//cyclic sort
/*
import java.util.*;
class sort{
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        int arr[]={6,3,5,2,4,1};
        cyclelicsort(arr);
        System.out.println(Arrays.toString(arr));
    }
    static int[] cyclelicsort(int arr[]){
        for(int i=0;i<arr.length;i++){
            int correct=arr[i]-1;
            if(arr[correct]!=arr[i]){
               int temp=arr[correct];
               arr[correct]=arr[i];
               arr[i]=temp;
            }
        }
        return arr;
    }
}
*/

// Merge sort
/* 
import java.util.*;

public class sort {
    public static void main(String[] args) {
        int arr[] = { 3, 5, 1, 3, 2, 8, 7, 4 };
        System.out.println(Arrays.toString(Mergesort(arr)));
    }

    static int[] Mergesort(int arr[]) {
        if (arr.length == 1) {
            return arr;
        }
        int mid = arr.length / 2;
        int[] left = Mergesort(Arrays.copyOfRange(arr, 0, mid));
        int[] right = Mergesort(Arrays.copyOfRange(arr, mid, arr.length));
        return merge(left, right);
    }

    static int[] merge(int[] left, int[] right) {
        int i = 0;
        int j = 0;
        int k = 0;
        int arr3[] = new int[left.length + right.length];
        while (i < left.length && j < right.length) {
            if (left[i] < right[j]) {
                arr3[k] = left[i];
                i++;
            } else {
                arr3[k] = right[j];
                j++;
            }
            k++;
        }
        while (i < left.length) {
            arr3[k] = left[i];
            i++;
            k++;
        }
        while (j < right.length) {
            arr3[k] = right[j];
            j++;
            k++;
        }
        return arr3;
    }
}
*/
//Quick sort
import java.util.*;

class sort {
    public static void main(String[] args) {
        int arr[] = { 5, 4, 3, 2, 1 };
        Sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    static void Sort(int[] nums, int low, int high) {
        if (low >= high) {
            return;
        }
        int s = low;
        int e = high;
        int m = (e + s) / 2;
        int pivot = nums[m];
        while (s <= e) {
            while (nums[s] < pivot) {
                s++;
            }
            while (nums[e] > pivot) {
                e--;
            }
            if (s <= e) {
                int temp = nums[s];
                nums[s] = nums[e];
                nums[e] = temp;
                s++;
                e--;
            }
        }
        // pivote is at correct index now sort that 2 havles
        Sort(nums, low, e);
        Sort(nums, s, high);
    }
}