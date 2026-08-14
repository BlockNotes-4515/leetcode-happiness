class Solution {
    public int maximumLengthSubstring(String s) {
        
        int[] freq=new int[256];
        int left=0;
        int max=0;
        for(int right=0;right<s.length();right++){
            freq[s.charAt(right)]++;

            while(freq[s.charAt(right)]>2){
                freq[s.charAt(left)]--;
                left++;
            }
            max=Math.max(max,right-left+1);
        }
        return max;
    }
}