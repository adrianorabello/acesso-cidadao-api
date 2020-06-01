package com.bi.biproxyapi.cors;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.bi.biproxyapi.config.File;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CorsFilter implements Filter {
	
    @Autowired
	private File file;
	
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {	
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;	
		boolean option = false;			
		
	
		for(int i = 0; i < file.getJson().getOrigem().size();i++) {
			if ( file.getJson().getOrigem().get(i).toString().equals(request.getHeader("Origin"))){			
				response.setHeader("Access-Control-Allow-Origin",  file.getJson().getOrigem().get(i).toString());
		        response.setHeader("Access-Control-Allow-Credentials", "true");
			}				
			if ("OPTIONS".equals(request.getMethod()) && ((file.getJson().getOrigem().get(i).toString().equals(request.getHeader("Origin"))))) {
				response.setHeader("Access-Control-Allow-Methods", "POST, GET, DELETE, PUT, OPTIONS");
	        	response.setHeader("Access-Control-Allow-Headers", "Authorization, Content-Type, Accept");
	        	response.setHeader("Access-Control-Max-Age", "3600");				
				response.setStatus(HttpServletResponse.SC_OK);
				option = true;
			} 					
		}	
		if(!option) {		
			chain.doFilter(req, resp);		
		}
		
//		
//		if ( "http://localhost:4200".equals(request.getHeader("Origin"))){
//			
//			response.setHeader("Access-Control-Allow-Origin", "http://localhost:4200");
//	        response.setHeader("Access-Control-Allow-Credentials", "true");
//		}
//	    if ( "http://info.planejamento.es.gov.br".equals(request.getHeader("Origin"))){
//			
//			response.setHeader("Access-Control-Allow-Origin", "http://info.planejamento.es.gov.br");
//	        response.setHeader("Access-Control-Allow-Credentials", "true");
//		}
//		
//	    if ("http://ss07.planejamento.es.gov.br".equals(request.getHeader("Origin"))){
//			
//			response.setHeader("Access-Control-Allow-Origin", " http://ss07.planejamento.es.gov.br");
//	        response.setHeader("Access-Control-Allow-Credentials", "true");
//		}
		
//		if ("OPTIONS".equals(request.getMethod()) &&(("http://localhost:4200".equals(request.getHeader("Origin")) || 
//				"http://ss07.planejamento.es.gov.br".equals(request.getHeader("Origin")) ||
//				"http://info.planejamento.es.gov.br".equals(request.getHeader("Origin"))))) {
//			response.setHeader("Access-Control-Allow-Methods", "POST, GET, DELETE, PUT, OPTIONS");
//        	response.setHeader("Access-Control-Allow-Headers", "Authorization, Content-Type, Accept");
//        	response.setHeader("Access-Control-Max-Age", "3600");
//			
//			response.setStatus(HttpServletResponse.SC_OK);
//		} else {
//			chain.doFilter(req, resp);
//		}
//		
	}
	
	@Override
	public void destroy() {
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}
	
	
	

}