/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package liststacktemplate;

/**
 *
 * @author Paul
 */
public class MyStack<T> {

    MyList<T> arr = new MyList();

    /**
     * push an element onto the stack
     *
     * @param t the element to add to the stack
     * @return return the stack to allow chaining. i.e. stack.push(1).push(2)...
     */
    public MyStack<T> push(T t) {
        arr.add(t);
        return this;
    }

    /**
     * remove and return the top element from the stack. This method should
     * throw an exception of your own descriptive making when this method is
     * called on an empty stack.
     *
     * @return the top of the stack/removed element
     */
    public T pop() {
        int i = 0;
        T removedElement;
        if(arr != null){
            while (i <= arr.size()) {
                if (i < arr.size()) {
                    i++;
                } else if (arr.get(i) != null) {
                    removedElement = arr.get(i);
                    arr.removeAtIndex(i);
                    return removedElement;
                }

            }
        }else{
            System.out.println("EmptyStack Exception");
        }
            return null;
    }

    /**
     * returns the top element on the stack, but does not remove it.
     *
     * @return the top element of the stack
     */
    public T peek() {
        int i = 0;
        T peekElement;
        if(arr != null){
            while (i <= arr.size()) {
                if (i < arr.size()) {
                    i++;
                } else if (arr.get(i) != null) {
                    peekElement = arr.get(i);
                    return peekElement;
                }

            }
        }else{
            System.out.println("EmptyStack Exception");
        }
            return null;
    }

    /**
     * Answers whether or not the stack contains elements.
     *
     * @return true-contains elements; false otherwise.
     */
    public boolean isEmpty() {
         if (arr.size() < 1) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * returns how many elements are in the stack.
     *
     * @return
     */
    public int size() {
        return arr.size();
    }

    /**
     * Custom toString which prints the stack... as a stack. (See example test
     * case from lab.
     *
     * @return
     */
    @Override
    public String toString() {
        return arr.toString();
    }
}
