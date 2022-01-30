package com.provApp.gestionApp.models;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.provApp.gestionApp.controlleurs.ModifierPersonnelClickListener;
import com.provApp.gestionApp.controlleurs.ModifierPersonnelMouseListener;

import lombok.Data;
import lombok.NoArgsConstructor;

@Component @NoArgsConstructor @Data
public class ModifierPersonnelModel {

	int compteur  ;
	JCheckBox checkBox1, checkBox2, checkBox3 /* , checkBox4, checkBox5 */;  
	JButton buttonMontrer ;
	JTextField ordAnnuelTextField ;
	//JDatePickerImpl datePicker ;
	JTextField designationTextField ;
	JTextField analyseTextField ;
	JTextField divisionTextField ;
	JPanel containerPanel2 = null ;
	JPanel principalContainer ;
	JPanel containerPanel1 ;
	JButton buttonReMontrer ;
	JButton buttonChercher ;
	JTable table ;
	JComboBox<String> listeDeroulantFirst ;
	JComboBox<String> listeDeroulant ;
	JTextField text1 /* , text5  */;
	JTextArea text3, text4 ;
	JButton validerUpdate ;
	JTextField text1New ;
	JPanel pana ;
	JPanel tableContainer ;	
	ModifierPersonnelClickListener clickClassListener ;
	ModifierPersonnelMouseListener mouseClassListener ;
	
	@Autowired
	public ModifierPersonnelModel(ModifierPersonnelClickListener clickClassListener,
			ModifierPersonnelMouseListener mouseClassListener) {
		super();
		this.clickClassListener = clickClassListener;
		this.mouseClassListener = mouseClassListener;
	}
}
