package PlusOne;

class Solution {
    public static void main(String[] args){
        int[] digits = {1,2,3,4};
        int[] ans = plusOne(digits);
        for(int num : ans){
            System.out.print(num);
        }
    }
    public static int[] plusOne(int[] digits) {
        //only case we care about is 9 where we will just make the current index to 0
        //and drop to the previous index to do the same thing otherwise we increment.
        //if ptr exceeds list range then we need another place therefore copy elements starting from 1
        //and make the first value 1. (the elements will always be 0);
        int ptr = digits.length-1;
        while(ptr>-1){
            if(digits[ptr]!=9){
                digits[ptr]+=1;
                return digits;
            }
            else{
                digits[ptr] = 0;
                ptr--;
            }
        }
        int[] newlist = new int[digits.length+1];
        for(int i = 1, k=0;i<digits.length-1;i++, k++){
            newlist[i] = digits[k];
        }
        newlist[0] = 1;
        return newlist;
    }
}