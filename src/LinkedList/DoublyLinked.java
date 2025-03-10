package LinkedList;

public class DoublyLinked {
    NodeDoub head;
    int size;

    DoublyLinked(){

    }
    DoublyLinked(NodeDoub head){
        this.head = head;
        size++;
    }
    public int getSize(){
        return size;
    }
    public void prepend(NodeDoub newFirst){
        head.prev = newFirst;
        newFirst = head;
        size++;

    }
    public void insertDoubly(NodeDoub curr, NodeDoub next, NodeDoub prev){
        if(prev != null || next != null) {
            curr.next = next;
            curr.prev = prev;
            next.prev = curr;
            prev.next = curr;
            size++;
        }else{
            System.out.println("Null values");
        }
    }
    public void append(NodeDoub add){
        NodeDoub trav = head;
        while(trav.next != null){
            trav = trav.next;
        }
        add.prev = trav;
        trav.next = add;
        add.next=null;
        size++;

    }
    public void delete(NodeDoub prev, NodeDoub next){
        prev.next = next;
        next.prev = prev;
        size--;
    }


}

