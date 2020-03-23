package member.service;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import dao.MemberDAO;
import vo.Member;
import vo.Note;

public class NoteListSvc {

	public int getListCount() {
		// TODO Auto-generated method stub
		Connection con = getConnection();
		MemberDAO memberDao = MemberDAO.getInstance();
		memberDao.setConnection(con);

		int listCount = memberDao.selectNoteListCount();

		close(con);
		return listCount;
	}

	public ArrayList<Note> getNoteList(int page, int limit, String member_id) {
		// TODO Auto-generated method stub
		Connection con = getConnection();
		MemberDAO memberDao = MemberDAO.getInstance();
		memberDao.setConnection(con);

		ArrayList<Note> noteList = memberDao.selectNoteList(page, limit, member_id);

		close(con);
		return noteList;
	}

	public int getNoteCount(String member_id) {
		// TODO Auto-generated method stub
		Connection con = getConnection();
		MemberDAO memberDao = MemberDAO.getInstance();
		memberDao.setConnection(con);

		int noteCount = memberDao.selectNoteCount(member_id);

		close(con);
		return noteCount;
	}

}
