package vo;

public class Coupon {

	private String member_id;
	private String member_name;
	private int coupon_price;
	private String coupon_date;
	private int order_num;
	private int reservation_num;
	private String coupon_content;
	private int coupon_index;
	private int total_price;
	private String inout_coupon;

	public String getInout_coupon() {
		return inout_coupon;
	}

	public void setInout_coupon(String inout_coupon) {
		this.inout_coupon = inout_coupon;
	}

	public int getTotal_price() {
		return total_price;
	}

	public void setTotal_price(int total_price) {
		this.total_price = total_price;
	}

	public int getCoupon_index() {
		return coupon_index;
	}

	public void setCoupon_index(int coupon_index) {
		this.coupon_index = coupon_index;
	}

	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}

	public String getMember_name() {
		return member_name;
	}

	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}

	public int getCoupon_price() {
		return coupon_price;
	}

	public void setCoupon_price(int coupon_price) {
		this.coupon_price = coupon_price;
	}

	public String getCoupon_date() {
		return coupon_date;
	}

	public void setCoupon_date(String string) {
		this.coupon_date = string;
	}

	public int getOrder_num() {
		return order_num;
	}

	public void setOrder_num(int order_num) {
		this.order_num = order_num;
	}

	public int getReservation_num() {
		return reservation_num;
	}

	public void setReservation_num(int reservation_num) {
		this.reservation_num = reservation_num;
	}

	public String getCoupon_content() {
		return coupon_content;
	}

	public void setCoupon_content(String coupon_content) {
		this.coupon_content = coupon_content;
	}

}
