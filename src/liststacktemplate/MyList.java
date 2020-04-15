/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package liststacktemplate;

/**
 *
 * @author Paul
 * @param <T>
 */
public class MyList<T> {

    ListNode head;
    ListNode last;

    /**
     * get the ith element stored in the list. Note that this does not return
     * the containing node, but the stored element in the node. Null if D.N.E.
     *
     * @param i
     * @return
     */
    public T get(int i) {
        if (this.isEmpty()) {
            return null;
        } else {
            this.last = this.head;
            for (int j = 0; j < this.size(); j++) {
                if (j == i) {
                    if (this.last != null) {
                        return (T) this.last.getValue();
                    } else {
                        return null;
                    }
                } else {
                    if (this.last.next != null) {
                        this.last = this.last.next;
                    } else {
                        return null;
                    }
                }
            }
        }
        return null;
    }

    /**
     * Add an element to the end of the list.
     *
     * @param v the element to insert.
     * @return the modified list object
     */
    public MyList<T> add(T v) {

        ListNode newNode = new ListNode(v);
        newNode.next = null;
        if (this.head == null) {
            this.head = newNode;
        } else {
            this.last = this.head;
            for (int i = 0; i < this.size(); i++) {
                if (this.last.next != null) {
                    this.last = this.last.next;
                } else {
                    this.last.next = newNode;
                }
            }
        }
        return this;
    }

    /**
     * removes an element (node) at the index specified.
     *
     * @param i￼
     * @return the element which was removed. null if invalid index.
     */
    public T removeAtIndex(int i) {
        /*
        Be careful here! think about edge cases. If you choose to keep a
        'last' pointer, what if the element being removed is last?
         */
        int index = i - 1;
        T item = this.get(i - 1);
        this.last = this.head;
        ListNode previous = this.head;
        for (int j = 0; j < this.size(); j++) {
            if (j == index) {
                if (this.last == this.head) {
                    this.head = this.head.next;
                    return (T) previous.v;
                } else if (index < this.size()) {
                    this.last.next = this.last.next.next;
                    return (T) previous.v;
                }
            } else {
                if (this.last.next != null) {
                    this.last = this.last.next;
                    previous = previous.next;
                } else {
                    return null;
                }
            }
        }
        return null;
    }

    /**
     * returns the index of the element given. -1 if not found.
     *
     * @param v The element to look for.
     * @return the index or -1 if not found.
     */
    public int indexOf(T v) {
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i) == v) {
                return i;
            }
        }
        return -1;
    }

    /**
     * removes the first occurrence of given element. Does nothing if the
     * element is not present in the list.
     *
     * @param v the element to remove
     * @return the modified list to allow chaining i.e.
     * ls.remove(3).remove(4)...
     */
    public MyList<T> remove(T v) {
        int index = this.indexOf(v) - 1;
        this.last = this.head;
        for (int i = 0; i < this.size(); i++) {
            if (i == index) {
                if (this.last == this.head) {
                    this.head = this.head.next;
                } else if (index < this.size()) {
                    this.last.next = this.last.next.next;
                }
            } else {
                if (this.last.next != null) {
                    this.last = this.last.next;
                } else {
                    return null;
                }
            }
        }
        return this;
    }

    /**
     * calculates and returns the size/length of the list.
     *
     * @return the length/size.
     */
    public int size() {
        int counter = 0;
        ListNode x = this.last;
        while (x != null) {
            counter++;
            x = x.next;
        }
        return counter;
    }

    /**
     * Answers if there are any elements in the list.
     *
     * @return true if list contains at least 1 element, false otherwise.
     */
    public boolean isEmpty() {
        if (this.size() < 1) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * A pretty toString for lists.
     *
     * @return MyList: [elem1, elem2, elem3...]
     */
    @Override
    public String toString() {
        T current;
        String print = "";
        for (int i = 0; i < this.size(); i++) {
           current = this.get(i);
           print += current;
        }
        return print;
    }

}
