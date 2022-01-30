package com.provApp.gestionApp.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.provApp.gestionApp.models.HomePageModel;
import com.provApp.gestionApp.models.LoginPageModel;

import lombok.Data;

@Component
@Scope("prototype") @Data
public class LoginPage {

	LoginPageModel pageModel ;
	HomePageModel homePage ;
	ApplicationContext appContext ;
	Border borderCustom ;

	@Autowired
	public LoginPage( LoginPageModel page, Border customBorder ) {
		
		try {
			this.pageModel = page ;
			this.borderCustom = customBorder ;
			pageModel.getClickClassListener().setPage( this );
			pageModel.getMouseClassListener().setPage( this ) ;
			pageModel.getFocusClassListener().setPage( this ) ;
			initializePage();
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}	
	}

	public void initializePage() throws IOException {
		pageModel.setPrincipalContainer( new JPanel( new BorderLayout() ) ) ;
		pageModel.setGridBagImageContainer( new JPanel( new GridBagLayout() ) ) ;
		pageModel.setGridBagFormContainer( new JPanel( new GridBagLayout() ) );
		//gridBagFormContainer.setSize(new Dimension(500, 300));
		pageModel.getGridBagFormContainer().setBackground(new Color(242, 234, 237));
		pageModel.getGridBagImageContainer().setBackground(new Color(242, 234, 237));
		
		Border border0 = new EmptyBorder(20, 20, 30, 0);
		JLabel labelOfSearch0 = new JLabel(" AUTHENTIFICATION : ");
		labelOfSearch0.setFont(new Font("Montserrat", Font.BOLD, 20));
		labelOfSearch0.setForeground(new Color(255, 255, 255));
		JPanel flowText0 = new JPanel(new GridBagLayout()) ;
		GridBagConstraints constaBagConstraints = new GridBagConstraints() ;
		flowText0.setBackground(new Color(164, 164, 191));
		flowText0.add(labelOfSearch0, constaBagConstraints) ;
		labelOfSearch0.setBorder(border0);
		pageModel.getPrincipalContainer().add(flowText0, BorderLayout.PAGE_START) ;
		
		pageModel.setGridBagConstraint( new GridBagConstraints() ); 
		pageModel.getGridBagConstraint().fill = GridBagConstraints.NONE ;
		pageModel.getGridBagConstraint().gridx = 0;  
		pageModel.getGridBagConstraint().gridy = 0; 
		pageModel.getGridBagConstraint().anchor = GridBagConstraints.PAGE_START ;
		pageModel.getGridBagConstraint().insets = new Insets(30,30,0,0) ;
		
		Image myPicture = ImageIO.read(getClass().getResource("/images/img.png")).getScaledInstance(400, 500, Image.SCALE_SMOOTH);
		ImageIcon cc = new ImageIcon(myPicture) ;
		
		JLabel leftPicLabel = new JLabel(cc);
		leftPicLabel.setBackground(new Color(242, 234, 237));
		pageModel.getGridBagImageContainer().addMouseListener(pageModel.getMouseClassListener());
		pageModel.getGridBagImageContainer().add(leftPicLabel, pageModel.getGridBagConstraint());
		pageModel.getPrincipalContainer().add(pageModel.getGridBagImageContainer(), BorderLayout.LINE_START);
		
		Image myPicture2 = ImageIO.read(getClass().getResource("/images/avatar.png")).getScaledInstance(150, 150, Image.SCALE_SMOOTH);
		ImageIcon cc2 = new ImageIcon(myPicture2) ;
		
		JLabel rightPicLabel = new JLabel(cc2);
		rightPicLabel.setBackground(new Color(242, 234, 237));
		pageModel.getGridBagConstraint().insets = new Insets(30,0,0,0) ;
		pageModel.getGridBagFormContainer().add(rightPicLabel, pageModel.getGridBagConstraint());
		pageModel.getGridBagFormContainer().addMouseListener(pageModel.getMouseClassListener());
		String champs[]={"Administrateur","Normal"}; 
		pageModel.setListeDeroulant( new JComboBox<>(champs) );
		pageModel.getListeDeroulant().addMouseListener(pageModel.getMouseClassListener());
		pageModel.getListeDeroulant().addFocusListener(pageModel.getFocusClassListener());

		Color colo = new Color(136, 140, 60) ;
		pageModel.getListeDeroulant().setPreferredSize(new Dimension(300,50));
		pageModel.getListeDeroulant().setBackground(colo);
		pageModel.getListeDeroulant().setFont(new Font("Montserrat", Font.CENTER_BASELINE, 12));
		pageModel.getGridBagConstraint().gridy = 1; 
		pageModel.getGridBagConstraint().anchor = GridBagConstraints.CENTER ;
		pageModel.getGridBagConstraint().fill = GridBagConstraints.NONE ;
		pageModel.getGridBagFormContainer().add(pageModel.getListeDeroulant(), pageModel.getGridBagConstraint());
		
		pageModel.setUserNameFocus( new JLabel(" NOM UTILISATEUR ") );
		pageModel.getUserNameFocus().setFont(new Font("Montserrat", Font.CENTER_BASELINE, 14));
		pageModel.getUserNameFocus().setForeground(new Color(120,120,120)) ;
		pageModel.getGridBagConstraint().gridy = 2;
		pageModel.getGridBagConstraint().insets = new Insets(15,10,-20,0) ;
		pageModel.getGridBagConstraint().anchor = GridBagConstraints.WEST;
		pageModel.getGridBagFormContainer().add(pageModel.getUserNameFocus(), pageModel.getGridBagConstraint());
		pageModel.getUserNameFocus().setVisible(false);
		
		pageModel.setUserName( new JLabel(" NOM UTILISATEUR ") );
		
		pageModel.getUserName().addMouseListener(pageModel.getMouseClassListener()) ;
		//pageModel.getUserName().addFocusListener(pageModel.getFocusClassListener())  ;
		
		pageModel.getUserName().setFont(new Font("Montserrat", Font.CENTER_BASELINE, 14));
		pageModel.getUserName().setForeground(new Color(120,120,120)) ;
		pageModel.getGridBagConstraint().insets = new Insets(30,12,0,0) ;
		pageModel.getGridBagConstraint().gridy = 3;
		pageModel.getGridBagFormContainer().add(pageModel.getUserName(), pageModel.getGridBagConstraint());
		pageModel.setUserNameTextField(  new JTextField() );
		pageModel.getUserNameTextField().setFont(new Font("Montserrat", Font.CENTER_BASELINE, 14));
		pageModel.getUserNameTextField().setBackground( new Color(242, 234, 237) ); // 		pageMoround(new Color(242, 234, 237));
		pageModel.getGridBagConstraint().insets = new Insets(30,0,0,0) ;
		pageModel.setFocuBorderUName( null );
		Border borderEmpty = new EmptyBorder(0, 10, 0, 0) ;

		pageModel.setBorderLeft( BorderFactory.createCompoundBorder( borderCustom, borderEmpty) );
		
		Border compound0 = BorderFactory.createCompoundBorder( pageModel.getFocuBorderUName(), pageModel.getBorderLeft());
		pageModel.getUserNameTextField().setBorder(compound0) ; 
		//pageModel.getUserNameTextField().setBorder(new EmptyBorder(0,10,0,0)) ; // supress the borders
		pageModel.getUserNameTextField().setPreferredSize(new Dimension( 300, 50));
		
		pageModel.getUserNameTextField().addFocusListener(pageModel.getFocusClassListener()) ;
		
	    pageModel.getGridBagFormContainer().add(pageModel.getUserNameTextField(), pageModel.getGridBagConstraint());

	    pageModel.setPasswordFocus( new JLabel(" MOT DE PASSE  ") );
		pageModel.getPasswordFocus().setFont(new Font("Montserrat", Font.CENTER_BASELINE, 14));
		pageModel.getPasswordFocus().setForeground(new Color(120,120,120)) ;
		pageModel.getGridBagConstraint().gridy = 4;
		pageModel.getGridBagConstraint().insets = new Insets(15,10,-20,0) ;
		pageModel.getGridBagConstraint().anchor = GridBagConstraints.WEST;
		pageModel.getGridBagFormContainer().add(pageModel.getPasswordFocus(), pageModel.getGridBagConstraint());
		pageModel.getPasswordFocus().setVisible(false);		
		
		pageModel.setPassword( new JLabel(" MOT DE PASSE  ") );
		pageModel.getPassword().setFocusable(false) ;
		pageModel.getPassword().setFont(new Font("Montserrat", Font.CENTER_BASELINE, 14));
		pageModel.getPassword().setForeground(new Color(120,120,120)) ;
		
		pageModel.getPassword().addMouseListener(pageModel.getMouseClassListener()) ;
		
		pageModel.getGridBagConstraint().gridy = 5;
		pageModel.getGridBagConstraint().insets = new Insets(30,12,0,0) ;
		pageModel.getGridBagFormContainer().add(pageModel.getPassword(), pageModel.getGridBagConstraint());
		pageModel.setPasswordTextField( new JPasswordField() ) ;
		pageModel.getPasswordTextField().setFont(new Font("Montserrat", Font.CENTER_BASELINE, 14));
		pageModel.getPasswordTextField().setBackground( new Color(242, 234, 237) );
		pageModel.setFocusBorder( null );
		pageModel.getGridBagConstraint().insets = new Insets(30,0,0,0) ;
		Border compound1 = BorderFactory.createCompoundBorder( pageModel.getFocusBorder(), pageModel.getBorderLeft());
		pageModel.getPasswordTextField().setBorder(compound1) ; // supress the borders
		
		pageModel.getPasswordTextField().addFocusListener(pageModel.getFocusClassListener()) ;
		
		pageModel.getPasswordTextField().setPreferredSize(new Dimension( 300, 50));
	    pageModel.getGridBagFormContainer().add(pageModel.getPasswordTextField(), pageModel.getGridBagConstraint());
		
		pageModel.setLoginButton( new JButton("Se Connecter") );
		pageModel.getLoginButton().addMouseListener(pageModel.getMouseClassListener());
		pageModel.getLoginButton().addActionListener(pageModel.getClickClassListener()) ;
		
	 	pageModel.getLoginButton().setPreferredSize(new Dimension( 140, 40 ));
	 	pageModel.getLoginButton().setFont(new Font("Montserrat", Font.CENTER_BASELINE, 14));
	 	pageModel.getLoginButton().setForeground(Color.black);
	 	pageModel.getLoginButton().setBackground(new Color(136, 140, 70));
	 	pageModel.getGridBagConstraint().gridy = 6;
		pageModel.getGridBagConstraint().anchor = GridBagConstraints.CENTER;
		pageModel.getGridBagFormContainer().add(pageModel.getLoginButton(), pageModel.getGridBagConstraint());
		
		pageModel.getPrincipalContainer().add(pageModel.getGridBagFormContainer(), BorderLayout.CENTER);
		
	}
}
