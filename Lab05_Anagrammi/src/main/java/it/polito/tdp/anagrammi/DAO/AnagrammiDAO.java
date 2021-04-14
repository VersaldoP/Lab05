package it.polito.tdp.anagrammi.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AnagrammiDAO {

	public static boolean checkAnagram(String parziale) {
		
		final String sql="SELECT p.nome "+
				"FROM  parola p "+
				"WHERE p.nome= ?";
	     try {
	    	 Connection conn= ConnectDB.getConnection();
	    	 PreparedStatement st = conn.prepareStatement(sql);
	    	 st.setString(1,parziale);
	    	 ResultSet rs= st.executeQuery();
	    	 if(rs.next()) {
	    		 rs.close();
	    		 st.close();
	    		 conn.close();
	    		 return true;
	    		
	    		 
	    	 }
	    	 else {
	    		 rs.close();
	    		 st.close();
	    		 conn.close();
	    		 return false;
	    	 }
	     }
	     catch (SQLException e) {
				// e.printStackTrace();
				throw new RuntimeException("Errore Db", e);
			}
		
	}

}
