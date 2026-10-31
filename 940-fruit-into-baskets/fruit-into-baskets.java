class Solution {
    public int totalFruit(int[] fruits) {

        int n=fruits.length;
        int left=0, max=0;
        Map<Integer,Integer> freq=new HashMap<>();

        for(int right=0;right<n;right++){
            freq.put(fruits[right],freq.getOrDefault(fruits[right],0)+1);

            while(freq.size()>2){
                int leftVal=fruits[left];
                freq.put(leftVal,freq.get(leftVal)-1);

                if(freq.get(leftVal)==0){
                    freq.remove(leftVal);
                }
                left++;
            }
            max=Math.max(max,right-left+1);
        }
        return max;
    }
}