package manu.java.cert;

import java.time.LocalDate;
import java.time.Month;
import java.util.Calendar;

public class _c {
	private static int $;

	public static void main(String[] main) {
		// 1
		String a_b;
		System.out.println($);
//System.out.print(a_b);

		// 2
		String s1 = "Java";
		String s2 = "Java";
		StringBuilder sb1 = new StringBuilder();
		sb1.append("Ja").append("va");
		System.out.println(s1 == s2);
		System.out.println(s1.equals(s2));
		System.out.println(sb1.toString() == s1);
		System.out.println(sb1.toString().equals(s1));

		
		// 8
		System.out.println(LocalDate.of(2015, Calendar.APRIL, 1));
		System.out.println(LocalDate.of(2015, Month.APRIL, 1));
		System.out.println(LocalDate.of(2015, 3, 1));
		System.out.println(LocalDate.of(2015, 4, 1));
//		System.out.println(new LocalDate(2015, 3, 1));
//		System.out.println(new LocalDate(2015, 4, 1));

	}
}