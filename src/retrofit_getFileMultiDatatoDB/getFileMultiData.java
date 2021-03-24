package retrofit_getFileMultiDatatoDB;

import java.util.List;

import Retrofit.application.Data;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class getFileMultiData {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Retrofit retrofit = new Retrofit.Builder()
				.baseUrl("http://localhost/retrofit/")
				.addConverterFactory(GsonConverterFactory.create())
				.build();
		
		getFileMultiDataInterface getMultidata = retrofit.create(getFileMultiDataInterface.class);
		
		Call<getFileMultiDatatoDBMODEL> call = getMultidata.getUserMultiList();
		
		call.enqueue(new Callback<getFileMultiDatatoDBMODEL>() {

			@Override
			public void onFailure(Call<getFileMultiDatatoDBMODEL> call, Throwable t) {
				// TODO Auto-generated method stub
				System.out.println("Failed" + t.getMessage());
				
			}

			@Override
			public void onResponse(Call<getFileMultiDatatoDBMODEL> call, Response<getFileMultiDatatoDBMODEL> response) {
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
				  setFileDatatoDBInterface getMultidata = retrofit.create(setFileDatatoDBInterface.class);
				  
				  Call<ResponseBody> Setcall = getMultidata.insertdata(email,password);
				  
				  Setcall.enqueue(new Callback<ResponseBody>() {

					@Override
					public void onFailure(Call<ResponseBody> call, Throwable t) {
						// TODO Auto-generated method stub
						System.out.println("Failed");
					}

					@Override
					public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
						// TODO Auto-generated method stub
						System.out.println("Success to add \t Email: " + userlist.getEmail() + " Password: " + userlist.getPassword() );
						
					}
					  
				  });
				  
				  } //end of foreach
				 

			}
			
		});
	}

}
