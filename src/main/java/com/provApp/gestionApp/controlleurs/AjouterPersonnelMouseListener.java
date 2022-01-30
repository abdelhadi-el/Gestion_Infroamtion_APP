package com.provApp.gestionApp.controlleurs;

import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import org.springframework.stereotype.Component;

import com.provApp.gestionApp.views.AjouterPersonnel;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Component @Data @EqualsAndHashCode(callSuper=false)
public class AjouterPersonnelMouseListener extends MouseAdapter{

	AjouterPersonnel page ;
	
	@Override
	public void mouseEntered(MouseEvent e) {
		
		if (  e.getSource() == page.getModelPage().getCommitButton() ) {
			page.getModelPage().getCommitButton().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)) ;

		}else if ( e.getSource() == page.getModelPage().getListeDeroulant() ) {
			page.getModelPage().getListeDeroulant().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)) ;
		
		}
		}
}
