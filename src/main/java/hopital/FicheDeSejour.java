package hopital;

import java.util.ArrayList;
import java.util.Date;

public class FicheDeSejour {


	private Patient patient;
	private ArrayList<Specialite>  listSpecialite;
	private Date dateEntre;

	/** Constructeur fiche de sejour 
	 * @param p patient à qui appartient la fiche
	 */
	public FicheDeSejour(Patient p,Date d){
		this.patient = p;
		this.listSpecialite = new ArrayList<Specialite>();
		this.dateEntre=d;
	}


	/** Ajoute un specialiste à la fiche
	 * @param s Specialiste à ajouter
	 * @return true si le specialiste a ete ajouter, faux sinon
	 */
	public boolean addSpecialite(Specialite s){
		if (!this.listSpecialite.contains(s)){
			this.listSpecialite.add(s);
			return true;
		}
		else {
			return false;
		}
	}


	/** Renvoi le patient
	 * @return le patient
	 */
	public Patient getPatient() {
		return this.patient;
	}

	public Date getDate() {
		return this.dateEntre;
	}

	/** Modifie le patient
	 * @param patient à modifier
	 */
	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	/** Renvoi la liste des specialistes
	 * @return la liste des specialistes
	 */
	public ArrayList<Specialite> getListSpecialite() {
		return listSpecialite;
	}

	/** Modifie la liste des specialistes
	 * @param listSpecialite la liste a modifier
	 */
	public void setListSpecialite(ArrayList<Specialite> listSpecialite) {
		if (this.listSpecialite.isEmpty()){
			this.listSpecialite = listSpecialite;
		}
		else{
			for (Specialite s : listSpecialite){
				if (!this.listSpecialite.contains(s)){
					this.listSpecialite.add(s);
				}
			}
		}
	}



}
