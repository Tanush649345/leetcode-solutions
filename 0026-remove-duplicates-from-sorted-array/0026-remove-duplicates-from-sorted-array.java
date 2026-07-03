class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0||nums.length==1) return nums.length;
        int l =0;
        int r =0;
        while(r<nums.length){
            if(nums[l]==nums[r]){
                r++;
            }
            else{
                nums[++l] = nums[r];
            }
        }
        return ++l;
    }
}