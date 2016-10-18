package br.edu.ifsc.gerenciador.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import br.edu.ifsc.gerenciador.dao.UsuarioDAO;
import br.edu.ifsc.gerenciador.modelo.Usuario;

@WebServlet(urlPatterns="/novoUsuario")
public class NovoUsuario extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String email = req.getParameter("email");
	String senha = req.getParameter("senha");
	Usuario usuario = new Usuario(email, senha);
	
	
	new UsuarioDAO().adiciona(usuario);
	PrintWriter writer = resp.getWriter();
	writer.println("<html><doby>Empresa " + email + " adicionada </body> </html>");
}

}
