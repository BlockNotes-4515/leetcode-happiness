class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        
       
        //2. Merge intervals by adding the new interval
        int n=intervals.length;
        if(n==0) return new int[][]{newInterval};
        List<int[]> result=new ArrayList<>();

        //Sorted an array here first
        //Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));

        int start1=newInterval[0];
        int end1=newInterval[1];
        boolean inserted=false;

        for(int i=0;i<n;i++){
            int start2=intervals[i][0];
            int end2=intervals[i][1];
            if(end2<start1){
                result.add(new int[]{start2,end2});
                continue;
            }
            if(start2>end1){
                if(!inserted){
                    result.add(new int[]{start1,end1});
                    inserted=true;
                }
                result.add(new int[]{start2,end2});
                continue;
            }
            //If Merge Occurs
            start1=Math.min(start1,start2);
            end1=Math.max(end1,end2);
        }
        if(!inserted){
            result.add(new int[]{start1,end1});
        }
        return result.toArray(new int[result.size()][]);
    }
}

 /*1. This is the normal basic program of the merging an intervals
        int n=intervals.length;
        if(n==0) return new int[0][];
        List<int[]> result=new ArrayList<>();

        //Sorting and array in ascending order
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));

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
        result.add(new int[]{start1,end1});
        return result.toArray(new int[result.size()][]);

        //We use this code in this program as template
        */