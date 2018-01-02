package Lists.DoublyLinkedList;

public class Node {
	protected int data;    
	protected Node next, prev;
	
	public Node(int val, Node next, Node prev) {
		this.data = val;
		this.next = next;
		this.prev = prev;
	}
	
	public Node() {
		this(0, null, null);
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public Node getLinkNext() {
		return next;
	}

	public void setLinkNext(Node next) {
		this.next = next;
	}

	public Node getLinkPrev() {
		return prev;
	}

	public void setLinkPrev(Node prev) {
		this.prev = prev;
	}
}
