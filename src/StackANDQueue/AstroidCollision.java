package StackANDQueue;

import java.util.Arrays;
import java.util.Stack;

public class AstroidCollision {
    public static void main(String[] args) {
        int asteroids[] = {5,10,-5};
        System.out.println("Resulting Asteroids: " + Arrays.toString(asteroidCollision(asteroids)));

    }
    public static int[] asteroidCollision(int[] asteroids) {

        Stack<Integer> stack = new Stack<>();

        for(int a:asteroids){
            boolean isdestroyed=false;
            while(!stack.isEmpty() && a<0 && stack.peek()>0){
                if(stack.peek()< -a){
                    stack.pop();
                }
                else if(stack.peek() == -a){
                    stack.pop();
                    isdestroyed = true;
                    break;
                }
                else{
                    isdestroyed=true;
                    break;
                }
            }
            if(!isdestroyed){
                stack.push(a);
            }

        }

        int[] res = new int[stack.size()];
        for (int i = res.length - 1; i >= 0; i--) {
            res[i] = stack.pop();
        }

        return res;



    }
}
