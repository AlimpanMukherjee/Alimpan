import java.util.Stack;

class MyQueue {
    private Stack<Integer> st=new Stack<>();

    // public MyQueue() {
    //     st = new Stack<>();
    // }
    
    public void push(int x) {
        st.push(x);
    }
    
    public int pop() {
        Stack<Integer> dummy = new Stack<>();
        if(st.size() == 0) return -1;
        if(st.size() == 1) return st.pop();
        
        while(st.size() > 1) {
            dummy.push(st.pop());
        }
        
        int element = st.pop();
        
        while(!dummy.isEmpty()) {
            st.push(dummy.pop());
        }
        
        return element;
    }
    
    public int peek() {
        Stack<Integer> dummy = new Stack<>();
        if(st.size() == 0) return -1;
        
        while(st.size() > 0) {
            dummy.push(st.pop());
        }
        
        int element = dummy.peek();
        
        while(!dummy.isEmpty()) {
            st.push(dummy.pop());
        }
        
        return element;
    }
    
    public boolean empty() {
        return st.isEmpty();
    }
}


/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */