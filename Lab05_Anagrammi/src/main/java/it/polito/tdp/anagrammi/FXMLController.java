package it.polito.tdp.anagrammi;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.anagrammi.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	private Model model;
	private String parola;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField parolaTxt;

    @FXML
    private Button calcolaAnagrammibtn;

    @FXML
    private TextArea anagrammiCorrettitxt;

    @FXML
    private TextArea anagrammiErratitxt;

    @FXML
    private Button resetbtn;

    @FXML
    void doCalcolaAnagrammi(ActionEvent event) {
    	 anagrammiCorrettitxt.clear();
         anagrammiErratitxt.clear();
         parola= parolaTxt.getText();
         if(parola.toLowerCase().matches("[a-z]+")||parola!="") {
         model.doAnagrammi(parola);
         System.out.println("check");
         for(String s:model.getAnagrammiCorretti()) {
         anagrammiCorrettitxt.appendText(s+"\n");
         }
         for(String s:model.getAnagrammiErrati()) {
         anagrammiErratitxt.appendText(s+"\n");
         }
         }
         else {
        	 anagrammiCorrettitxt.setText("Devi inserire una parola composta solo da caratteri");
         }
      
    }

    @FXML
    void doReset(ActionEvent event) {
     anagrammiCorrettitxt.clear();
     anagrammiErratitxt.clear();
     parolaTxt.clear();
    }

    @FXML
    void initialize() {
        assert parolaTxt != null : "fx:id=\"parolaTxt\" was not injected: check your FXML file 'Scene.fxml'.";
        assert calcolaAnagrammibtn != null : "fx:id=\"calcolaAnagrammibtn\" was not injected: check your FXML file 'Scene.fxml'.";
        assert anagrammiCorrettitxt != null : "fx:id=\"anagrammiCorrettitxt\" was not injected: check your FXML file 'Scene.fxml'.";
        assert anagrammiErratitxt != null : "fx:id=\"anagrammiErratitxt\" was not injected: check your FXML file 'Scene.fxml'.";
        assert resetbtn != null : "fx:id=\"resetbtn\" was not injected: check your FXML file 'Scene.fxml'.";

    }

	public void setModel(Model model) {
		// TODO Auto-generated method stub
		this.model=model; 
	}
}
