package com.provApp.gestionApp.models;

import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.provApp.gestionApp.controlleurs.RechercherPersonnelClickListener;
import com.provApp.gestionApp.controlleurs.RechercherPersonnelMouseListener;

import lombok.Data;
import lombok.NoArgsConstructor;

@Component @NoArgsConstructor
@Scope("prototype") @Data
public class RechercherPersonnelModel {
		
		JPanel panel_container ;
		JPanel fl ;
		JPanel panel = new JPanel() ;
		JPanel tableContainer = null ;
		JPanel principalContainer ;
		JTable table = new JTable() ;
		JPanel pana = new JPanel(new GridBagLayout()) ; 
		JTextField NumOrderAnnuel  ;
		JTextField designationField ;
		JComboBox<String> listeDeroulant ;
		JComboBox<String> listeDeroulant1 ;
		JButton rechAllInfo  ;
		JButton rechInfo  ;
		JButton rechInfoDesignation ;
		JButton rechInfodivision  ;
		JButton supprimer ;
		JTextArea text3  ; 
		JTextField text1,text5 ; 
		JTextArea text4  ;
		RechercherPersonnelClickListener clickClassListener ;
		RechercherPersonnelMouseListener mouseClassListener ;
		
		@Autowired
		public RechercherPersonnelModel(RechercherPersonnelClickListener clickClassListener,
				RechercherPersonnelMouseListener mouseClassListener) {
			super();
			this.clickClassListener = clickClassListener;
			this.mouseClassListener = mouseClassListener;
		}
}
