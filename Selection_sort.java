import java.util.Random;
import java.util.Scanner;

public class Selection_sort {
    public static void Selection(int arr[]){
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
    }

    public static void reverse(int arr[]){
        for(int i=0;i<arr.length/2;i++){
            int temp = arr[i];
            arr[i] = arr[arr.length-1-i];
            arr[arr.length-1-i] = temp;
        }
    }

    public static void bdisplay(int arr[]) {
        System.out.println("Before Selection Sort");    
        for(int i:arr){    
            System.out.print(i+" ");    
        }
        System.out.println();
    }

    public static void adisplay(int arr[]) {
        System.out.println("After Selection Sort");    
        for(int i:arr){    
            System.out.print(i+" ");    
        }
        System.out.println();
    }

    public static void main(String[] args) {
        
        /* Avg case */
        Random random = new Random();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number");
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
        // bdisplay(arr1);
        Selection(arr1);//sorting array using insertion sort 
        // adisplay(arr1);

        // Best Case
        /* Best case input is avg case output */
        System.out.println("\n[Best Case:-]");   
        // bdisplay(arr1); 
        Selection(arr1);
        // adisplay(arr1);

        // Wrost case
        /* Wrost case input is reverse of best case output */
        System.out.println("\n[Wrost Case:-]");   
        reverse(arr1);
        // bdisplay(arr1);
        Selection(arr1);
        // adisplay(arr1);

    }
}
