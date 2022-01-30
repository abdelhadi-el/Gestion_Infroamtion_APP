package com.provApp.gestionApp.controlleurs;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.regex.Pattern;

import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.provApp.gestionApp.models.Alert;
import com.provApp.gestionApp.views.LoginPage;
import com.provApp.gestionApp.views.RightPartOfAdminView;

import lombok.Data;

@Component @Data
public class LoginClickListener implements ActionListener {
 
	LoginPage page ;
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if ( e.getSource() == page.getPageModel().getLoginButton()  ) {
			
			page.getPageModel().getUserNameTextField().setText( page.getPageModel().getUserNameTextField().getText());
			if ( page.getPageModel().getUserNameTextField().getText().isEmpty() || page.getPageModel().getPasswordTextField().getText().isEmpty() ) {
				new Alert("Remplir d'abord les champs");
			}else { 
				Boolean boolResultUName = Pattern.matches("[a-zA-Z0-9éè./*-+àêç_ @-]*", page.getPageModel().getUserNameTextField().getText());
				Boolean boolResultPassword = Pattern.matches("[a-zA-Z0-9éè./*-+àêç_ @-]*", page.getPageModel().getPasswordTextField().getText());

				if ( boolResultUName && boolResultPassword ) {					
					ChercherPersonnel initialisation = page.getAppContext().getBean(ChercherPersonnel.class) ;
					try {
						Boolean resultCheckUser =  initialisation.checkUser(  page.getPageModel().getUserNameTextField().getText(), page.getPageModel().getPasswordTextField().getText(), page.getPageModel().getListeDeroulant().getSelectedIndex() ) ;
						if ( resultCheckUser && ( page.getPageModel().getListeDeroulant().getSelectedIndex() == 0 ) ) {
							page.getHomePage().getSetInfo().setEnabled(true) ;
							page.getHomePage().getRechInfo().setEnabled(true) ;
							page.getHomePage().getAddInfo().setEnabled(true) ;
							page.getHomePage().getSortir().setVisible(false);
							page.getHomePage().getSeDeconnecter().setVisible(true);
							JLabel uNameBienvenue = new JLabel( page.getPageModel().getUserNameTextField().getText().toUpperCase() ) ;
							uNameBienvenue.setForeground(new Color(255, 255, 255));
							uNameBienvenue.setFont(new Font("Montserrat", Font.BOLD, 20));
							page.getHomePage().getFlowText().add( uNameBienvenue );
							page.getHomePage().getFlowText().setBorder(new EmptyBorder(0,0,25,0));
							page.getHomePage().setAdminRightPartExists(true) ;

							page.getHomePage().getRechInfo().doClick();
							
							ApplicationContext contextRoot = page.getAppContext() ; // we can try to use app field in the homePage class
							RightPartOfAdminView window = page.getAppContext().getBean(RightPartOfAdminView.class) ;
							window.setAppContext(contextRoot);
							window.setHomePp(page.getHomePage()) ;
							
							page.getHomePage().setRighViewAdmin( window );
							
							page.getHomePage().getFrame().getContentPane().add( page.getHomePage().getRighViewAdmin().getPageModel().getPanel_container() , BorderLayout.LINE_END) ;
							page.getHomePage().setAdminRightPartExists(true) ;
						}else if ( resultCheckUser && ( page.getPageModel().getListeDeroulant().getSelectedIndex() == 1 ) ) {
							page.getHomePage().getSetInfo().setEnabled(true) ;
							page.getHomePage().getRechInfo().setEnabled(true) ;
							page.getHomePage().getAddInfo().setEnabled(true) ;
							page.getHomePage().getSortir().setVisible(false);
							page.getHomePage().getSeDeconnecter().setVisible(true);
							JLabel uNameBienvenue = new JLabel( page.getPageModel().getUserNameTextField().getText().toUpperCase() ) ;
							uNameBienvenue.setForeground(new Color(255, 255, 255));
							uNameBienvenue.setFont(new Font("Montserrat", Font.BOLD, 20));
							page.getHomePage().getFlowText().add( uNameBienvenue );
							page.getHomePage().getFlowText().setBorder(new EmptyBorder(0,0,25,0));
							page.getHomePage().getRechInfo().doClick();
							page.getHomePage().getContainerP().validate(); // just added

						}else {
							new Alert("Erreur : Aucun utilisateur avec ces cordonnées") ;
						}
						
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}else {
					new Alert("Erreur : caractère saisi non pris en charge") ;
				}
			}
		}
	}

}
