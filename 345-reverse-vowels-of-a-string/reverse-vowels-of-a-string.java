class Solution {
    public String reverseVowels(String s) {

        char[] ch=s.toCharArray();
        int j=s.length()-1;
        for(int i=0;i<s.length();i++){
            if(ch[i]=='a'||ch[i]=='e'||ch[i]=='i'||ch[i]=='o'||ch[i]=='u'||
            ch[i]=='A'||ch[i]=='E'||ch[i]=='I'||ch[i]=='O'||ch[i]=='U'){
                while(j>i){
                    if(ch[j]=='a'||ch[j]=='e'||ch[j]=='i'||ch[j]=='o'||ch[j]=='u'||
                    ch[j]=='A'||ch[j]=='E'||ch[j]=='I'||ch[j]=='O'||ch[j]=='U'){
                        char temp=ch[i];
                        ch[i]=ch[j];
                        ch[j]=temp;
                        j--;
                        break;
                    }
                    j--;
                }
            }
        }
        return new String(ch);
    }
}