class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        if(n==0)return -1;
        int l =0;
        int r = n-1;
        while(l<=r){
            int mid = l - (l-r)/2;
            if(nums[mid]==target) return mid;
            if(nums[l]==target) return l;
            if(nums[r]==target) return r;
            if(nums[l] < nums[mid]){
                if(nums[l] < target && nums[mid] > target){
                    r = mid -1;
                }
                else{
                    l = mid +1;
                }
            }
            else{
                if(nums[mid] < target && nums[r] > target){
                    l = mid +1;
                }
                else{
                    r = mid-1;
                }
            }
           
        }
        return -1;
    }
}