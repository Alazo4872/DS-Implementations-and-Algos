package HashMap;

import java.util.LinkedList;

public class HashMapDesign {
    //buckets which stores kv pairs in case of collisions
    //stored in the static array of map
    LinkedList<Entry>[] map;
    //determines size of bucket, prime number for has function
    public static int SIZE = 769;

    //init structure
    public HashMapDesign(){
        map = new LinkedList[SIZE];
    }
    //value is always non-negative
    public void put(int key, int value){
        //Searches the buckets using hashcode
        //if bucket is null we create a new LinkedList and add the entry
        //or else search all entries if key is found then we change its value
        int bucket = key%SIZE;
        if(map[bucket] == null){
            map[bucket] = new LinkedList<>();
            map[bucket].add(new Entry(key, value));
        }
        else{
            //iterate through map to find and change the value if bucket already
            //exists
            for(Entry entry : map[bucket]){
                if(entry.key == key){
                    entry.value = value;
                    return;
                }
            }
            //if value not found
            map[bucket].add(new Entry(key, value));
        }


    }
    //removes specified key value
    public int get(int key){

        int bucket = key % SIZE;
        //since map is a static array of LinkedLists, we use an instance of LinkedList
        //to be assigned to the bucket calculated in key%size calculation
        //then we go look through the entries stored in that linkedlist to find our
        //specified value
        //map-LinkedList-specific value
        LinkedList<Entry> entries = map[bucket];
        //iterate through chosen bucket and find value
        for(Entry entry : entries){
            if(entry.key == key){
                return entry.value;
            }
        }
        return -1;
    }
    //returns value associated with the provided key
    public void remove(int key){
        //first locate bucket in map
        int bucket = key%SIZE;
        //find the entry to be removed
        Entry toRemove = null;
        //do not search if bucket does not exist
        if(map[bucket] == null){
            return;
        }
        else {
            //now find the exact LinkedList using our calculated bucket
            LinkedList<Entry> entries = map[bucket];
            for (Entry entry : entries) {
                //look if entry keys are equivalent in both bucket and provided key
                if (entry.key == key) {
                    toRemove = entry;
                }

            }
            if (toRemove == null) return;
                //remove entry if found
                map[bucket].remove(toRemove);
        }
    }

    //implementation of storing keys and values inside the LinkedList buckets
    public class Entry {
        //public allows direct usage in hashmap
        public int key;
        public int value;

        public Entry(int key, int value){
            this.key = key;
            this.value = value;
        }

    }

}

