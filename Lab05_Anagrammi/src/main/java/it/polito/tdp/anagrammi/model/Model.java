package it.polito.tdp.anagrammi.model;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import it.polito.tdp.anagrammi.DAO.AnagrammiDAO;

public class Model {
	
	
	private Set<String> anagrammiCorretti;
	private Set<String> anagrammiErrati;

	public void doAnagrammi(String parola) {
		// TODO Auto-generated method stub
		anagrammiCorretti = new HashSet<String>();
		anagrammiErrati = new HashSet<String>();
		generaAnagrammiRicorsivo("",parola,0);
	}

	private void generaAnagrammiRicorsivo(String parziale,String parola,int livello) {
		// TODO Auto-generated method stub
		if(parola.length()==0) {
			if(AnagrammiDAO.checkAnagram(parziale)) {
				System.out.println("check");
				anagrammiCorretti.add(parziale);
			}
			else {
				anagrammiErrati.add(parziale);
			}
			
		}
		else {
			for(int i=0;i<parola.length();i++) {
			
			char tentativo = parola.charAt(i);
			
			String nuovaParziale = parziale+ tentativo;//così non vado a modificare tentativo e non devo fare il backtracking
			String nuovaParola = parola.substring(0,i)+parola.substring(i+1);
			generaAnagrammiRicorsivo(nuovaParziale,nuovaParola,livello+1);
			
			}
		
		
		
		}
	}

	public Set<String> getAnagrammiCorretti() {
		System.out.println("check");
		return anagrammiCorretti;
		
	}

	public Set<String> getAnagrammiErrati() {
		return anagrammiErrati;
	}


	

}
