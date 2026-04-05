package com.pethotel.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class WebConfig implements WebMvcConfigurer{

	private final LoginInterceptor loginInterceptor;
	
	public WebConfig(LoginInterceptor loginInterceptor) {
		
		this.loginInterceptor = loginInterceptor;
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(loginInterceptor)
		           .addPathPatterns("/**")
		           .excludePathPatterns(
		        		    "/" //리다이렉트 시켜주는 메인경로		        		   
		        		   ,"/main/home" //메인홈
		        		   ,"/user/login"//로그인화면
		        		   ,"/user/member" //회원가입 화면
		        		   ,"/board/list" //게시판리스트 뷰화면
		        		   ,"/board/view"//게시판 뷰 화면
		        		   
		        		   );
		
		
	}
		
		
	
}
