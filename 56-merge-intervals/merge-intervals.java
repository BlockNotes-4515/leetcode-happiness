class Solution {
    public int[][] merge(int[][] intervals) {

        int n=intervals.length;
        if(n==0) return new int[0][];

        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
        
        List<int[]> result=new ArrayList<>();
        int start1=intervals[0][0];
        int end1=intervals[0][1];

        for(int i=1;i<n;i++){
            int start2=intervals[i][0];
            int end2=intervals[i][1];
            if(end1>=start2){
                start1=start1;
                end1=Math.max(end1,end2);
                continue;
            }
            result.add(new int[]{start1,end1});
            start1=start2;
            end1=end2;
        }
        //After reaching at the last of the array we got the array (start1,end1)
        result.add(new int[] {start1,end1});
        return result.toArray(new int[result.size()][]);
    }
}