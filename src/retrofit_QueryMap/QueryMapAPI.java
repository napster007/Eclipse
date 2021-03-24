package retrofit_QueryMap;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

public interface QueryMapAPI {
	
	@GET("query_map.php")
	Call<List<QueryMapModel>> getUserByEmail(
			@QueryMap(encoded=true) Map<String, String> options
		);
}
