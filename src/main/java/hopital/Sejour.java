package hopital;

import java.util.ArrayList;
import java.util.Date;

public class Sejour {

	private Date dateEntree;
	private Date dateSortie;
	private Patient patient;
	private ArrayList<FicheDeSuivi> listFicheDeSuivi;

	/** Constructeur  du sejour
	 * @param d date d'entree du patient
	 * @param p le patient
	 */
	public Sejour(Date d, Patient p){
		this.dateEntree = d;
		this.dateSortie = null;
		this.patient = p;
		this.listFicheDeSuivi = new ArrayList<FicheDeSuivi>();
	}

	/** renvoi la date d'entree du patient
	 * @return la date d'entree du patient
	 */
	public Date getDateEntree() {
		return dateEntree;
	}

	/** Modifie la date d'entree du patient
	 * @param dateEntree à modifier
	 */
	public void setDateEntree(Date dateEntree) {
		this.dateEntree = dateEntree;
	}

	/** Renvoi l'etat de la date de sortie
	 * @return vrai si la date est renseignee, faux sinon
	 */
	public boolean getDateSortie() {
		if (this.dateSortie != null){
			return true;
		}
		else {
			return false;
		}
	}

	/** Modifie la date de sortie 
	 * @param dateSortie a modifier
	 */
	public void setDateSortie(Date dateSortie) {
		this.dateSortie = dateSortie;
	}

	/** renvoi le patient
	 * @return le patient
	 */
	public Patient getPatient() {
		return patient;
	}

	/** modifie le patient
	 * @param patient a modifier
	 */
	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	/** renvoi la liste des fiches de suivi 
	 * @return les fiches de suivi
	 */
	public ArrayList<FicheDeSuivi> getListFicheDeSuivi() {
		return listFicheDeSuivi;
	}

	/** modifie la liste des fiche de suivi
	 * @param listFicheDeSuivi à modifier
	 */
	public void setListFicheDeSuivi(ArrayList<FicheDeSuivi> listFicheDeSuivi) {
		this.listFicheDeSuivi = listFicheDeSuivi;
	}

	/** ajouter une fiche de suivi à la liste
	 * @param s la fiche à ajouter
	 */
	public void addFicheDeSuivi(FicheDeSuivi s){
		if(!this.listFicheDeSuivi.contains(s))
			this.listFicheDeSuivi.add(s);
	}

}
