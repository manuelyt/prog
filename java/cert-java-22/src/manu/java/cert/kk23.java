package manu.java.cert;

public class kk23 {
	static int kk23;
	int kk24;

	public kk23() {
	}

//	public static int kka23() {
	public int kka23() {
		kk23 = 2;
		return 1;
	}

	public String exceptions() {
		String result = "";
		String v = null;
		try {
			try {
				result += "before";
				v.length();
				result += "after";
			} catch (NullPointerException e) {
				result += "catch";
				throw new RuntimeException();
			} finally {
				result += "finally";
				throw new Exception();
			}
		} catch (Exception e) {
			result += "done";
		}

		return result;
	}

	public String exceptions2() {
		String result = "";
		int kk22;
		try {
			int kk23 = 1 / 0;
//		} catch (Exception e) {
		} finally {
			kk22 = 1_000_002;
			System.out.println(kk22);
		}

		kk22 = 1_000_001;
		System.out.println(kk22);
		return result;

	}

	public static void main(String[] args) {

		kk23 kk24 = new kk23();
		kk24.kka23();
		System.out.println(kk24.exceptions());

		try {
			System.out.println(kk24.exceptions2());
		} catch (Exception e) {
			System.out.println(" --- error 22 ");
		}

		//
		//
		//
		//
		//

		// pg 52
		int kk22 = 011;
		System.out.println(kk22);
		kk22 = 0xa;
		System.out.println(kk22);
		kk22 = 0b11;
		System.out.println(kk22);

		kk22 = 1_000_000;
		System.out.println(kk22);

		System.out.println(kk24);

		int kk25 = 0;
		while (kk25++ < 22) {
		}
		System.out.println(kk25);

//		kk23=3;
//		int kk23b= kka23();
//		System.out.println(kk23);
//		System.out.println(kk23b);

	}
}
