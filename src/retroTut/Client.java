package retroTut;



import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Retrofit retrofit = new Retrofit.Builder()
				.baseUrl("http://localhost/retrofit/")
				.addConverterFactory(GsonConverterFactory.create())
				.build();
		
		GetDataAPI dataqueryAPI = retrofit.create(GetDataAPI.class);
        Call<GetDataModel> call = dataqueryAPI.getData();
        
        call.enqueue(new Callback<GetDataModel>() {

			@Override
			public void onFailure(Call<GetDataModel> call, Throwable t) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onResponse(Call<GetDataModel> call, Response<GetDataModel> response) {
				// TODO Auto-generated method stub
				if(response.code() != 200) {
					System.out.println("Error Connection");
				}
				String jsony="";
				jsony +=" ID:" + response.body().getId() +
						" \n User ID: " + response.body().getUserId() +
						" \n Title: " + response.body().getTitle();
				
				System.out.println("Data Retived: \n" + jsony);
			}
        	
        });
		
	}

}
