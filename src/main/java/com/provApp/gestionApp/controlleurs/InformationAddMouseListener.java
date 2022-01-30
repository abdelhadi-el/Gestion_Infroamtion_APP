package com.provApp.gestionApp.controlleurs;

import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import org.springframework.stereotype.Component;

import com.provApp.gestionApp.views.InformationAdd;

@Component
public class InformationAddMouseListener extends MouseAdapter {
	
	public InformationAdd page ;
	
	@Override
	public void mouseEntered(MouseEvent e) {
		
		if ( e.getSource() == page.getModelPage().getDatePicker().getComponent(1) ) {
			page.getModelPage().getDatePicker().getComponent(1).setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)) ;
		} else if (  e.getSource() == page.getModelPage().getCommitButton() ) {
			page.getModelPage().getCommitButton().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)) ;

		}
		}
}
