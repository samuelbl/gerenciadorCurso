package br.edu.ifsc.gerenciador.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ifsc.gerenciador.dao.EmpresaDAO;
import br.edu.ifsc.gerenciador.modelo.Empresa;

@WebServlet(urlPatterns="/busca")
public class BuscaEmpresa extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter writer = resp.getWriter();
		writer.println("<html>");
		writer.println("<body>");
		writer.println("Reultado da busca:<br/>");
		String filtro = req.getParameter("filtro");
		for (Empresa empresa : new EmpresaDAO().buscaPorSimilaridade(filtro)){
			writer.println("<li>" + empresa.getId() + ": " + empresa.getNome() + "</li>");
		}
		
		writer.println("</body>");
		writer.println("</html>");
	}
}
