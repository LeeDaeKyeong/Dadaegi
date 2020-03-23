package Mmember.svc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.commit;
import static db.JdbcUtil.getConnection;
import static db.JdbcUtil.rollback;

import java.sql.Connection;

import dao.MemberDAO;
import vo.Note;

public class NoteAddService {

	public boolean addNote(Note note) {
		// TODO Auto-generated method stub
		MemberDAO memberDAO = MemberDAO.getInstance();
		Connection con = getConnection();
		memberDAO.setConnection(con);
		boolean noteAddSuccess = false;
		int insertCount = memberDAO.insertNote(note);

		if (insertCount > 0) {
			commit(con);
			noteAddSuccess = true;
		} else {
			rollback(con);
		}
		close(con);

		return noteAddSuccess;
	}

}
