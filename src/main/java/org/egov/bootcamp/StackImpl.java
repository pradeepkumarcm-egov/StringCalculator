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
        first.setEle(ele);
        first.setNext(current); 
        total++;
        return this;
    }

    public T pop()
    {
        if (first == null) return null;
        T ele = first.getEle();
        first = first.getNext();
        total--;
        return ele;
    }

	public int size() {
		int totalLength=0;
		Node current = first;
		if (current == null) {
			return totalLength;
		}
		totalLength++;
		while(current.getNext()!=null){
			current=current.getNext();
			totalLength++;
			}
		return totalLength;
	}

	public boolean isEmpty() {
		return (size()>0?false:true);
	}

	public T[] toArray() {
		int listLength = this.size();
		T[] array = (T[]) new Object[listLength];
		Node listPointer = first;
		for (int i = 0; i < listLength; i++) {
			array[i] = (T) listPointer.getEle();
			listPointer = listPointer.getNext();
		}
		return array;
	}
	
	public boolean contains(T ele) {
		
		if(ele==null) throw new NullPointerException();
		int listLength = this.size();
		Node listPointer = first;
	     	for (int i = 0; i < listLength; i++) {
	    		T existing=(T) listPointer.getEle();
	    		if(existing.equals(ele))
	    		{
	    			return true;
	    		}
				listPointer = listPointer.getNext();
	    	}
	return false;
	}

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        Node tmp = first;
        while (tmp != null) {
            sb.append(tmp.getEle()).append("");
            tmp = tmp.getNext();
        }
        return sb.toString();
    }

}
