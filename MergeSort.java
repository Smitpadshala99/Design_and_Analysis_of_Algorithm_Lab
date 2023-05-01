import java.util.Random;
import java.util.Scanner;

public class MergeSort {
    static long comparisons=0;
    static long swaps=0;

    private static void mergeSort(int[] array, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;
            mergeSort(array, left, middle);
            mergeSort(array, middle + 1, right);
            merge(array, left, middle, right);
        }
    }

    private static void merge(int[] array, int left, int middle, int right) {
        int leftSize = middle - left + 1;
        int rightSize = right - middle;
        int[] leftArray = new int[leftSize];
        int[] rightArray = new int[rightSize];
        for (int i = 0; i < leftSize; i++) {
            leftArray[i] = array[left + i];
        }
        for (int i = 0; i < rightSize; i++) {
            rightArray[i] = array[middle + 1 + i];
        }
        int i = 0, j = 0, k = left;
        while (i < leftSize && j < rightSize) {
            if (leftArray[i] <= rightArray[j]) {
                array[k] = leftArray[i];
                i++;
            } else {
                array[k] = rightArray[j];
                j++;
            }
            comparisons++;
            k++;
        }
        while (i < leftSize) {
            array[k] = leftArray[i];
            i++;
            k++;
        }
        while (j < rightSize) {
            array[k] = rightArray[j];
            j++;
            k++;
        }
    }

    public static void sort(int[] array) {
        comparisons = 0;
        swaps = 0;
        long start = System.nanoTime();
        mergeSort(array, 0, array.length - 1);
        long end = System.nanoTime();
        System.out.println("Comparison:- "+comparisons+" Swaps:- "+swaps);
        System.out.println("Execution Time:- "+(end-start));
        if(isSorted(array)){
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
        Random random = new Random();
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number:- ");
        int n=sc.nextInt();
        int[] arr1 = new int[n];    
        for(int i=0;i<n;i++){
            arr1[i] = random.nextInt(n);
            for(int j=0;j<i;j++){
                if(arr1[i] == arr1[j]){
                    i--;
                    break;
                }
            }
        }
                
        System.out.println("\n[Avarage Case:-]");   
        bdisplay(arr1);
        sort(arr1);
        adisplay(arr1);

        // Best Case
        /* Best case input is avg case output */
        System.out.println("\n[Best Case:-]");   
        bdisplay(arr1); 
        sort(arr1);
        adisplay(arr1);

        // Wrost case
        /* Wrost case input is reverse of best case output */
        System.out.println("\n[Wrost Case:-]");   
        reverse(arr1);
        bdisplay(arr1);
        sort(arr1);
        adisplay(arr1);

    }
}
