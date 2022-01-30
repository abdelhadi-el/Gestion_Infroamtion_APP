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

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.provApp.gestionApp.models.ModifierPersonnelModel;

import lombok.Data;

@Component @Data @Scope("prototype")
public class ModifierPersonnel {

	ModifierPersonnelModel pageModel ;
	ApplicationContext appContext ;
	
	public ModifierPersonnel( ModifierPersonnelModel modelP ) {
		this.pageModel = modelP ;	
		pageModel.getClickClassListener().page = this ;
		pageModel.getMouseClassListener().page = this ;
		initialize();
	}
private void initialize() {
		
		Border border = new EmptyBorder(20, 20, 30, 0); // raison de design
		JLabel modificationLabel = new JLabel("MODIFICATION DE PERSONNELS :");
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
		pageModel.setCheckBox1( new JCheckBox("Identifiant") );
		pageModel.setCheckBox2( new JCheckBox("Nom d'utilisateur") );
		pageModel.setCheckBox3( new JCheckBox("Type") );
		panelContainerFlow.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
		panelContainerFlow.add(whatUseToSelect) ;
		panelContainerFlow.add(whatUseToSelect2) ;
		panelContainerFlow.add(pageModel.getCheckBox1()); panelContainerFlow.add(pageModel.getCheckBox2()); panelContainerFlow.add(pageModel.getCheckBox3());// panelContainerFlow.add(pageModel.getCheckBox4()); panelContainerFlow.add(pageModel.getCheckBox5());
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

		pageModel.setText3( new JTextArea() ); pageModel.getText3().setFont(new Font(null, Font.BOLD, 12));
		pageModel.setText1( new JTextField() ) ; //pageModel.setText5( new JTextField() ) ; 
		pageModel.getText1().setFont(new Font(null, Font.BOLD, 12)); //pageModel.getText5().setFont(new Font(null, Font.BOLD, 12));
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
		
		JLabel ordAnnuel1 = new JLabel(" Identifiant de l'utilisateur :");
		ordAnnuel1.setFont(new Font(null, Font.BOLD, 12));
		gridB.add(ordAnnuel1, gridBagConstraints1);
		gridBagConstraints1.gridx = 1; 
		pageModel.getText1().setPreferredSize(new Dimension(150,40));
		gridB.add(pageModel.getText1(), gridBagConstraints1) ; 
		JLabel ordAnnuel1New = new JLabel(" Nouvelle valeur de l'identifiant:");  ordAnnuel1New.setFont(new Font(null, Font.BOLD, 12));
		gridBagConstraints1.gridx = 2;
		gridB.add(ordAnnuel1New, gridBagConstraints1);
		gridBagConstraints1.gridx = 3;
		gridB.add(pageModel.getText1New(), gridBagConstraints1);
		gridBagConstraints1.gridx = 0;  
		gridBagConstraints1.gridy = 1;
		JLabel designationLabel = new JLabel(" Nom de l'utilisateur :");
		designationLabel.setFont(new Font(null, Font.BOLD, 12));
		gridB.add(designationLabel, gridBagConstraints1);
		gridBagConstraints1.gridx = 1;
		gridB.add(paneTextArea1, gridBagConstraints1) ; 
		gridBagConstraints1.gridx = 0;  
		gridBagConstraints1.gridy = 2;
		JLabel analyseLabel = new JLabel(" Mot de passe de l'utilisateur :");
		analyseLabel.setFont(new Font(null, Font.BOLD, 12));
		gridB.add(analyseLabel, gridBagConstraints1);
		gridBagConstraints1.gridx = 1;
		gridB.add(paneTextArea, gridBagConstraints1) ; 
		gridBagConstraints1.gridx = 0;  
		gridBagConstraints1.gridy = 3;
		JLabel divisionLabel = new JLabel(" Type de l'utilisateur :");
		divisionLabel.setFont(new Font(null, Font.BOLD, 12));
		gridB.add(divisionLabel, gridBagConstraints1);
		gridBagConstraints1.gridx = 1;
		String champs1[]={"Administrateur","normal"}; 
		pageModel.setListeDeroulant( new JComboBox<>(champs1) );
		pageModel.getListeDeroulant().setBackground(new Color(136, 140, 60));
		pageModel.getListeDeroulant().addMouseListener(pageModel.getMouseClassListener());
		pageModel.getListeDeroulant().addActionListener(pageModel.getClickClassListener());
		pageModel.getListeDeroulant().setPreferredSize(new Dimension(165,36));
		pageModel.getListeDeroulant().setFont(new Font("Arial", Font.CENTER_BASELINE, 12));
		gridB.add(pageModel.getListeDeroulant(), gridBagConstraints1) ;
		 pageModel.getPana().add(gridB, gridBagConstraints0); 
		 gridBagConstraints1.gridx = 2;  
		 gridBagConstraints1.gridy = 2; 
		gridBagConstraints1.anchor = GridBagConstraints.ABOVE_BASELINE_LEADING ;
		 gridB.add(pageModel.getValiderUpdate(), gridBagConstraints1);
		 
		pageModel.setContainerPanel2( new JPanel(new BorderLayout()) );
		pageModel.setTableContainer( new JPanel(new GridLayout()) );
		pageModel.getTableContainer().setBorder(new EmptyBorder(50,0,40,0));
		pageModel.getTableContainer().setBackground(new Color(242, 234, 237)); 
		
		pageModel.setListeDeroulantFirst( new JComboBox<>(champs1) );
		pageModel.getListeDeroulantFirst().setBackground(new Color(136, 140, 60));
		pageModel.getListeDeroulantFirst().addMouseListener(pageModel.getMouseClassListener());
		pageModel.getListeDeroulantFirst().addActionListener(pageModel.getClickClassListener());
		pageModel.getListeDeroulantFirst().setPreferredSize(new Dimension(165,36));
		pageModel.getListeDeroulantFirst().setFont(new Font("Arial", Font.CENTER_BASELINE, 12));
	}
	

}
