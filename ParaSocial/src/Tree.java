import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * 
 * Stores the binary tree object, containing methods for reading from and writing to files, displaying and searching the tree as well as addding and removing nodes
 * 
 * @author Adam Munro
 * @version 1.0.0
 *
 */
public class Tree {

	private Node root;


	public Tree() {

		root = null;

	}

	public Tree(Node root) {

		this.root = root;

	}

	/**
	 * 
	 * Finds where a node should go in the tree and then adds it
	 * 
	 * @param newNode The node to be added
	 * @param current The current node it is checking
	 * @param previous The last node checked
	 */
	public void addItem(Node newNode, Node current, Node previous) {

		if (treeEmpty()) {
			setRoot(newNode); //if there's nothing in the tree, it makes newNode the root
		} else if (current == null || current.getItem() == null) { //if it finds and empty space in the tree it checks the value of the ID and places it appropriately
			if (previous.getItem().getElapsedTime(previous.getItem().getTimePosted(), LocalDateTime.now()) < newNode.getItem().getElapsedTime(newNode.getItem().getTimePosted(), LocalDateTime.now())) {
				previous.setRightNode(newNode);
			} else if (previous.getItem().getElapsedTime(previous.getItem().getTimePosted(), LocalDateTime.now()) > newNode.getItem().getElapsedTime(newNode.getItem().getTimePosted(), LocalDateTime.now())) {
				previous.setLeftNode(newNode);
			}
		} else if (current.getItem() != null && current.getItem().getElapsedTime(current.getItem().getTimePosted(), LocalDateTime.now()) < newNode.getItem().getElapsedTime(newNode.getItem().getTimePosted(), LocalDateTime.now())) {
			addItem(newNode, current.getRightNode(), current); //if the current node isn't empty, it checks the correct next node
		} else if (current.getItem() != null && current.getItem().getElapsedTime(current.getItem().getTimePosted(), LocalDateTime.now()) > newNode.getItem().getElapsedTime(newNode.getItem().getTimePosted(), LocalDateTime.now())) {
			addItem(newNode, current.getLeftNode(), current);
		}
		

	}

