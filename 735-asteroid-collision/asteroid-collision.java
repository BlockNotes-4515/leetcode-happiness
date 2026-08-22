class Solution {
    public int[] asteroidCollision(int[] asteroids) {

        Stack<Integer> stack=new Stack<>();

        for(int i=0;i<asteroids.length;i++){
            int ast=asteroids[i];
            while(true){
                if(stack.isEmpty()){
                    stack.push(i);
                    break;
                }
                if(ast>=0){
                    stack.push(i);
                    break;
                }

                int indx=stack.peek();
                if(asteroids[indx]>=0){
                    int astAbs=Math.abs(ast);
                    if(asteroids[indx]>astAbs){
                        break;
                    }
                    else if(asteroids[indx]==astAbs){
                        stack.pop();
                        break;
                    }
                    else{
                        stack.pop();
                    }
                }else{
                    stack.push(i);
                    break;
                }
            }
        }

        int[] res=new int[stack.size()];
        int i=res.length-1;
        while(!stack.isEmpty()){
            res[i]=asteroids[stack.pop()];
            i--;
        }
        return res;
    }
}