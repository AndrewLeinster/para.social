import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 * 
 * Stores the binary tree object, containing methods for reading from and
 * writing to files, displaying and searching the tree as well as addding and
 * removing nodes
 * 
 * @author Laura Clark, Adam Munro, Iona Cavill and Andrew Leinster
 * @version 1.0.0
 *
 */
public class Tree {

	private Node root;
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

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
	 * @param newNode  The node to be added
	 * @param current  The current node it is checking
	 * @param previous The last node checked
	 */
	public void addItem(Node newNode, Node current, Node previous) {

		long currentTime = 0;
		long previousTime = 0;
		long newTime = 0;

		if (current != null)
		{
		currentTime = current.getItem().getElapsedTime(current.getItem().getTimePosted(), LocalDateTime.now()); //determines the elapsed time of each node
		}
		if (previous != null)
		{
		previousTime = previous.getItem().getElapsedTime(previous.getItem().getTimePosted(), LocalDateTime.now()); //and stores them as fields in the method
		}
		if (newNode != null)
		{
		newTime = newNode.getItem().getElapsedTime(newNode.getItem().getTimePosted(), LocalDateTime.now());
		}

		if (treeEmpty()) {
			setRoot(newNode); // if there's nothing in the tree, it makes newNode the root
		} else if (current == null || current.getItem() == null) { // if it finds and empty space in the tree it checks
																	// the value of the ID and places it appropriately
			if (previousTime < newTime) {
				previous.setRightNode(newNode);
			} else if (previousTime > newTime) {
				previous.setLeftNode(newNode);
			}
		} else if (current.getItem() != null && currentTime < newTime) {
			addItem(newNode, current.getRightNode(), current); // if the current node isn't empty, it checks the correct
																// next node
		} else if (current.getItem() != null && currentTime > newTime) {
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
	 * Searches the tree for a node and if found, deletes it
	 * 
	 * @param found    whether the node has been found
	 * @param current  the node currently being checked
	 * @param target   the node being searched for
	 * @param previous the previous node that was checked
	 * 
	 */
	public void searchDelete(boolean found, Node current, Post targetPost, Node previous) {

		long target = targetPost.getElapsedTime(targetPost.getTimePosted(), LocalDateTime.now());
		long currentTime = current.getItem().getElapsedTime(current.getItem().getTimePosted(), LocalDateTime.now());

		if (target == currentTime) {

			found = true;
			removeItem(current, previous); // deletes the node when found
			System.out.println("Item Deleted");

		} else if (target < currentTime && current.getLeftNode() != null) {

			searchDelete(found, current.getLeftNode(), targetPost, current);

		} else if (target > currentTime && current.getRightNode() != null) {

			searchDelete(found, current.getRightNode(), targetPost, current);

		}

		if (current.getItem() != null) {
			if (!found && (target > currentTime && current.getRightNode() == null)
					|| (target < currentTime && current.getLeftNode() == null)) {
				System.out.println("Item Wasn't Found"); // if the end of the tree is reached and found = false, a
															// message is displayed
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
			target.setItem(null); // if the node has no children, the node is removed
		} else if (target.getLeftNode() != null && target.getRightNode() == null) {
			target.setItem(null); // if the node has a single child, the node is removed
			parent.setLeftNode(target.getLeftNode()); // and the child is set to be a child of target's parent node
		} else if (target.getLeftNode() == null && target.getRightNode() != null) {
			target.setItem(null);
			parent.setRightNode(target.getRightNode());
		} else if (target.getLeftNode() != null && target.getRightNode() != null) { // if the node has two children

			Node replaced = target.getRightNode();

			while (replaced.getLeftNode() != null) {
				replaced = replaced.getLeftNode(); // finds the left most node on the right hand side of the remainder
													// of the tree
			}

			target.setItem(replaced.getItem()); // sets target to the node found
			replaced.setItem(null); // sets the original node found to null
		}
	}

	public void writeTree() {
		FileOutputStream outputStream = null;
		PrintWriter printWriter = null;
		String fileName;

		fileName = ("PsPosts.txt");

		try {
			outputStream = new FileOutputStream(fileName);
			printWriter = new PrintWriter(outputStream);
			writeNodes(root, printWriter); // writes the tree node by node to the tree

		} catch (IOException e) {
			System.out.println("Error Saving File");
		} finally {
			if (printWriter != null) {
				printWriter.close(); // closes the file
			}
		}
	}

	/**
	 * 
	 * Writes the nodes to a file
	 * 
	 * @param current     the node being written
	 * @param printWriter the instance of PrintWriter being used to write to the file
	 *                
	 */
	public void writeNodes(Node current, PrintWriter printWriter) {
		if (current != null && current.getItem() != null) {
			current.writeNode(printWriter); // writes the current node to the file
			writeNodes(current.getLeftNode(), printWriter); // traverses the tree
			writeNodes(current.getRightNode(), printWriter);
		}
	}

	/**
	 * reads the tree from a file
	 */
	public void readTree() {

		String fileName = null;
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
		String nextLine;

		fileName = ("PsPosts.txt");

		try {
			fileReader = new FileReader(fileName);
			bufferedReader = new BufferedReader(fileReader);
			nextLine = bufferedReader.readLine();
			while (nextLine != null) {
				String ID = nextLine;
				nextLine = bufferedReader.readLine();
				String postedBy = nextLine; 
				nextLine = bufferedReader.readLine();
				LocalDateTime timePosted = LocalDateTime.parse(nextLine, formatter); //converts the text in the file to the neccesary field type
				nextLine = bufferedReader.readLine();
				String caption = nextLine;
				nextLine = bufferedReader.readLine();
				int numberOfLikes = Integer.parseInt(nextLine); //converts the text in the file to the neccesary field type
				nextLine = bufferedReader.readLine();
				int size = Integer.parseInt(nextLine);
				ArrayList<String> likedBy = new ArrayList<String>();
				for (int i = 0; i < size; i++) {

					nextLine = bufferedReader.readLine();
					likedBy.add(nextLine);

				}
				nextLine = bufferedReader.readLine();
				String postImage = nextLine;

				Post item = new Post(postImage, caption, numberOfLikes, likedBy, timePosted, postedBy, ID); 
				// reads the values from the file and creates a new Item, passing the read fields as parameters
				Node node = new Node(item); // creates a new Node containing Item
				nextLine = bufferedReader.readLine();
				addItem(node, root, null); // adds the new Node to the tree as normal

			}
			System.out.println("Loaded");
		} catch (IOException e) {
			System.out.println("Error Loading File");
		} finally {
			if (bufferedReader != null) {
				try {
					bufferedReader.close();
				} catch (IOException e) {
					System.out.println("Error Closing File");
				}
			}
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