package util.txt.meneame;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class FormatearMeneame {
	
	/*


fusilado de :
https://www.digitalocean.com/community/tutorials/java-httpurlconnection-example-java-http-request-get-post


	 */

	
	private static final String USER_AGENT = "Mozilla/5.0";

//	private static final String GET_URL = "https://localhost:9090/SpringMVCExample";
//	private static final String GET_URL = "https://google.com";
	private static final String GET_URL = "https://www.meneame.net/rss";

	private static final String nficheror2 = "c:\\manu\\git\\zmanu25\\ocio\\meneame\\xml-meneame.html";
	private static final String nficheror3 = "c:\\manu\\git\\zmanu25\\ocio\\meneame\\xml-meneame2.html";
	private static final String nficheror4 = "c:\\manu\\git\\zmanu25\\ocio\\meneame\\xml-meneame4.html";
	private static final String nficheror5 = "c:\\manu\\git\\zmanu25\\ocio\\meneame\\xml-meneame5.html";
//	private static final String POST_URL = "https://localhost:9090/SpringMVCExample/home";
//	private static final String POST_URL = "https://google.com";

	private static final String POST_PARAMS = "userName=Pankaj";

	public static void main(String[] args) throws IOException {
		sendGET();
		System.out.println("GET DONE");
	}

	private static void sendGET() throws IOException {
		try {
			
		

		String buf= "";
		char EOF = '\0';
		CharSequence eof2 = String.valueOf(EOF);
		

		BufferedReader br = null;

		br = new BufferedReader(new InputStreamReader(new FileInputStream(nficheror2), "utf-8"));

		FileWriter fichero = null;
		fichero = new FileWriter(nficheror2);
		PrintWriter pw = null;
		pw = new PrintWriter(fichero);
		
		BufferedWriter outx = new BufferedWriter(new FileWriter(nficheror4));
		
		
		URL obj = new URL(GET_URL);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("GET");
		con.setRequestProperty("User-Agent", USER_AGENT);
		int responseCode = con.getResponseCode();
		System.out.println("GET Response Code :: " + responseCode);
		if (responseCode == HttpURLConnection.HTTP_OK) { // success
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();
			int cont = 0;

			while ((inputLine = in.readLine()) != null) {
				cont++;
//				if(cont>1290 &&cont<1295) {
//					int kk=0;
//				}
//				else {
					
				
//				response.append(inputLine);
//				if (inputLine.equals("")) {
//					inputLine=" ";
//				}
//					if (inputLine.contains("Donald Trump van en aumen")) {
//						int kk=0;
//					int busq = inputLine.indexOf(String.valueOf(eof2));
//					while (busq == -1) {
//						inputLine=inputLine.substring(0,busq)+" "+inputLine.substring(busq+1);
//						 busq = inputLine.indexOf(String.valueOf(eof2));
//						
//					}
//					else {
				pw.println(inputLine);
				buf+=inputLine+"\n";
//				System.out.println(inputLine);
//				outx.write(inputLine+"\n");
				
				}
//			}
			in.close();

			// print result
//			System.out.println(response.toString());
		} else {
			System.out.println("GET request did not work.");
		}
		
		

//		pw.println(buf);
		
		
		pw.close();

//		int kk22 = buf.length();
		
		

//		System.out.println(" -------------------------- ");
//		System.out.println(buf.substring(kk22-200));
		
		
		
//		PrintWriter out5 = new PrintWriter(nficheror5);
//		out5.println(buf);
//		out5.close();
//		
//		
//		
//		
//		
//		
//		String item = "<item>";
//		String itemc = "</item>";
//		String chan = "</channel>";
//		String rss = "</rss>";
//		
//
//		int busq1 = buf.indexOf(item);
//		int busq2 = buf.indexOf(itemc);
//		int busq3 = buf.indexOf(rss);
//		int busq4 = buf.indexOf(chan);
//
//		
//		if (busq1>busq2) {
//			buf=buf.substring(0,busq2) + itemc;
//		}
//		
//		if (busq3==-1) {
//			buf+=rss;
//		}
//		
//		if (busq4==-1) {
//			buf+=chan;
//		}
//
//
//		BufferedReader br3 = null;
//
//		br3 = new BufferedReader(new InputStreamReader(new FileInputStream(nficheror3), "utf-8"));
//
//		FileWriter fichero3 = null;
//
//		fichero3 = new FileWriter(nficheror3);
//		PrintWriter pw3 = null;
//		pw3 = new PrintWriter(fichero3);
//
//		pw3.print(buf);
//		
//		
		
		

		}
		catch(Exception e) {
			e.printStackTrace();
//			System.out.println("GET request did not work.");

			int kk=0;
		}

	}


}