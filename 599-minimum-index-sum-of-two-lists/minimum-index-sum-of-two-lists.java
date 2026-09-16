class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {

        HashMap<String,Integer> map=new HashMap<>();

        //Working on the first Array List1
        for(int i=0;i<list1.length;i++){
            map.put(list1[i],i);
        }

        ArrayList<String> ans=new ArrayList<>();
        int min=Integer.MAX_VALUE;

        //Working on the Array List2
        for(int j=0;j<list2.length;j++){
            
            if(map.containsKey(list2[j])){
                int sum=map.get(list2[j])+j;
            
                if(sum<min){
                   min=sum;
                   ans.clear();
                   ans.add(list2[j]);
                }
                else if(sum==min){
                   ans.add(list2[j]);
                }
            }    
        }
        return ans.toArray(new String[0]);
    }
}