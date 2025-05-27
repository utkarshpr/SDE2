package StackANDQueue;

import java.util.Stack;

public class MinStack {
    public static void main(String[] args) {

    }
}
class MinStackImp {
    Stack<Pair> st=new Stack<>();
    int min=0;
    public MinStackImp() {
        min=Integer.MAX_VALUE;
    }

    public void push(int val) {
        if(st.isEmpty()){
            min=val;
        }
        else{
            min=Math.min(val,st.peek().y);
        }
        st.push(new Pair(val,min));

    }

    public void pop() {
        st.pop();
    }

    public int top() {
    return  st.peek().x;
    }

    public int getMin() {
        return  st.peek().y;
    }
}

class Pair {
    int x, y;
    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}