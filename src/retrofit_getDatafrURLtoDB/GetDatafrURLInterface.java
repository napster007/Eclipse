package retrofit_getDatafrURLtoDB;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetDatafrURLInterface {
	
	@GET("v1/74f887f5")
	Call<GetDatafbURLtoDBMODEL> getDataList();

}
