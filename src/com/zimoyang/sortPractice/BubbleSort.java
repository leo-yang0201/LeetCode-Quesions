package com.zimoyang.sortPractice;

public class BubbleSort {
    public static void main(String[] args) {
        int[] a = new int[]{3,6,2,1,0,9,8};
        BubbleSort.bubbleSort(a);
        for (int v : a) {
            System.out.println(v);
        }
    }

    private static void bubbleSort(int[] a) {
        for (int i = 0;i < a.length - 1;i++) {
            for (int j = 0 ; j < a.length - 1 - i;j++) {
                if (a[j] < a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
    }
}
