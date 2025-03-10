package Last_Stone_Weight;

import java.util.Collections;
import java.util.PriorityQueue;

class Solution {
    public static void main(String[] args){
        int[] stones = {2,3,6,2,4};

        System.out.println(lastStoneWeight(stones));
    }
    public static int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        //add all elements to the maxheap
        for (int num : stones) {
            maxHeap.offer(num);
        }
        //while our maxheap has more than only one element.
        while(maxHeap.size() > 1){
            //we set placeholder for first value to be subtracted with next value
            int temp = maxHeap.poll();
            int newVal = temp - maxHeap.poll();
            //after this, the only condition to add the value is if the difference is positive. (the first value is larger)
            if (newVal>0){
                maxHeap.offer(newVal);
            }

        }
        //there is a case where both stones are destroyed until the end! it does nota matter because peek retrieves highest
        maxHeap.offer(0);
        return Math.abs(maxHeap.peek());
    }
}