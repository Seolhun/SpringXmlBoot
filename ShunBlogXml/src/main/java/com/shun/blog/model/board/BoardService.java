package com.shun.blog.model.board;

import java.util.*;

import javax.servlet.http.HttpServletRequest;

public interface BoardService {
	// 게시물 리스트 가져오기
	List<Map<String, Object>> boardAllData(int start);
	
	int boardTotalPage();

	// 항목 별 게시물 검색결과 가져오기 (동적쿼리시 수정)
	int boardSearchTotalPage(Map map);

	List<Map<String, Object>> boardSearch(Map map);

	// 댓글 달기
	void boardReplyInsert(Map map);

	// 댓글 갯수 증가시키기
	void boardDepthIncrement(int boardNo);

	// 댓글 갯수 확인 - 게시물 지우기 방지
	int checkReplyNum(int boardNo);

	// 게시물 지우기
	void boardDelete(int boardNo);

	// 게시물 댓글 지우기
	void boardReplyDelete(Map map);

	// 게시물 갯수 감소시키기
	void boardDepthDecrement(int reBoardNo);

	// 게시물 수정 확인
	void boardModifyInsert(Map map);

	// 게시물 저장하기
	void boardInsert(Map map, HttpServletRequest req) throws Exception;

	// 게시물 보기
	BoardVO boardDetail(int boardNo);

	// 게시물 댓글 리스트
	List<BoardReplyVO> boardReplyList(int boardNo);

	// 조회수 증가시키기
	void boardHitIncrement(int boardNo);

	// 좋아요 누르기 (구현 중)
	void boardLikeChange(Map map);

	// 게시물 수정 내용 가져오기
	BoardVO boardModify(int boardNo);

}
