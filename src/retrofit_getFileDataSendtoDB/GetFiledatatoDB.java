package retrofit_getFileDataSendtoDB;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class GetFiledatatoDB {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Retrofit retrofit = new Retrofit.Builder()
				.baseUrl("http://localhost/retrofit/")
				.addConverterFactory(GsonConverterFactory.create())
				.build();
		
		GetFiledatatoDBInterface getFiledata = retrofit.create(GetFiledatatoDBInterface.class);
		
		Call<GetFiledatatoDBMODEL> call = getFiledata.getUserData();
		
		call.enqueue(new Callback<GetFiledatatoDBMODEL>(){

			@Override
			public void onFailure(Call<GetFiledatatoDBMODEL> call, Throwable t) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onResponse(Call<GetFiledatatoDBMODEL> call, Response<GetFiledatatoDBMODEL> response) {
				// TODO Auto-generated method stub
				
				String data = "Data Retrived: \n Email: " + response.body().getUemail()+
						" \n Password: " +response.body().getUpassword();
				String email = response.body().getUemail();
				String password = response.body().getUpassword();
				
				System.out.println(data);
				
				SetFiledatatoDBInterface setFiledataTodbAPI = retrofit.create(SetFiledatatoDBInterface.class);
		        Call<ResponseBody> Insertcall = setFiledataTodbAPI.insertUserdata(email,password);
		        
		        Insertcall.enqueue(new Callback<ResponseBody>() {

					@Override
					public void onFailure(Call<ResponseBody> call, Throwable t) {
						// TODO Auto-generated method stub
						System.out.println("Failed");
					}

					@Override
					public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
						// TODO Auto-generated method stub
						System.out.println("Success");
						
						
					}

					
		        	
		        });
			}
			
		});

	}

}
