package LoggingInterceptor;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LogResponse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Gson gson = new GsonBuilder().serializeNulls().create();
		
		HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor() ;
		loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
		
		OkHttpClient okhttp = new OkHttpClient.Builder()
				.addInterceptor(loggingInterceptor)
				.build();
		
		Retrofit retrofit = new Retrofit.Builder()
				.baseUrl("https://jsonplaceholder.typicode.com/")
				.addConverterFactory(GsonConverterFactory.create(gson))
				.client(okhttp)
				.build();
		
		LogAPI logAPI = retrofit.create(LogAPI.class);
		
		Call<LogDataModel> call = logAPI.getLog();
		call.enqueue(new Callback<LogDataModel>() {

			@Override
			public void onFailure(Call<LogDataModel> call, Throwable t) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onResponse(Call<LogDataModel> call, Response<LogDataModel> response) {
				// TODO Auto-generated method stub
				if(response.code() !=200) {
					System.out.println("Error in Connection");
					
				}
				
				String value= "";
				value+="ID: " + response.body().getId();
				
				System.out.println("Data: \n " + value);
			}
			
		});
	}

}
