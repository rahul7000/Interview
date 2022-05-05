package com.rahul.practice.wordproblem;

import java.util.Scanner;
import java.util.TreeSet;

public class Solution1 {

	 // Complete the miniMaxSum function below.
    static void miniMaxSum(int[] arr) {

        TreeSet<Long> treeSet = new TreeSet<>();
        for (int i=0;i<arr.length;i++){
            long sum = 0;
            for(int j=0;j<arr.length;j++){
                if(i!=j){
                sum= sum+arr[j];
                }
            }
            treeSet.add(sum);
        }
        System.out.println(treeSet.first()+" "+treeSet.last());

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[] arr = new int[5];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < 5; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        miniMaxSum(arr);

        scanner.close();
    }
}
