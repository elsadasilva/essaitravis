package hopital;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Formatter;

import javax.swing.JTextArea;

import util.CheckEntry;
import util.Display;
import util.InitializeHospital;
import util.IterList;
import util.Write;



public class Services {

	private Hopital h;
	private Write w;
	private CheckEntry check;
	private Display display;
	private IterList iter;


	/**
	 * Constructeur de service
	 */
	public Services(){
		this.h = new InitializeHospital().init();
		this.w=new Write();
		this.check=new CheckEntry();
		this.display=new Display();
	}

	/**
	 * gère l'entrée d'un patient dans l'hopital
	 * @return Patient ajouté dans l'hopital
	 */
	public Patient entreePatient(){
		Patient p;
		String adresse = "";
		int age = 1;
		String strCQ = "";
		Date d1 = null;
		this.w.ww("");
		p = findPatient(true);		
		if (p.getAge() > -1){
			this.w.w("Coordonnées du patient :");
			this.w.w("");
			this.display.afficheDonneesPatient(p);
			if(p.getFiche()==null) {
				this.w.w("");
				this.w.w("Creation de la fiche de sejour");
				while (d1 == null){
					d1 = dateDeSejour(p); 
				}
			}
		}
		if (p.getAge()==-1){
			this.w.w("");
			this.w.w("Creation d'une nouvelle fiche patient.");
			this.w.w("");
			boolean boolCQ = false;
			while (!boolCQ){
				strCQ = this.check.myScan("Indiquez son numero de securite sociale (15 chiffres)");
				boolCQ = this.check.testNum(strCQ.trim());
			}
			this.w.w("Numéro de SS : "+strCQ);
			boolean boolAge = false;
			while (!boolAge){
				try{
					age = Integer.parseInt(this.check.myScan("Indiquez son âge").trim());
					if (age >= 0 && age <= 120)
						boolAge = true;
				}
				catch (Exception e){

				}
			}
			this.w.w("Age : "+age);
			adresse = this.check.myScan("Indiquez son adresse");
			this.w.w("Adresse : "+adresse);
			p.setAge(age);
			String nom = p.getNom();
			String prenom = p.getPrenom();
			p = h.createPatient(prenom.trim(), nom.trim(), age, strCQ, adresse.trim());
			while (d1 == null){
				d1 = dateDeSejour(p); 
			}
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			this.w.w("Date d'entrée : " +formatter.format(d1));
			this.h.createSejour(d1, p);	
		}
		p.setFiche(new FicheDeSejour(p,d1));		
		this.display.afficheSpecialite(p,this.h);
		return p;
	}







	/**
	 * trouve un patient
	 * @param b indique dans quel situation faire la recherche de patient
	 * @return le patient trouve
	 */
	public  Patient findPatient(boolean b){
		String strPrenom="";
		String strNom="";
		while(strNom.equals("")) {
			strNom = this.check.myScan("Indiquez le nom du patient");
		}
		this.w.w("Nom du patient : " +strNom);
		while(strPrenom.equals("")) {
			strPrenom = this.check.myScan("Indiquez le prenom du patient.");
		}
		this.w.w("Prenom du patient : " +strPrenom);
		this.iter=new IterList<Patient>();
		this.iter.setList(this.h.returnMultiPatient(strPrenom.trim(), strNom.trim()));
		Patient p ;
		if(!iter.hasNext()) {
			this.w.w("Le patient n'existe pas.");
			return new Patient(strPrenom.trim(), strNom.trim());
		}
		else{
			String strCQ="0";
			boolean boolCQ = false;
			this.display.afficheHomonyme(this.iter, b);
			while (!boolCQ || Integer.parseInt(strCQ.trim()) < 1 || Integer.parseInt(strCQ.trim()) >(this.iter.size()+1)){
				strCQ = this.check.myScan("Saissisez votre choix");
				boolCQ = this.check.testInt(strCQ.trim());
			}
			if (Integer.parseInt(strCQ.trim())==this.iter.size()+1){
				return 	new Patient(strPrenom.trim(), strNom.trim());
			}
			else
				return (Patient) this.iter.getIndex((Integer.parseInt(strCQ.trim())-1));
		}
	}



