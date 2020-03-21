package manu.java.cert;

import java.io.*;
import java.util.*;

public class Needle {
	public static int count(String needle, InputStream haystack) throws Exception {
//    	BufferedReader reader = new BufferedReader(haystack);

//    	InputStream inputstream = new FileInputStream("c:\\data\\input-text.txt");

//    	reader.re

		int count = 0;
		String str = "";
		String res2 = "";
		ArrayList<String> res = new ArrayList<String>();
		BufferedInputStream reader = new BufferedInputStream(haystack);
		int data = haystack.read();
		while (data != -1) {
			if (data == 10) {
				res.add(str);
			}
			str += (char) data;
			data = haystack.read();
		}
		for (String item : res) {
			if (item.contains("xxx")) {
				count++;
				res2+=item+" , ";
//				res2.add(item);
			}
		}
		System.out.print( count + " ( " + res2 + " ) ");
		return 0;
	}

	public static void main(String[] args) throws Exception {
		String inMessage = "Hello, there!\nHow are you today?\nYes, you over there.";

		try (InputStream inStream = new ByteArrayInputStream(inMessage.getBytes())) {
			System.out.println(Needle.count("there", inStream));
		}
	}
}