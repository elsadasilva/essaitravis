package util;

import hopital.Hopital;
import hopital.Specialiste;
import hopital.Specialite;

public class InitializeHospital {

	public  Hopital init(){
		Hopital h = new Hopital();

		Specialite s1 = new Specialite("Cardiologie");
		Specialite s2 = new Specialite("Rhumatologie");
		Specialite s3 = new Specialite("Dermatologie");
		Specialite s4 = new Specialite("Gastro-entérologie");
		Specialite s5 = new Specialite("Imunologie");
		Specialite s6 = new Specialite("Orthopédie");
		Specialite s7 = new Specialite("Oncologie");

		Specialiste sp1 = new Specialiste("Dupont", "Charles", s1);
		Specialiste sp2 = new Specialiste("Duez", "Henri", s1);
		Specialiste sp3 = new Specialiste("Zola", "Paul", s2);
		Specialiste sp4 = new Specialiste("Voltaire", "Emile", s2);
		Specialiste sp5 = new Specialiste("Aznavoure", "Zola", s3);
		Specialiste sp6 = new Specialiste("Halliday", "Lola", s3);
		Specialiste sp7 = new Specialiste("Clerbout", "Péneloppe", s4);
		Specialiste sp8 = new Specialiste("Messi", "Matisse", s4);
		Specialiste sp9 = new Specialiste("Ronaldo", "Chris", s5);
		Specialiste sp10 = new Specialiste("Zidane", "Zizou", s5);
		Specialiste sp11 = new Specialiste("Mitterant", "Denis", s6);
		Specialiste sp12 = new Specialiste("Polnaref", "Matthieu", s6);
		Specialiste sp13 = new Specialiste("Golman", "Clarc", s7);

		s1.addSpecialiste(sp1);
		s1.addSpecialiste(sp2);		
		s2.addSpecialiste(sp3);
		s2.addSpecialiste(sp4);
		s3.addSpecialiste(sp5);
		s3.addSpecialiste(sp6);
		s4.addSpecialiste(sp7);
		s4.addSpecialiste(sp8);
		s5.addSpecialiste(sp9);
		s5.addSpecialiste(sp10);
		s6.addSpecialiste(sp11);
		s6.addSpecialiste(sp12);
		s7.addSpecialiste(sp13);

		h.addSpecialiste(sp1);
		h.addSpecialiste(sp2);		
		h.addSpecialiste(sp3);
		h.addSpecialiste(sp4);
		h.addSpecialiste(sp5);
		h.addSpecialiste(sp6);
		h.addSpecialiste(sp7);
		h.addSpecialiste(sp8);
		h.addSpecialiste(sp9);
		h.addSpecialiste(sp10);
		h.addSpecialiste(sp11);
		h.addSpecialiste(sp12);
		h.addSpecialiste(sp13);

		h.addSpecialite(s1);
		h.addSpecialite(s2);		
		h.addSpecialite(s3);
		h.addSpecialite(s4);
		h.addSpecialite(s5);
		h.addSpecialite(s6);
		h.addSpecialite(s7);

		return h;
	}

}
