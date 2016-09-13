package com.shun.blog.commons;

import java.io.File;
import java.util.*;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Component("fileUtils")
public class FileUtils {
	private static final String filePath = "/Users/hunseol/Desktop/fileUploader/";

	public List<Map<String, Object>> parseInsertFileInfo(Map<String, Object> map, HttpServletRequest request) throws Exception {
		MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;
		Iterator<String> iterator = multipartHttpServletRequest.getFileNames();
		
		MultipartFile multipartFile = null;
		String originFileName = null;
		String originalFileExtension = null;
		String storeFileName = null;

		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		Map<String, Object> listMap = null;
		
		int boardno=(Integer)map.get("fileBoardNo");
		String fileRegAccount=(String)map.get("boardAccount"); //글쓰기시 로그인 아이디를 가져오는 것. 결국 파일업로드는 로그인 한사람의 아이디이다. 

		// 디렉토리가 존재하지 않을시 자동생성
		File file = new File(filePath);
		if (file.exists() == false) {
			file.mkdirs();
		}

		while (iterator.hasNext()) {
			multipartFile = multipartHttpServletRequest.getFile(iterator.next());
			if (multipartFile.isEmpty() == false) {
				originFileName = multipartFile.getOriginalFilename();
				originalFileExtension = originFileName.substring(originFileName.lastIndexOf("."));
				storeFileName = CommonUtils.getRandomString() + originalFileExtension;

				file = new File(filePath + storeFileName);
				multipartFile.transferTo(file);
				
				listMap = new HashMap<String, Object>();
				listMap.put("fileBoardNo", boardno);
				listMap.put("originFileName", originFileName);
				listMap.put("storeFileName", storeFileName);
				listMap.put("fileSize", multipartFile.getSize());
				listMap.put("fileRegAccount", fileRegAccount); //에러가 날 수도 있다.
				list.add(listMap);
			}
		}
		return list;
	}
}