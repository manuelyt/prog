package util.java.net.ajax;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Properties;

import org.springframework.data.util.Pair;

import com.google.gson.Gson;



import org.json.JSONObject;
import org.json.XML;
 

public class PeticionAjax {

	public PeticionAjax() {



/*		
		
		String jsonInputString = "{"+
				"action: 'request_wait'," +
				"UUID: " + valorDado + ","+
				"reqjson: {"+
					"regimenData: ["+
						"{suid:10 , vol:200},"+
						"{suid:20 , vol:50},"+
						"{suid:30 , vol:120 , unit:13},"+
						"{suid:40 , vol:1 , unit:92}"+
						"],"+
					"otherData: {"+
						"forceShl:28"+
						"}"+
					"}"+
				"}";
		
		*/

		int valorDado = (int) Math.floor(Math.random() * 899999 + 100001);

		ArrayList<Key> json = new ArrayList<Key>();

		Key<String, String> kk1 = new Key<String, String>("action", "request_wait");
		json.add(kk1);
		Key<String, Integer> kk2 = new Key<String, Integer>("UUID", valorDado);
		json.add(kk2);

		ArrayList<Key> kk95 = new ArrayList<Key>();

		ArrayList<Key> kk7 = new ArrayList<Key>();

		Key<String, Integer> kk5 = new Key<String, Integer>("suid", 10);
		kk7.add(kk5);
		Key<String, Integer> kk51 = new Key<String, Integer>("vol", 200);
		kk7.add(kk51);

		ArrayList<ArrayList> kk6 = new ArrayList<ArrayList>();

		kk6.add(kk7);

		ArrayList<Key> kk7b = new ArrayList<Key>();

		Key<String, Integer> kk5b = new Key<String, Integer>("suid", 20);
		kk7.add(kk5b);
		Key<String, Integer> kk51b = new Key<String, Integer>("vol", 50);
		kk7.add(kk51b);

		kk6.add(kk7b);

		ArrayList<Key> kk7c = new ArrayList<Key>();

		Key<String, Integer> kk5c = new Key<String, Integer>("suid", 30);
		kk7.add(kk5c);
		Key<String, Integer> kk51c = new Key<String, Integer>("vol", 120);
		kk7.add(kk51c);
		Key<String, Integer> kk52c = new Key<String, Integer>("unit", 13);
		kk7.add(kk52c);

		kk6.add(kk7c);
		ArrayList<Key> kk7d = new ArrayList<Key>();

		Key<String, Integer> kk5d = new Key<String, Integer>("suid", 40);
		kk7.add(kk5d);
		Key<String, Integer> kk51d = new Key<String, Integer>("vol", 1);
		kk7.add(kk51d);
		Key<String, Integer> kk52d = new Key<String, Integer>("unit", 92);
		kk7.add(kk52d);

		kk6.add(kk7d);

		Key<String, ArrayList> kk4 = new Key<String, ArrayList>("regimenData", kk6);

		kk95.add(kk4);

//		ArrayList<Key> kk90 = new ArrayList<Key>();

		ArrayList<Key> kk92 = new ArrayList<Key>();

		Key<String, Integer> kk93 = new Key<String, Integer>("forceShl", 28);
		kk92.add(kk93);

		Key<String, ArrayList> kk91 = new Key<String, ArrayList>("otherData", kk92);

		// kk90.add(kk91);

		kk95.add(kk91);

		Key<String, ArrayList> kk94 = new Key<String, ArrayList>("reqjson", kk95);

		json.add(kk94);

//		String jsonInputString = new Gson().toJson(json);
		
//		
//		Request kk99 = new Request();
//		
//		kk99.setUUID(valorDado);
//
//		String jsonInputString = new Gson().toJson(kk99);



//
//		String req = " { " 
//				+   "  action: request_wait,"
//				+   "  UUID: 348676,"
//				+   "  reqjson: {"
//				+   "  regimenData: ["
//				+   "          {"
//				+   "              suid: 10,"
//				+   "              vol: 200"
//				+   "          },"
//				+   "          {"
//				+   "              suid: 20,"
//				+   "              vol: 50"
//				+   "          },"
//				+   "          {"
//				+   "              suid: 30,"
//				+   "              unit: 13,"
//				+   "              vol: 120"
//				+   "          },"
//				+   "          {"
//				+   "              suid: 40,"
//				+   "              unit: 13,"
//				+   "              vol: 120"
//				+   "          }"
//				+   "      ],"
//				+   "  otherData: {"
//				+   "  forceShl: 28"
//				+   "      }"
//				+   " } "
//				+   " } ";
//		
//		
		
//		
//		
//		String req = "{"
////				+   "    \"action\":1,"
////				+   "    \"action\":\"request_nowait\","
////				+   "    \"action\":\"pickup\","
////				+   "    \"action\":\"request\","
//				+   "    \"action\":\"request_wait\","
//				+   "    \"UUID\":348676,"
//				+   "    \"reqjson\":{"
//				+   "       \"regimenData\":["
//				+   "          {"
//				+   "             \"suid\":10,"
//				+   "             \"vol\":200"
//				+   "          },"
//				+   "          {"
//				+   "             \"suid\":20,"
//				+   "             \"vol\":50"
//				+   "          },"
//				+   "          {"
//				+   "             \"suid\":30,"
//				+   "             \"unit\":13,"
//				+   "             \"vol\":120"
//				+   "          },"
//				+   "          {"
//				+   "             \"suid\":40,"
//				+   "             \"unit\":13,"
//				+   "             \"vol\":120"
//				+   "          }"
//				+   "       ],"
//				+   "       \"otherData\":{"
//				+   "          \"forceShl\":28"
//				+   "       }"
//				+   "    }"
//				+   " }";
//		
//		
		
		
		
		
		
		


//
//		String req = " { " 
//				+   "  action: request_wait"
//				+   " } ";


//		String req = " { " 
//				+   "  action: 1"
//				+   " } ";
//		

//
//		String req = " { " 
//				+   "  \"action\": 'request_wait'"
//				+   " } ";
		

		String req = "{action:}" ; 
//		String req = "{\"action\":'request_wait'}" ; 
//		String req = " { \"action\" : 'request_wait' } " ; 

//		String req = " { " 
//				+   "  \"action\": 1"
//				+   " } ";
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

//
//		try {
//
//		    JSONObject jsonobj = new JSONObject(req);
//			
//		}
//		catch(Exception e) {
//			e.printStackTrace();
//		}
//		

		
		
		
//
//		try {
//			final URL url = new URL("http://localhost:50080/eccif/");
//			final URLConnection urlConnection = url.openConnection();
//			urlConnection.setDoOutput(true);
//			urlConnection.setRequestProperty("Content-Type", "application/json; charset=utf-8");
//			urlConnection.connect();
//			final OutputStream outputStream = urlConnection.getOutputStream();
//			outputStream.write(("{\"fNamn\": \"" + stringData + "\"}").getBytes("UTF-8"));
//			outputStream.flush();
//			final InputStream inputStream = urlConnection.getInputStream();
//			
//			
//		}
//		catch(Exception e) {
//			e.printStackTrace();
//		}
//		

		try {
			// URL of the server endpoint
			URL url = new URL("http://localhost:50080/eccif/");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();

			// Set up the connection properties
			conn.setRequestMethod("POST"); // or "GET"
			conn.setRequestProperty("Content-Type", "application/json");
			conn.setDoOutput(true);

			// Write request body (if needed)
//            String jsonInputString = "{\"key\": \"value\"}"; 
			try (OutputStream os = conn.getOutputStream()) {
				byte[] input = req.getBytes("utf-8");
				os.write(input, 0, input.length);
			}

			// Get the response
			int responseCode = conn.getResponseCode();
			System.out.println("Response Code: " + responseCode);
			try (BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"))) {
				StringBuilder response = new StringBuilder();
				String responseLine;
				while ((responseLine = br.readLine()) != null) {
					response.append(responseLine.trim());
				}
				System.out.println("Response: " + response.toString());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		PeticionAjax kk = new PeticionAjax();

	}

}
