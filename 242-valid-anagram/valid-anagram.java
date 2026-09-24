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
        if(s.length()!=t.length()){
            return false;
        }
        char[] charCount=new char[26];
        for(int i=0;i<s.length();i++){
            charCount[s.charAt(i)-'a']++;
            charCount[t.charAt(i)-'a']--;
        }
        for(int count:charCount){
            if(count!=0){
                return false;
            }
        }
        return true;
    }
}