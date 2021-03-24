package retrofit_Query;

import java.util.List;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface DataQueryAPI {
	
	@GET("viewUser.php")
	Call<List<DataModelQuery>> viewUserbyId( @Query("id")int id);
	
	
	

}
