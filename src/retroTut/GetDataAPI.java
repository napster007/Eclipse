package retroTut;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetDataAPI {
	
	@GET("sampledata.json")
	Call<GetDataModel> getData();

}
