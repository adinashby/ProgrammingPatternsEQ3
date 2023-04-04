/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eq3progpatterns;

//import java.util.Stack;

import java.util.Arrays;

/**
 *
 * @author adinashby
 */
public class InsertionSortExercise1 {

    public static void main(String[] args) {
        //Stack<Integer> myStack = new Stack<>();

        Stack myStack = new Stack(5);

        myStack.push(38);
        myStack.push(17);
        myStack.push(50);
        myStack.push(4);
        myStack.push(18);

        myStack.printStack();
        // sortStack(myStack);
        Stack sortedStack = sortStackUsingOurImp(myStack);

        sortedStack.printStack();
    }

//    public static Stack<Integer> sortStack(Stack<Integer> myStack) {
//
//        for (int i = 1; i < myStack.size(); i++) {
//            int key = myStack.get(i);
//            int j = i - 1;
//
//            while (j >= 0 && myStack.get(j) > key) {
//                myStack.set(j + 1, myStack.get(j));
//                j = j - 1;
//            }
//            
//            myStack.set(j + 1, key);
//        }
//
//        return myStack;
//    }
    public static Stack sortStackUsingOurImp(Stack myStack) {
        Stack sortedStack = new Stack(5);

        sortedStack.push(myStack.pop());

        while (!myStack.isEmpty()) {

            int selected = myStack.pop();

            if (sortedStack.peek() < selected) {
                sortedStack.push(selected);
            } else {
                int counter = 0;

                while (!sortedStack.isEmpty() && sortedStack.peek() > selected) {
                    myStack.push(sortedStack.pop());
                    ++counter;
                }

                sortedStack.push(selected);

                for (int i = 0; i < counter; i++) {
                    sortedStack.push(myStack.pop());
                }
            }
        }

        return sortedStack;
    }

}
