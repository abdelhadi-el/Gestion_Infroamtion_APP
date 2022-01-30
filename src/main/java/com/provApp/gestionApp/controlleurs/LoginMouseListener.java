package com.provApp.gestionApp.controlleurs;

import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import org.springframework.stereotype.Component;

import com.provApp.gestionApp.views.LoginPage;

@Component
public class LoginMouseListener extends MouseAdapter{

	LoginPage page ;
	
	public LoginPage getPage() {
		return page;
	}

	public void setPage(LoginPage page) {
		this.page = page;
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
		if ( e.getSource() == page.getPageModel().getPassword() ) {
			page.getPageModel().getPassword().setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR)) ;
		}else if ( e.getSource() == page.getPageModel().getUserName() ) {
			page.getPageModel().getUserName().setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR)) ;
		}
		else if ( e.getSource() == page.getPageModel().getListeDeroulant() ) {
			 page.getPageModel().getListeDeroulant().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)) ;

		}	
		else if ( e.getSource() == page.getPageModel().getLoginButton() ) {
			 page.getPageModel().getLoginButton().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)) ;
		}

	}
	
	@Override
	public void mousePressed(MouseEvent e) 
	{
		if ( e.getSource() == page.getPageModel().getUserName() ) {
			getPage().getPageModel().getUserNameTextField().requestFocus();
		}else if ( e.getSource() == page.getPageModel().getPassword() ) {
			getPage().getPageModel().getPasswordTextField().requestFocus();
		}else if ( e.getSource() == page.getPageModel().getGridBagFormContainer() ) {
			getPage().getPageModel().getGridBagFormContainer().requestFocus();
		}else if ( e.getSource() == page.getPageModel().getGridBagImageContainer() ) {
			getPage().getPageModel().getGridBagImageContainer().requestFocus();
		}
		
	}
	
}
