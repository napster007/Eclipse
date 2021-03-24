package Retrofit.SeriesTut;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Main {
	private static JsonPlaceHolderAPI jsonplaceholderAPI;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor() ;
		loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
		
		OkHttpClient okhttp = new OkHttpClient.Builder()
				.addInterceptor(new Interceptor() {

					@Override
					public okhttp3.Response intercept(Chain chain) throws IOException {
						// TODO Auto-generated method stub
						Request originalRequest = chain.request();
						Request newRequest = originalRequest.newBuilder()
								.header("Interceptor-Header","What do you like?")
								.build();
						
						return chain.proceed(newRequest);
					}
					
				})
				.addInterceptor(loggingInterceptor)
				.build();
		
		Gson gson = new GsonBuilder()
				.serializeNulls()
				.create();
		
		Retrofit retrofit = new Retrofit.Builder()
				.baseUrl("https://jsonplaceholder.typicode.com/")
				.addConverterFactory(GsonConverterFactory.create(gson))
				.client(okhttp)
				.build();
		
		jsonplaceholderAPI = retrofit.create(JsonPlaceHolderAPI.class);
		
		getPosts();
		//getComments();
		//createPost();
		//updatePost();
		//deletePost();
	}

	private static void deletePost() {
		// TODO Auto-generated method stub
		Call<Void> call = jsonplaceholderAPI.deletePost(5);
		
		call.enqueue(new Callback<Void>() {

			@Override
			public void onFailure(Call<Void> call, Throwable t) {
				// TODO Auto-generated method stub
				System.out.println("Error:"+ t.getMessage());
			}

			@Override
			public void onResponse(Call<Void> call, Response<Void> response) {
				// TODO Auto-generated method stub
				System.out.println("Code: " + response.code());
			}
			
		});
		
	}

	private static void updatePost() {
		// TODO Auto-generated method stub
		Post post = new Post(12, null,"Aloha");
		Map<String,String> headers = new HashMap();
		headers.put("Map-Header1", "Def");
		headers.put("Map-Header2", "SAMPLE");
		Call<Post> call = jsonplaceholderAPI.patchPost(headers,5, post);
		
		call.enqueue(new Callback<Post>() {

			@Override
			public void onFailure(Call<Post> call, Throwable t) {
				// TODO Auto-generated method stub
				System.out.println("Error:"+ t.getMessage());
			}

			@Override
			public void onResponse(Call<Post> call, Response<Post> response) {
				// TODO Auto-generated method stub
				if(response.code() != 200) {
					System.out.println("Error Connection");
					System.out.println("Error Code: " + response.code());
					
				}
				Post postResponse = response.body();
				String content ="";
				content += "Code: " + response.code() + "\n";
				content += "ID: " + postResponse.getId() + "\n";
				content += "User ID: " + postResponse.getUserId() + "\n";
				content += "Title: " + postResponse.getTitle() + "\n";
				content += "Body: " + postResponse.getBody() + "\n";
				
				System.out.println(content);
			}
			
		});
	}

	private static void createPost() {
		// TODO Auto-generated method stub
		Post post = new Post(77,"New Title","New Body");
		
		Map<String,String> fields = new HashMap();
		fields.put("userId", "34");
		fields.put("title", "New Title 22");
		fields.put("body", "New BOdy 22");
		
		Call<Post> call = jsonplaceholderAPI.createPost(fields);
		
		call.enqueue(new Callback<Post>() {
			
			@Override
			public void onResponse(Call<Post> call, Response<Post> response) {
				// TODO Auto-generated method stub
				if(response.code() != 201) {
					System.out.println("Error Connection");
					System.out.println("Error Code: " + response.code());
					
				}
				
				//////
				Post postResponse = response.body();
				String content ="";
				content += "Code: " + response.code() + "\n";
				content += "ID: " + postResponse.getId() + "\n";
				content += "User ID: " + postResponse.getUserId() + "\n";
				content += "Title: " + postResponse.getTitle() + "\n";
				content += "Body: " + postResponse.getBody() + "\n";
				
				System.out.println(content);
			}
			
			@Override
			public void onFailure(Call<Post> call, Throwable t) {
				// TODO Auto-generated method stub
				System.out.println("Error:" + t.getMessage());
			}

			
			
		});
		
	}

	private static void getPosts() {
		// TODO Auto-generated method stub
		
		Map<String, String> parameters = new HashMap();
		parameters.put("userId", "1");
		parameters.put("_sort", "id");
		parameters.put("_order", "desc");
		
		Call<List<Post>> call = jsonplaceholderAPI.getPosts(parameters);
		
		//Call<List<Post>> call = jsonplaceholderAPI.getPosts(new Integer[] {2,4,6},"id","desc");
		
		call.enqueue(new Callback<List<Post>>() {

			

			@Override
			public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
				// TODO Auto-generated method stub
				if(response.code() != 200) {
					System.out.println("Error Connection");
					System.out.println("Error Code: " + response.code());
					
				}
				
				List<Post> posts = response.body();
				
				for(Post post: posts) {
					String content ="";
					content += "ID: " + post.getId() + "\n";
					content += "User ID: " + post.getUserId() + "\n";
					content += "Title: " + post.getTitle() + "\n";
					content += "Body: " + post.getBody() + "\n";
					
					System.out.println(content);
				}
			}
			
			@Override
			public void onFailure(Call<List<Post>> call, Throwable t) {
				// TODO Auto-generated method stub
				System.out.println("Error: " + t.getMessage());
			}
			
		});
	}
	
	private static void getComments() {
		Call<List<Comment>> call = jsonplaceholderAPI.getComments("posts/3/comments");
		
		call.enqueue(new Callback<List<Comment>>() {

			

			@Override
			public void onResponse(Call<List<Comment>> call, Response<List<Comment>> response) {
				// TODO Auto-generated method stub
				if(response.code() != 200) {
					System.out.println("Error Connection");
					System.out.println("Error Code: " + response.code());
					
				}
				
				List<Comment> comments = response.body();
				
				for(Comment comment: comments) {
					String content ="";
					content += "Post ID: " + comment.getPostId() + "\n";
					content += "ID: " + comment.getId() + "\n";
					content += "Name: " + comment.getName() + "\n";
					content += "Email: " + comment.getEmail() + "\n";
					content += "Body: " + comment.getBody() + "\n";
					
					System.out.println(content);
				}
			}
			
			@Override
			public void onFailure(Call<List<Comment>> call, Throwable t) {
				// TODO Auto-generated method stub
				System.out.println("Error: " + t.getMessage());
			}
			
		});
	}

}
