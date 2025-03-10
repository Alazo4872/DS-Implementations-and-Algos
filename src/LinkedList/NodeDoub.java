package LinkedList;

public class NodeDoub <T> {
    T data;
    NodeDoub next;
    NodeDoub prev;

    NodeDoub(T data){
        this.data = data;
    }
    NodeDoub(T data, NodeDoub next){
        this.data = data;
    }
    NodeDoub(T data, NodeDoub next, NodeDoub prev){

            this.data = data;
            this.next = next;
            this.prev = prev;

    }
}
