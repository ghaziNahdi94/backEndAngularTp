package Modele;

import java.util.ArrayList;

import com.google.gson.annotations.SerializedName;

public class User {
	
	
	private String email;
	private String nom;
	private String prenom;
	private String address;
	private String password;	
	private String image;
	private ArrayList<String> livres;
	
	
	public User(String email, String nom, String prenom, String adress,String password,String image,ArrayList<String> livres) {
		super();
		this.email = email;
		this.nom = nom;
		this.prenom = prenom;
		this.password = password;
		this.address = adress;
		this.image = image;
		this.livres = livres;
	}


	
	
	
	public ArrayList<String> getLivres() {
		return livres;
	}





	public void setLivres(ArrayList<String> livres) {
		this.livres = livres;
	}





	public String getAddress() {
		return address;
	}





	public void setAddress(String address) {
		this.address = address;
	}





	public void setEmail(String email) {
		this.email = email;
	}





	public void setNom(String nom) {
		this.nom = nom;
	}





	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}





	public String getEmail() {
		return email;
	}


	public String getNom() {
		return nom;
	}


	public String getPrenom() {
		return prenom;
	}


	public String getPassword() {
		return password;
	}


	public String getAdress() {
		return address;
	}


	@Override
	public String toString() {
		return email+"/"+nom+"/"+prenom+"/"+password+"/"+address;
	}


	public void setPassword(String password) {
		this.password = password;
	}





	public String getImage() {
		return image;
	}





	public void setImage(String image) {
		this.image = image;
	}
	
	
	
	
	
	
	

}
