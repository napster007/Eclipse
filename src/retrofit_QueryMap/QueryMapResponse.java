package retrofit_QueryMap;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;



public class QueryMapResponse {
	
	public static void getUserbyEmail(String email) {
		
		////Mpaing for the email
		Map<String, String> options = new HashMap<String,String>();
		options.put("email", email);
		Gson gson = new GsonBuilder()
		        .setLenient()
		        .create();
	    Retrofit retrofit =  new Retrofit.Builder()
	    		.baseUrl("http://localhost/retrofit/")
	    		.addConverterFactory(GsonConverterFactory.create(gson))
	    		.build();
	    
	    QueryMapAPI querymapAPI = retrofit.create(QueryMapAPI.class);
        Call<List<QueryMapModel>> call = querymapAPI.getUserByEmail(options);
        
        call.enqueue(new Callback<List<QueryMapModel>>() {

        	@Override
			public void onResponse(Call<List<QueryMapModel>> call, Response<List<QueryMapModel>> response) {
				// TODO Auto-generated method stub
        		
        		if(response.code() != 200) {
        			System.out.println("Error Connection");
        		}
        		//System.out.println("Success");

				List<QueryMapModel> posts =response.body();
				
				for (QueryMapModel post: posts){
					String Content;
					if(post.getEmail() == null && post.getPassword()== null) {
						System.out.println("No User Found" );
						
					}else {
						Content = "ID: " + post.getId()+"\n";
						Content += "Email: " + post.getEmail()+"\n";
						Content += "Password: " + post.getPassword()+"\n";
						
						
						
						System.out.println("Data Retrieved " +"\n"+ Content );
					}
					
					
				}
			}
        	
        	@Override
			public void onFailure(Call<List<QueryMapModel>> call, Throwable t) {
				// TODO Auto-generated method stub
        		System.out.println("Failed");
				t.printStackTrace();
			}

			
        	
        });
	   
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		getUserbyEmail("nappykun@yahoo.com");
	}

}
