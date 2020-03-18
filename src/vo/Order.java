package vo;

public class Order {

	private int order_num;
	private String member_id;
	private String member_name;
	private String member_email;
	private String member_phone;
	private String member_birth;
	private String member_gender;

	private int total_price;
	private String order_status;
	private String order_date;
	private String payment_way;
	private int payment_date;
	private String order_way;
	private int coupon;
	private String demand;
	private String payment_status;
	private String product_name;
	private String confirm;
	private int product_quantity;

	public Order(int order_num, String member_id, int total_price, String order_status, String order_date,
			String payment_way, int payment_date, String order_way, String demand, String payment_status, int coupon,
			String confirm, String product_name, int product_quantity) {
		// TODO Auto-generated constructor stub
		this.order_num = order_num;
		this.member_id = member_id;
		this.total_price = total_price;
		this.order_status = order_status;
		this.order_date = order_date;
		this.payment_way = payment_way;
		this.payment_date = payment_date;
		this.order_way = order_way;
		this.demand = demand;
		this.payment_status = payment_status;
		this.coupon = coupon;
		this.confirm = confirm;
		this.product_name = product_name;
		this.product_quantity = product_quantity;
	}

	public String getMember_email() {
		return member_email;
	}

	public void setMember_email(String member_email) {
		this.member_email = member_email;
	}

	public String getMember_phone() {
		return member_phone;
	}

	public void setMember_phone(String member_phone) {
		this.member_phone = member_phone;
	}

	public String getMember_birth() {
		return member_birth;
	}

	public void setMember_birth(String member_birth) {
		this.member_birth = member_birth;
	}

	public String getMember_gender() {
		return member_gender;
	}

	public void setMember_gender(String member_gender) {
		this.member_gender = member_gender;
	}

	public String getMember_name() {
		return member_name;
	}

	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}

	public int getProduct_quantity() {
		return product_quantity;
	}

	public void setProduct_quantity(int product_quantity) {
		this.product_quantity = product_quantity;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public Order() {
		// TODO Auto-generated constructor stub
	}

	public int getOrder_num() {
		return order_num;
	}

	public void setOrder_num(int order_num) {
		this.order_num = order_num;
	}

	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}

	public int getTotal_price() {
		return total_price;
	}

	public void setTotal_price(int total_price) {
		this.total_price = total_price;
	}

	public String getOrder_status() {
		return order_status;
	}

	public void setOrder_status(String order_status) {
		this.order_status = order_status;
	}

	public String getOrder_date() {
		return order_date;
	}

	public void setOrder_date(String order_date) {
		this.order_date = order_date;
	}

	public String getPayment_way() {
		return payment_way;
	}

	public void setPayment_way(String payment_way) {
		this.payment_way = payment_way;
	}

	public int getPayment_date() {
		return payment_date;
	}

	public void setPayment_date(int payment_date) {
		this.payment_date = payment_date;
	}

	public String getOrder_way() {
		return order_way;
	}

	public void setOrder_way(String order_way) {
		this.order_way = order_way;
	}

	public int getCoupon() {
		return coupon;
	}

	public void setCoupon(int coupon) {
		this.coupon = coupon;
	}

	public String getDemand() {
		return demand;
	}

	public void setDemand(String demand) {
		this.demand = demand;
	}

	public String getPayment_status() {
		return payment_status;
	}

	public void setPayment_status(String payment_status) {
		this.payment_status = payment_status;
	}

	public String getConfirm() {
		return confirm;
	}

	public void setConfirm(String confirm) {
		this.confirm = confirm;
	}
}
