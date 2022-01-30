package com.provApp.gestionApp.models;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.jdatepicker.impl.JDatePickerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.provApp.gestionApp.controlleurs.InformationSetClickListener;
import com.provApp.gestionApp.controlleurs.InformationSetMouseListener;

import lombok.Data;
import lombok.NoArgsConstructor;

@Component @NoArgsConstructor @Data
public class InformationSetModel {

	int compteur  ;
	JCheckBox checkBox1, checkBox2, checkBox3, checkBox4, checkBox5 ;  
	JButton buttonMontrer ;
	JTextField ordAnnuelTextField ;
	JDatePickerImpl datePicker ;
	JTextField designationTextField ;
	JTextField analyseTextField ;
	JTextField divisionTextField ;
	JPanel containerPanel2 = null ;
	JPanel principalContainer ;
	JPanel containerPanel1 ;
	JButton buttonReMontrer ;
	JButton buttonChercher ;
	JTable table ;
	JTextField text1, text5 ;
	JTextArea text3, text4 ;
	JDatePickerImpl datePickerForResult ;
	JButton validerUpdate ;
	JTextField text1New ;
	JPanel pana ;
	JPanel tableContainer ;
	InformationSetClickListener clickClassListener ;
	InformationSetMouseListener mouseClassListener ;
	
	@Autowired
	public InformationSetModel(InformationSetClickListener clickClassListener,
			InformationSetMouseListener mouseClassListener) {
		super();
		this.clickClassListener = clickClassListener;
		this.mouseClassListener = mouseClassListener;
	}
}
