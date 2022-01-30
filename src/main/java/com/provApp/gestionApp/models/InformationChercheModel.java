package com.provApp.gestionApp.models;

import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.jdatepicker.impl.JDatePickerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.provApp.gestionApp.controlleurs.InformationChercheClickListener;
import com.provApp.gestionApp.controlleurs.InformationChercheMouseListener;

import lombok.Data;
import lombok.NoArgsConstructor;

@Component @NoArgsConstructor @Data
public class InformationChercheModel {
	
	JPanel panel_container ;
	JPanel fl ;
	JPanel panel = new JPanel() ;
	JPanel tableContainer = null ;
	JPanel principalContainer ;
	JTable table = new JTable() ;
	JPanel pana = new JPanel(new GridBagLayout()) ; 
	JTextField NumOrderAnnuel  ;
	JTextField designationField ;
	JTextField divisionField ;
	JDatePickerImpl datePicker ;
	JDatePickerImpl datePicker1 ;
	JComboBox<String> listeDeroulant ;
	JButton rechAllInfo  ;
	JButton rechInfo  ;
	JButton rechInfoDate ;
	JButton rechInfoDesignation ;
	JButton rechInfodivision  ;
	JButton supprimer ;
	JTextArea text3  ; 
	JTextField text1,text2 ,text5 ; 
	JTextArea text4  ;
	InformationChercheClickListener clickClassListener ;
	InformationChercheMouseListener mouseClassListener ;

	@Autowired
	public InformationChercheModel(InformationChercheClickListener clickClassListener,
			InformationChercheMouseListener mouseClassListener) {
		super();
		this.clickClassListener = clickClassListener;
		this.mouseClassListener = mouseClassListener;
	} 
	
	
}
