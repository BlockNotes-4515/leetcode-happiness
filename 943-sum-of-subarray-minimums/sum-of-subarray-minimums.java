class Solution {
    public int sumSubarrayMins(int[] arr) {
        
       int[] nsei=new int[arr.length];
       int[] psei=new int[arr.length];

       for(int i=0;i<arr.length;i++){
        nsei[i]=arr.length;
        psei[i]=-1;
       }

       Stack<Integer> stack = new Stack<>();

       //Finding the next minimum
       for(int i=0;i<arr.length;i++){
        while(true){
            if(stack.isEmpty()){
                stack.push(i);
                break;
            }
            int indx=stack.peek();
            if(arr[i]<=arr[indx]){
                nsei[indx]=i;
                stack.pop();
            }
            else{
                stack.push(i);
                break;
            }
        }

       }
       stack.clear();
       for(int i=arr.length-1;i>=0;i--){
        while(true){
            if(stack.isEmpty()){
                stack.push(i);
                break;
            }
            int indx=stack.peek();
            if(arr[i]<arr[indx]){
                psei[indx]=i;
                stack.pop();
            }
            else{
                stack.push(i);
                break;
            }
        }
       }
       long sum=0;
        for(int i=0;i<arr.length;i++){
            int leftborder=i-psei[i];
            int rightborder=nsei[i]-i;
            long cont = ((long)leftborder*rightborder)%1000000007;
            cont=(cont*arr[i])%1000000007;
            sum=(sum+cont)%1000000007;
        }
        return (int) sum;
    }
}