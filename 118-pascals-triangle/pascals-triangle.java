class Solution {
    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> result=new ArrayList<List<Integer>>();
        result.add(new ArrayList<>());
        result.get(0).add(1);
        // 1 get

        //Making the formation behind logic
        //1 1 
        // 1 2 1 and son on.....
        for(int row=1;row<numRows;row++){

            //Making the newRow here
            List<Integer> newRow=new ArrayList<>();
            newRow.add(1);
            List<Integer> prevRow=result.get(row-1);

            //Now making the formation by summing mid-elements
            for(int i=1;i<row;i++){
                newRow.add(prevRow.get(i-1)+prevRow.get(i));
            }
            newRow.add(1);
            result.add(newRow);
        }
        return result;
    }
}