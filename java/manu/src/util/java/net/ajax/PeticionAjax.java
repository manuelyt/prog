package util.java.net.ajax;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class PeticionAjax {

	public PeticionAjax() {
		
		int valorDado = (int)Math.floor(Math.random()*899999+100001);
		
		
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
                byte[] input = jsonInputString.getBytes("utf-8"); 
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
