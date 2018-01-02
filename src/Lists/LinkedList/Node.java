package Lists.LinkedList;

public class Node {
	protected int data;
	protected Node link;
	
	public Node(int data,Node link) {
		this.data = data;
		this.link = link;		
	}
	
	public Node() {
		this(0,null);
	}
	
	public void setLink(Node n) {
		link = n;
	}
	
	public Node getLink() {
		return link;
	}
	
	public void setData(int n) {
		data = n;
	}
	
	public int getData() {
		return data;
	}
}
