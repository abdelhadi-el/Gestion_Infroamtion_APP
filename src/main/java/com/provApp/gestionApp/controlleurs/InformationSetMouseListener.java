package com.provApp.gestionApp.controlleurs;

import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import org.springframework.stereotype.Component;

import com.provApp.gestionApp.views.InformationSet;

@Component
public class InformationSetMouseListener extends MouseAdapter{

	public InformationSet page ;

	@Override
	public void mouseEntered(MouseEvent e) {
		
		if ( e.getSource() == page.getPageModel().getButtonMontrer() ) {
			page.getPageModel().getButtonMontrer().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)) ;
		}
		 else if ( e.getSource() == page.getPageModel().getButtonReMontrer() ) {
				page.getPageModel().getButtonReMontrer().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)) ;
		
		 }else if ( e.getSource() == page.getPageModel().getButtonChercher() ) {
			page.getPageModel().getButtonChercher().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)) ;

		 }else if ( e.getSource() == page.getPageModel().getDatePickerForResult().getComponent(1) ) {
				page.getPageModel().getDatePickerForResult().getComponent(1).setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)) ;

		}else if ( e.getSource() == page.getPageModel().getValiderUpdate() ) {
			page.getPageModel().getValiderUpdate().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)) ;

		}else if ( e.getSource() == page.getPageModel().getDatePicker().getComponent(1) ) {
			page.getPageModel().getDatePicker().getComponent(1).setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)) ;

		}
	}
}
