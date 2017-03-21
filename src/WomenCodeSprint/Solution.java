package WomenCodeSprint;


import java.util.*;


public class Solution {
    static HashMap<String,Long[]> vendorRange=new HashMap<String,Long[]>();
    private static int count;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            int n = in.nextInt();
            int[] sizes = new int[n];
            for(int sizes_i=0; sizes_i < n; sizes_i++){
                sizes[sizes_i] = in.nextInt();
            }
            int v = in.nextInt();
            for(int a1 = 0; a1 < v; a1++){
                int smallest = in.nextInt();
                int largest = in.nextInt();
                // your code goes here
                long small=smallest;
                long large=largest;
                Solution.vendorRangeCalculation(small,large);
            }
            for(int i=0;i<sizes.length;i++){
                if(Solution.findSize(sizes[i])){
                    count++;
                }
            }
            System.out.println(count);
        }
    }
    public static void vendorRangeCalculation(long small, long large){
        String vendorKey="V"+vendorRange.size()+1;
        Long[] vendorValue={small,large};
        vendorRange.put(vendorKey,vendorValue);
    }
    public static boolean findSize(long size){
        for(Map.Entry<String,Long[]> e : vendorRange.entrySet()){
            Long[] values=e.getValue();
            if(values[0]<=size && size<=values[1]){
                return true;
            }
        }
        return false;
    }
}

