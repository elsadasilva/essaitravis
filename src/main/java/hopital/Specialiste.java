package hopital;

public class Specialiste {

	private String nom;
	private String prenom;
	private Specialite spec;

	/** Constructeur du specialiste
	 * @param n nom du specialiste
	 * @param p prenom du specialiste
	 * @param s specialite du specialiste
	 */
	public Specialiste(String n, String p, Specialite s){
		this.nom = n;
		this.prenom = p;
		this.spec = s;
	}

	/** Renvoi le nom du specialiste
	 * @return le nom du specialiste
	 */
	public String getNom() {
		return nom;
	}

	/** Modifie le nom du specialiste
	 * @param nom du specialiste
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/** Renvoi le nom du specialiste
	 * @return le nom du specialiste
	 */
	public String getPrenom() {
		return prenom;
	}

	/** Modifie le prenom du specialiste
	 * @param prenom du specialiste
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/** Renvoi la specialite du specialiste
	 * @return la specialite du specialiste
	 */
	public Specialite getSpec() {
		return spec;
	}

	/** Modifie la specialite du specialiste
	 * @param spec Specialite à modifier
	 */
	public void setSpec(Specialite spec) {
		this.spec = spec;
	}




}
