class MyQueue {

    Stack<Integer> mystack1 = new Stack<>();
    Stack<Integer> mystack2 = new Stack<>();

    public MyQueue() {
        
    }

    public void push(int x) {
        mystack1.push(x);
    }

    public int pop() {

        if (mystack2.isEmpty()) {
            while (!mystack1.isEmpty()) {
                mystack2.push(mystack1.pop());
            }
        }
        return mystack2.pop();
    }

    public int peek() {

        if (mystack2.isEmpty()) {
            while (!mystack1.isEmpty()) {
                mystack2.push(mystack1.pop());
            }
        }
        return mystack2.peek();
    }

    public boolean empty() {
        return mystack1.isEmpty() && mystack2.isEmpty();
    }
} 


// 