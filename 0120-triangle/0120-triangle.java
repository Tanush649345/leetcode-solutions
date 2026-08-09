class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int l = triangle.size();
        int[] prev = new int[l];
        for(int i =0;i<l;i++){
            prev[i] = triangle.get(l-1).get(i);
        }
        for(int i = l-2;i>=0;i--){
            int[] curr = new int[i+1];
            for(int j=0;j<=i;j++){
                int one = prev[j];
                int two = prev[j+1];
                curr[j] = triangle.get(i).get(j) + Math.min(one,two);
            }
            prev = curr;
        }
        return prev[0];
    }
}