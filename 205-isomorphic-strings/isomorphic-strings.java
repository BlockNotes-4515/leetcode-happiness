class Solution {
    public boolean isIsomorphic(String s, String t) {
        
        //Using the HashMap and HashSet
        HashMap<Character,Character> map=new HashMap<>();
        HashSet<Character> used=new HashSet<>();

        for(int i=0;i<s.length();i++){

            char a=s.charAt(i);
            char b=t.charAt(i);

            //Checking if the same character maps to different character or not?
            if(map.containsKey(a)){
                if(map.get(a)!=b){
                    return false;
                }
            }
            else if(used.contains(b)){
                return false;
            }
            else{
                map.put(a,b);
                used.add(b);
            }
        }
        return true;
    }
}