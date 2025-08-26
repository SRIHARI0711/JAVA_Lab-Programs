package Queue;
class QueueUnderflowException extends Exception{
    public QueueUnderflowException(String message){
        super(message);
    }
}

class QueueOverflowException extends Exception{
    public QueueOverflowException(String message){
        super(message);
    }
}

class Queue {
    private int size;
    private int front,rear;
    private int[] a;
    
    public Queue(int n){
        a = new int[n];
        size = n;
        front = -1;
        rear = -1;
    }

    public int getSize(){
        return size;
    }

    public void enqueue(int item) throws QueueOverflowException{
        if(rear == size-1){
            throw new QueueOverflowException("Queue Overflow! cannot enqueue" +item);
        }
        if(front == -1){
            front = 0;
        }
        a[++rear] = item;
    }

    public int dequeue() throws QueueUnderflowException{
        if(front == -1 || front > rear){
            throw new QueueUnderflowException("Queue Underflow! cannot dequeue.");
        }
        return a[front++];
    }

    public void display(){
        if(front ==-1 || front > rear){
            System.out.println("Queue is Empty!");
            return;
        }
        System.out.println("The following are the elements of the queue:");
        for(int i = front;i<=rear;i++){
            System.out.println(a[i]);
        }
    }

    public static void main(String[] args) {
        Queue q = new Queue(5);
        
        for(int i = 0;i<q.getSize();i++){
            try{
                q.enqueue(i);
            }
            catch(QueueOverflowException e){
                System.out.println(e.getMessage());
            }
            q.display();
        }
        for(int i = 0;i<q.getSize();i++){
            try{
                System.out.println("Dequeued: "+q.dequeue());
            }
            catch(QueueUnderflowException e){
                System.out.println(e.getMessage());
            }
            q.display();
        }
    }
}
