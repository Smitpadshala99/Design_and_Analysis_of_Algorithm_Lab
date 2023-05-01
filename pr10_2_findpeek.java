import java.util.*;

public class pr10_2_findpeek {

    // binary search O(logn)
    public static int findPeak(int[] A, int n) {
        int low = 0, high = n - 1;
        while (low < high) {
            int mid = (low + high) / 2;
            if (A[mid] < A[mid + 1]) {
                low = mid + 1;
            } else {
                high = mid;
            } 
        }
        return low;
    }  

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int n = sc.nextInt();
        int[] A = new int[n];
        System.out.println("Enter the array elements (Sorted):");
        for (int i = 0; i < n; i++) {
            A[i] = sc.nextInt();
        }
        int peakIndex = findPeak(A, n);
        System.out.println("The peak element is: " + A[peakIndex] + " at index " + peakIndex);
    }
}
