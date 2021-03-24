package retrofit_getDatafrURLtoDB;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class GetdatafrURL {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Retrofit retrofit = new Retrofit.Builder()
				.baseUrl("https://api.mocki.io/")
				.addConverterFactory(GsonConverterFactory.create())
				.build();
		
		GetDatafrURLInterface getdatafrURL = retrofit.create(GetDatafrURLInterface.class);
		
		Call<GetDatafbURLtoDBMODEL> call = getdatafrURL.getDataList();
		
		call.enqueue(new Callback<GetDatafbURLtoDBMODEL>() {

			@Override
			public void onFailure(Call<GetDatafbURLtoDBMODEL> call, Throwable t) {
				// TODO Auto-generated method stub
				System.out.println("Failed");
			}

			@Override
			public void onResponse(Call<GetDatafbURLtoDBMODEL> call, Response<GetDatafbURLtoDBMODEL> response) {
				// TODO Auto-generated method stub
				System.out.println("Success");
				
				List<Users> retri = response.body().getUsers();
				 
				  for(Users userlist : retri) { 
					 
					  String Udatas = "";
				  Udatas += "Email:"+ userlist.getEmail(); 
				  Udatas += "Password:"+ userlist.getPassword();
				  
				  System.out.println(Udatas);
				  //////inserting to db
				  String email = userlist.getEmail();
				  String password = userlist.getPassword(); 
				  
				  Retrofit retrofit = new Retrofit.Builder()
							.baseUrl("http://localhost/retrofit/")
							.addConverterFactory(GsonConverterFactory.create())
							.build();
					
					GetDatafrURLInterface getdatafrURL = retrofit.create(GetDatafrURLInterface.class);
				  
				  SetDataFromUrltoDB setMultidatafrURLtoDB = retrofit.create(SetDataFromUrltoDB.class);
				  
				  Call<ResponseBody> Setcall = setMultidatafrURLtoDB.insertUserdata(email,password);
				  
				  Setcall.enqueue(new Callback<ResponseBody>() {

					@Override
					public void onFailure(Call<ResponseBody> call, Throwable t) {
						// TODO Auto-generated method stub
						System.out.println("Failed");
					}

					@Override
					public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
						// TODO Auto-generated method stub
						System.out.println("Ready to insert");
					}
					  
				  });
				  }
			}
			
		});

	}

}
