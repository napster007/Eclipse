package retrofit_getData;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class DataResponse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://localhost/retrofit/") //Set the Root URL
                .addConverterFactory(GsonConverterFactory.create())
                .build(); //Finally building the adapter
		
		getDataInterface getdataInterface = retrofit.create(getDataInterface.class);
		
		Call<DataModel> call = getdataInterface.getData();
		
		call.enqueue(new Callback<DataModel>(){

			@Override
			public void onResponse(Call<DataModel> call, Response<DataModel> response) {
				// TODO Auto-generated method stub
				
				if(response.code() != 200) {
					System.out.println("Error Connection");
				}
				String jsony="";
				jsony +=" ID:" + response.body().getId() +
						" \n User ID: " + response.body().getUserId() +
						" \n Title: " + response.body().getTitle()+
						" \n Author: " + response.body().getAuthor();
				
				System.out.println("Data Retived: \n" + jsony);
			}

			@Override
			public void onFailure(Call<DataModel> call, Throwable t) {
				// TODO Auto-generated method stub
				
			}
			
			
		});
	}

}
