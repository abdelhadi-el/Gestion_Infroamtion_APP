package com.provApp.gestionApp.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.util.Properties;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.SqlDateModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.provApp.gestionApp.models.DateLabelFormatter;
import com.provApp.gestionApp.models.InformationSetModel;

import lombok.Data;

@Component @Data @Scope("prototype")
public class InformationSet {

	InformationSetModel pageModel ;
	ApplicationContext appContext ;

	@Autowired
	public InformationSet( InformationSetModel modelPage ) {
		this.pageModel = modelPage ;		
		pageModel.getClickClassListener().page = this ;
		pageModel.getMouseClassListener().page = this ;
		initialize();
	}
	
private void initialize() {
		
		Border border = new EmptyBorder(20, 20, 30, 0); // raison de design
		JLabel modificationLabel = new JLabel("MODIFICATION DE DONNEES :");
		JPanel flowText0 = new JPanel(new GridBagLayout()) ;
		flowText0.setBackground(new Color(164, 164, 191));
		modificationLabel.setFont(new Font("Montserrat", Font.BOLD, 20));
		modificationLabel.setBorder(border);
		modificationLabel.setForeground(new Color(255, 255, 255));
		flowText0.add(modificationLabel);
		pageModel.setPrincipalContainer( new JPanel(new BorderLayout()) );
		pageModel.getPrincipalContainer().add(flowText0, BorderLayout.PAGE_START);
		pageModel.getPrincipalContainer().setBackground(new Color(242, 234, 237));
		
		JPanel panelContainerBorder = new JPanel(new BorderLayout()) ;
		panelContainerBorder.setBackground(new Color(153, 153, 255));
		pageModel.getPrincipalContainer().add(panelContainerBorder, BorderLayout.CENTER);
		
		JPanel panelContainerFlow = new JPanel(new FlowLayout()) ;
		panelContainerFlow.setSize(400,200);
		panelContainerFlow.setPreferredSize(new Dimension(160, 110));
		panelContainerFlow.setBackground(new Color(242, 234, 237)); //242
		
		JLabel whatUseToSelect = new JLabel("Selectionner les champs que vous voulez utiliser") ;
		JLabel whatUseToSelect2 = new JLabel("pour sélectionner la donnée désirée :") ;
		whatUseToSelect2.setFont(new Font(null, Font.BOLD, 14));
		whatUseToSelect.setFont(new Font(null, Font.BOLD, 14));
		pageModel.setCheckBox1( new JCheckBox("Numéro d'ordre") );
		pageModel.setCheckBox2( new JCheckBox("Date d'arrivée") );
		pageModel.setCheckBox3( new JCheckBox("Expéditeur") );
		pageModel.setCheckBox4( new JCheckBox("Objet ") );
		pageModel.setCheckBox5( new JCheckBox("Division") );
		panelContainerFlow.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
		panelContainerFlow.add(whatUseToSelect) ;
		panelContainerFlow.add(whatUseToSelect2) ;
		panelContainerFlow.add(pageModel.getCheckBox1()); panelContainerFlow.add(pageModel.getCheckBox2()); panelContainerFlow.add(pageModel.getCheckBox3()); panelContainerFlow.add(pageModel.getCheckBox4()); panelContainerFlow.add(pageModel.getCheckBox5());
		pageModel.setButtonMontrer( new JButton("montrer les champs") ) ;
		pageModel.getButtonMontrer().setBackground(new Color(136, 140, 70));
		pageModel.getButtonMontrer().setFont(new Font(null, Font.BOLD, 13));
		
		pageModel.getButtonMontrer().addMouseListener(pageModel.getMouseClassListener());
		
		panelContainerFlow.add(pageModel.getButtonMontrer()) ;
		
		panelContainerBorder.add(panelContainerFlow, BorderLayout.PAGE_START) ;
		pageModel.setContainerPanel1( new JPanel(new BorderLayout()) ) ; // responsible of the display of field choosed by JCheckBox ( in the actionListener )
		pageModel.getContainerPanel1().setBackground(new Color(242, 234, 237)); // 242
		panelContainerBorder.add(pageModel.getContainerPanel1(), BorderLayout.CENTER) ;
		
		pageModel.getButtonMontrer().addActionListener(pageModel.getClickClassListener()); 
		
		
		pageModel.setButtonReMontrer( new JButton("Rechoisir les champs à apparaître") );
		pageModel.getButtonReMontrer().addMouseListener(pageModel.getMouseClassListener());
		pageModel.getButtonReMontrer().setFont(new Font(null, Font.BOLD, 13));
		pageModel.getButtonReMontrer().setBackground(new Color(136, 140, 70));
		
		pageModel.setButtonChercher( new JButton("Chercher") ) ;
		pageModel.getButtonChercher().setFont(new Font(null, Font.BOLD, 13));
		pageModel.getButtonChercher().setBackground(new Color(136, 140, 70));
		
		pageModel.getButtonChercher().addMouseListener(pageModel.getMouseClassListener());
		pageModel.getButtonChercher().addActionListener(pageModel.getClickClassListener());
		
		pageModel.getButtonReMontrer().addActionListener(pageModel.getClickClassListener());
		
		pageModel.setPana( new JPanel(new GridBagLayout()) ); 
		GridBagConstraints gridBagConstraints0 = new GridBagConstraints(); 
		gridBagConstraints0.fill = GridBagConstraints.NONE ;
		gridBagConstraints0.weightx = 0.5;
		gridBagConstraints0.weighty = 0.5;
		gridBagConstraints0.gridx = 0;  
		gridBagConstraints0.gridy = 0; 
		gridBagConstraints0.anchor = GridBagConstraints.BASELINE_LEADING ;
		pageModel.getPana().setBackground(new Color(242, 234, 237));
		
		GridBagConstraints gridBagConstraints1 = new GridBagConstraints();  // for the the gridBagLayout 
		gridBagConstraints1.fill = GridBagConstraints.HORIZONTAL ; 
		gridBagConstraints1.gridx = 0;  
		gridBagConstraints1.gridy = 0; 
		gridBagConstraints1.weightx = 0.5;
		gridBagConstraints1.insets = new Insets(0,40,0,20) ;
		JPanel gridB =new JPanel( new GridBagLayout() ) ;
		gridB.setBackground(new Color(242, 234, 237));
		SqlDateModel model = new SqlDateModel();
		model.setSelected(true); // to set initial value !!! veeerry important
		Properties p = new Properties();
	    p.put("text.today", "Today");
	    p.put("text.month", "Month");
	    p.put("text.year", "Year");
		JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
		pageModel.setDatePickerForResult( new JDatePickerImpl(datePanel, new DateLabelFormatter()) );
		pageModel.getDatePickerForResult().setBackground(new Color(242, 234, 237));
		pageModel.getDatePickerForResult().getComponent(0).setFont(new Font(null, Font.BOLD, 12));
		pageModel.getDatePickerForResult().getComponent(1).setBackground(new Color(136, 140, 70));
		
		pageModel.getDatePickerForResult().getComponent(1).addMouseListener(pageModel.getMouseClassListener());
		pageModel.setText3( new JTextArea() ); pageModel.getText3().setFont(new Font(null, Font.BOLD, 12));
		pageModel.setText1( new JTextField() ) ; pageModel.setText5( new JTextField() ) ; 
		pageModel.getText1().setFont(new Font(null, Font.BOLD, 12)); pageModel.getText5().setFont(new Font(null, Font.BOLD, 12));
		pageModel.setText4( new JTextArea() ) ;  pageModel.getText4().setFont(new Font(null, Font.BOLD, 12));
		pageModel.setText1New( new JTextField() ) ;  pageModel.getText1New().setPreferredSize(new Dimension(150,40));
		pageModel.getText1New().setFont(new Font(null, Font.BOLD, 12));
		pageModel.getText4().setLineWrap(true);
		pageModel.getText3().setLineWrap(true);
		JScrollPane paneTextArea = new JScrollPane(pageModel.getText4()) ;
		JScrollPane paneTextArea1 = new JScrollPane(pageModel.getText3()) ;
		paneTextArea1.setViewportView(pageModel.getText3());
		paneTextArea1.setPreferredSize(new Dimension(150,40));
		paneTextArea.setViewportView(pageModel.getText4());
		paneTextArea.setPreferredSize(new Dimension(150,40));
		pageModel.setValiderUpdate( new JButton("Valider") );
		pageModel.getValiderUpdate().setFont(new Font(null, Font.BOLD, 13));
		pageModel.getValiderUpdate().setPreferredSize(new Dimension(150,40));
		pageModel.getValiderUpdate().setBackground(new Color(136, 140, 70));
		
		pageModel.getValiderUpdate().addMouseListener(pageModel.getMouseClassListener());
		pageModel.getValiderUpdate().addActionListener(pageModel.getClickClassListener());
		
		pageModel.getText1().setEditable(false);
		
		JLabel ordAnnuel1 = new JLabel("Numéro d'ordre annuel :");
		ordAnnuel1.setFont(new Font(null, Font.BOLD, 12));
		gridB.add(ordAnnuel1, gridBagConstraints1);
		gridBagConstraints1.gridx = 1; 
		pageModel.getText1().setPreferredSize(new Dimension(150,40));
		gridB.add(pageModel.getText1(), gridBagConstraints1) ; 
		JLabel ordAnnuel1New = new JLabel("Nouvelle valeur :");  ordAnnuel1New.setFont(new Font(null, Font.BOLD, 12));
		gridBagConstraints1.gridx = 2;
		gridB.add(ordAnnuel1New, gridBagConstraints1);
		gridBagConstraints1.gridx = 3;
		gridB.add(pageModel.getText1New(), gridBagConstraints1);
		
		gridBagConstraints1.gridx = 0;  
		gridBagConstraints1.gridy = 1; 
		JLabel dateArrivee = new JLabel("Date arrivée :");
		dateArrivee.setFont(new Font(null, Font.BOLD, 12));
		gridB.add(dateArrivee, gridBagConstraints1);
		gridBagConstraints1.gridx = 1;  
		gridB.add(pageModel.getDatePickerForResult(), gridBagConstraints1) ; 
		gridBagConstraints1.gridx = 0;  
		gridBagConstraints1.gridy = 2;
		JLabel designationLabel = new JLabel("Expéditeur :");
		designationLabel.setFont(new Font(null, Font.BOLD, 12));
		gridB.add(designationLabel, gridBagConstraints1);
		gridBagConstraints1.gridx = 1;
		gridB.add(paneTextArea1, gridBagConstraints1) ; 
		gridBagConstraints1.gridx = 0;  
		gridBagConstraints1.gridy = 3;
		JLabel analyseLabel = new JLabel("Objet :");
		analyseLabel.setFont(new Font(null, Font.BOLD, 12));
		gridB.add(analyseLabel, gridBagConstraints1);
		gridBagConstraints1.gridx = 1;
		gridB.add(paneTextArea, gridBagConstraints1) ; 
		gridBagConstraints1.gridx = 0;  
		gridBagConstraints1.gridy = 4;
		JLabel divisionLabel = new JLabel("Division :");
		divisionLabel.setFont(new Font(null, Font.BOLD, 12));
		gridB.add(divisionLabel, gridBagConstraints1);
		gridBagConstraints1.gridx = 1;
		gridB.add(pageModel.getText5(), gridBagConstraints1) ;
		
		pageModel.getDatePickerForResult().getComponent(0).setPreferredSize(new Dimension(115,40));pageModel.getDatePickerForResult().getComponent(1).setPreferredSize(new Dimension(30,40));
		pageModel.getText5().setPreferredSize(new Dimension(150,40));
		 pageModel.getPana().add(gridB, gridBagConstraints0); 
		 gridBagConstraints1.gridx = 2;  
		 gridBagConstraints1.gridy = 2; 
		gridBagConstraints1.anchor = GridBagConstraints.ABOVE_BASELINE_LEADING ;
		 gridB.add(pageModel.getValiderUpdate(), gridBagConstraints1);
		 
		pageModel.setContainerPanel2( new JPanel(new BorderLayout()) );
		pageModel.getContainerPanel1().setBackground(new Color(242, 234, 237));
		pageModel.setTableContainer( new JPanel(new GridLayout()) );
		pageModel.getTableContainer().setBorder(new EmptyBorder(50,0,40,0));
		pageModel.getTableContainer().setBackground(new Color(242, 234, 237));
	}
	
}
