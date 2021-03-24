package retrofit_getData;

import retrofit2.Call;
import retrofit2.http.GET;

public interface getDataInterface {
	
	@GET("sampledata.json")
	Call<DataModel> getData();
}
