package com.shun.blog.model.board;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.shun.blog.commons.file.FileUtils;

@Service(value = "boardServiceImple")
public class BoardServiceImpl implements BoardService {
	Logger log = Logger.getLogger(this.getClass());

	@Autowired
	private FileUtils fileUtils;

	@Autowired
	private BoardDAO boardDAO;

	@Override
	public int boardTotalPage() {
		return boardDAO.boardTotalPage();
	}

	@Override
	public List<Map<String, Object>> boardAllData(int start) {
		return boardDAO.boardAllData(start);
	}

	@Override
	public int boardSearchTotalPage(Map map) {
		return boardDAO.boardSearchTotalPage(map);
	}

	@Override
	public List<Map<String, Object>> boardSearch(Map map) {
		return boardDAO.boardSearch(map);
	}

	@Override
	public void boardReplyInsert(Map map) {
		boardDAO.boardReplyInsert(map);
	}

	@Override
	public void boardDepthIncrement(int boardNo) {
		boardDAO.boardDepthIncrement(boardNo);
	}

	@Override
	public int checkReplyNum(int boardNo) {
		return boardDAO.checkReplyNum(boardNo);
	}

	@Override
	public void boardDelete(int boardNo) {
		boardDAO.boardDelete(boardNo);
	}

	@Override
	public void boardReplyDelete(Map map) {
		boardDAO.boardReplyDelete(map);
	}

	@Override
	public void boardDepthDecrement(int reBoardNo) {
		boardDAO.boardDepthDecrement(reBoardNo);
	}

	@Override
	public void boardModifyInsert(Map map) {
		boardDAO.boardModifyInsert(map);
	}

	@Override
	public void boardInsert(Map map, HttpServletRequest req) throws Exception {
		boardDAO.boardInsert(map);
		int fileBoardNo = boardDAO.insertFileCheckBoardNo(map);
		map.put("fileBoardNo", fileBoardNo);
		MultipartHttpServletRequest mhsr = (MultipartHttpServletRequest) req;
		Iterator<String> iterator = mhsr.getFileNames();
		MultipartFile multipartFile = null;
		while (iterator.hasNext()) {
			multipartFile = mhsr.getFile(iterator.next());
			if (multipartFile.isEmpty() == false) {
				log.debug("------------- file start -------------");
				log.debug("name : " + multipartFile.getName());
				log.debug("filename : " + multipartFile.getOriginalFilename());
				log.debug("size : " + multipartFile.getSize());
				log.debug("-------------- file end --------------\n");
			}
		}
		List<Map<String, Object>> list = fileUtils.parseInsertFileInfo(map, req);
		for (int i = 0, size = list.size(); i < size; i++) {
			boardDAO.boardInsertFile(list.get(i));
		}
	}

	@Override
	public BoardVO boardDetail(int boardNo) {
		return boardDAO.boardDetail(boardNo);
	}

	@Override
	public List<BoardReplyVO> boardReplyList(int boardNo) {
		return boardDAO.boardReplyList(boardNo);
	}

	@Override
	public void boardHitIncrement(int boardNo) {
		boardDAO.boardHitIncrement(boardNo);
	}

	// 좋아요 기능 구현 중
	@Override
	public void boardLikeChange(Map map) {
		boardDAO.boardLikeChange(map);
	}

	@Override
	public BoardVO boardModify(int boardNo) {
		return boardDAO.boardModify(boardNo);
	}
}