package Heaps_PriorityQueue;

import java.lang.reflect.Array;

public class PriorityQueue<T extends Comparable<T>> {
    private T[] pqArray;
    private int qSize, capacity;
    private int index; //keep track of the last inserting index (where to insert next)
    private Class<T> cl;

    public PriorityQueue(Class<T> cl, int capacity){
        this.capacity =capacity;
        this.cl = cl;
        //object that is created in new instance will be cast down to generic array
        //cl is to make class same type for comparisons.
        pqArray = ((T[]) Array.newInstance(cl, capacity));
        qSize = 0;
    }

    public void clear(){
        qSize = 0;
        pqArray = ((T[]) Array.newInstance(cl, capacity));
    }

    public boolean isEmpty(){
        return qSize ==0;
    }
    public boolean isFull(){
        return qSize == capacity;
    }
    public int size(){
        return qSize;
    }

    //Method to add a new prioritized element/object
    public void add(T data){
        if(isFull()){
            System.out.println("Queue is full, cannot insert!");
            return;
        }
        pqArray[index] = data;
        qSize++;
        index++;
        System.out.println("Adding a new element "+ data);
    }

    public T remove(){
        if(isEmpty()){
            System.out.println("The queue is empty");
            return null;
        }
        //removal is done on maximum value and will return it so we first locate it
        int maxIndex = 0;
        for(int i = 0; i<index; i++){
            if(pqArray[i].compareTo(pqArray[maxIndex])>0){
                maxIndex = i;
            }
        }
        //once we have it we assign the value to what we are returning
        T result = pqArray[maxIndex];
        System.out.println("Remove the element"+ result);
        //move the last item in the queue slot and store it where max index is
        //what exactly happens here? well we just move the last element to where our removed element is, effectively deleting it and creating a duplicate
        //why does this work? because by doing this we first have to decrement index to get the last element. even though index points to empty, we now
        //make that last duplicated element as index in order to disregard it and make it to a new value added later on.
        index--;
        pqArray[maxIndex] = pqArray[index];
        qSize--;
        return result;
    }
    public static void main(String[] args){
        PriorityQueue<Integer> pq = new PriorityQueue<>(Integer.class, 4);
        pq.add(10);
        pq.add(40);
        pq.add(20);
        System.out.println(pq.size());
        System.out.println(pq.remove());
        System.out.println(pq.size());

    }

}
