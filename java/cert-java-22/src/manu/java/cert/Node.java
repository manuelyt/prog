package manu.java.cert;

class Node {
	private Node leftChild, rightChild;

	public Node(Node leftChild, Node rightChild) {
		this.leftChild = leftChild;
		this.rightChild = rightChild;
	}

	public Node getLeftChild() {
		return this.leftChild;
	}

	public Node getRightChild() {
		return this.rightChild;
	}

	public int height() {
		return 0;
//        throw new UnsupportedOperationException("Waiting to be implemented.");
	}
//
//	public static int height2(Node node) {
//		System.out.print(" - ");
//		System.out.print("a");
//    	int right = 0 , left = 0 ;
//    	if ( node.leftChild == null ) {
//    		System.out.print("b");
//    		if ( node.rightChild == null ) {
//    			System.out.print("c");
//    			return 1;
//    		}
//    		else {
//        		System.out.print("d"+height2(node.rightChild)+1);
//    			return height2(node.rightChild)+1;
//    		}
//    	}
//    	else {
//    		if ( node.rightChild == null ) {
//        		System.out.print("e" + height2(node.leftChild)+1);
//    			return height2(node.leftChild)+1;
//    		}
//    		 right = height2(node.rightChild);
//    		 left = height2(node.leftChild);
//    		if (right > left ) {
//        		System.out.print("f" + right);
//    			return right;
//    		}
//    		else {
//        		System.out.print("g"+left);
//    			return left;
//    		}
//    	}
//	}

	public static int height3(Node node) {
		int right = 0, left = 0;
		if (node.leftChild == null) {
			if (node.rightChild == null) {
				return 1;
			} else {
				return height3(node.rightChild) + 1;
			}
		} else {
			if (node.rightChild == null) {
				return height3(node.leftChild) + 1;
			}
			right = height3(node.rightChild);
			left = height3(node.leftChild);
			if (right > left) {
				return right;
			} else {
				return left;
			}
		}
	}

	public static void main(String[] args) {
		Node leaf1 = new Node(null, null);
		Node leaf2 = new Node(null, null);
		Node node = new Node(leaf1, null);
		Node root = new Node(node, leaf2);

		System.out.println(root.height());
		System.out.println();
		System.out.println("asdf asdf a");
		System.out.println(height3(root));
	}
}