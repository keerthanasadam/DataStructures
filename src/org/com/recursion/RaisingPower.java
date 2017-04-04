package org.com.recursion;

public class RaisingPower {
	/*Calculating x^y in O(log N) instead of O(N) complexity.
	 *For example 2^8 is calculated by multiplying 2 with itself 8 times.
	 *the number of multiplications can be reduced by multiplying x with itself and diving y with 2.
	 *For even numbers:
	 *2^8=4^4 
	 *i.e., 2^8= (2^2)^(8/2)
	 *for odd numbers:
	 *if y is odd multiply with x;
	 * 
	 */
	public static Long raise(long x, long y){
		if(y==1)
			return x;
		else
			if(y%2!=0){
				return x*raise(x*x,y/2);
			}
			else return raise(x*x,y/2);
	}
	public static void main(String[] args) {
		System.out.println(RaisingPower.raise(2, 8));
		System.out.println(RaisingPower.raise(3, 18));
	}
}
