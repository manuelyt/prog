
package util.net;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class Wget {
	
	/*


fusilado de :
https://www.digitalocean.com/community/tutorials/java-httpurlconnection-example-java-http-request-get-post


	 */

	
	private static final String USER_AGENT = "Mozilla/5.0";

//	private static final String GET_URL = "https://localhost:9090/SpringMVCExample";
//	private static final String GET_URL = "https://google.com";
	private static final String GET_URL = "https://www.meneame.net/rss";

	private static final String nficheror2 = "c:\\manu\\git\\zmanu25\\ocio\\meneame\\xml-meneame.html";
//	private static final String POST_URL = "https://localhost:9090/SpringMVCExample/home";
//	private static final String POST_URL = "https://google.com";

	private static final String POST_PARAMS = "userName=Pankaj";

	public static void main(String[] args) throws IOException {
		sendGET();
		System.out.println("GET DONE");
	}

	private static void sendGET() throws IOException {
		

		

		BufferedReader br = null;

		br = new BufferedReader(new InputStreamReader(new FileInputStream(nficheror2), "utf-8"));

		FileWriter fichero = null;

		fichero = new FileWriter(nficheror2);
		PrintWriter pw = null;
		pw = new PrintWriter(fichero);
		
		
		
		
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

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
				pw.println(inputLine);
			}
			in.close();

			// print result
//			System.out.println(response.toString());
		} else {
			System.out.println("GET request did not work.");
		}

	}


}