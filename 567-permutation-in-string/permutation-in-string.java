class Solution {
    public boolean checkInclusion(String s1, String s2) {

        int n=s1.length();
        int m=s2.length();
        int left=0;

        Map<Character,Integer> first=new HashMap<>();
        for(char c:s1.toCharArray()){
            first.put(c,first.getOrDefault(c,0)+1);
        }
        Map<Character,Integer> second=new HashMap<>();
        for(int right=0;right<m;right++){
            char ch=s2.charAt(right);
            second.put(ch,second.getOrDefault(ch,0)+1);

            while(right-left+1>n){
                char leftV=s2.charAt(left);
                second.put(leftV,second.get(leftV)-1);

                if(second.get(leftV)==0){
                    second.remove(leftV);
                }
                left++;
            }
            if(second.equals(first)){
                return true;
            }
        }
        return false;
    }
}