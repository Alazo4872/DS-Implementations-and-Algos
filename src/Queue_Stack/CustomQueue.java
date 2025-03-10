package Queue_Stack;

public class CustomQueue {
    protected int[] data;
    //static
    private static final int DEFAULT_SIZE = 10;

    //why? because it will point to where the last object was inserted
    //which will then increment when adding new value
    int end = 0;

    public CustomQueue(){
        this(DEFAULT_SIZE);
    }

    public CustomQueue(int size){
        this.data = new int[size];
    }
    public boolean isFull(){
        return end == data.length;
    }
    private boolean isEmpty(){
        return end == 0;
    }

    public boolean insert(int item){
        if(isFull()){
            return false;
        }
        //having ++ at the end will add the item then increment
        data[end++] = item;
        return true;
    }
    public int remove() throws Exception{
        if(isEmpty()){
            throw new Exception("Queue is empty");
        }
        int removed = data[0];
        for(int i = 1; i< end; i++){
            data[i-1] = data[i];
        }
        end--;

        return removed;
    }
    public int front() throws Exception{
        if(isEmpty()){
            throw new Exception("Queue is empty");
        }

        return data[0];
    }
    public void display(){
        for(int i = 0; i<end ; i++){
            System.out.println(data[i]);
        }
    }
}
