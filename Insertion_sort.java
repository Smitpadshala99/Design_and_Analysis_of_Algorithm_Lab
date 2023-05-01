import java.util.Random;
import java.util.Scanner;

public class Insertion_sort {    
    public static void Insertion(int arr[]){  
        long comp=0;
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
        System.out.println("\nComparison:- "+comp);
        System.out.println("Execution Time:- " + (endi-starti)+ " nanosecond");
    }

    public static void reverse(int arr[]){
        for(int i=0;i<arr.length/2;i++){
            int temp = arr[i];
            arr[i] = arr[arr.length-1-i];
            arr[arr.length-1-i] = temp;
        }
    }

    public static void bdisplay(int arr[]) {
        System.out.println("Before Insertion Sort");    
        for(int i:arr){    
            System.out.print(i+" ");    
        }
    }

    public static void adisplay(int arr[]) {
        System.out.println("After Insertion Sort");    
        for(int i:arr){    
            System.out.print(i+" ");    
        }
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

        System.out.println("Size of array:- "+n);
        System.out.println("\n\n[Avarage Case:-]");   
        // bdisplay(arr1);
        Insertion(arr1);//sorting array using insertion sort 
        // adisplay(arr1);

        // Best Case
        /* Best case input is avg case output */
        System.out.println("\n\n[Best Case:-]");   
        // bdisplay(arr1); 
        Insertion(arr1);
        // adisplay(arr1);

        // Wrost case
        /* Wrost case input is reverse of best case output */
        System.out.println("\n\n[Wrost Case:-]");   
        reverse(arr1);
        // bdisplay(arr1);
        Insertion(arr1);
        // adisplay(arr1);

    }    
}    