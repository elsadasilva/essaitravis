package hopital;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class FicheDeSuivi {

	private ArrayList<ComptesRendu> listContreRendu;
	private Sejour sejour;
	private Specialite specialite;

	/** Constructeur 
	 * @param s Sejour de la fiche de suivi
	 */
	public FicheDeSuivi(Sejour s, Specialite spec){
		this.sejour = s;

		this.listContreRendu = new ArrayList<ComptesRendu>();
		this.setSpecialite(spec);
	}


	/** Ajoute un compte rendu à la fiche de suivi
	 * @param c Compte rendu à ajouter
	 */
	public void addContreRendu(ComptesRendu c){
		if (!this.listContreRendu.contains(c)){
			this.listContreRendu.add(c);
		}
	}



	/** renvoi la liste des comptes rendus
	 * @return la liste des comptes rendus
	 */
	public ArrayList<ComptesRendu> getListContreRendu() {
		return listContreRendu;
	}

	/** Modifie la liste des comptes rendus
	 * @param listContreRendu à modifier
	 */
	public void setListContreRendu(ArrayList<ComptesRendu> listContreRendu) {
		this.listContreRendu = listContreRendu;
	}

	/** renvoi le sejour de la fiche
	 * @return le sejour
	 */
	public Sejour getSejour() {
		return sejour;
	}

	/** Modifie de le sejour de la fiche de suivi
	 * @param sejour à modifier
	 */
	public void setSejour(Sejour sejour) {
		this.sejour = sejour;
	}


	/**
	 * getter specialite
	 * @return specialite
	 */
	public Specialite getSpecialite() {
		return specialite;
	}


	/**
	 * set la specialite
	 * @param specialite
	 */
	public void setSpecialite(Specialite specialite) {
		this.specialite = specialite;
	}




}
