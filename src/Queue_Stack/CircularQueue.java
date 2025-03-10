package Queue_Stack;

public class CircularQueue {
    protected int[] data;
    //static
    private static final int DEFAULT_SIZE = 10;

    //why? because it will point to where the last object was inserted
    //which will then increment when adding new value
    int end = 0;
    int front = 0;
    private int size = 0;


    public CircularQueue(){
        this(DEFAULT_SIZE);
    }

    public CircularQueue(int size){
        this.data = new int[size];
    }
    public boolean isFull(){
        return size == data.length;
    }
    private boolean isEmpty(){
        return size == 0;
    }

    public boolean insert(int item){
        if(isFull()){
            return false;
        }
        //having ++ at the end will add the item then increment
        data[end++] = item;
        end = end%data.length;
        size++;
        return true;
    }
    public int remove() throws Exception{
        if(isEmpty()){
            throw new Exception("Queue is empty");
        }
        int removed = data[front++];
       front=front% data.length;
        end--;

        return removed;
    }
    public int front() throws Exception{
        if(isEmpty()){
            throw new Exception("Queue is empty");
        }

        return data[front];
    }
    public void display(){
        int i = front;
        do{
            System.out.println(data[i++]);
            i%= data.length;
        }while (i!= end);
        System.out.println("END");
    }
}
