package vo;

import java.sql.Date;

public class QuestionBean {
	
	private int question_index;
	private String member_id;
	private String question_name;
	private String question_pass;
	private String question_subject;
	private String question_content;
	private String question_file;
	private int question_re_ref;
	private int question_re_lev;
	private int question_re_seq;
	private int question_readcount;
	private Date question_date;
	
	public int getQuestion_index() {
		return question_index;
	}
	public void setQuestion_index(int question_index) {
		this.question_index = question_index;
	}
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	public String getQuestion_name() {
		return question_name;
	}
	public void setQuestion_name(String question_name) {
		this.question_name = question_name;
	}
	public String getQuestion_pass() {
		return question_pass;
	}
	public void setQuestion_pass(String question_pass) {
		this.question_pass = question_pass;
	}
	public String getQuestion_subject() {
		return question_subject;
	}
	public void setQuestion_subject(String question_subject) {
		this.question_subject = question_subject;
	}
	public String getQuestion_content() {
		return question_content;
	}
	public void setQuestion_content(String question_content) {
		this.question_content = question_content;
	}
	public String getQuestion_file() {
		return question_file;
	}
	public void setQuestion_file(String question_file) {
		this.question_file = question_file;
	}
	public int getQuestion_re_ref() {
		return question_re_ref;
	}
	public void setQuestion_re_ref(int question_re_ref) {
		this.question_re_ref = question_re_ref;
	}
	public int getQuestion_re_lev() {
		return question_re_lev;
	}
	public void setQuestion_re_lev(int question_re_lev) {
		this.question_re_lev = question_re_lev;
	}
	public int getQuestion_re_seq() {
		return question_re_seq;
	}
	public void setQuestion_re_seq(int question_re_seq) {
		this.question_re_seq = question_re_seq;
	}
	public int getQuestion_readcount() {
		return question_readcount;
	}
	public void setQuestion_readcount(int question_readcount) {
		this.question_readcount = question_readcount;
	}
	public Date getQuestion_date() {
		return question_date;
	}
	public void setQuestion_date(Date question_date) {
		this.question_date = question_date;
	}
	
	
	


}
