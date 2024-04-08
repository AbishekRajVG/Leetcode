class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        // sorting is time O(nlogn)
        Arrays.sort(nums);
        int n = nums.length;

        List<List<Integer>> result = new ArrayList<>();

        for(int i = 0; i < n; i++){
            int curr = nums[i];

            if(i != 0 && curr == nums[i-1]){
                continue;
            }
            // left and right pointers to compute other two values
            int l = i + 1 , r = n-1;
            while(l<r){
                List<Integer> validSum = new ArrayList<Integer>();
                int threeSum = curr + nums[l] + nums[r];
                if(threeSum > 0){
                    r -= (nums[r] != nums[r-1])? 1 : 2;
                }
                else if(threeSum < 0){
                    l += (nums[l] != nums[l+1])? 1: 2;
                }
                else{
                    Collections.addAll(validSum, curr, nums[l], nums[r]);
                    result.add(validSum);
                    l++;
                    while(nums[l] == nums[l-1] && l<r){
                        l++;
                    }
                }
            }
        }
        return result;
    }
}