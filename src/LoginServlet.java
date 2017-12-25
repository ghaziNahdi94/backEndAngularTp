

import java.io.BufferedReader;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.codec.binary.Base64;

import com.google.gson.Gson;

import DAO.UserDAO;
import Modele.ConnectRequest;
import Modele.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 

	
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		
	}


	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		BufferedReader reader = request.getReader();
		Gson gson = new Gson();

		ConnectRequest cr = gson.fromJson(reader, ConnectRequest.class);
		
		
		UserDAO dao = new UserDAO();
		
		
		
		User u = dao.getUserByEmail(cr.getEmail());
		
		Reponse rep = new Reponse();
		
		if(u == null) {
			
			rep.setGoodEmail(false);
			rep.setGoodPassword(false);
			rep.setUser(null);
			
		}else {
			
			
			
			rep.setGoodEmail(true);
			
			if(u.getPassword().equals(Base64.encodeBase64String(cr.getPassword().getBytes()))) {
				
				System.out.println("true");

				
				rep.setGoodPassword(true);
				rep.setUser(u);
			}else {
				
				rep.setGoodPassword(false);
				rep.setUser(null);
				
			}
			
			
			
		}
		
		
		
		String json = new Gson().toJson(rep);
		response.setContentType("application/json");
        response.getWriter().write(json);
		
	}

	
	
class Reponse{
		
		private User user;
		private boolean goodEmail;
		private boolean goodPassword;

		public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
		}

		public boolean isGoodEmail() {
			return goodEmail;
		}

		public void setGoodEmail(boolean goodEmail) {
			this.goodEmail = goodEmail;
		}

		public boolean isGoodPassword() {
			return goodPassword;
		}

		public void setGoodPassword(boolean goodPassword) {
			this.goodPassword = goodPassword;
		}
		
		
		
	}
	
	
	
}
