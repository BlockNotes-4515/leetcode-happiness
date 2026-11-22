class Solution {
    public boolean checkString(String s) {

        boolean found=false;
        int n=s.length();

        for(int i=0;i<n;i++){

            if(s.charAt(i)=='b'){
                found=true;
            }
            if(s.charAt(i)=='a' && found){
                return false;
            }
        }
        return true;
    }
}