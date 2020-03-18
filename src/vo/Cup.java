package vo;

public class Cup {
	
	private int cup_index;
	private String product_code;
	private String product_name;
	private int product_price;
	private String product_image;
	private String product_content;
	private String product_date;
	private String product_status;
	private int product_quantity;
	

	public Cup(int cup_index, String product_code, String product_name, int product_price, String product_image, String product_content,
			String product_date,String product_status,int product_quantity) {
		// TODO Auto-generated constructor stub
		super();
		this.cup_index = cup_index;
		this.product_code = product_code;
		this.product_name = product_name;
		this.product_price = product_price;
		this.product_image = product_image;
		this.product_content = product_content;
		this.product_date = product_date;
		this.product_status = product_status;
		this.product_quantity = product_quantity;
	}
	
	public Cup(int cup_index, String product_code, String product_name, int product_price, String product_image, String product_content, String product_date,
			String product_status) {
		// TODO Auto-generated constructor stub
		super();
		this.cup_index = cup_index;
		this.product_code = product_code;
		this.product_name = product_name;
		this.product_price = product_price;
		this.product_image = product_image;
		this.product_content = product_content;
		this.product_date = product_date;
		this.product_status = product_status;
	}

	public int getCup_index() {
		return cup_index;
	}
	public void setCup_index(int cup_index) {
		this.cup_index = cup_index;
	}
	public String getProduct_code() {
		return product_code;
	}
	public void setProduct_code(String product_code) {
		this.product_code = product_code;
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
	public String getProduct_image() {
		return product_image;
	}
	public void setProduct_image(String product_image) {
		this.product_image = product_image;
	}
	public String getProduct_content() {
		return product_content;
	}
	public void setProduct_content(String product_content) {
		this.product_content = product_content;
	}
	public String getProduct_date() {
		return product_date;
	}
	public void setProduct_date(String product_date) {
		this.product_date = product_date;
	}
	public String getProduct_status() {
		return product_status;
	}
	public void setProduct_status(String product_status) {
		this.product_status = product_status;
	}

	public int getProduct_quantity() {
		return product_quantity;
	}

	public void setProduct_quantity(int product_quantity) {
		this.product_quantity = product_quantity;
	}
	

}
