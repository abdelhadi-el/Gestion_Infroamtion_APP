package com.provApp.gestionApp.controlleurs;

import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import org.springframework.stereotype.Component;

import com.provApp.gestionApp.views.InformationCherche;

@Component
public class InformationChercheMouseListener extends MouseAdapter {
	
	public InformationCherche page ;
	 
	@Override
	public void mouseEntered(MouseEvent e) {
		
		if ( e.getSource() == page.getPageModel().getListeDeroulant() ) {
			page.getPageModel().getListeDeroulant().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)) ;
		
		} else if ( e.getSource() == page.getPageModel().getRechInfo() ) {
			page.getPageModel().getRechInfo().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)) ;
		
		}else if ( e.getSource() == page.getPageModel().getRechAllInfo() ) {
			page.getPageModel().getRechAllInfo().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)) ;

		}else if ( e.getSource() == page.getPageModel().getDatePicker().getComponent(1) ) {
			page.getPageModel().getDatePicker().getComponent(1).setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)) ;

		}else if ( e.getSource() == page.getPageModel().getDatePicker1().getComponent(1) ) {
			page.getPageModel().getDatePicker1().getComponent(1).setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)) ;

		}else if ( e.getSource() == page.getPageModel().getRechInfoDate() ) {
			page.getPageModel().getRechInfoDate().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)) ;

		}else if ( e.getSource() == page.getPageModel().getRechInfoDesignation() ) {
			page.getPageModel().getRechInfoDesignation().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)) ;

		}else if ( e.getSource() == page.getPageModel().getRechInfodivision() ) {
			page.getPageModel().getRechInfodivision() .setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)) ;

		}else if ( e.getSource() == page.getPageModel().getSupprimer()  ) {
			page.getPageModel().getSupprimer().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)) ;

		} 
		
		}
}
