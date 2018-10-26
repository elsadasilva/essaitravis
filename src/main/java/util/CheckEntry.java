package util;

import java.awt.Dimension;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

import graphic.SimpleInputDialog;

public class CheckEntry {


	public CheckEntry() {
		new Write();
	}


	public String myScan(String s){
		SimpleInputDialog jop = new SimpleInputDialog(null, true,s);
		UIManager.put("OptionPane.minimumSize",new Dimension(200,200));
		String nom ="";
		nom = jop.getResult();
		return nom.trim();
	}

	public boolean testInt(String str){
		try{
			Integer.parseInt(str.trim());
			return true;
		}
		catch (Exception e){
			return false;
		}
	}


	public boolean testNum(String cq){
		Pattern pattern = Pattern.compile("^([1-37-8])([0-9]{2})(0[0-9]|[2-35-9][0-9]|[14][0-2])((0[1-9]|[1-8][0-9]|9[0-69]|2[abAB])(00[1-9]|0[1-9][0-9]|[1-8][0-9]{2}|9[0-8][0-9]|990)|(9[78][0-9])(0[1-9]|[1-8][0-9]|90))([0-9]{3})([0-8][0-9]|9[0-7])");
		Matcher matcher = pattern.matcher(cq);	
		if (matcher.find() && cq.length() == 15){
			return true;				}
		else{
			return false;
		}
	}


}
