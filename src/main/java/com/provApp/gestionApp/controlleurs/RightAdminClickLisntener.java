package com.provApp.gestionApp.controlleurs;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.provApp.gestionApp.views.AjouterPersonnel;
import com.provApp.gestionApp.views.ModifierPersonnel;
import com.provApp.gestionApp.views.RechercherPersonnel;
import com.provApp.gestionApp.views.RightPartOfAdminView;

@Component
public class RightAdminClickLisntener implements ActionListener {
	
	public RightPartOfAdminView pageModel ;
	Boolean inLoginPage = true ;

	@Override
	public void actionPerformed(ActionEvent e) {
	
			if ( e.getSource() == pageModel.getPageModel().getRechPersonnel() ) {

				pageModel.getPageModel().getRechPersonnel().setEnabled(false);
				pageModel.getPageModel().getRechPersonnel().setForeground(new Color(255,255,255));

				if (pageModel.getPageModel().getAddPersonnel().isEnabled() == false) {
					pageModel.getPageModel().setButton2( true ) ;
				}else if ( pageModel.getPageModel().getSetPersonnel().isEnabled() == false ) {
					pageModel.getPageModel().setButton3( true ) ;
				}
				if ( pageModel.getPageModel().getButton2() || pageModel.getPageModel().getButton3() || inLoginPage || true) { //not first click
					inLoginPage = false ;
					pageModel.getHomePp().getContainerP().removeAll() ;
					pageModel.getHomePp().getFrame().repaint();
					pageModel.getHomePp().getFrame().revalidate();
					
					ApplicationContext contextRoot = pageModel.getAppContext() ; // we can try to use app field in the homePage class
					RechercherPersonnel window = pageModel.getAppContext().getBean(RechercherPersonnel.class) ;
					window.setAppContext(contextRoot);
					
					pageModel.getHomePp().getContainerP().add(	window.getPageModel().getPrincipalContainer(), BorderLayout.CENTER ) ;    //// aattention variable window.prin..... !!!!!!!! ????
					pageModel.getHomePp().getContainerP().setPreferredSize(new Dimension(865,960));
					pageModel.getHomePp().getFrame().repaint();
					pageModel.getHomePp().getFrame().revalidate();
					pageModel.getPageModel().getAddPersonnel().setEnabled(true) ; pageModel.getPageModel().getSetPersonnel().setEnabled(true) ;
					pageModel.getHomePp().getRechInfo().setEnabled(true) ; pageModel.getHomePp().getAddInfo().setEnabled(true) ; pageModel.getHomePp().getSetInfo().setEnabled(true) ;
				}
			
			}else if ( e.getSource() == pageModel.getPageModel().getAddPersonnel() ) {

				pageModel.getPageModel().getAddPersonnel().setForeground(new Color(255,255,255));
				pageModel.getPageModel().getAddPersonnel().setEnabled(false);
				if ( pageModel.getPageModel().getRechPersonnel().isEnabled() == false) {
					pageModel.getPageModel().setButton1( true );
				}else if (pageModel.getPageModel().getSetPersonnel().isEnabled() == false) {
					pageModel.getPageModel().setButton3( true ) ;
				}
				
				if ( pageModel.getPageModel().getButton1() || pageModel.getPageModel().getButton3() || inLoginPage  || true) { //not first click
					inLoginPage = false ;
					pageModel.getHomePp().getContainerP().removeAll() ;
					pageModel.getHomePp().getFrame().repaint();
					pageModel.getHomePp().getFrame().revalidate();
					
					ApplicationContext contextRoot = pageModel.getAppContext() ; // we can try to use app field in the homePage class
					AjouterPersonnel window = pageModel.getAppContext().getBean(AjouterPersonnel.class) ;
					window.setAppContext(contextRoot);
					
					pageModel.getHomePp().getContainerP().add(	window.getModelPage().getPrincipalContainer() , BorderLayout.CENTER ) ; /// aattention !!!!! ???
					pageModel.getHomePp().getContainerP().setPreferredSize(new Dimension(700,550));
					pageModel.getHomePp().getFrame().repaint();
					pageModel.getHomePp().getFrame().revalidate();
					pageModel.getPageModel().getRechPersonnel().setEnabled(true) ; pageModel.getPageModel().getSetPersonnel().setEnabled(true) ;
					pageModel.getHomePp().getRechInfo().setEnabled(true) ; pageModel.getHomePp().getAddInfo().setEnabled(true) ; pageModel.getHomePp().getSetInfo().setEnabled(true) ;
				}
			
			}else if (  e.getSource() == pageModel.getPageModel().getSetPersonnel() ) {

				pageModel.getPageModel().getSetPersonnel().setForeground(new Color(255,255,255));
				pageModel.getPageModel().getSetPersonnel().setEnabled(false);
				if ( pageModel.getPageModel().getRechPersonnel().isEnabled() == false ) {
					pageModel.getPageModel().setButton1( true );
				}else if ( pageModel.getPageModel().getAddPersonnel().isEnabled() == false ) {
					pageModel.getPageModel().setButton2( true );
				}
				
				if ( pageModel.getPageModel().getButton1() || pageModel.getPageModel().getButton2() || inLoginPage || true ) { //not first click
					inLoginPage = false ;
					pageModel.getHomePp().getContainerP().removeAll() ;
					pageModel.getHomePp().getFrame().repaint();
					pageModel.getHomePp().getFrame().revalidate();
					
					ApplicationContext contextRoot = pageModel.getAppContext() ; // we can try to use app field in the homePage class
					ModifierPersonnel window = pageModel.getAppContext().getBean(ModifierPersonnel.class) ;
					window.setAppContext(contextRoot);
					
					pageModel.getHomePp().getContainerP().add(	window.getPageModel().getPrincipalContainer(), BorderLayout.CENTER ) ; /// ????? !!!!!!!!!!
					pageModel.getHomePp().getContainerP().setPreferredSize(new Dimension(900,750));
					pageModel.getHomePp().getFrame().repaint();
					pageModel.getHomePp().getFrame().revalidate();
					pageModel.getPageModel().getRechPersonnel().setEnabled(true) ; pageModel.getPageModel().getAddPersonnel().setEnabled(true) ;
					pageModel.getHomePp().getRechInfo().setEnabled(true) ; pageModel.getHomePp().getAddInfo().setEnabled(true) ; pageModel.getHomePp().getSetInfo().setEnabled(true) ;
				}

			}
		}
		

}
