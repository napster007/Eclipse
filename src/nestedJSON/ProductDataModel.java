package nestedJSON;

public class ProductDataModel {
	
	private int productId;
	private String name;
	private double price;
	
	
	private ProductAttributes attributes ;

	public int getProductId() {
		return productId;
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}

	public ProductAttributes getProductAttributes() {
		return attributes;
	}
	
	
}
