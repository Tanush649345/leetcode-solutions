class Solution {
    void sumsubset(int ind,int target,int[] nums,List<List<Integer>>ans,List<Integer>ds){
        if(target == 0){
            ans.add(new ArrayList<>(ds));
            return;
        }
        if(target < 0 ||ind >= nums.length) return;
        ds.add(nums[ind]);
        sumsubset(ind+1,target-nums[ind],nums,ans,ds);
        ds.remove(ds.size() - 1);
        int next = ind + 1;
        while(next < nums.length && nums[next]==nums[next-1]) next++;
        sumsubset(next,target,nums,ans,ds);
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        sumsubset(0,target,candidates,ans,ds);
        return ans;
    }
}