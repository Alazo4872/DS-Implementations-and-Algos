package Recursion;

public class Main {
    public static void main(String[] args) {
        //all recursive calls should have base case to prevent infinite loops
        //all recursion can be solved with iteration
        //easy to solve problems but space complexity is not constant
        //breaks down bigger problems into smaller ones
        //how to know if we can solve? if we can break it into smaller numbers
        //it is called a recurrence relation
        //ex: fibo(n) into 2 smaller probs  = fibo(n-1) + fibo(n-2)
        add(1);
        int[] arr = {1,5,8,5,3,3,0,28,1789};
        System.out.println(binarySearch(arr, 5, arr.length-1, 0));
        System.out.println("\n\n\n");
        System.out.println(fibo(6));
    }
    static void add(int x){
        if(x==5) {
            return;
        }
        System.out.println(x);
        //tail recursion
        add(x+1);
    }
    public static int fibo(int n){
        //here we know fibo when broken down is equal to 1 or 0
        if(n<2){
            return n;
        }
        //will recursively call until it reaches 1 then first fibo will return 1
        //and next will return 0. then now that we have those values the addition will
        //be returned upwards
        return fibo(n-1) + fibo(n-2);
    }
    public static int binarySearch(int[] arr, int target, int r, int l){
        if(l>r){
            return -1;
        }
        int m = (r-l)/2;
        if(arr[m] == target){
            return m;
        }
        if(target>arr[m]){
            return binarySearch(arr, target, r, m+1);
        }
            return binarySearch(arr, target, m-1, l);
    }
}