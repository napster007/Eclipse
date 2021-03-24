package Retrofit.application;



import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.json.simple.JSONObject;

import com.google.gson.JsonArray;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ReqresClient {
	private static Retrofit retrofit;
	private static FileWriter file;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		retrofit = new Retrofit.Builder()
				.baseUrl("https://reqres.in/")
				.addConverterFactory(GsonConverterFactory.create())
				.build();
		
		getUserLists();

	}

	private static void getUserLists() {
		// TODO Auto-generated method stub
		JSONObject obj = new JSONObject();
		ReqresAPI reqresApi = retrofit.create(ReqresAPI.class);
		
		Call<ReqResMainModel> call = reqresApi.getUserList();
		
		
		call.enqueue(new Callback<ReqResMainModel>() {

			@Override
			public void onFailure(Call<ReqResMainModel> call, Throwable t) {
				// TODO Auto-generated method stub
				System.out.println("Error:" + t);
			}

			@Override
			public void onResponse(Call<ReqResMainModel> call, Response<ReqResMainModel> response) {
				// TODO Auto-generated method stub
				if(response.code() != 200) {
					System.out.println("Connection Error");
				}
				
				ReqResMainModel users = response.body();
				
				
				String usersList = "";
				
				usersList += "Page: " + users.getPage() + "\n";
				usersList += "Per Page: " + users.getPer_page() + "\n";
				usersList += "Total: " + users.getTotal() + "\n";
				usersList += "Total Pages: " + users.getTotal_pages() + "\n";
				
				obj.put("page", users.getPage());
		        obj.put("method", new Exception().getStackTrace()[0].getMethodName()); // geting the function used
		        obj.put("total", users.getTotal() );
		        obj.put("total_pages", users.getTotal_pages());
		 
		        JsonArray content = new JsonArray();
		        
				
				List<Data> user_array= response.body().getData();
				//Data user_array= response.body().getData();
				 
				 for(Data userlist: user_array) {
					 usersList += "=========================================== \n";
					 usersList += "Id: " + userlist.getId() + "\n";
					 usersList += "Email: " + userlist.getEmail() + "\n";
					 usersList += "First Name: " + userlist.getFirst_name() + "\n";
					 usersList += "Last NAme: " + userlist.getLast_name() + "\n";
					 usersList += "Avatar: " + userlist.getAvatar() + "\n";
					 
					 // adding to the JSON Array
					 
					 	content.add("id:"+userlist.getId());
				        content.add("email:"+userlist.getEmail());
				        content.add("first_name:"+userlist.getFirst_name());
				        content.add("last_name:"+userlist.getLast_name());
				        content.add("avatar:"+userlist.getAvatar());
				        obj.put("response", content);
				        
				 }
				 
				
				System.out.print(usersList);
				System.out.println("=========================================== ");
				
				try {
					 
		            // Constructs a FileWriter given a file name, using the platform's default charset
		            file = new FileWriter("C:\\Users\\TLCInc\\Documents\\toJSON.txt"); ///path to document
		            file.write(obj.toJSONString()); // convert to string
		            Loggging("Successfully Copied JSON Object to File...");
		            Loggging("JSON Object: " + obj);
		 
		        } catch (IOException e) {
		            e.printStackTrace();
		 
		        } finally {
		 
		            try {
		                file.flush();
		                file.close();
		            } catch (IOException e) {
		                // TODO Auto-generated catch block
		                e.printStackTrace();
		            }
		        }
			}
			
		});
	}
	
	static public void Loggging(String str) {
        System.out.println(str);
    }

}
