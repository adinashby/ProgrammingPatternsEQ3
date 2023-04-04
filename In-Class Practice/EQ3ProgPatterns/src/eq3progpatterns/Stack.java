/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eq3progpatterns;

import java.util.Arrays;

/**
 *
 * @author adinashby
 */
class Stack {

    private int arr[];
    private int top;
    private int capacity;

    // Constructor to initialize the stack
    Stack(int size) {
        arr = new int[size];
        capacity = size;
        top = -1;
    }

    // Utility function to add an element `x` to the stack
    public void push(int x) {
        if (isFull()) {
            System.out.println("Overflow\nProgram Terminated\n");
            System.exit(-1);
        }
         
        int newSize = top + 2;
        
        arr = Arrays.copyOf(arr, newSize);
        
        
        //System.out.println("Inserting " + x);
        arr[++top] = x;
        
        ++capacity;
    }

    // Utility function to pop a top element from the stack
    public int pop() {
        // check for stack underflow
        if (isEmpty()) {
            System.out.println("Underflow\nProgram Terminated");
            System.exit(-1);
        }
        
        int removed = arr[top];
        //System.out.println("Removing " + peek());
        arr = Arrays.copyOf(arr, top);
        
        top--;
        
        --capacity;
        // decrease stack size by 1 and (optionally) return the popped element
        return removed;
    }

    // Utility function to return the top element of the stack
    public int peek() {
        if (!isEmpty()) {
            return arr[top];
        } else {
            System.exit(-1);
        }

        return -1;
    }

    // Utility function to return the size of the stack
    public int size() {
        return top + 1;
    }

    // Utility function to check if the stack is empty or not
    public boolean isEmpty() {
        return top == -1; // or return size() == 0;
    }

    // Utility function to check if the stack is full or not
    public boolean isFull() {
        return top == capacity - 1; // or return size() == capacity;
    }
    
    public void printStack() {
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {

        Stack stack = new Stack(3);

        stack.push(1);      // inserting 1 in the stack
        stack.push(2);      // inserting 2 in the stack

        stack.pop();        // removing the top element (2)
        stack.pop();        // removing the top element (1)

        stack.push(3);      // inserting 3 in the stack

        System.out.println("The top element is " + stack.peek());
        System.out.println("The stack size is " + stack.size());

        stack.pop();        // removing the top element (3)

        // check if the stack is empty
        if (stack.isEmpty()) {
            System.out.println("The stack is empty");
        } else {
            System.out.println("The stack is not empty");
        }
    }
}
