package vo;

public class Reservation {
	private int reservation_index;
	private int reservation_num;
	private String member_id;
	private String member_name;
	private String member_phone;
	private String member_email;
	private String member_birth;
	private String member_gender;
	private String demand;
	private int coupon;
	private int product_quantity;
	private int total_price;
	private String reservation_date;
	private String payment_date;
	private String payment_way;
	private String payment_status;
	private String reservation_status;
	private String confirm;
	private String product_name;

	public Reservation(String payment_date, int reservation_num, String product_name, String reservation_date,
			String payment_status, String reservation_status, String confirm, int product_quantity, int total_price,
			int coupon, String payment_way, String member_id, String demand) {
		// TODO Auto-generated constructor stub
		this.payment_date = payment_date;
		this.reservation_num = reservation_num;
		this.product_name = product_name;
		this.payment_date = payment_date;
		this.reservation_date = reservation_date;
		this.payment_status = payment_status;
		this.reservation_status = reservation_status;
		this.confirm = confirm;
		this.product_quantity = product_quantity;
		this.total_price = total_price;
		this.coupon = coupon;
		this.payment_way = payment_way;
		this.member_id = member_id;
		this.demand = demand;
	}

	public String getMember_gender() {
		return member_gender;
	}

	public void setMember_gender(String member_gender) {
		this.member_gender = member_gender;
	}

	public Reservation() {
		// TODO Auto-generated constructor stub
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public String getMember_name() {
		return member_name;
	}

	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}

	public String getMember_phone() {
		return member_phone;
	}

	public void setMember_phone(String member_phone) {
		this.member_phone = member_phone;
	}

	public String getMember_email() {
		return member_email;
	}

	public void setMember_email(String member_email) {
		this.member_email = member_email;
	}

	public String getMember_birth() {
		return member_birth;
	}

	public void setMember_birth(String member_birth) {
		this.member_birth = member_birth;
	}

	public String getDemand() {
		return demand;
	}

	public void setDemand(String demand) {
		this.demand = demand;
	}

	public int getCoupon() {
		return coupon;
	}

	public void setCoupon(int coupon) {
		this.coupon = coupon;
	}

	public int getProduct_quantity() {
		return product_quantity;
	}

	public void setProduct_quantity(int product_quantity) {
		this.product_quantity = product_quantity;
	}

	public int getReservation_index() {
		return reservation_index;
	}

	public void setReservation_index(int reservation_index) {
		this.reservation_index = reservation_index;
	}

	public int getReservation_num() {
		return reservation_num;
	}

	public void setReservation_num(int reservation_num) {
		this.reservation_num = reservation_num;
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

	public String getReservation_date() {
		return reservation_date;
	}

	public void setReservation_date(String reservation_date) {
		this.reservation_date = reservation_date;
	}

	public String getPayment_date() {
		return payment_date;
	}

	public void setPayment_date(String payment_date) {
		this.payment_date = payment_date;
	}

	public String getPayment_way() {
		return payment_way;
	}

	public void setPayment_way(String payment_way) {
		this.payment_way = payment_way;
	}

	public String getPayment_status() {
		return payment_status;
	}

	public void setPayment_status(String payment_status) {
		this.payment_status = payment_status;
	}

	public String getReservation_status() {
		return reservation_status;
	}

	public void setReservation_status(String reservation_status) {
		this.reservation_status = reservation_status;
	}

	public String getConfirm() {
		return confirm;
	}

	public void setConfirm(String confirm) {
		this.confirm = confirm;
	}
}