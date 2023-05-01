/*
The problem can be solved using dynamic programming. 
We can define a subproblem as follows:

Let's assume that we have already bought the first 𝑘 licenses in the best possible order, and we are about to buy license 𝑘 + 1. Let 𝑐𝑘 be the minimum total cost of buying the first 𝑘 licenses in the optimal order, and 𝑐𝑘,𝑗 be the minimum total cost of buying the first 𝑘 licenses in the optimal order, assuming that license 𝑗 is the 𝑘 + 1th license to be bought. 
Then, we can define the value of 𝑐𝑘+1 as follows:
𝑐𝑘+1=min{𝑐𝑘, 𝑗+100𝑟𝑗𝑘+1}, for all j such that 1 ≤ j ≤ n and 𝑟𝑗 < 𝑟𝑘+1

The first term on the right-hand side of the above formula represents the case where we don't buy the 𝑘 + 1th license in this step. 
In that case, the minimum cost of buying the first 𝑘 licenses is the same as the minimum cost of buying the first 𝑘 licenses in the previous step, which is 𝑐𝑘.

The second term on the right-hand side of the formula represents the case where we buy the 𝑘 + 1th license. 
In that case, the minimum cost of buying the first 𝑘 licenses is 𝑐𝑘,𝑗, which is the minimum total cost of buying the first 𝑘 licenses assuming that license 𝑗 is the 𝑘 + 1th license to be bought. 
We add the cost of the 𝑘 + 1th license, which is 100𝑟𝑗𝑘+1, to get the total cost.

We can compute the values of 𝑐𝑘+1 using the above formula for k = 0, 1, 2, ..., 𝑛 − 1, and then choose the order that gives us the minimum total cost.

The time complexity of the above algorithm is O(𝑛^3), which is polynomial in 𝑛. 

 */


import java.util.*;

public class pr10_1_greedy {

    // // Compute the optimal order for buying the licenses
    // public static int[] computeOptimalOrder(double[] growthRates) {
    //     int n = growthRates.length;
    //     double[][] costs = new double[n][n];
    //     int[][] prev = new int[n][n];

    //     // Initialize the costs and prev arrays
    //     for (int j = 0; j < n; j++) {
    //         costs[0][j] = 100 * Math.pow(growthRates[j], 0);
    //         prev[0][j] = -1;
    //     }

    //     // Compute the costs and prev arrays
    //     for (int i = 1; i < n; i++) {
    //         for (int j = 0; j < n; j++) {
    //             costs[i][j] = Double.POSITIVE_INFINITY;
    //             for (int k = 0; k < n; k++) {
    //                 if (growthRates[j] < growthRates[k] && costs[i - 1][k] + 100 * Math.pow(growthRates[j], i) < costs[i][j]) {
    //                     costs[i][j] = costs[i - 1][k] + 100 * Math.pow(growthRates[j], i);
    //                     prev[i][j] = k;
    //                 }
    //             }
    //         }
    //     }

    //     // Find the index of the last license in the optimal order
    //     int lastLicense = 0;
    //     for (int j = 1; j < n; j++) {
    //         if (costs[n - 1][j] < costs[n - 1][lastLicense]) {
    //             lastLicense = j;
    //         }
    //     }

    //     // Backtrack from the last license to get the optimal order
    //     int[] order = new int[n];
    //     int index = n - 1;
    //     while (lastLicense != -1) {
    //         order[index] = lastLicense;
    //         lastLicense = prev[index][lastLicense];
    //         index--;
    //     }

    //     return order;
    // }

    // // Compute the total cost of buying the licenses in the given order
    // public static double computeTotalCost(double[] growthRates, int[] order) {
    //     int n = growthRates.length;
    //     double totalCost = 0;
    //     for (int i = 0; i < n; i++) {
    //         totalCost += 100 * Math.pow(growthRates[order[i]], i);
    //     }
    //     return totalCost;
    // }

    // public static void main(String[] args) {
    //     Scanner sc = new Scanner(System.in);

    //     // Get the number of licenses and their growth rates
    //     System.out.print("Enter the number of licenses: ");
    //     int n = sc.nextInt();
    //     double[] growthRates = new double[n];
    //     for (int i = 0; i < n; i++) {
    //         System.out.print("Enter the growth rate for license " + (i + 1) + ": ");
    //         growthRates[i] = sc.nextDouble();
    //     }

    //     // Compute the optimal order for buying the licenses
    //     int[] order = computeOptimalOrder(growthRates);

    //     // Print the optimal order and the total cost
    //     System.out.println("Optimal order for buying the licenses:");
    //     for (int i = 0; i < n; i++) {
    //         System.out.println("License " + (order[i] + 1));
    //     }
    //     double totalCost = computeTotalCost(growthRates, order);
    //     System.out.println("Total cost: $" + totalCost);
    // }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of licenses: ");
        int n = sc.nextInt();
        double[] growthRates = new double[n];
        System.out.println("Enter the growth rates for each license: ");
        for (int i = 0; i < n; i++) {
            growthRates[i] = sc.nextDouble();
        }
        int[] order = buyLicenses(growthRates);
        System.out.println("The optimal order to buy the licenses is: " + Arrays.toString(order));
    }

    public static int[] buyLicenses(double[] growthRates) {
        int n = growthRates.length;
        List<Integer> remainingLicenses = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            remainingLicenses.add(i);
        }
        int[] order = new int[n];
        double[] prices = new double[n];
        Arrays.fill(prices, 100.0);
        for (int i = 0; i < n; i++) {
            int bestLicenseIndex = -1;
            double bestPrice = Double.MAX_VALUE;
            for (int j : remainingLicenses) {
                double price = prices[j] * Math.pow(growthRates[j], i);
                if (price < bestPrice) {
                    bestPrice = price;
                    bestLicenseIndex = j;
                }
            }
            order[i] = bestLicenseIndex;
            remainingLicenses.remove((Integer) bestLicenseIndex);
        }
        return order;
    }

}
