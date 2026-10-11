class Solution {
    public int maxVowels(String s, int k) {

       int count=0;
       int max=0;
       
       for(int i=0;i<s.length();i++){

        char c=s.charAt(i);

        if("aeiou".indexOf(c)!=-1){
            count++;
        }
        if(i>=k && "aeiou".indexOf(s.charAt(i-k))!=-1){
            count--;
        }
        max=Math.max(max,count);
       }
       return max;
    }
}