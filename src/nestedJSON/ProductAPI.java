package nestedJSON;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ProductAPI {
	
	@GET("nestedJSON.json")
	Call<ProductDataModel> getProdcutData();
	

}
