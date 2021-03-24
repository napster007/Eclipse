package retrofit_getFileDataSendtoDB;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetFiledatatoDBInterface {
	
	@GET("sampledata.json")
	Call<GetFiledatatoDBMODEL> getUserData();
	
	
	
}
