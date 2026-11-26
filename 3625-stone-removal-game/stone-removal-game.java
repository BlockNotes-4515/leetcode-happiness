class Solution {
    public boolean canAliceWin(int n) {
        
        int stone=10;
        boolean alice=true;

        while(n>=stone){
            n=n-stone;
            stone--;
            alice=!alice;
        }
        return !alice;
    }
}