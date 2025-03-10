package Trees;

import java.util.ArrayList;

public class ClassroomBST<T extends Comparable<T>> {
    public BNode<T> root;
    public int size;;

    public ClassroomBST(BNode<T> root){
        this.root = root;
        size++;
    }

    public ClassroomBST(){
    }

    public BNode<T> getRoot(){
        return root;
    }

    public void addRoot(T data){
        if(this.root != null){
            return;
        }
        BNode<T> r = new BNode<>(data);
        this.root = r;
        size++;
    }
    public void add(T data){
        BNode<T> node = find(data);
        if(node == null){
            addRoot(data);
        }
        else if(node.data.compareTo(data)>0){
            //add to left
            addLeft(node, data);
        }
        else if(node.data.compareTo(data)<0) {
            addRight(node, data);
        }
    }
    public void addRight(BNode<T> parent, T data){
        BNode<T> temp = new BNode<>(data);
        temp.parent = parent;
        parent.right = temp;
        size++;

    }
    public void addLeft(BNode<T> parent, T data){
        BNode<T> temp = new BNode<>(data);
        temp.parent = parent;
        parent.left = temp;
        size++;
    }
    public BNode<T> find(T data) {
        if(getRoot() == null){
            return null;
        }
        BNode r = getRoot();
        return findTraverse(r, data);
    }
    public BNode<T> findTraverse(BNode<T> parent, T data){
        int comparsion = data.compareTo(parent.data);
        if(comparsion == 0){
            return parent;
        }
        if(comparsion > 0 && parent.right!=null){
            return findTraverse(parent.right, data);
        }
        if(comparsion < 0 && parent.left!=null){
            return findTraverse(parent.left, data);
        }
        return(parent);

    }
    //looks for data in tree
    public boolean contains(T data){
        BNode<T> temp = find(data);
        if(temp == null){
            return false;
        }
        if(temp.data.compareTo(data)== 0){
            return true;
        }
        else return false;
    }

    public ArrayList<T> inOrder(){

        ArrayList<T> vals = inOrder(root, new ArrayList<>());
        return vals;
    }

    private ArrayList<T> inOrder(BNode<T> root, ArrayList<T> inOrderList){
        if(root == null){
            return null;
        }
        inOrder(root.left, inOrderList);
        inOrderList.add(root.data);
        inOrder(root.right, inOrderList);

        return inOrderList;
    }




    public static void main(String[] args){
        ClassroomBST<InventoryItem> bst = new ClassroomBST();
        InventoryItem item = new InventoryItem(1, "Laptop", 1100);
        InventoryItem item1 = new InventoryItem(1, "Phone", 900);
        InventoryItem item2 = new InventoryItem(1, "Speaker", 563);
        InventoryItem item3 = new InventoryItem(1, "Table", 76);
        InventoryItem item4 = new InventoryItem(1, "Chair", 32);

        bst.add(item);
        bst.add(item1);
        bst.add(item2);
        bst.add(item3);
        bst.add(item4);


        /*
        bst.add(100);
        bst.add(90);
        bst.add(120);
        bst.add(85);
        bst.add(95);
        bst.add(200);

        System.out.println("Root is: "+ bst.getRoot().data);
        System.out.println("Right node is: "+ bst.getRoot().left.data);
        //System.out.println("Left node is: "+ bst.getRoot().right.data);
        System.out.println("Left node of left is: "+ bst.getRoot().left.left.data);
        System.out.println(bst.contains(100));

        System.out.println(bst.inOrder());
        */

    }






    public class BNode<T extends Comparable<T>> {
        public T data;
        public BNode<T> parent;
        public BNode<T> left;
        public BNode<T> right;

        public BNode(T data){
            parent = left = right = null;
            this.data = data;
        }

        public BNode(T data, BNode<T> p, BNode<T> lc, BNode<T> rc){
            this.data = data;
            this.parent = p;
            this.left = lc;
            this.right = rc;
        }

        public void removeChild(BNode<T> child){
            if(child == null){
                return;
            }
            if(child == this.left){
                this.left = null;
            }
            if(child == this.right){
                this.right = null;
            }
        }

    }
}
