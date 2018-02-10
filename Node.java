package tree;
import java.io.*;
import java.util.*;
//class Node;
public class Node {
	public int iData;
	public double dData;
	public Node leftChild;
	public Node RightChild;
	
	public void displayNode(){
		System.out.print('{');
		System.out.print(iData);
		System.out.print(", ");
		System.out.print(dData);
		System.out.print("}");
	}
}//end class Node
