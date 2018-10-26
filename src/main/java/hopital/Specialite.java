package hopital;

import java.util.ArrayList;

public class Specialite {

	private String nom;
	private ArrayList<Specialiste> listSpec;

	/** Constructeur de la specialite
	 * @param n le nom de la specalite
	 */
	public Specialite(String n){
		this.nom = n;
		this.listSpec = new ArrayList<Specialiste>();
	}




	/** Ajoute un specialiste
	 * @param s le Specialiste à ajouter
	 * @return un boolean, vrai lorsque l'ajout se fait, faux lorsque le specialiste est dejà dans la liste
	 */
	public boolean addSpecialiste(Specialiste s){
		if (!this.listSpec.contains(s)){
			this.listSpec.add(s);
			return true;
		}
		else
			return false;
	}


	/** Renvoi le nom de la specialite
	 * @return le nom de la specialite
	 */
	public String getNom() {
		return nom;
	}

	/** Modifie le nomn de la specialite
	 * @param nom de la specialite
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/** Renvoi la liste des specialistes
	 * @return la liste des specialistes
	 */
	public ArrayList<Specialiste> getListSpec() {
		return listSpec;
	}

	/** Modifie la liste des specialites
	 * @param listSpec la liste à ajouter
	 */
	public void setListSpec(ArrayList<Specialiste> listSpec) {
		this.listSpec = listSpec;
	}




}
