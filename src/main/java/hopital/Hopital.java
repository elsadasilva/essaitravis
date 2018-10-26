package hopital;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Lukas
 *
 */

public class Hopital {

	private Map<Patient, ArrayList<Sejour>> mapInterne;
	private ArrayList<Specialite> listSpecialite;
	private ArrayList<Specialiste> listSpecialiste;

	/**
	 * Constructeur de Hopital
	 */
	public Hopital(){
		this.mapInterne = new HashMap<Patient, ArrayList<Sejour>>();
		this.listSpecialite = new ArrayList<Specialite>();
		this.listSpecialiste = new ArrayList<Specialiste>();
	}



	/**	Permet de creer un Patient et de l'ajouter à la map du l'hopital
	 * @param p Prenom du Patient
	 * @param n Nom du Patient
	 * @param age du Patient
	 * @param numS Numero de securite sociale du patient
	 * @param adresse du Patient
	 * @return le Patient cree
	 */
	public Patient createPatient(String p, String n, int age, String numS, String adresse){
		Patient patient = new Patient(p,  n,  age,  numS, adresse);
		this.mapInterne.put(patient, new ArrayList<Sejour>());
		return patient;		
	}

	/** Recherche si le patient est contenu dans la liste de l'hopital
	 * @param p Prenom du Patient
	 * @param n Nom du Patient
	 * @param numsecu
	 * @return le patient lorsqu'il est dans la liste
	 */
	public ArrayList<Patient> returnMultiPatient(String p, String n){
		ArrayList<Patient> l = new ArrayList<Patient>();
		for (Patient monPatient : this.mapInterne.keySet()){
			if (monPatient.getNom().toLowerCase().equals(n.toLowerCase().trim()) && monPatient.getPrenom().toLowerCase().equals(p.toLowerCase().trim())){
				l.add(monPatient);
			}
		}
		return l;
	}


	/**
	 * getter qui renvoi tous les comptes rendus
	 * @param p le patient
	 * @param s specialite 
	 * @return liste de comptes rendus
	 */
	public ArrayList<ComptesRendu> getComptesRendu(Patient p, Specialite s){
		ArrayList<ComptesRendu> list = new ArrayList<ComptesRendu>();
		for (Sejour sejour : this.mapInterne.get(p)){
			for (FicheDeSuivi fiche : sejour.getListFicheDeSuivi()){
				for (ComptesRendu r : fiche.getListContreRendu()){
					if (r.getNom().getSpec()==s){
						list.add(r);
					}
				}
			}
		}
		return list;
	}





	/** Creer un sejour et l'ajoute à la liste de l'hopital
	 * @param dateEntree du patient
	 * @param p le patient
	 */
	public void createSejour(Date dateEntree, Patient p ){		
		this.mapInterne.get(p).add(new Sejour(dateEntree, p));
	}

	/** Ajoute une specialite à l'hopital
	 * @param s Specialite à ajouter
	 */
	public void addSpecialite(Specialite s){
		if (!this.listSpecialite.contains(s)){
			this.listSpecialite.add(s);
		}
	}

	/** Supprime une specialite de l'hopital
	 * @param s Specialite à supprimer
	 */
	public void removeSpecialite(Specialite s){
		if (this.listSpecialite.contains(s)){
			this.listSpecialite.remove(s);
		}
	}

	/** Ajoute un specialiste à l'hopital
	 * @param s Specialiste à ajouter
	 */
	public void addSpecialiste(Specialiste s){
		if (!this.listSpecialiste.contains(s)){
			this.listSpecialiste.add(s);
		}
	}

	/** Supprime un specialiste à l'hopital
	 * @param s Specialiste à supprimer
	 */
	public void removeSpecialiste(Specialiste s){
		if (this.listSpecialiste.contains(s)){
			this.listSpecialiste.remove(s);
		}
	}

	public ArrayList<Specialite> getlistSpecialite(){
		return this.listSpecialite;
	}

	public ArrayList<Specialiste> getlistSpecialiste(){
		return this.listSpecialiste;
	}

	public ArrayList<Sejour> getMultiSejour(Patient p){
		return this.mapInterne.get(p);
	}


	public Sejour getSejour(Patient p){
		for (Sejour s : this.mapInterne.get(p)){
			if(!s.getDateSortie())
				return s;				
		}
		return null;
	}

	public Specialiste checkContainSpecialiste(String nom, String prenom){
		for (Specialiste s : this.listSpecialiste){
			if (s.getNom().toLowerCase().equals(nom.toLowerCase()) && s.getPrenom().toLowerCase().equals(prenom.toLowerCase())){
				return s;
			}
		}
		return null;
	}

}
