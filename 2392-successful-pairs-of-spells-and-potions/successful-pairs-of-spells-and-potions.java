class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {

        //My Bruete Force Approach Solutions
        /*
        int n=spells.length;
        int m=potions.length;
        int sum=0;
        int arr[]=new int[n];

        for(int i=0;i<n;i++){
            int count=0;
            for(int j=0;j<m;j++){
                if((long) spells[i]*potions[j]>=success){
                    count++;
                }
            }
            arr[i]=count;
        }
        return arr; 
        */
        Arrays.sort(potions);

        int n=spells.length;
        int m=potions.length;
        int pairs[]=new int[n];

        for(int i=0;i<n;i++){
            int left=0, right=m;
            while(left<right){
                int mid=left+(right-left)/2;
                if((long) spells[i]*potions[mid]>=success){
                    right=mid;
                }else{
                    left=mid+1;
                }
            }
            pairs[i]=m-left;
        }    
        return pairs;
    }
}