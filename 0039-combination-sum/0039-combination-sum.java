class Solution {
    void sumsubset(int ind,int target,int[] nums,List<List<Integer>>ans,List<Integer>ds){
        if(target < 0 ||ind >= nums.length) return;
        if(target == 0){
            ans.add(new ArrayList<>(ds));
            return;
        }
        ds.add(nums[ind]);
        sumsubset(ind,target-nums[ind],nums,ans,ds);
        ds.remove(ds.size() - 1);
        sumsubset(ind+1,target,nums,ans,ds);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        sumsubset(0,target,candidates,ans,ds);
        return ans;
    }
}