package com.dreamworks.restworks.interview.tree.heap;

import java.util.Arrays;

public class HeapIntArray {

    private static int total;

    private static void swap(int[] arr, int a, int b)
    {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

    private static void heapify(int[] arr, int i)
    {
    	                    // starting from index 1
        int lft = i * 2;    // 2n
        int rgt = lft + 1;  // 2n+1
        
        int grt = i;

        if (lft <= total && arr[lft] > arr[grt]) grt = lft;
        if (rgt <= total && arr[rgt] > arr[grt]) grt = rgt;
        
        if (grt != i) {
            swap(arr, i, grt);
            heapify(arr, grt);
        }
    }

    public static void heapsort(int[] arr)
    {
        total = arr.length - 1;

        for (int i = total / 2; i >= 0; i--)
            heapify(arr, i);

        for (int i = total; i > 0; i--) {
            swap(arr, 0, i);
            total--;
            heapify(arr, 0);
        }
    }

    
    public static void main(final String[] args)
    {
        int[] arr = new int[] { 3, 2, 1, 5, 4 };

        System.out.println(Arrays.toString(arr));
        heapsort(arr);
        System.out.println(Arrays.toString(arr));
    }
}