package WomenCodeSprint;

import java.util.*;

public class HackathonShirts {
	 public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);
	        int q = in.nextInt();
	        for(int a0 = 0; a0 < q; a0++){
	            int n = in.nextInt();
	            int[] sizes = new int[n];
	            TreeMap<Integer,String> sizesMap=new TreeMap<Integer, String>();
	            for(int sizes_i=0; sizes_i < n; sizes_i++){
	                sizes[sizes_i] = in.nextInt();
	                sizesMap.put(sizes[sizes_i], " ");
	            }
	            int v = in.nextInt();
	            int count=0;
	            SortedMap<Integer,String> treemap=new TreeMap<Integer,String>();
	            Set<Integer> s=new HashSet<>();
	            for(int a1 = 0; a1 < v; a1++){
	                int smallest = in.nextInt();
	                int largest = in.nextInt();
	                treemap=sizesMap.subMap(smallest, largest+1);
	                int size=treemap.size();
	               for(Map.Entry<Integer, String> map:treemap.entrySet()){
	            	   s.add(map.getKey());
	               }
	                
	                if(size>0){
	                	count+=size;
	                	treemap.clear();
	                }
	            }
	            System.out.println(count);
	        }
	 }
}
