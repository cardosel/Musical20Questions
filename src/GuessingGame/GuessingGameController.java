package GuessingGame;

import BinaryTree.*;
import xml.CommutativeExpressionReader;
import xml.CommutativeExpressionWriter;

/**
 * Controller class
 */
public class GuessingGameController {
	private DefaultBinTree<String> tree;
	private DefaultBinTreeNode<String> currentNode;
	private GuessingGameView view;

	public GuessingGameController(GuessingGameView view) {
		this.view = view;
		// this is to initialize both tree & node
		tree = new DefaultBinTree<String>();
		tree = (DefaultBinTree<String>) CommutativeExpressionReader
				.readCommutativeExpr("extra/txt/Music.xml");
		currentNode = (DefaultBinTreeNode<String>) tree.getRoot();
	}

	// return the current node 
	
	public DefaultBinTreeNode<String> getCurrentNode() {
		return currentNode;
	}

	// returns the tree
	public DefaultBinTree<String> getTree() {
		return tree;
	}

	// method when user clicks yes
	public void clickY() {
		// checks if the node's child is a leaf
		// gets to the first question
		if (currentNode.getLeftChild() == null
				|| currentNode.getRightChild() == null) {
			// if left node is not null
			if(currentNode.getLeftChild() != null)
				// move to the answer
				currentNode = (DefaultBinTreeNode<String>) currentNode.getLeftChild();
			else
				// move to the answer
				currentNode = (DefaultBinTreeNode<String>) currentNode.getRightChild();
			// set text to be the answer
			view.getQuestion().setText(
					"So it's definitely " + ((String) currentNode.getData()).substring(2)
							+ " !");
			view.restartGame();
		}
		// if current node's child is not a leaf
		else {
			// see the 1st char of the answers
			char ans = ((String) currentNode.getLeftChild().getData())
					.charAt(0);
			// if the left child is the yes answer
			if (Character.toString(ans).equals("Y"))
				// move to next question
				currentNode = (DefaultBinTreeNode<String>) currentNode.getLeftChild();
			else {
				// move to next question
				currentNode = (DefaultBinTreeNode<String>) currentNode.getRightChild();
			}
			// set text to be the next question
			view.getQuestion().setText(
					((String) currentNode.getData()).substring(2));
		}
	}

	// method when user clicks no
	public void clickN() {
		// check if the current node's child is a leaf first
		// get to the question "Are you thinking of..."
		if (currentNode.getLeftChild() == null
				|| currentNode.getRightChild() == null) {
			// display the question's text
			view.getQuestion()
					.setText(
							"Oops... I guessed wrong! Please tell me the correct answer!");
			// form to take user's new questions
			view.questForm();
		}

		// if current node's child is not a leaf
		else {
			// see the 1st char of the answers
			char ans = ((String) currentNode.getLeftChild().getData())
					.charAt(0);
			// if the left child is the yes answer
			if (Character.toString(ans).equals("N")) {
				// move to next question
				currentNode = (DefaultBinTreeNode<String>) currentNode.getLeftChild();
			} else {
				// move to next question
				currentNode = (DefaultBinTreeNode<String>) currentNode.getRightChild();
			}
			// set text to be the next question
			view.getQuestion().setText(
					((String) currentNode.getData()).substring(2));
		}
	}

	/**
	 * Method called to update tree and xml file
	 */
	public void updateTree(boolean clickYes, String question, String answer) {
		// add the question to be the current node's child
		// if left child is null
		if (currentNode.getLeftChild() == null) {
			currentNode.setLeftChild(new DefaultBinTreeNode<String>("N:" + question));
			// current node is now the child
			currentNode = (DefaultBinTreeNode<String>) currentNode.getLeftChild();
		} 
		// if right child is null
		else {
			currentNode.setRightChild(new DefaultBinTreeNode<String>("N:" + question));
			// current node is now the child
			currentNode = (DefaultBinTreeNode<String>) currentNode.getRightChild();
		}

		// if user click yes as the answer
		if (clickYes) {
			// if left child is null
			if (currentNode.getLeftChild() == null)
				// set left child to be the answer with the Y
				currentNode.setLeftChild(new DefaultBinTreeNode<String>("Y:" + answer));
			// if right child is null
			else
				// set right child to be the answer with the Y
				currentNode.setRightChild(new DefaultBinTreeNode<String>("Y:" + answer));
		}
		else{
				// if left child is null
				if (currentNode.getLeftChild() == null)
					// set left child to be the answer with the N
					currentNode.setLeftChild(new DefaultBinTreeNode<String>("N:" + answer));
				// if right child is null
				else
					// set right child to be the answer with the N
					currentNode.setRightChild(new DefaultBinTreeNode<String>("N:" + answer));
			}
	
		// update the xml file and the tree
		CommutativeExpressionWriter.writeCommutativeExpr( (BinTree<String>) getTree(), "extra/txt/Music.xml");
	
		// set question text
		view.getQuestion().setText("Let's try again!");
		// restart the game through view
		view.restartGame();
	}
}
