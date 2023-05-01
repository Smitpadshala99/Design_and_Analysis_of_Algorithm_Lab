
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class All_Sort {

    public static void reverse(int arr[]){
        for(int i=0;i<arr.length/2;i++){
            int temp = arr[i];
            arr[i] = arr[arr.length-1-i];
            arr[arr.length-1-i] = temp;
        }
    }

    public static void isSorted(int[] a) {
        boolean s;
        for (int i=1; i<a.length; i++) {
            if (a[i] < a[i-1]) {
                System.out.println("Array is not Sorted");
                break;
            }
        }
        System.out.println("Array is Sorted");
    }

    public static int[] sort(int[] arr) {
        // Creating objects of Insertion, Selection, QuickSort, and MergeSort classes
        Insertion i = new Insertion();
        Selection s = new Selection();
        QuickSort q = new QuickSort();
        MergeSort m = new MergeSort();

        i.Insertion(Arrays.copyOf(arr, arr.length));
        s.Selection(Arrays.copyOf(arr, arr.length));
        q.qsort(Arrays.copyOf(arr, arr.length));
        // m.msort(Arrays.copyOf(arr, arr.length));
        m.msort(arr);

        isSorted(arr);

        return arr;
    }

    public static void main(String[] args) {

        display d = new display();
        Random random = new Random();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number:- ");
        int n=sc.nextInt();
        int[] arr1 = new int[n];    
        // Generate unique random numbers
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
        // d.bdisplay(arr1);
        sort(arr1);
        // d.adisplay(arr1);

        // Best Case
        /* Best case input is avg case output */
        System.out.println("\n[Best Case:-]");   
        // d.bdisplay(arr1); 
        sort(arr1);
        // d.adisplay(arr1);

        // Wrost case
        /* Wrost case input is reverse of best case output */
        System.out.println("\n[Wrost Case:-]");   
        reverse(arr1);
        // d.bdisplay(arr1);
        sort(arr1);
        // d.adisplay(arr1);
    }
}
class Insertion{
    public void Insertion(int arr[]){ 
        display di = new display();
        System.out.println("\nInsertion sort");
        di.bdisplay(arr);
        long comp=0;
        long swap=0;
        long starti = System.nanoTime();
        for (int j = 1; j < arr.length; j++) {  
            int key = arr[j];  
            int i = j-1;  
            while ( (i > -1) && ( arr[i] > key ) ) {  
                arr[i+1] = arr[i];  
                i--; 
                comp++;
            }  
            arr[i+1] = key; 
            comp++; 
        } 
        long endi = System.nanoTime();
        System.out.println("Comparison:- "+comp+" Swaps:- "+swap);
        System.out.println("Execution Time:- " + (endi-starti)+ " nanosecond");
        di.adisplay(arr);
    }
}

class Selection{
    public void Selection(int arr[]){
        display ds = new display();
        System.out.println("\nSelection sort");
        ds.bdisplay(arr);
        int comp=0,swap=0;
        long start = System.nanoTime();
        for(int i=0;i<arr.length-1;i++){
            int min=i;
            for(int j=min+1;j<arr.length;j++){
                comp++;
                if(arr[j] < arr[min]){
                    min = j;
                }
            }
            if(min!=i){

            swap++;
            arr[min] = arr[min] + arr[i];
            arr[i] = arr[min] - arr[i];
            arr[min] = arr[min] - arr[i];
            // int temp = arr[min];
            // arr[min] = arr[i];
            // arr[i] = temp;
            }
        }
        long end = System.nanoTime();
        System.out.println("Comparison:- "+comp+" swaps:- "+swap);
        System.out.println("Execution Time:- "+ (end-start)+" nanoseconds");
        ds.adisplay(arr);
    }

}


class QuickSort{

    static long comparisonCount;
    static long swapCount;
    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low-1);
        for (int j=low; j<high; j++) {
            comparisonCount++;
            if (arr[j] <= pivot) {
                i++;
                // swap(arr, i, j);
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                swapCount++;
            }
        }
        // swap(arr, i+1, high);
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;
        // swapCount++;
        return i+1;
    }

    public static void quicksort(int[] arr, int left, int right) {
        if(left<right){
            int pi=partition(arr, left, right);
            quicksort(arr, left, pi-1);
            quicksort(arr, pi+1, right);
        }
    }

    public void qsort(int[] arr) {
        display dq = new display();
        System.out.println("\nQuick sort");
        dq.bdisplay(arr);
        comparisonCount=0;
        swapCount=0;
        long start = System.nanoTime();
        quicksort(arr, 0, arr.length-1);
        long end = System.nanoTime();
        System.out.println("Comparison:- "+comparisonCount+"\tSwaps:- "+swapCount);
        System.out.println("Execution Time:- " + (end-start)+ " nanosecond"); 
        dq.adisplay(arr);
    }
}

// Merge Sort Class
class MergeSort{

    static long comparisons=0;
    static long swaps=0;
    public static void mergeSort(int[] array, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;
            mergeSort(array, left, middle);
            mergeSort(array, middle + 1, right);
            merge(array, left, middle, right);
        }
    }

    public static void merge(int[] array, int left, int middle, int right) {
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

    public void msort(int[] array) {
        display dm =new display();
        System.out.println("\nMerge Sort");
        dm.bdisplay(array);
        comparisons = 0;
        swaps = 0;
        long start = System.nanoTime();
        mergeSort(array, 0, array.length - 1);
        long end = System.nanoTime();
        System.out.println("Comparison:- "+comparisons+" Swaps:- "+swaps);
        System.out.println("Execution Time:- "+(end-start)); 
        dm.adisplay(array);
    }
}

class display{
    public void bdisplay(int arr[]) {
        if(arr.length<=10){
        System.out.println("Before Sort");    
        for(int i:arr){    
            System.out.print(i+" ");    
        }
        System.out.println();
        }
    }

    public void adisplay(int arr[]) {
        if(arr.length<=10){
        System.out.println("After Sort");    
        for(int i:arr){    
            System.out.print(i+" ");    
        }
        System.out.println();
        }
    }

}


