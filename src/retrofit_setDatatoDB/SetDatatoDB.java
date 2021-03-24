package retrofit_setDatatoDB;


import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class SetDatatoDB {

	private static final String BASE_URL="http://localhost/retrofit/";
    
    private static Retrofit retrofit;
 
    public static void insertData(String email, String password){
        retrofit=new Retrofit.Builder()
        		.baseUrl(BASE_URL)
        		.addConverterFactory(GsonConverterFactory.create())
        		.build();
        
        SetDatatoDBAPI setdataTodbAPI = retrofit.create(SetDatatoDBAPI.class);
        Call<ResponseBody> call = setdataTodbAPI.insertdata(email,password);
        call.enqueue(new Callback<ResponseBody>() {

			@Override
			public void onResponse(Call<ResponseBody> call, retrofit2.Response<ResponseBody> response) {
				// TODO Auto-generated method stub
				System.out.println("Success");
			}

			@Override
			public void onFailure(Call<ResponseBody> call, Throwable t) {
				// TODO Auto-generated method stub
				System.out.println("Failed");
			}
        	
        });
    }
    
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		insertData("nappykun@yahoo.com","123456789");
	}

}
