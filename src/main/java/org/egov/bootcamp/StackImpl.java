package org.egov.bootcamp;


public class StackImpl<T> implements Stack<T> {

    private int total;

    private Node<T> first;

    public StackImpl() { }

    public StackImpl<T> push(T ele)
    {
    	if(ele==null) throw new NullPointerException();
        Node current = first;
        first = new Node();
        first.ele = ele;
        first.next = current;
        total++;
        return this;
    }

    public T pop()
    {
        if (first == null) return null;
        T ele = first.ele;
        first = first.next;
        total--;
        return ele;
    }

	public int size(Node listPointer, int totalLength) {
		if (listPointer == null) {
			return totalLength;
		}
		return size(listPointer.next, ++totalLength);
	}

	public int size() {
		return size(first, 0);
	}
	public boolean isEmpty() {
		return (size()>0?false:true);
	}

	public T[] toArray() {
		int listLength = this.size();
		T[] array = (T[]) new Object[listLength];
		Node listPointer = first;
		for (int i = 0; i < listLength; i++) {
			array[i] = (T) listPointer.ele;
			listPointer = listPointer.next;
		}
		return array;
	}
	
	public boolean contains(T ele) {
		
		if(ele==null) throw new NullPointerException();
		int listLength = this.size();
		Node listPointer = first;
	     	for (int i = 0; i < listLength; i++) {
	    		T existing=(T) listPointer.ele;
	    		if(existing.equals(ele))
	    		{
	    			return true;
	    		}
				listPointer = listPointer.next;
	    	}
	return false;
	}

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        Node tmp = first;
        while (tmp != null) {
            sb.append(tmp.ele).append("");
            tmp = tmp.next;
        }
        return sb.toString();
    }

}
