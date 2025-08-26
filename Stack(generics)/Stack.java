public class Stack<T> {
    private int maxSize;
    private T[] stackArray;
    private int top;

    @SuppressWarnings("unchecked")
    public Stack(int size) {
        this.maxSize = size;
        stackArray = (T[]) new Object[size];
        this.top = -1; // Stack is initially empty
    }
    public void push(T item) {
        if (top == maxSize - 1) {
            System.out.println("Stack is full. Cannot push " + item);
            return;
        }
        stackArray[++top] = item;
        System.out.println("Pushed: " + item);
    }
    public boolean isEmpty() {
        return top == -1;
    }

    public T pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty. Cannot pop.");
            return null;
        }
        T item = stackArray[top--];
        System.out.println("Popped: " + item);
        return item;
    }
    public void clear() {
        top = -1; // Reset the stack to empty
        System.out.println("Stack cleared.");
    }
    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return;
        }
        System.out.print("Stack contents: ");
        for (int i = top;i >= 0; i--) {
            System.out.print(stackArray[i] + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Stack<Integer> intStack = new Stack<>(5);
        intStack.push(10);
        intStack.push(20);
        intStack.push(30);
        intStack.display();
        
        intStack.pop();
        intStack.display();
        
        intStack.clear();
        intStack.display();

        System.out.println();

        Stack<String> stringStack = new Stack<>(5);
        stringStack.push("Hello");
        stringStack.push("World");
        stringStack.push("Java");
        stringStack.display();
        stringStack.pop(); stringStack.display(); stringStack.clear();
        stringStack.display();
        System.out.println("Stack operations completed.");
    }
}