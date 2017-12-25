package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import Modele.Livre;
import Modele.User;

public class LivreDAO {
	
	
	private Connection con = null;


	private final String URL = "jdbc:mysql://localhost/library";
	private final String USER = "root";
	private final String PASSWORD = "";
	
	
	private final String GET_ALL_LIVRES = "select * from livre";
	private final String CHANGE_QUANTITY = "UPDATE livre set quantity=quantity-? where titre=?";
	
	
	
	
	
	
	private Logger log = null;
	private void initLog() {
		log = Logger.getRootLogger();
		BasicConfigurator.configure();	
	}
	
	
	
	public LivreDAO() {initLog();}
	
	
	
	
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
	
	
	
	
	
	public void changeLivreQuantityByTitle(String title,int q) {
		
		
			openAllDb();
		
			System.out.println("q:"+q);
		
		try {
			PreparedStatement ps = con.prepareStatement(CHANGE_QUANTITY);
			
			ps.setInt(1,q);
			ps.setString(2, title);

			ps.executeUpdate();
				
			
		closeAllDb(ps,con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
			
	}
	
	
	public Livre[] getAllLivres() {
		
		ArrayList<Livre> livres = new ArrayList<Livre>();
		
		ResultSet res = null;
		
		openAllDb();
		
		
		try {
			PreparedStatement ps = con.prepareStatement(GET_ALL_LIVRES);
			
		

			res = ps.executeQuery();
			

			while(res.next()) {
				
				
			String titre = res.getString(1);
			double prixElectronique = res.getDouble(2);
			double prixPhysique = res.getDouble(3);
			String image = res.getString(4);
			int quantity = res.getInt(5);
			String description = res.getString(6);
			String genre = res.getString(7);
			String auteur = res.getString(8);
			
			
			Livre livre = new Livre(titre, image, prixElectronique, prixPhysique, auteur, quantity, genre, description);
			
			livres.add(livre);
				
			}
			
			
			
		closeAllDb(ps,con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		Livre[] arrayLivres = new Livre[livres.size()];
		arrayLivres = livres.toArray(arrayLivres);
		
		return arrayLivres;
	}
	
	
	
	
	

}
