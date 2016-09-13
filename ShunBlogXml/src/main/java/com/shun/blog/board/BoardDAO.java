package com.shun.blog.board;

import org.springframework.stereotype.Repository;
import com.shun.blog.commons.AbstractDAO;
import java.util.*;

@Repository
public class BoardDAO extends AbstractDAO {

	// boardno, userno,subject,content,regdate,hit,blike,depth
	public List<Map<String, Object>> boardAllData(int start) {
		return (List<Map<String, Object>>) selectList("board.boardAllData", start);
	}

	// 게시판 총 페이지 갯수
	public int boardTotalPage() {
		return (Integer) selectOne("board.boardTotalPage");
	}

	// 게시판 글 작성
	public void boardInsert(Map map) throws Exception {
		insert("board.boardInsert", map);
	}

	// 게시판 파일 보내기
	public void boardInsertFile(Map map) throws Exception {
		insert("board.boardInsertFile", map);
	}

	// 게시판 등록시 게시판 번호를 통해 파일 DB번호 등록
	public int insertFileCheckBoardNo(Map map) {
		return (Integer) selectOne("board.insertFileCheckBoardNo", map);
	}

	// 게시판 상세보기
	public BoardVO boardDetail(int boardNo) {
		return (BoardVO) selectOne("board.boardDetail", boardNo);
	}

	// 조회수 증가
	public void boardHitIncrement(int boardNo) {
		update("board.boardHitIncrement", boardNo);
	}

	// 좋아요 증가(구현 중)
	public void boardLikeChange(Map map) {
		boardLikeChange(map);
	}

	// 댓글 달기
	public void boardReplyInsert(Map map) {
		insert("board.boardReplyInsert", map);
	}

	public List<BoardReplyVO> boardReplyList(int boardNo) {
		return selectList("board.boardReplyList", boardNo);
	}

	// 게시글에 댓글 등록시 Depth 증가시키기
	public void boardDepthIncrement(int boardNo) {
		update("board.boardDepthIncrement", boardNo);
	}

	// 게시글 삭제하기
	public void boardDelete(int boardNo) {
		delete("board.boardDelete", boardNo);
	}

	// 게시글에 댓글 확인 - 댓글 있을 시 삭제 불가
	public int checkReplyNum(int boardNo) {
		return (Integer) selectOne("board.checkReplyNum", boardNo);
	}

	// 게시판 댓글 삭제하기
	public void boardReplyDelete(Map map) {
		delete("board.boardReplyDelete", map);
	}

	// 게시판 Depth -1 해주기
	public void boardDepthDecrement(int boardNo) {
		update("board.boardDepthDecrement", boardNo);
	}

	// 게시판 수정하기 불러오기
	public BoardVO boardModify(int boardNo) {
		return (BoardVO) selectOne("board.boardModify", boardNo);
	}

	// 게시판 수정한 것 입력하기
	public void boardModifyInsert(Map map) {
		update("board.boardModifyInsert", map);
	}

	// 검색 결과 출력하기
	public List<Map<String, Object>> boardSearch(Map map) {
		return selectList("board.boardSearch", map);
	}

	// 게시판 총 페이지 갯수
	public int boardSearchTotalPage(Map map) {
		return (Integer) selectOne("board.boardSearchTotalPage", map);
	}
}
