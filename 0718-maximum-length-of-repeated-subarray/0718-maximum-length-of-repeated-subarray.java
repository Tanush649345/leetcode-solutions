class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int max =0;
        int[] prev = new int[m+1];
        for(int i=0;i<=m;i++){
            prev[i]=0;
        }
        for(int i=1;i<=n;i++){
            int[] curr = new int[m+1];
            for(int j=1;j<=m;j++){
                if(nums1[i-1] == nums2[j-1]){
                    curr[j] = 1 + prev[j-1];
                    max = Math.max(max,curr[j]);
                }
                else curr[j]=0;
            }
            prev = curr;
        }
        return max;
    }
}