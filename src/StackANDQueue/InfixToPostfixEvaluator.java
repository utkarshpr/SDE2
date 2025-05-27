package StackANDQueue;

import java.util.Stack;

public class InfixToPostfixEvaluator {

    static int precedence(char ch) {
        switch (ch) {
            case '+':
            case '-': return 1;
            case '*':
            case '/': return 2;
            case '^': return 3;
        }
        return -1;
    }

    static String infixToPostfix(String expr) {
       Stack <Character> stack=new Stack<>();
       StringBuilder result=new StringBuilder();
       int i=0;

       while(i<expr.length()){
           char ch=expr.charAt(i);
           if(Character.isDigit(ch)){
                while(i<expr.length() && Character.isDigit(expr.charAt(i))){
                    result.append(expr.charAt(i));
                    i++;
                }
                result.append(" ");
                continue;
           }
           if(ch=='('){
                stack.push('(');
           }else if(ch ==')'){
               while (!stack.isEmpty() && stack.peek()=='('){
                   result.append(stack.pop()).append(" ");
               }
               stack.pop();
           }else if(isOperator(ch) ){
                while (!stack.isEmpty() && precedence(ch)<=precedence(stack.peek())){
                    result.append(stack.pop()).append(" ");
                }
                stack.push(ch);
           }

           i++;
       }
       while (!stack.isEmpty()){
           result.append(stack.pop()).append(" ");
       }
       return  result.toString().trim();
    }

    static boolean isOperator(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '^';
    }

    static int evaluatePostfix(String postfix) {
        String string[]=postfix.split(" ");
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<string.length;i++){
            if(Character.isDigit(string[i].charAt(0))){
                st.push(Integer.parseInt(string[i]));
            }
            else{
                int b = st.pop();
                int a = st.pop();
                switch (string[i]){
                    case "+": st.push(a+b);break;
                    case "-": st.push(a - b); break;
                    case "*": st.push(a * b); break;
                    case "/": st.push(a / b); break;
                }
            }
        }
        return  st.pop();
    }

    public static void main(String[] args) {
        String expression = "51+5*3+5*8";
        System.out.println("Infix: " + expression);

        String postfix = infixToPostfix(expression);
        System.out.println("Postfix: " + postfix);

        int result = evaluatePostfix(postfix);
        System.out.println("Evaluated Result: " + result);
    }
}
