

/**
 * 
 * Stores the Nodes of the binary tree containing methods to display individual nodes and write individual nodes to a file
 * 
 * @author Adam Munro
 * @version 1.0.0
 *
 */
public class Node {

	private Post item;
	private Node leftNode;
	private Node rightNode;
	

	public Node() {

		item = null;
		leftNode = null;
		rightNode = null;

	}

	public Node(Post item) {

		this.item = item;
		leftNode = null;
		rightNode = null;

	}


	/**
	 * 
	 * Gets the value of item
	 * 
	 * @return item
	 */
	public Post getItem() {
		return item;
	}

	/**
	 *
	 * Sets the value of item
	 *
	 * @param item
	 */
	public void setItem(Post item) {
		this.item = item;
	}

	/**
	 * 
	 * Gets the value of leftNode
	 * 
	 * @return leftNode
	 */
	public Node getLeftNode() {
		return leftNode;
	}

	/**
	 * 
	 * Sets the value of left Node
	 * 
	 * @param leftNode
	 */
	public void setLeftNode(Node leftNode) {
		this.leftNode = leftNode;
	}
	
	/**
	 * 
	 * Gets the value of rightNode
	 * 
	 * @return rightNode
	 */
	public Node getRightNode() {
		return rightNode;
	}

	/**
	 * 
	 * Sets the value of rightNode
	 * 
	 * @param rightNode
	 */
	public void setRightNode(Node rightNode) {
		this.rightNode = rightNode;
	}

}
