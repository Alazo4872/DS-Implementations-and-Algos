package HashMap;

public class FirstHashMap {
    //array is length of 1000000 values being the bound
    int[] map;
    //init structure
    public FirstHashMap(){
        map = new int[1000000];
        /*
        each value is mapped out to be -1 because this will be the return if
        value does not exist, but it takes a long time inside a for loop
        Instead, we add 1 to the value in put method and subtract 1 in the get
        method to have the same implementation knowing that values are
        initialized as 0

        for(int i = 0; i<= map.length;i++){
             map[i] = -1;
         }
        */

    }
    public void put(int key, int value){
        //index of the key when calculated is found in the list where it then
        //replaces the current value
        map[key] = value+1;
    }
    //retrieves the value tied to the key controlled in hashcode func -1 returned
    //if key not found (meaning value can automatically not be negative!)
    public int get(int key){
        //will simply return the value found at the key index provided
        return map[key]-1;
    }
    //Removes mapping of specified key value
    public void remove(int key){
        //provided index is found on our map and the according value is then removed
        //returns to being 0 or -1 having for loop implementation
        map[key] = 0;
    }
}
