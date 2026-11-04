class Solution {
    public String minWindow(String s, String t) {
        
        Map<Character,Integer> map=new HashMap<>();

        int left=0;
        int n=t.length();
        int m=s.length();

        for(int i=0;i<n;i++){
            char ch=t.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        int count=0;
        int start=0;
        int min=Integer.MAX_VALUE;

        for(int right=0;right<m;right++){
            char ch=s.charAt(right);
            if(map.containsKey(ch)){
                if(map.get(ch)>0){
                    count++;
                }
                map.put(ch,map.get(ch)-1);
            }
            while(count==n){
                if(right-left+1<min){
                    min=right-left+1;
                    start=left;
                }
                char c=s.charAt(left);
                if (map.containsKey(c)) {
                    map.put(c, map.get(c) + 1);

                    if (map.get(c) > 0) {
                        count--;
                    }
                }
                left++;
            }
        }
        if(min==Integer.MAX_VALUE){
            return "";
        }else{
            return s.substring(start,start+min);
        }
    }
}