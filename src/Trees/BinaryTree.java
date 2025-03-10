package Trees;

import java.util.Scanner;

public class BinaryTree<T> {

    public BinaryTree(){

    }
    private static class Node<T> {
        //value
        T data;

        //both nodes that can branch out either direction
        Node left;
        Node right;

        //initialize node without any pointers
        Node(T data) {
            this.data = data;
        }

        Node(T data, Node right, Node left) {
            this.data = data;
            this.right = right;
            this.left = left;
        }
    }

        //this is basically the head;
        private Node root;

        //insert elements this is upon creating! a web of continous additions
    // using recursive function to initialize
        public void populate(Scanner scanner){
            //will initialize the first instance of root node
            System.out.println("Enter root node value: ");
            //upcast whatever in put as generic type
            String val = scanner.next();
            T data = (T) val;
            //initialized root with the value passed in
            root = new Node(data);
            populate(scanner, root);

        }
        public void populate(Scanner scanner, Node node){
            System.out.println("Do you want to enter left of " +node.data);
            boolean left = scanner.nextBoolean();
            if(left){
                //will continuously go left until there is ever a contradiction
                System.out.println("Enter the value of the left of "+node.data);
                //converts data to create a new node to the left to make the same
                //process recursive function
                T data = (T) scanner.next();
                node.left = new Node<>(data);
                populate(scanner, node.left);
            }
            //if answer is no moves to next step
            System.out.println("Do you want to enter right of " +node.data);
            boolean right = scanner.nextBoolean();

            if(right){
                System.out.println("Enter the value of the right of "+node.data);

                T data = (T) scanner.next();
                node.right = new Node<>(data);
                populate(scanner, node.right);
            }
            //process has been completed! and will now terminate in recursive stack!
            //in every instance of the recursive function, the process
            //stops halfway if left is true because another function is called.
            //right will always be the final step, so whenever a process is completed
            //it has gone through right and returns to the previous call if it is still
            //in that halfway of left.
        }
        //helper method that is simply called to initiate the display process
    //without any user input using the known root of the tree. After this,
    //it can now initiate the recursive function which will print out the elements
       //sort of like "chain reaction" domino effect
        public void display(){
            display(root, "");
        }
        //recursive method for printing
    public void display(Node node, String indent){
            if(node==null){
                return;
            }
            System.out.println(indent + node.data);
            //these two are used as gateways
           display(node.left, indent +"\t");
           //once it reaches this, the recursive stack of the instance is deleted
           display(node.right,  indent + "\t");
    }
    public void betterDisplay(){
        betterDisplay(root, 0);
    }
    private void betterDisplay(Node node, int level){
            if(node == null){
                return;
            }
            //goes to the right most index first, when it returns
        //from recursive calls it will resume from after this.
            betterDisplay(node.right, level + 1);

            if(level != 0){
                for(int i = 0; i<level-1;i++){
                    //takes into account the levels
                    //and for each will simply place a mark and tab
                    //on that exact same line
                    System.out.print("|\t\t");
                }
                //after this, it will place the data and then skip a line
                //for the next iteration
                System.out.println("|------>" +node.data);
            }else{
                //this means that it is the root
                System.out.println(node.data);
            }
            //why at the end? because first right is taken into account
        //by continously traversing until the right becomes null.
        //now we can take into account left most children and traverse the
        //list to the left most side.
        betterDisplay(node.left, level + 1);


    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BinaryTree tree = new BinaryTree();
        tree.populate(scanner);
        tree.display();
        tree.betterDisplay();
    }

}
