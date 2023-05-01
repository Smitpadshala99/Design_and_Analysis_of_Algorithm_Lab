// for n=100000 use terminal write java -Xss128m QuickSort.java (file name)
import java.util.Random;
import java.util.Scanner;

public class QuickSort {
    static long comparisonCount;
    static long swapCount;
    public static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        swapCount++;
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low-1);
        for (int j=low; j<high; j++) {
            comparisonCount++;
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i+1, high);
        return i+1;
    }

    public static void quicksort(int[] arr, int left, int right) {
        if(left<right){
            int pi=partition(arr, left, right);
            quicksort(arr, left, pi-1);
            quicksort(arr, pi+1, right);
        }
    }

    public static void sort(int[] arr) {
        comparisonCount=0;
        swapCount=0;
        long start = System.nanoTime();
        quicksort(arr, 0, arr.length-1);
        long end = System.nanoTime();
        System.out.println("\nComparison:- "+comparisonCount+"\tSwaps:- "+swapCount);
        System.out.println("Execution Time:- " + (end-start)+ " nanosecond");
        if(isSorted(arr)){
            System.out.println("Array is sorted");
        } else{
            System.out.println("Array is not sorted");
        }    
    }

        public static void reverse(int arr[]){
            for(int i=0;i<arr.length/2;i++){
                int temp = arr[i];
                arr[i] = arr[arr.length-1-i];
                arr[arr.length-1-i] = temp;
            }
        }
    
        public static boolean isSorted(int[] a) {
            for (int i=1; i<a.length; i++) {
                if (a[i] < a[i-1]) {
                    return false;
                }
            }
            return true;
        }

        public static void bdisplay(int arr[]) {
            if(arr.length<=10){ 
            System.out.println("Before Sort"); 
            for(int i:arr){    
                System.out.print(i+" ");    
            }
            System.out.println();
            }
        }
    
        public static void adisplay(int arr[]) {
            if(arr.length<=10){
            System.out.println("After Sort");    
            for(int i:arr){    
                System.out.print(i+" ");    
            }
            System.out.println();
            }
        }


    public static void main(String[] args) {
        System.out.println("Enter a number: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        Random random = new Random();

        // Generate unique random numbers
        for(int i=0;i<n;i++){
            arr[i] = random.nextInt(n);
            for(int j=0;j<i;j++){
                if(arr[i] == arr[j]){
                    i--;
                    break;
                }
            }
        }

        System.out.println("\n[Avarage Case:-]");   
        bdisplay(arr);
        sort(arr);
        adisplay(arr);

        // Best Case
        /* Best case input is avg case output */
        System.out.println("\n[Best Case:-]");   
        bdisplay(arr); 
        sort(arr);
        adisplay(arr);


        // Wrost case
        /* Wrost case input is reverse of best case output */
        System.out.println("\n[Wrost Case:-]");   
        reverse(arr);
        bdisplay(arr);
        sort(arr);
        adisplay(arr);

    }
}