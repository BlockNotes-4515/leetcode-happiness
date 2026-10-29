class Solution {
    public void sortColors(int[] nums) {
        
        /*
        int n=nums.length;
        int minIndex=0;
        for(int i=0;i<n;i++){
            minIndex=i;
            for(int j=i+1;j<n;j++){
                if(nums[j]<nums[minIndex]){
                    minIndex=j;
                }
            }
            int temp=nums[minIndex];
            nums[minIndex]=nums[i];
            nums[i]=temp;
            */
            int n=nums.length;
            int left=0;
            int mid=0;
            int right=n-1;

            while(mid<=right){
                if(nums[mid]==0){
                    int temp=nums[left];
                    nums[left]=nums[mid];
                    nums[mid]=temp;

                    left++;
                    mid++;
                }
                else if(nums[mid]==1){
                    mid++;
                }else{
                    int temp=nums[mid];
                    nums[mid]=nums[right];
                    nums[right]=temp;

                    right--;
                }
            }
        }
    }
