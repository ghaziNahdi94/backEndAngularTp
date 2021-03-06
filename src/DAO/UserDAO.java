package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import Modele.Livre;
import Modele.User;

public class UserDAO {

	
	private Connection con = null;


	private final String URL = "jdbc:mysql://localhost/library";
	private final String USER = "root";
	private final String PASSWORD = "";
	
	
	
	private final String ADD_USER_QUERY = "insert into user(nom,prenom,email,password,address,image,livres) values(?,?,?,?,?,?,'')";
	private final String Get_USER_BY_EMAIL = "select * from user where email=?";
	private final String ADD_Livres = "update user set livres=CONCAT(?,livres)";
	private final String GET_Livres = "select livres from user where email=?";
	 
	
	
	
	
	private Logger log = null;
	private void initLog() {
		log = Logger.getRootLogger();
		BasicConfigurator.configure();	
	}
	
	
	
	public UserDAO() {initLog();}
	
	
private void openAllDb(){
		
		try {
				
				
				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection(URL,USER,PASSWORD);
				
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
	
	
	private void closeAllDb(PreparedStatement ps,Connection con) {
		
		if(ps != null)
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(con != null)
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}
	
	
	
	
public String[] getLivresByEmail(String email) {
		
	     String[] livresTab=null;
		ResultSet res = null;
		
		openAllDb();
		
		
		try {
			PreparedStatement ps = con.prepareStatement(GET_Livres);
			ps.setString(1,email);
		

			res = ps.executeQuery();
			

			if(res.next()) {
				
		
				String livresCh = res.getString(1);
				
				 livresTab = livresCh.split("aaa");
				
				
				
				
				
				
			}
			
			
			
		closeAllDb(ps,con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return livresTab;
	}
	
	
	public User getUserByEmail(String email) {
		
		User u = null;
		ResultSet res = null;
		
		openAllDb();
		
		
		try {
			PreparedStatement ps = con.prepareStatement(Get_USER_BY_EMAIL);
			ps.setString(1,email);
		

			res = ps.executeQuery();
			

			if(res.next()) {
				
				
				String nom = res.getString(1);
				String prenom = res.getString(2);
				String em = res.getString(3);
				String password = res.getString(4);
				String address = res.getString(5);
				String image = res.getString(6);
				String livresCh = res.getString(7);
				
				String[] livresTab = livresCh.split("aaa");
				
				ArrayList<String> livres = new ArrayList<String>(Arrays.asList(livresTab));
				
				u = new User(email,nom,prenom,address,password,image,livres);
				
				
			}
			
			
			
		closeAllDb(ps,con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return u;
	}
	
	
	public void inscrireUser(User user) {
		
		
openAllDb();
		
	
	
		try {
			PreparedStatement ps = con.prepareStatement(ADD_USER_QUERY);
			ps.setString(1, user.getNom());
			ps.setString(2, user.getPrenom());
			ps.setString(3, user.getEmail());
			ps.setString(4, user.getPassword());
			ps.setString(5, user.getAdress());
			ps.setString(6, user.getImage());
			

			ps.executeUpdate();
			
			
			log.debug("c'est bon");
			
		closeAllDb(ps,con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	public void addLivres(Livre[] livres) {
		
		
		openAllDb();
				
		String l = "";
		
		for(Livre s : livres)
			l+=s.getTitre()+"aaa";
				
				
				try {
					PreparedStatement ps = con.prepareStatement(ADD_Livres);
							
					
					ps.setString(1, l);

					ps.executeUpdate();
					
					
					log.debug("c'est bon");
					
				closeAllDb(ps,con);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
				
			}
			
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
