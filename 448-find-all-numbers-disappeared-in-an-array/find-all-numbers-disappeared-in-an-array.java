class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {

      int n=nums.length;
      Set<Integer> s=new HashSet<>();
      for(int num:nums){
        s.add(num);
      }

      //Gettng Resultset compare and fetch the missing values from the main set
      List<Integer> res=new ArrayList<>();
      for(int i=1;i<=n;i++){
        if(!s.contains(i)){
            res.add(i);
        }
      }
      return res;
    }
}