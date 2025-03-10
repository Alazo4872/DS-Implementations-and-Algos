package Trees;

import java.util.Scanner;

public class BinarySearchTree {

    public class Node{
        private int height;
        private int val;
        private Node left;
        private Node right;

        public Node(int val){
            this.val = val;

        }
        public int getValue(){
            return this.val;
        }
    }
    private Node root;
    BinarySearchTree(){

    }
    public int height(Node node){
        if (node == null) {
            return -1;
        }
        return node.height;
    }
    public boolean isEmpty(){
        return root == null;
    }
    public void display(){
        //initiates the recursive function call
        display(root, "Root Node: ");
    }
    private void display(Node node, String details){
        //means there is nothing here
        if(node == null){
            return;
        }
        //prints current instance
        System.out.println(details + node.getValue());
        //will first try to print left most children of each iteration
        //then after left most will go back the recursive chain
        display(node.left,  "Left child of: "+node.getValue() + " : ");
        display(node.right,  "Right child of: "+node.getValue() + " : ");
    }

    private void insert(Node newNode){
        if(root == null){
            root = newNode;
        }
        insert(newNode, root);
    }

    private void insert(Node newNode, Node currNode){
        //will simply kill the stack because previous call stack logic
        //has already been placed
        if(newNode.val== currNode.val){
            return;
        }
        //will check which half to delete by traversing the list
        //using the left smaller right greater logic
        //then we can check if there is an object there (not null)
        //if null we set it equal to val
        if(newNode.val<currNode.val){
            //here now that we know to go here, we have two options.
            //either we keep going or we found an empty space to put
            //our inserted node.
            //then we return because we dont need the right logic anymore
            if(currNode.left == null){
                currNode.left = newNode;
                return;
            }else {
                insert(newNode, currNode.left);
            }
        }
        if(newNode.val>currNode.val) {
            if (currNode.right == null) {
                currNode.right = newNode;
            } else {
                insert(newNode, currNode.right);
            }
        }
        currNode.height = Math.max(height(currNode.left), height(currNode.right))+1;

    }
    public void populate(int[] nums){
        for(int i = 0; i<nums.length;i++){
            this.insert(new Node(nums[i]));
        }
    }
    private void insertNew(Node newNode, Node currNode){
        //instead of putting logic in the if statement, we check in the beginning
        //if this value is null
        if(currNode == null){
            currNode = newNode;
            return;
        }
        if(newNode.val>currNode.val){
            insertNew(newNode, currNode.left);
        }

        if(newNode.val>currNode.val){
            insertNew(newNode, currNode.right);
        }
        //now we increment the height since we added another element
        //the height is based on the element to its children. so it takes the largest
        //value of its childrens height and then adds 1 because it is a new level.
        //max just compares the largest value and takes that one, it is essential because
        //this will give us what we are really looking for which is the furthest down
        //the tree goes. no children = -1 because when added to 1 it now equals 0.
        currNode.height = Math.max(height(currNode.left), height(currNode.right))+1;
        //means they are equal value
        return;
    }
    public boolean balanced(){
        return balanced(root);
    }
    private boolean balanced(Node node){
        if(node == null){
            return true;
        }
        //finds the height of both left and right and checks the positive fifference in order
        //to see if it is balanced (does not excede 1 height of difference.
        //then will also recursiely call children on both left and right to check any other possibilities
        //within children
        //this will make sure every node is traversed because it has both scenarios on call stack

        return Math.abs(height(node.left) - height(node.right)) <= 1 && balanced(node.left) && balanced(node.right);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BinarySearchTree tree = new BinarySearchTree();
        int[] nums = {1,9,3,8,4,2};
        tree.populate(nums);
        tree.display();
        System.out.println(tree.balanced());
        tree.orderTraversal();
        System.out.println("\n");
        tree.postOrderTraversal();
    }
    public void populateSorted(int[] nums){
        populateSorted(nums, 0, nums.length);
    }

    private void populateSorted(int[] nums, int start, int end){
        //this means that the two pointer is no longer pointing at more
        // than 1 element
        if(start>=end){
            return;
        }
        //gives list middle to be inserted first every time in order to be stored
        //in balance
        //condition is start>=end but still includes last mid value!
        //because the mid is calculated afterwards. otherwise we would have
        //infinite recursion due to the element being equivalent
        int mid = (start+ end);
        this.insert(new Node(nums[mid]));

        //after this, it will recursively call methods for each middle element

        populateSorted(nums, start, mid);
        populateSorted(nums, mid+1, end);

    }
    //helper function that will access the root node
    public void orderTraversal(){
        orderTraversal(root);
    }
    public void orderTraversal(Node node){
        //first it traverses left most and then it is allowed to print
        //once we have reached a null node we can return to the previous recursive track
        //where it will originally leave of at node.left completion of last node.

        if(node == null){
            return;
        }

            orderTraversal(node.left);

            System.out.print(node.val+" ");

            orderTraversal(node.right);

    }
    //helper function that will access the root node
    public void postOrderTraversal(){
        postOrderTraversal(root);
    }
    public void postOrderTraversal(Node node){
        //first it continoulsy traverses while there is still left and right
        //once it hits an edge, the left right calls are exhausted and the
        //stack will start clearing

        //usage when deleting because it assures all edges
        //bottom up calculation such as height


        if(node == null){
            return;
        }

        postOrderTraversal(node.left);

        postOrderTraversal(node.right);

        System.out.print(node.val+" ");


    }
}
