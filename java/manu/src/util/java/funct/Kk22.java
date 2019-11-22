package util.java.funct;

import util.java.object.clone.Pojo23;

public class Kk22 {

	private static void foo(Object bar) {
		bar = null;
	}


	private static void foo2(Pojo23 bar) {
		bar.at22 = null;
		bar.setAt23(null);
	}

	public static void main(String[] args) {
		String baz = "Hah!";
		foo(baz);
		System.out.println(baz);

		Pojo23 ob22 = new Pojo23();
		ob22.at22 = "aaa";
		ob22.setAt23("ccc");

		System.out.print("          " + ob22.at22);
		System.out.print(" ");
		System.out.print(ob22.getAt23());
		System.out.print("\n");

		foo2(ob22);

		System.out.print("          " + ob22.at22);
		System.out.print(" ");
		System.out.print(ob22.getAt23());
		System.out.print("\n");
	}
}
