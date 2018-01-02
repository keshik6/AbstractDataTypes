package Lists.DoublyLinkedList;

import java.util.ArrayList;

public class DoublyLinkedList {
	protected Node start,end;
	private int size;
	
	public boolean isEmpty() {
		return (size == 0);
	}
	
	public int getSize() {
		return size;
	}
	
	public void insertAtStart(int val) {
		Node newStart = new Node(val, null,null);
		if (start == null) {
			start = newStart;
			end = start;
		}
		else {
			newStart.setLinkNext(start);
			start.setLinkPrev(newStart);
			start = newStart;
		}
		size++;
	}
	
	public void insertAtEnd(int val) {
		Node newEnd = new Node(val, null, null);
		if (start == null) {
			start = newEnd;
			end = start;
		}
		else {
			end.setLinkNext(newEnd);
			newEnd.setLinkPrev(end);
			end = newEnd;
		}
		size++;
	}
	
	public void insertAtPos(int val, int pos) {
		Node insertNode = new Node(val, null, null);
		Node controlPointer = start;

		if (pos == 1) {
			insertAtStart(val);
			return;
		}
		
		if (pos == size+1) {
			insertAtEnd(val);
			return;
		}
		
		for (int i = 2; i<size; i++) {
			if (i == pos) {
				Node tmp = controlPointer.getLinkNext();
				controlPointer.setLinkNext(insertNode);           
				insertNode.setLinkPrev(controlPointer);            
				insertNode.setLinkNext(tmp);            
				tmp.setLinkPrev(insertNode);
			}
			
			controlPointer =  controlPointer.getLinkNext();
		}
		size++;
	}
	
	public void deleteAtPos(int pos) {
		Node controlPointer = start;
		if (pos>size || pos<1) {
			return;
		}
		if (pos == 1) {
			Node newStart = start.getLinkNext();
			newStart.setLinkPrev(null);
			start = newStart;
			size--;
			return;
		}
		
		if (pos == size) {
			Node newEnd = end.getLinkPrev();
			newEnd.setLinkNext(null);
			end = newEnd;
			size--;
			return;
		}
		
		pos -= 1;
		for (int i = 1; i<size; i++) {
			if (i == pos) {
				Node tmp = controlPointer.getLinkNext().getLinkNext();
				controlPointer.setLinkNext(tmp);
				tmp.setLinkPrev(controlPointer);
			}
			
			controlPointer = controlPointer.getLinkNext();
		}
		size--;
		
	}
	
	public void display() {
		ArrayList<Integer> showList = new ArrayList<>();
		Node controlPointer = start;
		showList.add(controlPointer.getData());
		for (int i =1; i<size; i++) {
			controlPointer = controlPointer.getLinkNext();
			showList.add(controlPointer.getData());
		}
		System.out.println(showList);
	}
	
}
