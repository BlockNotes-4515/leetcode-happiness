class Solution {
    public int trap(int[] height) {

        //By, using the brute force approach
        int water=0;
        for(int i=1;i<height.length-1;i++){

            int curr=height[i];

            int leftMax=curr;
            int rightMax=curr;

            for(int j=i-1;j>=0;j--){
                leftMax=Math.max(leftMax,height[j]);
            }
            for(int j=i+1;j<height.length;j++){
                rightMax=Math.max(rightMax,height[j]);

                if(rightMax>=leftMax){
                    break;
                }
            }
            water=water+Math.min(leftMax,rightMax)-curr;
        }
        return water;
    }
}