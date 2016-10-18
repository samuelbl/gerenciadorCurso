package br.edu.ifsc.gerenciador.web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;


@WebFilter(urlPatterns="/*")
public class FiltroDeAuditoria implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("Iniciou");

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {	
		HttpServletRequest req = (HttpServletRequest) request;
		Cookie[] cookies = req.getCookies();
		
		boolean teste = true;
		
		for (Cookie cookie : cookies) {
			if(cookie.getName().equals("usuario.logado")){
				System.out.println("Usuario " +cookie.getValue()+ " acessando a URI: " + req.getRequestURI());
				teste = true;
			}
			else{
				teste = false;
			}
		}
		
		if(teste == false){
			System.out.println("Usuario <desconhecido> acessando a URI: " + req.getRequestURI());	
		}
		
		chain.doFilter(req, response);
	}

	@Override
	public void destroy() {
	 System.out.println("Destruído");

	}

}
