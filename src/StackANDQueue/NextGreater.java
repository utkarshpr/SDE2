package StackANDQueue;

import java.util.Stack;

public class NextGreater {
    public static void main(String[] args) {
        int arr[]={5,7,1,2,6,0};

        int arr2[] = nextGreaterElements(arr);
        System.out.println("The next greater elements are ");
        for (int i = 0; i < arr2.length; i++) {
            System.out.print(arr2[i] + " ");
        }
    }

    private static int[] nextGreaterElements(int[] arr) {

        int res[]=new int[arr.length];
        int n=arr.length;
        Stack<Integer> stack=new Stack<>();
        //stack.push(-1);
        for(int i=2*arr.length-1;i>=0;i--){

           while (!stack.isEmpty() && stack.peek()<=arr[i%n]){
               stack.pop();
           }
            if(stack.isEmpty()){
                res[i%n]=-1;
            }else{
                res[i%n]=stack.peek();
            }
            stack.push(arr[i%n]);

        }
        return res;
    }
}
