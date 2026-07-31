class Solution {
    public boolean isAnagram(String s, String t) {
        
        //First Approach
        /*
        if(s.length()!=t.length()){
            return false;
        }

        char[] ch1=s.toCharArray();
        char[] ch2=t.toCharArray();

        //Sorting an arrays here
        Arrays.sort(ch1);
        Arrays.sort(ch2);

        //Returning the equal word of characters they have
        return Arrays.equals(ch1,ch2);
        */
        // Second Approach here given
        int freq[]=new int[26];

        for(char c:s.toCharArray()){
            int indx=c-'a';
            freq[indx]=freq[indx]+1;
        }
        for(char c:t.toCharArray()){
            int indx=c-'a';
            freq[indx]=freq[indx]-1;
        }
        for(int i=0;i<26;i++){
            if(freq[i]!=0){
                return false;
            }
        }
        return true;
    }
}