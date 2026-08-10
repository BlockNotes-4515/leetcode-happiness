class Solution {
    public int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }
        /*
        int n=nums.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<n-i-1;j++){
                if(nums[j]>nums[j+1]){
                    int temp=nums[j];
                    nums[j]=nums[j+1];
                    nums[j+1]=temp;
                }
            }
        }
        return nums;
        */
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
        }
        return nums;
        */
    void mergeSort(int[] a, int l, int r) {
        if (l >= r) return;

        int m = (l + r)/2;

        mergeSort(a, l, m);
        mergeSort(a, m + 1, r);

        int[] t = new int[r - l + 1];
        int i=l,j = m + 1, k = 0;

        while (i<=m&&j<=r)
            t[k++]=a[i]<a[j]?a[i++]:a[j++];

        while (i <= m) t[k++]=a[i++];
        while (j <= r) t[k++]=a[j++];
        for (i=l; i <=r; i++)
            a[i]=t[i-l];
    }
}