	/**
	 * affiche le sejour du patient
	 */
	public void visualisationSejour(){
		this.w.ww("");
		Patient p = findPatient(false);
		if (p.getAge() > -1 && p.getFiche()!=null){
			Sejour s = h.getSejour(p);
			DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");			
			String today = formatter.format(p.getFiche().getDate());
			this.w.w("Le patient "+ p.getNom() + " "+p.getPrenom()+ " est entrée le : "+today + ".");
			ArrayList<Specialite> listSpe = p.getFiche().getListSpecialite();
			if (!listSpe.isEmpty()){
				this.w.w("En consultation pour : ");
				for (Specialite spec : listSpe){
					this.w.w(spec.getNom().toString());
					this.display.afficherCompteRenduSejour(s);
				}
			}
			else{
				this.w.w("Ce patient n'a pas de spécialité");
			}			
		}
		else{
			this.w.w("Il n'y a actuellement pas de fiche de séjour rattaché à ce patient.");
		}
	}


	/**
	 * effectue une consultation a un patient
	 */
	public void consultationBis() {
		this.w.ww("");
		Patient p = findPatient(false);
		if (p.getAge() > -1){
			if (this.display.afficherSpecialisteNecessaire(h,p)) {
				DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
				FicheDeSuivi f =new FicheDeSuivi(null, null);
				String strNomSpe = this.check.myScan("Indiquez le nom du spécialiste.");
				String strPrenomSpe = this.check.myScan("Indiquez le prenom du spécialiste.");
				Specialiste s = h.checkContainSpecialiste(strNomSpe, strPrenomSpe);
				if (s!= null) {
					if(p.getFiche() != null && p.getFiche().getListSpecialite().contains(s.getSpec())){			
						this.w.w("Affichage des anciens comptes rendus :");
						Sejour sejour = h.getSejour(p);
						f.setSejour(sejour);
						f.setSpecialite(s.getSpec());
						this.display.afficherCompteRendu(this.h.getComptesRendu(p, s.getSpec()));
						this.ajoutCompteRendu(f,s,sejour);
					}	
					else {
						this.w.w("La fiche de ce patient ne contient pas cette spécialité .");
					}
				}
				else {
					this.w.w("Spécialiste non trouvé");
				}
			}
		}
	}








	/**
	 * ajoute un compteRendu
	 * @param f fiche a ajouter
	 * @param s specialite du compte rendu
	 * @param sejour sejour durant lequel a ete realise le compte rendu
	 */
	public void ajoutCompteRendu(FicheDeSuivi f, Specialiste s,Sejour sejour){
		String desc = "";
		Date d1=null;
		boolean date=false;
		while(!date) {
			String str1 = this.check.myScan("Renseignez la date de redaction (DD/MM/YYYY)");
			DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			try{
				d1 = sdf.parse(str1);
				date=true;
			}	
			catch (ParseException e){
			}
		}
		desc = this.check.myScan("Renseignez la description de la consultation");
		ComptesRendu c = new ComptesRendu(d1, s, desc.trim());
		f.addContreRendu(c);
		sejour.addFicheDeSuivi(f);
	}


	/**
	 * effectue la sortie d'un patient de l hopital
	 */
	public void sortiePatient(){
		this.w.ww("");
		Patient p = this.findPatient(false);
		Date d1;
		if (p.getAge() > -1 && h.getSejour(p).getDateSortie()==false){
			try {
				boolean bool1 = false;
				while (!bool1) {
					String s = this.check.myScan("Indiquez la date de sortie du patient (DD/MM/YYYY) ");
					DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
					d1 = sdf.parse(s);
					if (d1.after(h.getSejour(p).getDateEntree())) {
						h.getSejour(p).setDateSortie(d1);
						bool1 = true;
						p.destroyFiche();
					}
					else 
						this.w.w("La date de sortie indiquée est antérieure à la date d'entrée.");
				}
			}	
			catch (ParseException e){
				this.w.w("Format de date incorrect.");		
			} 
		}
	}


	/**
	 * premet d indiquer une date d entree du patient
	 * @param p patient
	 * @return la date d entree
	 */
	public Date dateDeSejour( Patient p){
		String s = this.check.myScan("Indiquez la date d'entree (DD/MM/YYYY)");
		DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try{
			Date d1 = sdf.parse(s);
			this.h.createSejour(d1, p);
			return d1;
		}	
		catch (ParseException e){
			return null;
		}
	}






}
