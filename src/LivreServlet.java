

import java.io.BufferedReader;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import DAO.LivreDAO;
import Modele.Livre;

/**
 * Servlet implementation class LivreServlet
 */
@WebServlet("/LivreServlet")
public class LivreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
 
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		BufferedReader reader = request.getReader();
		Gson gson = new Gson();
		
		
		
		LivreDAO dao = new LivreDAO();
		
		Livre[] livres = dao.getAllLivres();
		
		String json = new Gson().toJson(livres);
		response.setContentType("application/json");
        response.getWriter().write(json);
	
	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		
		BufferedReader reader = request.getReader();
		Gson gson = new Gson();
		
		Livre[] livres = gson.fromJson(reader,Livre[].class);
		
		
		
		LivreDAO dao = new LivreDAO();
		

		for(Livre l : livres) {
			
			System.out.println(l.getTitre()+"/"+l.getQuantity());
			dao.changeLivreQuantityByTitle(l.getTitre(), l.getQuantity());
			
		}
		
		
		
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
