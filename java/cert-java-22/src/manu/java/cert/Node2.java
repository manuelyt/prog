package manu.java.cert;

public class Node2 {
	public Node2 getN1() {
		return n1;
	}

	public void setN1(Node2 n1) {
		this.n1 = n1;
	}

	public Node2 getN2() {
		return n2;
	}

	public void setN2(Node2 n2) {
		this.n2 = n2;
	}

	Node2 n1;
	Node2 n2;

	public Node2(Node2 na, Node2 nb) {

	}

	public void set(Node2 na, Node2 nb) {
		this.setN1(na);
		this.setN2(nb);
	}

}
