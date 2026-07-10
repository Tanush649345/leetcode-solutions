class Solution {
    void swap(int i,int j,int[] nums){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    void findpermutation(int ind,int[] nums,List<List<Integer>> ans){
        if(ind == nums.length){
            List<Integer> ds = new ArrayList<>();
            for(int i =0;i<nums.length;i++){
                ds.add(nums[i]);
            }
            ans.add(ds);
        }
        for(int i = ind;i<nums.length;i++){
            swap(ind,i,nums);
            findpermutation(ind+1,nums,ans);
            swap(ind,i,nums);
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        findpermutation(0,nums,ans);
        return ans;
    }
}