package com.provApp.gestionApp.controlleurs;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.BorderFactory;
import javax.swing.border.Border;

import org.springframework.stereotype.Component;

import com.provApp.gestionApp.views.LoginPage;

@Component
public class LoginFocusListener implements FocusListener {

	LoginPage page ;
	 
	public LoginPage getPage() {
		return page;
	}

	public void setPage(LoginPage page) {
		this.page = page;
	}

	
	@Override
	public void focusGained(FocusEvent e) {
		if ( e.getSource() == page.getPageModel().getPasswordTextField() ) {
			page.getPageModel().setFocusBorder( null ) ;
			Border compound = BorderFactory.createCompoundBorder( page.getPageModel().getFocusBorder(), page.getPageModel().getBorderLeft() );
			page.getPageModel().getPasswordTextField().setBorder(compound);
			
			page.getPageModel().getPassword().setVisible(false);
			page.getPageModel().getPasswordFocus().setVisible(true);			


		}else if ( e.getSource() == page.getPageModel().getUserNameTextField() ) {
			page.getPageModel().setFocuBorderUName( null ) ;
			Border compound = BorderFactory.createCompoundBorder( page.getPageModel().getFocuBorderUName(), page.getPageModel().getBorderLeft() );
			page.getPageModel().getUserNameTextField().setBorder(compound);
			
			page.getPageModel().getUserName().setVisible(false);			
			page.getPageModel().getUserNameFocus().setVisible(true);			
			//page.getPageModel().getUserNameTextField().setBorder(new EmptyBorder(-20, 0, 0, 0));
			//			page.getPageModel().setUserName( new JLabel(" NOM UTILISATEUR ") );
//			page.getPageModel().getUserName().addMouseListener(page.getPageModel().getMouseClassListener()); 
//			page.getPageModel().getUserName().setFont(new Font(null, Font.BOLD, 14));
//			page.getPageModel().getGridBagConstraint().gridy = 2 ;
//			page.getPageModel().getGridBagFormContainer().add( page.getPageModel().getUserName(), page.getPageModel().getGridBagConstraint()) ;
//			page.getPageModel().getGridBagFormContainer().validate();
		}else if ( e.getSource() == page.getPageModel().getListeDeroulant() ) {
System.out.println("trrrtr");
		}
	}

	@Override
	public void focusLost(FocusEvent e) {
		if ( e.getSource() == page.getPageModel().getPasswordTextField() ) {
			page.getPageModel().setFocusBorder(null ) ;
			Border compound = BorderFactory.createCompoundBorder( page.getPageModel().getFocusBorder(), page.getPageModel().getBorderLeft());
			page.getPageModel().getPasswordTextField().setBorder(compound);
			
			if ( page.getPageModel().getPasswordTextField().getText().isEmpty() ) {
				page.getPageModel().getPassword().setVisible(true);
				page.getPageModel().getPasswordFocus().setVisible(false) ;
				//page.getPageModel().getUserNameTextField().setBorder(new EmptyBorder(0, 0, 0, 0));

			}
			
		}else if ( e.getSource() == page.getPageModel().getUserNameTextField() ) {
			page.getPageModel().setFocuBorderUName( null ) ;
			Border compound = BorderFactory.createCompoundBorder( page.getPageModel().getFocuBorderUName(), page.getPageModel().getBorderLeft() );
			page.getPageModel().getUserNameTextField().setBorder(compound);
			if ( page.getPageModel().getUserNameTextField().getText().isEmpty() ) {
				page.getPageModel().getUserName().setVisible(true);
				page.getPageModel().getUserNameFocus().setVisible(false);
				//page.getPageModel().getUserNameTextField().setBorder(new EmptyBorder(0, 0, 0, 0));

			}
						

		}
			
	}

}
