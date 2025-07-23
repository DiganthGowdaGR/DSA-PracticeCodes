class MaxC {
    public int maximumCount(int[] nums) {
        int lastNegIndx = firstNegNum(nums) + 1;
        int lastPasIndx = nums.length - firstPosNum(nums); 
        return math.Max(lastNegIndx, lastPasIndx);     
        
    }

    public void firstPosNum(int[] nums){
        int start = 0;
        int end =  nums.length-1;
        int ans = nums.length;

        while(start <= end){
            int mid = (start + end)/2;

            if(nums[mid] > 0 ){
                ans = mid;
                end = mid - 1;
            }
            else{
               start = mid + 1;
            }
        }
        return ans;
    }

    public void firstNegNum(int[] nums){
        int start = 0;
        int end = nums.length-1;
        int ans = -1;

        while(start <= end ){
            int mid =  (start + end)/2;

            if(nums[mid] < 0 ){
                ans = mid;
                start  = mid + 1; 
            }
            else{
                end =  mid - 1;
            }
        }
        return ans;
    }

}
