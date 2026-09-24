class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        //First we creating the HashMap
        HashMap<String,List<String>> map=new HashMap<>();
        //Creating the string to characters and then sort and then again strings
        for(String str:strs){
            char[] chars=str.toCharArray();
            Arrays.sort(chars);
            String key=new String(chars);
            if(!map.containsKey(key)){
                map.put(key,new ArrayList<>());
            }
            map.get(key).add(str);
        }
        return new ArrayList<>(map.values());
    }
}