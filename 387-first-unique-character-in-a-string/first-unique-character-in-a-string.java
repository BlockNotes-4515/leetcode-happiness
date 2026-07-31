class Solution {
    public int firstUniqChar(String s) {
        
        Map<Character,Integer> map=new HashMap<>();

        //Calculating the value of the frequencies
        for(char c:s.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        //Checking the retunr of the unique characters
        for(int i=0;i<s.length();i++){
            if(map.get(s.charAt(i))==1){
                return i;
            }
        }
        return -1;
    }
}