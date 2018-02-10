package tree;

public class Tree {
	private Node root;
	
	public Tree(){
		root = null;
	}
	
	public Node find(int key){
		Node current = root;
		while(current.iData != key){
			if(key < current.iData){
				current = current.leftChild;
			}else{ 
				current = current.RightChild;	
			}
			if (current == null){
				return null;
			}
		}
		return current;
	}
	
	public void insert(int id, double dd){
		Node newNode = new Node();
		newNode.iData = id;
		newNode.dData = dd;
		if (root == null){
			root = newNode;
		}else {
			Node current = root;
			Node parent;
			while (true){
				parent = current;
				if (id < current.iData){
					current = current.leftChild;
					if(current == null){
						parent.leftChild = newNode;
						return;
					}
				}else {
					current = current.RightChild;
						if(current == null){
							parent.leftChild = newNode;
							return;
						}
				}
			}
		}
	}
	
	public boolean delete(int key){
		Node current = root;
		Node parent = root;
		boolean isLeftChild = true;
		
		while(current.iData != key){
			parent = current;
			if(key < current.iData){
				isLeftChild = true;
				current = current.leftChild;
			}else {
				isLeftChild = false;
				current = current.RightChild;
			}
			if (current == null){
				return false;
			}
		}
		if (current.leftChild == null && current.RightChild == null){
			if (current == root){
				root = null;
			}else if(isLeftChild){
				parent.leftChild = null;
			}else {
				parent.RightChild = null;
			}
		}else if (current.RightChild == null){
			if(current == root){
				root = current.leftChild;
			}else if(isLeftChild){
				parent.leftChild = current.RightChild;
			}else {
				parent.RightChild = current.RightChild;
			}
		}else {
			Node successor = getSuccessor(current);
			if(current == root){
				root = successor;
			}else if(isLeftChild){
				parent.leftChild = successor;
			}else{
				parent.RightChild = successor;
			}
			successor.leftChild = current.leftChild;
		}
		return true;
	}
	private Node getSuccessor(Node delNode){
		Node successorParent = delNode;
		Node successor = delNode;
		Node current = delNode.RightChild;
		while(current != null){
			successorParent = successor;
			successor =current;
			current = current.leftChild;
		}
		if(successor != delNode.RightChild){
			successorParent.leftChild = successor.RightChild;
			successor.RightChild = delNode.RightChild;
		}
		
		return successor;
	}
	
	private void traverse(int traverseType){
		switch(traverseType){
		case 1: System.out.print("\nPreorder traversal: ");
				preOrder(root);
				break;
		case 2: System.out.print("\nInorder traversal: ");
				nInOrder(root);
				break;
		case 3: System.out.print("\nPostInorder traversal: ");
				postInOrder(root);
				break;
		}
	System.out.println();
	}
	
	private void preOrder(Node localRoot){
		if(localRoot != null){
			System.out.print(localRoot.iData + " ");
			preOrder(localRoot.leftChild);
			preOrder(localRoot.leftChild.RightChild);
		}
	}
	
	private void inOrder (Node localRoot){
		if (localRoot != null){
			inOrder(localRoot.leftChild);
			System.out.print(localRoot.iData + " ");
			inOrder(localRoot.RightChild);
		}
	}
	
	private void postOrder(Node localRoot){
		if (localRoot != null){
			postOrder(localRoot.leftChild);
			postOrder(localRoot.RightChild);
			System.out.print(localRoot.iData + " ");
		}
	}
}
