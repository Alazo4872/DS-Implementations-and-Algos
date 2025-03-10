package Trees;

public class SegmentTrees {


    public static void main(String[] args) {

            int[] arr = {3,8,6,7,-1,-8,4,9};
            SegmentTrees tree = new SegmentTrees(arr);
        }



    private class Node {
        int data;
        int startInterval;
        int endInterval;
        Node left;
        Node right;

        public Node(int startInterval, int endInterval) {
            this.startInterval = startInterval;
            this.endInterval = endInterval;
        }
    }

    Node root;

    public SegmentTrees(int[] arr) {
        //create a tree using th array
        //assign it to root so we can return the entire updated tree
        //O(N) to make tree
        //start and end intervals denote the indices to be calculated when
        //storing the wanted value
        this.root = constructTree(arr, 0, arr.length-1);
    }

    private Node constructTree(int[] arr, int start, int end){
        //you know you have reached the end of the tree because
        //after halving start and end you have finally come to a singular
        //point now you can just assign that index and return the
        //leaf in recursive stack to then be processed (if sum function
        //will add the elements)
        if(start == end){
            //leaf node
            Node leaf = new Node(start, end);
            leaf.data = arr[start];
            return leaf;
        }

        //create new node with index you are at
        Node node = new Node(start, end);

        int mid = (start+end)/2;

        //mid+1 why? because integers round down therefore we can predict
        //that when passed down list length is even (no middle)
        //it will be offset by the smallest value which allows us to then
        //pass mid+1 as the offset to right
        node.left = this.constructTree(arr, start, mid);
        node.right = this.constructTree(arr, mid+1, end);


        //so what is happening here? remember that the leaf node is returning
        //the updated version of itself (a single value) therefore we can
        //now use this functionality to collect both children's data and
        //sum it as this nodes data then we take that data all the way
        //up the tree
        node.data = node.left.data + node.right.data;
        return node;

    }

    public void display(){
        display(root);
    }
    private void display(Node node){
        String str = "";

        if(node.left != null){
            str = str +"Interval =" + node.left.startInterval + "-" +node.left.endInterval + "] and data: " +node.left.data + " -> ";
        }
        else{
            str = str + "No left child";
        }
        //current interval
        str = str +"Interval =" + node.startInterval + "-" +node.endInterval + "] and data: " +node.data + " <- ";

        if(node.right != null){
            str = str +"Interval =" + node.right.startInterval + "-" +node.right.endInterval + "] and data: " +node.right.data + " -> ";
        }
        else{
            str = str + "No right child";
        }
        System.out.println(str);

        //call recursion
        if(node.left != null){
            display(node.left);
        }
        if(node.left != null){
            display(node.right);
        }
    }
    //query start and end index
    public int query(int qsi, int qei){
        return this.query(this.root, qsi, qei);
    }

    public int query(Node node, int qsi, int qei){
        if(node.startInterval >- qsi && node.endInterval <= qei){
            //this means that the node lies inside of the exact query
            return node.data;
        } else if (node.startInterval>qei || node.endInterval <qsi) {
            //completely out of range outside therefore value isnt here
            return 0;
        }else{
            //this is the case when there is some overlap therefore
            //we are free to traverse
            return this.query(node.left, qsi, qei) +
                    this.query(node.right, qsi, qei);
        }
    }
    public void updateIndexValue(int index, int value){
        updateIndexValue(this.root, index, value);
    }
    private int updateIndexValue(Node node, int index, int value){
        //here we now that the start index is found inside the range
        //of this node
        if(index >= node.startInterval&& index <= node.endInterval){
            //here we know that the intervals point to one value
            //which is our desired value so we set and return the update
            if(index == node.startInterval && index == node.endInterval){
                node.data = value;
                return node.data;
            }
            else{
                //this is the case where we start traversing backwards
                //at this point we can start updating the values
                //of each node by taking the new left and right of the
                //subtrees and returning them
                //we never worry about another possibility of value
                //not found in list as it is handled at the beginning
                int leftAns = updateIndexValue(node.left, index, value);
                int rightAns = updateIndexValue(node.right, index, value);

                node.data = leftAns + rightAns;
                return node.data;
            }
        }
        return node.data;
    }
}


