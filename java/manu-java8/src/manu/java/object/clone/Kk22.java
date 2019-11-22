package manu.java.object.clone;

public class Kk22 {
	
	public class Pojo22 {
		public String at22;

		public Pojo22() {
		}
	}

	public static void main(String[] args) throws Exception {
		System.out.println(" ------------ ");

		Pojo23 ob22 = new Pojo23();
		ob22.at22 = "aaa";
		ob22.setAt23("ccc");

		Pojo23 ob23 = (Pojo23) ob22.clone();
		System.out.print(ob22.at22);
		System.out.print(" ");
		System.out.print(ob22.getAt23());
		System.out.print("\n");
		System.out.print(ob23.at22);
		System.out.print(" ");
		System.out.print(ob23.getAt23());
		System.out.print("\n");
		System.out.print("\n");
		ob23.at22 = "bbb";
		ob23.setAt23("ddd");
		System.out.print(ob22.at22);
		System.out.print(" ");
		System.out.print(ob22.getAt23());
		System.out.print("\n");
		System.out.print(ob23.at22);
		System.out.print(" ");
		System.out.print(ob23.getAt23());
		System.out.print("\n");

		System.out.println(" ------------ ");
	}

}
