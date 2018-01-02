package Lists.LinkedList;
import java.util.ArrayList;

public class LinkedList {
	protected Node start;
	protected Node end;
	private int size;
	
	public LinkedList() {
		start = null;
		end = null;
		size = 0;
	}
	
	public boolean isEmpty() {
		return (size == 0);
	}
	
	public int getSize() {
		return size;
	}
	
	public void insertAtStart(int val) {
		Node newStart = new Node(val,null);
		size++;
		if (start == null) {
			//Start and end refer to the same node if size == 1
			start = newStart;			
			end = start;
		}
		else {
			//Visualize and see this 
			newStart.setLink(start);
			start = newStart;
		}
	}
	
	public void insertAtEnd(int val) {
		Node newEnd = new Node(val,null);
		size++;
		if (start == null) {
			//Start and end refer to the same node if size == 1
			start = newEnd;
			end = start;
		}
		else {
			//Visualize and see
			end.setLink(newEnd);
			end = newEnd;
		}
	}
	
	public void insertAtPos(int val,int pos) {
		Node newNode = new Node(val,null);
		Node controlPointer = start;
		
		if (pos == 1) {
			insertAtStart(val);
			return;
		}
		
		if (pos == size +1) {
			insertAtEnd(val);
			return;
		}
		
		for (int i = 2; i<size; i++) {
			if (i == pos) {
				Node tmp = controlPointer.getLink();
				controlPointer.setLink(newNode);
				newNode.setLink(tmp);
				break;
			}
			controlPointer = controlPointer.getLink();
		}
		size++;
	}
	
	public void deleteAtPos(int pos) {
		if (pos>size || pos<1) {
			return;
		}
		
		pos = pos-1;
		Node controlPointer = start;
		
		for (int i = 1; i<size; i++) {
			if (i == pos) {
				Node linkNode = controlPointer.getLink().getLink();
				controlPointer.setLink(linkNode);
				break;
			}
		
			controlPointer = controlPointer.getLink();
		}
		size--;
	}
	
	public void display() {
		ArrayList<Integer> showLinkedList = new ArrayList<>();
		Node controlPointer = start;
		showLinkedList.add(controlPointer.getData());
		for (int i =1; i<size; i++) {
			controlPointer = controlPointer.getLink();
			showLinkedList.add(controlPointer.getData());
		}
		System.out.println(showLinkedList);
	}
}
