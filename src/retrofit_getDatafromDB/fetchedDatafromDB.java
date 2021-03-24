package retrofit_getDatafromDB;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class fetchedDatafromDB {
	// static List<DataModelDB> usersData;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Gson gson = new GsonBuilder()
		        .setLenient()
		        .create();
		Retrofit retrofit = new Retrofit.Builder()
				.baseUrl("http://localhost/retrofit/")
				.addConverterFactory(GsonConverterFactory.create(gson))
				.build();
		getDatafromDBApi GetDatafromdbAPI = retrofit.create(getDatafromDBApi.class);
		Call<List<DataModelDB>> call = GetDatafromdbAPI.getUsers();
		
		call.enqueue(new Callback<List<DataModelDB>>() {

			@Override
			public void onResponse(Call<List<DataModelDB>> call, Response<List<DataModelDB>> response) {
				// TODO Auto-generated method stub
				if(response.code() != 200) {
					System.out.println("Error Connection");
				}
				
				List<DataModelDB> posts =response.body();
				int i = 1;
				for (DataModelDB post: posts){
					String Content="";
					Content += "ID: " + post.getId()+"\n";
					Content += "Email: " + post.getEmail()+"\n";
					Content += "Password: " + post.getPassword()+"\n";
					
					
					
					System.out.println("Data Retrieved# "+i +"\n"+ Content );
					i++;
				}
			}

			@Override
			public void onFailure(Call<List<DataModelDB>> call, Throwable t) {
				// TODO Auto-generated method stub
				System.out.println("Something Went Wrong!: ");
				t.printStackTrace();
			}
			
		});
	}

}
