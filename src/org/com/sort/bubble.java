package org.com.sort;

import java.util.Arrays;

/**
 * @author keerthana
 *
 */
public class bubble {
	public static void sort(int[] a) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length - 1 - i; j++) {
				if (a[j] > a[j + 1]) {
					int temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;
				}
			}
		}
		printArray(a);
	}

	public static void printArray(int[] sorted) {
		System.out.println("Bubble sort: " + Arrays.toString(sorted));
	}
}
