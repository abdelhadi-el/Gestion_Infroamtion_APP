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

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.provApp.gestionApp.models.RechercherPersonnelModel;

import lombok.Data;

@Component @Data
@Scope("prototype")
public class RechercherPersonnel {
	

		RechercherPersonnelModel pageModel ;
		ApplicationContext appContext ;
		
		@Autowired
		public RechercherPersonnel( RechercherPersonnelModel modelP ) {
			this.pageModel = modelP ;
			pageModel.getClickClassListener().setPage( this );
			pageModel.getMouseClassListener().setPage( this ) ;
			
			initialize();
		}
		
		private void initialize() {
			
			JPanel flowText = new JPanel(new FlowLayout()) ;
			JLabel labelOfSearch1 = new JLabel(" Entrez l'identifiant de l'utilisateur que vous désirez afficher : ");
			flowText.setPreferredSize(new Dimension( 300, 70 ));
			labelOfSearch1.setFont(new Font(null, Font.BOLD, 14));
			flowText.setBorder(new EmptyBorder(40, 0, 0, 0)); // the buttom is not working
			flowText.add(labelOfSearch1); // flowText.add(labelOfSearch2);
			pageModel.setPrincipalContainer( new JPanel(new BorderLayout()) );
			Border border0 = new EmptyBorder(20, 20, 30, 0);
			JLabel labelOfSearch0 = new JLabel("RECHERCHE DE PERSONNELS : ");
			labelOfSearch0.setFont(new Font("Montserrat", Font.BOLD, 20));
			labelOfSearch0.setForeground(new Color(255, 255, 255));
			labelOfSearch0.setBorder(border0);
			JPanel flowText0 = new JPanel(new GridBagLayout()) ;
			flowText0.setBackground(new Color(164, 164, 191));
			flowText0.add(labelOfSearch0) ;
			pageModel.getPrincipalContainer().add(flowText0, BorderLayout.PAGE_START) ; 
			
			pageModel.setNumOrderAnnuel( new JTextField() );
			
			JLabel whatToUpdate = new JLabel("S�lectionner le critère de sélection à activer:") ;
			whatToUpdate.setFont(new Font(null, Font.BOLD, 14));
			String champs[]={"","Par Identifiant","Par Nom D'utilisateur","Par Type", "Tous"}; 

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
			gridBagConstraints.gridy = 3;
			gridBagConstraints.gridx = 0;
			gridBagConstraints.fill = GridBagConstraints.BOTH ;
			gridBagConstraints.insets = new Insets(20,40,0,0) ;
			JLabel labelOfSearch3 = new JLabel(" Entrez le nom d'utilisateur que vous désirez afficher : ");
			labelOfSearch3.setFont(new Font(null, Font.BOLD, 14));
			pageModel.getPanel_container().add(labelOfSearch3, gridBagConstraints) ;
			
			gridBagConstraints.gridy = 4;
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
			gridBagConstraints.gridy = 4;
			gridBagConstraints.gridx = 1;
			pageModel.getPanel_container().add(pageModel.getRechInfoDesignation(), gridBagConstraints) ;
			
			gridBagConstraints.gridy = 5;
			gridBagConstraints.gridx = 0;
			gridBagConstraints.fill = GridBagConstraints.BOTH ;
			gridBagConstraints.insets = new Insets(20,40,0,0) ;
			JLabel labelOfSearch4 = new JLabel(" Choisissez le type que vous désirez afficher : ");
			labelOfSearch4.setFont(new Font(null, Font.BOLD, 14));
			pageModel.getPanel_container().add(labelOfSearch4, gridBagConstraints) ;
			
			gridBagConstraints.gridy = 6;
			gridBagConstraints.gridx = 0;
			gridBagConstraints.insets = new Insets(7,0,0,0) ;
			gridBagConstraints.fill = GridBagConstraints.NONE ;
			String champs1[]={"Administrateur","normal"}; 
			pageModel.setListeDeroulant1( new JComboBox<>(champs1) );
			pageModel.getListeDeroulant1().setBackground(new Color(136, 140, 60));
			pageModel.getListeDeroulant1().addMouseListener(pageModel.getMouseClassListener());
			pageModel.getListeDeroulant1().addActionListener(pageModel.getClickClassListener());
			pageModel.getListeDeroulant1().setPreferredSize(new Dimension(165,36));
			pageModel.getListeDeroulant1().setFont(new Font("Arial", Font.CENTER_BASELINE, 12));
			pageModel.getListeDeroulant1().setEnabled(false) ;	
			pageModel.getPanel_container().add(pageModel.getListeDeroulant1(), gridBagConstraints) ;
			
			pageModel.setRechInfodivision( new JButton("Rechercher") );
			pageModel.getRechInfodivision().setBackground(new Color(136, 140, 70));
			pageModel.getRechInfodivision().setEnabled(false);
			
			pageModel.getRechInfodivision().addMouseListener(pageModel.getMouseClassListener());
			pageModel.getRechInfodivision().addActionListener(pageModel.getClickClassListener());
			
			gridBagConstraints.fill = GridBagConstraints.NONE ;
			pageModel.getRechInfodivision().setPreferredSize(new Dimension( 140, 40 ));
			pageModel.getRechInfodivision().setFont(new Font("Arial", Font.CENTER_BASELINE, 14));
			pageModel.getRechInfodivision().setForeground(Color.black);
			gridBagConstraints.gridy = 6;
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
			gridBagConstraints1.anchor = GridBagConstraints.PAGE_START ;
			gridBagConstraints1.weightx = 0.5;
			gridBagConstraints1.insets = new Insets(0,40,0,20) ;
			JPanel gridB =new JPanel( new GridBagLayout() ) ;
			gridB.setBackground(new Color(242, 234, 237));

			pageModel.setText1( new JTextField() ); pageModel.setText5( new JTextField() );
			pageModel.setText3(new JTextArea()); pageModel.setText4(new JTextArea());
			
			pageModel.getText1().setPreferredSize(new Dimension(150,40)); pageModel.getText1().setFont(new Font(null, Font.BOLD, 12));
			pageModel.getText5().setPreferredSize(new Dimension(150,40)); pageModel.getText5().setFont(new Font(null, Font.BOLD, 12));
			pageModel.getText4().setLineWrap(true); pageModel.getText4().setFont(new Font(null, Font.BOLD, 12));
			pageModel.getText3().setLineWrap(true); pageModel.getText3().setFont(new Font(null, Font.BOLD, 12));
			JScrollPane paneTextArea = new JScrollPane(pageModel.getText4()) ;
			JScrollPane paneTextArea1 = new JScrollPane(pageModel.getText3()) ;
			paneTextArea1.setViewportView(pageModel.getText3());
			paneTextArea1.setPreferredSize(new Dimension(150,40));
			paneTextArea.setViewportView(pageModel.getText4());
			paneTextArea.setPreferredSize(new Dimension(150,40));
			pageModel.getText1().setEditable(false); // pageModel.getText2().setEditable(false);
			pageModel.getText3().setEditable(false);  pageModel.getText4().setEditable(false);
			pageModel.getText5().setEditable(false);
			
			JLabel ordAnnuel1 = new JLabel(" Identifiant de l'utilisateur :");
			ordAnnuel1.setFont(new Font(null, Font.BOLD, 12));
			gridB.add(ordAnnuel1, gridBagConstraints1);
			gridBagConstraints1.gridx = 1; 
			pageModel.getText1().setPreferredSize(new Dimension(150,40));
			gridB.add(pageModel.getText1(), gridBagConstraints1) ; 
			gridBagConstraints1.gridx = 0;  
			gridBagConstraints1.gridy = 1;
			JLabel designationLabel = new JLabel("Nom de l'utilisateur :");
			designationLabel.setFont(new Font(null, Font.BOLD, 12));
			gridB.add(designationLabel, gridBagConstraints1);
			gridBagConstraints1.gridx = 1;
			gridB.add(paneTextArea1, gridBagConstraints1) ; 
			gridBagConstraints1.gridx = 0;  
			gridBagConstraints1.gridy = 2;
			JLabel analyseLabel = new JLabel("Mot de passe de l'utilisateur :");
			analyseLabel.setFont(new Font(null, Font.BOLD, 12));
			gridB.add(analyseLabel, gridBagConstraints1);
			gridBagConstraints1.gridx = 1;
			gridB.add(paneTextArea, gridBagConstraints1) ; 
			gridBagConstraints1.gridx = 0;  
			gridBagConstraints1.gridy = 3;
			JLabel divisionLabel = new JLabel("Type de l'utilisateur :");
			divisionLabel.setFont(new Font(null, Font.BOLD, 12));
			gridB.add(divisionLabel, gridBagConstraints1);
			gridBagConstraints1.gridx = 1;
			gridB.add(pageModel.getText5(), gridBagConstraints1) ;
			
			gridBagConstraints0.insets = new Insets(0,0,20,0) ;
			gridBagConstraints0.anchor = GridBagConstraints.PAGE_START ;
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
