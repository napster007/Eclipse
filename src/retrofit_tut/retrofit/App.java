package retrofit_tut.retrofit;

import java.util.List;


import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * Hello world!
 *
 */
public class App extends DataModel
{
    public static void main( String[] args )
    {
       // System.out.println( "Hello World!" );
    	OkHttpClient clients = new OkHttpClient();
		//Retrofit Builder
		Retrofit retrofit = new Retrofit.Builder()
				.client(clients)
				.baseUrl("https://jsonplaceholder.typicode.com/")
				.addConverterFactory(GsonConverterFactory.create())
				.build();
		
		//instance for Interface
		MyAPICall myAPICall = retrofit.create(MyAPICall.class);
		Call<List<DataModel>> call = myAPICall.getData();
		
		
		call.enqueue(new Callback<List<DataModel>>() {
			@Override
			public void onResponse(Call<List<DataModel>> call, Response <List<DataModel>> response) {
				// TODO Auto-generated method stub
				if(response.code() !=200) {
					System.out.println("Connection Error"+ response);
					return;
					
				}
			
				List<DataModel> posts =response.body();
				int i = 1;
				for (DataModel post: posts){
					String Content="";
					Content += "ID: " + post.getId()+"\n";
					Content += "UserID: " + post.getUserId()+"\n";
					Content += "Title: " + post.getTitle()+"\n";
					Content += "Body: " + post.getBody()+"\n";
					
					
					System.out.println("MainActivity# "+i +"\n"+ Content );
					i++;
				}
					/* String jsony = "";
						jsony = " ID=" + response.body().getId()+
								"\n UserID= " + response.body().getUserId()+
								"\n Title= " + response.body().getTitle()+
								"\n Completed= "+response.body().isCompleted();*/
						
						
				
				//Get data to text
				
				
			}
			
			@Override
			public void onFailure(Call<List<DataModel>> call, Throwable response) {
				// TODO Auto-generated method stub
				System.out.println("Error"+ response.getMessage());
			}

			
			
		});
    }
}
