class Solution {
    public List<Integer> getRow(int rowIndex) {

        List<Integer> prevRow=new ArrayList<>();
        prevRow.add(1);

        //Creating the pascal's Triangle formation
        for(int indx=1;indx<=rowIndex;indx++){

            //Creating the first row
            List<Integer> newRow=new ArrayList<>();
            newRow.add(1);

            //Adding the middle-most value item in the list
            for(int i=1;i<=indx-1;i++){
                newRow.add(prevRow.get(i-1)+prevRow.get(i));
            }
            newRow.add(1);
            prevRow=newRow;
        }
        return prevRow;
    }
}