package retrofit_getFileDataSendtoDB;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface SetFiledatatoDBInterface {
	
		@FormUrlEncoded
		@POST("setUser.php")
	    Call<ResponseBody> insertUserdata(
	            @Field("name")String name,
	            @Field("email")String email
	 
	    );

	
}
