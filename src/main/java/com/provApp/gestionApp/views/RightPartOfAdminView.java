package com.provApp.gestionApp.views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.provApp.gestionApp.models.HomePageModel;
import com.provApp.gestionApp.models.RightPartAdminModel;

import lombok.Data;

@Component @Data
public class RightPartOfAdminView {

	RightPartAdminModel pageModel ;
	HomePageModel homePp ;
	ApplicationContext appContext ;

	@Autowired
	public RightPartOfAdminView( RightPartAdminModel page ) {
		this.pageModel = page ;	
		pageModel.getClickClassListener().pageModel = this ; // remplissage de la classe listener
		pageModel.getMouseClassListener().pageModel = this ;
		
		initializePage();
	}
	
	private void initializePage() {
		
		GridBagConstraints gridBagConstraints = new GridBagConstraints();  // for the the gridBagLayout 
		gridBagConstraints.fill = GridBagConstraints.BOTH ; 
		gridBagConstraints.gridx = 0;  
		gridBagConstraints.gridy = 0; 
		gridBagConstraints.weightx = 0.5;
		gridBagConstraints.weighty = 0.5 ;
		gridBagConstraints.insets = new Insets(80,0,0,0) ;
	
		pageModel.setPanel_container( new JPanel() ) ;		// container of the 3 buttons //gris pour la page start
		pageModel.getPanel_container().setPreferredSize(new Dimension( 140, 100 ));
		pageModel.getPanel_container().setLayout(new GridBagLayout());
		pageModel.getPanel_container().setBackground(new Color(164, 164, 191));
	
		Icon img = new ImageIcon(getClass().getResource("/images/search_click.png")) ;
		pageModel.setRechPersonnel(  new JButton("<html><center>Rechercher / <br />Supprimer<br />Personnel</center></html>", img) ) ;
		pageModel.getRechPersonnel().setPreferredSize(new Dimension(100,120));
		pageModel.getRechPersonnel().setBackground(new Color(22, 35, 90)) ;
		pageModel.getRechPersonnel().setForeground(new Color(255,255,255));
		pageModel.getRechPersonnel().setVerticalTextPosition(SwingConstants.BOTTOM);
		pageModel.getRechPersonnel().setHorizontalTextPosition(SwingConstants.CENTER);
		pageModel.getRechPersonnel().setFont(new Font("Montserrat", Font.BOLD, 16));
		
		pageModel.getRechPersonnel().addMouseListener(pageModel.getMouseClassListener()) ;		
		pageModel.getRechPersonnel().addActionListener(pageModel.getClickClassListener()) ;
		
		pageModel.getPanel_container().add(pageModel.getRechPersonnel(), gridBagConstraints) ;
	
		gridBagConstraints.gridy = 1; 
		gridBagConstraints.insets = new Insets(10,0,0,0) ;
		Icon img1 = new ImageIcon(getClass().getResource("/images/add_click.png")) ;
		pageModel.setAddPersonnel( new JButton("<html><center>Ajouter<br />Personnel</center></html>", img1) );
		pageModel.getAddPersonnel().setPreferredSize(new Dimension(100,120));
		//pageModel.getAddPersonnel().setEnabled(false);
		pageModel.getAddPersonnel().setVerticalTextPosition(SwingConstants.BOTTOM);
		pageModel.getAddPersonnel().setHorizontalTextPosition(SwingConstants.CENTER);
		pageModel.getAddPersonnel().setBackground(new Color(22, 35, 90)) ;
		pageModel.getAddPersonnel().setForeground(new Color(255,255,255));
		
		pageModel.getAddPersonnel().addMouseListener(pageModel.getMouseClassListener()) ;
		pageModel.getAddPersonnel().addActionListener(pageModel.getClickClassListener()) ;
	
		pageModel.getAddPersonnel().setFont(new Font("Montserrat", Font.BOLD, 16));
		pageModel.getPanel_container().add(pageModel.getAddPersonnel(), gridBagConstraints) ;
	
		gridBagConstraints.gridy = 2; 
		Icon img2 = new ImageIcon(getClass().getResource("/images/update_click.png")) ;
		pageModel.setSetPersonnel( new JButton("<html><center>Modifier<br />Personnel</center></html>", img2) );
		pageModel.getSetPersonnel().setPreferredSize(new Dimension(100,120));
		pageModel.getSetPersonnel().setVerticalTextPosition(SwingConstants.BOTTOM);
		pageModel.getSetPersonnel().setHorizontalTextPosition(SwingConstants.CENTER);
		pageModel.getSetPersonnel().setBackground(new Color(22, 35, 90)) ;
		pageModel.getSetPersonnel().setForeground(new Color(255,255,255));
		
		pageModel.getSetPersonnel().addMouseListener(pageModel.getMouseClassListener()) ;
		pageModel.getSetPersonnel().addActionListener(pageModel.getClickClassListener()) ;
	
		pageModel.getSetPersonnel().setFont(new Font("Montserrat", Font.BOLD, 16));
		pageModel.getPanel_container().add(pageModel.getSetPersonnel(), gridBagConstraints) ;
		
	}
}
