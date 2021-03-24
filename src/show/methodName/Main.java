package show.methodName;

public class Main {
	
	
	public static void myFunction() {
		System.out.println("My Function name is: " + new Exception().getStackTrace()[0].getMethodName());
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		myFunction();
	}

}
