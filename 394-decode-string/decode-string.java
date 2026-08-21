class Solution {
    public String decodeString(String s) {

        Stack<Integer> numStack=new Stack<>();
        Stack<String> strStack=new Stack<>();
        int num=0;
        String current="";

        //Possible conditions are as follows:
        /*
        1. Digits
        2. [
        3. ]
        4. Character
        */
        for(char ch:s.toCharArray()){
            if(Character.isDigit(ch)){
                num=num*10+(ch-'0');
            }
            else if(ch=='['){
                numStack.push(num);
                strStack.push(current);
                num=0;
                current="";
            }
            else if(ch==']'){
                int repeat=numStack.pop();
                String previous=strStack.pop();

                StringBuilder temp=new StringBuilder();
                for(int i=0;i<repeat;i++){
                    temp.append(current);
                }
                current=previous+temp.toString();
            }
            else{
                current+=ch;
            }
        }
        return current;
    }
}