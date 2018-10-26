package hopital;

import java.util.Date;

public class ComptesRendu {

	private Date date;
	private Specialiste nom;
	private String descriptif;

	public ComptesRendu(Date d, Specialiste s, String des){
		this.date = d;
		this.nom = s;
		this.descriptif = des;			
	}

	/** renvoi la date du compte rendu
	 * @return la date
	 */
	public Date getDate() {
		return date;
	}

	/** Modifie la date du compte rendu
	 * @param date à ajouter
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/** Renvoi le specialiste qui a rediger le compte rendu
	 * @return le specialiste
	 */
	public Specialiste getNom() {
		return nom;
	}

	/** modifie le specialiste du compte rendu
	 * @param nom le specaliste
	 */
	public void setNom(Specialiste nom) {
		this.nom = nom;
	}

	/** renvoi la description faite par le specaialiste
	 * @return la description du compte rendu
	 */
	public String getDescriptif() {
		return descriptif;
	}

	/** Modifie la description du compte rendu
	 * @param descriptif à modifier
	 */
	public void setDescriptif(String descriptif) {
		this.descriptif = descriptif;
	}




}
