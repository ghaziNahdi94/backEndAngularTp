package Modele;

public class User {
	
	
	private String email;
	private String nom;
	private String prenom;
	private String password;
	private String address;
	
	
	public User(String email, String nom, String prenom, String password, String adress) {
		super();
		this.email = email;
		this.nom = nom;
		this.prenom = prenom;
		this.password = password;
		this.address = adress;
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
	
	
	
	
	
	
	

}
