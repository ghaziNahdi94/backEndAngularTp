package Modele;

public class Livre {

	
	
	
	private String titre;
	private String image;
	private double prixElectronique;
	private double prixPhysique;
	private String auteur;
	private int quantity;
	private String genre;
	private String description;
	
	
	
	
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Livre(String titre, String image, double prixElectronique, double prixPhysique, String auteur, int quantity,
			String genre, String description) {
		super();
		this.titre = titre;
		this.image = image;
		this.prixElectronique = prixElectronique;
		this.prixPhysique = prixPhysique;
		this.auteur = auteur;
		this.quantity = quantity;
		this.genre = genre;
		this.description = description;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public double getPrixElectronique() {
		return prixElectronique;
	}
	public void setPrixElectronique(double prixElectronique) {
		this.prixElectronique = prixElectronique;
	}
	public double getPrixPhysique() {
		return prixPhysique;
	}
	public void setPrixPhysique(double prixPhysique) {
		this.prixPhysique = prixPhysique;
	}
	public String getAuteur() {
		return auteur;
	}
	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
