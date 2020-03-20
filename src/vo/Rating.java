package vo;

public class Rating {

	private String member_rating;
	private String rating_payment;
	private String rating_discount;
	private String rating_content;
	private int rating_count;

	public int getRating_count() {
		return rating_count;
	}

	public void setRating_count(int rating_count) {
		this.rating_count = rating_count;
	}

	public String getMember_rating() {
		return member_rating;
	}

	public void setMember_rating(String member_rating) {
		this.member_rating = member_rating;
	}

	public String getRating_payment() {
		return rating_payment;
	}

	public void setRating_payment(String rating_payment) {
		this.rating_payment = rating_payment;
	}

	public String getRating_discount() {
		return rating_discount;
	}

	public void setRating_discount(String rating_discount) {
		this.rating_discount = rating_discount;
	}

	public String getRating_content() {
		return rating_content;
	}

	public void setRating_content(String rating_content) {
		this.rating_content = rating_content;
	}

}
