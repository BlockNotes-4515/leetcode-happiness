class Solution {
    public int[] sortedSquares(int[] nums) {
        
        //Normal Brute force approach
        /*
        int n=nums.length;
        int[] result=new int[n];

        for(int i=0;i<n;i++){
            result[i]=(nums[i]*nums[i]);
        }
        Arrays.sort(result);
        return result;
        */
        //By, using the merge sorted array
        int n=nums.length;
        
        int[] negative=new int[n];
        int[] positive=new int[n];

        int a=0,b=0;
        for(int i=0;i<n;i++){
            if(nums[i]<0){
                negative[a]=nums[i]*nums[i];
                a++;
            }else{
                positive[b]=nums[i]*nums[i];
                b++;
            }
        }
        //Merge the array into main array
        int[] result=new int[n];
        int k=0;
        for(int i=0;i<a;i++){
            result[k]=negative[i];
            k++;
        }
        for(int i=0;i<b;i++){
            result[k]=positive[i];
            k++;
        }
        Arrays.sort(result);
        return result;
    }
}