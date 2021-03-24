package nestedJSON;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ProductResponse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://localhost/retrofit/")
                .addConverterFactory(GsonConverterFactory.create())//Use Gson
                .build();

        //Use the retrofit instance to create the method body of JsonPlaceHolderApi Interface
        ProductAPI productAPI = retrofit.create(ProductAPI.class);
        Call<ProductDataModel> call = productAPI.getProdcutData();
        
        call.enqueue(new Callback<ProductDataModel>() {

			@Override
			public void onFailure(Call<ProductDataModel> call, Throwable t) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onResponse(Call<ProductDataModel> call, Response<ProductDataModel> response) {
				// TODO Auto-generated method stub
				
				if(response.code() != 200) {
					System.out.println("Connection Error");
				}
				
				if(response.body().getName() != null) {
					String productData = "";
					
					productData +="Product ID: " + response.body().getProductId() + "\n" ;
					productData +="Name: " + response.body().getName() + "\n" ;
					productData +="Price: " + response.body().getPrice() + "\n" ;
					productData +="Attributes: \n" ;
					productData +="\t Color: " + response.body().getProductAttributes().getColor() + "\n" ;
					productData +="\t Size: " + response.body().getProductAttributes().getSize() + "\n" ;
					productData +="\t Type: " + response.body().getProductAttributes().getType() + "\n" ;
					productData +="\t Ounces: " + response.body().getProductAttributes().getOunces() + "\n" ;
					
					
					System.out.println("Product Data \n" + productData);
				}
				
			}
        	
        	
        });
	}

}
