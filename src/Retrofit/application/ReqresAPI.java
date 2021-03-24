package Retrofit.application;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ReqresAPI {

	@GET("api/users?page=2")
	Call<ReqResMainModel> getUserList();
}
