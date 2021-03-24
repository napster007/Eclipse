package retrofit_Query;

import java.util.List;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;




public class UserViewer {
	
	
		
		private static final String BASE_URL="http://localhost/retrofit/";
	    private static Retrofit retrofit;
	 
	    public static void viewuserbyId(int id){
	        retrofit=new Retrofit.Builder()
	        		.baseUrl(BASE_URL)
	        		.addConverterFactory(GsonConverterFactory.create())
	        		.build();
	        
	        DataQueryAPI dataqueryAPI = retrofit.create(DataQueryAPI.class);
	        Call<List<DataModelQuery>> call = dataqueryAPI.viewUserbyId(id);
	        
	        call.enqueue(new Callback<List<DataModelQuery>>() {

				@Override
				public void onResponse(Call<List<DataModelQuery>> call, Response<List<DataModelQuery>> response) {
					// TODO Auto-generated method stub
					System.out.println("Success");

					List<DataModelQuery> posts =response.body();
				
					for (DataModelQuery post: posts){
						String Content;
						Content = "ID: " + post.getId()+"\n";
						Content += "Email: " + post.getEmail()+"\n";
						Content += "Password: " + post.getPassword()+"\n";
						
						
						
						System.out.println("Data Retrieved# " +"\n"+ Content );
						
					}
				}

				@Override
				public void onFailure(Call<List<DataModelQuery>> call, Throwable t) {
					// TODO Auto-generated method stub
					System.out.println("Failed");
					t.printStackTrace();
			
				}
	        	
	        });
		
	}
	    

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		viewuserbyId(2);
	}

}
