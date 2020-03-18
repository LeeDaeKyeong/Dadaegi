package vo;

public class Stock {

	private int stock_index;
	private String product_code;
	private String inout_date;
	private int inout_quantity;
	private String stock_status;
	private String product_image;
	private String product_name;
	private int product_price;

	public String getProduct_image() {
		return product_image;
	}

	public void setProduct_image(String product_image) {
		this.product_image = product_image;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public int getProduct_price() {
		return product_price;
	}

	public void setProduct_price(int product_price) {
		this.product_price = product_price;
	}

	public int getStock_index() {
		return stock_index;
	}

	public void setStock_index(int stock_index) {
		this.stock_index = stock_index;
	}

	public String getProduct_code() {
		return product_code;
	}

	public void setProduct_code(String product_code) {
		this.product_code = product_code;
	}

	public String getInout_date() {
		return inout_date;
	}

	public void setInout_date(String inout_date) {
		this.inout_date = inout_date;
	}

	public int getInout_quantity() {
		return inout_quantity;
	}

	public void setInout_quantity(int inout_quantity) {
		this.inout_quantity = inout_quantity;
	}

	public String getStock_status() {
		return stock_status;
	}

	public void setStock_status(String stock_status) {
		this.stock_status = stock_status;
	}
}
