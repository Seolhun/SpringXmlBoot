package com.shun.blog.spring.configuration;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import com.shun.blog.spring.configuration.SpringRootConfig;
public class SpringMvcInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

//	Mapping시 /자동으로 붙여준다.Resolver는 파일위치 폴더를 나타내는 것이고, 이것은 리퀘스트 요청을 말하는 것.
	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}
	
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] { SpringRootConfig.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] { SpringWebConfig.class };
	}
}
