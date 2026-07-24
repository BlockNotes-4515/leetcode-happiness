class Solution {
    public int lengthOfLastWord(String s) {
        
        int length=0;
        int i=s.length()-1;

        //Leading and Trailing of the white spaces
        while(i>=0 && s.charAt(i)==' '){
            i--;
        }
        //Taking the length of the last word
        while(i>=0 && s.charAt(i)!=' '){
            length++;
            i--;
        }
        return length;
    }
}