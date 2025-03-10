package Queue_Stack;

public class Main {
    public static void main(String[] args) throws Exception {
        CustomStack stack = new CustomStack(5);
        stack.push(10);
        stack.push(10);
        stack.push(10);
        stack.push(10);
        stack.push(10);

        System.out.println(stack.pop());

        CustomQueue queue = new CustomQueue();

        queue.insert(10);
        queue.insert(11);
        queue.insert(12);
        queue.insert(190);
        queue.insert(112);

        queue.display();
        queue.remove();
        System.out.println();

        queue.display();

        CircularQueue circularQueue = new CircularQueue();
        circularQueue.insert(20);
        circularQueue.insert(21);
        circularQueue.insert(22);
        circularQueue.insert(23);
        circularQueue.display();






    }
}