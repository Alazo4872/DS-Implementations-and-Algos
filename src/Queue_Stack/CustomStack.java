package Queue_Stack;

public class CustomStack {
     protected int[] data;
     //static
     private static final int DEFAULT_SIZE = 10;

     //why? because it will point to where the last object was inserted
    //which will then increment when adding new value
     int ptr = -1;

    public CustomStack(){
        this(DEFAULT_SIZE);
    }

     public CustomStack(int size){
         this.data = new int[size];
     }

     public boolean push(int item){
        if(isFull()){
            System.out.println("Stack is full");
            return false;
        }
        ptr++;
        data[ptr] = item;
        return true;
     }
     public boolean isFull(){
        return ptr == data.length -1;
     }
    private boolean isEmpty(){
        return ptr == -1;
    }
    public int pop() throws StackException {
        if(isEmpty()){
            throw new StackException("Cannot pop from empty stack");
        }
        int removed = data[ptr];
        ptr--;
        return removed;
    }
    public int peek() throws StackException {
        if(isEmpty()){
            throw new StackException("Cannot peek from empty stack");
        }
        return data[ptr];
    }
}
