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

import javax.swing.JButton;
import javax.swing.JComboBox;
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
import com.provApp.gestionApp.models.InformationChercheModel;

import lombok.Data;

@Component @Data @Scope("prototype") 
public class InformationCherche {

	InformationChercheModel pageModel ;
	ApplicationContext appContext ;
	
@Autowired
	public InformationCherche( InformationChercheModel modelP ) {
		this.pageModel = modelP ;
		pageModel.getClickClassListener().page = this ;
		pageModel.getMouseClassListener().page = this ;
		
		initialize();
	}
	
	private void initialize() {
		
		JPanel flowText = new JPanel(new FlowLayout()) ;
		JLabel labelOfSearch1 = new JLabel(" Entrez le numéro d'ordre annuel que vous désirez rechercher : ");
		flowText.setPreferredSize(new Dimension( 300, 70 ));
		labelOfSearch1.setFont(new Font(null, Font.BOLD, 14));
		flowText.setBorder(new EmptyBorder(40, 0, 0, 0)); // the buttom is not working
		flowText.add(labelOfSearch1); // flowText.add(labelOfSearch2);
		pageModel.setPrincipalContainer( new JPanel(new BorderLayout()) );
		Border border0 = new EmptyBorder(20, 20, 30, 0);
		JLabel labelOfSearch0 = new JLabel("RECHERCHE DE DONNEES : ");
		labelOfSearch0.setFont(new Font("Montserrat", Font.BOLD, 20));
		labelOfSearch0.setForeground(new Color(255, 255, 255));
		labelOfSearch0.setBorder(border0);
		JPanel flowText0 = new JPanel(new GridBagLayout()) ;
		flowText0.setBackground(new Color(164, 164, 191));
		flowText0.add(labelOfSearch0) ;
		pageModel.getPrincipalContainer().add(flowText0, BorderLayout.PAGE_START) ; 
		
		pageModel.setNumOrderAnnuel( new JTextField() );
		
		JLabel whatToUpdate = new JLabel("Sélectionner le critère de sélection à activer:") ;
		whatToUpdate.setFont(new Font(null, Font.BOLD, 14));
		String champs[]={"","Numéro d'ordre","Date d'arrivée","Expéditeur","Division", "Tous"}; 

		pageModel.setListeDeroulant( new JComboBox<>(champs) );
		Color colo = new Color(136, 140, 60) ;
		pageModel.getListeDeroulant().setBackground(colo);
		
		pageModel.getListeDeroulant().addMouseListener(pageModel.getMouseClassListener());
		pageModel.getListeDeroulant().addActionListener(pageModel.getClickClassListener());
		
		GridBagConstraints gridBagConstraints = new GridBagConstraints(); 
		gridBagConstraints.fill = GridBagConstraints.BOTH ;
		gridBagConstraints.gridx = 0;  
		gridBagConstraints.gridy = 0; 
		gridBagConstraints.weightx = 0.5;
		gridBagConstraints.weighty = 0.5 ;
		gridBagConstraints.insets = new Insets(30,0,0,0) ;
		pageModel.setPanel_container( new JPanel() );		
		pageModel.getPanel_container().setLayout(new GridBagLayout());
		
		pageModel.getPanel_container().add(whatToUpdate, gridBagConstraints) ;
		gridBagConstraints.fill = GridBagConstraints.NONE ;
		gridBagConstraints.gridx = 1;
		pageModel.getListeDeroulant().setPreferredSize(new Dimension(165,36));
		pageModel.getListeDeroulant().setBackground(colo);
		pageModel.getListeDeroulant().setFont(new Font("Arial", Font.CENTER_BASELINE, 12));
		pageModel.getPanel_container().add(pageModel.getListeDeroulant(), gridBagConstraints) ;
		
		Border border = new EmptyBorder(0, 30, 0, 30);   //raison de design 
		 // for the the gridBagLayout 
		gridBagConstraints.insets = new Insets(30,40,0,0) ;
		gridBagConstraints.gridx = 0;  
		gridBagConstraints.gridy = 1; 
		gridBagConstraints.gridwidth = 2;
		gridBagConstraints.weightx = 0.5;
		gridBagConstraints.weighty = 0.5 ;
		pageModel.setFl( new JPanel(new BorderLayout()) );
		pageModel.getFl().setPreferredSize(new Dimension(500,100));
		pageModel.getFl().setBackground(new Color(242, 234, 237));
		
		gridBagConstraints.fill = GridBagConstraints.BOTH ;
		pageModel.getPanel_container().setBorder(border);
		pageModel.getPanel_container().setBackground(new Color(242, 234, 237));
		pageModel.getPanel_container().add(labelOfSearch1, gridBagConstraints) ;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.gridwidth = 1;
		gridBagConstraints.insets = new Insets(7,0,0,0) ;
		gridBagConstraints.fill = GridBagConstraints.NONE ;
		pageModel.getPanel_container().add(pageModel.getNumOrderAnnuel(), gridBagConstraints) ;
		
		pageModel.getNumOrderAnnuel().setEditable(false);
		pageModel.getNumOrderAnnuel().setPreferredSize(new Dimension( 130, 36));
		pageModel.getNumOrderAnnuel().setFont(new Font(null, Font.BOLD, 12));
		pageModel.getFl().add(pageModel.getPanel_container(), BorderLayout.PAGE_START);
		pageModel.getPrincipalContainer().add(pageModel.getFl(), BorderLayout.CENTER);
		
		gridBagConstraints.fill = GridBagConstraints.NONE ;
		
		pageModel.setRechInfo( new JButton("Rechercher") );
		pageModel.getRechInfo().setEnabled(false);
		pageModel.getRechInfo().setPreferredSize(new Dimension( 140,40 ));
		pageModel.getRechInfo().setFont(new Font("Arial", Font.CENTER_BASELINE, 14));
		pageModel.getRechInfo().setForeground(Color.black);
		pageModel.getRechInfo().setBackground(new Color(136, 140, 70));
		pageModel.getRechInfo().setBounds(168, 103, 100, 40);   //place for later
		
		pageModel.getRechInfo().addMouseListener(pageModel.getMouseClassListener());
		pageModel.getRechInfo().addActionListener(pageModel.getClickClassListener());
		
		gridBagConstraints.gridx = 1;
		pageModel.getPanel_container().add(pageModel.getRechInfo(), gridBagConstraints) ;
		
		pageModel.setRechAllInfo( new JButton("Afficher tout") );
		pageModel.getRechAllInfo().setBackground(new Color(136, 140, 70));
		pageModel.getRechAllInfo().setPreferredSize(new Dimension( 140, 40 ));
		pageModel.getRechAllInfo().setFont(new Font("Arial",  Font.CENTER_BASELINE, 14));
		pageModel.getRechAllInfo().setForeground(Color.black);
		
		pageModel.getRechAllInfo().addMouseListener(pageModel.getMouseClassListener());
		pageModel.getRechAllInfo().addActionListener(pageModel.getClickClassListener());

		gridBagConstraints.fill = GridBagConstraints.NONE ;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.gridx = 2;
		gridBagConstraints.gridheight = 1 ;
		gridBagConstraints.insets = new Insets(30,0,0,0) ;
		pageModel.getPanel_container().add(pageModel.getRechAllInfo(), gridBagConstraints) ;

		gridBagConstraints.gridheight = 1 ;
		gridBagConstraints.gridy = 3;
		gridBagConstraints.gridx = 0;
		gridBagConstraints.fill = GridBagConstraints.BOTH ;
		gridBagConstraints.insets = new Insets(20,40,0,0) ;
		JLabel labelOfSearch2 = new JLabel(" Entrez l'intervalle de date dans lequel vous désirez rechercher : ");
		labelOfSearch2.setFont(new Font(null, Font.BOLD, 14));
		pageModel.getPanel_container().add(labelOfSearch2, gridBagConstraints) ;
		
		SqlDateModel model = new SqlDateModel();
		SqlDateModel model1 = new SqlDateModel();
		Properties p = new Properties();
	    p.put("text.today", "Today");
	    p.put("text.month", "Month");
	    p.put("text.year", "Year");
	    Properties p1 = new Properties();
	    p1.put("text.today", "Today");
	    p1.put("text.month", "Month");
	    p1.put("text.year", "Year");
		JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
		JDatePanelImpl datePanel1 = new JDatePanelImpl(model1, p1);
		pageModel.setDatePicker( new JDatePickerImpl(datePanel, new DateLabelFormatter()) );
		pageModel.setDatePicker1( new JDatePickerImpl(datePanel1, new DateLabelFormatter()) );
		pageModel.getDatePicker().getComponent(0).setFont(new Font(null, Font.BOLD, 12));
		pageModel.getDatePicker1().getComponent(0).setFont(new Font(null, Font.BOLD, 12));
		pageModel.getDatePicker().getComponent(1).setEnabled(false);
		
		pageModel.getDatePicker().getComponent(1).addMouseListener(pageModel.getMouseClassListener());
		pageModel.getDatePicker1().getComponent(1).addMouseListener(pageModel.getMouseClassListener());
		
		pageModel.getDatePicker().getComponent(1).setBackground(colo);
		pageModel.getDatePicker1().getComponent(1).setBackground(colo);
		pageModel.getDatePicker1().getComponent(1).setEnabled(false);
		pageModel.getListeDeroulant().getComponent(1).setBackground(colo);
		
		gridBagConstraints.gridy = 4;
		gridBagConstraints.gridx = 0;
		gridBagConstraints.insets = new Insets(7,0,0,0) ;
		gridBagConstraints.fill = GridBagConstraints.NONE ;
		pageModel.getDatePicker().setPreferredSize(new Dimension(145,36));
		pageModel.getDatePicker().setBorder(new EmptyBorder(0, 0, 0, 15));
		pageModel.getDatePicker().setBackground(new Color( 242, 234, 237));
		pageModel.getDatePicker1().setBackground(new Color( 242, 234, 237));
		pageModel.getDatePicker1().setPreferredSize(new Dimension(130,36));
		JPanel flowDate1 = new JPanel(new FlowLayout());
		JLabel label1 = new JLabel("Entre") ; label1.setBorder(new EmptyBorder(0, 0, 10, 10));
		label1.setFont(new Font(null, Font.BOLD, 14));
		flowDate1.add(label1) ; flowDate1.add(pageModel.getDatePicker()) ;
		pageModel.getPanel_container().add(flowDate1, gridBagConstraints) ;
		JLabel label2 = new JLabel("Et") ; label2.setBorder(new EmptyBorder(0, 0, 7, 0));
		label2.setFont(new Font(null, Font.BOLD, 14));
		flowDate1.add(label2) ; flowDate1.add(pageModel.getDatePicker1()) ;
		flowDate1.setBackground(new Color( 242, 234, 237));
	
		pageModel.setRechInfoDate( new JButton("Rechercher") );
		pageModel.getRechInfoDate().setBackground(new Color( 136, 140, 70 ));
		pageModel.getRechInfoDate().setEnabled(false);
		
		pageModel.getRechInfoDate().addMouseListener(pageModel.getMouseClassListener());
		pageModel.getRechInfoDate().addActionListener(pageModel.getClickClassListener());
		
		gridBagConstraints.fill = GridBagConstraints.NONE ;
		pageModel.getRechInfoDate().setPreferredSize(new Dimension( 140, 40 ));
		pageModel.getRechInfoDate().setFont(new Font("Arial", Font.CENTER_BASELINE, 14));
		pageModel.getRechInfoDate().setForeground(Color.black);
		gridBagConstraints.gridy = 4;
		gridBagConstraints.gridx = 1;
		gridBagConstraints.insets = new Insets(-7,0,0,0) ;
		pageModel.getPanel_container().add(pageModel.getRechInfoDate(), gridBagConstraints) ;
		
		gridBagConstraints.gridy = 5;
		gridBagConstraints.gridx = 0;
		gridBagConstraints.fill = GridBagConstraints.BOTH ;
		gridBagConstraints.insets = new Insets(20,40,0,0) ;
		JLabel labelOfSearch3 = new JLabel(" Entrez l'expéditeur que vous désirez rechercher : ");
		labelOfSearch3.setFont(new Font(null, Font.BOLD, 14));
		pageModel.getPanel_container().add(labelOfSearch3, gridBagConstraints) ;
		
		gridBagConstraints.gridy = 6;
		gridBagConstraints.gridx = 0;
		gridBagConstraints.insets = new Insets(7,0,0,0) ;
		gridBagConstraints.fill = GridBagConstraints.NONE ;
		pageModel.setDesignationField( new JTextField() );
		pageModel.getDesignationField().setEditable(false);
		pageModel.getDesignationField().setFont(new Font(null, Font.BOLD, 12));
		pageModel.getDesignationField().setPreferredSize(new Dimension( 130, 36));
		pageModel.getPanel_container().add(pageModel.getDesignationField(), gridBagConstraints) ;
		
		pageModel.setRechInfoDesignation( new JButton("Rechercher") );
		pageModel.getRechInfoDesignation().setEnabled(false);
		
		pageModel.getRechInfoDesignation().addMouseListener(pageModel.getMouseClassListener());
		pageModel.getRechInfoDesignation().addActionListener(pageModel.getClickClassListener());
		
		gridBagConstraints.fill = GridBagConstraints.NONE ;
		pageModel.getRechInfoDesignation().setPreferredSize(new Dimension( 140, 40 ));
		pageModel.getRechInfoDesignation().setFont(new Font("Arial", Font.CENTER_BASELINE, 14));
		pageModel.getRechInfoDesignation().setForeground(Color.black);
		pageModel.getRechInfoDesignation().setBackground(new Color(136, 140, 70));
		gridBagConstraints.gridy = 6;
		gridBagConstraints.gridx = 1;
		pageModel.getPanel_container().add(pageModel.getRechInfoDesignation(), gridBagConstraints) ;
		
		gridBagConstraints.gridy = 7;
		gridBagConstraints.gridx = 0;
		gridBagConstraints.fill = GridBagConstraints.BOTH ;
		gridBagConstraints.insets = new Insets(20,40,0,0) ;
		JLabel labelOfSearch4 = new JLabel(" Entrez la division que vous désirez rechercher : ");
		labelOfSearch4.setFont(new Font(null, Font.BOLD, 14));
		pageModel.getPanel_container().add(labelOfSearch4, gridBagConstraints) ;
		
		gridBagConstraints.gridy = 8;
		gridBagConstraints.gridx = 0;
		gridBagConstraints.insets = new Insets(7,0,0,0) ;
		gridBagConstraints.fill = GridBagConstraints.NONE ;
		pageModel.setDivisionField( new JTextField() );
		pageModel.getDivisionField().setEditable(false);
		pageModel.getDivisionField().setFont(new Font(null, Font.BOLD, 12));
		pageModel.getDivisionField().setPreferredSize(new Dimension( 130, 36));
		pageModel.getPanel_container().add(pageModel.getDivisionField(), gridBagConstraints) ;
		
		pageModel.setRechInfodivision( new JButton("Rechercher") );
		pageModel.getRechInfodivision().setBackground(new Color(136, 140, 70));
		pageModel.getRechInfodivision().setEnabled(false);
		
		pageModel.getRechInfodivision().addMouseListener(pageModel.getMouseClassListener());
		pageModel.getRechInfodivision().addActionListener(pageModel.getClickClassListener());
		
		gridBagConstraints.fill = GridBagConstraints.NONE ;
		pageModel.getRechInfodivision().setPreferredSize(new Dimension( 140, 40 ));
		pageModel.getRechInfodivision().setFont(new Font("Arial", Font.CENTER_BASELINE, 14));
		pageModel.getRechInfodivision().setForeground(Color.black);
		gridBagConstraints.gridy = 8;
		gridBagConstraints.gridx = 1;
		pageModel.getPanel_container().add(pageModel.getRechInfodivision(), gridBagConstraints) ;
	
		pageModel.setPana( new JPanel(new GridBagLayout()) ); 
		GridBagConstraints gridBagConstraints0 = new GridBagConstraints(); 
		gridBagConstraints0.fill = GridBagConstraints.NONE ;
		gridBagConstraints0.weightx = 0.5;
		gridBagConstraints0.weighty = 0.5;
		gridBagConstraints0.gridx = 0;  
		gridBagConstraints0.gridy = 0; 
		gridBagConstraints0.anchor = GridBagConstraints.PAGE_END ;
		pageModel.getPana().setBackground(new Color(242, 234, 237));
		
		GridBagConstraints gridBagConstraints1 = new GridBagConstraints();  // for the the gridBagLayout 
		gridBagConstraints1.fill = GridBagConstraints.HORIZONTAL ; 
		gridBagConstraints1.gridx = 0;  
		gridBagConstraints1.gridy = 0; 

		gridBagConstraints1.weightx = 0.5;
		gridBagConstraints1.insets = new Insets(0,40,0,20) ;
		JPanel gridB =new JPanel( new GridBagLayout() ) ;
		gridB.setBackground(new Color(242, 234, 237));

		pageModel.setText1( new JTextField() ); pageModel.setText2( new JTextField() ); pageModel.setText5( new JTextField() );
		pageModel.setText3(new JTextArea()); pageModel.setText4(new JTextArea());
		
		pageModel.getText1().setPreferredSize(new Dimension(150,40)); pageModel.getText1().setFont(new Font(null, Font.BOLD, 12));
		pageModel.getText2().setPreferredSize(new Dimension(150,40)); pageModel.getText2().setFont(new Font(null, Font.BOLD, 12));
		pageModel.getText5().setPreferredSize(new Dimension(150,40)); pageModel.getText5().setFont(new Font(null, Font.BOLD, 12));
		pageModel.getText4().setLineWrap(true); pageModel.getText4().setFont(new Font(null, Font.BOLD, 12));
		pageModel.getText3().setLineWrap(true); pageModel.getText3().setFont(new Font(null, Font.BOLD, 12));
		JScrollPane paneTextArea = new JScrollPane(pageModel.getText4()) ;
		JScrollPane paneTextArea1 = new JScrollPane(pageModel.getText3()) ;
		paneTextArea1.setViewportView(pageModel.getText3());
		paneTextArea1.setPreferredSize(new Dimension(150,40));
		paneTextArea.setViewportView(pageModel.getText4());
		paneTextArea.setPreferredSize(new Dimension(150,40));
		pageModel.getText1().setEditable(false);  pageModel.getText2().setEditable(false);
		pageModel.getText3().setEditable(false);  pageModel.getText4().setEditable(false);
		pageModel.getText5().setEditable(false);
		
		JLabel ordAnnuel1 = new JLabel("Numéro d'ordre annuel :");
		ordAnnuel1.setFont(new Font(null, Font.BOLD, 12));
		gridB.add(ordAnnuel1, gridBagConstraints1);
		gridBagConstraints1.gridx = 1; 
		pageModel.getText1().setPreferredSize(new Dimension(150,40));
		gridB.add(pageModel.getText1(), gridBagConstraints1) ; 
		gridBagConstraints1.gridx = 0;  
		gridBagConstraints1.gridy = 1; 
		JLabel dateArrivee = new JLabel("Date arrivée :");
		dateArrivee.setFont(new Font(null, Font.BOLD, 12));
		gridB.add(dateArrivee, gridBagConstraints1);
		gridBagConstraints1.gridx = 1;  
		gridB.add(pageModel.getText2(), gridBagConstraints1) ; 
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
		
		gridBagConstraints0.insets = new Insets(0,0,20,0) ;
		pageModel.getPana().add(gridB, gridBagConstraints0); 
		pageModel.setSupprimer( new JButton("Supprimer") );
		pageModel.getSupprimer().setFont(new Font(null, Font.BOLD, 13));
		pageModel.getSupprimer().setPreferredSize(new Dimension(150,40));
		pageModel.getSupprimer().setBackground(new Color(136, 140, 70));
		
		pageModel.getSupprimer().addMouseListener(pageModel.getMouseClassListener());
		pageModel.getSupprimer().addActionListener(pageModel.getClickClassListener());
		
		 gridBagConstraints0.gridx = 1;  
		 gridBagConstraints0.gridy = 0; 
		 gridBagConstraints0.insets = new Insets(0,-80,0,0) ;
		gridBagConstraints0.anchor = GridBagConstraints.ABOVE_BASELINE_LEADING ;
		pageModel.getPana().add(pageModel.getSupprimer(), gridBagConstraints0);
		pageModel.getPana().setVisible(false);
		pageModel.getPrincipalContainer().add(pageModel.getPana(), BorderLayout.PAGE_END);
	
		pageModel.setTableContainer( new JPanel(new GridLayout()) ) ;
	}
	
}