package generate.JSONFIle;

import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONObject;
import com.google.gson.JsonArray;

public class generateJSonFile {


		// TODO Auto-generated method stub
		private static FileWriter file;
		 
	    @SuppressWarnings("unchecked")
	    public static void main(String[] args) {
	 
	        // JSON object. Key value pairs are unordered. JSONObject supports java.util.Map interface.
	        JSONObject head = new JSONObject();
	        head.put("Access Token", "Write JSON File using JAVA");
	        head.put("Method", new Exception().getStackTrace()[0].getMethodName()); // getting the function used
	        head.put("version", "1.0");
	        
	       
	      
	        JSONObject content = new JSONObject();
		    content.put("Staffphone","091515151515_");
		    content.put("contactChannelId", "5645165465");
		    head.put("content", content);
	        
	        
	        try {
	 
	            // Constructs a FileWriter given a file name, using the platform's default charset
	            file = new FileWriter("C:\\Users\\TLCInc\\Documents\\toJSON.txt"); ///path to document
	            file.write(head.toJSONString()); // convert to string
	            Loggging("Successfully Copied JSON Object to File...");
	            Loggging("JSON Object: " + head);
	 
	        } catch (IOException e) {
	            e.printStackTrace();
	 
	        } finally {
	 
	            try {
	                file.flush();
	                file.close(); // closing the file 
	            } catch (IOException e) {
	                // TODO Auto-generated catch block
	                e.printStackTrace();
	            }
	        }
	    }
	    
	    static public void Loggging(String str) {
	        System.out.println(str);
	    }
	}


