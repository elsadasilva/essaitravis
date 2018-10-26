package hopital;

import java.util.ArrayList;

public class Consultation {

	private Specialiste specialiste;
	private Patient patient;

	/** Constructeur de la consultation
	 * @param s specialiste
	 * @param p patient
	 */
	public Consultation(Specialiste s, Patient p){
		this.specialiste = s;
		this.patient = p;
	}


	/** Renvoi la liste des comptes rendus
	 * @return la liste des comptes rendus
	 */
	public ArrayList<ComptesRendu> getComptesRendu(){
		return null;
	}



	/** renvoi le specialiste
	 * @return le specialiste
	 */
	public Specialiste getSpecialiste() {
		return specialiste;
	}

	/** Modifie le specialiste
	 */
	public void setSpecialiste(Specialiste specialiste) {
		this.specialiste = specialiste;
	}

	/** renvoi le patient
	 * @return le patient
	 */
	public Patient getPatient() {
		return patient;
	}

	/** modifie le patient
	 * @param patient à modifier
	 */
	public void setPatient(Patient patient) {
		this.patient = patient;
	}




}
