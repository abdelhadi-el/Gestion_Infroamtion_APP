package com.provApp.gestionApp.controlleurs;

import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import org.springframework.stereotype.Component;

import com.provApp.gestionApp.views.RechercherPersonnel;

@Component
public class RechercherPersonnelMouseListener extends MouseAdapter {

	RechercherPersonnel page ;

	public RechercherPersonnel getPage() {
		return page;
	}

	public void setPage(RechercherPersonnel page) {
		this.page = page;
	}
	
	@Override
	public void mouseEntered(MouseEvent e) {
		
		if ( e.getSource() == page.getPageModel().getListeDeroulant() ) {
			page.getPageModel().getListeDeroulant().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)) ;
		
		}else if ( e.getSource() == page.getPageModel().getListeDeroulant1() ) {
			page.getPageModel().getListeDeroulant1().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)) ;
		
		}
		else if ( e.getSource() == page.getPageModel().getRechInfo() ) {
			page.getPageModel().getRechInfo().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)) ;
		
		}else if ( e.getSource() == page.getPageModel().getRechAllInfo() ) {
			page.getPageModel().getRechAllInfo().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)) ;

		}else if ( e.getSource() == page.getPageModel().getRechInfoDesignation() ) {
			page.getPageModel().getRechInfoDesignation().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)) ;

		}else if ( e.getSource() == page.getPageModel().getRechInfodivision() ) {
			page.getPageModel().getRechInfodivision() .setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)) ;

		}else if ( e.getSource() == page.getPageModel().getSupprimer()  ) {
			page.getPageModel().getSupprimer().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)) ;

		} 
		
		}

	
}
