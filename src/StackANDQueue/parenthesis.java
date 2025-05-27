package StackANDQueue;

import java.util.Stack;

public class parenthesis {
    public static void main(String[] args) {
        String s="()[{}()]";
        if(isValid(s)==true)
            System.out.println("True");
        else
            System.out.println("False");
    }

    private static boolean isValid(String s) {
        Stack<Character> st=new Stack<>();
        for(int i=0;i<s.length();i++){

            if(s.charAt(i)=='('||s.charAt(i)=='{'||s.charAt(i)=='['){
                st.push(s.charAt(i));
            }
            else {
                if (st.isEmpty()) return false;
                char ch = st.pop();
                if ((s.charAt(i) == ')' && ch == '(') || (s.charAt(i) == ']' && ch == '[') || (s.charAt(i) == '}' && ch == '{')) {
                    continue;
                }
                return false;
            }
        }
        return st.isEmpty();
    }
}



