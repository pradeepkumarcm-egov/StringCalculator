package org.egov.bootcamp;


public class Node<T>  {
    private T ele;
    private Node<T>  next;
     
	public T getEle() {
		return ele;
	}
	public void setEle(T ele) {
		this.ele = ele;
	}
	public Node<T> getNext() {
		return next;
	}
	public void setNext(Node<T> next) {
		this.next = next;
	}
     
     
}
