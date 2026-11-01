import java.util.HashMap;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        /*
        HashSet<Character> set=new HashSet<>();
        int n=s.length();
        int left=0;
        int maxLen=0;

        for(int right=0;right<n;right++){
            while(set.contains(s.charAt(right))){
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            maxLen=Math.max(maxLen,right-left+1);
        }
        return maxLen;
        */

        int n=s.length();
        int max=0;
        int left=0;
        HashSet<Character> set=new HashSet<>();

        for(int right=0;right<n;right++){
            char c=s.charAt(right);
            while(set.contains(c)){
                set.remove(s.charAt(left));
                left++;
            }
            set.add(c);
            max=Math.max(max,right-left+1);
        }
        return max;
    }
}