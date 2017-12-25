

import java.io.BufferedReader;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import DAO.LivreDAO;
import DAO.UserDAO;
import Modele.Livre;

/**
 * Servlet implementation class UserLivre
 */
@WebServlet("/UserLivre")
public class UserLivre extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		
		String email = request.getParameter("email");
		
		
		Gson gson = new Gson();
		
		
		
		UserDAO dao = new UserDAO();
		
		String[] livres = dao.getLivresByEmail(email);
		
		String json = new Gson().toJson(livres);
		response.setContentType("application/json");
        response.getWriter().write(json);
		
		
	}

protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		
		BufferedReader reader = request.getReader();
		Gson gson = new Gson();
		
		Livre[] livres = gson.fromJson(reader,Livre[].class);
		
		
		
		UserDAO dao = new UserDAO();
		

	
		
			
			dao.addLivres(livres);
			
		
		
		
		
		Reponse rep = new Reponse();
		rep.setOk(true);
		String json = new Gson().toJson(rep);
		response.setContentType("application/json");
        response.getWriter().write(json);
		
	}
	
	
	
	
	
class Reponse{
		
		private boolean ok;
		
		public boolean getOk() {return this.ok;}
		public void setOk(boolean b) {this.ok = b;}
		
	}

}