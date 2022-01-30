package com.provApp.gestionApp.models;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.provApp.gestionApp.controlleurs.AjouterPersonnelClickListener;
import com.provApp.gestionApp.controlleurs.AjouterPersonnelMouseListener;

import lombok.Data;
import lombok.NoArgsConstructor;

@Component @NoArgsConstructor @Data
public class AjouterPersonnelModel {

	JPanel principalContainer ;
	JButton commitButton ;
	JTextField ordAnnuelTextField ;
	JTextField designationTextField ;
	JTextField analyseTextField  ;
	JComboBox<String> listeDeroulant ;
	AjouterPersonnelClickListener clickClassListener ;
	AjouterPersonnelMouseListener mouseClassListener ;
	
	@Autowired
	public AjouterPersonnelModel(AjouterPersonnelClickListener clickClassListener,
			AjouterPersonnelMouseListener mouseClassListener) {
		super();
		this.clickClassListener = clickClassListener;
		this.mouseClassListener = mouseClassListener;
	}	
}
