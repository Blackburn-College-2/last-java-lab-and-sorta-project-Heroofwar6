/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package liststacktemplate;

import org.w3c.dom.Node;

/**
 *
 * @author Paul
 */
public class ListNode<T>  {
    ListNode next;
    T v;
    /**
     * Create a new ListNode given a value.
     *
     * @param v
     */
    ListNode(T v) {
        this.v = v;
        this.next = null;
    }

    /**
     * return the value being held by this Node.
     *
     * @return
     */
    public T getValue() {
        return this.v;
    }
}
