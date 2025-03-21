package Queue_Stack;

public class DynamicStack extends CustomStack{

    public DynamicStack(){
        super();
    }
    public DynamicStack(int size){
        super(size);
    }

    @Override
    public boolean push(int item) {
        if(this.isFull()){
            int[] temp = new int[data.length*2];

            for(int i = 0; i< data.length; i++){
                temp[i] = data[i];
            }

            data = temp;
        }
        //after creating the list we know that it is larger therefore
        //we add the element normally
        return super.push(item);
    }
}
