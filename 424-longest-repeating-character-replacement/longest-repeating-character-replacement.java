class Solution {
    public int characterReplacement(String s, int k) {
        
        /*
       int[] freq=new int[26];
       int left=0;
       int maxfreq=0;
       int maxlen=0;
       for(int right=0;right<s.length();right++){

        freq[s.charAt(right)-'A']++;

        //Calculating the maximum frequencies
        maxfreq=Math.max(maxfreq,
        freq[s.charAt(right)-'A']);

        while((right-left+1)-maxfreq>k){
            freq[s.charAt(left)-'A']--;
            left++;
        }
        //Caluclating the maximu length and then return 
        maxlen=Math.max(maxlen,right-left+1);
       }
       return maxlen;
       */

       int n=s.length();
       int left=0;
       int max=0;
       int maxFreq=0;
    
       Map<Character,Integer> freq=new HashMap<>();

       for(int right=0;right<n;right++){
          char c=s.charAt(right);
          freq.put(c,freq.getOrDefault(c,0)+1);
          maxFreq=Math.max(maxFreq,freq.get(c));
 
          while((right-left+1)-maxFreq>k){
             char leftChar=s.charAt(left);
             freq.put(leftChar,freq.get(leftChar)-1);

             if(freq.get(leftChar)==0){
                freq.remove(leftChar);
             }
             left++;
          }
          max=Math.max(max,right-left+1);
       }
       return max;
    }
}