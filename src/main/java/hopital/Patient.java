package hopital;

public class Patient {

	private String prenom;
	private String nom;
	private int age;
	private String numSecu;
	private String adresse;
	private FicheDeSejour fiche;

	/** Constructeur d'un Patient
	 * @param p prenom du patient
	 * @param n nom du patient
	 * @param age du patient
	 * @param numS numero de securite sociale du patient
	 * @param adresse du patient
	 */
	public Patient(String p, String n, int age, String numS, String adresse){
		this.prenom = p;
		this.nom = n;
		this.age = age;
		this.numSecu = numS;
		this.adresse = adresse;
		this.fiche = null;
	}

	public Patient(String p, String n){
		this.prenom = p;
		this.nom = n;
		this.age = -1;
		this.numSecu = null;
		this.adresse = null;
		this.fiche = null;
	}



	/** renvoi le prenom du patient
	 * @return le prenom du patient
	 */
	public String getPrenom() {
		return prenom;
	}

	/** moodifie le prenom du patient
	 * @param prenom à modifier
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/** renvoi le nom du patient
	 * @return le nom du patient
	 */
	public String getNom() {
		return nom;
	}

	/** modifie le le nom du patient
	 * @param nom à modifier
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/** renvoi l'age du patient
	 * @return l'age du patient
	 */
	public int getAge() {
		return age;
	}

	/** Modifie l'age du patient
	 * @param age à modifier
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/** Renvoi le numero de securite sociale du patient
	 * @return le numero de securite sociale du patient
	 */
	public String getNumSecu() {
		return numSecu;
	}

	/** modifie le numero de securite sociale du patient
	 * @param numSecu le numero de securite sociale à modifier
	 */
	public void setNumSecu(String numSecu) {
		this.numSecu = numSecu;
	}

	/** renvoi l'adresse du patient
	 * @return l'adresse du patient
	 */
	public String getAdresse() {
		return adresse;
	}

	/** modifie l'adresse du patient
	 * @param adresse à modifier
	 */
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	/** renvoi la fiche du sejour du patient
	 * @return la fiche du sejour
	 */
	public FicheDeSejour getFiche() {
		return this.fiche;
	}

	/** modifie la fiche du sejour
	 * @param fiche à modifier
	 * @return vrai si la fiche est correctement modifier, faux sinon
	 */
	public boolean setFiche(FicheDeSejour fiche) {
		if (this.fiche == null){
			this.fiche = fiche;
			return true;}
		else
			return false;
	}

	/**
	 * detruit la fiche de sejour du patient
	 */
	public void destroyFiche(){
		this.fiche =  null;
	}




}
