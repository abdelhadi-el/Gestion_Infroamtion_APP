package com.provApp.gestionApp.controlleurs;

import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import org.springframework.stereotype.Component;

import com.provApp.gestionApp.views.ModifierPersonnel;

@Component
public class ModifierPersonnelMouseListener extends MouseAdapter{

	public ModifierPersonnel page ;

	@Override
	public void mouseEntered(MouseEvent e) {
		
		if ( e.getSource() == page.getPageModel().getButtonMontrer() ) {
			page.getPageModel().getButtonMontrer().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)) ;
		}
		 else if ( e.getSource() == page.getPageModel().getButtonReMontrer() ) {
				page.getPageModel().getButtonReMontrer().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)) ;
		
		 }else if ( e.getSource() == page.getPageModel().getButtonChercher() ) {
			page.getPageModel().getButtonChercher().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)) ;

		 }else if ( e.getSource() == page.getPageModel().getValiderUpdate() ) {
			page.getPageModel().getValiderUpdate().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)) ;

		}else if ( e.getSource() == page.getPageModel().getListeDeroulant() ) {
			page.getPageModel().getListeDeroulant().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)) ;

		}
		else if ( e.getSource() == page.getPageModel().getListeDeroulantFirst() ) {
			page.getPageModel().getListeDeroulantFirst().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)) ;

		}
	}
}