	/**
	 * 
	 * Checks if the tree is empty
	 * 
	 * @return TRUE if tree is empty, FALSE if it is not
	 */
	public boolean treeEmpty() {
		if (getRoot() == null) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * 
	 * Processes user input when searching for a node
	 * 
	 * @param function indicates whether the sought node is to be displayed or deleted
	 */
	public void findNode(String function) {
		boolean valid = false;
		int target = 0;

		while (!valid) {
			System.out.println();
			System.out.println("Enter ID to " + function + ".");
			Scanner s1 = new Scanner(System.in);
			try {

				target = s1.nextInt();
				valid = true;

			} catch (InputMismatchException e) {
				System.out.println("Invalid ID"); //outputs an error message if a non-integer is entered
			}
		}

		if (function.equals("Search")) {
			searchDisplay(false, root, target); //calls the correct method dependent on the value of function
		} else if (function.equals("Delete")) {
			searchDelete(false, root, target, null);
		}

	}

	/**
	 * 
	 * Searches the tree for a node and if found, displays it
	 * 
	 * @param found boolean value indicating whether the node has been found or not
	 * @param current the node currently being checked
	 * @param target the node being searched for
	 */
	public void searchDisplay(boolean found, Node current, int target) {

		if (target == ((current.getItem()).getElapsedTime(current.getItem().getTimePosted(), LocalDateTime.now()))) {

			found = true;
			System.out.println("Item Found");
			current.displayNode(); //displays the node once found

		} else if (target < ((current.getItem()).getElapsedTime(current.getItem().getTimePosted(), LocalDateTime.now())) && current.getLeftNode() != null) {

			searchDisplay(found, current.getLeftNode(), target); //traverses the tree, calling searchDisplay again with the new value of current

		} else if (target > ((current.getItem()).getElapsedTime(current.getItem().getTimePosted(), LocalDateTime.now())) && current.getRightNode() != null) {

			searchDisplay(found, current.getRightNode(), target);

		}
		if (current.getItem() != null) {
			if (!found && (target > ((current.getItem()).getElapsedTime(current.getItem().getTimePosted(), LocalDateTime.now())) && current.getRightNode() == null)
					|| (target < ((current.getItem()).getElapsedTime(current.getItem().getTimePosted(), LocalDateTime.now())) && current.getLeftNode() == null)) {
				System.out.println("Item Wasn't Found"); //if the end of the tree is reached and found = false, a message is displayed
			}
		}

	}

	/**
	 * Searches the tree for a node and if found, deletes it
	 * 
	 * @param found whether the node has been found
	 * @param current the node currently being checked
	 * @param target the node being searched for
	 * @param previous the previous node that was checked
	 * 
	 */
	public void searchDelete(boolean found, Node current, int target, Node previous) {

		if (target == ((current.getItem()).getElapsedTime(current.getItem().getTimePosted(), LocalDateTime.now()))) {

			found = true;
			removeItem(current, previous); //deletes the node when found
			System.out.println("Item Deleted");

		} else if (target < ((current.getItem()).getElapsedTime(current.getItem().getTimePosted(), LocalDateTime.now())) && current.getLeftNode() != null) {

			searchDelete(found, current.getLeftNode(), target, current);

		} else if (target > ((current.getItem()).getElapsedTime(current.getItem().getTimePosted(), LocalDateTime.now())) && current.getRightNode() != null) {

			searchDelete(found, current.getRightNode(), target, current);

		}

		if (current.getItem() != null) {
			if (!found && (target > ((current.getItem()).getElapsedTime(current.getItem().getTimePosted(), LocalDateTime.now())) && current.getRightNode() == null)
					|| (target < ((current.getItem()).getElapsedTime(current.getItem().getTimePosted(), LocalDateTime.now())) && current.getLeftNode() == null)) {
				System.out.println("Item Wasn't Found"); //if the end of the tree is reached and found = false, a message is displayed
			}
		}

    }

	/**
	 * 
	 * Removes a node from the tree
	 * 
	 * @param target the node to be removed
	 * @param parent the parent node of target
	 */
	public void removeItem(Node target, Node parent) {
		if (target.getLeftNode() == null && target.getRightNode() == null) {
			target.setItem(null); //if the node has no children, the node is removed
		} else if (target.getLeftNode() != null && target.getRightNode() == null) {
			target.setItem(null); //if the node has a single child, the node is removed
			parent.setLeftNode(target.getLeftNode()); //and the child is set to be a child of target's parent node
		} else if (target.getLeftNode() == null && target.getRightNode() != null) {
			target.setItem(null);
			parent.setRightNode(target.getRightNode());
		} else if (target.getLeftNode() != null && target.getRightNode() != null) { //if the node has two children
			
			Node replaced = target.getRightNode();

			while (replaced.getLeftNode() != null) {
				replaced = replaced.getLeftNode(); //finds the left most node on the right hand side of the remainder of the tree
			}

			target.setItem(replaced.getItem()); //sets target to the node found
			replaced.setItem(null); //sets the original node found to null

		}
	}

	
	/**
	 * 
	 * Displays the tree from lowest ID to highest
	 * 
	 * @param current the current Node
	 */
	public void inorderDisplay(Node current) {

		if (current != null && current.getItem() != null) {
			inorderDisplay(current.getLeftNode()); //traverses the tree
			current.displayNode(); //displays the current node
			inorderDisplay(current.getRightNode());
		}

	}
	
	/**
	 * 
	 * Displays the tree from bottom to top
	 * 
	 * @param current the current Node
	 */
	public void postorderDisplay(Node current) {

		if (current != null && current.getItem() != null) {
			inorderDisplay(current.getLeftNode()); //traverses the tree
			inorderDisplay(current.getRightNode());
			current.displayNode(); //displays the current node
		}

	}

	/**
	 * 
	 * Displays the tree from top to bottom
	 * 
	 * @param current the current Node
	 */
	public void preorderDisplay(Node current) {

		if (current != null && current.getItem() != null) {
			current.displayNode(); //displays the current node
			inorderDisplay(current.getLeftNode()); //traverses the tree
			inorderDisplay(current.getRightNode());
		}

	}

	/**
	 * Gets the value of root
	 * 
	 * @return root
	 */
	public Node getRoot() {
		return root;
	}

	/**
	 * Sets the value of root
	 * 
	 * @param newRoot
	 */
	public void setRoot(Node newRoot) {
		root = newRoot;
	}

}



