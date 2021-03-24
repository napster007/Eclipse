package LoggingInterceptor;

import retrofit2.Call;
import retrofit2.http.GET;

public interface LogAPI {
	
	@GET("posts/5")
	Call<LogDataModel> getLog();

}
