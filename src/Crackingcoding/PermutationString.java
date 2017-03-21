package Crackingcoding;

import java.util.HashSet;
import java.util.Set;

public class PermutationString {
	public static boolean checkPermutation(String given, String check) {
		boolean isPermutation = false;
		if (given.length() != check.length()) {
			isPermutation = false;
		} else {
			HashSet<Character> a = new HashSet<Character>();
			HashSet<Character> b = new HashSet<Character>();
			for (int i = 0; i < given.length(); i++) {

				a.add(given.charAt(i));
				b.add(check.charAt(i));

			}
			if (a.equals(b)) {
				isPermutation = true;
			}

			Set<Character> initial = new HashSet<Character>();
			for (int j = 0; j < given.length(); j++) {
				initial.add(given.charAt(j));
			}
			for (int i = 0; i < check.length(); i++) {

				if (a.contains(check.charAt(i))) {
					isPermutation = true;
				} else {
					isPermutation = false;
					break;
				}
			}
		}
		return isPermutation;

	}

	public static boolean permutation() {

		int[] letters = new int[256];
		String s = "hello";
		char[] s_array = s.toCharArray();
		for (char c : s_array) {
			letters[c]++;
		}

		String t = "abcde";
		for (int i = 0; i < t.length(); i++) {
			int c = (int) t.charAt(i);
			if (--letters[c] < 0) {
				return false;
			}
			System.out.println(c);
		}
		return true;
	}

	public static void main(String[] args) {
		// System.out.println(PermutationString.checkPermutation("hello hi",
		// "llohe ih"));
		// System.out.println(PermutationString.checkPermutation("abc", "cda"));
		System.out.println(PermutationString.permutation());
	}

}
