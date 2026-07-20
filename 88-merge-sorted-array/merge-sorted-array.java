class Solution{
    public void merge(int A[], int m, int B[], int n){

        //Declaration of the variables.
        int i=m-1;
        int j=n-1;
        int k=(m+n)-1;
        //int C[]=new int[];

        //Merging of the two sorted arrays.
        while(i>=0 && j>=0){
            if(A[i]>B[j]){
                A[k]=A[i];
                i--;
            }
            else{
                A[k]=B[j];
                j--;
            }
            k--;
        }
        //Possibility of large array merging.
        while(j>=0){
            A[k]=B[j];
            j--;
            k--;
        }
    }
}