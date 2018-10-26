package util;

import java.util.Iterator;
import java.util.List;

public class IterList<T> implements Iterator<T>{
	private List myList;
	private int i;

	public void  setList(List<T> l) {
		this.myList=l;
		this.i=0;
	}

	public boolean hasNext() {			
		return (this.i<this.myList.size()) ;
	}

	public T next() {
		int ind=0;
		if(this.i<myList.size()) {
			ind=this.i;
			this.i=this.i+1;
			return (T) (this.myList.get(ind)) ;
		}
		return null;
	}

	public int size() {
		return this.myList.size();	
	}

	public T getIndex(int p) {
		return (T) this.myList.get(p);
	}

	public void init() {
		this.i=0;
	}
}
