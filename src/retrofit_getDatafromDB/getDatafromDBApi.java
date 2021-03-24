package retrofit_getDatafromDB;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface getDatafromDBApi {
	
	@GET("getUsers.php")
	Call<List<DataModelDB>> getUsers();
}
