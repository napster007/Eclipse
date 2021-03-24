package retrofit_getFileMultiDatatoDB;

import java.util.List;


import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;


public interface getFileMultiDataInterface {
	
	//@FormUrlEncoded
	@GET("sampledata.json")
	Call<getFileMultiDatatoDBMODEL> getUserMultiList();

}
