package com.provApp.gestionApp.models;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.jdatepicker.impl.JDatePickerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.provApp.gestionApp.controlleurs.InformationAddClickListener;
import com.provApp.gestionApp.controlleurs.InformationAddMouseListener;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor @Component @Data
public class InformationAddModel {

	JPanel principalContainer ;
	JDatePickerImpl datePicker ;
	JButton commitButton ;
	JTextField ordAnnuelTextField ;
	JTextField designationTextField ;
	JTextField analyseTextField  ;
	JTextField divisionTextField ;
	InformationAddClickListener clickClassListener ;
	InformationAddMouseListener mouseClassListener ;
	
	@Autowired
	public InformationAddModel(InformationAddClickListener clickClassListener,InformationAddMouseListener mouseClassListener) {
		super();
		this.clickClassListener = clickClassListener;
		this.mouseClassListener = mouseClassListener;
	}
	
	
}
