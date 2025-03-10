package LongestConsecutiveSequence;

import java.util.HashSet;

class Solution {
    public static void main(String[] args){
        int[] nums = {2,20,4,10,3,4,5};
        System.out.println(longestConsecutive(nums));

    }
    public static int longestConsecutive(int[] nums) {
        //first creates hashset for instant lookup
        HashSet<Integer> set= new HashSet<>();
        for(int i = 0; i< nums.length;i++){
            set.add(nums[i]);
        }

        //initializes our maximum variable starting at 0 if list is empty
        //if greater value will change after the completion of an iteration
        int max = 0;
        for(int i = 0; i< nums.length;i++){
            //we reset this on every iteration as it will be the total count of
            //numbers incremented found in the hashset that may be assigned to max
            int count = 0;
            //wait wouldnt we have tp check every single value iterably? exactly! thats why
            //we instead check if the number is the beginning of a sequence by making sure no
            //values preced it. Originally i also had requirement of having a next value
            //(nums[i]+1) however this fails the case where there is only 1 value in the list

            if(!set.contains(nums[i]-1)){
                //now we assign val to our current iteration value to experiment with in other words
                //increment
                int val = nums[i];
                //every increment we check if the value is still valid
                while(set.contains(val)){
                    val = val+1;
                    //found next increment of value? bump count up
                    count++;
                }
            }else{
                //fails case of starting value (has preceding elements)
            }
            //now we can alter max according to our value of count
            if(count>max){
                max = count;
            }
        }
        return max;
    }

}
