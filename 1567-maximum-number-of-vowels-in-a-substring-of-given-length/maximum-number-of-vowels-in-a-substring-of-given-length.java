class Solution {
    public int maxVowels(String s, int k) {

        //HashMap<Character,Integer> map=new HashMap<>();
        int n=s.length();
        int left=0;
        int count=0;
        int max=0;
        
        for(int right=0;right<n;right++){
            char c=s.charAt(right);
            if(c=='a' || c=='e' || c=='i' || c=='o' || c=='u'){
                count++;
            }
            while((right-left+1)>k){
                char ch=s.charAt(left);
                if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u'){
                    count--;
                }
                left++;
            }
            max=Math.max(max,count);
        }
        return max;
    }
}