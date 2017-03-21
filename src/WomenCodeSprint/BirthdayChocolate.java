package WomenCodeSprint;

import java.util.*;

public class BirthdayChocolate {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] squares = new int[n];
		for (int squares_i = 0; squares_i < n; squares_i++) {
			squares[squares_i] = in.nextInt();
		}
		int d = in.nextInt();
		int m = in.nextInt();
		// your code goes here
		System.out.println(BirthdayChocolate.count_ways(squares, d, m));
	}

	public static int count_ways(int[] squares, int d, int m) {
		int sum = 0;
		int count = 0;
		int loop=m;
		int j=0;
		int array_len = squares.length;
		if (m <=array_len) {
			for (int i = 0; i < array_len; i++) {
				j=i;
				while(loop>0 && j<array_len){
					sum += squares[j];
					loop--;
					j++;
				}
				if (sum == d) {
					count++;
				}
				sum = 0;
				loop=m;
			}
		} else {
			return 0;
		}
		return count;
	}
}
