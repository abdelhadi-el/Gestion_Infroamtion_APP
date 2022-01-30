package com.provApp.gestionApp.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.SqlDateModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.provApp.gestionApp.models.DateLabelFormatter;
import com.provApp.gestionApp.models.InformationAddModel;

import lombok.Data;

@Component @Data  @Scope("prototype")
public class InformationAdd {

	InformationAddModel modelPage ;
	ApplicationContext appContext ;

	@Autowired
	public InformationAdd( InformationAddModel modelP ) {
		this.modelPage = modelP ;
		modelPage.getClickClassListener().page = this ;
		modelPage.getMouseClassListener().page = this ;
		
		initialize();
	}	
	
	
	private void initialize() {
		
		Border border = new EmptyBorder(20, 20, 30, 0); // raison de design
		JPanel flowText0 = new JPanel(new GridBagLayout()) ;
		flowText0.setBackground(new Color(164, 164, 191));
		JLabel modificationLabel = new JLabel("AJOUT DE DONNEES :");
		modificationLabel.setFont(new Font("Montserrat", Font.BOLD, 20));
		modificationLabel.setBorder(border);
		modificationLabel.setForeground(new Color(255, 255, 255));
		modelPage.setPrincipalContainer( new JPanel(new BorderLayout()) );
		flowText0.add(modificationLabel) ;
		modelPage.getPrincipalContainer().add(flowText0, BorderLayout.PAGE_START) ;
		modelPage.getPrincipalContainer().setBackground(new Color(242, 234, 237));
		
		Border titledBorderMargin = new EmptyBorder(30, 35, 0, 35);  // a supp
		JPanel container = new JPanel(new GridBagLayout()) ; // null is the borderLayout
		container.setBorder(titledBorderMargin);
		container.setBackground(new Color(242, 234, 237)); 
		JPanel panel = new JPanel(new GridBagLayout()); 
		panel.setPreferredSize(new Dimension(600, 400));
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(22, 35, 90), new Color(242, 234, 237)), "Informations", TitledBorder.LEADING, TitledBorder.TOP, new Font(null, Font.BOLD, 14), new Color(42, 52, 87)));
		panel.setBackground(new Color(242, 234, 237));
		GridBagConstraints gridBagConstraints0 = new GridBagConstraints(); 
		gridBagConstraints0.fill = GridBagConstraints.NONE ;
		gridBagConstraints0.weightx = 0.5;
		gridBagConstraints0.weighty = 0.5;
		gridBagConstraints0.gridy = 0; 
		gridBagConstraints0.anchor = GridBagConstraints.PAGE_START ;
		container.add(panel, gridBagConstraints0) ;
		modelPage.getPrincipalContainer().add(container, BorderLayout.CENTER);
		
		GridBagConstraints gridBagConstraints = new GridBagConstraints();  // for the the gridBagLayout 
		gridBagConstraints.fill = GridBagConstraints.HORIZONTAL ; 
		gridBagConstraints.gridx = 0;  
		gridBagConstraints.gridy = 0; 
		gridBagConstraints.weightx = 0.5;
		gridBagConstraints.insets = new Insets(0,0,10,0) ;
		
		// remplissage du titled border ( panel ) it's a gridLayout(4,4)
		JLabel ordAnnuel = new JLabel("Numéro d'ordre annuel :");
		ordAnnuel.setFont(new Font(null, Font.BOLD, 14));
		panel.add(ordAnnuel, gridBagConstraints);
		
			gridBagConstraints.gridx = 1;  
			gridBagConstraints.gridy = 0;
		modelPage.setOrdAnnuelTextField( new JTextField() );
		modelPage.getOrdAnnuelTextField().setFont(new Font(null, Font.BOLD, 12));
		panel.add(modelPage.getOrdAnnuelTextField(), gridBagConstraints);

			gridBagConstraints.gridx = 0;  
			gridBagConstraints.gridy = 1;
		JLabel dateArrivee = new JLabel("Date arrivée :");
		dateArrivee.setFont(new Font(null, Font.BOLD, 14));
		panel.add(dateArrivee, gridBagConstraints);
			gridBagConstraints.gridx = 1;  
			gridBagConstraints.gridy = 1;
			gridBagConstraints.fill = GridBagConstraints.HORIZONTAL ; 

		// date field
		SqlDateModel model = new SqlDateModel();
		Properties p = new Properties();
	    p.put("text.today", "Today");
	    p.put("text.month", "Month");
	    p.put("text.year", "Year");
		JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
		modelPage.setDatePicker( new JDatePickerImpl(datePanel, new DateLabelFormatter()) );
		modelPage.getDatePicker().setBackground(new Color(242, 234, 237));
		modelPage.getDatePicker().getComponent(0).setFont(new Font(null, Font.BOLD, 12));
		modelPage.getDatePicker().getComponent(1).setBackground(new Color( 136, 140, 70 ));
		modelPage.getDatePicker().setPreferredSize(new Dimension(150, 50));
		
		modelPage.getDatePicker().getComponent(1).addMouseListener(modelPage.getMouseClassListener()) ;
		
		panel.add(modelPage.getDatePicker(), gridBagConstraints);
		
			gridBagConstraints.gridx = 0;  
			gridBagConstraints.gridy = 2;
		JLabel designationLabel = new JLabel("Expéditeur :");
		designationLabel.setFont(new Font(null, Font.BOLD, 14));
		panel.add(designationLabel, gridBagConstraints); 
			gridBagConstraints.gridx = 1;  
			gridBagConstraints.gridy = 2;
		modelPage.setDesignationTextField( new JTextField() );
		modelPage.getDesignationTextField().setFont(new Font(null, Font.BOLD, 12));
		panel.add(modelPage.getDesignationTextField(), gridBagConstraints);
		
			gridBagConstraints.gridx = 0;  
			gridBagConstraints.gridy = 3;
		JLabel analyseLabel = new JLabel("Objet :");
		analyseLabel.setFont(new Font(null, Font.BOLD, 14));
		panel.add(analyseLabel, gridBagConstraints);
			gridBagConstraints.gridx = 1;  
			gridBagConstraints.gridy = 3;
		modelPage.setAnalyseTextField( new JTextField() );
		modelPage.getAnalyseTextField().setFont(new Font(null, Font.BOLD, 12));
		panel.add(modelPage.getAnalyseTextField(), gridBagConstraints);
	
			gridBagConstraints.gridx = 0;  
			gridBagConstraints.gridy = 4;
		JLabel divisionLabel = new JLabel("Division :");
		divisionLabel.setFont(new Font(null, Font.BOLD, 14));
		panel.add(divisionLabel, gridBagConstraints);
			gridBagConstraints.gridx = 1;  
			gridBagConstraints.gridy = 4;
		modelPage.setDivisionTextField( new JTextField() );
		modelPage.getDivisionTextField().setFont(new Font(null, Font.BOLD, 12));
		panel.add(modelPage.getDivisionTextField(), gridBagConstraints);
	
		modelPage.setCommitButton( new JButton("Valider") );
		
		modelPage.getCommitButton().addMouseListener(modelPage.getMouseClassListener());

		modelPage.getCommitButton().setFont(new Font(null, Font.BOLD, 14));
		modelPage.getCommitButton().setBackground(new Color( 136, 140, 70 ));
 		modelPage.getCommitButton().setPreferredSize(new Dimension(140,36));  
	
		gridBagConstraints0.gridy = 1; 
		container.add(modelPage.getCommitButton(), gridBagConstraints0);

		modelPage.getCommitButton().addActionListener( modelPage.getClickClassListener() );


	}
}