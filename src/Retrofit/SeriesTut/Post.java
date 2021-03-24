package Retrofit.SeriesTut;

public class Post {
	private int id;
	private int userId;
	private String title;
	private String body;
	
	///Constructor
	public Post(int userId, String title, String body) {
		super();
		this.userId = userId;
		this.title = title;
		this.body = body;
	}
	
	///Getters
	public int getId() {
		return id;
	}
	
	public int getUserId() {
		return userId;
	}
	public String getTitle() {
		return title;
	}
	public String getBody() {
		return body;
	}
	
	

}
