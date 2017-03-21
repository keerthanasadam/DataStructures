package WomenCodeSprint;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;

public class ChoosingRecipe {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int q = in.nextInt();
		for (int a0 = 0; a0 < q; a0++) {
			int r = in.nextInt();
			int p = in.nextInt();
			int n = in.nextInt();
			int m = in.nextInt();
			int[] pantry = new int[m];
			for (int pantry_i = 0; pantry_i < m; pantry_i++) {
				pantry[pantry_i] = in.nextInt();
			}
			int[] cost = new int[p];
			for (int cost_i = 0; cost_i < p; cost_i++) {
				cost[cost_i] = in.nextInt();
			}
			int[][] recipe = new int[r][p];
			for (int recipe_i = 0; recipe_i < r; recipe_i++) {
				for (int recipe_j = 0; recipe_j < p; recipe_j++) {
					recipe[recipe_i][recipe_j] = in.nextInt();
				}
			}
			System.out.println(ChoosingRecipe.minimizeRecipeCost(recipe, cost, pantry, n, r,p));
		}
	}

	public static int minimizeRecipeCost(int[][] recipe, int[] cost, int[] pantry, int n, int r, int p) {
		int mincost = 0;
		int[] recipecost = new int[cost.length];
		HashMap<Integer, Integer> hmap = new HashMap<Integer, Integer>();
		for (int i = 0; i < pantry.length; i++) {
			cost[pantry[i]] = 0;
		}
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < p; j++) {
				recipecost[i] = recipecost[i] + recipe[i][j] * cost[j];
			}
			hmap.put(i, recipecost[i]);
		}
		List<Integer> mapKeys = new ArrayList<Integer>(hmap.keySet());
		List<Integer> mapValues = new ArrayList<Integer>(hmap.values());
		Collections.sort(mapValues);
		Collections.sort(mapKeys);
		LinkedHashMap<Integer, Integer> sortedMap = new LinkedHashMap<>();
		Iterator<Integer> valueIt = mapValues.iterator();
		while (valueIt.hasNext()) {
			Integer val = valueIt.next();
			Iterator<Integer> keyIt = mapKeys.iterator();
			while (keyIt.hasNext()) {
				Integer key = keyIt.next();
				Integer comp1 = hmap.get(key);
				Integer comp2 = val;
				if (comp1.equals(comp2)) {
					keyIt.remove();
					sortedMap.put(key, val);
					break;
				}
			}
		}
		for (int i = 0; i < n; i++) {
			Integer key = sortedMap.keySet().iterator().next();
			Integer value = sortedMap.get(key);
			mincost += value;
			sortedMap.remove(key);
		}
		return mincost;
	}
}
