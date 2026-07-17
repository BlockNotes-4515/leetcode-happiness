import java.util.Scanner;
class Solution {
    public static boolean isPalindrome(int x) {
        if(x<0)
        return false;

        int original = x;
        int reverse=0;
        while(x!=0){
           int digit=x%10;
            reverse=reverse*10+digit;
            x=x/10;
        }
        return original==reverse;
    }
public static void main(String[] args){
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    if(isPalindrome(n)){
        System.out.print("Palindrome");
    }else{
        System.out.print("Not Palindrome");
    }
}
}