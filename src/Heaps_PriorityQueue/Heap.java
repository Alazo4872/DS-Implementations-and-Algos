package Heaps_PriorityQueue;

import java.util.ArrayList;

public class Heap<T extends Comparable<T>> {
    private ArrayList<T> list;

    public Heap(){
        //initializes the list that will simulate our heap
        list = new ArrayList<>();
    }

    //helper method that will help with swaps within the list overtime
    private void swap(int first, int second){
        T temp = list.get(first);
        list.set(first, list.get(second));
        list.set(second, temp);
    }

    //the following are all methods of retrieving parent indices (draw a complete
    //binary tree left to right and perform operations on any index)
    private int parent(int index){
        //0th index
        return (index - 1)/2;
    }

    private int left(int index){
        return (index * 2)+1;
    }

    private int right(int index){
        return (index * 2)+2;
    }

    //puts value at the very end of the list then calls upheap to bubble it
    //into its according place if necessary
    public void insert(T value){
        //at very end
        list.add(value);
        //then swap (upheap)
        upheap(list.size() - 1);
    }
    private void upheap(int index){

        //once 0 is reached, we know it is the head of the heap therefore
        //no other operations can be done
        if(index == 0){
            //it is over
            return;
        }
        //get parent
        //we know if the value is greater we can swap with parent
        int p = parent(index);
        //since our implementation is a min heap, in this logic we use the compareto
        //method in order to see if we should swap the with parent if value is less.
        if(list.get(index).compareTo(list.get(p))<0){
            swap(index, p);
            upheap(p);
        }
    }

    //will remove the min element (head)
    public T remove() throws Exception{
        //cant remove from empty heap
        if(list.isEmpty()){
            throw new Exception("Removing from empty heap!");
        }
        //we store min (head) in temporary value to return it after removal
        T temp = list.get(0);

        //now how do we update the list? we take the last value and set it to the top
        //and make right adjustments by traversing downwards and traversing if
        //necessary (downheap)
        T last = list.remove(list.size()-1);
        if(!list.isEmpty()){
            list.set(0, last);
            downheap(0);
        }
        return temp;
    }

    private void downheap(int index){
        //we initialize two variables to perform the swaps, both left and right of the
        //index, then we want to check which of the sides is smaller to then
        //swap our current larger value and keep traversing downwards
        int min = index;
        int left = left(index);
        int right = right(index);

        if(left<list.size() && list.get(min).compareTo(list.get(left)) > 0){
            min = left;
        }
        if(right<list.size() && list.get(min).compareTo(list.get(right)) > 0){
            min = right;
        }
        //in this case, if min == index this means that neither expression ever happened
        //this means that are current location of index is smaller than both children
        //therefore it is the correct location.
        if(min!= index){
            swap(min, index);
            downheap(min);
        }
    }
    public ArrayList<T> heapSort() throws Exception{
        ArrayList<T> data = new ArrayList<>();

        //it will just remove from the arraylist starting and first value
        //continously doing so until it is empty
        while (!list.isEmpty()) {
            data.add(this.remove());
        }
        return data;
    }
    public static void main(String[] args) throws Exception {
        Heap<Integer> heap = new Heap<>();

        heap.insert(34);
        heap.insert(44);
        heap.insert(14);
        heap.insert(84);
        heap.insert(24);
        heap.insert(984);
        heap.insert(22);

        System.out.println(heap.remove());
        ArrayList list1 = heap.heapSort();
        System.out.println(list1);
    }

}
