package vo;

public class Note {

	private int note_index;
	private String recv_id;
	private String note_content;
	private int recv_chk;
	private String send_date;
	private String send_id;

	public String getSend_id() {
		return send_id;
	}

	public void setSend_id(String send_id) {
		this.send_id = send_id;
	}

	public Note(int note_index, String recv_id, String send_id, String note_title, String note_content,
			String send_date, String note_file) {
		// TODO Auto-generated constructor stub
		this.note_index = note_index;
		this.recv_id = recv_id;
		this.note_content = note_content;
		this.send_date = send_date;
	}

	public Note() {
		// TODO Auto-generated constructor stub
	}

	public int getNote_index() {
		return note_index;
	}

	public void setNote_index(int note_index) {
		this.note_index = note_index;
	}

	public String getRecv_id() {
		return recv_id;
	}

	public void setRecv_id(String recv_id) {
		this.recv_id = recv_id;
	}

	public String getNote_content() {
		return note_content;
	}

	public void setNote_content(String note_content) {
		this.note_content = note_content;
	}

	public int getRecv_chk() {
		return recv_chk;
	}

	public void setRecv_chk(int recv_chk) {
		this.recv_chk = recv_chk;
	}

	public String getSend_date() {
		return send_date;
	}

	public void setSend_date(String send_date) {
		this.send_date = send_date;
	}
}
