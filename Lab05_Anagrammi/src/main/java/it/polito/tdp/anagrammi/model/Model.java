package it.polito.tdp.anagrammi.model;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import it.polito.tdp.anagrammi.DAO.AnagrammiDAO;

public class Model {
	
	
	private Set<String> anagrammiCorretti;
	private Set<String> anagrammiErrati;
	private Set<String> anagrammi;
	private AnagrammiDAO aDAO= new AnagrammiDAO();
	

	public void doAnagrammi(String parola) {
		// TODO Auto-generated method stub
		anagrammiCorretti = new HashSet<String>();
		anagrammiErrati = new HashSet<String>();
		anagrammi = new HashSet<String>();
		generaAnagrammiRicorsivo("",parola,0);
		for(String s:anagrammi) {
		if(aDAO.checkAnagram(s)) {
			System.out.println("check");
			anagrammiCorretti.add(s);
		}
		else {
			anagrammiErrati.add(s);
		}
		}
		
		
	}

	private void generaAnagrammiRicorsivo(String parziale,String parola,int livello) {
		// TODO Auto-generated method stub
		//soluzioone alternativa mettere un int con il passo per vedere a che punto siamo della parola e vedere se il counter ha dimensione = parola di cui si cercano gli anagrammi
		if(parola.length()==0) {
			
			anagrammi.add(parziale);
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

		return anagrammiCorretti;
		
	}

	public Set<String> getAnagrammiErrati() {
		return anagrammiErrati;
	}


	

}
