

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUpload;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.tomcat.util.codec.binary.Base64;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import DAO.UserDAO;
import Modele.User;




@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	
	
	
	
	
	
	
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		
	}
	
	
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		BufferedReader reader = request.getReader();
		Gson gson = new Gson();

		
		
		User user = gson.fromJson(reader,User.class);
		
		
		
		
		
		
		Reponse rep = new Reponse();
		
		UserDAO dao = new UserDAO();
		
		
		if(dao.getUserByEmail(user.getEmail()) == null) {	
	
			

			rep.setOk(true);
			//crypter mot de passe
			user.setPassword(Base64.encodeBase64String(user.getPassword().getBytes()));
			
			
					
			dao.inscrireUser(user);
			
		}else {
		
			
			rep.setOk(false);
			
		}
		
		
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
