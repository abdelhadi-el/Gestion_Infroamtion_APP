package com.provApp.gestionApp.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.provApp.gestionApp.GestionAppApplication;
import com.provApp.gestionApp.models.HomePageModel;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Component @NoArgsConstructor 
@Scope("prototype") @Data @EqualsAndHashCode(callSuper=false)
public class HomePage extends HomePageModel{

	@Autowired
	GestionAppApplication app ;
	ApplicationContext appContext ;
	HomePageModel pageModel ;
	
	@Autowired
	public HomePage(HomePageModel mod) {
		this.pageModel = mod ;
		pageModel.getClickClassListener().pageModel = this ; // remplissage de la classe listener
		pageModel.getMouseClassListener().pageModel = this ;
		
		initializePage();
	}
	
	private void initializePage() {
		
		pageModel.setFrame( new JFrame() );
		pageModel.getFrame().setBounds(0, 0, 1200, 650);
		pageModel.getFrame().setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		pageModel.getFrame().setLocationRelativeTo(null);
		pageModel.getFrame().getContentPane().setBackground(new Color(242, 234, 237));
		pageModel.getFrame().getContentPane().setLayout(new BorderLayout());
        pageModel.getFrame().setMinimumSize(new Dimension(700, 490));  // for minimum size allowed

		
		pageModel.setWelcomeLabel( new JLabel(" BIENVENUE ") );
		pageModel.getWelcomeLabel().setFont(new Font("Montserrat", Font.BOLD, 20));
		pageModel.getWelcomeLabel().setBorder(new EmptyBorder(20,0,10,0));
		pageModel.getWelcomeLabel().setForeground(new Color(255, 255, 255));
		pageModel.setFlowText( new JPanel( new FlowLayout() ) );
		pageModel.getFlowText().add(pageModel.getWelcomeLabel()) ;
		pageModel.getFlowText().setBackground(new Color(164, 164, 191));
		
		GridBagConstraints gridBagConstraints = new GridBagConstraints();  // for the the gridBagLayout 
		gridBagConstraints.fill = GridBagConstraints.BOTH ; 
		gridBagConstraints.gridx = 0;  
		gridBagConstraints.gridy = 0; 
		gridBagConstraints.weightx = 0.5;
		gridBagConstraints.weighty = 0.5 ;
		gridBagConstraints.insets = new Insets(4,0,0,0) ;

		JPanel panel_container = new JPanel() ;		// container of the 3 buttons //gris pour la page start
		panel_container.setPreferredSize(new Dimension( 140, 100 ));
		panel_container.setLayout(new GridBagLayout());
		panel_container.setBackground(new Color(164, 164, 191));
		panel_container.add(pageModel.getFlowText(), gridBagConstraints);
		
		gridBagConstraints.gridy = 1; 

		Icon img = new ImageIcon(getClass().getResource("/images/search_click.png")) ;
		pageModel.setRechInfo(  new JButton("<html><center>Rechercher / <br />Supprimer</center></html>", img) ) ;
		pageModel.getRechInfo().setEnabled(false) ;
		pageModel.getRechInfo().setBackground(new Color(22, 35, 90)) ;
		pageModel.getRechInfo().setForeground(new Color(255,255,255));
		pageModel.getRechInfo().setVerticalTextPosition(SwingConstants.BOTTOM);
		pageModel.getRechInfo().setHorizontalTextPosition(SwingConstants.CENTER);
		pageModel.getRechInfo().setFont(new Font("Montserrat", Font.BOLD, 16));

		pageModel.getRechInfo().addMouseListener(pageModel.getMouseClassListener()) ;		
		pageModel.getRechInfo().addActionListener(pageModel.getClickClassListener()) ;
		
		panel_container.add(pageModel.getRechInfo(), gridBagConstraints) ;

		gridBagConstraints.gridy = 2; 
		Icon img1 = new ImageIcon(getClass().getResource("/images/add_click.png")) ;
		pageModel.setAddInfo( new JButton(" Ajouter ", img1) );
		pageModel.getAddInfo().setEnabled(false);
		pageModel.getAddInfo().setVerticalTextPosition(SwingConstants.BOTTOM);
		pageModel.getAddInfo().setHorizontalTextPosition(SwingConstants.CENTER);
		pageModel.getAddInfo().setBackground(new Color(22, 35, 90)) ;
		pageModel.getAddInfo().setForeground(new Color(255,255,255));
		
		pageModel.getAddInfo().addMouseListener(pageModel.getMouseClassListener()) ;
		pageModel.getAddInfo().addActionListener(pageModel.getClickClassListener()) ;

		pageModel.getAddInfo().setFont(new Font("Montserrat", Font.BOLD, 16));
		panel_container.add(pageModel.getAddInfo(), gridBagConstraints) ;

		gridBagConstraints.gridy = 3; 
		Icon img2 = new ImageIcon(getClass().getResource("/images/update_click.png")) ;
		pageModel.setSetInfo( new JButton(" Modifier ", img2) );
		pageModel.getSetInfo().setEnabled(false) ;
		pageModel.getSetInfo().setVerticalTextPosition(SwingConstants.BOTTOM);
		pageModel.getSetInfo().setHorizontalTextPosition(SwingConstants.CENTER);
		pageModel.getSetInfo().setBackground(new Color(22, 35, 90)) ;
		pageModel.getSetInfo().setForeground(new Color(255,255,255));
		
		pageModel.getSetInfo().addMouseListener(pageModel.getMouseClassListener()) ;
		pageModel.getSetInfo().addActionListener(pageModel.getClickClassListener()) ;

		pageModel.getSetInfo().setFont(new Font("Montserrat", Font.BOLD, 16));
		panel_container.add(pageModel.getSetInfo(), gridBagConstraints) ;
		
		gridBagConstraints.gridy = 4; 
		Icon img3 = new ImageIcon(getClass().getResource("/images/exit_click.png")) ;
		pageModel.setSortir( new JButton(" Quitter ", img3) );
		pageModel.getSortir().setVerticalTextPosition(SwingConstants.BOTTOM);
		pageModel.getSortir().setHorizontalTextPosition(SwingConstants.CENTER);
		pageModel.getSortir().setBackground(new Color(22, 35, 90)) ;
		pageModel.getSortir().setForeground(new Color(255,255,255));
		pageModel.getSortir().setFont(new Font("Montserrat", Font.BOLD, 16));
		panel_container.add(pageModel.getSortir(), gridBagConstraints) ;
		
		pageModel.getSortir().addMouseListener(pageModel.getMouseClassListener()) ;
		pageModel.getSortir().addActionListener(pageModel.getClickClassListener()) ;
		// c'est une alternative du boutton sortir qui est log out
		//Icon img3 = new ImageIcon(getClass().getResource("/images/exit_click.png")) ;
		pageModel.setSeDeconnecter( new JButton("<html><center>Se<br />Déconnecter</center></html>", img3) );
		pageModel.getSeDeconnecter().setVerticalTextPosition(SwingConstants.BOTTOM);
		pageModel.getSeDeconnecter().setHorizontalTextPosition(SwingConstants.CENTER);
		pageModel.getSeDeconnecter().setBackground(new Color(22, 35, 90)) ;
		pageModel.getSeDeconnecter().setForeground(new Color(255,255,255));
		pageModel.getSeDeconnecter().setFont(new Font("Montserrat", Font.BOLD, 16));
		panel_container.add(pageModel.getSeDeconnecter(), gridBagConstraints) ;
		pageModel.getSeDeconnecter().setVisible(false) ;
		
		pageModel.getSeDeconnecter().addMouseListener(pageModel.getMouseClassListener()) ;
		pageModel.getSeDeconnecter().addActionListener(pageModel.getClickClassListener()) ;

		pageModel.getFrame().getContentPane().add( panel_container, BorderLayout.LINE_START ) ;

		LoginPage window = GestionAppApplication.getContext().getBean(LoginPage.class) ;
		window.setHomePage(pageModel) ;
		window.setAppContext(GestionAppApplication.getContext()) ;
		pageModel.getContainerP().add(	window.getPageModel().getPrincipalContainer(), BorderLayout.CENTER ) ; //// aattention variable window.prin..... !!!!!!!! ????
		pageModel.getContainerP().setPreferredSize(new Dimension(730,600));
		pageModel.setScroll( new JScrollPane( pageModel.getContainerP()) ) ;
		pageModel.getScroll().setBorder(null);
		pageModel.getFrame().getContentPane().add(	pageModel.getScroll(), BorderLayout.CENTER );
	}
	
}

