package retrofit_tut.retrofit;



public class DataModel {

	//This model class will be thew template for the data that we are going to parse
	
	private int userId;
	private int id;
	private String title; 
	private String body;
	
	private boolean completed;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public boolean isCompleted() {
		return completed;
	}
	public void setCompleted(boolean completed) {
		this.completed = completed;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	} 
	
	
	
}
