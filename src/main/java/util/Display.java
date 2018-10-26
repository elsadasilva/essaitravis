package util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import hopital.ComptesRendu;
import hopital.FicheDeSejour;
import hopital.FicheDeSuivi;
import hopital.Hopital;
import hopital.Patient;
import hopital.Sejour;
import hopital.Specialiste;
import hopital.Specialite;

public class Display {

	private Write w;
	private CheckEntry check;
	private IterList iter;
	private DateFormat formatter;

	public Display() {
		this.w=new Write();
		this.check=new CheckEntry();
		formatter = new SimpleDateFormat("dd/MM/yyyy");
	}


	/**
	 * Affiche le menu pour l'utilisateur
	 */
	public void afficheHomonyme(IterList<Patient> it, boolean b){
		int i = 1;
		it.init();
		while(it.hasNext()){
			Patient p=it.next();
			this.w.w(i + ". " + p.getPrenom() + " " + p.getNom() + " " + p.getAdresse() + " " + p.getNumSecu());
			i++;
		}
		if (b)
			this.w.w(i + ". Nouveau patient");
		this.w.w("Indiquez le choix du patient.");
	}

	public void afficheDonneesPatient(Patient p){
		this.w.w("");
		this.w.w("Patient : " +p.getPrenom() + " " + p.getNom());
		this.w.w("Adresse : " + p.getAdresse());
		this.w.w("Age : " + p.getAge());
		this.w.w("Numéro de SS : " + p.getNumSecu());
		this.w.w("");
	}


	public void afficheFicheSejour(Patient p,Hopital h) {
		FicheDeSejour f=p.getFiche();
		Sejour s = h.getSejour(p);
		afficheDonneesPatient(p);
		this.w.w("");
		this.w.w("Date d'entrée : " +formatter.format(f.getDate()));
		ArrayList<Specialite> listSpe = p.getFiche().getListSpecialite();
		if (!listSpe.isEmpty()){
			this.w.w("En consultation pour : ");
			for (Specialite spec : listSpe){
				this.w.w(spec.getNom().toString());
				afficherCompteRendu(h.getComptesRendu(p, spec));
			}
		}
		else{
			this.w.w("Ce patient n'a pas de spécialité");
		}	
	}





	public void afficheSpecialite(Patient p ,Hopital h){
		ArrayList<Specialite> list = h.getlistSpecialite();
		ArrayList<Specialite> listChoix = new ArrayList<Specialite>();
		this.w.w("Voici la liste des spécialités de l'hopital. Indiquez celle que vous desirez");
		String str = "0";
		int i= 1 ;
		IterList iter2=new IterList<Specialite>();
		iter2.setList(h.getlistSpecialite());
		while(iter2.hasNext()) {
			Specialite s=(Specialite) iter2.next();
			this.w.w(i +". " + s.getNom().toString());
			i++;
		}
		this.w.w(i +". Quitter");		
		while (Integer.parseInt(str)!=i){
			boolean bool = false ;
			while (!bool){
				str = this.check.myScan("Insérer votre choix");
				if (this.check.testInt(str)){
					bool = true;
				}
			}
			if (Integer.parseInt(str)>=1 && list.size() >= Integer.parseInt(str)){
				listChoix.add(list.get(Integer.parseInt(str)-1));
				this.w.w("Ajouté :" + (list.get(Integer.parseInt(str)-1).getNom().toString()));
			}
		}
		p.getFiche().setListSpecialite(listChoix);	
		this.w.ww("");
	}




	public boolean afficherSpecialisteNecessaire(Hopital h, Patient p) {
		IterList iter2=new IterList<Specialiste>();
		iter2.setList(h.getlistSpecialiste());
		this.w.w("Liste des Spécialiste :");
		if (p.getFiche().getListSpecialite().isEmpty()) {
			this.w.w("Aucune spécialité trouvé pour ce patient");
			return false;
		}
		else {
			while(iter2.hasNext()) {
				Specialiste s=(Specialiste) iter2.next();
				if (p.getFiche().getListSpecialite().contains(s.getSpec()))
					this.w.w("- Dr  " +s.getNom() + " "+s.getPrenom()+" -  "+s.getSpec().getNom());
			}
			return true;
		}
	}




	public void afficherCompteRenduSejour(Sejour s){
		this.iter=new IterList<FicheDeSuivi>();
		this.iter.setList(s.getListFicheDeSuivi()); 
		if(iter.size()>0) {
			while(iter.hasNext()) {
				FicheDeSuivi suivi=(FicheDeSuivi) iter.next();		
				this.w.w("Liste des comptes rendu pour : " +suivi.getSpecialite().getNom().toString());
				IterList itercompte=new IterList<ComptesRendu>();
				itercompte.setList(suivi.getListContreRendu());
				while(itercompte.hasNext()){
					ComptesRendu cpt=(ComptesRendu) itercompte.next();
					this.w.w("Compte rendu du : " + formatter.format(cpt.getDate()));
					this.w.w("Rédigé par : "+ cpt.getNom().getNom().toString());
					this.w.w(cpt.getDescriptif());
				}
			}
		}
		else {
			this.w.w("");
			this.w.w("La patient n'a encore effectué aucune consultation ");
			this.w.w("");
		}
	}


	public void afficherCompteRendu(ArrayList<ComptesRendu> cpt){
		this.iter=new IterList<ComptesRendu>();
		this.iter.setList(cpt); 
		if(iter.size()>0) {
			while(iter.hasNext()) {
				ComptesRendu r =(ComptesRendu) iter.next();		
				this.w.w("Liste des comptes rendu pour : " + r.getNom().getSpec().getNom().toString());
				this.w.w("Compte rendu du : " + formatter.format(r.getDate()));
				this.w.w("Rédigé par : "+ r.getNom().getNom().toString());
				this.w.w(r.getDescriptif());
			}
		}
		else {
			this.w.w("");
			this.w.w("La patient n'a encore effectué aucune consultation ");
			this.w.w("");

		}
	}





}
